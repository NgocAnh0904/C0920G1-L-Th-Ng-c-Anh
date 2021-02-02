package com.codegym.demo.service;

import com.codegym.demo.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

public interface CustomerService {
    Page<Customer>  findCustomer(Pageable pageable);

    Customer findById(String id);

    void save(Customer customer);
    void update(Customer customer);
    void delete(String id);
    Page<Customer> findAllByCustomer_nameContaining(Pageable pageable, String searchName);
}
