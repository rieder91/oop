package band;

import java.util.ArrayList;

/**
 * 
 * @author Thomas
 *
 */
public class PlaceManager {
	ArrayList<Place> places;
	
	/**
	 * 
	 */
	public PlaceManager() {
		places = new ArrayList<Place>();
	}
	
	/**
	 * 
	 * @param p
	 */
	public void addPlace(Place p) {
		if(!places.contains(p)) {
			places.add(p);
		}
	}
	
	/**
	 * 
	 * @param name
	 */
	public void removePlace(String name) {
		for(Place p : places) {
			if (name.equals(p.getName())) {
				places.remove(p);
			}
		}
	}
	
	/**
	 * 
	 * @param p
	 */
	public void removePlace(Place p) {
		places.remove(p);
	}
	
	/**
	 * 
	 * @param inf
	 * @return
	 */
	public ArrayList<Place> getPlacesByFilter(ArrayList<Infrastructure> inf) {
		ArrayList<Place> ret = new ArrayList<Place>();
		for(Place p : places) {
			if(p.hasInfrastructure(inf)) {
				ret.add(p);
			}
		}
		return ret;
	}

}
