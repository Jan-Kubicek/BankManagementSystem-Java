package org.example.GUI;

import javax.swing.*;
import java.awt.*;

public class CreateUsersAccount extends JFrame {
    //Komponents
    JLabel lbFirstName, lbLastName, lbDegree, lbEmail, lbTel, lbSex, lbDateOfBirth, lbDarkM, lbYes, lbNo, lbPin, lbPassword;
    JButton btnExit, btnCreate;
    JTextField tfFirstName, tfLastName, tfDegree, tfEmail, tfTelephone, tfSex, tfPin, tfPassword, tfDateOfBirth;
    JRadioButton rbtnYes, rbtnNo;
    JPanel pnlWest, pnlEast, pnlCenter, pnlSouth, pnlRow1, pnlRow2, pnlRow3, pnlRow4, pnlRow5, pnlRow6, pnlRow7;

    //Konstructor
    public CreateUsersAccount(){
        InitGUI();
        setSize(640,480);
        setTitle("Creating Users Account");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
    //GUI
    public void InitGUI(){
        //West
        pnlWest = new JPanel();
        pnlWest.setBackground(Color.getColor("",ColorPalette.getSidePannels()));
        add(pnlWest,BorderLayout.WEST);

        //East
        pnlEast = new JPanel();
        pnlEast.setBackground(Color.getColor("",ColorPalette.getSidePannels()));
        add(pnlEast,BorderLayout.EAST);

        //South
        pnlSouth = new JPanel();
            pnlRow7 = new JPanel(new GridLayout(1,2));
                btnCreate = new JButton("Create Account");
                btnCreate.setBackground(Color.getColor("",ColorPalette.getBackGround()));
                btnCreate.setForeground(Color.getColor("",ColorPalette.getForeGround()));
                btnCreate.addActionListener(e -> {
                    //TODO
                });pnlRow7.add(btnCreate);
                btnExit = new JButton("Exit");
                btnExit.setBackground(Color.getColor("",ColorPalette.getBackGround()));
                btnExit.setForeground(Color.getColor("",ColorPalette.getForeGround()));
                btnExit.addActionListener(e -> {
                    //TODO
                });pnlRow7.add(btnExit);
            pnlSouth.add(pnlRow7);
        add(pnlSouth,BorderLayout.SOUTH);

        //Center
        pnlCenter = new JPanel(new GridLayout(6,1));
            pnlRow1 = new JPanel(new GridLayout(1,4));
                lbFirstName  = new JLabel("First name"); pnlRow1.add(lbFirstName);
                tfFirstName = new JTextField(); pnlRow1.add(tfFirstName);
                lbLastName = new JLabel("Last name"); pnlRow1.add(lbLastName);
                tfLastName = new JTextField(); pnlRow1.add(tfLastName);
            pnlCenter.add(pnlRow1);
            pnlRow2 = new JPanel(new GridLayout(1,4));
                lbDegree = new JLabel("Degree"); pnlRow2.add(lbDegree);
                tfDegree = new JTextField(); pnlRow2.add(tfDegree);
                lbSex = new JLabel("Sex"); pnlRow2.add(lbSex);
                tfSex = new JTextField(); pnlRow2.add(tfSex);
            pnlCenter.add(pnlRow2);
            pnlRow3 = new JPanel(new GridLayout(1,4));

            pnlCenter.add(pnlRow3);
        add(pnlCenter,BorderLayout.CENTER);

        pack();
    }
    //Main
    public static void main(String[] args){
        new CreateUsersAccount().setVisible(true);
    }
}
