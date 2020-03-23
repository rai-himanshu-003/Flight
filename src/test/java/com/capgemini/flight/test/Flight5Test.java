package com.capgemini.flight.test;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.capgemini.flight.dao.FlightSystemDao;
import com.capgemini.flight.dao.FlightSystemDaoImpl;
import com.capgemini.flight.entity.Airport;
import com.capgemini.flight.exception.AirportNotFoundException;

@TestInstance(Lifecycle.PER_CLASS)
public class Flight5Test {
	
	FlightSystemDao dao;
	Airport airport;
	
	@BeforeAll()
	public void BeforeAll() {
		dao=new FlightSystemDaoImpl();
		airport = new Airport("Chennai International Airport", "Chennai", "MAA");
	}
	
	@Test
	@DisplayName("test case for checking Airport details ")
	public void testGetAirport() throws AirportNotFoundException {
		assertEquals(dao.getAirport("MAA").toString(),airport.toString());
	}

	@Test
	@DisplayName("test case for AirportNotFoundException ")
	public void testAirportException() throws AirportNotFoundException {
		assertAll("airport details",
		()->assertThrows(AirportNotFoundException.class, ()->{dao.getAirport("ghdgfjfjjfag");}),
		()->assertThrows(AirportNotFoundException.class, ()->{dao.getAirport("1001010010");}),
		()->assertThrows(AirportNotFoundException.class, ()->{dao.getAirport("");})
		);
	}

}
