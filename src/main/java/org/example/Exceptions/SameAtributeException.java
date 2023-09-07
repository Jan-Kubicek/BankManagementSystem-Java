package org.example.Exceptions;

public class SameAtributeException extends Exception {
    public SameAtributeException(){
        super("Value is same as old one !!");
    }
}
