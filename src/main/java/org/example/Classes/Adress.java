package org.example.Classes;

import org.example.Exceptions.OutOfRangeException;
import org.example.Exceptions.SameAtributeException;

public class Adress {
    //Atributes
    public String nameOfTown, street;
    public int numberOfHouse;
    //Konstruktors
    public Adress(String nameOfTown, String street, int numberOfHouse){
        this.nameOfTown = nameOfTown; this.street = street; this.numberOfHouse = numberOfHouse;
    }
    //Methods
    public void setNameOfTown(String newNameOfTown){
        try{
            if(newNameOfTown.length() < 2 || newNameOfTown.length() > 20){
                throw new OutOfRangeException();
            }
            if(this.nameOfTown.equals(newNameOfTown)){
                throw new SameAtributeException();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public String getNameOfTown(){ return nameOfTown;}

    public void setStreet(String newStreet){
        try{
            if(newStreet.length() < 3 || newStreet.length() > 30){
                throw new OutOfRangeException();
            }
            if(this.street.equals(newStreet)){
                throw new SameAtributeException();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public String getStreet(){return street;}

    public void setNumberOfHouse(int newNumberOfHouse){
        try {
            if(newNumberOfHouse == numberOfHouse){
                throw new SameAtributeException();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public int getNumberOfHouse(){return numberOfHouse;}
}
