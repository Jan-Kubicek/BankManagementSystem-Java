package org.example.GUI;

import javax.swing.*;
import java.awt.*;

public class FirstFrame extends JFrame {
    //Komponenty
        JLabel lbNadpis;
        JButton btnEmploye, btnCustomer;
        JPanel pnlCenter, pnlRow, pnlEmptyRow, pnlEast, pnlWest;
    //Konstruktor
    public FirstFrame(){
        InitGUI();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Bank Management System");
        setSize(640,480);
    }
    //GUI
    public void InitGUI(){
        //Center
        pnlCenter = new JPanel(new GridLayout(7,1));
                lbNadpis = new JLabel("Welcome in Banking Management System"); pnlCenter.add(lbNadpis);
                for(int i = 0; i < 5; i ++){
                    pnlCenter.add(pnlEmptyRow = new JPanel());
                    pnlEmptyRow.setBackground(Color.getColor("",ColorPalette.getBodyPanel()));
                }
                pnlRow = new JPanel(new GridLayout(1,2));
                    btnEmploye = new JButton("Employe"); pnlRow.add(btnEmploye);
                    btnEmploye.setBackground(Color.getColor("",ColorPalette.getBackGround()));
                    btnEmploye.setForeground(Color.getColor("",ColorPalette.getForeGround()));
                    btnEmploye.addActionListener(e -> {
                        //TODO open Employe Loggin frame
                        //new EmployeLoginSide().setVisible(true);
                    });
                    btnCustomer = new JButton("Customer"); pnlRow.add(btnCustomer);
                    btnCustomer.setBackground(Color.getColor("",ColorPalette.getBackGround()));
                    btnCustomer.setForeground(Color.getColor("",ColorPalette.getForeGround()));
                    btnCustomer.addActionListener(e -> {
                        //TODO open Customer Loggin frame
                    });
                pnlCenter.add(pnlRow);
                pnlCenter.setBackground(Color.getColor("",ColorPalette.getBodyPanel()));
        add(pnlCenter,BorderLayout.CENTER);
        //East
        pnlEast = new JPanel(); pnlEast.setBackground(Color.getColor("",ColorPalette.getSidePannels()));
        add(pnlEast,BorderLayout.EAST);
        //West
        pnlWest = new JPanel(); pnlWest.setBackground(Color.getColor("",ColorPalette.getSidePannels()));
        add(pnlWest, BorderLayout.WEST);
        pack();
    }
    //Main
    public static void main(String[] args){
        new FirstFrame().setVisible(true);
    }
}
