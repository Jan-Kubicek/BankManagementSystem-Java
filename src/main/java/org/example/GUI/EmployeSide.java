package org.example.GUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.WindowEvent;

public class EmployeSide extends JFrame {
    //Atributes
    public static String nameOfLoggedAdmin, branche;

    //Komponenty
    JTable table;
    JButton btnCreateUserAcc, btnCreateAdminAcc, btnCheckAccounts, btnExit, btnCustomizeProfile, btnDeleteAcc, btnReset;
    JLabel lbName, lbAdmin, lbBranch, lbCurrentBranch;
    JPanel pnlWest, pnlEast, pnlNorth, pnlCenter, pnlUpperCenter, pnlBottomCenter, pnlBottomCenterCenter, pnlBottomCenterEast;
    //Konstruktor
    public EmployeSide(){
        InitGUI();
        setTitle("Employe Side");
        setSize(640,480);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
    //GUI
    public void InitGUI(){
        //North
        pnlNorth  = new JPanel(new GridLayout(1,4));
            lbName = new JLabel("Name: "); pnlNorth.add(lbName);
            lbAdmin = new JLabel(getNameOfLoggedAdmin()); pnlNorth.add(lbAdmin);
            lbBranch = new JLabel("Branch: ");pnlNorth.add(lbBranch);
            lbCurrentBranch = new JLabel(getNameOfBranche()); pnlNorth.add(lbCurrentBranch);
        add(pnlNorth,BorderLayout.NORTH);
        //East
        pnlEast = new JPanel();
            pnlEast.setBackground(Color.getColor("",ColorPalette.getSidePannels()));
        add(pnlEast,BorderLayout.EAST);
        //West
        pnlWest = new JPanel();
            pnlWest.setBackground(Color.getColor("",ColorPalette.getSidePannels()));
        add(pnlWest,BorderLayout.WEST);
        //Center
        pnlCenter = new JPanel( new GridLayout(2,1));
            //Upper Center
            pnlUpperCenter = new JPanel(new GridLayout(2,2));
                btnCreateUserAcc = new JButton("Create Users account");
                btnCreateUserAcc.setBackground(Color.getColor("",ColorPalette.getBackGround()));
                btnCreateUserAcc.setForeground(Color.getColor("",ColorPalette.getForeGround()));
                btnCreateUserAcc.addActionListener(e -> {
                    new CreateUsersAccount().setVisible(true);
                });pnlUpperCenter.add(btnCreateUserAcc);
                btnCreateAdminAcc = new JButton("Create Admins account");
                btnCreateAdminAcc.setBackground(Color.getColor("",ColorPalette.getBackGround()));
                btnCreateAdminAcc.setForeground(Color.getColor("",ColorPalette.getForeGround()));
                btnCreateAdminAcc.addActionListener(e -> {
                   //TODO
                });pnlUpperCenter.add(btnCreateAdminAcc);
                btnCheckAccounts = new JButton("Check Accounts");
                btnCheckAccounts.setBackground(Color.getColor("",ColorPalette.getBackGround()));
                btnCheckAccounts.setForeground(Color.getColor("",ColorPalette.getForeGround()));
                btnCheckAccounts.addActionListener(e -> {
                    int numberOfUsersAccount = CollectionOfUsersAccounts.collectionOfUsers.size();
                    JOptionPane.showMessageDialog(this,"Number of Users accounts right now is: "+numberOfUsersAccount,"Number of Users",JOptionPane.INFORMATION_MESSAGE);
                });pnlUpperCenter.add(btnCheckAccounts);
                btnExit = new JButton("Exit");
                btnExit.setBackground(Color.getColor("",ColorPalette.getBackGround()));
                btnExit.setForeground(Color.getColor("",ColorPalette.getForeGround()));
                btnExit.addActionListener(e -> {
                    JOptionPane.showMessageDialog(this,"You was been successfully logout","Logout",JOptionPane.INFORMATION_MESSAGE);
                    close();
                    new EmployeLoginSide().setVisible(true);
                });pnlUpperCenter.add(btnExit);
            pnlCenter.add(pnlUpperCenter);
            //Bottom Center
            pnlBottomCenter = new JPanel(new BorderLayout());
                //Bottom Center - Center
                pnlBottomCenterCenter = new JPanel(new GridLayout(1,1));
                    DefaultTableModel model = new DefaultTableModel();
                        model.addColumn("ID");
                        model.addColumn("Name");
                        model.addColumn("Since");
                        model.addColumn("Balance");
                        model.addColumn("Email");
                        model.addColumn("Telephone Numer");
                    table = new JTable(model);
                    pnlBottomCenterCenter.add(new JScrollPane(table));
                pnlBottomCenter.add(pnlBottomCenterCenter,BorderLayout.CENTER);
                //Bottom Center - East
                pnlBottomCenterEast = new JPanel(new GridLayout(3,1));
                    btnCustomizeProfile = new JButton("Customize Profile");
                    btnCustomizeProfile.setBackground(Color.getColor("",ColorPalette.getBackGround()));
                    btnCustomizeProfile.setForeground(Color.getColor("",ColorPalette.getForeGround()));
                    btnCustomizeProfile.addActionListener(e -> {
                        //TODO
                    });pnlBottomCenterEast.add(btnCustomizeProfile);
                    btnDeleteAcc = new JButton("Delete account");
                    btnDeleteAcc.setBackground(Color.getColor("",ColorPalette.getBackGround()));
                    btnDeleteAcc.setForeground(Color.getColor("",ColorPalette.getForeGround()));
                    btnDeleteAcc.addActionListener(e -> {
                        //TODO
                    });pnlBottomCenterEast.add(btnDeleteAcc);
                    btnReset = new JButton("Reset");
                    btnReset.setBackground(Color.getColor("",ColorPalette.getBackGround()));
                    btnReset.setForeground(Color.getColor("",ColorPalette.getForeGround()));
                    btnReset.addActionListener(e -> {
                        //TODO
                    });pnlBottomCenterEast.add(btnReset);
                pnlBottomCenter.add(pnlBottomCenterEast,BorderLayout.EAST);
            pnlCenter.add(pnlBottomCenter);
        add(pnlCenter,BorderLayout.CENTER);
        pack();
    }
    //Main
    public static void main(String[] args){
        new EmployeSide().setVisible(true);
    }

    public void close(){
        WindowEvent closeWindow = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closeWindow);
    }
    public static void setNameOfAdmin(String name){
        nameOfLoggedAdmin = name;
    }

    public static String getNameOfLoggedAdmin(){return nameOfLoggedAdmin;}
    public static void  setBranche(String brancheN){ branche = brancheN;}
    public static String getNameOfBranche(){return branche;}
}
