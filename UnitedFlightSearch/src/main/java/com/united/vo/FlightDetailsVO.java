package com.united.vo;

import java.util.Date;

/*
 *   {
    "flightNumber": "2005",
    "carrier": "UA",
    "origin": "IAH",
    "departure": "2018-01-31T05:10:00",
    "destination": "ORD",
    "arrival": "2018-01-31T07:57:00",
    "aircraft": "Airbus A320",
    "distance": 925,
    "travelTime": "02:47",
    "status": "Arrived at Gate"

  },
 */

@SuppressWarnings("unused")
public class FlightDetailsVO {

	private String flightNumber;
	private String carrier;
	private String origin;
	private String departure;
	private String destination;
	private String arrival;
	private String aircraft;
	private Integer distance;
	private Date travelTime;
	private String status;
	/**
	 * @return the flightNumber
	 */
	public String getFlightNumber() {
		return flightNumber;
	}
	/**
	 * @param flightNumber the flightNumber to set
	 */
	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}
	/**
	 * @return the carrier
	 */
	public String getCarrier() {
		return carrier;
	}
	/**
	 * @param carrier the carrier to set
	 */
	public void setCarrier(String carrier) {
		this.carrier = carrier;
	}
	/**
	 * @return the origin
	 */
	public String getOrigin() {
		return origin;
	}
	/**
	 * @param origin the origin to set
	 */
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	/**
	 * @return the departure
	 */
	public String getDeparture() {
		return departure;
	}
	/**
	 * @param departure the departure to set
	 */
	public void setDeparture(String departure) {
		this.departure = departure;
	}
	/**
	 * @return the destination
	 */
	public String getDestination() {
		return destination;
	}
	/**
	 * @param destination the destination to set
	 */
	public void setDestination(String destination) {
		this.destination = destination;
	}
	/**
	 * @return the arrival
	 */
	public String getArrival() {
		return arrival;
	}
	/**
	 * @param arrival the arrival to set
	 */
	public void setArrival(String arrival) {
		this.arrival = arrival;
	}
	/**
	 * @return the aircraft
	 */
	public String getAircraft() {
		return aircraft;
	}
	/**
	 * @param aircraft the aircraft to set
	 */
	public void setAircraft(String aircraft) {
		this.aircraft = aircraft;
	}
	/**
	 * @return the distance
	 */
	public Integer getDistance() {
		return distance;
	}
	/**
	 * @param distance the distance to set
	 */
	public void setDistance(Integer distance) {
		this.distance = distance;
	}
	/**
	 * @return the travelTime
	 */
	public Date getTravelTime() {
		return travelTime;
	}
	/**
	 * @param travelTime the travelTime to set
	 */
	public void setTravelTime(Date travelTime) {
		this.travelTime = travelTime;
	}
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "FlightDetailsVO [flightNumber=" + flightNumber + ", carrier=" + carrier + ", origin=" + origin
				+ ", departure=" + departure + ", destination=" + destination + ", arrival=" + arrival + ", aircraft="
				+ aircraft + ", distance=" + distance + ", travelTime=" + travelTime + ", status=" + status + "]";
	}

	
}
