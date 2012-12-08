
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
	
	
	public Liste avgDiesel(){
		Integer fertilize=0;
		Integer drill=0;
		Integer all=0;
		Traktor t;
		MyIterator it=this.traktoren.iterator();
		
		while (it.hasNext()){
			t=(Traktor)it.next();
			
			if(t instanceof DieselTraktor){
				all+=((DieselTraktor) t).getFuel();
				if(t.getGeraet() instanceof Duengerstreuer){
					fertilize+=((DieselTraktor) t).getFuel();
				}
				if(t.getGeraet() instanceof Drillmaschine){
					drill+=((DieselTraktor) t).getFuel();
				}
			}
		}
		
		Liste ret=new Liste();
		ret.add(all);
		ret.add(fertilize);
		ret.add(drill);
		return traktoren;
		
	}
	
	public Liste avgGas(){
		Double fertilize=0.0;
		Double drill=0.0;
		Double all=0.0;
		Traktor t;
		MyIterator it=this.traktoren.iterator();
		
		while (it.hasNext()){
			t=(Traktor)it.next();
			
			if(t instanceof BiogasTraktor){
				all+=((BiogasTraktor) t).getFuel();
				if(t.getGeraet() instanceof Duengerstreuer){
					fertilize+=((DieselTraktor) t).getFuel();
				}
				if(t.getGeraet() instanceof Drillmaschine){
					drill+=((DieselTraktor) t).getFuel();
				}
			}
		}
		
		Liste ret=new Liste();
		ret.add(all);
		ret.add(fertilize);
		ret.add(drill);
		return traktoren;
		
		
	}
}
