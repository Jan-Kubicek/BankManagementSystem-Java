package org.example.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;

public class WithdrawMoney extends JFrame {
    //Komponents
    JLabel lbWithdraw;
    JButton btnSubmit;
    JPanel pnlCenter, pnlSouth, pnlEast, pnlWest;
    JTextField tfWithdraw;

    //Konstructor
    public WithdrawMoney(){
        InitGUI();
        setTitle("Withdraw Money");
        setSize(640,480);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
    //GUI
    public void InitGUI(){
        //Center
        pnlCenter = new JPanel(new GridLayout(1,2));
        lbWithdraw = new JLabel("Insert amount of money");pnlCenter.add(lbWithdraw);
        tfWithdraw = new JTextField();pnlCenter.add(tfWithdraw);
        add(pnlCenter,BorderLayout.CENTER);
        //West
        pnlWest = new JPanel();
        pnlWest.setBackground(Color.getColor("",ColorPalette.getSidePannels()));
        add(pnlWest,BorderLayout.WEST);
        //East
        pnlEast = new JPanel();
        pnlEast.setBackground(Color.getColor("",ColorPalette.getSidePannels()));
        add(pnlEast,BorderLayout.EAST);
        //South
        pnlSouth = new JPanel(new GridLayout(1,1));
        btnSubmit = new JButton("Submit");
        btnSubmit.setBackground(Color.getColor("",ColorPalette.getBackGround()));
        btnSubmit.setForeground(Color.getColor("",ColorPalette.getForeGround()));
        btnSubmit.addActionListener(e -> {
            float amoutOfMoney = Float.parseFloat(tfWithdraw.getText());
            String idOfUser = UserSide.getIdOfLoggedUser();
            for(int i = 0 ; i < CollectionOfUsersAccounts.collectionOfUsers.size(); i++){
                if(CollectionOfUsersAccounts.collectionOfUsers.get(i).ID.equals(idOfUser)){
                    UserAccount userAccount = CollectionOfUsersAccounts.collectionOfUsers.get(i);
                    userAccount.outCome(amoutOfMoney);
                    JOptionPane.showMessageDialog(this,"Withdraw of money was Suscesfully","Confirm",JOptionPane.INFORMATION_MESSAGE);
                    close();
                }
            }
        });pnlSouth.add(btnSubmit);
        add(pnlSouth,BorderLayout.SOUTH);

        pack();
    }
    //Main
    public static void main(String[] args){
        new WithdrawMoney().setVisible(true);
    }

    public void close(){
        WindowEvent closeWindow = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closeWindow);
    }
}
