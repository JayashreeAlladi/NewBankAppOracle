package com.cg.BankCustomer.service;

import com.cg.BankCustomer.Bean.CustomerDetails;
import com.cg.BankCustomer.Exceptionhandle.NoAccountException;
import com.cg.BankCustomer.dao.EnrollmentDao;
import com.cg.BankCustomer.dao.EnrollmentDaoImpl;

public class EnrollmentServiceImpl implements EnrollmentService{
     EnrollmentDao enrollmentDao=new EnrollmentDaoImpl();
	public long register(CustomerDetails customerDetails) {
		// TODO Auto-generated method stub
		long accountNo=enrollmentDao.register(customerDetails);
		
		if(accountNo==0) {
			try {
				throw new NoAccountException();
			} catch (NoAccountException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return accountNo;
	}

	public CustomerDetails login(CustomerDetails customerDetails) {
		
		// TODO Auto-generated method stub
		
		return enrollmentDao.login(customerDetails);
	}

}
