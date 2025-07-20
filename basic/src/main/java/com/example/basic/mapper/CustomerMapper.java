package com.example.basic.mapper;

import com.example.basic.dto.CustomerDto;
import com.example.basic.entity.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    @Mapping(target = "fullName", expression = "java(mapToName(customer))")
    CustomerDto mapToCustomerDto(Customer customer);

    Customer mapToCustomer(CustomerDto customerDto);

    default String mapToName(Customer customer) {
        return String.format("%s %s", customer.getFirstName(), customer.getLastName());
    }
}
