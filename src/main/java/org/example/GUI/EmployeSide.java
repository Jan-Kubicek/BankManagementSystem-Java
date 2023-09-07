package org.example.GUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.time.format.DateTimeFormatter;

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
                btnCreateUserAcc.addActionListener(e -> new CreateUsersAccount().setVisible(true));pnlUpperCenter.add(btnCreateUserAcc);
                btnCreateAdminAcc = new JButton("Create Admins account");
                btnCreateAdminAcc.setBackground(Color.getColor("",ColorPalette.getBackGround()));
                btnCreateAdminAcc.setForeground(Color.getColor("",ColorPalette.getForeGround()));
                btnCreateAdminAcc.addActionListener(e -> new CreateAdminsAccount().setVisible(true));pnlUpperCenter.add(btnCreateAdminAcc);
                btnCheckAccounts = new JButton("Check Accounts");
                btnCheckAccounts.setBackground(Color.getColor("",ColorPalette.getBackGround()));
                btnCheckAccounts.setForeground(Color.getColor("",ColorPalette.getForeGround()));
                btnCheckAccounts.addActionListener(e -> {
                    int numberOfAdminsAccounts = CollectionOfAdminAccounts.collectionOfAdmins.size();
                    int numberOfUsersAccount = CollectionOfUsersAccounts.collectionOfUsers.size();
                    int sum = numberOfAdminsAccounts + numberOfUsersAccount;
                    JOptionPane.showMessageDialog(this,"Number of Account right now is: "+sum,"Number of Users and Admins",JOptionPane.INFORMATION_MESSAGE);
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
                        model.addColumn("ID");                  //0
                        model.addColumn("Name");                //1
                        model.addColumn("Since");               //2
                        model.addColumn("Balance");             //3
                        model.addColumn("Email");               //4
                        model.addColumn("Telephone Numer");     //5
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
                        int indexOfRow = table.getSelectedRow();
                        String idOfAccount = table.getValueAt(indexOfRow,0).toString();
                        StringBuilder typeOfAccount = new StringBuilder();
                        int indexOfAccount = -1;
                        for(int i = 0; i < 2 ; i++){
                            typeOfAccount.append(idOfAccount.charAt(i));
                        }
                        if( typeOfAccount.toString().equals("US")){
                            for(int i = 0; i < CollectionOfUsersAccounts.collectionOfUsers.size(); i++){
                                if(CollectionOfUsersAccounts.collectionOfUsers.get(i).ID.equals(idOfAccount)){
                                    indexOfAccount = i;
                                }
                            }
                            if(indexOfAccount != -1) {
                                CollectionOfUsersAccounts.removeUser(indexOfAccount);
                            }
                        }
                        if(typeOfAccount.toString().equals("AD")) {
                            for (int i = 0; i < CollectionOfAdminAccounts.collectionOfAdmins.size(); i++) {
                                if (CollectionOfAdminAccounts.collectionOfAdmins.get(i).ID.equals(idOfAccount)) {
                                    indexOfAccount = i;
                                }
                            }
                            if (indexOfAccount != -1) {
                                CollectionOfAdminAccounts.removeAdmin(indexOfAccount);
                            }
                        }
                    });pnlBottomCenterEast.add(btnDeleteAcc);
                    btnReset = new JButton("Reset");
                    btnReset.setBackground(Color.getColor("",ColorPalette.getBackGround()));
                    btnReset.setForeground(Color.getColor("",ColorPalette.getForeGround()));
                    btnReset.addActionListener(e -> {
                        model.setNumRows(0);
                        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                        for (int i = 0; i < CollectionOfUsersAccounts.collectionOfUsers.size(); i ++){
                            UserAccount userAccount = CollectionOfUsersAccounts.collectionOfUsers.get(i);
                            String formatedDateOfBirth = userAccount.since.format(format);
                            model.addRow(new Object[]{userAccount.getID(),userAccount.getName(),formatedDateOfBirth,userAccount.getAccountBalance(),userAccount.getEmail(),userAccount.getTelephoneNumber()});
                        }
                        for (int i = 0; i < CollectionOfAdminAccounts.collectionOfAdmins.size(); i ++){
                            AdminAccount adminAccount = CollectionOfAdminAccounts.collectionOfAdmins.get(i);
                            String formatedDateOfBirth = adminAccount.since.format(format);
                            model.addRow(new Object[]{adminAccount.getID(),adminAccount.getName(),formatedDateOfBirth,null,adminAccount.getEmail(),adminAccount.getTelephoneNumber()});
                        }
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
