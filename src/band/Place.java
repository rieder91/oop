package band;

import java.util.ArrayList;

/**
 * 
 * @author Thomas
 *
 */
public class Place {
	private String name;
	private ArrayList<Infrastructure> infrastructure;
	

	/**
	 * 
	 * @param name
	 */
	public Place(String name) {
		this.name = name;
		infrastructure = new ArrayList<Infrastructure>();
	}

	/**
	 * 
	 * @return
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * 
	 * @param inf
	 * @return
	 */
	public boolean hasInfrastructure(ArrayList<Infrastructure> inf) {
		for(Infrastructure i : inf) {
			if(!hasInfrastructure(i)) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * 
	 * @param inf
	 * @return
	 */
	public boolean hasInfrastructure(Infrastructure inf) {
		return infrastructure.contains(inf);
	}
	
	/**
	 * 
	 * @param i
	 */
	public void addInfrastructure(Infrastructure i) {
		if(!infrastructure.contains(i)) {
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
		if(infrastructure.contains(i)) {
			infrastructure.remove(i);
		}
	}
	

}
