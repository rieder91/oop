
public class Bestellung {

	public class Positionen{
		private int anz;
		private Form form;
		private Teigart teigart;
		private Fuellung fuellung;
		
		public Positionen(int a, Form fo, Teigart tart, Fuellung fu){
			this.anz=a;
			this.form=fo;
			this.teigart=tart;
			this.fuellung=fu;
		}
	}
}
