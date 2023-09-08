package org.example.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.time.LocalDateTime;

public class CustomizeProfile extends JFrame {
    public static String  idOfCustomizedProfile;
    public static boolean dark = false;
    //Komponents
    JLabel lbFirstName, lbLastName, lbDegree, lbEmail, lbTel, lbSex, lbDateOfBirth, lbPassword;
    JButton btnExit, btnCustom;
    JTextField tfFirstName, tfLastName, tfDegree, tfEmail, tfTelephone, tfSex, tfPassword, tfDateOfBirth;
    JPanel pnlWest, pnlEast, pnlCenter, pnlSouth, pnlRow1, pnlRow2, pnlRow3, pnlRow4, pnlRow6, pnlRow7;

    //Konstructor
    public CustomizeProfile(){
        InitGUI();
        setSize(640,480);
        setTitle("Creating Admins Account");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
    //GUI
    public void InitGUI(){
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
        pnlSouth = new JPanel();
        pnlRow7 = new JPanel(new GridLayout(1,2));
        btnCustom = new JButton("Customize Account");
        if(dark){
            btnCustom.setBackground(Color.getColor("",ColorPalette.getDarkBackGround()));
            btnCustom.setForeground(Color.getColor("",ColorPalette.getDarkForeGround()));
        }else{
            btnCustom.setBackground(Color.getColor("",ColorPalette.getBackGround()));
            btnCustom.setForeground(Color.getColor("",ColorPalette.getForeGround()));
        }
        btnCustom.addActionListener(e -> {
            String idOfCustomizedUser = getIdOfCustomizedProfile();
            StringBuilder firstTwoLetters = new StringBuilder();
            for(int i = 0; i < 2; i++){
                firstTwoLetters.append(idOfCustomizedUser.charAt(i));
            }
            if(firstTwoLetters.toString().equals("US")){ //User
                boolean successfully = true;
                UserAccount userAccount = null;
                for(int i = 0; i < CollectionOfUsersAccounts.collectionOfUsers.size(); i++){
                    if(CollectionOfUsersAccounts.collectionOfUsers.get(i).ID.equals(idOfCustomizedUser)){
                        userAccount = CollectionOfUsersAccounts.collectionOfUsers.get(i);
                    }
                }
                String firstName = null,lastName = null, degree = null, sex = null, email = null, telephone = null, dateOfBirth = null, password = null;
                boolean bFirstName, bLastName, bDegree, bSex, bEmail, bTelephone, bDateOfBirth, bPassword;
                bFirstName = false; bLastName = false; bDegree = false; bSex = false; bEmail = false; bTelephone = false; bDateOfBirth = false; bPassword = false;
                if(tfFirstName.getText().length() != 0 ){firstName = tfFirstName.getText(); bFirstName = true;}
                if(tfLastName.getText().length() != 0 ){lastName = tfLastName.getText(); bLastName = true;}
                if(tfDegree.getText().length() != 0){ degree = tfDegree.getText(); bDegree = true;}
                if(tfSex.getText().length() != 0){ sex = tfSex.getText(); bSex = true;}
                if(tfEmail.getText().length() !=0){ email = tfEmail.getText(); bEmail = true;}
                if(tfTelephone.getText().length() !=0){ telephone = tfTelephone.getText(); bTelephone = true;}
                if(tfDateOfBirth.getText().length() !=0){ dateOfBirth = tfDateOfBirth.getText(); bDateOfBirth = true;}
                if(tfPassword.getText().length() != 0){ password = tfPassword.getText(); bPassword = true;}
                if(userAccount != null) {
                    if (bFirstName) {
                        String customizedDegree = userAccount.degree;
                        String customizedLastName = userAccount.lastName;
                        String name = customizedDegree + " " + firstName + " " + customizedLastName;
                        try {
                            userAccount.setName(name);
                        } catch (Exception exception) {
                            JOptionPane.showMessageDialog(this, exception.getMessage(), "Warning", JOptionPane.WARNING_MESSAGE);
                            successfully = false;
                        }
                    }
                    if (bLastName) {
                        String customizedDegree = userAccount.degree;
                        String customizedFirstName = userAccount.firstName;
                        String name = customizedDegree + " " + customizedFirstName + " " + lastName;
                        try {
                            userAccount.setName(name);
                        } catch (Exception exception) {
                            JOptionPane.showMessageDialog(this, exception.getMessage(), "Warning", JOptionPane.WARNING_MESSAGE);
                            successfully = false;
                        }
                    }
                    if (bDegree) {
                        String customizedFirstName = userAccount.firstName;
                        String customizedLastName = userAccount.lastName;
                        String name = degree + " " + customizedFirstName + " " + customizedLastName;
                        try {
                            userAccount.setName(name);
                        } catch (Exception exception) {
                            JOptionPane.showMessageDialog(this, exception.getMessage(), "Warning", JOptionPane.WARNING_MESSAGE);
                            successfully = false;
                        }
                    }
                    if (bSex) {
                        try {
                            userAccount.setSex(sex);
                        } catch (Exception exception) {
                            JOptionPane.showMessageDialog(this, exception.getMessage(), "Warning", JOptionPane.WARNING_MESSAGE);
                            successfully = false;
                        }
                    }
                    if (bEmail) {
                        try {
                            userAccount.setEmail(email);
                        } catch (Exception exception) {
                            JOptionPane.showMessageDialog(this, exception.getMessage(), "Warning", JOptionPane.WARNING_MESSAGE);
                            successfully = false;
                        }
                    }
                    if (bTelephone) {
                        try {
                            userAccount.setTelephoneNumber(telephone);
                        } catch (Exception exception) {
                            JOptionPane.showMessageDialog(this, exception.getMessage(), "Warning", JOptionPane.WARNING_MESSAGE);
                            successfully = false;
                        }
                    }
                    if (bDateOfBirth) {
                        try {
                            int hour = 0;
                            int minute = 0;
                            String[] tokens = dateOfBirth.split("/");
                            int[] numbers = new int[3];
                            for (int i = 0; i < tokens.length; i++) {
                                numbers[i] = Integer.parseInt(tokens[i]);
                            }
                            LocalDateTime dateOfBirthLDT = LocalDateTime.of(numbers[2], numbers[1], numbers[0], hour, minute);
                            userAccount.setDateOfBirth(dateOfBirthLDT);
                        } catch (Exception exception) {
                            JOptionPane.showMessageDialog(this, exception.getMessage(), "Warning", JOptionPane.WARNING_MESSAGE);
                            successfully = false;
                        }
                    }
                    if (bPassword) {
                        try {
                            userAccount.setPassword(password);
                        } catch (Exception exception) {
                            JOptionPane.showMessageDialog(this, exception.getMessage(), "Warning", JOptionPane.WARNING_MESSAGE);
                            successfully = false;
                        }
                    }
                }
                if(successfully){
                    JOptionPane.showMessageDialog(this,"Changes was successfully saved","Successfull",JOptionPane.INFORMATION_MESSAGE);
                }
            }
            if(firstTwoLetters.toString().equals("AD")) { //ADMIN Employe
                boolean successfully = true;
                AdminAccount adminAccount = null;
                for (int i = 0; i < CollectionOfAdminAccounts.collectionOfAdmins.size(); i++) {
                    if (CollectionOfAdminAccounts.collectionOfAdmins.get(i).ID.equals(idOfCustomizedUser)) {
                        adminAccount = CollectionOfAdminAccounts.collectionOfAdmins.get(i);
                    }
                }
                String firstName = null, lastName = null, degree = null, sex = null, email = null, telephone = null, dateOfBirth = null, password = null;
                boolean bFirstName, bLastName, bDegree, bSex, bEmail, bTelephone, bDateOfBirth, bPassword;
                bFirstName = false;
                bLastName = false;
                bDegree = false;
                bSex = false;
                bEmail = false;
                bTelephone = false;
                bDateOfBirth = false;
                bPassword = false;
                if (tfFirstName.getText().length() != 0) {
                    firstName = tfFirstName.getText();
                    bFirstName = true;
                }
                if (tfLastName.getText().length() != 0) {
                    lastName = tfLastName.getText();
                    bLastName = true;
                }
                if (tfDegree.getText().length() != 0) {
                    degree = tfDegree.getText();
                    bDegree = true;
                }
                if (tfSex.getText().length() != 0) {
                    sex = tfSex.getText();
                    bSex = true;
                }
                if (tfEmail.getText().length() != 0) {
                    email = tfEmail.getText();
                    bEmail = true;
                }
                if (tfTelephone.getText().length() != 0) {
                    telephone = tfTelephone.getText();
                    bTelephone = true;
                }
                if (tfDateOfBirth.getText().length() != 0) {
                    dateOfBirth = tfDateOfBirth.getText();
                    bDateOfBirth = true;
                }
                if (tfPassword.getText().length() != 0) {
                    password = tfPassword.getText();
                    bPassword = true;
                }
                if (adminAccount != null) {
                    if (bFirstName) {
                        String customizedDegree = adminAccount.degree;
                        String customizedLastName = adminAccount.lastName;
                        String name = customizedDegree + " " + firstName + " " + customizedLastName;
                        try {
                            adminAccount.setName(name);
                        } catch (Exception exception) {
                            JOptionPane.showMessageDialog(this, exception.getMessage(), "Warning", JOptionPane.WARNING_MESSAGE);
                            successfully = false;
                        }
                    }
                    if (bLastName) {
                        String customizedDegree = adminAccount.degree;
                        String customizedFirstName = adminAccount.firstName;
                        String name = customizedDegree + " " + customizedFirstName + " " + lastName;
                        try {
                            adminAccount.setName(name);
                        } catch (Exception exception) {
                            JOptionPane.showMessageDialog(this, exception.getMessage(), "Warning", JOptionPane.WARNING_MESSAGE);
                            successfully = false;
                        }
                    }
                    if (bDegree) {
                        String customizedFirstName = adminAccount.firstName;
                        String customizedLastName = adminAccount.lastName;
                        String name = degree + " " + customizedFirstName + " " + customizedLastName;
                        try {
                            adminAccount.setName(name);
                        } catch (Exception exception) {
                            JOptionPane.showMessageDialog(this, exception.getMessage(), "Warning", JOptionPane.WARNING_MESSAGE);
                            successfully = false;
                        }
                    }
                    if (bSex) {
                        try {
                            adminAccount.setSex(sex);
                        } catch (Exception exception) {
                            JOptionPane.showMessageDialog(this, exception.getMessage(), "Warning", JOptionPane.WARNING_MESSAGE);
                            successfully = false;
                        }
                    }
                    if (bEmail) {
                        try {
                            adminAccount.setEmail(email);
                        } catch (Exception exception) {
                            JOptionPane.showMessageDialog(this, exception.getMessage(), "Warning", JOptionPane.WARNING_MESSAGE);
                            successfully = false;
                        }
                    }
                    if (bTelephone) {
                        try {
                            adminAccount.setTelephoneNumber(telephone);
                        } catch (Exception exception) {
                            JOptionPane.showMessageDialog(this, exception.getMessage(), "Warning", JOptionPane.WARNING_MESSAGE);
                            successfully = false;
                        }
                    }
                    if (bDateOfBirth) {
                        try {
                            int hour = 0;
                            int minute = 0;
                            String[] tokens = dateOfBirth.split("/");
                            int[] numbers = new int[3];
                            for (int i = 0; i < tokens.length; i++) {
                                numbers[i] = Integer.parseInt(tokens[i]);
                            }
                            LocalDateTime dateOfBirthLDT = LocalDateTime.of(numbers[2], numbers[1], numbers[0], hour, minute);
                            adminAccount.setDateOfBirth(dateOfBirthLDT);
                        } catch (Exception exception) {
                            JOptionPane.showMessageDialog(this, exception.getMessage(), "Warning", JOptionPane.WARNING_MESSAGE);
                            successfully = false;
                        }
                    }
                    if (bPassword) {
                        try {
                            adminAccount.setPassword(password);
                        } catch (Exception exception) {
                            JOptionPane.showMessageDialog(this, exception.getMessage(), "Warning", JOptionPane.WARNING_MESSAGE);
                            successfully = false;
                        }
                    }
                }
                if(successfully){
                    JOptionPane.showMessageDialog(this,"Changes was successfully saved","Successfull",JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });pnlRow7.add(btnCustom);
        btnExit = new JButton("Exit");
        if(dark){
            btnExit.setBackground(Color.getColor("",ColorPalette.getDarkBackGround()));
            btnExit.setForeground(Color.getColor("",ColorPalette.getDarkForeGround()));
        }else{
            btnExit.setBackground(Color.getColor("",ColorPalette.getBackGround()));
            btnExit.setForeground(Color.getColor("",ColorPalette.getForeGround()));
        }
        btnExit.addActionListener(e -> close());pnlRow7.add(btnExit);
        pnlSouth.add(pnlRow7);
        add(pnlSouth,BorderLayout.SOUTH);

        //Center
        pnlCenter = new JPanel(new GridLayout(5,1));
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
        pnlRow6 = new JPanel(new GridLayout(1,2));
        lbPassword = new JLabel("Password"); pnlRow6.add(lbPassword);
        tfPassword = new JTextField(); pnlRow6.add(tfPassword);
        pnlCenter.add(pnlRow6);
        add(pnlCenter,BorderLayout.CENTER);

        pack();
    }
    //Main
    public static void main(String[] args){
        new CustomizeProfile().setVisible(true);
    }

    public void close(){
        WindowEvent closeWindow = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closeWindow);
    }
    //Methods
    public static void setIdOfCustomizedProfile(String idOfCustomizedProfile1){idOfCustomizedProfile = idOfCustomizedProfile1;}
    public static String getIdOfCustomizedProfile(){return idOfCustomizedProfile;}
    public static void setDark(boolean dark1){dark = dark1;}
    public static boolean getDark(){return dark;}
}
