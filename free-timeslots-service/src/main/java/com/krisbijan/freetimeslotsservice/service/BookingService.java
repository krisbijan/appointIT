package com.krisbijan.freetimeslotsservice.service;

import com.krisbijan.freetimeslotsservice.model.Booking;
import com.krisbijan.freetimeslotsservice.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    public List<Booking> findBookingsForDay( Integer year,  Integer month,  Integer day) {
        return bookingRepository.findByYearAndMonthAndDay(year, month, day);
    }
}
