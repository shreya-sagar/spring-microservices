package com.example.basic.service;

import com.example.basic.dto.CustomerDto;
import com.example.basic.entity.Customer;
import jakarta.validation.Valid;

public interface CustomerService {
    void createCustomer(CustomerDto customer);
    CustomerDto getCustomer(Long id);
    boolean patchCustomer(@Valid CustomerDto customer);
}
