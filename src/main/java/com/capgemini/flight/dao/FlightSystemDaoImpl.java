package com.capgemini.flight.dao;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.capgemini.flight.entity.Airport;
import com.capgemini.flight.entity.ScheduledFlight;
import com.capgemini.flight.exception.AirportNotFoundException;
import com.capgemini.flight.exception.ScheduleFlightException;
import com.capgemini.flight.util.FlightSystemRepository;

public class FlightSystemDaoImpl implements FlightSystemDao {
	List<Airport> airportLst = FlightSystemRepository.getAirportDetails();

	Airport airport;

	Map<Integer, ScheduledFlight> map = FlightSystemRepository.getScheduledFlight();
	
	/*
	 * this method shows the Scheduled flight details of a id which is entered by admin
	 * MethodName:viewScheduledFlight
	 * @throws ScheduleFlightException
	 * ReturnType:Map<ScheduedFlight>
	 * Parameter1:int id
	 * 
	 */
	public ScheduledFlight viewScheduledFlight(int id) throws ScheduleFlightException {

		if (!map.containsKey(id)) {
			throw new ScheduleFlightException("Invalid Id");
		}
		return map.get(id);

	}

	/* 
	 * this method delete a particular flight schedule and update it into the Map
	 * containing id and scheduled flight details
	 * MethodName:deleteScheduledFlight
	 * @throws ScheduleFlightException
	 * ReturnType: boolean
	 * Parameter1:int id
	 */
	public boolean deleteScheduledFlight(int id) throws ScheduleFlightException {
		
			if (!map.containsKey(id)) {
				throw new ScheduleFlightException("Invalid Id");
			} else
				map.remove(id);
                return true;
		
	}

	/*
	 * this method filter out source airport details by comparing the airport code
	 * which is enter by admin to the airport code in the list and then return
	 * airport details
	 * MethodName:getAirport
	 * @throws AirportNotFoundException
	 * ReturnType: Airport
	 * Parameter:String airportcode
	 * 
	 */
	public Airport getAirport(String airportcode) throws AirportNotFoundException {

		List<Airport> srclst = airportLst.stream()
				.filter(airport -> airport.getAirportCode().equalsIgnoreCase(airportcode)).collect(Collectors.toList());
		if (srclst.isEmpty())
			throw new AirportNotFoundException("airport not found");

		Airport srcAirport = srclst.get(0);

		return srcAirport;
	}

	
	/*
	 * this method update the details after changing the source airport and
	 * destination airport in to the map
	 * MethodName:updateSchedule
	 * ReturnType:boolean
	 * Parameter ScheduledFlight 
	 * 
	 */
	@Override
	public boolean updateSchedule(ScheduledFlight schedule) {
		map.replace(schedule.getScheduledId(), schedule);
		return false;
	}

}
