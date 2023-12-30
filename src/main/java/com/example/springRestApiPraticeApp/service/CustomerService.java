package com.example.springRestApiPraticeApp.service;

import com.example.springRestApiPraticeApp.entity.Customer;
import com.example.springRestApiPraticeApp.exception.CustomerNotFoundException;
import com.example.springRestApiPraticeApp.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    public void createCustomer(Customer customer) {
        Optional<Customer> customerRepositoryById = customerRepository.findById(customer.getId());
        if (Objects.equals(customerRepositoryById,customer.getId()) || customerRepositoryById.get().getId()== customer.getId()){
            throw new  CustomerNotFoundException("Customer duplicated  for customer ");
        }

        customerRepository.save(customer);
    }

    public List<Customer> findCustomerAll() {
        return customerRepository.findAll();
    }


    public Customer findCustomerById(long customerId) {
        Optional<Customer> findById = customerRepository.findById(customerId);

        if (findById.isEmpty()) {
            throw new CustomerNotFoundException("NOT FOUND CUSTOMER ");
        }
        return findById.get();
    }

    public void updateCustomer(Customer customer) {
        Customer customerById = findCustomerById(customer.getId());
        if (Objects.isNull(customerById)) {
            throw new NullPointerException();
        }
        customerRepository.save(customer);
    }

    public void deleteCustomer(long customerId) {
        Customer customerById = findCustomerById(customerId);
        if (Objects.isNull(customerById)) {
            throw new NullPointerException();
        }
        customerRepository.deleteById(customerById.getId());
    }


}
