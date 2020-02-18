package com.capgemini.flight.dao;

import com.capgemini.flight.entity.Airport;
import com.capgemini.flight.entity.ScheduledFlight;
import com.capgemini.flight.exception.AirportNotFoundException;
import com.capgemini.flight.exception.ScheduleFlightException;

public interface FlightSystemDao {

	public ScheduledFlight viewScheduledFlight(int id) throws ScheduleFlightException;

	public boolean deleteScheduledFlight(int id) throws ScheduleFlightException;

	public Airport getAirport(String airportcode) throws AirportNotFoundException;

	public boolean updateSchedule(ScheduledFlight schedule);

}
