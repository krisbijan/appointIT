package com.krisbijan.booktimeslotservice.service;

import com.krisbijan.booktimeslotservice.exceptions.InvalidTimeslotException;
import com.krisbijan.booktimeslotservice.model.Booking;
import com.krisbijan.booktimeslotservice.model.BookingHelper;
import com.krisbijan.booktimeslotservice.repository.BookTimeslotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookTimeslotService {

    @Autowired
    BookTimeslotRepository bookTimeslotRepository;


    public Booking bookTimeslot(Booking booking) throws InvalidTimeslotException {
        checkIfBookingLegal(booking);
        return bookTimeslotRepository.save(booking);
    }

    private void checkIfBookingLegal(Booking booking) throws InvalidTimeslotException {

        BookingHelper checkedBooking = new BookingHelper(booking);

        List<Booking> bookings = bookTimeslotRepository.findByYearAndMonthAndDay(booking.getYear(),booking.getMonth(),booking.getDay());

        for (Booking b : bookings){

            BookingHelper bHelper = new BookingHelper(b);

            if (inBetween(checkedBooking.getFrom(),bHelper.getFrom(),bHelper.getTo()) || inBetween(checkedBooking.getTo(),bHelper.getFrom(),bHelper.getTo()))
                throw new InvalidTimeslotException();
        }

    }

    private boolean inBetween (Integer in, Integer start, Integer end){

        if (in>start && in<end)
            return true;

        return false;
    }


}
