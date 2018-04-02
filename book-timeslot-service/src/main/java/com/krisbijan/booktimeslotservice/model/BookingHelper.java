package com.krisbijan.booktimeslotservice.model;

public class BookingHelper {

    private Integer from;
    private  Integer to;

    public BookingHelper(Booking booking){
        this.from = booking.getFromHour()*60+booking.getFromMin();
        this.to = booking.getToHour()*60+booking.getToMin();
    }

    public Integer getFrom() {
        return from;
    }

    public void setFrom(Integer from) {
        this.from = from;
    }

    public Integer getTo() {
        return to;
    }

    public void setTo(Integer to) {
        this.to = to;
    }
}
