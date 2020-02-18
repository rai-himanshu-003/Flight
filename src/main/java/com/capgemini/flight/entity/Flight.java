package com.capgemini.flight.entity;

import java.math.BigInteger;

public class Flight {

	private BigInteger flightNumber;
	private String carrierName;
	private Integer seatCapacity;
	
	public Flight() {
		
	}

	public Flight(BigInteger flightNumber, String carrierName, Integer seatCapacity) {
		super();
		this.flightNumber = flightNumber;
		this.carrierName = carrierName;
		this.seatCapacity = seatCapacity;
	}

	public BigInteger getFlightNumber() {
		return flightNumber;
	}

	public String getCarrierName() {
		return carrierName;
	}

	public Integer getSeatCapacity() {
		return seatCapacity;
	}


	@Override
	public String toString() {
		return " flightNumber=" + flightNumber + "\ncarrierName=" + carrierName + "\nseatCapacity=" + seatCapacity;
	}

}
