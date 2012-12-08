
@Creator()
public class Bauernhof {
	private final String name;
	private Liste traktoren;
	
	private static Liste existingBauernhoefe = new Liste();
	
	@Creator()
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
	
	@Creator()
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
	
	@Creator()
	public void addTraktor(Traktor t) {
		// only add traktor if a traktor with the same serial has not been added before
		if(!this.traktoren.contains(t)) {
			traktoren.add(t);
		}
	}
	
	@Creator()
	public void removeTraktor(int serial) {
		MyIterator it = traktoren.iterator();
		while(it.hasNext()) {
			if(it.next().equals(serial)) {
				it.remove();
			}
		}
	}
	
	@Creator()
	public String toString() {
		return traktoren.toString();
	}
	
	@Creator(name = "Thomas", lastUpdate = "08.12.2012")
	protected void increaseHoursOfTraktor(int serial, int hours) {
		Traktor t = (Traktor) traktoren.searchFor(serial);
		
		if(t != null && hours > 0) {
			t.increaseHours(hours);
		}
		
	}
	
	@Creator(name = "Thomas", lastUpdate = "08.12.2012")
	protected int getHoursOfTraktor(int serial) {
		Traktor t = (Traktor) traktoren.searchFor(serial);
		
		if(t != null) {
			return t.getHours();
		} else {
			return 0;
		}
	}
	
	@Creator(name = "Thomas", lastUpdate = "08.12.2012")
	protected void increaseDieselUsage(int serial, int liters) {
		Object t = traktoren.searchFor(serial);
		
		if(t != null && t instanceof DieselTraktor && liters > 0) {
			((DieselTraktor) t).increaseFuel(liters);
		}
	}
	
	@Creator(name = "Thomas", lastUpdate = "08.12.2012")
	protected int getDieselUsage(int serial) {
		Object t = traktoren.searchFor(serial);
		
		if(t != null && t instanceof DieselTraktor) {
			return ((DieselTraktor) t).getFuel();
		} else {
			return 0;
		}
	}
	
	@Creator(name = "Thomas", lastUpdate = "08.12.2012")
	protected void increaseGasUsage(int serial, double gas) {
		Object t = traktoren.searchFor(serial);
		
		if(t != null && t instanceof BiogasTraktor && gas > 0.0) {
			((BiogasTraktor) t).increaseFuel(gas);
		}
	}
	
	@Creator(name = "Thomas", lastUpdate = "08.12.2012")
	protected double getGasUsage(int serial) {
		Object t = traktoren.searchFor(serial);

		if (t != null && t instanceof BiogasTraktor) {
			return ((BiogasTraktor) t).getFuel();
		} else {
			return 0.0;
		}
	}
	
	@Creator(name = "Thomas", lastUpdate = "08.12.2012")
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
	
	@Creator(name = "Thomas", lastUpdate = "08.12.2012")
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
	
	@Creator(name = "Thomas", lastUpdate = "08.12.2012")
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

	/**
	 * Die durchschnittliche Fassungskapazitaet des Düngerbehaelters aller
	 * Traktoren insgesamt und aufgeschluesselt nach Art des Traktors
	 * (Dieseltraktor oder Biogastraktor).
	 * 
	 * @return list with the stats int the following order: avgOverall,
	 *         avgDiesel, avgGas
	 */
	@Creator(name = "Thomas", lastUpdate = "08.12.2012")
	protected Liste getCapacityStats() {
		MyIterator it = traktoren.iterator();
		Liste ret = new Liste();

		double sumDiesel = 0.0, sumGas = 0.0;
		int cntDiesel = 0, cntGas = 0;

		while (it.hasNext()) {
			Traktor t = (Traktor) it.next();
			TraktorGeraet tg = t.getGeraet();

			if (tg != null && tg instanceof Duengerstreuer) {

				Double value = (Double) tg.getDetail();

				if (t instanceof DieselTraktor) {
					cntDiesel++;
					sumDiesel += value;
				} else if (t instanceof BiogasTraktor) {
					cntGas++;
					sumGas += value;
				}
			}
		}

		if (cntDiesel != 0 || cntGas != 0) {
			ret.add((sumDiesel + sumGas) / (cntDiesel + cntGas));
		} else {
			ret.add(0.0);
		}

		if (cntDiesel != 0) {
			ret.add(sumDiesel / cntDiesel);
		} else {
			ret.add(0.0);
		}

		if (cntGas != 0) {
			ret.add(sumGas / cntGas);
		} else {
			ret.add(0.0);
		}

		return ret;
	}
	
	/**
	 * Die minimale und maximale Anzahl an Saescharen insgesamt und
	 * aufgeschluesselt nach Art des Traktors (Dieseltraktor oder
	 * Biogastraktor).
	 * 
	 * @return list with max/min values in the following order: maxOverall,
	 *         minOverall, maxGas, minGas, maxDiesel, minDiesel
	 */
	@Creator(name = "Thomas", lastUpdate = "08.12.2012")
	protected Liste getSaescharenStats() {
		MyIterator it = traktoren.iterator();
		Liste ret = new Liste();

		int maxBio = 0, maxDiesel = 0, minBio = Integer.MAX_VALUE, minDiesel = Integer.MAX_VALUE;

		while (it.hasNext()) {
			Traktor t = (Traktor) it.next();
			TraktorGeraet tg = t.getGeraet();

			if (tg != null && tg instanceof Drillmaschine) {
				Integer value = (Integer) tg.getDetail();

				if (t instanceof BiogasTraktor) {

					if (value < minBio) {
						minBio = value;
					}

					if (value > maxBio) {
						maxBio = value;
					}

				} else if (t instanceof DieselTraktor) {

					if (value < minDiesel) {
						minDiesel = value;
					}

					if (value > maxDiesel) {
						maxDiesel = value;
					}

				}

			}
		}

		ret.add(maxBio > maxDiesel ? maxBio : maxDiesel);
		ret.add(minBio < minDiesel ? minBio : minDiesel);

		if (maxDiesel != 0) {
			ret.add(maxDiesel);
			ret.add(minDiesel);
		} else {
			ret.add(0);
			ret.add(0);
		}

		if (maxBio != 0) {
			ret.add(maxBio);
			ret.add(minBio);
		} else {
			ret.add(0);
			ret.add(0);
		}

		return ret;
	}
	
	/**
	 * Der durchschnittliche Dieselverbrauch aller Diesetraktoren eines Bauernhofs 
	 * – alle zusammen und zusaetzlich aufgeschluesselt nach den Einsatzarten (Saeen oder Duengen).
	 * 
	 * @return list with avg values in the following order:
	 * 		- avg All
	 * 		- avg Duengen
	 * 		- avg Saeen
	 */
	@Creator(name = "Markus", lastUpdate = "08.12.2012")
	public Liste avgDiesel(){
		Integer fertilize=0;
		Integer drill=0;
		Integer all=0;
		Integer helper = 0;
		Traktor t;
		MyIterator it=this.traktoren.iterator();
		
		while (it.hasNext()){
			t=(Traktor)it.next();
			helper = ((DieselTraktor) t).getFuel();
			if(t instanceof DieselTraktor){
				all+=helper;
				if(t.getGeraet() instanceof Duengerstreuer){
					fertilize+=helper;
				}
				if(t.getGeraet() instanceof Drillmaschine){
					drill+=helper;
				}
			}
		}
		
		Liste ret=new Liste();
		ret.add(all);
		ret.add(fertilize);
		ret.add(drill);
		return traktoren;
		
	}
	
	/**
	 * Der durchschnittliche Gasverbrauch aller Biogastraktoren eines Bauernhofs – 
	 * alle zusammen und zusaetzlich aufgeschluesselt nach den Einsatzarten (Saeen oder Duengen).
	 * 
	 * @return list with avg values in the following order:
	 * 		- avg All
	 * 		- avg Duengen
	 * 		- avg Saeen
	 */
	@Creator(name = "Markus", lastUpdate = "08.12.2012")
	public Liste avgGas(){
		Double fertilize=0.0;
		Double drill=0.0;
		Double all=0.0;
		Double helper = 0.0;
		Traktor t;
		MyIterator it=this.traktoren.iterator();
		
		while (it.hasNext()){
			t=(Traktor)it.next();
			helper = ((BiogasTraktor) t).getFuel();
			
			if(t instanceof BiogasTraktor){
				all+=helper;
				if(t.getGeraet() instanceof Duengerstreuer){
					fertilize+=helper;
				}
				if(t.getGeraet() instanceof Drillmaschine){
					drill+=helper;
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
