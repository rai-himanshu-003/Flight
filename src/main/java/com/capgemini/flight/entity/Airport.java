package com.capgemini.flight.entity;

public class Airport {

	private String airportName;
	private String airportLocation;
	private String airportCode;
	
	public Airport() {
		
	}

	public Airport(String airportName, String airportLocation, String airportCode) {
		super();
		this.airportName = airportName;
		this.airportLocation = airportLocation;
		this.airportCode = airportCode;
	}

	public String getAirportName() {
		return airportName;
	}

	public String getAirportLocation() {
		return airportLocation;
	}

	public String getAirportCode() {
		return airportCode;
	}
	

	public void setAirportName(String airportName) {
		this.airportName = airportName;
	}

	public void setAirportLocation(String airportLocation) {
		this.airportLocation = airportLocation;
	}

	public void setAirportCode(String airportCode) {
		this.airportCode = airportCode;
	}

	@Override
	public String toString() {
		return "airportName=" + airportName + " \nairportLocation=" + airportLocation + " \nairportCode=" + airportCode;
	}

}
