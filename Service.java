package com.mycompany.mslgui;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class Service {
    private List<String> mainMemory;
    public Simulator simulator;

    Service() {
        this.mainMemory = Utils.initializeMainMemory();
        this.simulator = Utils.setDefaultValuesSimulator();
    }

    /**
     * Listens the program control load button and once clicked setting the value from switches
     * to program control register.
     * @param value It's in the type of hexadecimal
     */
    public void programControlListener(String value) {
        simulator.setProgramControl(value);
    }

    /**
     * Listens the memory address register load button and once clicked setting the value from switches
     * to memory address register.
     * @param value It's in the type of hexadecimal
     */
    public void memoryAddressRegisterListener(String value) {
        simulator.setMemoryAddressRegister(value);
    }

    /**
     * Listens the memory buffer register load button and once clicked setting the value from switches
     * to memory buffer register.
     * @param value It's in the type of hexadecimal
     */
    public void memoryBufferRegisterListener(String value) {
        simulator.setMemoryBufferRegister(value);
    }

    /**
     * Listens the general purpose register zero load button and
     * once clicked setting the value from switches to general purpose register zero.
     * @param value It's in the type of hexadecimal
     */
    public void gprZeroListener(String value) {
        simulator.getGeneralPurposeRegister().setRegisterZero(value);
    }

    /**
     * Listens the general purpose register one load button and
     * once clicked setting the value from switches to general purpose register one.
     * @param value It's in the type of hexadecimal
     */
    public void gprOneListener(String value) {
        simulator.getGeneralPurposeRegister().setRegisterOne(value);
    }

    /**
     * Listens the general purpose register two load button and
     * once clicked setting the value from switches to general purpose register two.
     * @param value It's in the type of hexadecimal
     */
    public void gprTwoListener(String value) {
        simulator.getGeneralPurposeRegister().setRegisterTwo(value);
    }

    /**
     * Listens the general purpose register three load button and
     * once clicked setting the value from switches to general purpose register three.
     * @param value It's in the type of hexadecimal
     */
    public void gprThreeListener(String value) {
        simulator.getGeneralPurposeRegister().setRegisterThree(value);
    }

    /**
     * Listens the index register one load button and
     * once clicked setting the value from switches to index register one.
     * @param value It's in the type of hexadecimal
     */
    public void ixrOneListener(String value) {
        simulator.getIndexRegister().setRegisterOne(value);
    }

    /**
     * Listens the index register two load button and
     * once clicked setting the value from switches to index register two.
     * @param value It's in the type of hexadecimal
     */
    public void ixrTwoListener(String value) {
        simulator.getIndexRegister().setRegisterTwo(value);
    }

    /**
     * Listens the index register two load button and
     * once clicked setting the value from switches to index register three.
     * @param value It's in the type of hexadecimal
     */
    public void ixrThreeListener(String value) {
        simulator.getIndexRegister().setRegisterThree(value);
    }

    /**
     * Listens main load button and
     * once clicked loading the value from main memory to memory buffer register.
     */
    public void mainLoadButtonListener() {
        String memoryData = getDataFromMainMemoryByLocation(simulator.getMemoryAddressRegister());
        simulator.setMemoryBufferRegister(memoryData);
    }

    /**
     * Listens main load button and
     * once clicked loading the value from main memory to memory buffer register.
     */
    public void mainStoreButtonListener() {
        setDataInMainMemoryByLocation(simulator.getMemoryBufferRegister(),
                simulator.getMemoryAddressRegister());
    }

    /**
     * Listens main store button and
     * once clicked storing the value to main memory from memory buffer register data and
     * memory address register as a location of main memory.
     * @param memoryData Memory content to be stored in main memory
     * @param memoryLocation Memory location of main memory
     */
    private void setDataInMainMemoryByLocation(String memoryData, String memoryLocation) {
        int memoryDataInDecimal = Utils.convertHexadecimalToDecimal(memoryData);
        String memoryDataInDecimalString = Utils.convertIntegerToString(memoryDataInDecimal);
        int memoryLocationInDecimal = Utils.convertHexadecimalToDecimal(memoryLocation);
        mainMemory.add(memoryLocationInDecimal,memoryDataInDecimalString);
    }

    /**
     * Performing single step operation for the current program control value
     */
    public void singleStepListener() {
        simulator.setMemoryAddressRegister(simulator.getProgramControl());
        int programControlValueInDecimal = Utils.convertHexadecimalToDecimal(
                simulator.getProgramControl())+1;
        String programControlValueInHexadecimal = Utils.convertDecimalToHexadecimal(
                Utils.convertIntegerToString(programControlValueInDecimal));
        simulator.setProgramControl(programControlValueInHexadecimal);
        simulator.setMemoryBufferRegister(getDataFromMainMemoryByLocation(
                simulator.getMemoryAddressRegister()));
        simulator.setInstructionRegister(simulator.getMemoryBufferRegister());

        decodeOpcode(simulator.getInstructionRegister());
        performOperations();
    }

    public void readInputFile(String inputFilePath) {
        try {
            File inputFile = new File(inputFilePath);
            Scanner myReader = new Scanner(inputFile);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                readDataFromFile(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void runListener() {

    }

    private void readDataFromFile(String data) {
        String memoryLocation = data.substring(0,4);
        String memoryData = data.substring(5,9);
        System.out.println(memoryData + " " + memoryLocation);
        setDataInMainMemoryByLocation(memoryData, memoryLocation);
    }

    private String getDataFromMainMemoryByLocation(String value) {
        int memoryLocation = Utils.convertHexadecimalToDecimal(value);
        return Utils.convertDecimalToHexadecimal(mainMemory.get(memoryLocation));
    }

    private void decodeOpcode(String value) {
        String binaryValue = Utils.convertHexadecimalToBinary(value);
        assignOpcodeValue(binaryValue);
    }

    private void assignOpcodeValue(String value) {
        Opcode opcode = simulator.getOpcode();
        opcode.setOperations(value.substring(0,6));
        opcode.setGeneralPurposeRegister(value.substring(6,8));
        opcode.setIndexRegister(value.substring(8,10));
        opcode.setIndirectMode(value.substring(10,11));
        opcode.setAddress(value.substring(11,16));
        simulator.setOpcode(opcode);
    }

    private void performOperations() {
        String operationsCodeInOctal = Utils.convertBinaryToOctalNumber(
                simulator.getOpcode().getOperations());
        String octalInProperForm = Utils.convertOctalToProperTwoDigitOctalNumber(operationsCodeInOctal);
        calculateEffectiveAddress();
        switch (octalInProperForm) {
            case "01":
                performLoadRegisterFromMemoryOperation();
                break;
            case "02":
                performStoreRegisterToMemoryOperation();
                break;
            case "03":
                performLoadRegisterWithAddressOperation();
                break;
            case "41":
                performLoadIndexRegisterFromMemoryOperation();
                break;
            case "42":
                performStoreIndexRegisterToMemoryOperation();
                break;
            default:
                System.out.println("Invalid operations");
        }
    }

    private void calculateEffectiveAddress() {
        if (simulator.getOpcode().getIndexRegister().equals("00")) {
            String effectiveAddressInHexadecimal = Utils.convertBinaryToHexadecimal(
                    simulator.getOpcode().getAddress());
            simulator.getOpcode().setEffectiveAddress(effectiveAddressInHexadecimal);
            return;
        }
        if (simulator.getOpcode().getIndirectMode().equals("0")) {
            calculateEffectiveAddressForFalseIndirectMode();
            return;
        }
        calculateEffectiveAddressForTrueIndirectMode();
    }

    private void calculateEffectiveAddressForFalseIndirectMode() {
        int effectiveAddressInDecimal = Utils.convertBinaryToDecimal(
                simulator.getOpcode().getAddress());
        int indexRegisterDataInDecimalInteger = Utils.convertHexadecimalToDecimal(
                getDataFromIndexRegisterByAddress());
        int calculatedEffectiveAddressInDecimal = effectiveAddressInDecimal +
                indexRegisterDataInDecimalInteger;
        String calculatedEffectiveAddressInDecimalString = Utils.convertIntegerToString(
                calculatedEffectiveAddressInDecimal);
        String calculatedEffectiveAddressInHexadecimal = Utils.convertDecimalToHexadecimal(
                calculatedEffectiveAddressInDecimalString);
        simulator.getOpcode().setEffectiveAddress(calculatedEffectiveAddressInHexadecimal);
    }

    private void calculateEffectiveAddressForTrueIndirectMode() {
        int indexRegisterDataInDecimal = Utils.convertHexadecimalToDecimal(
                getDataFromIndexRegisterByAddress());
        int addressInOpcodeInDecimalInteger = Utils.convertBinaryToDecimal(
                simulator.getOpcode().getAddress());

        String addressInOpcodeInDecimalString = Utils.convertIntegerToString(addressInOpcodeInDecimalInteger);
        String addressInOpcodeInHexadecimalString = Utils.convertDecimalToHexadecimal(addressInOpcodeInDecimalString);
        String effectiveAddressDataFromMemoryInHexadecimal = getDataFromMainMemoryByLocation(
                addressInOpcodeInHexadecimalString);
        int effectiveAddressDataFromMemoryInDecimalInteger = Utils.convertHexadecimalToDecimal(
                effectiveAddressDataFromMemoryInHexadecimal);

        int preCalculatedEffectiveAddressInDecimalInteger = indexRegisterDataInDecimal +
                effectiveAddressDataFromMemoryInDecimalInteger;
        String preCalculatedEffectiveAddressInDecimalString = Utils.convertIntegerToString(
                preCalculatedEffectiveAddressInDecimalInteger);
        String preCalculatedEffectiveAddressInHexadecimalString = Utils.convertDecimalToHexadecimal(
                preCalculatedEffectiveAddressInDecimalString);
        String calculatedEffectiveAddressInHexadecimal = getDataFromMainMemoryByLocation(
                preCalculatedEffectiveAddressInHexadecimalString);
        simulator.getOpcode().setEffectiveAddress(calculatedEffectiveAddressInHexadecimal);
    }

    private String getDataFromIndexRegisterByAddress() {
        int indexRegisterInDecimal = Utils.convertBinaryToDecimal(
                simulator.getOpcode().getIndexRegister());
        String indexRegisterDataInDecimalString;
        if (indexRegisterInDecimal == 1) {
            indexRegisterDataInDecimalString = Utils.convertDecimalToHexadecimal(
                    simulator.getIndexRegister().getRegisterOne());
        } else if (indexRegisterInDecimal == 2) {
            indexRegisterDataInDecimalString = Utils.convertDecimalToHexadecimal(
                    simulator.getIndexRegister().getRegisterTwo());
        } else {
            indexRegisterDataInDecimalString = Utils.convertDecimalToHexadecimal(
                    simulator.getIndexRegister().getRegisterThree());
        }
        return indexRegisterDataInDecimalString;
    }

    private void performLoadRegisterFromMemoryOperation() {
        String getValueFromMainMemoryInHexadecimal = getDataFromMainMemoryByLocation(
                simulator.getOpcode().getEffectiveAddress());
        loadGPRFromOpcode(getValueFromMainMemoryInHexadecimal);
    }

    private void performStoreRegisterToMemoryOperation() {
        String dataFromGPRByOpcodeInHexadecimal = getDataFromGPRByOpcode();
        setDataInMainMemoryByLocation(dataFromGPRByOpcodeInHexadecimal,
                simulator.getOpcode().getEffectiveAddress());
    }

    /**
     * Getting the data from the particular general purpose register by the opcode switch value
     * @return Hexadecimal data value of specific general purpose register
     */
    private String getDataFromGPRByOpcode() {
        String gprRegisterSelect = simulator.getOpcode().getGeneralPurposeRegister();
        GeneralPurposeRegister generalPurposeRegister = simulator.getGeneralPurposeRegister();
        if (gprRegisterSelect.equals("00")) {
            return generalPurposeRegister.getRegisterZero();
        }
        if (gprRegisterSelect.equals("01")) {
            return generalPurposeRegister.getRegisterOne();
        }
        if (gprRegisterSelect.equals("10")) {
            return generalPurposeRegister.getRegisterTwo();
        }
        return generalPurposeRegister.getRegisterThree();
    }

    /**
     * Getting the data from the particular index register by the opcode switch value
     * @return Hexadecimal data value of specific index register
     */
    private String getDataFromIXRByOpcode() {
        String ixrRegisterSelect = simulator.getOpcode().getIndexRegister();
        IndexRegister indexRegister = simulator.getIndexRegister();
        if (ixrRegisterSelect.equals("01")) {
            return indexRegister.getRegisterOne();
        }
        if (ixrRegisterSelect.equals("10")) {
            return indexRegister.getRegisterTwo();
        }
        return indexRegister.getRegisterThree();
    }

    private void performLoadRegisterWithAddressOperation() {
        loadGPRFromOpcode(simulator.getOpcode().getEffectiveAddress());
    }

    private void performLoadIndexRegisterFromMemoryOperation() {
        String getValueFromMainMemoryInHexadecimal = getDataFromMainMemoryByLocation(
                simulator.getOpcode().getEffectiveAddress());
        loadIndexRegisterFromOpcode(getValueFromMainMemoryInHexadecimal);
    }

    private void performStoreIndexRegisterToMemoryOperation() {
        System.out.println("before "+mainMemory.get(2));
        String dataFromIXRByOpcodeInHexadecimal = getDataFromIXRByOpcode();
        setDataInMainMemoryByLocation(dataFromIXRByOpcodeInHexadecimal,
                simulator.getOpcode().getEffectiveAddress());
        System.out.println("Effective address "+ simulator.getOpcode().getEffectiveAddress());
        System.out.println("after "+mainMemory.get(2));
    }

    private void loadGPRFromOpcode(String data) {
        String gprRegisterSelect = simulator.getOpcode().getGeneralPurposeRegister();
        GeneralPurposeRegister generalPurposeRegister = simulator.getGeneralPurposeRegister();
        if (gprRegisterSelect.equals("00")) {
            generalPurposeRegister.setRegisterZero(data);
            return;
        }
        if (gprRegisterSelect.equals("01")) {
            generalPurposeRegister.setRegisterOne(data);
            return;
        }
        if (gprRegisterSelect.equals("10")) {
            generalPurposeRegister.setRegisterTwo(data);
            return;
        }
        generalPurposeRegister.setRegisterThree(data);
    }

    private void loadIndexRegisterFromOpcode(String data) {
        String ixrRegisterSelect = simulator.getOpcode().getIndexRegister();
        IndexRegister indexRegister = simulator.getIndexRegister();
        if (ixrRegisterSelect.equals("01")) {
            indexRegister.setRegisterOne(data);
            return;
        }
        if (ixrRegisterSelect.equals("10")) {
            indexRegister.setRegisterTwo(data);
            return;
        }
        indexRegister.setRegisterThree(data);
    }
}
