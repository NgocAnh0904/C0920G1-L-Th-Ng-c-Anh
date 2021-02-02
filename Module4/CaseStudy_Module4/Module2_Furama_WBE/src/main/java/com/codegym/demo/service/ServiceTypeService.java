package com.codegym.demo.service;

import com.codegym.demo.model.ServiceType;

import java.util.List;

public interface ServiceTypeService {
    List<ServiceType> findAll();

    void save(ServiceType serviceType);

    void update(ServiceType serviceType);

    void delete(Long id);

    ServiceType findById(Long id);
}
