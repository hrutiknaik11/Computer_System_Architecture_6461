package com.mycompany.mslgui;

import java.util.Arrays;

public class GeneralPurposeRegister {
    private String registerZero;
    private String registerOne;
    private String registerTwo;
    private String registerThree;

    GeneralPurposeRegister() {
        registerZero = "";
        registerOne = "";
        registerTwo = "";
        registerThree = "";
    }
    public String getRegisterZero() {
        return registerZero;
    }

    public void setRegisterZero(String registerZero) {
        this.registerZero = registerZero;
    }

    public String getRegisterOne() {
        return registerOne;
    }

    public void setRegisterOne(String registerOne) {
        this.registerOne = registerOne;
    }

    public String getRegisterTwo() {
        return registerTwo;
    }

    public void setRegisterTwo(String registerTwo) {
        this.registerTwo = registerTwo;
    }

    public String getRegisterThree() {
        return registerThree;
    }

    public void setRegisterThree(String registerThree) {
        this.registerThree = registerThree;
    }

    @Override
    public String toString() {
        return "GeneralPurposeRegister{" +
                "registerZero='" + registerZero + '\'' +
                ", registerOne='" + registerOne + '\'' +
                ", registerTwo='" + registerTwo + '\'' +
                ", registerThree='" + registerThree + '\'' +
                '}';
    }
}
