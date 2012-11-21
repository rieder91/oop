

public interface SecurityLevel {
	public void isAllowed(Hilfskraft android);
	public void isAllowed(Gesellschaftler android);
	public void isAllowed(Bauarbeiter android);
	public void isAllowed(ServiceTechniker android);
	public void isAllowed(Transportarbeiter android);
	public void isAllowed(Objektbewacher android);
	public void isAllowed(Leibwaechter android);
	public void isAllowed(Kaempfer android);
}
