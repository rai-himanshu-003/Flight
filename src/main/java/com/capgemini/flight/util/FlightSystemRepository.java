package com.capgemini.flight.util;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.capgemini.flight.entity.Airport;
import com.capgemini.flight.entity.Flight;
import com.capgemini.flight.entity.Schedule;
import com.capgemini.flight.entity.ScheduledFlight;

public class FlightSystemRepository {
	
   
	public static Map<Integer,ScheduledFlight> schfmap = new HashMap< >();
	public static List<Airport> airportlst =new ArrayList<Airport>();
	

	static {
		Flight flight1 = new Flight(BigInteger.valueOf(1001), "Air India", 310);
		Flight flight2 = new Flight(BigInteger.valueOf(1002), "Spice Jet", 320);
		Flight flight3 = new Flight(BigInteger.valueOf(1003), "IndiGo", 200);
		Flight flight4 = new Flight(BigInteger.valueOf(1004), "Vistara", 410);

	
		Airport airport1 = new Airport("Chennai International Airport", "Chennai", "MAA");
		Airport airport2 = new Airport("Mysore Airport", "Mysore", "MYQ");
		Airport airport3 = new Airport("Pune Airport", "Pune", "PNQ");
		Airport airport4 = new Airport("Bengaluru International Airport", "Banglore", "BLR");
		Airport airport5 = new Airport("Lucknow Airport", "Lucknow", "LKO");
		
		/**********Adding airport*********/
		airportlst.add(airport1);
		airportlst.add(airport2);
		airportlst.add(airport3);
		airportlst.add(airport4);
		airportlst.add(airport5);
		

		Schedule schedule1 = new Schedule(airport1, airport3, LocalDateTime.of(2020, 03, 10, 12, 55),
				LocalDateTime.of(2020, 03, 10, 15, 45));
		Schedule schedule2 = new Schedule(airport2, airport1, LocalDateTime.of(2020, 03, 12, 15, 32),
				LocalDateTime.of(2020, 03, 12, 19, 35));
		Schedule schedule3 = new Schedule(airport3, airport5, LocalDateTime.of(2020, 03, 15, 11, 00),
				LocalDateTime.of(2020, 03, 16, 11, 45));
		Schedule schedule4 = new Schedule(airport5, airport1, LocalDateTime.of(2020, 04, 20, 11, 00),
				LocalDateTime.of(2020, 04, 21, 15, 20));
		Schedule schedule5 = new Schedule(airport4, airport5, LocalDateTime.of(2020, 05, 23, 9, 00),
				LocalDateTime.of(2020, 05, 24, 12, 00));
		Schedule schedule6 = new Schedule(airport4, airport1, LocalDateTime.of(2020, 06, 1, 10, 00),
				LocalDateTime.of(2020, 06, 1, 12, 00));
		Schedule schedule7 = new Schedule(airport4, airport4, LocalDateTime.of(2020, 10, 14, 8, 00),
				LocalDateTime.of(2020, 10, 14, 9, 00));

		ScheduledFlight sf1 = new ScheduledFlight(1211,flight1, 23, schedule1);
		ScheduledFlight sf2 = new ScheduledFlight(1213,flight2, 30, schedule2);
		ScheduledFlight sf3 = new ScheduledFlight(1214,flight2, 33, schedule3);
		ScheduledFlight sf4 = new ScheduledFlight(1215,flight1, 12, schedule4);
		ScheduledFlight sf5 = new ScheduledFlight(1216,flight4, 10, schedule5);
		ScheduledFlight sf6 = new ScheduledFlight(1217,flight4, 56, schedule6);
		ScheduledFlight sf7 = new ScheduledFlight(1218,flight3, 100, schedule7);
		
  /****************Adding Scheduled Flight*********/
		schfmap.put(1211,sf1);
		schfmap.put(1213,sf2);
		schfmap.put(1214,sf3);
		schfmap.put(1215,sf4);
		schfmap.put(1216,sf5);
		schfmap.put(1217,sf6);
		schfmap.put(1218,sf7);
		

	}
/*
 * this method return map containing all scheduled flight 
 * MethodName: getScheduledFlight
 * ReturnType:Map<Integer,ScheduledFlight>
 * 
 */
	public static Map<Integer,ScheduledFlight> getScheduledFlight() {

	       return schfmap;

	}
/*
 * this method return the list containing Airport details
 * MethodName:getAirportDetails
 * ReturnType:List<Airport>
 */
	public static List<Airport> getAirportDetails(){
		return airportlst;
	}
	
}
