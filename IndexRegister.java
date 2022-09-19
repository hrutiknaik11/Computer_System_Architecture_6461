package com.mycompany.mslgui;

public class IndexRegister {
    private String registerOne;
    private String registerTwo;
    private String registerThree;

    IndexRegister() {
        //TODO: Mocked for now..
        //It is in decimal value
        registerOne = "9";
        registerTwo = "3";
        registerThree = "0";
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
        return "IndexRegister{" +
                "registerOne='" + registerOne + '\'' +
                ", registerTwo='" + registerTwo + '\'' +
                ", registerThree='" + registerThree + '\'' +
                '}';
    }
}
