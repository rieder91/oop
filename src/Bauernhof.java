
public class Bauernhof {
	private final String name;
	private Liste traktoren;
	
	public Bauernhof(String name) {
		this.name = name;
		traktoren = new Liste();
	}
	
	public void addTraktor(Traktor t) {
		traktoren.add(t);
	}
	
	public void removeTraktor(int serial) {
		MyIterator it = traktoren.iterator();
		while(it.hasNext()) {
			Traktor t = (Traktor) it.next();
			if(t.getNummer() == serial) {
				it.remove();
			}
		}
	}
	
	public String toString() {
		return traktoren.toString();
	}
	
	public void increaseHours(int serial, int hours) {
		
	}
	
	public void increaseHours(Traktor t, int hours) {
		
	}
	
	public int getDiesel(int serial) {
		return 0;
	}
	
	public double getGas(int serial) {
		return 0;
	}

	public String getName() {
		return name;
	}
	
	
	
	
}
