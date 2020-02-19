package com.capgemini.flight.test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import com.capgemini.flight.dao.FlightSystemDao;
import com.capgemini.flight.dao.FlightSystemDaoImpl;
import com.capgemini.flight.entity.Airport;
import com.capgemini.flight.entity.Flight;
import com.capgemini.flight.entity.Schedule;
import com.capgemini.flight.entity.ScheduledFlight;
import com.capgemini.flight.exception.AirportNotFoundException;
import com.capgemini.flight.exception.ScheduleFlightException;
import com.capgemini.flight.exception.ValidateException;
import com.capgemini.flight.service.FlightSystemService;
import com.capgemini.flight.service.FlightSystemServiceImpl;
import com.capgemini.flight.util.FlightSystemRepository;
@TestInstance(Lifecycle.PER_CLASS)
public class Flight1Test {

	FlightSystemService ser;
  
	List<Airport> airportlst= FlightSystemRepository.getAirportDetails();
    
	 @BeforeAll
     public void beforeAll() {
	 ser=new FlightSystemServiceImpl();
     }
	 
	@Test
	@DisplayName("test case for wrong scheduledFlight id")
	public void testScheduleId() throws ValidateException {
		assertAll("scheduleId",
       ()->assertThrows(ValidateException.class,()->{ser.deleteScheduledFlights("12001");}),
	   ()->assertThrows(ValidateException.class,()->{ser.deleteScheduledFlights("sgdwjfhsjwhdj");}));         
	}
	
	@Test
	@DisplayName("test case for return type")
	public void testDeleteSchedule() throws ValidateException, ScheduleFlightException {
		assumeTrue(ser != null);
		assertTrue(ser.deleteScheduledFlights("1218"));

	}
	@Test
	@DisplayName("test case for incorrect value of scheduledFlight id")
    public void testScheduleFlightException()throws ValidateException, ScheduleFlightException {
		assertAll("scheduleId",
			      ()->assertThrows(ScheduleFlightException.class,()->{ser.deleteScheduledFlights("1200");}),
				  ()->assertThrows(ScheduleFlightException.class,()->{ser.deleteScheduledFlights("4567");}));
	}
	

   @Test
   @DisplayName("test case for airport list size")
	public void testAirportListsize() {
		assertEquals(5, airportlst.size());
	}
    
}
