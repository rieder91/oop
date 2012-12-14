
public class Keksbackmaschine {
	Form f;
	
	public Keksbackmaschine(Form f){
		this.f=f;
	}
	
	public Keks backen(Teigart t){
		return (new Keks(t,f));
	}
}
