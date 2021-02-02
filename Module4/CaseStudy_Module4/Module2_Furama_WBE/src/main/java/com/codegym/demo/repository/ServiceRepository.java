package com.codegym.demo.repository;

import com.codegym.demo.model.Service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ServiceRepository extends JpaRepository<Service, Long> {
    Page<Service> findByName(Pageable pageable, String name);
}
