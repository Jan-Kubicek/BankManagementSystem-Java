package org.example.GUI;

import javax.swing.*;

public class EmployeSide extends JFrame {
    //Komponenty
    JTable table;
    JButton btnCreateUserAcc, btnCreateAdminAcc, btnCheckAccounts, btnExit, btnCustomizeProfile, btnDeleteAcc, btnReset;
    JLabel lbName, lbAdmin, lbBranch, lbCurrentBranch;
    JPanel pnlWest, pnlEast, pnlNorth, pnlCenter, pnlUpperCenter, pnlBottomCenter, pnlBottomCenterCenter, pnlBottomCenterEast;
    //Konstruktor
    public EmployeSide(){
        InitGUI();
        setTitle("Employe Side");
        setSize(640,480);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    //GUI
    public void InitGUI(){

        pack();
    }
    //Main
    public static void main(String[] args){
        new EmployeSide().setVisible(true);
    }
}
