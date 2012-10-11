package assignment1;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class Band {

	private String name;
	private String genre;

	// contain the current information
	private ArrayList<Event> events;
	private ArrayList<Member> members;
	private ArrayList<Track> tracks;

	// contain the "join dates"
	private HashMap<Member, ArrayList<Date>> memberDates;
	private HashMap<Track, ArrayList<Date>> trackDates;

	// contain the "leave dates"
	private HashMap<Member, ArrayList<Date>> previousMembers;
	private HashMap<Track, ArrayList<Date>> previousTracks;

	public Band(String name, String genre) {
		super();
		this.name = name;
		this.genre = genre;

		events = new ArrayList<Event>();
		members = new ArrayList<Member>();
		tracks = new ArrayList<Track>();

		memberDates = new HashMap<Member, ArrayList<Date>>();
		trackDates = new HashMap<Track, ArrayList<Date>>();

		previousMembers = new HashMap<Member, ArrayList<Date>>();
		previousTracks = new HashMap<Track, ArrayList<Date>>();
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
		for (Member m : members) {
			ret += m.toString();
			ret += '\n';
		}

		ret += "\nEvents:\n";
		for (Event e : events) {
			ret += e.toString();
			ret += '\n';
		}

		ret += "\nTracks:\n";
		for (Track t : tracks) {
			ret += t.toString();
			ret += '\n';
		}

		return ret;

	}

	/**
	 * 
	 * @param t
	 * @param d
	 */
	public void addTrack(Track t, Date d) {
		if (!tracks.contains(t)) {
			tracks.add(t);
			if (trackDates.containsKey(t)) {
				// the track has already been added in the past - we need to add
				// a new date
				ArrayList<Date> history = previousTracks.get(t);
				Date removeDate = history.get(history.size());
				if (removeDate.after(d)) {
					// throw new invalid date exception
				} else {
					trackDates.get(t).add(d);
				}
			} else {
				ArrayList<Date> newHistory = new ArrayList<Date>();
				newHistory.add(d);
				trackDates.put(t, newHistory);
			}
		} else {
			// throw new already exists exception
		}

	}

	/**
	 * 
	 * @param t
	 * @param d
	 */
	public void removeTrack(Track t, Date d) {
		ArrayList<Date> history = trackDates.get(t);
		Date joinDate = history.get(history.size());

		if (joinDate.after(d)) {
			// throw new remove date before add date exception
		} else if (!tracks.contains(t)) {
			// throw new invalid track exception
		} else {
			tracks.remove(t);
			if (previousTracks.containsKey(t)) {
				// we need to add a new date to the history
				previousTracks.get(t).add(d);
			} else {
				ArrayList<Date> newHistory = new ArrayList<Date>();
				newHistory.add(d);
				previousTracks.put(t, newHistory);
			}

		}
	}

	/**
	 * 
	 * @param Event
	 * @return
	 */
	public void addEvent(Event e) {
		if (!events.contains(e)) {
			events.add(e);
		} else {
			// throw new already exists exception
		}

	}

	/**
	 * 
	 * @param e
	 * @return
	 */
	public void removeEvent(Event e) {
		if (!events.contains(e)) {
			// throw new invalid event exception
		} else {
			events.remove(e);
		}
	}

	/**
	 * 
	 * @param m
	 * @return
	 */
	public void addMember(Member m, Date d) {
		if (!members.contains(m)) {
			members.add(m);
			if (memberDates.containsKey(m)) {
				// the member has already been part of the band once before
				// TODO Check if the LAST leave-date was BEFORE the new join
				// date
				ArrayList<Date> history = previousMembers.get(m);
				Date leaveDate = history.get(history.size());
				if (leaveDate.after(d)) {
					// throw new invalid date exception
				} else {
					memberDates.get(m).add(d);
				}
			} else {
				ArrayList<Date> newHistory = new ArrayList<Date>();
				newHistory.add(d);
				memberDates.put(m, newHistory);
			}
		} else {
			// throw new already exists exception
		}
	}

	/**
	 * 
	 * @param m
	 * @return
	 */
	public void removeMember(Member m, Date d) {
		ArrayList<Date> history = memberDates.get(m);
		Date joinDate = history.get(history.size());
		if (joinDate.after(d)) {
			// throw new remove date before add date exception
		} else if (!members.contains(m)) {
			// throw new invalid member exception
		} else {
			members.remove(m);
			if (previousMembers.containsKey(m)) {
				// the member has leave once before
				previousMembers.get(m).add(d);
			} else {
				ArrayList<Date> newHistory = new ArrayList<Date>();
				newHistory.add(d);
				previousMembers.put(m, newHistory);
			}
		}
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
		for (Event e : events) {
			if (types.contains(e.getClass())) {
				if (e.getTime().after(d1) && e.getTime().before(d2)) {
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
	public Double getBillingFromTo(Date d1, Date d2,
			ArrayList<Class<? extends Event>> types) {
		Double ret = 0.0;
		for (Event e : events) {
			if (types.contains(e.getClass())) {
				if (e.getTime().after(d1) && e.getTime().before(d2)) {
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

		for (Member m : memberDates.keySet()) {
			Date lastValidDate = null;
			for (Date joinDate : memberDates.get(m)) {
				if (joinDate.before(d)) {
					lastValidDate = joinDate;
				}
			}

			// if he left the group get the one after the lastValidDate
			if (lastValidDate != null && previousMembers.containsKey(m)) {
				for (Date leaveDate : previousMembers.get(m)) {
					if (leaveDate.before(d) && leaveDate.after(lastValidDate)) {
						lastValidDate = null;
					}
				}
			}

			if (lastValidDate != null) {
				ret.add(m);
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

		for (Track t : trackDates.keySet()) {
			Date lastValidDate = null;
			for (Date addDate : trackDates.get(t)) {
				if (addDate.before(d)) {
					lastValidDate = addDate;
				}
			}

			if (lastValidDate != null && previousTracks.containsKey(t)) {
				for (Date removeDate : previousTracks.get(t)) {
					if (removeDate.before(d) && removeDate.after(lastValidDate)) {
						lastValidDate = null;
					}
				}
			}

			if (lastValidDate != null) {
				ret.add(t);
			}
		}

		return ret;
	}

}