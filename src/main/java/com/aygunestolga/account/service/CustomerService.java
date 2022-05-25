package com.aygunestolga.account.service;


import com.aygunestolga.account.exception.CustomerNotFoundException;
import com.aygunestolga.account.model.Customer;
import com.aygunestolga.account.repository.ICustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    private final ICustomerRepository customerRepository;


    public CustomerService(ICustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }


    protected Customer findCustomerById(String id){
        return customerRepository
                .findById(id)
                .orElseThrow(
                        () -> new CustomerNotFoundException("Customer could not find by id" + id));
    }

}
