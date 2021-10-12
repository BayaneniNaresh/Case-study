package com.flightSerachMicroservice.mongoDB.model;



import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

@Document(collection="flights")
public class flights {
	@Id
	private String flightId;
	private String flightName;
	private String from;
	private String to;
	private double fare;
	private String date;
	
	
	public String getDate() {
		return date;
	}
	public void setdate(String date) {
		this.date = date;
	}
	public String getFlightId() {
		return flightId;
	}
	public void setFlightId(String flightId) {
		this.flightId = flightId;
	}
	public String getFlightName() {
		return flightName;
	}
	public void setFlightName(String flightName) {
		this.flightName = flightName;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public double getFare() {
		return fare;
	}
	public void setFare(double fare) {
		this.fare = fare;
	}
	public flights(String flightId, String flightName, String from, String to, double fare, String date) {
		super();
		this.flightId = flightId;
		this.flightName = flightName;
		this.from = from;
		this.to = to;
		this.fare = fare;
		this.date = date;
	}
	
}
