package com.krisbijan.freetimeslotsservice.controller;

import com.krisbijan.freetimeslotsservice.model.Booking;
import com.krisbijan.freetimeslotsservice.model.Day;
import com.krisbijan.freetimeslotsservice.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @GetMapping("/bookings/{year}/{month}/{day}")
    public ResponseEntity<Day> findBookingsForDay(@PathVariable Integer day, @PathVariable Integer month, @PathVariable Integer year){
        Day dayOut = bookingService.findBookingsForDay(year, month, day);
        return new ResponseEntity<>(dayOut,HttpStatus.OK );
    }

}
