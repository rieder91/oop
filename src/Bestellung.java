import java.util.ArrayList;
import java.util.Iterator;

//TODO
public class Bestellung implements Iterable<Position> {

	private ArrayList<Position> al = new ArrayList<Position>();

	public void addPosition(int a, Form f, Teigart t, Fuellung fu) {
		al.add(new Position(a, f, t, fu));
	}

	@Override
	public Iterator<Position> iterator() {
		return this.al.iterator();
	}
	
	public void drucke(){
		for(Position p:this.al){
			System.out.println(p);
		}
	}

}
