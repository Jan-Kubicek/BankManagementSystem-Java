package org.example.GUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.io.PrintWriter;
import java.time.format.DateTimeFormatter;

public class UserSide extends JFrame {
    //Atribute
    public static String nameOfLoggedUser, IdOfLoggedUser;
    public static boolean dark;
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
        if(dark){
            pnlEast.setBackground(Color.getColor("",ColorPalette.getDarkSidePannels()));
        }else {
            pnlEast.setBackground(Color.getColor("",ColorPalette.getSidePannels()));
        }
        add(pnlEast,BorderLayout.EAST);
        //West
        pnlWest = new JPanel();
        if(dark){
            pnlWest.setBackground(Color.getColor("",ColorPalette.getDarkSidePannels()));
        }else{
            pnlWest.setBackground(Color.getColor("",ColorPalette.getSidePannels()));
        }
        add(pnlWest,BorderLayout.WEST);
        //Center
        pnlCenter = new JPanel(new GridLayout(2,1));
            //Upper Center
            pnlUpper = new JPanel( new GridLayout(4,2));
                btnCustomizedProfile = new JButton("Customize Profile");
                if(dark){
                    btnCustomizedProfile.setBackground(Color.getColor("",ColorPalette.getDarkBackGround()));
                    btnCustomizedProfile.setForeground(Color.getColor("",ColorPalette.getDarkForeGround()));
                }
                else{
                    btnCustomizedProfile.setBackground(Color.getColor("",ColorPalette.getBackGround()));
                    btnCustomizedProfile.setForeground(Color.getColor("",ColorPalette.getForeGround()));
                }
                btnCustomizedProfile.addActionListener(e -> {
                    new CustomizeProfile();
                    CustomizeProfile.setDark(dark);
                    CustomizeProfile.setIdOfCustomizedProfile(getIdOfLoggedUser());
                    new CustomizeProfile().setVisible(true);
                });

                pnlUpper.add(btnCustomizedProfile);
                btnPrintAllTransactions = new JButton("Print all Transactions");
                if(dark){
                    btnPrintAllTransactions.setBackground(Color.getColor("",ColorPalette.getDarkBackGround()));
                    btnPrintAllTransactions.setForeground(Color.getColor("",ColorPalette.getDarkForeGround()));
                }else{
                    btnPrintAllTransactions.setBackground(Color.getColor("", ColorPalette.getBackGround()));
                    btnPrintAllTransactions.setForeground(Color.getColor("", ColorPalette.getForeGround()));
                }
                btnPrintAllTransactions.addActionListener(e -> {
                    String idOfLogginUser = getIdOfLoggedUser();
                    try{
                        PrintWriter vystup = new PrintWriter("Export.txt");
                            vystup.println("All Transaction of this Account");
                            vystup.println("OutComming transactions");
                            for(int i = 0; i < CollectionOfTransactions.collectionOfTransactions.size(); i++){
                                if(CollectionOfTransactions.collectionOfTransactions.get(i).getOutgoingAccount().ID.equals(idOfLogginUser)){
                                    vystup.println(CollectionOfTransactions.collectionOfTransactions.get(i).toString());
                                }
                            }
                            vystup.println("");
                            vystup.println("Incomminng Account");
                            for(int i = 0; i < CollectionOfTransactions.collectionOfTransactions.size(); i++){
                                if(CollectionOfTransactions.collectionOfTransactions.get(i).getIncommingAccount().ID.equals(idOfLogginUser)){
                                    vystup.println(CollectionOfTransactions.collectionOfTransactions.get(i).toString());
                                }
                            }
                        vystup.close();
                    }catch (Exception a){
                        a.printStackTrace();
                    }
                });pnlUpper.add(btnPrintAllTransactions);
                btnInsertMoney = new JButton("Insert Money");
                if(dark){
                    btnInsertMoney.setBackground(Color.getColor("",ColorPalette.getDarkBackGround()));
                    btnInsertMoney.setForeground(Color.getColor("",ColorPalette.getDarkForeGround()));
                }else {
                    btnInsertMoney.setForeground(Color.getColor("", ColorPalette.getForeGround()));
                    btnInsertMoney.setBackground(Color.getColor("", ColorPalette.getBackGround()));
                }
                btnInsertMoney.addActionListener(e -> {
                    new InsertMoney();
                    InsertMoney.setDark(dark);
                    new InsertMoney().setVisible(true);
                });
                pnlUpper.add(btnInsertMoney);
                btnSettings = new JButton("Settings");
                if(dark){
                    btnSettings.setBackground(Color.getColor("",ColorPalette.getDarkBackGround()));
                    btnSettings.setForeground(Color.getColor("",ColorPalette.getDarkForeGround()));
                }else {
                    btnSettings.setBackground(Color.getColor("", ColorPalette.getBackGround()));
                    btnSettings.setForeground(Color.getColor("", ColorPalette.getForeGround()));
                }btnSettings.addActionListener(e -> {
                    new Settings();
                    Settings.setDark(dark);
                    new Settings().setVisible(true);
                });
                pnlUpper.add(btnSettings);
                btnWithdrawMoney = new JButton("Withdraw Money");
                if(dark){
                    btnWithdrawMoney.setBackground(Color.getColor("",ColorPalette.getDarkBackGround()));
                    btnWithdrawMoney.setForeground(Color.getColor("",ColorPalette.getDarkForeGround()));
                }else {
                    btnWithdrawMoney.setBackground(Color.getColor("", ColorPalette.getBackGround()));
                    btnWithdrawMoney.setForeground(Color.getColor("", ColorPalette.getForeGround()));
                }btnWithdrawMoney.addActionListener(e -> {
                    new WithdrawMoney();
                    WithdrawMoney.setDark(dark);
                    new WithdrawMoney().setVisible(true);
                });
                pnlUpper.add(btnWithdrawMoney);
                btnChangePinCode = new JButton("Change PIN");
                if(dark){
                    btnChangePinCode.setBackground(Color.getColor("",ColorPalette.getDarkBackGround()));
                    btnChangePinCode.setForeground(Color.getColor("",ColorPalette.getDarkForeGround()));
                }else {
                    btnChangePinCode.setBackground(Color.getColor("", ColorPalette.getBackGround()));
                    btnChangePinCode.setForeground(Color.getColor("", ColorPalette.getForeGround()));
                }btnChangePinCode.addActionListener(e -> {
                    new ChangePinCode();
                    ChangePinCode.setDark(dark);
                    new ChangePinCode().setVisible(true);
                });
                pnlUpper.add(btnChangePinCode);
                btnMakeTransaction = new JButton("Make Transaction");
                if(dark){
                    btnMakeTransaction.setBackground(Color.getColor("",ColorPalette.getDarkBackGround()));
                    btnMakeTransaction.setForeground(Color.getColor("",ColorPalette.getDarkForeGround()));
                }else {
                    btnMakeTransaction.setBackground(Color.getColor("", ColorPalette.getBackGround()));
                    btnMakeTransaction.setForeground(Color.getColor("", ColorPalette.getForeGround()));
                }btnMakeTransaction.addActionListener(e -> {
                    new CreateTransaction();
                    CreateTransaction.setDark(dark);
                    new CreateTransaction().setVisible(true);
                });
                pnlUpper.add(btnMakeTransaction);
                btnExit = new JButton("Exit");
                if(dark){
                    btnExit.setBackground(Color.getColor("",ColorPalette.getDarkBackGround()));
                    btnExit.setForeground(Color.getColor("",ColorPalette.getDarkForeGround()));
                }else {
                    btnExit.setBackground(Color.getColor("", ColorPalette.getBackGround()));
                    btnExit.setForeground(Color.getColor("", ColorPalette.getForeGround()));
                }btnExit.addActionListener(e -> {
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
                    if(dark){
                        btnRemoveRow.setBackground(Color.getColor("",ColorPalette.getDarkBackGround()));
                        btnRemoveRow.setForeground(Color.getColor("",ColorPalette.getDarkForeGround()));
                    }else {
                        btnRemoveRow.setBackground(Color.getColor("", ColorPalette.getBackGround()));
                        btnRemoveRow.setForeground(Color.getColor("", ColorPalette.getForeGround()));
                    }btnRemoveRow.addActionListener(e -> {
                        int indexOfRow = table.getSelectedRow();
                        model.removeRow(indexOfRow);
                    });pnlEastBottom.add(btnRemoveRow);
                    btnClear = new JButton("Clear");
                    if(dark){
                        btnClear.setBackground(Color.getColor("",ColorPalette.getDarkBackGround()));
                        btnClear.setForeground(Color.getColor("",ColorPalette.getDarkForeGround()));
                    }else {
                        btnClear.setBackground(Color.getColor("", ColorPalette.getBackGround()));
                        btnClear.setForeground(Color.getColor("", ColorPalette.getForeGround()));
                    }btnClear.addActionListener(e -> model.setNumRows(0));
                    pnlEastBottom.add(btnClear);
                    btnPrintTransactions = new JButton("Print Transactions");
                    if(dark){
                        btnPrintTransactions.setBackground(Color.getColor("",ColorPalette.getDarkBackGround()));
                        btnPrintTransactions.setForeground(Color.getColor("",ColorPalette.getDarkForeGround()));
                    }else {
                        btnPrintTransactions.setBackground(Color.getColor("", ColorPalette.getBackGround()));
                        btnPrintTransactions.setForeground(Color.getColor("", ColorPalette.getForeGround()));
                    }btnPrintTransactions.addActionListener(e -> {
                        model.setNumRows(0);
                        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                        int idOfRow = model.getRowCount(); ++idOfRow;
                        String idOfLoginedUser = getIdOfLoggedUser();
                        for(int i = 0; i < CollectionOfTransactions.collectionOfTransactions.size(); i ++){
                            if(CollectionOfTransactions.collectionOfTransactions.get(i).incommingAccount.ID.equals(idOfLoginedUser)){
                                Transaction transaction = CollectionOfTransactions.collectionOfTransactions.get(i);
                                ++idOfRow;
                                model.addRow(new Object[]{idOfRow,transaction.getId(),transaction.getOutgoingAccount().name,transaction.getIncommingAccount(),transaction.getAmountOfMoney(),transaction.getDateOfTransaction().format(format)});
                            }
                            if(CollectionOfTransactions.collectionOfTransactions.get(i).outgoingAccount.ID.equals(idOfLoginedUser)){
                                Transaction transaction = CollectionOfTransactions.collectionOfTransactions.get(i);
                                ++idOfRow;
                                model.addRow(new Object[]{idOfRow,transaction.getId(),transaction.getOutgoingAccount().name,transaction.getIncommingAccount(),transaction.getAmountOfMoney(),transaction.getDateOfTransaction().format(format)});
                            }
                        }
                    });
                    pnlEastBottom.add(btnPrintTransactions);
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
    public static void setDark(boolean dark1){dark = dark1;}
    public static boolean getDark(){return dark;}
    public static String getNameOfLoggedUser(){return nameOfLoggedUser;}
    public static void setIdOfLoggedUser(String id){ IdOfLoggedUser = id;}
    public static String getIdOfLoggedUser(){return IdOfLoggedUser;}
}
