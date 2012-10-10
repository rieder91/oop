package assignment1;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class Band {

	private HashMap<Member, Date> members;
	private ArrayList<Event> events;
	private HashMap<Track, Date> tracks;

	public Band() {
		super();
	}

	public HashMap<Member, Date> getMembers() {
		return this.members;
	}

	public ArrayList<Event> getEvents() {
		return this.events;
	}

	public HashMap<Track, Date> getTracks() {
		return this.tracks;
	}

	/**
	 * 
	 * @return
	 */
	public String toString() {
	}

	/**
	 * 
	 * @param Event
	 * @return
	 */
	public void addEvent(Event e) {
	}

	/**
	 * 
	 * @param e
	 * @return
	 */
	public void removeEvent(Event e) {
	}

	/**
	 * 
	 * @param m
	 * @return
	 */
	public void addMember(Member m) {
	}

	/**
	 * 
	 * @param m
	 * @return
	 */
	public void removeMember(Member m) {
	}

	/**
	 * 
	 * @param d1
	 * @param d2
	 * @param types
	 * @return
	 */
	public ArrayList<Event> getEventsFromTo(Date d1, Date d2,
			ArrayList<Class<? extends Event>> types) {
	}

	/**
	 * 
	 * @param d1
	 * @param d2
	 * @return
	 */
	public HashMap<String, Double> getBillingFromTo(Date d1, Date d2) {
	}

	/**
	 * 
	 * @param d
	 * @return
	 */
	public ArrayList<Member> getMemberAt(Date d) {
	}

	/**
	 * 
	 * @param d
	 * @return
	 */
	public ArrayList<Track> getTracks(Date d) {
	}

}