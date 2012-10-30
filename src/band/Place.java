
package band;

import java.util.ArrayList;

/**
 * contains all informations concerning one place
 * 
 * @author OOP Gruppe 187
 * 
 * GOOD: only depends on infraastructure
 * GOOD: high Klassenzusammenhalt
 */
public class Place {

	private String name;
	private ArrayList<Infrastructure> infrastructure;

	/**
	 * constructor
	 * 
	 * @param name
	 *            name of the place
	 */
	public Place(String name) {

		this.name = name;
		this.infrastructure = new ArrayList<Infrastructure>();
	}

	/**
	 * adds an infrastructure to the place, if not already there
	 * 
	 * @param i
	 *            infrastructure that is being added
	 */
	public void addInfrastructure(Infrastructure i) {

		if (!this.infrastructure.contains(i)) {
			this.infrastructure.add(i);
		}
	}

	/**
	 * compares two places
	 * 
	 * @return true if two places are equal, otherwise false
	 */
	@Override
	public boolean equals(Object obj) {

		if (this == obj) { return true; }
		if (obj == null) { return false; }
		if (this.getClass() != obj.getClass()) { return false; }
		Place other = (Place) obj;
		if (this.infrastructure == null) {
			if (other.infrastructure != null) { return false; }
		}
		else {
			for (Infrastructure i : this.infrastructure) {
				if (!other.infrastructure.contains(i)) { return false; }
			}
		}
		if (this.name == null) {
			if (other.name != null) { return false; }
		}
		else if (!this.name.equals(other.name)) { return false; }
		return true;
	}

	/**
	 * @return ArrayList of all infrastructures of the place
	 */
	public ArrayList<Infrastructure> getInfrastructure() {

		return this.infrastructure;
	}

	/**
	 * @return name of the place as String
	 */
	public String getName() {

		return this.name;
	}

	/**
	 * @return HashCode of the place
	 */
	@Override
	public int hashCode() {

		final int prime = 31;
		int result = 1;
		result = prime * result + (this.infrastructure == null ? 0 : this.infrastructure.hashCode());
		result = prime * result + (this.name == null ? 0 : this.name.hashCode());
		return result;
	}

	/**
	 * checks the place if all infrastructure-elements specified in @inf are available
	 * 
	 * @param inf
	 *            infrastructure that the place is searched for
	 * @return true if available; false otherwise
	 * 
	 * 
	 * PRECONDITION: inf must not be null
	 */
	public boolean hasInfrastructure(ArrayList<Infrastructure> inf) {

		for (Infrastructure i : inf) {
			if (!this.hasInfrastructure(i)) { return false; }
		}
		return true;
	}

	/**
	 * checks the place if one infrastructure-element is available
	 * 
	 * @param inf
	 *            one infrastructure object
	 * @return true if the place has the required infrastructure; false otherwise
	 */
	public boolean hasInfrastructure(Infrastructure inf) {

		return this.infrastructure.contains(inf);
	}

	/**
	 * removes infrastructure i from place, if it's there
	 * 
	 * @param i
	 */
	public void removeInfrastructure(Infrastructure i) {

		if (this.infrastructure.contains(i)) {
			this.infrastructure.remove(i);
		}
	}

}
