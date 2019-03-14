package com.cg.BankCustomer.service;

import org.omg.IOP.TransactionService;

import com.cg.BankCustomer.Bean.TransactionDetails;
import com.cg.BankCustomer.dao.TransactionDao;
import com.cg.BankCustomer.dao.TransactionDaoImpl;

public class TransactionServiceImpl implements TransactionService{
    TransactionDao transactionDao=new TransactionDaoImpl();
	public double deposit(long accountNo) {
		
		// TODO Auto-generated method stub
		
		double balance=transactionDao.deposit(accountNo);
		return balance;
	}

	public double withdraw(long accountNo) {
		return null;
		// TODO Auto-generated method stub
		
	}

	public double showBalance(long accountNo) {
		return null;
		// TODO Auto-generated method stub
		
	}

	public TransactionDetails fundTransfer(long fromAccountNo, long toAccountNo) {
		// TODO Auto-generated method stub
		return null;
	}

}
