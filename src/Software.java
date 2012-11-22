public interface Software {

	public void vonHilfskraftInstalliert(Hilfskraft android);

	public void vonGesellschaftlerInstalliert(Gesellschaftler android);

	public void vonBauarbeiterInstalliert(Bauarbeiter android);

	public void vonServiceTechnikerInstalliert(ServiceTechniker android);

	public void vonTransportarbeiterInstalliert(Transportarbeiter android);

	public void vonObjektbewacherInstalliert(Objektbewacher android);

	public void vonLeibwaechterInstalliert(Leibwaechter android);

	public void vonKaempferInstalliert(Kaempfer android);
	
	public SecurityLevel getSecurityLevel();
}
