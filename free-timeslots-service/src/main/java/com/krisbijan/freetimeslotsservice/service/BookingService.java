package com.krisbijan.freetimeslotsservice.service;

import com.krisbijan.freetimeslotsservice.model.Booking;
import com.krisbijan.freetimeslotsservice.model.Day;
import com.krisbijan.freetimeslotsservice.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    public Day findBookingsForDay(Integer year, Integer month, Integer day) {
        List<Booking> bookings = bookingRepository.findByYearAndMonthAndDay(year, month, day);
        return new Day(bookings,year,month,day);
    }
}
