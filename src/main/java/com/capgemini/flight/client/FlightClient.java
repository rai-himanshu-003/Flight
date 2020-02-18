package com.capgemini.flight.client;

import java.util.Scanner;

import com.capgemini.flight.exception.AirportNotFoundException;
import com.capgemini.flight.exception.ScheduleFlightException;
import com.capgemini.flight.exception.ValidateException;
import com.capgemini.flight.service.FlightSystemService;
import com.capgemini.flight.service.FlightSystemServiceImpl;

public class FlightClient {

	public static void main(String[] args) throws ScheduleFlightException, AirportNotFoundException, ValidateException {
		Scanner scan = new Scanner(System.in);
		System.out.println("choose one option");
		String opt = null;
		String id=null;
		FlightSystemService ser = new FlightSystemServiceImpl();
		do {
			System.out.println("1-delete a scheduled Flight\n2-change source and destination airport"
					+ "\n3-view ScheduledFlight");
			String menu = scan.next();
			switch (menu) {

			case "1": {
				try {
				System.out.println("enter the id to delete ");
				String scheduledId = scan.next();
				System.out.println(ser.deleteScheduledFlights(scheduledId));
				}catch(ValidateException | ScheduleFlightException e) {
					System.out.println(e.getMessage());
				}
				break;}
			
			case "2": {
		       try {
				System.out.println("enter the scheduled flights id");
				 id = scan.next();
		       
		        
				System.out.println("enter the source airport name");
				String str1 = scan.next();

				System.out.println("enter the destination airport name");
				String str2 = scan.next();

				System.out.println(ser.changeSourceAndDestination(id, str1, str2));
		        }catch(ValidateException|AirportNotFoundException|ScheduleFlightException ex) {
		        	System.out.println(ex.getMessage());
		        }
				break;
			}
			case"3":{
				try {
				System.out.println("enter the scheduled id");
			      String scheduleId=scan.next();
				System.out.println(ser.viewScheduledFlight(scheduleId));
				}catch(ValidateException | ScheduleFlightException e) {
					System.out.println(e.getMessage());
				}
				break;
			}
			
			default: {
				System.out.println("Invalid option");
			}

			}
			System.out.println("press y to continue");
			opt = scan.next();
		} while (opt.equals("y"));
		scan.close();
	}
}
