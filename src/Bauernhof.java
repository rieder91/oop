/**
 * Bauernhof Klasse
 * 
 * Folgende Methoden sollen unterstuetzt werden:
 * 
 * Erzeugen eines Bauernhofes.
 * Einfuegen von Traktoren in einen Bauernhof.
 * Entfernen von Traktoren aus einem Bauernhof.
 * aendern der Informationen ueber Traktoren wie oben beschrieben.
 * 
 * Methoden zum Berechnen folgender statistischer Werte:
 * 
 * Die durchschnittliche Anzahl der Betriebsstunden aller Traktoren eines
 * Bauernhofs – alle Traktoren zusammen und zusaetzlich aufgeschluesselt nach den
 * Einsatzarten (Saeen oder Duengen).
 * 
 * Die durchschnittliche Anzahl der Betriebsstunden aller Traktoren eines
 * Bauernhofs aufgeschluesselt nach der Art des Traktors (Dieseltraktor oder
 * Biogastraktor).
 * 
 * Der durchschnittliche Dieselverbrauch aller Diesetraktoren eines Bauernhofs –
 * alle zusammen und zusaetzlich aufgeschluesselt nach den Einsatzarten (Saeen oder
 * Duengen).
 * 
 * Der durchschnittliche Gasverbrauch aller Biogastraktoren eines Bauernhofs –
 * alle zusammen und zusaetzlich aufgeschluesselt nach den Einsatzarten (Saeen oder
 * Duengen).
 * 
 * Die minimale und maximale Anzahl an Saescharen insgesamt und aufgeschluesselt
 * nach Art des Traktors (Dieseltraktor oder Biogastraktor).
 * 
 * Die durchschnittliche Fassungskapazitaet des Duengerbehaelters aller Traktoren
 * insgesamt und aufgeschluesselt nach Art des Traktors (Dieseltraktor oder
 * Biogastraktor).
 * 
 * @author Thomas
 * 
 */
@Creator(name = "Thomas", lastUpdate = "09.12.2012")
public class Bauernhof {
	private final String name;
	private Liste traktoren;
	
	// list used to save the names of all existing farms
	private static Liste existingBauernhoefe = new Liste();
	
	/**
	 * one parameter constructor
	 * 
	 * @param name
	 *            name of the farm (unique)
	 */
	@Creator(name = "Dominic", lastUpdate = "08.12.2012")
	public Bauernhof(String name) {
		// check if the name if unique among all other Farms
		if (existingBauernhoefe.contains(name)) {
			throw new RuntimeException("Bauernhofname bereits vorhanden");
		} else {
			existingBauernhoefe.add(name);
		}

		this.name = name;
		traktoren = new Liste();
	}
	
	/**
	 * equals that only compares the name of two farms
	 */
	@Override
	@Creator(name = "Dominic", lastUpdate = "08.12.2012")
	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}

		if (other == null) {
			return false;
		}

		// only compare the name!
		if (other.equals(this.name)) {
			return true;
		} else {
			return false;
		}

	}
	
	/**
	 * adds a new tractor - given that it doesnt already exist
	 * 
	 * @param t
	 *            new tractor
	 */
	@Creator(name = "Dominic", lastUpdate = "08.12.2012")
	public void addTraktor(Traktor t) {
		// only add traktor if a traktor with the same serial has not been added
		// before
		if (!this.traktoren.contains(t)) {
			traktoren.add(t);
		}
	}

	/**
	 * removes a tractor with the serial passed as an argument
	 * 
	 * @param serial
	 *            serial of the tractor to be removed
	 */
	@Creator(name = "Dominic", lastUpdate = "08.12.2012")
	public void removeTraktor(int serial) {
		MyIterator it = traktoren.iterator();
		while (it.hasNext()) {
			if (it.next().equals(serial)) {
				it.remove();
			}
		}
	}
	
	/**
	 * returns a string representation of the farm
	 */
	@Creator(name = "Thomas", lastUpdate = "08.12.2012")
	public String toString() {
		return "Hofname: " + this.name + "\nTraktoren: \n" + traktoren.toString() + "\n";
	}
	
	/**
	 * increases the working hours of a certain tractor by a certain amount
	 * 
	 * @param serial
	 *            serial of the tractor whose working hours are increased
	 * @param hours
	 *            additional working hours
	 */
	@Creator(name = "Thomas", lastUpdate = "08.12.2012")
	protected void increaseHoursOfTraktor(int serial, int hours) {
		Traktor t = (Traktor) traktoren.searchFor(serial);

		if (t != null && hours > 0) {
			t.increaseHours(hours);
		}

	}
	
	/**
	 * returns the working hours of a tractor identified by the serial
	 * 
	 * @param serial
	 *            serial of the tractor
	 * @return working hours of the tractor
	 */
	@Creator(name = "Thomas", lastUpdate = "08.12.2012")
	protected int getHoursOfTraktor(int serial) {
		Traktor t = (Traktor) traktoren.searchFor(serial);

		if (t != null) {
			return t.getHours();
		} else {
			return 0;
		}
	}
	
	/**
	 * increases the fuel usage if the tractor with the given serial exists
	 * 
	 * @param serial
	 *            serial of the tractor
	 * @param liters
	 *            additional fuel usage
	 */
	@Creator(name = "Thomas", lastUpdate = "08.12.2012")
	protected void increaseFuelUsage(int serial, Object amount) {
		Traktor t = (Traktor) traktoren.searchFor(serial);

		if (t != null) {
			t.increaseFuel(amount);
		}
	}

	/**
	 * returns the fuel usage of the tractor identified by the serial if it
	 * exists
	 * 
	 * @param serial
	 *            serial of the tractor
	 * @return fuel usage of the tractor
	 */
	@Creator(name = "Thomas", lastUpdate = "08.12.2012")
	protected Object getFuelUsage(int serial) {
		Traktor t = (Traktor) traktoren.searchFor(serial);

		if (t != null) {
			return t.getFuel();
		} else {
			return null;
		}
	}


	
	/**
	 * changes the device attached to a tractor identified by its serial
	 * 
	 * @param serial
	 *            serial of the tractor
	 * @param geraet
	 *            new device
	 */
	@Creator(name = "Thomas", lastUpdate = "08.12.2012")
	protected void changeUsageOfTraktor(int serial, TraktorGeraet geraet) {
		Traktor t = (Traktor) traktoren.searchFor(serial);

		if (t != null) {
			if (geraet == null) {
				t.dismantle();
			} else {
				t.setEinsatzart(geraet);
			}
		}
	}

	/**
	 * returns the details of the device attached to the tractor
	 * @param serial serial of the tractor
	 * @return device detail
	 */
	@Creator(name = "Thomas", lastUpdate = "08.12.2012")
	protected Object getDeviceDetailOfTraktor(int serial) {
		Traktor t = ((Traktor) traktoren.searchFor(serial));
		TraktorGeraet tg;

		if(t != null) {
			tg = t.getGeraet();
		} else {
			return null;
		}
		
		if(tg != null) {
			return tg.getDetail();
		} else {
			return null;
		}
	}

	/**
	 * used to reduce duplicate code; calculates all the device statistics
	 * 
	 * @return List with the stats in the following order: avgOverall,
	 *         avgDiesel, avgGas, maxOverall, minOverall, maxGas, minGas,
	 *         maxDiesel, minDiesel
	 */
	@Creator(name = "Thomas", lastUpdate = "09.12.2012")
	private Liste getDeviceStats() {
		MyIterator it = traktoren.iterator();
		Liste ret = new Liste();

		double sumDiesel = 0.0, sumGas = 0.0;
		int cntDiesel = 0, cntGas = 0;

		int maxBio = 0, maxDiesel = 0;
		int minBio = Integer.MAX_VALUE, minDiesel = Integer.MAX_VALUE;

		while (it.hasNext()) {
			Traktor t = (Traktor) it.next();
			TraktorGeraet tg = t.getGeraet();

			if (tg != null) {
				if (tg instanceof Duengerstreuer) {
					Double value = (Double) tg.getDetail();
					// DO AVG STUFF
					if (t instanceof DieselTraktor) {
						cntDiesel++;
						sumDiesel += value;
					} else if (t instanceof BiogasTraktor) {
						cntGas++;
						sumGas += value;
					}

				} else if (tg instanceof Drillmaschine) {
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
	 * Die durchschnittliche Fassungskapazitaet des Duengerbehaelters aller
	 * Traktoren insgesamt und aufgeschluesselt nach Art des Traktors
	 * (Dieseltraktor oder Biogastraktor).
	 * 
	 * @return list with the stats int the following order: avgOverall,
	 *         avgDiesel, avgGas
	 */
	@Creator(name = "Thomas", lastUpdate = "09.12.2012")
	public Liste getDeviceCapacityStats() {
		Liste calc = getDeviceStats();
		Liste ret = new Liste();

		MyIterator it = calc.iterator();

		for (int i = 0; i < 3; i++) {
			ret.add(it.next());
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
	@Creator(name = "Thomas", lastUpdate = "09.12.2012")
	public Liste getDeviceSaescharenStats() {
		Liste calc = getDeviceStats();
		Liste ret = new Liste();

		MyIterator it = calc.iterator();

		for (int i = 0; i < 9; i++) {
			if (i >= 3) {
				ret.add(it.next());
			} else {
				it.next();
			}
		}

		return ret;
	}

	/**
	 * Der durchschnittliche Treibstoffverbrauch aller Biogastraktoren und
	 * Dieseltraktoren eines Bauernhofs – alle zusammen und zusaetzlich
	 * aufgeschluesselt nach den Einsatzarten (Saeen oder Duengen).
	 * 
	 * @return list with avg values in the following order: - avg All Biogas -
	 *         avg Duengen Biogas - avg Saeen Biogas - avg All Diesel - avg
	 *         Duengen Diesel - avg Saeen Diesel
	 */
	@Creator(name = "Markus", lastUpdate = "09.12.2012")
	private Liste getAverageFuelStats() {
		Double biofertilize = 0.0, biodrill = 0.0, bioall = 0.0;
		Double dieselfertilize = 0.0, dieseldrill = 0.0, dieselall = 0.0;
		Double helper = 0.0;
		int countfdieselfertilize = 0, countdieseldrill = 0, countdieselall = 0;
		int countfbiofertilize = 0, countbiodrill = 0, countbioall = 0;
		Traktor t;
		MyIterator it = this.traktoren.iterator();

		while (it.hasNext()) {
			t = (Traktor) it.next();
			if (t.getFuel() instanceof Double)
				helper = (Double) t.getFuel();
			if (t.getFuel() instanceof Integer)
				helper = ((Integer) t.getFuel()).doubleValue();

			if (t instanceof BiogasTraktor) {

				countbioall++;
				bioall = (bioall) + (helper);

				if (t.getGeraet() instanceof Duengerstreuer) {
					countfbiofertilize++;
					biofertilize = (biofertilize) + (helper);
				}
				if (t.getGeraet() instanceof Drillmaschine) {
					countbiodrill++;
					biodrill = (biodrill) + (helper);
				}

			} else {

				countdieselall++;
				dieselall = (dieselall) + (helper);

				if (t.getGeraet() instanceof Duengerstreuer) {
					countfdieselfertilize++;
					dieselfertilize = (dieselfertilize) + (helper);
				}
				if (t.getGeraet() instanceof Drillmaschine) {
					countdieseldrill++;
					dieseldrill = (dieseldrill) + (helper);
				}
			}
		}

		Liste ret = new Liste();
		if (countbioall != 0.0)
			bioall = bioall / countbioall;
		if (countfbiofertilize != 0.0)
			biofertilize = biofertilize / countfbiofertilize;
		if (countbiodrill != 0.0)
			biodrill = biodrill / countbiodrill;
		if (countdieselall != 0.0)
			dieselall = dieselall / countdieselall;
		if (countfdieselfertilize != 0.0)
			dieselfertilize = dieselfertilize / countfdieselfertilize;
		if (countdieseldrill != 0.0)
			dieseldrill = dieseldrill / countdieseldrill;

		ret.add(bioall);
		ret.add(biofertilize);
		ret.add(biodrill);

		ret.add(dieselall);
		ret.add(dieselfertilize);
		ret.add(dieseldrill);
		return ret;

	}

	/**
	 * Der durchschnittliche Dieselverbrauch aller Diesetraktoren eines
	 * Bauernhofs – alle zusammen und zusaetzlich aufgeschluesselt nach den
	 * Einsatzarten (Saeen oder Duengen).
	 * 
	 * @return list with avg values in the following order: - avg All - avg
	 *         Duengen - avg Saeen
	 */
	@Creator(name = "Markus", lastUpdate = "09.12.2012")
	public Liste getAverageFuelStatsDiesel() {

		Liste ret = new Liste();
		MyIterator it = getAverageFuelStats().iterator();
		it.next();
		it.next();
		it.next();
		ret.add(it.next());
		ret.add(it.next());
		ret.add(it.next());
		return ret;

	}

	/**
	 * Der durchschnittliche Gasverbrauch aller Biogastraktoren eines Bauernhofs
	 * – alle zusammen und zusaetzlich aufgeschluesselt nach den Einsatzarten
	 * (Saeen oder Duengen).
	 * 
	 * @return list with avg values in the following order: - avg All - avg
	 *         Duengen - avg Saeen
	 */
	@Creator(name = "Markus", lastUpdate = "09.12.2012")
	public Liste getAverageFuelStatsBio() {

		Liste ret = new Liste();
		MyIterator it = getAverageFuelStats().iterator();
		ret.add(it.next());
		ret.add(it.next());
		ret.add(it.next());
		return ret;

	}

	/**
	 * Die durchschnittliche Anzahl der Betriebsstunden aller Traktoren eines
	 * Bauernhofs – alle Traktoren zusammen und zusaetzlich aufgeschluesselt
	 * nach den Einsatzarten sowie der Art des Traktors.
	 * 
	 * @return List with results in following order: Gesamtstunden, Saeen,
	 *         Duengen, Dieseltraktor, Biotraktor
	 */
	@Creator(name = "Dominic", lastUpdate = "09.12.2012")
	private Liste getWorkingHoursStats() {
		Liste ret = new Liste();
		MyIterator it = this.traktoren.iterator();
		int all = 0, seed = 0, fertilize = 0, diesel = 0, bio = 0;
		int countAll = 0, countSeed = 0, countFertilize = 0, countDiesel = 0, countBio = 0;
		int tmp = 0;
		Traktor t = null;

		while (it.hasNext()) {
			t = (Traktor) it.next();
			tmp = t.getHours();

			countAll++;
			all += tmp;

			if (t instanceof DieselTraktor) {
				countDiesel++;
				diesel += tmp;
			} else if (t instanceof BiogasTraktor) {
				countBio++;
				bio += tmp;
			}

			if (t.getGeraet() instanceof Duengerstreuer) {
				countFertilize++;
				fertilize += tmp;
			} else if (t.getGeraet() instanceof Drillmaschine) {
				countSeed++;
				seed += tmp;
			}
		}

		if (all != 0) {
			ret.add(all / countAll);
		} else {
			ret.add(0);
		}

		if (seed != 0) {
			ret.add(seed / countSeed);
		} else {
			ret.add(0);
		}

		if (fertilize != 0) {
			ret.add(fertilize / countFertilize);
		} else {
			ret.add(0);
		}

		if (diesel != 0) {
			ret.add(diesel / countDiesel);
		} else {
			ret.add(0);
		}

		if (bio != 0) {
			ret.add(bio / countBio);
		} else {
			ret.add(0);
		}

		return ret;
	}

	/**
	 * Die durchschnittliche Anzahl der Betriebsstunden aller Traktoren eines
	 * Bauernhofs – alle Traktoren zusammen und zusaetzlich aufgeschluesselt
	 * nach den Einsatzarten (Saeen oder Duengen).
	 * 
	 * @return List with the results in the following order: overallAvg,
	 *         saeenAvg, dueengenAvg
	 */
	@Creator(name = "Dominic", lastUpdate = "09.12.2012")
	public Liste getWorkingHoursStatsByDevice() {
		Liste ret = new Liste();
		MyIterator it = getWorkingHoursStats().iterator();
		ret.add(it.next());
		ret.add(it.next());
		ret.add(it.next());
		return ret;
	}

	/**
	 * Die durchschnittliche Anzahl der Betriebsstunden aller Traktoren eines
	 * Bauernhofs aufgeschluesselt nach der Art des Traktors (Dieseltraktor oder
	 * Biogastraktor).
	 * 
	 * @return List with the results in the following order: overallAvg,
	 *         dieselAvg, gasAvg
	 */
	@Creator(name = "Dominic", lastUpdate = "09.12.2012")
	public Liste getWorkingHoursStatsByTractor() {
		Liste ret = new Liste();
		MyIterator it = getWorkingHoursStats().iterator();
		ret.add(it.next());
		it.next();
		it.next();
		ret.add(it.next());
		ret.add(it.next());
		return ret;
	}

}
