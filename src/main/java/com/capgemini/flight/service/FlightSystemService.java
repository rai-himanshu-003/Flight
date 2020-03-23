package com.capgemini.flight.service;

import com.capgemini.flight.entity.ScheduledFlight;
import com.capgemini.flight.exception.AirportNotFoundException;
import com.capgemini.flight.exception.ScheduleFlightException;
import com.capgemini.flight.exception.ValidateException;

public interface FlightSystemService {

	public boolean deleteScheduledFlights(String scheduledId) throws ValidateException, ScheduleFlightException;

	public boolean changeSourceAndDestination(String scheduleId, String src, String dest)
			throws ValidateException, ScheduleFlightException, AirportNotFoundException;
	
	 public ScheduledFlight viewScheduledFlight(String scheduleId) throws ValidateException,ScheduleFlightException;

}
