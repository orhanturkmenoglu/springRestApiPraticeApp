package com.example.springRestApiPraticeApp.service;

import com.example.springRestApiPraticeApp.entity.Customer;
import com.example.springRestApiPraticeApp.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    public List<Customer> findCustomerAll() {
        return customerRepository.findAll();
    }
}
