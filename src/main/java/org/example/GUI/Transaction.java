package org.example.GUI;

import java.time.LocalDateTime;
import java.util.Random;

public class Transaction {
    //Atributes
    public UserAccount outgoingAccount;
    public UserAccount incommingAccount;
    public float amountOfMoney;
    public LocalDateTime dateOfTransaction;
    public String id;
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
    public String getId(){return  id;}
    public String generateIdOfTransaction(String outgoingAcc, String incommingAcc){
        String TRS ="TRS";
        StringBuilder outg = null;
        StringBuilder incg = null;
        String result;
        for (int i = 0 ; i < 3; i++){
            outg.append(outgoingAcc.charAt(i));
            incg.append(incommingAcc.charAt(i));
        }
        Random random = new Random();
        String number = String.valueOf(random.nextInt(99999 - 1));
        String id = TRS+outg+incg+number;
        if(!CollectionOfTransactions.isIdOccupied(id)){
            result = id;
        }else{
            result = null;
        }
        return result;
    }
}