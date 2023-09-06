package org.example.Classes;

import org.example.Exceptions.OutOfRangeException;
import org.example.Exceptions.SameAtributeException;

import java.time.LocalDateTime;

final class UserAccount extends Account{
    //Atributes
    private float accountBalance;
    private int accountPinCode;
    private boolean darkMode;
    private float financialLimits;

    //Konstructors
    public UserAccount(String firstName, String lastName, String degree, String email, String id, LocalDateTime since, String telephoneNumber, String password, String sex, LocalDateTime dateOfBirth, boolean darkMode, int pinCode){
        this.Email = email; this.ID = id; this.since = since; this.telephoneNumber = telephoneNumber; this.password = password; this.sex = sex; this.dateOfBirth = dateOfBirth; this.darkMode = darkMode; this.accountPinCode = pinCode;
        this.name = degree+" "+firstName+" "+lastName;
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

    }

    @Override
    public LocalDateTime getSince() {
        return since;
    }

    @Override
    public void setTelephoneNumber(String newTelephoneNumber) {

    }

    @Override
    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    @Override
    public void setPassword(String newPassword) {

    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public void setSex(String newSex) {

    }

    @Override
    public String getSex() {
        return sex;
    }

    @Override
    public void setDateOfBirth(LocalDateTime newDateOfBirth) {

    }

    @Override
    public LocalDateTime getDateOfBirth() {
        return dateOfBirth;
    }

    @Override
    public void setAccountAdress(Adress newAdress) {

    }

    @Override
    public Adress getAccountAdress() {
        return accountAdress;
    }

    public String generateIdForUser(){
        String us ="US";
            //TODO PARSING of name to xxx of firstname xx of last name and random 5 digite Number
            //Try to find someone with same id if => yes = new id if => no set this ID
        String id = "";
        return id;
    }
}
