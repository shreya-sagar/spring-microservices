package com.example.basic.dto;

import com.example.basic.entity.BaseEntity;
import com.example.basic.entity.Product;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Builder
@Data
public class CustomerDto extends BaseEntity {
    private Long id;
    private String firstName;
    private String middleName;
    private String lastName;
    private String fullName;
    private LocalDate birthDate;

    @Email(message = "Email must be in valid format")
    private String email;

    @Size(min = 10, max = 20, message = "Mobile Number should have 10-20 characters")
    private String mobile;

    private List<Product> children;
}
