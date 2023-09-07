package org.example.GUI;

import org.example.Exceptions.OutOfRangeException;
import org.example.Exceptions.SameAtributeException;

import java.time.LocalDateTime;
import java.util.Random;

final class UserAccount extends Account{
    //Atributes
    private float accountBalance;
    private int accountPinCode;
    private boolean darkMode;
    private float financialLimits;

    //Konstructors
    public UserAccount(String firstName, String lastName, String degree, String email, LocalDateTime since, String telephoneNumber, String password, String sex, LocalDateTime dateOfBirth, boolean darkMode, int pinCode){
        this.Email = email; this.since = since; this.telephoneNumber = telephoneNumber; this.password = password; this.sex = sex; this.dateOfBirth = dateOfBirth; this.darkMode = darkMode; this.accountPinCode = pinCode;
        this.name = degree+" "+firstName+" "+lastName;
        this.ID = generateIdForUser(firstName,lastName);
        this.accountBalance = 0;
        this.financialLimits = 5000; // Standart financial limit for OutCome => it could be changed
        //Adress must be added manually => Adress must be initialized seperated and after that connected;
    }

    //Methods
    public void inCome(double amount){
        accountBalance += amount;
    }

    public void outCome(double amount){
        try{
            if(amount > financialLimits){
                throw new OutOfRangeException();
            }else{
                accountBalance -= amount;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void setFinancialLimits(float financialLimits){
        try{
             if(this.financialLimits == financialLimits){
                 throw new OutOfRangeException();
             }
             else{
                 this.financialLimits = financialLimits;
             }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public float getFinancialLimits(){return financialLimits;}
    public float getAccountBalance(){return accountBalance;}

    public void setAccountPinCode(int newPinCode){
        try{
            if(accountPinCode == newPinCode){
                throw new SameAtributeException();
            }
            if(newPinCode > 9999){
                throw new OutOfRangeException();
            }
            else{this.accountPinCode = newPinCode;}
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public int getAccountPinCode(){return accountPinCode;}

    public void setDarkMode(boolean darkMode){
        try{
            if(this.darkMode == darkMode){
                throw new SameAtributeException();
            }else{
                this.darkMode = darkMode;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public boolean getDarkMode(){return darkMode;}

    @Override
    public void setName(String newName) {
        try{
            if(this.name.equals(newName)){
                throw new SameAtributeException();
            }
            if(newName.length()  < 5 || newName.length() > 45){
                throw new OutOfRangeException();
            }
            else{this.name = newName;}
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setEmail(String newEmail) {
        try{
            if(this.Email.equals(newEmail)){
                throw new SameAtributeException();
            }
            if(newEmail.length() < 4 || newEmail.length() > 30 ){
                throw new OutOfRangeException();
            }
            if(!newEmail.contains("@")){
                throw new IllegalArgumentException();
            }
            else{
                this.Email = newEmail;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public String getEmail() {
        return Email;
    }

    @Override
    public void setID(String newID) {
        try{
            if(ID.equals(newID)){
                throw new SameAtributeException();
            }
            if(newID.length() != 12){
                throw new OutOfRangeException();
            }
            else{
                this.ID = newID;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public String getID() {
        return ID;
    }

    @Override
    public void setSince(LocalDateTime newSince) {
        try{
            if(since.toString().equals(newSince.toString())){
                throw new SameAtributeException();
            }
            else{this.since = newSince;}
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public LocalDateTime getSince() {
        return since;
    }

    @Override
    public void setTelephoneNumber(String newTelephoneNumber) {
        try{
            if(this.telephoneNumber.equals(newTelephoneNumber)){
                throw new SameAtributeException();
            }
            if(newTelephoneNumber.length() != 9){
                throw new OutOfRangeException();
            }
            else{
                this.telephoneNumber = newTelephoneNumber;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    @Override
    public void setPassword(String newPassword) {
        try{
            if(password.equals(newPassword)){
                throw new SameAtributeException();
            }
            else {
                this.password = newPassword;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public void setSex(String newSex) {
        try{
               if(sex.equals(newSex)){
                   throw new SameAtributeException();
               }
               else{
                   this.sex = newSex;
               }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public String getSex() {
        return sex;
    }

    @Override
    public void setDateOfBirth(LocalDateTime newDateOfBirth) {
        try{
                if(this.dateOfBirth.toString().equals(newDateOfBirth.toString())){
                    throw new SameAtributeException();
                }
                else{
                    this.dateOfBirth = newDateOfBirth;
                }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public LocalDateTime getDateOfBirth() {
        return dateOfBirth;
    }

    @Override
    public void setAccountAdress(Adress newAdress) {
        try{
                if(accountAdress.toString().equals(newAdress.toString())){
                    throw new SameAtributeException();
                }
                else{
                    this.accountAdress = newAdress;
                }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public Adress getAccountAdress() {
        return accountAdress;
    }

    public String generateIdForUser(){
        String us ="US";
        String[] tokens = name.split("");           //Degree + FirstName + LastName
        StringBuilder first = new StringBuilder();
        for ( int i = 0; i < 3;  i++){
            first.append(tokens[1].charAt(i));
        }
        StringBuilder second= new StringBuilder();
        for(int i = 0 ; i < 2; i++){
            second.append(tokens[2].charAt(i));
        }
        String number;
        Random randomNumber = new Random();
        number = String.valueOf(randomNumber.nextInt(99999 - 1));
        String result;
        String id = us+first+second+number;
        if(!CollectionOfUsersAccounts.isIdOccupied(id)){
            result = id.toUpperCase();
        }
        else { result = null; }
        return result;
    }
    public String generateIdForUser(String firstName, String lastName){
        String us = "US";
        String result;
        StringBuilder first = new StringBuilder();
        for ( int i = 0; i < 3;  i++){
            first.append(firstName.charAt(i));
        }
        StringBuilder second= new StringBuilder();
        for(int i = 0 ; i < 2; i++){
            second.append(lastName.charAt(i));
        }
        String number;
        Random randomNumber = new Random();
        number = String.valueOf(randomNumber.nextInt(99999 - 1));
        String id = us+first+second+number;
        if(!CollectionOfUsersAccounts.isIdOccupied(id)){
            result = id.toUpperCase();
        }
        else { result = null; }
       return result;
    }
}
