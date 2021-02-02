package com.codegym.demo.repository;

import com.codegym.demo.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


import java.util.List;
@EnableJpaRepositories
public interface CustomerRepository extends JpaRepository<Customer, String> {
//   List<Customer> findAllByNameContainingAndAddress(String name, String address);
   Page<Customer> findByCustomerNameContaining(Pageable pageable, String searchName);
}
