package com.codegym.demo.service;

import com.codegym.demo.model.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ServiceService {
    List<Service> findAll();
    Page<Service> findAll(Pageable pageable);

    void save(Service service);

    void update(Service service);
    void delete(Long id);
    Service findById(Long id);

    Page<Service> findAllByServiceNameContaining(Pageable pageable, String nameSearch);
}

