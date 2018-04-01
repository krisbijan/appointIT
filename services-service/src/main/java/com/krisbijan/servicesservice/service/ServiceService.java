package com.krisbijan.servicesservice.service;

import com.krisbijan.servicesservice.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceService {

    @Autowired
    ServiceRepository serviceRepository;

    public List<com.krisbijan.servicesservice.model.Service> getAllServices() {
        List<com.krisbijan.servicesservice.model.Service> services = serviceRepository.findAll();
        return services;
    }
}
