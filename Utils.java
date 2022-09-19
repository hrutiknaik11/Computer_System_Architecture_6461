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
        mainMemory.add(4,"14");
        mainMemory.add(5,"15");
        mainMemory.add(6,"16");
        mainMemory.add(7,"17");
        mainMemory.add(8,"18");
        mainMemory.add(9,"19");
        mainMemory.add(10,"20");
        return mainMemory;
    }

    public static int convertHexadecimalToDecimal(String value) {
        return Integer.parseInt(value,16);
    }

    public static String convertDecimalToHexadecimal(String value) {
        return Integer.toHexString(convertStringToInteger(value));
    }

    public static int convertStringToInteger(String value) {
        return Integer.parseInt(value);
    }

    public static String convertIntegerToString(int value) {
        return String.valueOf(value);
    }

    public static String convertHexadecimalNumberInFourDigits(String value) {
        return ("0000" + value).substring(value.length());
    }

    public static String convertHexadecimalToBinary(String value) {
        String binaryString = Integer.toBinaryString(convertHexadecimalToDecimal(value));
        return ("0000000000000000" + binaryString).substring(binaryString.length());
    }

    public static String convertBinaryToOctalNumber(String value) {
        return Integer.toOctalString(convertHexadecimalToDecimal(value));
    }

    public static int convertBinaryToDecimal(String value) {
        return Integer.parseInt(value,2);
    }

    public static String convertBinaryToHexadecimal(String value) {
        int decimal = convertBinaryToDecimal(value);
        String decimalString = convertIntegerToString(decimal);
        return convertDecimalToHexadecimal(decimalString);
    }
}
