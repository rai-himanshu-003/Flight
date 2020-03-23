package com.capgemini.flight.test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import com.capgemini.flight.dao.FlightSystemDao;
import com.capgemini.flight.dao.FlightSystemDaoImpl;
import com.capgemini.flight.entity.Airport;
import com.capgemini.flight.exception.ScheduleFlightException;

@TestInstance(Lifecycle.PER_CLASS)
public class Flight6Test {
	
	FlightSystemDao dao;
	Airport airport;
	
	@BeforeAll()
	public void BeforeAll() {
		dao=new FlightSystemDaoImpl();
		airport = new Airport("Chennai International Airport", "Chennai", "MAA");
	}
	
	@Test
	@DisplayName("test case for checking exception")
	public void testScheduleFlightException()throws ScheduleFlightException {
		assertAll("delete scheduled flight",
		()->assertThrows(ScheduleFlightException.class,()->{dao.deleteScheduledFlight(1248468);}),
		()->assertThrows(ScheduleFlightException.class,()->{dao.deleteScheduledFlight(0);}));
	}

	@Test
	@DisplayName("test case for return type ")
	public void testDeleteScheduledFlight() throws ScheduleFlightException {
		assertTrue(dao.deleteScheduledFlight(1213));
	}

}
