package org.example.GUI;

import java.util.ArrayList;

public class CollectionOfAdminAccounts {
    public static ArrayList<AdminAccount> collectionOfAdmins = new ArrayList<>();

    public static void addAdmin(AdminAccount adminAccount){ collectionOfAdmins.add(adminAccount);}
    public static void removeAdmin(int index){ collectionOfAdmins.remove( index);}
    public static boolean isIdOfAdminOccupied(String id){
        boolean isOccupied = false;
        for(AdminAccount adminAccount : collectionOfAdmins){
            if(adminAccount.getID().equals(id)){
                isOccupied = true;
                break;
            }
        }
        return isOccupied;
    }
    public static boolean adminLogin(String name, String password){
        boolean login = false;
        for(AdminAccount adminAccount : collectionOfAdmins){
            if(adminAccount.getName().equals(name)){
                if(adminAccount.getPassword().equals(password)){
                    login = true;
                }
            }
        }
        return login;
    }
}
