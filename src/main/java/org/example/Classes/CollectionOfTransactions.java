package org.example.Classes;

import java.util.ArrayList;

public class CollectionOfTransactions {
    static ArrayList<Transaction> collectionOfTransactions = new ArrayList<>();
    static void addTransaction(Transaction transaction){collectionOfTransactions.add(transaction);}
    static void removeTransaction(int index){collectionOfTransactions.remove(index);}
    static boolean isIdOccupied(String id){
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
