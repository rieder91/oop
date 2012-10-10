package assignment1;

import java.util.Date;

public abstract class Event {
	private String place;
	private Date time;
	private Integer duration;

	
	/**
	 * 
	 * @return 
	 */
	public String toString() {
		String ret = place + time + duration;
		return ret;
	}

	/**
	 * 
	 * @param time
	 * @param date
	 * @param duration
	 */
	public Event(Date time, String place, Integer duration) {
		super();
		this.place = place;
		this.time = time;
		this.duration = duration;
	}

	public String getPlace() {
		return place;
	}

	public Date getTime() {
		return time;
	}

	public Integer getDuration() {
		return duration;
	}
	
	public abstract Double getCost();
	
	
	

}