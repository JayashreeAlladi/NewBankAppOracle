package com.cg.BankCustomer.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.cg.BankCustomer.Bean.CustomerDetails;
import com.cg.BankCustomer.Bean.TransactionDetails;
import com.cg.BankCustomer.utility.DatabaseOConnection;

public class TransactionDaoImpl implements TransactionDao{
    DatabaseOConnection databaseOConnection=new DatabaseOConnection();
    Connection connection=databaseOConnection.connect();
    TransactionDetails transactionDetails=new TransactionDetails();
    CustomerDetails customerDetails=new CustomerDetails();
	public CustomerDetails withdraw(CustomerDetails customerDetails) {
		// TODO Auto-generated method stub
		Statement statement;
		try {
			statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from CUSTOMER_DETAILS");
			int count = 0;
			while (rs.next()) {
				if (rs.getInt(1) == customerDetails.getAccountNo()) {
					double balance = customerDetails.getBalance();
					if (balance >= customerDetails.getAmount()) {
						balance = balance-customerDetails.getAmount();
						try {
							PreparedStatement preparedStatement = connection.prepareStatement("update CUSTOMER_DETAILS set balance = ? where account_no = ?");
							preparedStatement.setDouble(1, customerDetails.getBalance());
							preparedStatement.setLong(2, customerDetails.getAccountNo());
							preparedStatement.executeUpdate();
							customerDetails.setBalance(balance);
							count++;
							break;
						} catch (SQLException e) {
//							e.printStackTrace();
						}	
					}
					
				}
			}
			if (count != 1) {
				customerDetails.setFirstName(null);
			}
			// connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return customerDetails;
		
	}

	public CustomerDetails deposit(CustomerDetails customerDetails) {
		// TODO Auto-generated method stub
		double balance = customerDetails.getBalance();
		balance =balance+ customerDetails.getAmount();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("update CUSTOMER_DETAILS set balance = ? where account_no = ?");
			preparedStatement.setDouble(1, customerDetails.getBalance());
			preparedStatement.setLong(2, customerDetails.getAccountNo());
			preparedStatement.executeUpdate();
			customerDetails.setBalance(balance);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return customerDetails;
	}

	public CustomerDetails showBalance(CustomerDetails customerDetails) {
		// TODO Auto-generated method stub
		ResultSet resultSet;
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("select balance from CUSTOMER_DETAILS where account_no = ?");
			preparedStatement.setLong(1,customerDetails.getAccountNo());
			resultSet = preparedStatement.executeQuery();
			resultSet.next();
			customerDetails.setBalance(resultSet.getInt(10));
		} catch (SQLException e) {
		}
		return customerDetails;
	}

	public TransactionDetails fundTransfer(long fromAccountNo, long toAccountNo) {
		// TODO Auto-generated method stub
		//ResultSet resultSet;
		try {
			PreparedStatement preparedStatement=connection.prepareStatement("insert into TRANSACTION_DETAILS values(TRANSACTION_ID.nextval,?,?,?)");
	        preparedStatement.setLong(1,transactionDetails.getFromAccountNo() );
	        preparedStatement.setLong(2, transactionDetails.getToAccountNo());
	        preparedStatement.setDouble(3, transactionDetails.getAmountTransfered());
	        int i=preparedStatement.executeUpdate();
	        if(i==1) {
	        	return transactionDetails;
	        }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return transactionDetails;
	}

	

}
