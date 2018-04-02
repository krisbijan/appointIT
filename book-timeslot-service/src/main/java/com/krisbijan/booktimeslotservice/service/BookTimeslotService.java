package com.krisbijan.booktimeslotservice.service;

import com.krisbijan.booktimeslotservice.exceptions.InvalidTimeslotException;
import com.krisbijan.booktimeslotservice.model.Booking;
import com.krisbijan.booktimeslotservice.model.BookingHelper;
import com.krisbijan.booktimeslotservice.model.Day;
import com.krisbijan.booktimeslotservice.repository.BookTimeslotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookTimeslotService {
    @Autowired
    BookTimeslotsServiceProxy bookTimeslotsServiceProxy;

    @Autowired
    BookTimeslotRepository bookTimeslotRepository;


    public Booking bookTimeslot(Booking booking) throws InvalidTimeslotException {
        checkIfBookingLegal(booking);
        return bookTimeslotRepository.save(booking);
    }

    private void checkIfBookingLegal(Booking booking) throws InvalidTimeslotException {

        BookingHelper checkedBooking = new BookingHelper(booking);

        // web service invocation
        //List<Booking> bookings = bookTimeslotRepository.findByYearAndMonthAndDay(booking.getYear(),booking.getMonth(),booking.getDay());
        Day day = bookTimeslotsServiceProxy.getFreeTimeslots(booking.getYear(),booking.getMonth(),booking.getDay());
        List<Booking> bookings = day.getBookings();

        for (Booking b : bookings){

            BookingHelper bHelper = new BookingHelper(b);

            if (inBetween(checkedBooking.getFrom(),bHelper.getFrom(),bHelper.getTo()) || inBetween(checkedBooking.getTo(),bHelper.getFrom(),bHelper.getTo()))
                throw new InvalidTimeslotException("Assigned timeslot is not free or valid");
        }

    }

    private boolean inBetween (Integer in, Integer start, Integer end){

        if (in>=start && in<=end)
            return true;

        return false;
    }


}
