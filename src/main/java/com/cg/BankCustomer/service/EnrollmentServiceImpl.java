package com.cg.BankCustomer.service;

import com.cg.BankCustomer.Bean.CustomerDetails;
import com.cg.BankCustomer.Exceptionhandle.NoAccountException;
import com.cg.BankCustomer.dao.EnrollmentDao;
import com.cg.BankCustomer.dao.EnrollmentDaoImpl;

public class EnrollmentServiceImpl implements EnrollmentService{
     EnrollmentDao enrollmentDao=new EnrollmentDaoImpl();
	public long register(CustomerDetails customerDetails) {
		// TODO Auto-generated method stub
		long account_no=enrollmentDao.register(customerDetails);
		return account_no;
		
	}

	public CustomerDetails login(CustomerDetails customerDetails) {
		
		// TODO Auto-generated method stub
		enrollmentDao.login(customerDetails);
		return customerDetails;
	}

}
