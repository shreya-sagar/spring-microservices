package com.example.basic.dto;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Builder
@Data
public class ResponseDto {
    private HttpStatus status;
    private String message;
}
