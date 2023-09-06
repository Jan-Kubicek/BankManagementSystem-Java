package org.example.GUI;

import javax.swing.*;
import java.awt.*;

public class EmployeLoginSide extends JFrame {
    //Komponenty
    JLabel lblNadpis, lblName, lblPassword, lblBranch;
    JPasswordField tfPassword;
    JTextField tfName;
    JButton btnBack, btnLogin;
    JPanel pnlCenter, pnlRows, pnlEmptyRow, pnlWest, pnlEast;
    //Konstruktor
    public EmployeLoginSide(){
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
            pnlRows = new JPanel(new GridLayout(4,2));
                lblName = new JLabel("Name: "); pnlRows.add(lblName);
                tfName = new JTextField(); pnlRows.add(tfName);
                lblPassword = new JLabel("Password: "); pnlRows.add(lblPassword);
                tfPassword = new JPasswordField(); pnlRows.add(tfPassword);
                lblBranch = new JLabel("Branche: "); pnlRows.add(lblBranch);
                Choice branches = new Choice();
                //TODO set branches for selecting
                pnlRows.add(branches);
                btnBack = new JButton("Back"); pnlRows.add(btnBack);
                btnBack.addActionListener(e -> {
                    //TODO
                });
                btnLogin = new JButton("Login"); pnlRows.add(btnLogin);
                btnLogin.addActionListener(e -> {
                    //TODO
                });
            pnlCenter.add(pnlRows);
        pnlEmptyRow = new JPanel(); pnlEmptyRow.setBackground(Color.yellow); pnlCenter.add(pnlEmptyRow);
        add(pnlCenter,BorderLayout.CENTER);
        pnlEast = new JPanel(); pnlEast.setBackground(Color.yellow); add(pnlEast,BorderLayout.EAST);
        pnlWest = new JPanel(); pnlWest.setBackground(Color.yellow); add(pnlWest,BorderLayout.WEST);
        pack();
    }
    //Main
    public static void main(String[] args){
        new EmployeLoginSide().setVisible(true);
    }
}
