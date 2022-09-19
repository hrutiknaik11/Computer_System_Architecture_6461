package com.mycompany.mslgui;

public class Opcode {
    private String operations;
    private String generalPurposeRegister;
    private String indexRegister;
    private String indirectMode;
    private String address;
    private String effectiveAddress;

    Opcode() {
        operations = "";
        generalPurposeRegister = "";
        indexRegister = "";
        indirectMode = "";
        address = "";
    }
    public String getOperations() {
        return operations;
    }

    public void setOperations(String operations) {
        this.operations = operations;
    }

    public String getGeneralPurposeRegister() {
        return generalPurposeRegister;
    }

    public void setGeneralPurposeRegister(String generalPurposeRegister) {
        this.generalPurposeRegister = generalPurposeRegister;
    }

    public String getIndexRegister() {
        return indexRegister;
    }

    public void setIndexRegister(String indexRegister) {
        this.indexRegister = indexRegister;
    }

    public String getIndirectMode() {
        return indirectMode;
    }

    public void setIndirectMode(String indirectMode) {
        this.indirectMode = indirectMode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEffectiveAddress() {
        return effectiveAddress;
    }

    public void setEffectiveAddress(String effectiveAddress) {
        this.effectiveAddress = Utils.convertHexadecimalNumberInFourDigits(effectiveAddress);
    }

    @Override
    public String toString() {
        return "Opcode{" +
                "operations='" + operations + '\'' +
                ", generalPurposeRegister='" + generalPurposeRegister + '\'' +
                ", indexRegister='" + indexRegister + '\'' +
                ", indirectMode='" + indirectMode + '\'' +
                ", address='" + address + '\'' +
                ", effectiveAddress='" + effectiveAddress + '\'' +
                '}';
    }
}
