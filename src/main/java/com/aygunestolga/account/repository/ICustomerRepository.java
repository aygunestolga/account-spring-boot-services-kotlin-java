package com.aygunestolga.account.repository;

import com.aygunestolga.account.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerRepository extends JpaRepository<Customer,String> {
}
