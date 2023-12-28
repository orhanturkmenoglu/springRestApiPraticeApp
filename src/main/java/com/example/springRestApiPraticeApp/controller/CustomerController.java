package com.example.springRestApiPraticeApp.controller;

import com.example.springRestApiPraticeApp.entity.Customer;
import com.example.springRestApiPraticeApp.exception.CustomerNotFoundException;
import com.example.springRestApiPraticeApp.exception.CustomerSuccessResponse;
import com.example.springRestApiPraticeApp.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping("/customer")
    public ResponseEntity<Void> createCustomer(@RequestBody Customer customer) {

        if (Objects.isNull(customer)) {
            throw new NullPointerException("Customer cannot be null");
        }
        customerService.createCustomer(customer);
        return CustomerSuccessResponse.responseBuilder("Customer created successfully", HttpStatus.CREATED);
    }

    @GetMapping("/customerAll")
    public ResponseEntity<List<Customer>> findCustomerAll() {
        List<Customer> customerAll = customerService.findCustomerAll();
        return CustomerSuccessResponse.responseBuilder("Customer list successfully", HttpStatus.OK, customerAll);
    }

    @PutMapping("/updateCustomer")
    public ResponseEntity<Void> updateCustomer(@RequestBody Customer customer) {
        if (Objects.isNull(customer)) {
            throw new NullPointerException("Customer cannot be null");
        }
        customerService.updateCustomer(customer);
        return CustomerSuccessResponse.responseBuilder("Customer updated successfully", HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteCustomer/{customerId}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable long customerId) {
        customerService.deleteCustomer(customerId);
        return CustomerSuccessResponse.responseBuilder("Customer deleted successfully", HttpStatus.OK);
    }

    @GetMapping("/customerById/{customerId}")
    public Customer findCustomerById(@PathVariable long customerId) {
        Customer customerById = customerService.findCustomerById(customerId);

        if (Objects.isNull(customerById)) {
            throw new CustomerNotFoundException("Customer not found by id: " + customerId);
        }
        return CustomerSuccessResponse.responseBuilder("Customer found successfully",HttpStatus.OK,customerById).getBody();
    }
}
