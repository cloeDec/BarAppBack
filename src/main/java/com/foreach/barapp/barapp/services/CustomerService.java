package com.foreach.barapp.barapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foreach.barapp.barapp.models.Customer;
import com.foreach.barapp.barapp.repository.CustomerRepository;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Customer getCustomerById(int id) {
        return customerRepository.findById(id).get();
    }

    public Customer saveCustomer(Customer Customer) {
        return customerRepository.save(Customer);
    }

    public void deleteCustomer(int id) {
        customerRepository.deleteById(id);
    }
}
