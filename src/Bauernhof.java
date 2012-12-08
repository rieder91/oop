
public class Bauernhof {
	private final String name;
	private Liste traktoren;
	
	private static Liste existingBauernhoefe = new Liste();
	
	public Bauernhof(String name) {
		// check if the name if unique among all other Farms
		if(existingBauernhoefe.contains(name)) {
			throw new RuntimeException("Bauernhofname bereits vorhanden");
		} else {
			existingBauernhoefe.add(name);
		}

		this.name = name;
		traktoren = new Liste();
	}
	
	public boolean equals(Object other) {
		if(this == other) {
			return true;
		}
		
		if(other == null) {
			return false;
		}
		
		// only compare the name!
		if (other.equals(this.name)) {
			return true;
		} else {
			return false;
		}
		
	}
	
	public void addTraktor(Traktor t) {
		// only add traktor if a traktor with the same serial has not been added before
		if(!this.traktoren.contains(t)) {
			traktoren.add(t);
		}
	}
	
	public void removeTraktor(int serial) {
		MyIterator it = traktoren.iterator();
		while(it.hasNext()) {
			if(it.next().equals(serial)) {
				it.remove();
			}
		}
	}
	
	public String toString() {
		return traktoren.toString();
	}
	
	protected void increaseHoursOfTraktor(int serial, int hours) {
		Traktor t = (Traktor) traktoren.searchFor(serial);
		
		if(t != null && hours > 0) {
			t.increaseHours(hours);
		}
		
	}
	
	protected int getHoursOfTraktor(int serial) {
		Traktor t = (Traktor) traktoren.searchFor(serial);
		
		if(t != null) {
			return t.getHours();
		} else {
			return 0;
		}
	}
	
	protected void increaseDieselUsage(int serial, int liters) {
		Object t = traktoren.searchFor(serial);
		
		if(t != null && t instanceof DieselTraktor && liters > 0) {
			((DieselTraktor) t).increaseFuel(liters);
		}
	}
	
	protected int getDieselUsage(int serial) {
		Object t = traktoren.searchFor(serial);
		
		if(t != null && t instanceof DieselTraktor) {
			return ((DieselTraktor) t).getFuel();
		} else {
			return 0;
		}
	}
	
	protected void increaseGasUsage(int serial, double gas) {
		Object t = traktoren.searchFor(serial);
		
		if(t != null && t instanceof BiogasTraktor && gas > 0.0) {
			((BiogasTraktor) t).increaseFuel(gas);
		}
	}
	
	protected double getGasUsage(int serial) {
		Object t = traktoren.searchFor(serial);

		if (t != null && t instanceof BiogasTraktor) {
			return ((BiogasTraktor) t).getFuel();
		} else {
			return 0.0;
		}
	}
	
	protected void changeUsageOfTraktor(int serial, TraktorGeraet geraet) {
		Traktor t = (Traktor) traktoren.searchFor(serial);
		
		if(t != null) {
			if(geraet == null) {
				t.dismantle();
			} else {
				t.setEinsatzart(geraet);
			}
		}
	}
	
	protected int getSaeschareCountOfTraktor(int serial) {
		Traktor t = ((Traktor) traktoren.searchFor(serial));
		TraktorGeraet tg;

		if(t != null) {
			tg = t.getGeraet();
		} else {
			return 0;
		}
		
		if(tg != null && tg instanceof Drillmaschine) {
			return (Integer) tg.getDetail();
		} else {
			return 0;
		}
	}
	
	protected double getCapacityOfTraktor(int serial) {
		Traktor t = (Traktor) traktoren.searchFor(serial);
		TraktorGeraet tg;
		
		if(t != null) {
			tg = t.getGeraet();
		} else {
			return 0.0;
		}
		
		if(tg != null && tg instanceof Duengerstreuer) {
			return (Double) tg.getDetail();
		} else {
			return 0.0;
		}
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
