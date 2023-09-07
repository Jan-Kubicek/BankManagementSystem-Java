package org.example.GUI;

import java.util.ArrayList;

public class CollectionOfTransactions {
    public static ArrayList<Transaction> collectionOfTransactions = new ArrayList<>();
    public static void addTransaction(Transaction transaction){collectionOfTransactions.add(transaction);}
    public static void removeTransaction(int index){collectionOfTransactions.remove(index);}
    public static boolean isIdOccupied(String id){
        boolean isOccupied = false;
        for(Transaction transaction : collectionOfTransactions){
            if(transaction.getId().equals(id)){
                isOccupied = true;
                break;
            }
        }
        return isOccupied;
    }

}
