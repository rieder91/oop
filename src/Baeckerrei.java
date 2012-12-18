import java.util.ArrayList;
import java.util.Hashtable;

/**
 * a bakery which accepts orders and bakes them
 * 
 * it safes all orders, cookie boxes and machine in order to reuse them
 * 
 * @author OOP Gruppe 187
 * 
 */
public class Baeckerrei {
	
	private ArrayList<Bestellung>	               bestellungen	        = new ArrayList<Bestellung>();
	private ArrayList<Keksdose>	                   keksdosen	        = new ArrayList<Keksdose>();
	private Hashtable<Form, Backmaschine>	       normaleKeksmaschinen	= new Hashtable<Form, Backmaschine>();
	private Hashtable<EinfacherKeks, Backmaschine>	doppelKeksmaschinen	= new Hashtable<EinfacherKeks, Backmaschine>();
	
	/**
	 * produces the cookies specified in the order; cookies are only baked once
	 * 
	 * @return
	 */
	public Keksdose backe(Bestellung bestellung) {
		if (!this.bestellungen.contains(bestellung)) {
			this.bestellungen.add(bestellung);
			Keksdose kdose = new Keksdose();
			
			for (Position p : bestellung) {
				Backmaschine b = this.createMachineBasedOnPosition(p);
				for (int i = 0; i < p.getAnzahl(); i++) {
					Keks newKeks = b.backen();
					if (newKeks != null) {
						kdose.addKeks(newKeks);
					}
				}
			}
			this.keksdosen.add(kdose);
			return kdose;
		} else {
			return this.keksdosen.get(this.bestellungen.indexOf(bestellung));
		}
		
	}
	
	/**
	 * creates a new cookie-machine based on the position
	 * 
	 * can be extended for new machines very easily
	 * 
	 * we didn't want to create a new machine each time we bake a cookie, so we safe all machine that were created once
	 * and reuse them
	 * 
	 * @param p
	 *            position
	 * @return new cookie machine - the type depends on the type of cookie the position contains
	 */
	private Backmaschine createMachineBasedOnPosition(Position p) {
		Backmaschine b = null;
		if (p.isDoubleSidedCookie()) {
			EinfacherKeks template = new EinfacherKeks(p.getTeigart(), p.getForm());
			if (this.doppelKeksmaschinen.containsKey(new EinfacherKeks(p.getTeigart(), p.getForm()))) {
				b = this.doppelKeksmaschinen.get(template);
				b.setDetail(p.getFuellung());
				
			} else {
				b = new Doppelkeksbackmaschine(new EinfacherKeks(p.getTeigart(), p.getForm()));
				b.setDetail(p.getFuellung());
				
				this.doppelKeksmaschinen.put(template, b);
			}
			
		} else
			if (p.isSingleSidedCookie()) {
				if (this.normaleKeksmaschinen.containsKey(p.getForm())) {
					b = this.normaleKeksmaschinen.get(p.getForm());
					b.setDetail(p.getTeigart());
					
				} else {
					b = new Keksbackmaschine(p.getForm());
					b.setDetail(p.getTeigart());
					
					this.normaleKeksmaschinen.put(p.getForm(), b);
				}
				
			}
		// can simply be extended with additional else-ifs...
		
		return b;
	}
}
