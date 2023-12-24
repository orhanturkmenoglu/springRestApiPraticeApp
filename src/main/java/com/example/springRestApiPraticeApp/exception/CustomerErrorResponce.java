package com.example.springRestApiPraticeApp.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerErrorResponce {
    private int status;
    private String message;
    private LocalDateTime dateTime;
}
