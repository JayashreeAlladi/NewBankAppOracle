
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
	
        public static void main(String[] args) {
        	 TransactionService transactionService = new TransactionServiceImpl();

        	Scanner sc=new Scanner(System.in);
        while(true) {	
        	System.out.println("=====Banking Application By Oracle=======");
        	System.out.println("1.Registration\n 2.Login \n3.Exit");
        	int choice=sc.nextInt();
          switch(choice) {
          case 1:
        	  System.out.println("=======Registration/Enrollment======");
        	 
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
 			 
 			 
 			 customerDetails.setBalance(0);
 			 
 			 long accountNo= enrollment.register(customerDetails);
 			 break;
               
        	 
          case 2:
        	 System.out.println("===Login Page===");
    		 System.out.println("Enter account number");
    		 customerDetails.setAccountNo(sc.nextLong());
    		 System.out.println("Enter password");
    		 customerDetails.setPassword(sc.next());
    		 customerDetails=enrollment.login(customerDetails);
    			
    		 do
    		 {
    		
        	  System.out.println("=================Transaction phase=============");
        	  System.out.println("1.deposit\n 2.withdraw \n3.showbalance\n 4.fund transfer \n5.exit");
        	  int n1=sc.nextInt();
        	  CustomerDetails customerDetails1=new CustomerDetails();
        		switch(n1) {
        		case 1:
      			  System.out.println("===deposit=== ");
    				System.out.println("Enter deposit amount");
				     double amount1=sc.nextDouble();
					customerDetails1 = transactionService.deposit(customerDetails1,amount1);
      			  
      			  break;
      			  
      		  case 2:
      			  System.out.println("===withdraw===");
      			  System.err.println(customerDetails1.getAccountNo());
						System.out.println("Enter withdraw amount");
						double amount=sc.nextDouble();
						
						customerDetails1 = transactionService.withdraw(customerDetails,amount);
						System.out.println("Remaining balance: "+customerDetails1.getBalance());
        		      
        		      break;
        		      
      		  case 3:
      			  System.out.println("===Show Balance===");
      			  customerDetails1 = transactionService.showBalance(customerDetails);
						System.out.println("Your balance is: "+customerDetails1.getBalance());
        		      
        		      break;
        		      
      		  case 4:
      			  System.out.println("===Fund Transfer===");
      			  System.out.println("Enter the fund amount to transfer");
					  double amount2=sc.nextDouble();
					  System.out.println("Enter the account number to which fund has to be transferred");
      			 // long accountNo=sc.nextLong();
      			  long AccountNo2=sc.nextLong();
      			  long previousAccount = customerDetails1.getAccountNo();
						customerDetails1 = transactionService.withdraw(customerDetails1,amount2);
						customerDetails1.setAccountNo(previousAccount);
						customerDetails1 = transactionService.deposit(customerDetails1,amount2);
						customerDetails1.setAccountNo(AccountNo2);
				//	transaction.fundTransfer(accountNo, AccountNo2);
						transactionDetails.setFromAccountNo(previousAccount);
						transactionDetails.setToAccountNo(AccountNo2);
					//	transactionDetails.setAmountTransfered(customerDetails1.getAmount());
      		  case 5:
      			  System.exit(0);
        		}
    		 }while(customerDetails!=null) ;
        	case 3:
        		System.exit(0);
        		
        	}
         }
    }   
}
