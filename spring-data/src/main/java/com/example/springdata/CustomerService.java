package com.example.springdata;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {


    @Autowired
    CustomerRepository customerRepository;


    public void populateCustomerData(){
        customerRepository.save(new Customer("Jack"));
        customerRepository.save(new Customer("Chloe"));
        customerRepository.save(new Customer("Kim"));
        customerRepository.save(new Customer("David"));
        customerRepository.save(new Customer("Michelle"));
    }


    public List<Customer> getAllCustomers(){
        List<Customer> customerList = new ArrayList<>();

        customerRepository.findAll().forEach(customer -> customerList.add(customer));
        System.out.println(customerList.toArray());

        return customerList;
    }



}
