package com.deloitte.telecom.service;

import com.deloitte.telecom.dao.ICustomerDao;
import com.deloitte.telecom.entities.Customer;

import java.util.*;

public interface ICustomerService {
    Customer addCustomer(String mobile, String name, double balance);

    Customer findCustomerByMobile(String mobile);

    Customer RechargeAccount(String mobile, double amount);

    Set<Customer> allCustomers();
    ICustomerDao getCustomer();

}

