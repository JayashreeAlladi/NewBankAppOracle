package com.cg.BankCustomer.Exceptionhandle;

public class NoAccountException extends Exception{
    public void NoAccountException() {
    	System.out.println("Account does not exists");
    }
}
