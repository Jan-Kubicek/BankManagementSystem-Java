package org.example.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.time.LocalDateTime;

public class CreateUsersAccount extends JFrame {
    //Komponents
    JLabel lbFirstName, lbLastName, lbDegree, lbEmail, lbTel, lbSex, lbDateOfBirth, lbDarkM, lbPin, lbPassword;
    JButton btnExit, btnCreate;
    JTextField tfFirstName, tfLastName, tfDegree, tfEmail, tfTelephone, tfSex, tfPin, tfPassword, tfDateOfBirth;
    JRadioButton rbtnYes, rbtnNo;
    JPanel pnlWest, pnlEast, pnlCenter, pnlSouth, pnlRow1, pnlRow2, pnlRow3, pnlRow4, pnlRow5, pnlRow6, pnlRow7;

    //Konstructor
    public CreateUsersAccount(){
        InitGUI();
        setSize(640,480);
        setTitle("Creating Users Account");
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

        //South
        pnlSouth = new JPanel();
            pnlRow7 = new JPanel(new GridLayout(1,2));
                btnCreate = new JButton("Create Account");
                btnCreate.setBackground(Color.getColor("",ColorPalette.getBackGround()));
                btnCreate.setForeground(Color.getColor("",ColorPalette.getForeGround()));
                btnCreate.addActionListener(e -> {
                    boolean add = true;
                    String firstName = tfFirstName.getText();
                    String lastName = tfLastName.getText();
                    String degree = tfDegree.getText();
                    String email = tfEmail.getText();
                    String telephoneNumber = tfTelephone.getText();
                    String sex = tfSex.getText();
                    int pin = Integer.parseInt(tfPin.getText());
                    String password = tfPassword.getText();
                    boolean darkMode ;
                    darkMode= rbtnYes.isSelected();
                    String dateOfBirth = tfDateOfBirth.getText();
                    int hour = 0;
                    int minute = 0;
                    String[] tokens = dateOfBirth.split("/");
                    int[] numbers = new int[3];
                    for( int i = 0; i < tokens.length; i++){
                        numbers[i] = Integer.parseInt(tokens[i]);
                    }
                    LocalDateTime dateOfBirthLDT = LocalDateTime.of(numbers[2],numbers[1],numbers[0],hour,minute);
                    UserAccount userAccount = new UserAccount(firstName,lastName,degree,email,LocalDateTime.now(),telephoneNumber,password,sex,dateOfBirthLDT,darkMode,pin);
                    for(int i = 0; i < CollectionOfUsersAccounts.collectionOfUsers.size(); i++){
                        UserAccount userAcc = CollectionOfUsersAccounts.collectionOfUsers.get(i);
                        if(userAccount.name.equals(userAcc.name)){
                            if(userAccount.Email.equals(userAcc.Email)){
                                if(userAccount.telephoneNumber.equals(userAcc.telephoneNumber)){
                                    JOptionPane.showMessageDialog(this,"This Account is already exist","ERROR",JOptionPane.ERROR_MESSAGE);
                                    add = false;
                                }
                            }
                        }
                    }
                    if(add){
                        CollectionOfUsersAccounts.addUser(userAccount);
                        JOptionPane.showMessageDialog(this,"New Account was Successfully created","Information",JOptionPane.INFORMATION_MESSAGE);
                    }
                });pnlRow7.add(btnCreate);
                btnExit = new JButton("Exit");
                btnExit.setBackground(Color.getColor("",ColorPalette.getBackGround()));
                btnExit.setForeground(Color.getColor("",ColorPalette.getForeGround()));
                btnExit.addActionListener(e -> close());pnlRow7.add(btnExit);
            pnlSouth.add(pnlRow7);
        add(pnlSouth,BorderLayout.SOUTH);

        //Center
        pnlCenter = new JPanel(new GridLayout(6,1));
            pnlRow1 = new JPanel(new GridLayout(1,4));
                lbFirstName  = new JLabel("First name"); pnlRow1.add(lbFirstName);
                tfFirstName = new JTextField(); pnlRow1.add(tfFirstName);
                lbLastName = new JLabel("Last name"); pnlRow1.add(lbLastName);
                tfLastName = new JTextField(); pnlRow1.add(tfLastName);
            pnlCenter.add(pnlRow1);
            pnlRow2 = new JPanel(new GridLayout(1,4));
                lbDegree = new JLabel("Degree"); pnlRow2.add(lbDegree);
                tfDegree = new JTextField(); pnlRow2.add(tfDegree);
                lbSex = new JLabel("Sex"); pnlRow2.add(lbSex);
                tfSex = new JTextField(); pnlRow2.add(tfSex);
            pnlCenter.add(pnlRow2);
            pnlRow3 = new JPanel(new GridLayout(1,4));
                lbEmail = new JLabel("Email"); pnlRow3.add(lbEmail);
                tfEmail = new JTextField(); pnlRow3.add(tfEmail);
                lbTel = new JLabel("Telephone"); pnlRow3.add(lbTel);
                tfTelephone = new JTextField(); pnlRow3.add(tfTelephone);
            pnlCenter.add(pnlRow3);
            pnlRow4 = new JPanel( new GridLayout(1,2));
                lbDateOfBirth = new JLabel("Date of Birth"); pnlRow4.add(lbDateOfBirth);
                tfDateOfBirth= new JTextField(); pnlRow4.add(tfDateOfBirth); // DD/MM/YYYY
            pnlCenter.add(pnlRow4);
            pnlRow5 = new JPanel(new GridLayout(1,5));
                lbDarkM = new JLabel("Dark Mode"); pnlRow5.add(lbDarkM);
                rbtnYes = new JRadioButton( "Yes"); pnlRow5.add(rbtnYes);
                rbtnNo = new JRadioButton("No"); pnlRow5.add(rbtnNo);
            pnlCenter.add(pnlRow5);
            pnlRow6 = new JPanel(new GridLayout(1,4));
                lbPin = new JLabel("Pin"); pnlRow6.add(lbPin);
                tfPin = new JTextField(); pnlRow6.add(tfPin);
                lbPassword = new JLabel("Password"); pnlRow6.add(lbPassword);
                tfPassword = new JTextField(); pnlRow6.add(tfPassword);
            pnlCenter.add(pnlRow6);
        add(pnlCenter,BorderLayout.CENTER);

        pack();
    }
    //Main
    public static void main(String[] args){
        new CreateUsersAccount().setVisible(true);
    }

    public void close(){
        WindowEvent closeWindow = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closeWindow);
    }
}
