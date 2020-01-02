package com.deloitte.telecom.dao;

import com.deloitte.telecom.entities.Customer;

import java.util.*;

public interface ICustomerDao {
    Customer addCustomer(String mobile, String name, double balance);

    Customer findCustomerByMobile(String mobile);
    Customer RechargeAccount(String mobile,double amount);
    Map<String,Customer>getStore();
    Set<Customer> allCustomers();
}
