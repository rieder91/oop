public interface Software {

	public void installiertIn(Hilfskraft android);

	public void installiertIn(Gesellschaftler android);

	public void installiertIn(Bauarbeiter android);

	public void installiertIn(ServiceTechniker android);

	public void installiertIn(Transportarbeiter android);

	public void installiertIn(Objektbewacher android);

	public void installiertIn(Leibwaechter android);

	public void installiertIn(Kaempfer android);
	
	public void installiertIn(Android android);
	
	public SecurityLevel getSecurityLevel();
}
