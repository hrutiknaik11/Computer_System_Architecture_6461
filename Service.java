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
    }

    public void memoryAddressRegisterListener(String value) {
        String memoryData = getDataInMainMemoryByLocation(value);
        simulator.setMemoryBufferRegister(memoryData);

        //TODO: Validate Parsing
//        if (memoryData == -1) {
//            simulator.setMemoryBufferRegister("Incorrect memory location");
//            return;
//        }


    }

    private String getDataInMainMemoryByLocation(String value) {

        //TODO:Validate Parsing
//        if (value.length() != 4) {
//            return -1;
//        }

        int memoryLocation = Utils.convertHexadecimalToDecimal(value);

        //TODO: Needs Validation
        String memoryData = mainMemory.get(memoryLocation);

        return memoryData;
    }
}
