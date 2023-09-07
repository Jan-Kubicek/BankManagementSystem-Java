package org.example.Classes;

import java.util.ArrayList;

public class CollectionOfUsersAccounts {
    static ArrayList<UserAccount> collectionOfUsers = new ArrayList<>();

    static void addUser(UserAccount userAccount){ collectionOfUsers.add(userAccount);}
    static void removeUser(int index){ collectionOfUsers.remove(index); }
    static boolean isIdOccupied(String  idOfUser){
        boolean isIdOccupied = false;
        for(UserAccount userAccount : collectionOfUsers){
            if (userAccount.getID().equals(idOfUser)) {
                isIdOccupied = true;
                break;
            }
        }
        return isIdOccupied;
    }


}
