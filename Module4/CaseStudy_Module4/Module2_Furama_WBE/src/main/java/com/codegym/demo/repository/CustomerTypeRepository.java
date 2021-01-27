package com.codegym.demo.repository;

import com.codegym.demo.model.CustomerType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerTypeRepository extends JpaRepository<CustomerType, String> {

}
