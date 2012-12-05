
public class Bauernhof {
	private final String name;
	private Liste traktoren;
	private static Liste existingBauernhoefe = new Liste();
	
	public Bauernhof(String name) {
		MyIterator it = existingBauernhoefe.iterator();
		while(it.hasNext()) {
			if(it.next().equals(name)) {
				throw new RuntimeException("Bauernhofname bereits vorhanden");
			}
		}
		this.name = name;
		existingBauernhoefe.add(name);
		traktoren = new Liste();
	}
	
	// TODO proper equals
	public boolean equals(Object query) {
		if(String.class.isAssignableFrom(query.getClass())) {
			return ((String) query).equals(name);
		}
		return false;
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
