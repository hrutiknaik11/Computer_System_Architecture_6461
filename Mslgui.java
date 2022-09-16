package com.mycompany.mslgui;

/**
 *
 * @author hrutu
 */

import java.awt.Color;
import javax.swing.*;  
public class Mslgui extends JFrame{//inheriting JFrame  
JFrame f;  
Mslgui(){  
JButton loadright1=new JButton("LOAD");//create button  
JButton loadright2=new JButton("LOAD");
JButton loadright3=new JButton("LOAD");

JButton loadleft1=new JButton("LOAD");
JButton loadleft2=new JButton("LOAD");
JButton loadleft3=new JButton("LOAD");
JButton loadleft4=new JButton("LOAD");
JButton loadleft5=new JButton("LOAD");
JButton loadleft6=new JButton("LOAD");
JButton loadleft7=new JButton("LOAD");

JButton store=new JButton("STORE");
JButton storeplus=new JButton("STORE +");
JButton loaddown=new JButton("LOAD");
JButton init=new JButton("INIT");


JButton ss=new JButton("SS");
JButton run=new JButton("RUN");

loadright1.setBounds(1400,80,100, 40);  
loadright2.setBounds(1400,150,100, 40);
loadright3.setBounds(1400,220,100, 40);

loadleft1.setBounds(565,80,100, 40);
loadleft2.setBounds(565,150,100, 40);
loadleft3.setBounds(565,220,100, 40);
loadleft4.setBounds(565,290,100, 40);
loadleft5.setBounds(565,420,100, 40);
loadleft6.setBounds(565,490,100, 40);
loadleft7.setBounds(565,560,100, 40);

store.setBounds(900,560,100,40);
storeplus.setBounds(1050,560,100,40);
loaddown.setBounds(1200,560,100,40);
init.setBounds(1350,560,100,40);
init.setBackground(Color.red);
init.setForeground(Color.white);



ss.setBounds(1210,650,50,100);
run.setBounds(1270,650,60,100);

add(loadright1);//adding button on frame 
add(loadright2);
add(loadright3);

add(loadleft1);
add(loadleft2);
add(loadleft3);
add(loadleft4);
add(loadleft5);
add(loadleft6);
add(loadleft7);

add(store);
add(storeplus);
add(loaddown);
add(init);


add(ss);
add(run);

JTextField bigbox= new JTextField();

JTextField righttf1= new JTextField();
JTextField righttf2= new JTextField();
JTextField righttf3= new JTextField();
JTextField righttf4= new JTextField();
JTextField righttf5= new JTextField();
JTextField righttf6= new JTextField();

JTextField lefttf1= new JTextField();
JTextField lefttf2= new JTextField();
JTextField lefttf3= new JTextField();
JTextField lefttf4= new JTextField();
JTextField lefttf5= new JTextField();
JTextField lefttf6= new JTextField();
JTextField lefttf7= new JTextField();

JTextField halt2= new JTextField();
JTextField run2= new JTextField();

righttf1.setBounds(935,80,400,40);
righttf2.setBounds(935,150,400,40);
righttf3.setBounds(935,220,400,40);
righttf4.setBounds(935,290,400,40);
righttf5.setBounds(935,360,400,40);
righttf6.setBounds(935,430,400,40);

lefttf1.setBounds(100,80,400,40);
lefttf2.setBounds(100,150,400,40);
lefttf3.setBounds(100,220,400,40);
lefttf4.setBounds(100,290,400,40);
lefttf5.setBounds(100,420,400,40);
lefttf6.setBounds(100,490,400,40);
lefttf7.setBounds(100,560,400,40);

halt2.setBounds(1450,650,75,40);
run2.setBounds(1450,710,75,40);

bigbox.setBounds(50,675,1100,50);

add(bigbox);
add(righttf1);
add(righttf2);
add(righttf3);
add(righttf4);
add(righttf5);
add(righttf6);

add(lefttf1);
add(lefttf2);
add(lefttf3);
add(lefttf4);
add(lefttf5);
add(lefttf6);
add(lefttf7);

add(halt2);
add(run2);

JLabel gpr0 = new JLabel("GPR  0");
JLabel gpr1 = new JLabel("GPR  1");
JLabel gpr2 = new JLabel("GPR  2");
JLabel gpr3 = new JLabel("GPR  3");

JLabel ixr1 = new JLabel("IXR  1");
JLabel ixr2 = new JLabel("IXR  2");
JLabel ixr3 = new JLabel("IXR  3");

JLabel pc = new JLabel("PC");
JLabel mar = new JLabel("MAR");
JLabel mbr = new JLabel("MBR");
JLabel ir = new JLabel("IR");
JLabel mfr = new JLabel("MFR");
JLabel priv = new JLabel("PRIVILEGED");

JLabel operations = new JLabel("OPERATIONS");
JLabel gprdown = new JLabel("GPR");
JLabel ixrdown = new JLabel("IXR");
JLabel i = new JLabel("I");
JLabel address= new JLabel("ADDRESS");

JLabel halt=  new JLabel("HALT");
JLabel run1= new JLabel("RUN");

gpr0.setBounds(30,80,200,40);
gpr1.setBounds(30,150,200,40);
gpr2.setBounds(30,220,200,40);
gpr3.setBounds(30,290,200,40);

ixr1.setBounds(30,420,200,40);
ixr2.setBounds(30,490,200,40);
ixr3.setBounds(30,560,200,40);

pc.setBounds(850,80,200,40);
mar.setBounds(850,150,200,40);
mbr.setBounds(850,220,200,40);
ir.setBounds(850,290,200,40);
mfr.setBounds(850,360,200,40);
priv.setBounds(850,430,200,40);

operations.setBounds(170,750,200,40);
gprdown.setBounds(490,750,200,40);
ixrdown.setBounds(650,750,200,40);

i.setBounds(792,750,200,40);

address.setBounds(990,750,200,40);

halt.setBounds(1375,650,200,40);
run1.setBounds(1375,710,200,40);

add(gpr0);
add(gpr1);
add(gpr2);
add(gpr3);

add(ixr1);
add(ixr2);
add(ixr3);

add(pc);
add(mar);
add(mbr);
add(ir);
add(mfr);
add(priv);

add(operations);
add(gprdown);
add(ixrdown);
add(i);

add(address);

add(halt);
add(run1);

setSize(300,400);  
setLayout(null);  
setVisible(true); 


}  


public static void main(String[] args) {  
new Mslgui();  
}}  
