package org.example.Classes;

import org.example.Exceptions.OutOfRangeException;

import java.time.LocalDateTime;

final class UserAccount extends Account{
    //Atributes
    private float accountBalance;
    private int accountPinCode;
    private boolean darkMode;
    private float financialLimits;

    //Konstructors
    public UserAccount(String name, String email, String id, LocalDateTime since, String telephoneNumber, String password, String sex, LocalDateTime dateOfBirth, boolean darkMode, int pinCode){
        this.name = name; this.Email = email; this.ID = id; this.since = since; this.telephoneNumber = telephoneNumber; this.password = password; this.sex = sex; this.dateOfBirth = dateOfBirth; this.darkMode = darkMode; this.accountPinCode = pinCode;
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

    @Override
    public void setName(String newName) {

    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public void setEmail(String newEmail) {

    }

    @Override
    public String getEmail() {
        return null;
    }

    @Override
    public void setID(String newID) {

    }

    @Override
    public String getID() {
        return null;
    }

    @Override
    public void setSince(LocalDateTime newSince) {

    }

    @Override
    public LocalDateTime getSince() {
        return null;
    }

    @Override
    public void setTelephoneNumber(String newTelephoneNumber) {

    }

    @Override
    public String getTelephoneNumber() {
        return null;
    }

    @Override
    public void setPassword(String newPassword) {

    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public void setSex(String newSex) {

    }

    @Override
    public String getSex() {
        return null;
    }

    @Override
    public void setDateOfBirth(LocalDateTime newDateOfBirth) {

    }

    @Override
    public LocalDateTime getDateOfBirth() {
        return null;
    }

    @Override
    public void setAccountAdress(Adress newAdress) {

    }

    @Override
    public Adress getAccountAdress() {
        return null;
    }
}
