package com.krisbijan.servicesservice.repository;

import com.krisbijan.servicesservice.model.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface ServiceRepository extends JpaRepository<Service,Integer> {
}
