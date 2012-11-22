
public class SensorenAktorenKitInf implements SensorenAktorenKit {
	@SuppressWarnings("unused")
	private final String seriennummer;
	
	public SensorenAktorenKitInf() {
		seriennummer = null;
	}
	
	private SensorenAktorenKitInf(String seriennummer) {
		this.seriennummer = seriennummer;
	}

	@Override
	public void vonBedienerInstalliert(Bediener android) {
		
	}
	
	@Override
	public void vonKaempferInstalliert(Kaempfer android) {
		// TODO Auto-generated method stub
		android.calledFromLeistungUnbegrenzt(new SensorenAktorenKitInf(android.getSeriennummer()));
		
	}

	@Override
	public void vonLevel3Installiert(Android android) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void vonLevel4Installiert(Android android) {
		// TODO Auto-generated method stub
		
	}

}
