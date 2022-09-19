package com.mycompany.mslgui;

import java.util.List;

public class Service {
    private List<String> mainMemory;
    public Simulator simulator;

    Service() {
        this.mainMemory = Utils.mockMainMemory();
        this.simulator = Utils.setDefaultValuesSimulator();
    }

    public void programControlListener(String value) {
        simulator.setMemoryAddressRegister(value);
        int programControlValueInDecimal = Utils.convertHexadecimalToDecimal(value)+1;
        String programControlValueInHexadecimal = Utils.convertDecimalToHexadecimal(
                Utils.convertIntegerToString(programControlValueInDecimal));
        simulator.setProgramControl(programControlValueInHexadecimal);
        simulator.setMemoryBufferRegister(getDataFromMainMemoryByLocation(
                simulator.getMemoryAddressRegister()));
        simulator.setInstructionRegister(simulator.getMemoryBufferRegister());

        //TODO: Need to test
//        decodeOpcode();
    }

    public void memoryAddressRegisterListener(String value) {
        String memoryData = getDataFromMainMemoryByLocation(value);
        simulator.setMemoryBufferRegister(memoryData);
    }

    private String getDataFromMainMemoryByLocation(String value) {
        int memoryLocation = Utils.convertHexadecimalToDecimal(value);
        return Utils.convertDecimalToHexadecimal(mainMemory.get(memoryLocation));
    }

    private void decodeOpcode() {
        String binaryValue = Utils.convertHexadecimalToBinary(simulator.getInstructionRegister());
        assignOpcodeValue(binaryValue);
        performOperations();
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
        calculateEffectiveAddress();
        switch (operationsCodeInOctal) {
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
        int indexRegisterDataInDecimal = getDataFromIndexRegisterByAddress();
        int calculatedEffectiveAddressInDecimal = effectiveAddressInDecimal +
                indexRegisterDataInDecimal;
        String calculatedEffectiveAddressInDecimalString = Utils.convertIntegerToString(
                calculatedEffectiveAddressInDecimal);
        String calculatedEffectiveAddressInHexadecimal = Utils.convertDecimalToHexadecimal(
                calculatedEffectiveAddressInDecimalString);
        simulator.getOpcode().setEffectiveAddress(calculatedEffectiveAddressInHexadecimal);
    }

    private void calculateEffectiveAddressForTrueIndirectMode() {
        int indexRegisterDataInDecimal = getDataFromIndexRegisterByAddress();
        int addressInOpcodeInDecimalInteger = Utils.convertBinaryToDecimal(
                simulator.getOpcode().getAddress());

        String addressInOpcodeInDecimalString = Utils.convertIntegerToString(addressInOpcodeInDecimalInteger);
        String effectiveAddressDataFromMemoryInHexadecimal = getDataFromMainMemoryByLocation(
                addressInOpcodeInDecimalString);
        int effectiveAddressDataFromMemoryInDecimalInteger = Utils.convertHexadecimalToDecimal(
                effectiveAddressDataFromMemoryInHexadecimal);

        int preCalculatedEffectiveAddressInDecimalInteger = indexRegisterDataInDecimal +
                effectiveAddressDataFromMemoryInDecimalInteger;
        String preCalculatedEffectiveAddressInDecimalString = Utils.convertIntegerToString(
                preCalculatedEffectiveAddressInDecimalInteger);
        String calculatedEffectiveAddressInHexadecimal = getDataFromMainMemoryByLocation(
                preCalculatedEffectiveAddressInDecimalString);
        simulator.getOpcode().setEffectiveAddress(calculatedEffectiveAddressInHexadecimal);
    }

    private int getDataFromIndexRegisterByAddress() {
        int indexRegisterInDecimal = Utils.convertBinaryToDecimal(
                simulator.getOpcode().getIndexRegister());
        String indexRegisterDataInDecimalString;
        if (indexRegisterInDecimal == 1) {
            indexRegisterDataInDecimalString = simulator.getIndexRegister().getRegisterOne();
        } else if (indexRegisterInDecimal == 2) {
            indexRegisterDataInDecimalString = simulator.getIndexRegister().getRegisterTwo();
        } else {
            indexRegisterDataInDecimalString = simulator.getIndexRegister().getRegisterThree();
        }
        return Utils.convertStringToInteger(indexRegisterDataInDecimalString);
    }

    private void performLoadRegisterFromMemoryOperation() {

    }

    private void performStoreRegisterToMemoryOperation() {

    }

    private void performLoadRegisterWithAddressOperation() {

    }

    private void performLoadIndexRegisterFromMemoryOperation() {

    }

    private void performStoreIndexRegisterToMemoryOperation() {

    }
}
