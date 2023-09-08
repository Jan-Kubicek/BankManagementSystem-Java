package org.example.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;

public class Settings extends JFrame {
    //Komponents
    JPanel pnlWest, pnlEast, pnlCenter, pnlRows12, pnlRow3, pnlRow4;
    JLabel lbDarkMode, lbFinancialLimit, lbActualFinancialLimit;
    JTextField tfDarkMode,tfFinancialLimit;
    JButton btnConfirm, btnExit;

    //Konstructor
    public Settings(){
        InitGUI();
        setTitle("Settings");
        setSize(640,480);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
    //GUI
    public void InitGUI(){
        //West
        pnlWest = new JPanel();
            pnlWest.setBackground(Color.getColor("",ColorPalette.getSidePannels()));
        add(pnlWest,BorderLayout.WEST);
        //East
        pnlEast = new JPanel();
            pnlEast.setBackground(Color.getColor("",ColorPalette.getSidePannels()));
        add(pnlEast,BorderLayout.EAST);
        //Central
        pnlCenter = new JPanel(new GridLayout(4,1));
            pnlRows12 = new JPanel(new GridLayout(2,2));
                lbDarkMode = new JLabel("Dark mode"); pnlRows12.add(lbDarkMode);
                tfDarkMode = new JTextField("YES/NO"); pnlRows12.add(tfDarkMode);
                lbFinancialLimit = new JLabel("Financial Limit"); pnlRows12.add(lbFinancialLimit);
                tfFinancialLimit = new JTextField(); pnlRows12.add(tfFinancialLimit);
            pnlCenter.add(pnlRows12);
            pnlRow3 = new JPanel();
                String idOfLoggedUser = UserSide.getIdOfLoggedUser();
                UserAccount userAccount = null;
                for(int i = 0; i < CollectionOfUsersAccounts.collectionOfUsers.size(); i++){
                    if(CollectionOfUsersAccounts.collectionOfUsers.get(i).ID.equals(idOfLoggedUser)){
                        userAccount = CollectionOfUsersAccounts.collectionOfUsers.get(i);
                    }
                }
                if(userAccount != null) {
                    lbActualFinancialLimit = new JLabel(String.valueOf(userAccount.getFinancialLimits()));
                }
            pnlCenter.add(pnlRow3);
            pnlRow4 = new JPanel(new GridLayout(1,2));
                btnConfirm = new JButton("Confirm");
                btnConfirm.setBackground(Color.getColor("",ColorPalette.getBackGround()));
                btnConfirm.setForeground(Color.getColor("",ColorPalette.getForeGround()));
                btnConfirm.addActionListener(e -> {
                    String idOfLOggedUser = UserSide.getIdOfLoggedUser();
                    UserAccount UserAccount = null;
                    for(int i = 0; i < CollectionOfUsersAccounts.collectionOfUsers.size(); i++){
                        if(CollectionOfUsersAccounts.collectionOfUsers.get(i).ID.equals(idOfLOggedUser)){
                            UserAccount = CollectionOfUsersAccounts.collectionOfUsers.get(i);
                        }
                    }
                    if(UserAccount != null) {
                        String darkMode = tfDarkMode.getText().toUpperCase();
                        boolean suscesfull = true;
                        if(darkMode.equals("YES")){
                           try{
                               UserAccount.setDarkMode(true);
                           }catch (Exception exception){
                               JOptionPane.showMessageDialog(this,exception.getMessage(),"Warning",JOptionPane.WARNING_MESSAGE);
                               suscesfull = false;
                           }
                        }
                        else{
                           try{
                               UserAccount.setDarkMode(false);
                           }catch (Exception exception){
                               JOptionPane.showMessageDialog(this,exception.getMessage(),"Warning",JOptionPane.WARNING_MESSAGE);
                               suscesfull = false;
                           }
                        }
                        float newFinancialLimit = Float.parseFloat(tfFinancialLimit.getText());
                        try{
                            UserAccount.setFinancialLimits(newFinancialLimit);
                        }catch (Exception exception){
                            JOptionPane.showMessageDialog(this,exception.getMessage(),"Warning",JOptionPane.WARNING_MESSAGE);
                            suscesfull = false;
                        }
                        if(suscesfull){
                            JOptionPane.showMessageDialog(this,"Settings was confirmed","Information",JOptionPane.INFORMATION_MESSAGE);
                        }
                    }
                });pnlRow4.add(btnConfirm);
                btnExit = new JButton("Exit");
                btnExit.setBackground(Color.getColor("",ColorPalette.getBackGround()));
                btnExit.setForeground(Color.getColor("",ColorPalette.getForeGround()));
                btnExit.addActionListener(e -> close()); pnlRow4.add(btnExit);
            pnlCenter.add(pnlRow4);
        add(pnlCenter,BorderLayout.CENTER);


        pack();
    }
    //Main
    public static void main(String[] args){
        new Settings().setVisible(true);
    }
    public void close(){
        WindowEvent closeWindow = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closeWindow);
    }
}
