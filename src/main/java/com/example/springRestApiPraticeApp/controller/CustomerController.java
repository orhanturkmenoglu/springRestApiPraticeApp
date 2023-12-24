package com.example.springRestApiPraticeApp.controller;

import com.example.springRestApiPraticeApp.entity.Customer;
import com.example.springRestApiPraticeApp.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping("/customer")
    public void createCustomer(@RequestBody Customer customer){
        customerService.createCustomer(customer);
    }

    @GetMapping("/customerAll")
    public List<Customer> findCustomerAll(){
        return customerService.findCustomerAll();
    }

    @PutMapping("/updateCustomer")
    public void updateCustomer(@RequestBody Customer customer){
        customerService.updateCustomer(customer);
    }

    @DeleteMapping("/deleteCustomer/{customerId}")
    public void deleteCustomer(@PathVariable long customerId)
    {
        customerService.deleteCustomer(customerId);
    }

    @GetMapping("/customerById/{customerId}")
    public Customer findCustomerById(@PathVariable long customerId){
        return customerService.findCustomerById(customerId);
    }
}
