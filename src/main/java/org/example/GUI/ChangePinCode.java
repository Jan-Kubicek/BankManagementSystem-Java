package org.example.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;

public class ChangePinCode extends JFrame {
    //Atributes
    public static boolean dark = false;
    //Komponents
    JLabel lbChangePin;
    JButton btnSubmit;
    JPanel pnlCenter, pnlSouth, pnlEast, pnlWest;
    JTextField tfChangePin;

    //Konstructor
    public ChangePinCode(){
        InitGUI();
        setTitle("Change Pin Code");
        setSize(300,120);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
    //GUI
    public void InitGUI(){
        //Center
        pnlCenter = new JPanel(new GridLayout(1,2));
        lbChangePin = new JLabel("ChangePin");pnlCenter.add(lbChangePin);
        tfChangePin = new JTextField();pnlCenter.add(tfChangePin);
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
            String idOfUser = UserSide.getIdOfLoggedUser();
            int newPinCode = Integer.parseInt(tfChangePin.getText());
            for(int i = 0; i < CollectionOfUsersAccounts.collectionOfUsers.size(); i ++){
                if(CollectionOfUsersAccounts.collectionOfUsers.get(i).ID.equals(idOfUser)){
                    try{
                        CollectionOfUsersAccounts.collectionOfUsers.get(i).setAccountPinCode(newPinCode);
                    }catch (Exception exception){
                        JOptionPane.showMessageDialog(this,exception.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
                        break;
                    }
                    JOptionPane.showMessageDialog(this,"Pin Code was changed Successfully","Confirm",JOptionPane.INFORMATION_MESSAGE);
                    close();
                }
            }
        });pnlSouth.add(btnSubmit);
        add(pnlSouth,BorderLayout.SOUTH);

        pack();
    }
    //Main
    public static void main(String[] args){
        new ChangePinCode().setVisible(true);
    }

    public void close(){
        WindowEvent closeWindow = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closeWindow);
    }
    public static void setDark(boolean dark1){dark = dark1;}
    public static boolean getDark(){return dark;}
}
