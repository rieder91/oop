import java.util.ArrayList;
import java.util.Iterator;

//TODO
public class Bestellung implements Iterable<Position> {

	private ArrayList<Position> positionen = new ArrayList<Position>();
	private Keksdose kekse = new Keksdose();

	public void addPosition(int a, Form f, Teigart t, Fuellung fu) {
		positionen.add(new Position(a, f, t, fu));
	}

	@Override
	public Iterator<Position> iterator() {
		return this.positionen.iterator();
	}
	
	public void drucke(){
		for(Position p:this.positionen){
			System.out.println(p);
		}
	}
	
	public Keksdose backen(){
		for(Position p:this.positionen){
		}
		return null;
	}

}
