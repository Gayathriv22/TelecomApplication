package com.deloitte.telecom.service;

import com.deloitte.telecom.dao.ICustomerDao;
import com.deloitte.telecom.entities.Customer;

import java.util.*;

public class CustomerServiceImp implements ICustomerService {
    private ICustomerDao dao;

    public CustomerServiceImp(ICustomerDao dao) {
        this.dao = dao;
    }

    @Override
    public Customer addCustomer(String mobile, String name, double balance) {
      Customer c=  dao.addCustomer(mobile,name,balance);
      return c;

    }

    @Override
    public Customer RechargeAccount(String mobile, double amount) {
        Customer c=dao.RechargeAccount(mobile,amount);
        return c;
    }

    @Override
    public Customer findCustomerByMobile(String mobile) {
        // dao.findCustomerByMobile(mobile);
        Customer c = dao.findCustomerByMobile(mobile);
        return c;
    }

    @Override
    public Set<Customer> allCustomers() {
        Set<Customer> customers = dao.allCustomers();
        return customers;
    }

    @Override
    public ICustomerDao getCustomer() {
        return dao;
    }
}
