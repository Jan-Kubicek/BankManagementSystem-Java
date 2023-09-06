package org.example.GUI;

import javax.swing.*;
import java.awt.*;


public class CustomerLoginSide extends JFrame {
    //Komponenty
    JLabel lblNadpis, lblName, lblPassword;
    JPasswordField tfPassword;
    JTextField tfName;
    JButton btnBack, btnLogin;
    JPanel pnlCenter, pnlRows, pnlEmptyRow, pnlWest, pnlEast;
    //Konstruktor
    public CustomerLoginSide(){
        InitGUI();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(640,480);
        setTitle("Employe login side");
    }
    //GUI
    public void InitGUI(){
        pnlCenter = new JPanel(new GridLayout(3,1));
        pnlCenter.setBackground(Color.yellow);
        lblNadpis = new JLabel("Employe Login"); pnlCenter.add(lblNadpis);
        pnlRows = new JPanel(new GridLayout(3,2));
        lblName = new JLabel("Name: "); pnlRows.add(lblName);
        tfName = new JTextField(); pnlRows.add(tfName);
        lblPassword = new JLabel("Password: "); pnlRows.add(lblPassword);
        tfPassword = new JPasswordField(); pnlRows.add(tfPassword);
        btnBack = new JButton("Back"); pnlRows.add(btnBack);
        btnBack.setBackground(Color.darkGray);
        btnBack.setForeground(Color.white);
        btnBack.addActionListener(e -> {
            //TODO
        });
        btnLogin = new JButton("Login"); pnlRows.add(btnLogin);
        btnLogin.setBackground(Color.darkGray);
        btnLogin.setForeground(Color.white);
        btnLogin.addActionListener(e -> {
            //TODO
        });
        pnlRows.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
        pnlRows.setBackground(Color.gray);
        pnlCenter.add(pnlRows);
        pnlEmptyRow = new JPanel(); pnlEmptyRow.setBackground(Color.yellow); pnlCenter.add(pnlEmptyRow);
        add(pnlCenter,BorderLayout.CENTER);
        pnlEast = new JPanel(); pnlEast.setBackground(Color.yellow); add(pnlEast,BorderLayout.EAST);
        pnlWest = new JPanel(); pnlWest.setBackground(Color.yellow); add(pnlWest,BorderLayout.WEST);
        pack();
    }
    //Main
    public static void main(String[] args){
        new CustomerLoginSide().setVisible(true);
    }
}
