package com.mycompany.mslgui;

import java.util.ArrayList;
import java.util.List;

public class Utils {
    public static Simulator setDefaultValuesSimulator() {
        Simulator simulator = new Simulator();
        return simulator;
    }

    public static List<String> mockMainMemory() {
        List<String> mainMemory = new ArrayList<>();
        mainMemory.add(0,"11");
        mainMemory.add(1,"12");
        mainMemory.add(2,"13");
        mainMemory.add(3,"14");
        return mainMemory;
    }

    public static int convertHexadecimalToDecimal(String value) {
        //TODO: Vaidate parsing

        return Integer.parseInt(value,16);
    }

    public static int convertStringToInteger(String value) {

          //TODO: Validate parsing
//        if (value == null || value.isBlank() || value.isEmpty()) {
//            value = "";
//        }

        return Integer.parseInt(value);
    }
}
