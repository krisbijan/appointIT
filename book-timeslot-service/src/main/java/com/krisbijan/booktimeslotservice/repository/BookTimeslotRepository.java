package com.krisbijan.booktimeslotservice.repository;

import com.krisbijan.booktimeslotservice.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public interface BookTimeslotRepository extends JpaRepository<Booking,Integer> {


    List<Booking> findByYearAndMonthAndDay(Integer year, Integer month, Integer day);

    
}
