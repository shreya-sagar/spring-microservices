package com.example.basic.dto;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Builder
@Data
public class ErrorResponseDto {
    private String path;
    private HttpStatus errorCode;
    private String errorMessage;
    private LocalDateTime errorTimestamp;
}
