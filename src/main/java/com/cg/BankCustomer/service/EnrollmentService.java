package com.cg.BankCustomer.service;

import com.cg.BankCustomer.Bean.CustomerDetails;

public interface EnrollmentService {
        public long register(CustomerDetails customerDetails);
        public CustomerDetails login(CustomerDetails customerDetails);
}
