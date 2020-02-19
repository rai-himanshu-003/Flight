package com.capgemini.flight.test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigInteger;
import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import com.capgemini.flight.entity.Airport;
import com.capgemini.flight.entity.Flight;
import com.capgemini.flight.entity.Schedule;
import com.capgemini.flight.entity.ScheduledFlight;
import com.capgemini.flight.exception.ScheduleFlightException;
import com.capgemini.flight.exception.ValidateException;
import com.capgemini.flight.service.FlightSystemService;
import com.capgemini.flight.service.FlightSystemServiceImpl;
@TestInstance(Lifecycle.PER_CLASS)
public class Flight2Test {
	FlightSystemService ser;
	Airport airport1;
	Airport airport3;
	Schedule schedule1;
	ScheduledFlight expectedsf1;

	@BeforeAll
	public void beforeAll() {
		ser = new FlightSystemServiceImpl();
		Flight flight1 = new Flight(BigInteger.valueOf(1001), "Air India", 310);
		airport1 = new Airport("Chennai International Airport", "Chennai", "MAA");
		airport3 = new Airport("Pune Airport", "Pune", "PNQ");
		schedule1 = new Schedule(airport1, airport3, LocalDateTime.of(2020, 03, 10, 12, 55),
				LocalDateTime.of(2020, 03, 10, 15, 45));
		expectedsf1 = new ScheduledFlight(1211, flight1, 23, schedule1);
	}

	@Test
	@DisplayName("test case wrong scheduled Id")
	public void testIdExceptio() throws ValidateException, ScheduleFlightException {
		assertAll("scheuledflight", () -> assertThrows(ScheduleFlightException.class, () -> {
			ser.viewScheduledFlight("1200");
		}), () -> assertThrows(ValidateException.class, () -> {
			ser.viewScheduledFlight("dfdfdgd");
		}));
	}

	@Test
	@DisplayName("test case for checking the details of scheduledflight")
	public void testFlightSchedule() throws ScheduleFlightException, ValidateException {
		assertEquals(expectedsf1.toString(), ser.viewScheduledFlight("1211").toString());
	}
}
