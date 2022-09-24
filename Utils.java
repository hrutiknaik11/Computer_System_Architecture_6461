package com.mycompany.mslgui;

import java.util.ArrayList;
import java.util.List;

public class Utils {
    public static Simulator setDefaultValuesSimulator() {
        return new Simulator();
    }

    public static List<String> initializeMainMemory() {
        return new ArrayList<>();
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
        return Integer.toOctalString(convertBinaryToDecimal(value));
    }

    public static String convertOctalToProperTwoDigitOctalNumber(String value) {
        return ("00" + value).substring(value.length());
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
