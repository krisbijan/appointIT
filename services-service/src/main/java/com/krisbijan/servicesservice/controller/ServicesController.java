package com.krisbijan.servicesservice.controller;

import com.krisbijan.servicesservice.model.Service;
import com.krisbijan.servicesservice.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ServicesController {

    @Autowired
    ServiceService serviceService;

    @GetMapping("/services")
    public ResponseEntity<List<Service>> getAllServices(){
        List<Service> services = serviceService.getAllServices();
        return new ResponseEntity<>(services,HttpStatus.OK);
    }
}
