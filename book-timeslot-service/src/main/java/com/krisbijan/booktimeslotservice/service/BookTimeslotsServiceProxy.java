package com.krisbijan.booktimeslotservice.service;

import com.krisbijan.booktimeslotservice.model.Day;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(name="free-timeslots-service",url="localhost:7000")
//@FeignClient(name="free-timeslots-service")
@FeignClient(name="zuul-api-gateway")
@RibbonClient(name="free-timeslots-service")
public interface BookTimeslotsServiceProxy {

    @GetMapping("/free-timeslots-service/bookings/{year}/{month}/{day}")
    public Day getFreeTimeslots ( @PathVariable("year") Integer year, @PathVariable("month") Integer month, @PathVariable("day") Integer day);
}
