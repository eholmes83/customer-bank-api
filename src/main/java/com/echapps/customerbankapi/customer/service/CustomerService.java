package com.echapps.customerbankapi.customer.service;

import com.echapps.customerbankapi.customer.model.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> getAllCustomers();
    void createCustomer(Customer customer);
    void deleteCustomer(Long id);
    void updateCustomer(Customer customer, Long customerId);
}
