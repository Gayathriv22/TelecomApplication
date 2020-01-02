package com.deloitte.telecom.dao;

import com.deloitte.telecom.entities.Customer;
import com.deloitte.telecom.exceptions.CustomerNotFoundException;
import com.deloitte.telecom.exceptions.MobileNumberNotFoundException;

import java.util.*;

public class CustomerDaoImp implements ICustomerDao {
    private Map<String, Customer> store = new HashMap<>();

    @Override
    public Customer addCustomer(String mobile, String name, double balance) {
        Customer c = new Customer(mobile, name, balance);
        store.put(c.getMobile(), c);
        return c;
    }

    @Override
    public Customer findCustomerByMobile(String mobile) {
        if (store.get(mobile) == null) {
            throw new MobileNumberNotFoundException("mobile number is not found " + mobile);
        }
        Customer c = store.get(mobile);

        return c;
    }

    @Override
    public Set<Customer> allCustomers() {
        Collection<Customer> customers = store.values();
        Set<Customer> customerSet = new HashSet<>(customers);
        return customerSet;

    }

    @Override
    public Customer RechargeAccount(String mobile, double amount) {
        Customer c = store.get(mobile);
        if (c == null) {
            throw new CustomerNotFoundException("Customer is not found" + mobile);
        }
        double bal = c.getBalance();
        bal = bal + amount;
        c.setBalance(bal);
        return c;
    }

    @Override
    public Map<String, Customer> getStore() {
        return store;
    }
}
