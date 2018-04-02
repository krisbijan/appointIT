package com.krisbijan.booktimeslotservice.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Day {

	private Integer year;

	private Integer month;

	private Integer day;

	private List<Booking> bookings;

	private List<Booking> freeTimeslots;

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Integer getMonth() {
		return month;
	}

	public void setMonth(Integer month) {
		this.month = month;
	}

	public Integer getDay() {
		return day;
	}

	public void setDay(Integer day) {
		this.day = day;
	}

	public List<Booking> getBookings() {
		return bookings;
	}

	public void setBookings(List<Booking> bookings) {
		this.bookings = bookings;
	}

	public List<Booking> getFreeTimeslots() {
		return freeTimeslots;
	}

	public void setFreeTimeslots(List<Booking> freeTimeslots) {
		this.freeTimeslots = freeTimeslots;
	}

	public Day() {
	}

	public Day(List<Booking> bookings, Integer year, Integer month, Integer day) {
		Collections.sort(bookings);
		this.bookings= bookings;
		this.year=year;
		this.month=month;
		this.day=day;
		this.freeTimeslots=new ArrayList<Booking>();
		makeFreeTimeslots();
	}

	private void makeFreeTimeslots() {
		if (bookings==null || bookings.size()==0){
			freeTimeslots.add(new Booking(year, month,day,0,0,23,59));
			return;
		}

		for (int i=0;i<bookings.size();i++){
			Booking thisBooking = bookings.get(i);
			Booking nextBooking = new Booking(year,month,day,23,59,23,59);

			if (i+1<bookings.size())
				nextBooking = bookings.get(i+1);

			if (i==0){
				Booking freeTimeslot = new Booking();
				freeTimeslot.setYear(year);
				freeTimeslot.setMonth(month);
				freeTimeslot.setDay(day);
				freeTimeslot.setFromHour(0);
				freeTimeslot.setFromMin(0);
				freeTimeslot.setToHour(thisBooking.getFromHour());
				freeTimeslot.setToMin(thisBooking.getFromMin());
				if (!(freeTimeslot.getToHour()==0 && freeTimeslot.getToMin()==0))
					freeTimeslots.add(freeTimeslot);
			}


			Booking freeTimeslot = new Booking();
			freeTimeslot.setYear(year);
			freeTimeslot.setMonth(month);
			freeTimeslot.setDay(day);
			freeTimeslot.setFromHour(thisBooking.getToHour());
			freeTimeslot.setFromMin(thisBooking.getToMin());
			freeTimeslot.setToHour(nextBooking.getFromHour());
			freeTimeslot.setToMin(nextBooking.getFromMin());

			if(thisBooking.getToHour()!=nextBooking.getFromHour() || thisBooking.getToMin()!=nextBooking.getFromMin())
				freeTimeslots.add(freeTimeslot);


		}
	}
}
