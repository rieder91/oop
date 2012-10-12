package assignment1;

import java.math.BigDecimal;
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
		String ret = "Place: " + place + " Time: " + time + " Duration: " + duration;
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
	
	public abstract BigDecimal getFinances();
	
	/** 
	 * compares two events
	 * 
	 * @return 
	 * 			true if the events are equal
	 * 			false if the events are not equal
	 */
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!this.getClass().equals(o.getClass())) {
			return false;

		}
		if (this.place.equals(((Event) o).place)
				&& this.time.equals(((Event) o).time)) {
			return true;

		}
		return false;
	}
}