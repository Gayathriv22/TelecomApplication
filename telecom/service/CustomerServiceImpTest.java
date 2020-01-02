package com.deloitte.telecom.service;

import com.deloitte.telecom.dao.CustomerDaoImp;
import com.deloitte.telecom.entities.Customer;
import org.junit.Test;
import org.junit.*;
import java.util.*;

public class CustomerServiceImpTest {
    @Test
    public void testCreateAccount(){
        CustomerServiceImp service =new CustomerServiceImp(new CustomerDaoImp());
        String mobile="9894673241";
        double balance=1000;
        String name="satya";
        Customer customer =service.addCustomer(mobile,name,balance);
        Assert.assertNotNull(customer);
        double resultBalance=customer.getBalance();
        Assert.assertEquals(balance,resultBalance,0);
        Assert.assertEquals(name,customer.getName());
        Map<String,Customer>store=service.getCustomer().getStore();
        Customer expected=store.get(mobile);
        Assert.assertNotNull(expected);
        Assert.assertEquals(expected,customer);
    }
    @Test
    public void testFindCustomerByMobile(){
        CustomerServiceImp service =new CustomerServiceImp(new CustomerDaoImp());
        String mobile="9894673241";
        double balance=1000;
        String name="satya";
        Customer customer =service.addCustomer(mobile,name,balance);
        Map<String,Customer>store=service.getCustomer().getStore();
        store.put(mobile,customer);
        Customer result=service.getCustomer(mobile);
        Assert.assertEquals(customer,result);
    }
}
