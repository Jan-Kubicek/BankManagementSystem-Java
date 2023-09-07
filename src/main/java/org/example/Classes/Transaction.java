package org.example.Classes;

import java.time.LocalDateTime;

public class Transaction {
    //Atributes
    public UserAccount outgoingAccount;
    public UserAccount incommingAccount;
    public float amountOfMoney;
    public LocalDateTime dateOfTransaction;
    //Konstructor
    public Transaction(UserAccount outgoingAccount, UserAccount incommingAccount, float amountOfMoney){
        this.outgoingAccount=outgoingAccount;
        this.incommingAccount=incommingAccount;
        outgoingAccount.outCome(amountOfMoney);
        incommingAccount.inCome(amountOfMoney);
        this.amountOfMoney = amountOfMoney;
        this.dateOfTransaction = LocalDateTime.now();
    }
    //Method

    public UserAccount getOutgoingAccount(){return outgoingAccount;}
    public UserAccount getIncommingAccount(){return incommingAccount;}
    public float getAmountOfMoney(){return amountOfMoney;}
    public LocalDateTime getDateOfTransaction(){return dateOfTransaction;}
}
