package com.cg.BankCustomer.dao;

import com.cg.BankCustomer.Bean.CustomerDetails;
import com.cg.BankCustomer.Bean.TransactionDetails;

public interface TransactionDao {
	public CustomerDetails deposit(CustomerDetails customerDetails);
     public CustomerDetails withdraw(CustomerDetails customerDetails);
     public CustomerDetails showBalance(CustomerDetails customerDetails);
     public TransactionDetails fundTransfer(long fromAccountNo,long toAccountNo);
	
}

