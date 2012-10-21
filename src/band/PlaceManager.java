package band;

import java.util.ArrayList;

/**
 * manages several places
 * 
 * @author OOP Gruppe 187
 * 
 */
public class PlaceManager {
	ArrayList<Place> places;

	/**
	 * default constructor
	 */
	public PlaceManager() {
		places = new ArrayList<Place>();
	}

	/**
	 * adds a new place
	 * 
	 * @param p
	 *            place that is being added
	 */
	public void addPlace(Place p) {
		if (!places.contains(p)) {
			places.add(p);
		}
	}

	/**
	 * removes a place via search-string
	 * 
	 * @param name
	 *            place that is searched for
	 */
	public void removePlace(String name) {
		for (Place p : places) {
			if (name.equals(p.getName())) {
				places.remove(p);
			}
		}
	}

	/**
	 * removes a place via place-obj
	 * 
	 * @param p
	 *            obj that is being removed
	 */
	public void removePlace(Place p) {
		places.remove(p);
	}

	/**
	 * return an arraylist of all places that match the requirements
	 * 
	 * @param inf
	 *            infrastructure-requirements
	 * @return arraylist of all places that match
	 */
	public ArrayList<Place> getPlacesByFilter(ArrayList<Infrastructure> inf) {
		ArrayList<Place> ret = new ArrayList<Place>();
		for (Place p : places) {
			if (p.hasInfrastructure(inf)) {
				ret.add(p);
			}
		}
		return ret;
	}

}
