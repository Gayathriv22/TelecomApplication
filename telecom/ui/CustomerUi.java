package com.deloitte.telecom.ui;

import com.deloitte.telecom.dao.CustomerDaoImp;
import com.deloitte.telecom.entities.Customer;
import com.deloitte.telecom.service.CustomerServiceImp;
import com.deloitte.telecom.service.ICustomerService;

import java.util.*;

public class CustomerUi {
    private ICustomerService service = new CustomerServiceImp(new CustomerDaoImp());


    public static void main(String[] args) {
        CustomerUi ui = new CustomerUi();
        ui.menuUi();
        ui.runUi();
    }

    public void menuUi() {
        System.out.println("CUSTOMER MOBILE CARE ");
        System.out.println("********************");
        System.out.println("Choose any of the option to proceed");
        System.out.println("1.Account Balance Enquiry");
        System.out.println("2. Recharge account");
        System.out.println("3.Create Account");
        System.out.println("4.Exit");
        System.out.println("Choose an option");

    }

    public void runUi() {

        int choice = 0;
        for (int i = 0; i < 3; i++) {
            menuUi();
            Scanner sc = new Scanner(System.in);
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.println();
                    System.out.println("Enter the mobile number: ");
                    String ch;
                    ch = sc.next();
                    //service.findCustomerByMobile(ch);
                    Customer fetched1 = service.findCustomerByMobile(ch);

                    System.out.println("Welcome " + fetched1.getName() + " ! ");
                    System.out.println("Your balance is :" + fetched1.getBalance());
                    break;
                case 2:
                    System.out.println("Recharge account");
                    Customer recharged = service.RechargeAccount("9895426744", 900);
                    System.out.println("new balance is: " + recharged.getBalance());
                    break;
                case 3:
                    System.out.println("create the account");
                    Scanner sc1 = new Scanner(System.in);

                    //Customer c1 = new Customer("9895426744", "Mariam",9000);
                    //Customer c2 = new Customer("9999786123", "gv",8000);
                    service.addCustomer("9895426744", "Mariam", 9000);
                    //service.addCustomer(c2);
                    Set<Customer>cust1=service.allCustomers();
                    print(cust1);
                    break;
                case 4:
                    break;

                default:
                    System.out.println("please enter a valid option");
            }
        }
    }
    public void print(Collection<Customer>cus){
        for(Customer c:cus){
            System.out.println("Customer name :" +c.getName());
            System.out.println("Customer mobile no is :"+c.getMobile()+" balance is:" + c.getBalance());

        }

    }
}