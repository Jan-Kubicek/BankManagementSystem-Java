package org.example.Classes;

import java.time.LocalDateTime;

abstract class Account {
    //Atributy
        public String name, ID, Email, password, telephoneNumber, sex;
        LocalDateTime since, dateOfBirth;
        Adress accountAdress;

    //Konstruktory

    //Metody
    public abstract void setName(String newName);
    public abstract String getName();
    public abstract void setEmail(String newEmail);
    public abstract String getEmail();
    public abstract void setID(String newID);
    public abstract String getID();
    public abstract void setSince(LocalDateTime newSince);
    public abstract LocalDateTime getSince();
    public abstract void setTelephoneNumber(String newTelephoneNumber);
    public abstract String getTelephoneNumber();
    public abstract void setPassword(String newPassword);
    public abstract String getPassword();
    public abstract void setSex(String newSex);
    public abstract String getSex();
    public abstract void setDateOfBirth(LocalDateTime newDateOfBirth);
    public abstract LocalDateTime getDateOfBirth();
    public abstract void setAccountAdress(Adress newAdress);
    public abstract Adress getAccountAdress();
}
