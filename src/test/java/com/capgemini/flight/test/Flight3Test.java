package com.capgemini.flight.test;

import static org.junit.jupiter.api.Assertions.assertAll;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import com.capgemini.flight.exception.AirportNotFoundException;
import com.capgemini.flight.exception.ScheduleFlightException;
import com.capgemini.flight.exception.ValidateException;
import com.capgemini.flight.service.FlightSystemService;
import com.capgemini.flight.service.FlightSystemServiceImpl;
@TestInstance(Lifecycle.PER_CLASS)
public class Flight3Test {
	FlightSystemService ser;
	
     @BeforeAll
     public void beforeAll() {
	 ser=new FlightSystemServiceImpl();
}
	@Test
	@DisplayName("test case for  return type")
	public void testChangeScheduledFlight() throws ValidateException, ScheduleFlightException, AirportNotFoundException {
    
	 assertTrue(ser.changeSourceAndDestination("1213", "LKO", "PNQ"));
	
	}
   
	@Test
	@DisplayName("test case for wrong airport name")
	public void testAirportNotFoundException()throws ValidateException,ScheduleFlightException,AirportNotFoundException{
		assertAll("airport name",
	()->assertThrows(AirportNotFoundException.class,()->{ser.changeSourceAndDestination("1216", "AGR", "PNQ");}),
    ()->assertThrows(AirportNotFoundException.class,()->{ser.changeSourceAndDestination("1215", "AGR", "fgfhdh");}),
		()->assertThrows(AirportNotFoundException.class,()->{ser.changeSourceAndDestination("1215", "", "");}));	
	}
	
	@Test
	@DisplayName("test case for wrong scheduledflight id")
	public void testValidateException()throws ValidateException,AirportNotFoundException{
		assertAll("change schedule",
	  ()->assertThrows(ValidateException.class,()->{ser.changeSourceAndDestination("12345678", "LKO", "PNQ");}),
	  ()->assertThrows(ValidateException.class,()->{ser.changeSourceAndDestination("dsdhdh", "BLR", "PNQ");}));
	}
     
	@Test
	@DisplayName("test case for incorrect value of scheduled flight id ")
	public void testScheduleFlightException()throws ValidateException,AirportNotFoundException,ScheduleFlightException{
		assertAll("change schedule",
		   ()->assertThrows(ScheduleFlightException.class,()->{ser.changeSourceAndDestination("1234", "MAA", "PNQ");}),
		   ()->assertThrows(ScheduleFlightException.class,()->{ser.changeSourceAndDestination("4567", "LKO", "BLR");}));
	}
	
	
}
