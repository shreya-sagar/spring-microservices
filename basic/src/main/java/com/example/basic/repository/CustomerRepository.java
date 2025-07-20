package com.example.basic.repository;

import com.example.basic.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    //List<Customer> getCustomersByMobile(String mobile);
    Optional<Customer> findByMobile(String mobile);
}
