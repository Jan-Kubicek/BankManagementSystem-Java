package org.example.GUI;

import javax.swing.*;
import java.awt.*;

public class CreateTransaction extends JFrame {
    //Komponents
    JPanel pnlWest, pnlEast, pnlCenter, pnlRow1, pnlRow2, pnlRow3;
    JLabel lbIncomeAccount, lbAmountOfMoney;
    JTextField tfAccount, tfMoney;
    JButton btnControl, btnSubmit, btnExit;
    //Konstructor
    public CreateTransaction(){
        InitGUI();
        setTitle("Creating new Transaction");
        setSize(640,480);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    //GUI
    public void InitGUI(){
        //West
        pnlWest = new JPanel();
            pnlWest.setBackground(Color.getColor("",ColorPalette.getSidePannels()));
        add(pnlWest, BorderLayout.WEST);
        //East
        pnlEast = new JPanel();
            pnlEast.setBackground(Color.getColor("",ColorPalette.getSidePannels()));
        add(pnlEast,BorderLayout.EAST);
        //Center
        pnlCenter = new JPanel(new GridLayout(3,1));
            pnlRow1 = new JPanel(new GridLayout(1,3));
                lbIncomeAccount = new JLabel("Income Account"); pnlRow1.add(lbIncomeAccount);
                tfAccount = new JTextField(); pnlRow1.add(tfAccount);
                btnControl = new JButton("Control");
                btnControl.setBackground(Color.getColor("",ColorPalette.getBackGround()));
                btnControl.setForeground(Color.getColor("",ColorPalette.getForeGround()));
                btnControl.addActionListener(e -> {
                    //TODO
                });
                pnlRow1.add(btnControl);
            pnlCenter.add(pnlRow1);
            pnlRow2 = new JPanel(new GridLayout(1,2));
                lbAmountOfMoney = new JLabel("Amount of money"); pnlRow2.add(lbAmountOfMoney);
                tfMoney = new JTextField(); pnlRow2.add(tfMoney);
            pnlCenter.add(pnlRow2);
            pnlRow3 = new JPanel( new GridLayout(1,2));
                btnSubmit = new JButton("Submit");
                btnSubmit.setBackground(Color.getColor("",ColorPalette.getBackGround()));
                btnSubmit.setForeground(Color.getColor("",ColorPalette.getForeGround()));
                btnSubmit.addActionListener(e -> {
                    //TODO
                });
                pnlRow3.add(btnSubmit);
                btnExit = new JButton("Exit");
                btnExit.setBackground(Color.getColor("",ColorPalette.getBackGround()));
                btnExit.setForeground(Color.getColor("",ColorPalette.getForeGround()));
                btnExit.addActionListener(e -> {
                    //TODO
                });
                pnlRow3.add(btnExit);
            pnlCenter.add(pnlRow3);
        add(pnlCenter,BorderLayout.CENTER);
        pack();
    }
    //Main
}
