package com.mycompany.mslgui;

/**
 * @author Tharun Ganapathi Raman
 * @author hrutu
 */

import java.awt.Color;
import javax.swing.*;  
public class Mslgui extends JFrame {

    private final Service service;
    private JButton pcLoadButton;
    private JButton marLoadButton;
    private JButton mbrLoadButton;
    private JButton gprZeroLoadButton;
    private JButton gprOneLoadButton;
    private JButton gprTwoLoadButton;
    private JButton gprThreeLoadButton;
    private JButton ixrOneLoadButton;
    private JButton ixrTwoLoadButton;
    private JButton ixrThreeLoadButton;
    private JButton storeButton;
    private JButton storePlusButton;
    private JButton mainLoadButton;
    private JButton initButton;
    private JButton singleStepButton;
    private JButton runButton;
    private JTextField opcodeTextField;
    private JTextField programControlTextField;
    private JTextField marTextField;
    private JTextField mbrTextField;
    private JTextField irTextField;
    private JTextField mfrTextField;
    private JTextField privilegedTextField;
    private JTextField gprZeroTextField;
    private JTextField gprOneTextField;
    private JTextField gprTwoTextField;
    private JTextField gprThreeTextField;
    private JTextField ixrOneTextField;
    private JTextField ixrTwoTextField;
    private JTextField ixrThreeTextField;
    private JTextField haltTextField;
    private JTextField runTextField;
    private JLabel gprZeroLabel;
    private JLabel gprOneLabel;
    private JLabel gprTwoLabel;
    private JLabel gprThreeLabel;
    private JLabel ixrOneLabel;
    private JLabel ixrTwoLabel;
    private JLabel ixrThreeLabel;
    private JLabel programControlLabel;
    private JLabel marLabel;
    private JLabel mbrLabel;
    private JLabel irLabel;
    private JLabel mfrLabel;
    private JLabel privilegedLabel;
    private JLabel operationsOpcodeLabel;
    private JLabel gprOpcodeLabel;
    private JLabel ixrOpcodeLabel;
    private JLabel indirectModeOpcodeLabel;
    private JLabel addressOpcodeLabel;
    private JLabel haltLabel;
    private JLabel runLabel;
    Mslgui() {
        this.service = new Service();
        createGUIComponents();
        applyStylesGUIComponents();
        addGUIComponentsInFrame();
        applyFrameStyle();
        updateOrSetAllTextFieldValues();
        addComponentListeners();
        System.out.println(service.simulator);
    }

    private void createGUIComponents() {
        createButtons();
        createTextFields();
        createLabels();
    }

    private void applyStylesGUIComponents() {
        applyButtonStyles();
        applyStylesTextFields();
        applyStylesLabel();
    }

    private void addGUIComponentsInFrame() {
        addButtons();
        addTextFields();
        addLabels();
    }

    private void applyFrameStyle() {
        setSize(300,400);
        setLayout(null);
        setVisible(true);
    }

    private void createButtons() {
        this.pcLoadButton = new JButton("LOAD");
        this.marLoadButton = new JButton("LOAD");
        this.mbrLoadButton = new JButton("LOAD");
        this.gprZeroLoadButton = new JButton("LOAD");
        this.gprOneLoadButton = new JButton("LOAD");
        this.gprTwoLoadButton = new JButton("LOAD");
        this.gprThreeLoadButton = new JButton("LOAD");
        this.ixrOneLoadButton = new JButton("LOAD");
        this.ixrTwoLoadButton = new JButton("LOAD");
        this.ixrThreeLoadButton = new JButton("LOAD");
        this.storeButton = new JButton("STORE");
        this.storePlusButton = new JButton("STORE +");
        this.mainLoadButton = new JButton("LOAD");
        this.initButton = new JButton("INIT");
        this.singleStepButton = new JButton("SS");
        this.runButton = new JButton("RUN");
    }

    private void applyButtonStyles() {
        this.pcLoadButton.setBounds(1300,80,100, 40);
        this.marLoadButton.setBounds(1300,150,100, 40);
        this.mbrLoadButton.setBounds(1300,220,100, 40);
        this.gprZeroLoadButton.setBounds(565,80,100, 40);
        this.gprOneLoadButton.setBounds(565,150,100, 40);
        this.gprTwoLoadButton.setBounds(565,220,100, 40);
        this.gprThreeLoadButton.setBounds(565,290,100, 40);
        this.ixrOneLoadButton.setBounds(565,420,100, 40);
        this.ixrTwoLoadButton.setBounds(565,490,100, 40);
        this.ixrThreeLoadButton.setBounds(565,560,100, 40);
        this.storeButton.setBounds(900,560,100,40);
        this.storePlusButton.setBounds(1050,560,100,40);
        this.mainLoadButton.setBounds(1200,560,100,40);
        this.initButton.setBounds(1350,560,100,40);
        this.initButton.setBackground(Color.red);
        this.initButton.setForeground(Color.white);
        this.singleStepButton.setBounds(1210,650,50,100);
        this.runButton.setBounds(1270,650,60,100);
    }

    private void addButtons() {
        add(pcLoadButton);
        add(marLoadButton);
        add(mbrLoadButton);
        add(gprZeroLoadButton);
        add(gprOneLoadButton);
        add(gprTwoLoadButton);
        add(gprThreeLoadButton);
        add(ixrOneLoadButton);
        add(ixrTwoLoadButton);
        add(ixrThreeLoadButton);
        add(storeButton);
        add(storePlusButton);
        add(mainLoadButton);
        add(initButton);
        add(singleStepButton);
        add(runButton);
    }

    private void createTextFields() {
        this.opcodeTextField = new JTextField();
        this.programControlTextField = new JTextField();
        this.marTextField = new JTextField();
        this.mbrTextField = new JTextField();
        this.irTextField = new JTextField();
        this.mfrTextField = new JTextField();
        this.privilegedTextField = new JTextField();
        this.gprZeroTextField = new JTextField();
        this.gprOneTextField = new JTextField();
        this.gprTwoTextField = new JTextField();
        this.gprThreeTextField = new JTextField();
        this.ixrOneTextField= new JTextField();
        this.ixrTwoTextField= new JTextField();
        this.ixrThreeTextField= new JTextField();
        this.haltTextField = new JTextField();
        this.runTextField = new JTextField();
    }

    private void applyStylesTextFields() {
        this.programControlTextField.setBounds(800,80,400,40);
        this.marTextField.setBounds(800,150,400,40);
        this.mbrTextField.setBounds(800,220,400,40);
        this.irTextField.setBounds(800,290,400,40);
        this.mfrTextField.setBounds(800,360,400,40);
        this.privilegedTextField.setBounds(800,430,400,40);
        this.gprZeroTextField.setBounds(100,80,400,40);
        this.gprOneTextField.setBounds(100,150,400,40);
        this.gprTwoTextField.setBounds(100,220,400,40);
        this.gprThreeTextField.setBounds(100,290,400,40);
        this.ixrOneTextField.setBounds(100,420,400,40);
        this.ixrTwoTextField.setBounds(100,490,400,40);
        this.ixrThreeTextField.setBounds(100,560,400,40);
        this.haltTextField.setBounds(1450,650,75,40);
        this.runTextField.setBounds(1450,710,75,40);
        this.opcodeTextField.setBounds(50,675,1100,50);
    }

    private void addTextFields() {
        add(opcodeTextField);
        add(programControlTextField);
        add(marTextField);
        add(mbrTextField);
        add(irTextField);
        add(mfrTextField);
        add(privilegedTextField);
        add(gprZeroTextField);
        add(gprOneTextField);
        add(gprTwoTextField);
        add(gprThreeTextField);
        add(ixrOneTextField);
        add(ixrTwoTextField);
        add(ixrThreeTextField);
        add(haltTextField);
        add(runTextField);
    }

    private void createLabels() {
        this.gprZeroLabel = new JLabel("GPR  0");
        this.gprOneLabel = new JLabel("GPR  1");
        this.gprTwoLabel = new JLabel("GPR  2");
        this.gprThreeLabel = new JLabel("GPR  3");
        this.ixrOneLabel = new JLabel("IXR  1");
        this. ixrTwoLabel = new JLabel("IXR  2");
        this.ixrThreeLabel = new JLabel("IXR  3");
        this.programControlLabel = new JLabel("PC");
        this.marLabel = new JLabel("MAR");
        this.mbrLabel = new JLabel("MBR");
        this.irLabel = new JLabel("IR");
        this.mfrLabel = new JLabel("MFR");
        this.privilegedLabel = new JLabel("PRIVILEGED");
        this.operationsOpcodeLabel = new JLabel("OPERATIONS");
        this.gprOpcodeLabel = new JLabel("GPR");
        this.ixrOpcodeLabel = new JLabel("IXR");
        this.indirectModeOpcodeLabel = new JLabel("I");
        this.addressOpcodeLabel = new JLabel("ADDRESS");
        this.haltLabel =  new JLabel("HALT");
        this.runLabel = new JLabel("RUN");
    }

    private void applyStylesLabel() {
        this.gprZeroLabel.setBounds(30,80,200,40);
        this.gprOneLabel.setBounds(30,150,200,40);
        this.gprTwoLabel.setBounds(30,220,200,40);
        this.gprThreeLabel.setBounds(30,290,200,40);
        this.ixrOneLabel.setBounds(30,420,200,40);
        this.ixrTwoLabel.setBounds(30,490,200,40);
        this.ixrThreeLabel.setBounds(30,560,200,40);
        this.programControlLabel.setBounds(700,80,200,40);
        this.marLabel.setBounds(700,150,200,40);
        this.mbrLabel.setBounds(700,220,200,40);
        this.irLabel.setBounds(700,290,200,40);
        this.mfrLabel.setBounds(700,360,200,40);
        this.privilegedLabel.setBounds(700,430,200,40);
        this. operationsOpcodeLabel.setBounds(170,750,200,40);
        this.gprOpcodeLabel.setBounds(490,750,200,40);
        this.ixrOpcodeLabel.setBounds(650,750,200,40);
        this.indirectModeOpcodeLabel.setBounds(792,750,200,40);
        this.addressOpcodeLabel.setBounds(990,750,200,40);
        this.haltLabel.setBounds(1375,650,200,40);
        this.runLabel.setBounds(1375,710,200,40);
    }

    private void addLabels() {
        add(gprZeroLabel);
        add(gprOneLabel);
        add(gprTwoLabel);
        add(gprThreeLabel);
        add(ixrOneLabel);
        add(ixrTwoLabel);
        add(ixrThreeLabel);
        add(programControlLabel);
        add(marLabel);
        add(mbrLabel);
        add(irLabel);
        add(mfrLabel);
        add(privilegedLabel);
        add(operationsOpcodeLabel);
        add(gprOpcodeLabel);
        add(ixrOpcodeLabel);
        add(indirectModeOpcodeLabel);
        add(addressOpcodeLabel);
        add(haltLabel);
        add(runLabel);
    }

    private void updateOrSetAllTextFieldValues() {
        String opcode = service.simulator.getOpcode().getOperations() + " "
                + service.simulator.getOpcode().getGeneralPurposeRegister() + " "
                + service.simulator.getOpcode().getIndexRegister() + " "
                + service.simulator.getOpcode().getIndirectMode() + " "
                + service.simulator.getOpcode().getAddress();
        setComponentValue(this.opcodeTextField, opcode);

        setComponentValue(this.programControlTextField, service.simulator.getProgramControl());
        setComponentValue(this.marTextField, service.simulator.getMemoryAddressRegister());
        setComponentValue(this.mbrTextField, service.simulator.getMemoryBufferRegister());
        setComponentValue(this.irTextField, service.simulator.getInstructionRegister());
        setComponentValue(this.mfrTextField, service.simulator.getMemoryFaultRegister());
        setComponentValue(this.privilegedTextField, service.simulator.getPrivileged());

        setComponentValue(this.gprZeroTextField,
                service.simulator.getGeneralPurposeRegister().getRegisterZero());
        setComponentValue(this.gprOneTextField,
                service.simulator.getGeneralPurposeRegister().getRegisterOne());
        setComponentValue(this.gprTwoTextField,
                service.simulator.getGeneralPurposeRegister().getRegisterTwo());
        setComponentValue(this.gprThreeTextField,
                service.simulator.getGeneralPurposeRegister().getRegisterThree());

        setComponentValue(this.ixrOneTextField,
                service.simulator.getIndexRegister().getRegisterOne());
        setComponentValue(this.ixrTwoTextField,
                service.simulator.getIndexRegister().getRegisterTwo());
        setComponentValue(this.ixrTwoTextField,
                service.simulator.getIndexRegister().getRegisterThree());

        setComponentValue(this.haltTextField, service.simulator.getHalt());
        setComponentValue(this.runTextField, service.simulator.getRun());
    }

    private void setComponentValue(JTextField textFieldComponent, String value) {
        if (value == null || value.isBlank() || value.isEmpty()) {
            value = "";
        }
        textFieldComponent.setText(value);
    }
    private void addComponentListeners() {
        pcLoadButton.addActionListener(event -> {
            String programControlValue = programControlTextField.getText();
            this.service.programControlListener(programControlValue);
            updateOrSetAllTextFieldValues();
        });

        marLoadButton.addActionListener(event -> {
            service.memoryAddressRegisterListener(marTextField.getText());
            setComponentValue(mbrTextField, service.simulator.getMemoryBufferRegister());
        });
    }
    public static void main(String[] args) {
        new Mslgui();
    }
}
