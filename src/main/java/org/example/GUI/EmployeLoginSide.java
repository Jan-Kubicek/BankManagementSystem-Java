package org.example.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;

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
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(640,480);
        setTitle("Employe login side");
    }
    //GUI
    public void InitGUI(){
        //Center
        pnlCenter = new JPanel(new GridLayout(3,1));
            pnlCenter.setBackground(Color.getColor("",ColorPalette.getBodyPanel()));
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
                btnBack.setBackground(Color.getColor("",ColorPalette.getBackGround()));
                btnBack.setForeground(Color.getColor("",ColorPalette.getForeGround()));
                btnBack.addActionListener(e -> {
                    close();
                    new FirstFrame().setVisible(true);
                });
                btnLogin = new JButton("Login"); pnlRows.add(btnLogin);
                btnLogin.setBackground(Color.getColor("",ColorPalette.getBackGround()));
                btnLogin.setForeground(Color.getColor("",ColorPalette.getForeGround()));
                btnLogin.addActionListener(e -> {
                    //TODO
                });
            pnlRows.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
            pnlRows.setBackground(Color.getColor("",ColorPalette.getFormPanel()));
            pnlCenter.add(pnlRows);
        pnlEmptyRow = new JPanel(); pnlEmptyRow.setBackground(Color.getColor("",ColorPalette.getBodyPanel())); pnlCenter.add(pnlEmptyRow);
        add(pnlCenter,BorderLayout.CENTER);
        //East
        pnlEast = new JPanel(); pnlEast.setBackground(Color.getColor("",ColorPalette.getSidePannels())); add(pnlEast,BorderLayout.EAST);
        //West
        pnlWest = new JPanel(); pnlWest.setBackground(Color.getColor("",ColorPalette.getSidePannels())); add(pnlWest,BorderLayout.WEST);
        pack();
    }
    //Main
    public static void main(String[] args){
        new EmployeLoginSide().setVisible(true);
    }


    public void close(){
        WindowEvent closeWindow = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closeWindow);
    }
}
