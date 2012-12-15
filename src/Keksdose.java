import java.util.ArrayList;

/**
 * 
 * @author OOP Gruppe 187
 *
 */
public class Keksdose {
	private ArrayList<Keks> al = new ArrayList<Keks>();
	
	/**
	 * 
	 * @param k
	 */
	protected void addKeks(Keks k){
		al.add(k);
	}
	
	/**
	 * 
	 */
	public void inhalt(){
		for(Keks k :this.al){
			System.out.println(k);
		}
	}
}
