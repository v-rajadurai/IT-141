package com.example.springapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.springapp.model.Customer;
import com.example.springapp.service.CustomerService;

@RestController
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @PostMapping("/customer")

    public Customer postCustomer(@RequestBody Customer customer)
    {
        return customerService.saveCustomer(customer);
    }

    @GetMapping("/customers")
    public List<Customer> listCustomers()
    {
        return customerService.getCustomers();
    }
    
}
