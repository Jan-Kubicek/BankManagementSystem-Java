package org.example.GUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.WindowEvent;

public class UserSide extends JFrame {
    //Atribute
    public static String nameOfLoggedUser, IdOfLoggedUser;

    //Komponenty
    JLabel lbName, lbUserName, lbId;
    JTable table;
    JButton btnCustomizedProfile, btnInsertMoney, btnWithdrawMoney, btnMakeTransaction, btnPrintAllTransactions, btnSettings, btnChangePinCode, btnExit, btnRemoveRow, btnClear, btnPrintTransactions;
    JPanel pnlNorth, pnlCenter, pnlWest, pnlEast, pnlUpper, pnlBottom, pnlEastBottom, pnlCenterBottom;
    //Konstruktor
    public UserSide(){
        InitGUI();
        setTitle("Users Account");
        setSize(640,480);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
    //GUI
    public void InitGUI(){
        //North
        pnlNorth = new JPanel(new GridLayout(1,3));
            lbName = new JLabel("Name: "); pnlNorth.add(lbName);
            lbUserName = new JLabel(getNameOfLoggedUser()); pnlNorth.add(lbUserName);
            lbId = new JLabel(getIdOfLoggedUser()); pnlNorth.add(lbId);
        add(pnlNorth, BorderLayout.NORTH);
        //East
        pnlEast = new JPanel();
        pnlEast.setBackground(Color.getColor("",ColorPalette.getSidePannels()));
        add(pnlEast,BorderLayout.EAST);
        //West
        pnlWest = new JPanel();
        pnlWest.setBackground(Color.getColor("",ColorPalette.getSidePannels()));
        add(pnlWest,BorderLayout.WEST);
        //Center
        pnlCenter = new JPanel(new GridLayout(2,1));
            //Upper Center
            pnlUpper = new JPanel( new GridLayout(4,2));
                btnCustomizedProfile = new JButton("Customize Profile");
                btnCustomizedProfile.setBackground(Color.getColor("",ColorPalette.getBackGround()));
                btnCustomizedProfile.setForeground(Color.getColor("",ColorPalette.getForeGround()));
                btnCustomizedProfile.addActionListener(e -> {
                    //TODO
                });pnlUpper.add(btnCustomizedProfile);
                btnPrintAllTransactions = new JButton("Print all Transactions");
                btnPrintAllTransactions.setBackground(Color.getColor("",ColorPalette.getBackGround()));
                btnPrintAllTransactions.setForeground(Color.getColor("",ColorPalette.getForeGround()));
                btnPrintAllTransactions.addActionListener(e -> {
                    //TODO
                });pnlUpper.add(btnPrintAllTransactions);
                btnInsertMoney = new JButton("Insert Money");
                btnInsertMoney.setForeground(Color.getColor("",ColorPalette.getForeGround()));
                btnInsertMoney.setBackground(Color.getColor("",ColorPalette.getBackGround()));
                btnInsertMoney.addActionListener(e -> {
                    new InsertMoney().setVisible(true);
                });pnlUpper.add(btnInsertMoney);
                btnSettings = new JButton("Settings");
                btnSettings.setBackground(Color.getColor("",ColorPalette.getBackGround()));
                btnSettings.setForeground(Color.getColor("",ColorPalette.getForeGround()));
                btnSettings.addActionListener(e -> {
                    //TODO
                });pnlUpper.add(btnSettings);
                btnWithdrawMoney = new JButton("Withdraw Money");
                btnWithdrawMoney.setBackground(Color.getColor("",ColorPalette.getBackGround()));
                btnWithdrawMoney.setForeground(Color.getColor("",ColorPalette.getForeGround()));
                btnWithdrawMoney.addActionListener(e -> {
                    //TODO
                });pnlUpper.add(btnWithdrawMoney);
                btnChangePinCode = new JButton("Change PIN");
                btnChangePinCode.setBackground(Color.getColor("",ColorPalette.getBackGround()));
                btnChangePinCode.setForeground(Color.getColor("",ColorPalette.getForeGround()));
                btnChangePinCode.addActionListener(e -> {
                    //TODO
                });pnlUpper.add(btnChangePinCode);
                btnMakeTransaction = new JButton("Make Transaction");
                btnMakeTransaction.setBackground(Color.getColor("",ColorPalette.getBackGround()));
                btnMakeTransaction.setForeground(Color.getColor("",ColorPalette.getForeGround()));
                btnMakeTransaction.addActionListener(e -> {
                    //TODO
                });pnlUpper.add(btnMakeTransaction);
                btnExit = new JButton("Exit");
                btnExit.setBackground(Color.getColor("",ColorPalette.getBackGround()));
                btnExit.setForeground(Color.getColor("",ColorPalette.getForeGround()));
                btnExit.addActionListener(e -> {
                    JOptionPane.showMessageDialog(this,"You was been successfully logout","Logout",JOptionPane.INFORMATION_MESSAGE);
                    close();
                    new CustomerLoginSide().setVisible(true);
                });pnlUpper.add(btnExit);
            pnlCenter.add(pnlUpper);
            //Bottom Center
            pnlBottom = new JPanel(new BorderLayout());
                //Bottom Center - Center
                pnlCenterBottom = new JPanel(new GridLayout(1,1));
                    DefaultTableModel model = new DefaultTableModel();
                        model.addColumn("Number");              //O
                        model.addColumn("ID");                  //1
                        model.addColumn("Outgoing account");    //2
                        model.addColumn("Incomming account");   //3
                        model.addColumn("Amount");              //4
                        model.addColumn("Date");                //5
                    table = new JTable(model);
                    pnlCenterBottom.add(new JScrollPane(table));
                pnlBottom.add(pnlCenterBottom,BorderLayout.CENTER);
                //Bottom Center - East
                pnlEastBottom = new JPanel(new GridLayout(3,1));
                    btnRemoveRow = new JButton("Remove Row");
                    btnRemoveRow.setBackground(Color.getColor("",ColorPalette.getBackGround()));
                    btnRemoveRow.setForeground(Color.getColor("",ColorPalette.getForeGround()));
                    btnRemoveRow.addActionListener(e -> {
                        //TODO
                    });pnlEastBottom.add(btnRemoveRow);
                    btnClear = new JButton("Clear");
                    btnClear.setBackground(Color.getColor("",ColorPalette.getBackGround()));
                    btnClear.setForeground(Color.getColor("",ColorPalette.getForeGround()));
                    btnClear.addActionListener(e -> {
                        //TODO
                    });pnlEastBottom.add(btnClear);
                    btnPrintTransactions = new JButton("Print Transactions");
                    btnPrintTransactions.setBackground(Color.getColor("",ColorPalette.getBackGround()));
                    btnPrintTransactions.setForeground(Color.getColor("",ColorPalette.getForeGround()));
                    btnPrintTransactions.addActionListener(e -> {
                        //TODO
                    });pnlEastBottom.add(btnPrintTransactions);
                pnlBottom.add(pnlEastBottom,BorderLayout.EAST);
            pnlCenter.add(pnlBottom);
        add(pnlCenter,BorderLayout.CENTER);
        pack();
    }
    //Main
    public static void main(String[] args){
        new UserSide().setVisible(true);
    }

    public void close(){
        WindowEvent closeWindow = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closeWindow);
    }

    public static void setNameOfUser(String name){
        nameOfLoggedUser = name;
    }

    public static String getNameOfLoggedUser(){return nameOfLoggedUser;}
    public static void setIdOfLoggedUser(String id){ IdOfLoggedUser = id;}
    public static String getIdOfLoggedUser(){return IdOfLoggedUser;}
}
