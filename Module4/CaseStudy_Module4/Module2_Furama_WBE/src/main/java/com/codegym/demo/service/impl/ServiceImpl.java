package com.codegym.demo.service.impl;

import com.codegym.demo.model.Service;
import com.codegym.demo.repository.ServiceRepository;
import com.codegym.demo.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
@org.springframework.stereotype.Service
public class ServiceImpl implements ServiceService {

    final
    ServiceRepository serviceRepository;

    public ServiceImpl(ServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

    @Override
    public List<Service> findAll() {
        return serviceRepository.findAll();
    }

    @Override
    public Page<Service> findAll(Pageable pageable) {
        return serviceRepository.findAll(pageable);
    }

    @Override
    public void save(Service service) {
        serviceRepository.save(service);
    }

    @Override
    public void update(Service service) {
        serviceRepository.save(service);
    }

    @Override
    public void delete(Long id) {
        this.serviceRepository.deleteById(id);
    }

    @Override
    public Service findById(Long id) {
        return serviceRepository.findById(id).orElse(null);
    }

    @Override
    public Page<Service> findAllByServiceNameContaining(Pageable pageable, String nameSearch) {
        return serviceRepository.findByName(pageable, nameSearch);
    }
}
