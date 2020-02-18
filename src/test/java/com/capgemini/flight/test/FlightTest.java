package com.capgemini.flight.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.api.Assertions.assertAll;


import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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

public class FlightTest {

	FlightSystemDao dao = new FlightSystemDaoImpl();
	FlightSystemService ser = new FlightSystemServiceImpl();

	Flight flight1 = new Flight(BigInteger.valueOf(1001), "Air India", 310);
	Airport airport1 = new Airport("Chennai International Airport", "Chennai", "MAA");
	Airport airport3 = new Airport("Pune Airport", "Pune", "PNQ");
	Schedule schedule1 = new Schedule(airport1, airport3, LocalDateTime.of(2020, 03, 10, 12, 55),
			LocalDateTime.of(2020, 03, 10, 15, 45));
	ScheduledFlight expectedsf1 = new ScheduledFlight(1211, flight1, 23, schedule1);

	List<Airport> airportlst= FlightSystemRepository.getAirportDetails();

	@Test
	@DisplayName("test case 1")
	public void testScheduleId() throws ValidateException {
		assertAll("scheduleId",
       ()->assertThrows(ValidateException.class,()->{ser.deleteScheduledFlights("12001");}),
	   ()->assertThrows(ValidateException.class,()->{ser.deleteScheduledFlights("sgdwjfhsjwhdj");}));         
	}
	@Test
	@DisplayName("test case 2")
	public void testScheduleId2() throws ValidateException, ScheduleFlightException {
       assertAll("scheuledflight",
		()->assertThrows(ScheduleFlightException.class, () -> {ser.viewScheduledFlight("1200");}),
		()->assertThrows(ValidateException.class,()->{ser.viewScheduledFlight("dfdfdgd");}));
	}

	@Test
	@DisplayName("test case 3")
	public void testAirportName() throws AirportNotFoundException {
		assertAll("airport",
		()->assertThrows(AirportNotFoundException.class, () -> {dao.getAirport("GJT");}),
		()->assertEquals(airport1.toString(),dao.getAirport("MAA").toString()));
	}

	@Test
	@DisplayName("test case 4")
	public void testDeleteSchedule() throws ValidateException, ScheduleFlightException {
		assumeTrue(ser != null);
		assertTrue(ser.deleteScheduledFlights("1214"));

	}

	@Test
	@DisplayName("test case 5")
	public void testChangeScheduledFlight() throws ValidateException, ScheduleFlightException, AirportNotFoundException {
    assertAll("change schedule",
		()->assertTrue(ser.changeSourceAndDestination("1214", "LKO", "PNQ")),
		()->assertThrows(AirportNotFoundException.class,()->{ser.changeSourceAndDestination("1214", "AGR", "PNQ");}));
	}

	@Test
	@DisplayName("test case 6")
	public void testFlightSchedule() throws ScheduleFlightException, ValidateException {
		assertEquals(expectedsf1.toString(), ser.viewScheduledFlight("1211").toString());
	}

   @Test
   @DisplayName("test case 7")
	public void testAirportListsize() {
		assertEquals(5, airportlst.size());
	}

}
