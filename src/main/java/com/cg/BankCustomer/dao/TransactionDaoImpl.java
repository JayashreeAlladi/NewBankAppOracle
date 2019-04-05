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
    TransactionDetails transactionDetails=new TransactionDetails();
    CustomerDetails customerDetails=new CustomerDetails();
	
    public CustomerDetails withdraw(CustomerDetails customerDetails,double amount) {
		// TODO Auto-generated method stub
		try {
			 Connection connection=databaseOConnection.connect();
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from customer_details");
			int count = 0;
			while (rs.next()) {
				if (rs.getLong(1) == customerDetails.getAccountNo()) {
					double balance = customerDetails.getBalance();
					if (balance >= amount) {
						
						try {
							PreparedStatement preparedStatement = connection.prepareStatement("update CUSTOMER_DETAILS set balance = ? where account_no = ?");
							balance = balance-amount;
							customerDetails.setBalance(balance);
							preparedStatement.setDouble(1, customerDetails.getBalance());
							preparedStatement.setLong(2, customerDetails.getAccountNo());
							preparedStatement.executeUpdate();
							
							count++;
							break;
						} catch (SQLException e) {
//							e.printStackTrace();
						}	
					}
					
				}
			}
			connection.close();
			if (count != 1) {
				customerDetails.setFirstName(null);
			}
			// connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return customerDetails;
		
	}

	public CustomerDetails deposit(CustomerDetails customerDetails,double amount) {
		// TODO Auto-generated method stub
		double balance = customerDetails.getBalance();
		//System.out.println(amount);
		
		 Connection connection=databaseOConnection.connect();
		try {
			PreparedStatement ps = connection.prepareStatement("update customer_details set balance= ? where account_no=?");
			balance =balance+amount;
			customerDetails.setBalance(balance);
		 //	System.out.println("my account num is : "+customerDetails.getAccountNo());
			ps.setDouble(1, balance);
			ps.setLong(2, customerDetails.getAccountNo());
			int x = ps.executeUpdate();
		
			if(x==1) {
				System.out.println("updated successfully");
			}
			else
				System.out.println("not updated");
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return customerDetails;
	}

	public CustomerDetails showBalance(CustomerDetails customerDetails) {
		// TODO Auto-generated method stub
		//System.out.println("balance before connecting to db.."+customerDetails.getBalance());
		 Connection connection=databaseOConnection.connect();
		ResultSet resultSet;
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("select * from CUSTOMER_DETAILS where account_no = ?");
			
			preparedStatement.setLong(1,customerDetails.getAccountNo());
			resultSet = preparedStatement.executeQuery();
			resultSet.next();
			customerDetails.setBalance(resultSet.getDouble(10));
			connection.close();
		} catch (SQLException e) {
		}
		return customerDetails;
	}

	public TransactionDetails fundTransfer(long fromAccountNo, long toAccountNo) {
		// TODO Auto-generated method stub
		//ResultSet resultSet;
		 Connection connection=databaseOConnection.connect();
		try {
			PreparedStatement preparedStatement=connection.prepareStatement("insert into TRANSACTION_DETAILS values(TRANSACTION_ID.nextval,?,?,?)");
	        preparedStatement.setLong(1,transactionDetails.getFromAccountNo() );
	        preparedStatement.setLong(2, transactionDetails.getToAccountNo());
	        preparedStatement.setDouble(3, transactionDetails.getAmountTransfered());
	        int i=preparedStatement.executeUpdate();
	        if(i==1) {
	        	System.out.println("fund transferred");;
	        }
	        connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return transactionDetails;
	}

	

}
