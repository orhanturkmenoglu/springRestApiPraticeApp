package com.example.springRestApiPraticeApp.controller;

import com.example.springRestApiPraticeApp.entity.Customer;
import com.example.springRestApiPraticeApp.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping("/customerAll")
    public List<Customer> findCustomerAll(){
        return customerService.findCustomerAll();
    }
}
