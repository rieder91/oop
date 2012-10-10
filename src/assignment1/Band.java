package assignment1;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class Band {

	private String name;
	private String genre;

	private ArrayList<Event> events;
	private ArrayList<Member> members;
	private ArrayList<Track> tracks;

	private HashMap<Member, Date> memberDates;
	private HashMap<Track, Date> trackDates;

	private HashMap<Member, Date> previousMembers;
	private HashMap<Track, Date> previousTracks;



	public Band(String name, String genre) {
		super();
		this.name = name;
		this.genre = genre;
	}

	public ArrayList<Member> getMembers() {
		return this.members;
	}

	public ArrayList<Event> getEvents() {
		return this.events;
	}

	public ArrayList<Track> getTracks() {
		return this.tracks;
	}

	/**
	 * 
	 * @return
	 */
	public String toString() {
		String ret = "";
		ret += "Band name: " + this.name;
		ret += "\nBand genre: " + this.genre;

		ret += "\n\nMembers:\n";
		for(Member m : members) {
			ret += m.toString();
		}
		
		ret+= "\n\nEvents:\n";
		for(Event e : events) {
			ret += e.toString();
		}
		
		ret+= "\n\nTracks:\n";
		for(Track t : tracks) {
			ret += t.toString();
		}

		return ret;

	}

	/**
	 * 
	 * @param t
	 */
	public void addTrack(Track t, Date d) {
		tracks.add(t);
		trackDates.put(t, d);
	}

	/**
	 * 
	 * @param t
	 */
	public void removeTrack(Track t, Date d) {
		tracks.remove(t);
		previousTracks.put(t, d);
	}

	/**
	 * 
	 * @param Event
	 * @return
	 */
	public void addEvent(Event e) {
		events.add(e);
	}

	/**
	 * 
	 * @param e
	 * @return
	 */
	public void removeEvent(Event e) {
		events.remove(e);
	}

	/**
	 * 
	 * @param m
	 * @return
	 */
	public void addMember(Member m, Date d) {
		members.add(m);
		memberDates.put(m, d);
	}

	/**
	 * 
	 * @param m
	 * @return
	 */
	public void removeMember(Member m, Date d) {
		members.remove(m);
		previousMembers.put(m, d);
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
		ArrayList<Event> ret = new ArrayList<Event>();
		for(Event e : events) {
			if(types.contains(e.getClass())) {
				if(e.getTime().after(d1) && e.getTime().before(d2)) {
					ret.add(e);
				}
			}
		}
		return ret;
	}

	/**
	 * 
	 * @param d1
	 * @param d2
	 * @return
	 */
	public Double getBillingFromTo(Date d1, Date d2, ArrayList<Class<? extends Event>> types) {
		Double ret = 0.0;
		for(Event e : events) {
			if(types.contains(e.getClass())) {
				if(e.getTime().after(d1) && e.getTime().before(d2)) {
					ret += e.getFinances();
				}
			}
		}
		return ret;
	}

	/**
	 * 
	 * @param d
	 * @return
	 */
	public ArrayList<Member> getMemberAt(Date d) {
		ArrayList<Member> ret = new ArrayList<Member>();

		for(Member m : memberDates.keySet()) {
			// check if the member joined before the date
			if(memberDates.get(m).before(d)) {
				// check if the member left the band
				if(previousMembers.containsKey(m)) {
					// did the member leave before or after the given date?
					if(previousMembers.get(m).after(d)) {
						ret.add(m);
					}
				} else {
					ret.add(m);
				}
			}
		}
		return ret;
	}

	/**
	 * 
	 * @param d
	 * @return
	 */
	public ArrayList<Track> getTracks(Date d) {
		ArrayList<Track> ret = new ArrayList<Track>();

		for(Track t : trackDates.keySet()) {
			if(trackDates.get(t).before(d)) {
				if(previousMembers.containsKey(t)) {
					if(previousMembers.get(t).after(d)) {
						ret.add(t);
					}
				} else {
					ret.add(t);
				}
			}
		}

		return ret;
	}

}