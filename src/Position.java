/**
 * 
 * @author OOP Gruppe 187
 *
 */
public class Position {
		private int anz;
		private Form form;
		private Teigart teigart;
		private Fuellung fuellung;

		/**
		 * 
		 * @return
		 */
		public int getAnz() {
			return anz;
		}

		/**
		 * 
		 * @return
		 */
		public Form getForm() {
			return form;
		}

		/**
		 * 
		 * @return
		 */
		public Teigart getTeigart() {
			return teigart;
		}

		/**
		 * 
		 * @return
		 */
		public Fuellung getFuellung() {
			return fuellung;
		}

		/**
		 * 
		 * @param a
		 * @param fo
		 * @param tart
		 * @param fu
		 */
		public Position(int a, Form fo, Teigart tart, Fuellung fu) {
			this.anz = a;
			this.form = fo;
			this.teigart = tart;
			this.fuellung = fu;
		}

		/**
		 * 
		 */
		@Override
		public String toString(){
			return "Anzahl: " + anz + " Form: " + form + " Teigart: " + teigart;
		}
	
}
