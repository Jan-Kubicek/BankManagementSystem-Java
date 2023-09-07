package org.example.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.time.LocalDateTime;

public class FirstFrame extends JFrame {
    //Komponenty
        JLabel lbNadpis;
        JButton btnEmploye, btnCustomer;
        JPanel pnlCenter, pnlRow, pnlEmptyRow, pnlEast, pnlWest;
    //Konstruktor
    public FirstFrame(){
        InitGUI();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
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
                        close();
                        new EmployeLoginSide().setVisible(true);
                    });
                    btnCustomer = new JButton("Customer"); pnlRow.add(btnCustomer);
                    btnCustomer.setBackground(Color.getColor("",ColorPalette.getBackGround()));
                    btnCustomer.setForeground(Color.getColor("",ColorPalette.getForeGround()));
                    btnCustomer.addActionListener(e -> {
                        close();
                        new CustomerLoginSide().setVisible(true);
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
        setUser();
    }

    public void close(){
        WindowEvent closeWindow = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closeWindow);
    }

    public static void setUser(){
        UserAccount user = new UserAccount("jan","kubicek","bc","email@seznam.cz", LocalDateTime.MIN,"731357202","heslo","men",LocalDateTime.MAX,false,3333);
        CollectionOfUsersAccounts.addUser(user);
        AdminAccount admin = new AdminAccount("jan","kubicek","bc","email@seznam.cz",LocalDateTime.MIN,"731357202","heslo","men",LocalDateTime.MAX);
        CollectionOfAdminAccounts.addAdmin(admin);
    }

}

