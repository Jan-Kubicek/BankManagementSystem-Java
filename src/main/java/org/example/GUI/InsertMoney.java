package org.example.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;

public class InsertMoney extends JFrame {
    //Atribute
        public static boolean dark = false;
    //Komponents
    JLabel lbInsert;
    JButton btnSubmit;
    JPanel pnlCenter, pnlSouth, pnlEast, pnlWest;
    JTextField tfInsert;

    //Konstructor
    public InsertMoney(){
        InitGUI();
        setTitle("Insert Money");
        setSize(320,120);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
    //GUI
    public void InitGUI(){
        //Center
        pnlCenter = new JPanel(new GridLayout(1,2));
           lbInsert = new JLabel("Insert amount of money");pnlCenter.add(lbInsert);
           tfInsert = new JTextField();pnlCenter.add(tfInsert);
        add(pnlCenter,BorderLayout.CENTER);
        //West
        pnlWest = new JPanel();
            if(dark){
                pnlWest.setBackground(Color.getColor("",ColorPalette.getDarkSidePannels()));
            }else{
                pnlWest.setBackground(Color.getColor("",ColorPalette.getSidePannels()));
            }
        add(pnlWest,BorderLayout.WEST);
        //East
        pnlEast = new JPanel();
        if(dark){
            pnlEast.setBackground(Color.getColor("",ColorPalette.getDarkSidePannels()));
        }else{
            pnlEast.setBackground(Color.getColor("",ColorPalette.getSidePannels()));
        }
        add(pnlEast,BorderLayout.EAST);
        //South
        pnlSouth = new JPanel(new GridLayout(1,1));
            btnSubmit = new JButton("Submit");
            if(dark){
                btnSubmit.setBackground(Color.getColor("",ColorPalette.getDarkBackGround()));
                btnSubmit.setForeground(Color.getColor("",ColorPalette.getDarkForeGround()));
            }else{
                btnSubmit.setBackground(Color.getColor("",ColorPalette.getBackGround()));
                btnSubmit.setForeground(Color.getColor("",ColorPalette.getForeGround()));
            }
            btnSubmit.addActionListener(e -> {
                float amoutOfMoney = Float.parseFloat(tfInsert.getText());
                String idOfUser = UserSide.getIdOfLoggedUser();
                for(int i = 0 ; i < CollectionOfUsersAccounts.collectionOfUsers.size(); i++){
                    if(CollectionOfUsersAccounts.collectionOfUsers.get(i).ID.equals(idOfUser)){
                        UserAccount userAccount = CollectionOfUsersAccounts.collectionOfUsers.get(i);
                        userAccount.inCome(amoutOfMoney);
                        JOptionPane.showMessageDialog(this,"Inserting of money was Suscesfully","Confirm",JOptionPane.INFORMATION_MESSAGE);
                        close();
                    }
                }
            });pnlSouth.add(btnSubmit);
        add(pnlSouth,BorderLayout.SOUTH);

        pack();
    }
    //Main
    public static void main(String[] args){
        new InsertMoney().setVisible(true);
    }

    public void close(){
        WindowEvent closeWindow = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closeWindow);
    }
    public static void setDark(boolean dark1){dark = dark1;}
    public static boolean getDark(){return dark;}
}
