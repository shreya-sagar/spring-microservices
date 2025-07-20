package com.example.basic.service;

import com.example.basic.dto.CustomerDto;
import com.example.basic.entity.Customer;
import com.example.basic.exception.CustomerAlreadyExistsException;
import com.example.basic.exception.ResourceNotFoundException;
import com.example.basic.mapper.CustomerMapper;
import com.example.basic.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    @Override
    public void createCustomer(CustomerDto customerDto) {
        Optional<Customer> optionalCustomer = customerRepository.findByMobile(customerDto.getMobile());
        if(optionalCustomer.isPresent()){
            throw new CustomerAlreadyExistsException("Customer already registered with given mobile "
                    + customerDto.getMobile());
        }
        Customer customer = customerMapper.mapToCustomer(customerDto);
        customerRepository.save(customer);
    }

    @Override
    public CustomerDto getCustomer(Long id) {
        Customer customer = customerRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Customer", "id", id.toString())
        );
        return customerMapper.mapToCustomerDto(customer);
    }

    @Override
    public boolean patchCustomer(CustomerDto customerDto) {
        Customer customer = customerRepository.findById(customerDto.getId()).orElseThrow(
                () -> new ResourceNotFoundException("Customer", "id", customerDto.getId().toString())
        );
        customerMapper.mapToCustomer(customerDto);
        customerRepository.save(customer);
        return true;
    }
}
