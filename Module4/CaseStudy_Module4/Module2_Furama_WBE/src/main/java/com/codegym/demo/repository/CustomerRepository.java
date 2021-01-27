package com.codegym.demo.repository;

import com.codegym.demo.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, String> {
   List<Customer> findAllByNameContainingAndAddress(String name, String address);
}
