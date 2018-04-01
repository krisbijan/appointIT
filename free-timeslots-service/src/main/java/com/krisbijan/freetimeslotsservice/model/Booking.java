package com.krisbijan.freetimeslotsservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.List;

@Table
@Entity
public class Booking implements Comparable<Booking>{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonIgnore
	private Integer id;

	@Column
	@Min(2018)
	@Max(2019)
	private Integer year;
	@Column
	@Min(1)
	@Max(12)
	private Integer month;
	@Column
	@Min(1)
	@Max(31)
	private Integer day;
	@Column
	@Min(0)
	@Max(23)
	private Integer fromHour;
	@Column
	@Min(0)
	@Max(59)
	private Integer fromMin;
	@Column
	@Min(0)
	@Max(23)
	private Integer toHour;
	@Column
	@Min(0)
	@Max(59)
	private Integer toMin;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

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

	public Integer getFromHour() {
		return fromHour;
	}

	public void setFromHour(Integer fromHour) {
		this.fromHour = fromHour;
	}

	public Integer getToHour() {
		return toHour;
	}

	public void setToHour(Integer toHour) {
		this.toHour = toHour;
	}

	public Integer getFromMin() {
		return fromMin;
	}

	public void setFromMin(Integer fromMin) {
		this.fromMin = fromMin;
	}

	public Integer getToMin() {
		return toMin;
	}

	public void setToMin(Integer toMin) {
		this.toMin = toMin;
	}

	public Booking(@Min(2018) @Max(2019) Integer year, @Min(1) @Max(12) Integer month, @Min(1) @Max(31) Integer day, @Min(0) @Max(23) Integer fromHour, @Min(0) @Max(59) Integer fromMin, @Min(0) @Max(23) Integer toHour, @Min(0) @Max(59) Integer toMin) {
		this.year = year;
		this.month = month;
		this.day = day;
		this.fromHour = fromHour;
		this.toHour = toHour;
		this.fromMin = fromMin;
		this.toMin = toMin;
	}

	public Booking() {
	}

	@Override
	public int compareTo(Booking o) {
		if(this.fromHour==o.fromHour && this.toHour==o.toHour && this.fromMin==o.fromMin && this.toMin==o.toMin)
			return 0;
		else if ((this.fromHour<o.fromHour) || (this.fromHour==o.fromHour && this.fromMin<o.fromMin))
			return -1;
		else
			return 1;
	}
}
