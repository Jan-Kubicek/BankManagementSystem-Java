package org.example.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import static org.example.GUI.CollectionOfUsersAccounts.*;

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
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(640,480);
        setTitle("Customer login side");
    }
    //GUI
    public void InitGUI(){
        //Center
        pnlCenter = new JPanel(new GridLayout(3,1));
        pnlCenter.setBackground(Color.getColor("",ColorPalette.getBodyPanel()));
        lblNadpis = new JLabel("Customer Login"); pnlCenter.add(lblNadpis);
        pnlRows = new JPanel(new GridLayout(3,2));
        lblName = new JLabel("Name: "); pnlRows.add(lblName);
        tfName = new JTextField(); pnlRows.add(tfName);
        lblPassword = new JLabel("Password: "); pnlRows.add(lblPassword);
        tfPassword = new JPasswordField(); pnlRows.add(tfPassword);
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
            String name = tfName.getText();
            String password = tfPassword.getText();
            String id = "";
            if(userLogin(name,password)){
                for (UserAccount collectionOfUser : collectionOfUsers) {
                    if (collectionOfUser.name.equals(name)) {
                        id = collectionOfUser.ID;
                    }
                }
                new UserSide();
                UserSide.setIdOfLoggedUser(id);
                UserSide.setNameOfUser(name);
                close();
                new UserSide().setVisible(true);
            }
            else{
                JOptionPane.showMessageDialog(this,"Wrong name or password was entered","Not logged in",JOptionPane.INFORMATION_MESSAGE);
            }
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
        new CustomerLoginSide().setVisible(true);
    }


    public void close(){
        WindowEvent closeWindow = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closeWindow);
    }
}
