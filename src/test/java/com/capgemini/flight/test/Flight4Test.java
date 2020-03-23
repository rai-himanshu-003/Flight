package com.capgemini.flight.test;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.math.BigInteger;
import java.time.LocalDateTime;

import com.capgemini.flight.dao.FlightSystemDao;
import com.capgemini.flight.dao.FlightSystemDaoImpl;
import com.capgemini.flight.entity.Airport;
import com.capgemini.flight.entity.Flight;
import com.capgemini.flight.entity.Schedule;
import com.capgemini.flight.entity.ScheduledFlight;
import com.capgemini.flight.exception.ScheduleFlightException;


@TestInstance(Lifecycle.PER_CLASS)
public class Flight4Test {

	FlightSystemDao dao;
	Airport airport1;
	Airport airport3;
	Schedule schedule1;
	ScheduledFlight expectedsf1;


	@BeforeAll
	public void BeforeAll() {
		dao = new FlightSystemDaoImpl();
		Flight flight1 = new Flight(BigInteger.valueOf(1001), "Air India", 310);
		airport1 = new Airport("Chennai International Airport", "Chennai", "MAA");
		airport3 = new Airport("Pune Airport", "Pune", "PNQ");
		schedule1 = new Schedule(airport1, airport3, LocalDateTime.of(2020, 03, 10, 12, 55),
				LocalDateTime.of(2020, 03, 10, 15, 45));
		expectedsf1 = new ScheduledFlight(1211, flight1, 23, schedule1);
	}

@Test
@DisplayName("test case for wrong scheduled ID in dao")	
	public void testViewScheduleFlight()throws ScheduleFlightException {
	
	assertAll("scheduledId",
		()->assertThrows(ScheduleFlightException.class,()->{dao.viewScheduledFlight(1234566);}),
		()->assertThrows(ScheduleFlightException.class,()->{dao.viewScheduledFlight(1200200202);}));		
}
@Test
@DisplayName("test case for checking the details of scheduledflight")
public void testScheduleFlight() throws ScheduleFlightException {
	
	assertEquals(expectedsf1.toString(),dao.viewScheduledFlight(1211).toString());
	
}

}
