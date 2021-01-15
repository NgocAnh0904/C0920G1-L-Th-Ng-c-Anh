package com.codegym.cms.repository;

import com.codegym.cms.model.Customer;
import org.springframework.data.repository.PagingAndSortingRepository;

//public interface CustomerRepository extends Repository<Customer> {
public interface CustomerRepository extends PagingAndSortingRepository<Customer, Long> {
    Customer findOne(Long id);

    void delete(Long id);

    Customer findById(Long id);

    void remove(Long id);
}
