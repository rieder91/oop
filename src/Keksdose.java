import java.util.ArrayList;

/**
 * Als Ergebnis erhaelt man eine Keksdose, die mit allen entsprechenden Keksen gefuellt ist.
 * 
 * @author OOP Gruppe 187
 * 
 */
public class Keksdose {
	
	private ArrayList<Keks>	kekse;
	
	/**
	 * constructor to create a new cookie-box
	 */
	public Keksdose() {
		this.kekse = new ArrayList<Keks>();
	}
	
	/**
	 * adds a cookie to the cookie-box
	 * 
	 * @param k
	 *            new cookie
	 */
	protected void addKeks(Keks k) {
		this.kekse.add(k);
	}
	
	/**
	 * prints the contents of the cookie-box
	 */
	public void inhalt() {
		System.out.println("Keksdose: ");
		if(this.kekse.size() == 0) {
			System.out.println("keine Kekse vorhanden");
		}
		for (Keks k : this.kekse) {
			System.out.println(k);
		}
	}
	
	/**
	 * returns true if the cookie-box is empty
	 * 
	 * @return true if the box is empty
	 */
	public boolean isEmpty() {
		return this.kekse.isEmpty();
	}
}
