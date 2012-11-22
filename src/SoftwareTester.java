
/**
 * This class tests the implementation of Software
 * 
 * THIS CLASS IS FOR TESTING PURPOSES ONLY AND NOT PART OF THE 
 * ACTUAL SOLUTION FOR THE ASSIGNMENT - THAT IS WHY WE USED INSTANCEOF!
 * 
 * @author Thomas
 *
 */
public class SoftwareTester implements Tester {

	/**
	 * default constructor
	 */
	public SoftwareTester() { }

	@Override
	public void runTests() {
		// Bediener
		Hilfskraft hilf = new Hilfskraft("Hilfroboter");
		Gesellschaftler gesell = new Gesellschaftler("Gesellschaftsroboter");

		// Schwerarbeiter
		Bauarbeiter bau = new Bauarbeiter("Bauroboter");
		ServiceTechniker service = new ServiceTechniker("Serviceroboter");
		Transportarbeiter transport = new Transportarbeiter("Transportroboter");

		// Beschuetzer
		Kaempfer kampf = new Kaempfer("Kampfroboter");
		Leibwaechter leib = new Leibwaechter("Leibwaechteroboter");
		Objektbewacher object = new Objektbewacher("Objektroboter");

		// alle Skins
		BeruehrungssensitiverSkin bSkin = new BeruehrungssensitiverSkin();
		HochfesterSkin hSkin = new HochfesterSkin();
		GepanzerterSkin gSkin = new GepanzerterSkin();

		// alle Security levels
		SecurityLevel1 level1 = new SecurityLevel1();
		SecurityLevel2 level2 = new SecurityLevel2();
		SecurityLevel3 level3 = new SecurityLevel3();
		SecurityLevel4 level4 = new SecurityLevel4();
		SecurityLevel5 level5 = new SecurityLevel5();


		// all possible software combos - for testing
		HilfskraefteSoftware hilfS1 = new HilfskraefteSoftware(level1);
		HilfskraefteSoftware hilfS2 = new HilfskraefteSoftware(level2);
		HilfskraefteSoftware hilfS3 = new HilfskraefteSoftware(level3);
		HilfskraefteSoftware hilfS4 = new HilfskraefteSoftware(level4);
		HilfskraefteSoftware hilfS5 = new HilfskraefteSoftware(level5);

		GesellschaftlerSoftware gesellS1 = new GesellschaftlerSoftware(level1);
		GesellschaftlerSoftware gesellS2 = new GesellschaftlerSoftware(level2);
		GesellschaftlerSoftware gesellS3 = new GesellschaftlerSoftware(level3);
		GesellschaftlerSoftware gesellS4 = new GesellschaftlerSoftware(level4);
		GesellschaftlerSoftware gesellS5 = new GesellschaftlerSoftware(level5);


		BauarbeiterSoftware bauS1 = new BauarbeiterSoftware(level1);
		BauarbeiterSoftware bauS2 = new BauarbeiterSoftware(level2);
		BauarbeiterSoftware bauS3 = new BauarbeiterSoftware(level3);
		BauarbeiterSoftware bauS4 = new BauarbeiterSoftware(level4);
		BauarbeiterSoftware bauS5 = new BauarbeiterSoftware(level5);

		ServiceTechnikerSoftware serviceS1 = new ServiceTechnikerSoftware(level1);
		ServiceTechnikerSoftware serviceS2 = new ServiceTechnikerSoftware(level2);
		ServiceTechnikerSoftware serviceS3 = new ServiceTechnikerSoftware(level3);
		ServiceTechnikerSoftware serviceS4 = new ServiceTechnikerSoftware(level4);
		ServiceTechnikerSoftware serviceS5 = new ServiceTechnikerSoftware(level5);

		TransportarbeiterSoftware transportS1 = new TransportarbeiterSoftware(level1);
		TransportarbeiterSoftware transportS2 = new TransportarbeiterSoftware(level2);
		TransportarbeiterSoftware transportS3 = new TransportarbeiterSoftware(level3);
		TransportarbeiterSoftware transportS4 = new TransportarbeiterSoftware(level4);
		TransportarbeiterSoftware transportS5 = new TransportarbeiterSoftware(level5);


		KaempferSoftware kampfS1 = new KaempferSoftware(level1);
		KaempferSoftware kampfS2 = new KaempferSoftware(level2);
		KaempferSoftware kampfS3 = new KaempferSoftware(level3);
		KaempferSoftware kampfS4 = new KaempferSoftware(level4);
		KaempferSoftware kampfS5 = new KaempferSoftware(level5);

		LeibwaechterSoftware leibS1 = new LeibwaechterSoftware(level1);
		LeibwaechterSoftware leibS2 = new LeibwaechterSoftware(level2);
		LeibwaechterSoftware leibS3 = new LeibwaechterSoftware(level3);
		LeibwaechterSoftware leibS4 = new LeibwaechterSoftware(level4);
		LeibwaechterSoftware leibS5 = new LeibwaechterSoftware(level5);

		ObjektbewacherSoftware objectS1 = new ObjektbewacherSoftware(level1);
		ObjektbewacherSoftware objectS2 = new ObjektbewacherSoftware(level2);
		ObjektbewacherSoftware objectS3 = new ObjektbewacherSoftware(level3);
		ObjektbewacherSoftware objectS4 = new ObjektbewacherSoftware(level4);
		ObjektbewacherSoftware objectS5 = new ObjektbewacherSoftware(level5);
		
		
		
		

	}

}
