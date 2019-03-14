 package com.cg.BankCustomer.service;

import com.cg.BankCustomer.Bean.TransactionDetails;

public interface TransactionService {
     public double deposit(long accountNo);
     public double withdraw(long accountNo);
     public double showBalance(long accountNo);
     public TransactionDetails fundTransfer(long fromAccountNo,long toAccountNo);
}
