import java.util.ArrayList;

/**
 * 
 * @author OOP Gruppe 187
 *
 */
public class Keksdose {
	private ArrayList<Keks> kekse;
	
	/**
	 * 
	 */
	public Keksdose() {
		kekse = new ArrayList<Keks>();
	}
	
	/**
	 * 
	 * @param k
	 */
	protected void addKeks(Keks k){
		kekse.add(k);
	}
	
	/**
	 * 
	 */
	public void inhalt() {
		for(Keks k : this.kekse){
			System.out.println(k);
		}
	}
	
	/**
	 * 
	 * @return
	 */
	public boolean isEmpty() {
		return kekse.isEmpty();
	}
}
