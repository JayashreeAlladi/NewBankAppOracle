package com.cg.BankCustomer.dao;

import com.cg.BankCustomer.Bean.CustomerDetails;

public interface EnrollmentDao {
	 public long register(CustomerDetails customerDetails);
     public void login(long account_no);
}
