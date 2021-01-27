package com.codegym.demo.service;

import com.codegym.demo.model.Customer;
import com.codegym.demo.model.CustomerType;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CustomerTypeService {
    List<CustomerType>findAll();
    void save(CustomerType customerType);
    void update(CustomerType customerType);
    void delete(String id);
    CustomerType findById(String id);

}
