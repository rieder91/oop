
public class Position {
		private int anz;
		private Form form;
		private Teigart teigart;
		private Fuellung fuellung;

		public int getAnz() {
			return anz;
		}

		public Form getForm() {
			return form;
		}

		public Teigart getTeigart() {
			return teigart;
		}

		public Fuellung getFuellung() {
			return fuellung;
		}

		

		public Position(int a, Form fo, Teigart tart, Fuellung fu) {
			this.anz = a;
			this.form = fo;
			this.teigart = tart;
			this.fuellung = fu;
		}

		@Override
		public String toString(){
			return "Anzahl: " + anz + " Form: " + form + " Teigart: " + teigart;
		}
	
}
