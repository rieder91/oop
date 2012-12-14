import java.util.ArrayList;


public class Keksdose {
	private ArrayList<Keks> al = new ArrayList<Keks>();
	
	public void addKeks(Keks k){
		al.add(k);
	}
	
	public ArrayList<Keks> getKekse(){
		return this.al;
	}
}
