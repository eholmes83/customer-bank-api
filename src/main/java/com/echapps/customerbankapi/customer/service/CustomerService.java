package com.echapps.customerbankapi.customer.service;

import com.echapps.customerbankapi.customer.model.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    List<Customer> getAllCustomers();
    Customer createCustomer(Customer customer);
    void deleteCustomer(Long id);
    Customer updateCustomer(Customer customer, Long customerId);
    Optional<Customer> getCustomerById(Long customerId);
}
