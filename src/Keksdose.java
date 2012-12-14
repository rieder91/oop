import java.util.ArrayList;


public class Keksdose {
	private ArrayList<Keks> al = new ArrayList<Keks>();
	
	public void addKeks(Keks k){
		al.add(k);
	}
	
	public void inhalt(){
		for(Keks k :this.al){
			System.out.println(k);
		}
	}
}
