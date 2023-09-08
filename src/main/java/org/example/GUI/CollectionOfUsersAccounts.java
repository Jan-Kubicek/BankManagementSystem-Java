package org.example.GUI;

import java.util.ArrayList;

public class CollectionOfUsersAccounts {
    public static ArrayList<UserAccount> collectionOfUsers = new ArrayList<>();

    public static void addUser(UserAccount userAccount){ collectionOfUsers.add(userAccount);}
    public static void removeUser(int index){ collectionOfUsers.remove(index); }
    public static boolean isIdOccupied(String  idOfUser){
        boolean isIdOccupied = false;
        for(UserAccount userAccount : collectionOfUsers){
            if (userAccount.getID().equals(idOfUser)) {
                isIdOccupied = true;
                break;
            }
        }
        return isIdOccupied;
    }

    public static UserAccount findUserById(String id){
        int idnex = -1;
        for(int i = 0; i < collectionOfUsers.size(); i++){
            if(collectionOfUsers.get(i).ID.equals(id)){
                idnex = i;
            }
        }
        return collectionOfUsers.get(idnex);
    }

    public static boolean userLogin(String name, String password){
        boolean login = false;
        for(UserAccount userAccount : collectionOfUsers){
            if(userAccount.getName().equals(name)){
                if(userAccount.getPassword().equals(password)){
                    login = true;
                }
            }
        }
        return login;
    }

}
