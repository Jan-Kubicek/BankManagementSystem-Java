package org.example.GUI;

import org.example.Exceptions.OutOfRangeException;
import org.example.Exceptions.SameAtributeException;

import java.time.LocalDateTime;

abstract class Account {
    //Atributy
        public String name, ID, Email, password, telephoneNumber, sex;
        LocalDateTime since, dateOfBirth;
        Adress accountAdress;

    //Konstruktory

    //Metody
    public abstract void setName(String newName) throws SameAtributeException, OutOfRangeException;
    public abstract String getName();
    public abstract void setEmail(String newEmail) throws SameAtributeException, OutOfRangeException;
    public abstract String getEmail();
    public abstract void setID(String newID) throws SameAtributeException, OutOfRangeException;
    public abstract String getID();
    public abstract void setSince(LocalDateTime newSince) throws SameAtributeException;
    public abstract LocalDateTime getSince();
    public abstract void setTelephoneNumber(String newTelephoneNumber) throws SameAtributeException, OutOfRangeException;
    public abstract String getTelephoneNumber();
    public abstract void setPassword(String newPassword) throws SameAtributeException;
    public abstract String getPassword();
    public abstract void setSex(String newSex) throws SameAtributeException;
    public abstract String getSex();
    public abstract void setDateOfBirth(LocalDateTime newDateOfBirth) throws SameAtributeException;
    public abstract LocalDateTime getDateOfBirth();
    public abstract void setAccountAdress(Adress newAdress) throws SameAtributeException;
    public abstract Adress getAccountAdress();
}
