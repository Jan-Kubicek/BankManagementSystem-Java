package org.example.Classes;

import java.util.ArrayList;

public class CollectionOfAdminAccounts {
    static ArrayList<AdminAccount> collectionOfAdmins = new ArrayList<>();

    static void addAdmin(AdminAccount adminAccount){ collectionOfAdmins.add(adminAccount);}
    static void removeAdmin(int index){ collectionOfAdmins.remove( index);}
    static boolean isIdOfAdminOccupied(String id){
        boolean isOccupied = false;
        for(AdminAccount adminAccount : collectionOfAdmins){
            if(adminAccount.getID().equals(id)){
                isOccupied = true;
                break;
            }
        }
        return isOccupied;
    }
}
