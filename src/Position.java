/**
 * 
 * @author OOP Gruppe 187
 *
 */
public class Position {
		private int anzahl;
		private Form form;
		private Teigart teigart;
		private Fuellung fuellung;

		
		/**
		 * constructor for a double sided cookie
		 * @param anzahl
		 * @param form
		 * @param teigart
		 * @param fuellung
		 */
		public Position(int anzahl, Form form, Teigart teigart, Fuellung fuellung) {
			this.anzahl = anzahl;
			this.form = form;
			this.teigart = teigart;
			this.fuellung = fuellung;
		}
		
		/**
		 * constructor for a single sided cookie
		 * @param anzahl
		 * @param form
		 * @param teigart
		 */
		public Position(int anzahl, Form form, Teigart teigart) {
			this(anzahl, form, teigart, null);
		}
		
		
		/**
		 * 
		 * @return
		 */
		protected int getAnzahl() {
			return anzahl;
		}

		/**
		 * 
		 * @return
		 */
		protected Form getForm() {
			return form;
		}

		/**
		 * 
		 * @return
		 */
		protected Teigart getTeigart() {
			return teigart;
		}

		/**
		 * 
		 * @return
		 */
		protected Fuellung getFuellung() {
			return fuellung;
		}
		
		/**
		 * 
		 * @return
		 */
		public boolean isDoubleSidedCookie() {
			return fuellung != null;
		}
		

		/**
		 * toString-Method for fancy output
		 */
		@Override
		public String toString(){
			StringBuilder ret = new StringBuilder();
			
			ret.append("Position: ");
			
			if(fuellung == null) {
				ret.append("Einfacher Keks - ");
				ret.append("Anzahl: " + anzahl + ", Form: " + form + ", Teigart: " + teigart);
			} else {
				ret.append("Doppelter Keks - ");
				ret.append("Anzahl: " + anzahl + ", Form: " + form + ", Teigart: " + teigart + ", Fuellung: " + fuellung);
			}
			
			return ret.toString();
		}
	
}
