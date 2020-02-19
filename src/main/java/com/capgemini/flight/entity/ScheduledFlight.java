package com.capgemini.flight.entity;

public class ScheduledFlight {
   private int scheduledId;
	private Flight flight=new Flight();
	private Integer availableSeats;
	private Schedule schedule=new Schedule();

	public ScheduledFlight() {
		
	}
	public ScheduledFlight(int scheduledId,Flight flight, Integer availableSeats, Schedule schedule) {
		super();
		this.scheduledId=scheduledId;
		this.flight = flight;
		this.availableSeats = availableSeats;
		this.schedule = schedule;
	}

	public int getScheduledId() {
		return scheduledId;
	}

	public void setScheduledId(int scheduledId) {
		this.scheduledId = scheduledId;
	}

	public Flight getFlight() {
		return flight;
	}

	public Integer getAvailableSeats() {
		return availableSeats;
	}

	public Schedule getSchedule() {
		return schedule;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}

	@Override
	public String toString() {
		return "\nscheduledId=" + scheduledId + flight + "\navailableSeats=" + availableSeats + "\nschedule=" + schedule;
	}
	

}
