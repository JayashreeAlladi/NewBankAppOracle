package com.cg.BankCustomer.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.cg.BankCustomer.Bean.CustomerDetails;
import com.cg.BankCustomer.utility.DatabaseOConnection;

public class EnrollmentDaoImpl implements EnrollmentDao{
	Scanner sc=new Scanner(System.in);
   CustomerDetails customerDetails=new CustomerDetails();
   DatabaseOConnection databaseOConnection=new DatabaseOConnection();
	public long register(CustomerDetails customerDetails) {
		
		Connection connection=databaseOConnection.connect();
		try {
			PreparedStatement preparedStatement=connection.prepareStatement("insert into Customer_Details values(account_no.nextval,?,?,?,?,?,?,?,?,?)");
		    preparedStatement.setString(1, customerDetails.getFirstName());
		    preparedStatement.setString(2, customerDetails.getLastName());
		    preparedStatement.setString(3, customerDetails.getEmailId());
		    preparedStatement.setString(4, customerDetails.getPassword());
		    preparedStatement.setString(5, customerDetails.getPancardNo());
		    preparedStatement.setLong(6, customerDetails.getAadharNo());
		    preparedStatement.setString(7, customerDetails.getAddress());
		    preparedStatement.setLong(8, customerDetails.getMobileNo());
		    preparedStatement.setDouble(9, customerDetails.getBalance());
		    
		    int i=preparedStatement.executeUpdate();
			if (i==1) {
				System.out.println("Registered successfully with account number"+customerDetails.getAccountNo());
			} else {
				System.err.println("Enter proper details");
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// TODO Auto-generated method stub
		return customerDetails.getAccountNo();
	}

	public CustomerDetails login(long account_no) {
		// TODO Auto-generated method stub
		Connection connection=databaseOConnection.connect();
		
		Statement statement;
		try {
			statement = connection.createStatement();
			ResultSet rs=statement.executeQuery("select * from Customer_Details");
			while(rs.next())
			{
				
				if(rs.getLong(9)==customerDetails.getAccountNo() && rs.getString(8).equals(customerDetails.getPassword()))
				{
			         
					break;
				}
				
			}
	    }catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   	
        return customerDetails;
   }
}
