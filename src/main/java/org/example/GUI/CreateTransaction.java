package org.example.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;

public class CreateTransaction extends JFrame {
    //Komponents
    JPanel pnlWest, pnlEast, pnlCenter, pnlRow1, pnlRow2, pnlRow3;
    JLabel lbIncomeAccount, lbAmountOfMoney;
    JTextField tfAccount, tfMoney;
    JButton btnControl, btnSubmit, btnExit;
    //Konstructor
    public CreateTransaction(){
        InitGUI();
        setTitle("Creating new Transaction");
        setSize(480,360);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    //GUI
    public void InitGUI(){
        //West
        pnlWest = new JPanel();
            pnlWest.setBackground(Color.getColor("",ColorPalette.getSidePannels()));
        add(pnlWest, BorderLayout.WEST);
        //East
        pnlEast = new JPanel();
            pnlEast.setBackground(Color.getColor("",ColorPalette.getSidePannels()));
        add(pnlEast,BorderLayout.EAST);
        //Center
        pnlCenter = new JPanel(new GridLayout(3,1));
            pnlRow1 = new JPanel(new GridLayout(1,3));
                lbIncomeAccount = new JLabel("Income Account"); pnlRow1.add(lbIncomeAccount);
                tfAccount = new JTextField(); pnlRow1.add(tfAccount);
                btnControl = new JButton("Control");
                btnControl.setBackground(Color.getColor("",ColorPalette.getBackGround()));
                btnControl.setForeground(Color.getColor("",ColorPalette.getForeGround()));
                btnControl.addActionListener(e -> {
                    String idOfIncomeAcc = tfAccount.getText();
                    boolean isThere = false;
                    for(int i = 0; i < CollectionOfUsersAccounts.collectionOfUsers.size(); i++){
                        if(CollectionOfUsersAccounts.collectionOfUsers.get(i).ID.equals(idOfIncomeAcc)){
                            UserAccount userAccount = CollectionOfUsersAccounts.collectionOfUsers.get(i);
                            JOptionPane.showMessageDialog(this,userAccount.name+" "+userAccount.Email+"\n"+userAccount.telephoneNumber,"Information",JOptionPane.INFORMATION_MESSAGE);
                            isThere = true;
                            break;
                        }
                    }
                    if(!isThere){
                        JOptionPane.showMessageDialog(this,"None of the Accounts have this id","WARNING",JOptionPane.WARNING_MESSAGE);
                    }
                });
                pnlRow1.add(btnControl);
            pnlCenter.add(pnlRow1);
            pnlRow2 = new JPanel(new GridLayout(1,2));
                lbAmountOfMoney = new JLabel("Amount of money"); pnlRow2.add(lbAmountOfMoney);
                tfMoney = new JTextField(); pnlRow2.add(tfMoney);
            pnlCenter.add(pnlRow2);
            pnlRow3 = new JPanel( new GridLayout(1,2));
                btnSubmit = new JButton("Submit");
                btnSubmit.setBackground(Color.getColor("",ColorPalette.getBackGround()));
                btnSubmit.setForeground(Color.getColor("",ColorPalette.getForeGround()));
                btnSubmit.addActionListener(e -> {
                    UserAccount incomeAccount = null;
                    UserAccount outcomeAccount = null;
                    String idOfOutComeAccount = UserSide.getIdOfLoggedUser();
                    String idOfInComeAccount = tfAccount.getText();
                    float amountOfMoney = Float.parseFloat(tfMoney.getText());
                    for(int i = 0; i < CollectionOfUsersAccounts.collectionOfUsers.size(); i++){
                        if(CollectionOfUsersAccounts.collectionOfUsers.get(i).ID.equals(idOfInComeAccount)){
                            incomeAccount = CollectionOfUsersAccounts.collectionOfUsers.get(i);
                        }
                        if(CollectionOfUsersAccounts.collectionOfUsers.get(i).ID.equals(idOfOutComeAccount)){
                            outcomeAccount = CollectionOfUsersAccounts.collectionOfUsers.get(i);
                        }
                    }
                    if(incomeAccount != null && outcomeAccount != null){
                        Transaction transaction = new Transaction(outcomeAccount,incomeAccount,amountOfMoney);
                        CollectionOfTransactions.addTransaction(transaction);
                        JOptionPane.showMessageDialog(this,"New transaction was successfully made","Confirmed",JOptionPane.INFORMATION_MESSAGE);
                    }
                });
                pnlRow3.add(btnSubmit);
                btnExit = new JButton("Exit");
                btnExit.setBackground(Color.getColor("",ColorPalette.getBackGround()));
                btnExit.setForeground(Color.getColor("",ColorPalette.getForeGround()));
                btnExit.addActionListener(e -> close());
                pnlRow3.add(btnExit);
            pnlCenter.add(pnlRow3);
        add(pnlCenter,BorderLayout.CENTER);
        pack();
    }
    //Main
    public static void main(String[] args){
        new CreateTransaction().setVisible(true);
    }
    public void close(){
        WindowEvent closeWindow = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closeWindow);
    }
}
