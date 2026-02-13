package com.echapps.customerbankapi.customer.repository;

import com.echapps.customerbankapi.customer.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
