package band;

import java.util.ArrayList;

/**
 * contains all informations concerining one place
 * 
 * @author OOP Gruppe 187
 * 
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
		infrastructure = new ArrayList<Infrastructure>();
	}

	/**
	 * @return name of the place
	 */
	public String getName() {
		return name;
	}

	/**
	 * true if the infrastructure is available
	 * 
	 * @param inf
	 *            infrastructure that the place is searched for
	 * @return true if available; false otherwise
	 */
	public boolean hasInfrastructure(ArrayList<Infrastructure> inf) {
		for (Infrastructure i : inf) {
			if (!hasInfrastructure(i)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * checks the place if one infrastructure-element is available
	 * 
	 * @param inf
	 *            one infrastructure object
	 * @return true if the place has the required infrastrucutre; false
	 *         otherwise
	 */
	public boolean hasInfrastructure(Infrastructure inf) {
		return infrastructure.contains(inf);
	}

	/**
	 * adds an infrastructure to the place
	 * 
	 * @param i
	 *            infrastructure that is being added
	 */
	public void addInfrastructure(Infrastructure i) {
		if (!infrastructure.contains(i)) {
			infrastructure.add(i);
		}
	}

	/**
	 * 
	 * @return
	 */
	public ArrayList<Infrastructure> getInfrastructure() {
		return infrastructure;
	}

	/**
	 * 
	 * @param i
	 */
	public void removeInfrastructure(Infrastructure i) {
		if (infrastructure.contains(i)) {
			infrastructure.remove(i);
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((infrastructure == null) ? 0 : infrastructure.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Place other = (Place) obj;
		if (infrastructure == null) {
			if (other.infrastructure != null)
				return false;
		} else {
			for (Infrastructure i : this.infrastructure) {
				if (!other.infrastructure.contains(i)) {
					return false;
				}
			}
		}
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}
