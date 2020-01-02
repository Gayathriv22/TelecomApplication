package com.deloitte.telecom.entities;


import java.util.*;


public class Customer {
    private String mobile;
    private String name;
    private double balance;

    public Customer() {

    }

    public Customer(String mobile, String name, double balance) {
        this.mobile = mobile;
        this.name = name;
        this.balance = balance;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
