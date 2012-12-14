
public class Doppelkeksbackmaschine extends Keksbackmaschine {

	Keks k;
	Fuellung f;
	public Doppelkeksbackmaschine(Keks k,Fuellung f) {
		super(k.getForm());
		this.k=k;
		this.f=f;
	}
	
	public Doppelkeks backen(){
		return (new Doppelkeks(this.k.clone(),this.f));
	}

}
