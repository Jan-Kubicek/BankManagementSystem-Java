package org.example.GUI;

import javax.swing.*;
import java.awt.*;

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
        //North
        pnlNorth  = new JPanel(new GridLayout(1,4));

        add(pnlNorth,BorderLayout.NORTH);
        //East
        pnlEast = new JPanel();
            pnlEast.setBackground(Color.getColor("",ColorPalette.getSidePannels()));
        add(pnlEast,BorderLayout.EAST);
        //West
        pnlWest = new JPanel();
            pnlWest.setBackground(Color.getColor("",ColorPalette.getSidePannels()));
        add(pnlWest,BorderLayout.WEST);
        //Center
        pnlCenter = new JPanel( new GridLayout(2,1));
            //Upper Center
            pnlUpperCenter = new JPanel(new GridLayout(2,2));
            pnlCenter.add(pnlUpperCenter);
            //Bottom Center
            pnlBottomCenter = new JPanel(new BorderLayout());
                //Bottom Center - Center
                pnlBottomCenterCenter = new JPanel(new GridLayout(1,1));
                pnlBottomCenter.add(pnlBottomCenterCenter,BorderLayout.CENTER);
                //Bottom Center - East
                pnlBottomCenterEast = new JPanel(new GridLayout(3,1));
                pnlBottomCenter.add(pnlBottomCenterEast,BorderLayout.EAST);
            pnlCenter.add(pnlBottomCenter);
        add(pnlCenter,BorderLayout.CENTER);

        pack();
    }
    //Main
    public static void main(String[] args){
        new EmployeSide().setVisible(true);
    }
}
