package com.cg.BankCustomer.UI;

import java.util.Scanner;

import com.cg.BankCustomer.Bean.CustomerDetails;
import com.cg.BankCustomer.Bean.TransactionDetails;
import com.cg.BankCustomer.service.EnrollmentService;
import com.cg.BankCustomer.service.EnrollmentServiceImpl;

import com.cg.BankCustomer.service.TransactionService;
import com.cg.BankCustomer.service.TransactionServiceImpl;

public class MainUI {
	static CustomerDetails customerDetails=new CustomerDetails();
	static TransactionDetails transactionDetails=new TransactionDetails();
	static EnrollmentService enrollment=new EnrollmentServiceImpl();
	static TransactionService transaction=new TransactionServiceImpl();
        public static void main(String[] args) {
        	Scanner sc=new Scanner(System.in);
        	System.out.println("=====Banking Application By Oracle=======");
        	System.out.println("1.Trasaction\n 2.Enrollment \n3.Exit");
        	int choice=sc.nextInt();
        	switch(choice) {
        	case 1:
        	  System.out.println("=======Transaction phase=====");
        	  int n=sc.nextInt();
        	  
        	  
        		 switch(n) {
        		  case 1:
        			  System.out.println("===deposit=== ");
        			  System.out.println("Enter account number");
        			  long accountNo=sc.nextLong();
          		      customerDetails.setAccountNo(accountNo);
        			  transaction.deposit(accountNo);
        			  break;
        			  
        		  case 2:
        			  System.out.println("===withdraw===");
        			  System.out.println("Enter account number");
        			  //long accountNo=sc.nextLong();
          		      customerDetails.setAccountNo(accountNo);
          		      transaction.withdraw(accountNo);
          		      break;
          		      
        		  case 3:
        			  System.out.println("===Show Balance===");
        			  System.out.println("Enter account number");
          		      customerDetails.setAccountNo(accountNo);
          		      transaction.showBalance(accountNo);
          		      break;
          		      
        		  case 4:
        			  System.out.println("===Fund Transfer===");
        			  long AccountNo2=sc.nextLong();
        			  transaction.fundTransfer(accountNo, AccountNo2);
        			  
        		  }
        	  break;
        	case 2:
        	  System.out.println("======Enrollment phase======");
        	  int n1=sc.nextInt();
        		switch(n1) {
        		case 1:
        			 System.out.println("===Registration Page===");
        			 System.out.println("enter first name");
        			 String firstName=sc.next();
        			 customerDetails.setFirstName(firstName);
        			 
        			 System.out.println("enter last name");
        			 String lastName=sc.next();
        			 customerDetails.setLastName(lastName);
        			 
        			 System.out.println("enter email");
        			 String emailId=sc.next();
        			 customerDetails.setEmailId(emailId);
        			 
        			 System.out.println("enter password");
        			 String password=sc.next();
        			 customerDetails.setPassword(password);
        			 
        			 System.out.println("enter pancard number");
        			 String pancardNo=sc.next();
        			 customerDetails.setPancardNo(pancardNo);
        			 
        			 System.out.println("enter aadhar number");
        			 long aadharNo=sc.nextLong();
        			 customerDetails.setAadharNo(aadharNo);
        			 
        			 System.out.println("enter address");
        			 String address=sc.next();
        			 customerDetails.setAddress(address);
        			 
        			 System.out.println("enter mobile number");
        			 long mobileNo=sc.nextLong();
        			 customerDetails.setMobileNo(mobileNo);
        			 
        			 System.out.println("enter balance");
        			 double balance=sc.nextDouble();
        			 customerDetails.setBalance(balance);
        			 
        			 long accountNo= enrollment.register(customerDetails);
        			 break;
        		case 2:
        			System.out.println("===Login Page===");
        			System.out.println("Enter account number");
        			customerDetails.setAccountNo(sc.nextLong());
        			System.out.println("Enter password");
        			customerDetails.setPassword(sc.next());
        			
        			customerDetails=enrollment.login(accountNo);
        		}
        	case 3:
        		System.exit(0);
        		
        	}
        }
}