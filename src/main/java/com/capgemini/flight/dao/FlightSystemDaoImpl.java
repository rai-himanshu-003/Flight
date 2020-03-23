package com.capgemini.flight.dao;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.capgemini.flight.entity.Airport;
import com.capgemini.flight.entity.ScheduledFlight;
import com.capgemini.flight.exception.AirportNotFoundException;
import com.capgemini.flight.exception.ScheduleFlightException;
import com.capgemini.flight.util.FlightSystemRepository;
/************************************************************************************
 * @Author name:Himanshu
 * @Description:this class contain methods to view , delete and update the schduledFlifgts
 * @Methods: viewScheduledFlight, deleteScheduledFlight, getAirport, updateSchedule 
 *************************************************************************************/
public class FlightSystemDaoImpl implements FlightSystemDao {
	List<Airport> airportLst = FlightSystemRepository.getAirportDetails();


	Map<Integer, ScheduledFlight> scheduleflightmap = FlightSystemRepository.getScheduledFlight();
	
	/***********************************************************************************
	 * this method shows the Scheduled flight details of a id which is entered by admin
	 * MethodName:viewScheduledFlight
	 * @throws ScheduleFlightException
	 * @returnType: Map<ScheduedFlight>
	 * @parameter: integer id
	 * 
	 ***********************************************************************************/
	public ScheduledFlight viewScheduledFlight(int id) throws ScheduleFlightException {

		if (!scheduleflightmap.containsKey(id)) {
			throw new ScheduleFlightException("Invalid Id");
		}
		return scheduleflightmap.get(id);

	}

	/****************************************************************************
	 * this method delete a particular flight schedule and update it into the Map
	 * containing id and scheduled flight details
	 * @MethodName:deleteScheduledFlight
	 * @throws ScheduleFlightException
	 * @returnType: boolean
	 * @parameter: integer id
	 ******************************************************************************/
	public boolean deleteScheduledFlight(int id) throws ScheduleFlightException {
		
			if (!scheduleflightmap.containsKey(id)) {
				throw new ScheduleFlightException("Invalid Id");
			}else {
				scheduleflightmap.remove(id);}
			
                return true;
		
	}

	/******************************************************************************
	 * this method filter out source airport details by comparing the airport code
	 * which is enter by admin to the airport code in the list and then return
	 * airport details
	 * @MethodName:getAirport
	 * @throws AirportNotFoundException
	 * @returnType: Airport
	 * @parameter:String airportcode
	 * 
	 *******************************************************************************/
	public Airport getAirport(String airportcode) throws AirportNotFoundException {

		List<Airport> srclst = airportLst.stream()
				.filter(airport -> airport.getAirportCode().equalsIgnoreCase(airportcode)).collect(Collectors.toList());
		if (srclst.isEmpty()) {
			throw new AirportNotFoundException("airport not found");}

		return srclst.get(0);
	}

	
	/********************************************************************************
	 * this method update the details after changing the source airport and
	 * destination airport in to the map
	 * @MethodName:updateSchedule
	 * @returnType:boolean
	 * @parameter ScheduledFlight 
	 * 
	 **********************************************************************************/
	@Override
	public boolean updateSchedule(ScheduledFlight schedule) {
		scheduleflightmap.replace(schedule.getScheduledId(), schedule);
		return false;
	}
	
	
		
	

}
