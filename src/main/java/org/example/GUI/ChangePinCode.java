package org.example.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;

public class ChangePinCode extends JFrame {
    //Komponents
    JLabel lbChangePin;
    JButton btnSubmit;
    JPanel pnlCenter, pnlSouth, pnlEast, pnlWest;
    JTextField tfChangePin;

    //Konstructor
    public ChangePinCode(){
        InitGUI();
        setTitle("Change Pin Code");
        setSize(640,480);
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
            String idOfUser = UserSide.getIdOfLoggedUser();
            int newPinCode = Integer.parseInt(tfChangePin.getText());
            for(int i = 0; i < CollectionOfUsersAccounts.collectionOfUsers.size(); i ++){
                if(CollectionOfUsersAccounts.collectionOfUsers.get(i).ID.equals(idOfUser)){
                    CollectionOfUsersAccounts.collectionOfUsers.get(i).setAccountPinCode(newPinCode);
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
}
