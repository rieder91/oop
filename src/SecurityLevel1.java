

public class SecurityLevel1 implements SecurityLevel {
	
	@Override
	public void isAllowed(Hilfskraft android, HilfskraefteSoftware s) {
		android.calledFromLevel1(s);
//		android.(this);
		// TODO Auto-generated method stub
		
	}

	@Override
	public void isAllowed(Gesellschaftler android) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void isAllowed(Bauarbeiter android) {
	}

	@Override
	public void isAllowed(ServiceTechniker android) {
	}

	@Override
	public void isAllowed(Transportarbeiter android) {
	}

	@Override
	public void isAllowed(Objektbewacher android) {
	}

	@Override
	public void isAllowed(Leibwaechter android) {
	}

	@Override
	public void isAllowed(Kaempfer android) {
	}
}
