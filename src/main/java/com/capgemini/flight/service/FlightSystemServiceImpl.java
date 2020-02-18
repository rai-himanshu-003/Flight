package com.capgemini.flight.service;

import com.capgemini.flight.dao.FlightSystemDao;
import com.capgemini.flight.dao.FlightSystemDaoImpl;
import com.capgemini.flight.entity.Airport;
import com.capgemini.flight.entity.ScheduledFlight;
import com.capgemini.flight.exception.AirportNotFoundException;
import com.capgemini.flight.exception.ScheduleFlightException;
import com.capgemini.flight.exception.ValidateException;

public class FlightSystemServiceImpl implements FlightSystemService {

	Airport airport;
	private FlightSystemDao dao = new FlightSystemDaoImpl();

	/*
	 * this method delete a scheduled flight by getting the scheduled id from the admin and then update
	 * into the ScheduledFlight map
	 * MethodName:deleteScheduledFlight
	 * @throws ValidateException,ScheduleFlightException
	 * ReturnType:boolean
	 * Parameter:String scheduleId
	 */
	@Override
	public boolean deleteScheduledFlights(String scheduledId)
			throws ValidateException, ScheduleFlightException {

		if (!scheduledId.matches("[1-9][0-9]{3}")) {
			throw new ValidateException("id must be number and it is between 3 to 6 number");
		}
		else 
		dao.deleteScheduledFlight(Integer.parseInt(scheduledId));
		return true;

	}
   /*
    * this method change the source and destination airport and then update it into the ScheduledFlight
    * MethodName:changeSourceAndDestination
    * ReturnType:boolean
    * @throws ValidateException,ScheduleFlightException,AirportNotFoundException
    * Parameter:String id,String src,String dest
    */
	@Override 
	public boolean changeSourceAndDestination(String id, String src, String dest)
			throws ValidateException, ScheduleFlightException, AirportNotFoundException {
		if (!id.matches("[1-9][0-9]{3}")) {
			throw new ValidateException("id must be number and it is between 3 to 6 number");}
		
		ScheduledFlight schFlight = dao.viewScheduledFlight(Integer.parseInt(id));
		Airport sourceAirport = dao.getAirport(src);
		Airport destinationAirport = dao.getAirport(dest);
		schFlight.getSchedule().setSourceAirport(sourceAirport);
		schFlight.getSchedule().setDestinationAirport(destinationAirport);
		dao.updateSchedule(schFlight);
		
		return true;

	}
	/*
	 * this method get scheduled flight details of a particular scheduled id entered by admin
	 * MethodName:viewScheduledFlight
	 * @throw ValidateException,ScheduleFlightException
	 * ReturnType:ScheduledFlight
	 * Parameter:String id
	 */
    @Override
	public ScheduledFlight viewScheduledFlight(String id) throws ValidateException,ScheduleFlightException {
    	if (!id.matches("[1-9][0-9]{3}")) {
			throw new ValidateException("id must be number and it is between 3 to 6 number");}

		return dao.viewScheduledFlight(Integer.parseInt(id));
	
}
}
