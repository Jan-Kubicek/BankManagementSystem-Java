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
    public String firstName, lastName, degree;

    //Konstructors
    public UserAccount(String firstName, String lastName, String degree, String email, LocalDateTime since, String telephoneNumber, String password, String sex, LocalDateTime dateOfBirth, boolean darkMode, int pinCode){
        this.Email = email; this.since = since; this.telephoneNumber = telephoneNumber; this.password = password; this.sex = sex; this.dateOfBirth = dateOfBirth; this.darkMode = darkMode; this.accountPinCode = pinCode;
        this.firstName = firstName; this.lastName = lastName; this.degree = degree;
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

    public void outCome(double amount) throws OutOfRangeException {
            if(amount > financialLimits){
                throw new OutOfRangeException();
            }else{
                accountBalance -= amount;
            }
    }

    public void setFinancialLimits(float financialLimits) throws OutOfRangeException {
             if(this.financialLimits == financialLimits){
                 throw new OutOfRangeException();
             }
             else{
                 this.financialLimits = financialLimits;
             }
    }

    public float getFinancialLimits(){return financialLimits;}
    public float getAccountBalance(){return accountBalance;}

    public void setAccountPinCode(int newPinCode) throws SameAtributeException, OutOfRangeException {
            if(accountPinCode == newPinCode){
                throw new SameAtributeException();
            }
            if(newPinCode > 9999){
                throw new OutOfRangeException();
            }
            else{this.accountPinCode = newPinCode;}

    }
    public int getAccountPinCode(){return accountPinCode;}

    public void setDarkMode(boolean darkMode) throws SameAtributeException {
            if(this.darkMode == darkMode){
                throw new SameAtributeException();
            }else{
                this.darkMode = darkMode;
            }
    }

    public boolean getDarkMode(){return darkMode;}

    @Override
    public void setName(String newName) throws SameAtributeException, OutOfRangeException {
            if(this.name.equals(newName)){
                throw new SameAtributeException();
            }
            if(newName.length()  < 5 || newName.length() > 45){
                throw new OutOfRangeException();
            }
            else{this.name = newName;}
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setEmail(String newEmail) throws SameAtributeException, OutOfRangeException, IllegalArgumentException {
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
    }

    @Override
    public String getEmail() {
        return Email;
    }

    @Override
    public void setID(String newID) throws SameAtributeException, OutOfRangeException {
            if(ID.equals(newID)){
                throw new SameAtributeException();
            }
            if(newID.length() != 12){
                throw new OutOfRangeException();
            }
            else{
                this.ID = newID;
            }
    }

    @Override
    public String getID() {
        return ID;
    }

    @Override
    public void setSince(LocalDateTime newSince) throws SameAtributeException {
            if(since.toString().equals(newSince.toString())){
                throw new SameAtributeException();
            }
            else{this.since = newSince;}
    }

    @Override
    public LocalDateTime getSince() {
        return since;
    }

    @Override
    public void setTelephoneNumber(String newTelephoneNumber) throws SameAtributeException, OutOfRangeException {
            if(this.telephoneNumber.equals(newTelephoneNumber)){
                throw new SameAtributeException();
            }
            if(newTelephoneNumber.length() != 9){
                throw new OutOfRangeException();
            }
            else{
                this.telephoneNumber = newTelephoneNumber;
            }
    }

    @Override
    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    @Override
    public void setPassword(String newPassword) throws SameAtributeException {
            if(password.equals(newPassword)){
                throw new SameAtributeException();
            }
            else {
                this.password = newPassword;
            }
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public void setSex(String newSex) throws SameAtributeException {
               if(sex.equals(newSex)){
                   throw new SameAtributeException();
               }
               else{
                   this.sex = newSex;
               }
    }

    @Override
    public String getSex() {
        return sex;
    }

    @Override
    public void setDateOfBirth(LocalDateTime newDateOfBirth) throws SameAtributeException {
                if(this.dateOfBirth.toString().equals(newDateOfBirth.toString())){
                    throw new SameAtributeException();
                }
                else{
                    this.dateOfBirth = newDateOfBirth;
                }
    }

    @Override
    public LocalDateTime getDateOfBirth() {
        return dateOfBirth;
    }

    @Override
    public void setAccountAdress(Adress newAdress) throws SameAtributeException {
                if(accountAdress.toString().equals(newAdress.toString())){
                    throw new SameAtributeException();
                }
                else{
                    this.accountAdress = newAdress;
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
