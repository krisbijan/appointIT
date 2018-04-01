package com.krisbijan.booktimeslotservice.controller;

import com.krisbijan.booktimeslotservice.exceptions.InvalidTimeslotException;
import com.krisbijan.booktimeslotservice.model.Booking;
import com.krisbijan.booktimeslotservice.service.BookTimeslotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookTimeslotController {

    @Autowired
    BookTimeslotService bookTimeslotService;

    @PostMapping("/book")
    public ResponseEntity<Booking> bookTimeslot(@RequestBody Booking booking) throws InvalidTimeslotException {
        Booking bookingOut = bookTimeslotService.bookTimeslot(booking);
        return new ResponseEntity<>(bookingOut,HttpStatus.CREATED);
    }
}
