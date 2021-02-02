package com.codegym.demo.service.impl;

import com.codegym.demo.model.CustomerType;
import com.codegym.demo.repository.CustomerTypeRepository;
import com.codegym.demo.service.CustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerTypeServiceImpl implements CustomerTypeService {
    @Autowired
    CustomerTypeRepository customerTypeRepository;

    @Override
    public List<CustomerType> findAll() {
        return customerTypeRepository.findAll();
    }

    @Override
    public void save(CustomerType customerType) {
        customerTypeRepository.save(customerType);
    }

    @Override
    public void update(CustomerType customerType) {
        customerTypeRepository.save(customerType);
    }

    @Override
    public void delete(String id) {
        customerTypeRepository.deleteById(id);
    }

    @Override
    public CustomerType findById(String id) {
        return customerTypeRepository.findById(id).orElse(null);
    }

}
