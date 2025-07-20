package com.example.basic.controller;

import com.example.basic.dto.CustomerDto;
import com.example.basic.dto.ResponseDto;
import com.example.basic.service.CustomerService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/customer", produces = {MediaType.APPLICATION_JSON_VALUE})
@Validated
@AllArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

    @GetMapping
    public String healthCheck(){
        return "Basic Microservices is up and running!";
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDto> getCustomer(@PathVariable Long id){
        CustomerDto customerDto = customerService.getCustomer(id);
        return ResponseEntity.status(HttpStatus.OK).body(customerDto);
    }

    @PostMapping
    public ResponseEntity<ResponseDto> addCustomer(@Valid @RequestBody CustomerDto customer){
       customerService.createCustomer(customer);
       return ResponseEntity.status(HttpStatus.CREATED).body(
               ResponseDto.builder()
                       .status(HttpStatus.CREATED)
                       .message("Customer added successfully!")
                       .build()
       );
    }

    @PatchMapping
    public ResponseEntity<ResponseDto> patchCustomer(@Valid @RequestBody CustomerDto customer){
        boolean patch = customerService.patchCustomer(customer);
        if (patch) {
            return ResponseEntity.status(HttpStatus.OK).body(
                ResponseDto.builder()
                        .status(HttpStatus.OK)
                        .message("Customer updated successfully!")
                        .build());
        } else {
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(
                    ResponseDto.builder()
                            .status(HttpStatus.EXPECTATION_FAILED)
                            .message("Failed to update Customer!")
                            .build());
        }
    }
}
