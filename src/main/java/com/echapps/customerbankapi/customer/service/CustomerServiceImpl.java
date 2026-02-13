package com.echapps.customerbankapi.customer.service;

import com.echapps.customerbankapi.customer.model.Customer;
import com.echapps.customerbankapi.customer.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public void createCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void deleteCustomer(Long id) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer with id: " + id + " not found"));
        customerRepository.delete(customer);
    }

    @Override
    public void updateCustomer(Customer customer, Long customerId) {
        Customer updatedCustomer = customerRepository.findById(customerId)
                .orElseThrow(() -> new RuntimeException("Customer with id: " + customerId + " not found"));

        updatedCustomer.setFirstName(customer.getFirstName());
        updatedCustomer.setLastName(customer.getLastName());
        updatedCustomer.setEmail(customer.getEmail());
        updatedCustomer.setPhoneNumber(customer.getPhoneNumber());

        customerRepository.save(updatedCustomer);
    }

}
