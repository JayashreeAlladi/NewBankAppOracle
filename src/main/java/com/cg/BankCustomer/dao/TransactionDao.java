package com.cg.BankCustomer.dao;

import com.cg.BankCustomer.Bean.TransactionDetails;

public interface TransactionDao {
	 public double deposit(long accountNo);
     public double withdraw(long accountNo);
     public double showBalance(long accountNo);
     public TransactionDetails fundTransfer(long fromAccountNo,long toAccountNo);
}

