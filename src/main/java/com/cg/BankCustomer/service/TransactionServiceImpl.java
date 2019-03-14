package com.cg.BankCustomer.service;

import org.omg.IOP.TransactionService;

import com.cg.BankCustomer.Bean.CustomerDetails;
import com.cg.BankCustomer.Bean.TransactionDetails;
import com.cg.BankCustomer.dao.TransactionDao;
import com.cg.BankCustomer.dao.TransactionDaoImpl;

public class TransactionServiceImpl implements TransactionService{
    TransactionDao transactionDao=new TransactionDaoImpl();
	public CustomerDetails deposit(CustomerDetails customerDetails) {
		
		// TODO Auto-generated method stub
		
	 customerDetails=transactionDao.deposit(customerDetails);
		return customerDetails;
	}

	public CustomerDetails withdraw(CustomerDetails customerDetails) {
		
		// TODO Auto-generated method stub
		customerDetails=transactionDao.withdraw(customerDetails);
		return customerDetails;
	}

	public CustomerDetails showBalance(CustomerDetails customerDetails) {
		
		// TODO Auto-generated method stub
		customerDetails=transactionDao.showBalance(customerDetails);
		return customerDetails;
	}

	public TransactionDetails fundTransfer(long fromAccountNo, long toAccountNo) {
		// TODO Auto-generated method stub
		TransactionDetails transactionDetails=transactionDao.fundTransfer(fromAccountNo, toAccountNo);
		return transactionDetails;
	}

}
