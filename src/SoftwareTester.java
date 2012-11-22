
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

	public void runTests() {
		// Bediener
		Android hilf = new Hilfskraft("Hilfroboter");
		Android gesell = new Gesellschaftler("Gesellschaftsroboter");

		// Schwerarbeiter
		Android bau = new Bauarbeiter("Bauroboter");
		Android service = new ServiceTechniker("Serviceroboter");
		Android transport = new Transportarbeiter("Transportroboter");

		// Beschuetzer
		Android kampf = new Kaempfer("Kampfroboter");
		Android leib = new Leibwaechter("Leibwaechteroboter");
		Android object = new Objektbewacher("Objektroboter");

		// alle Security levels
		SecurityLevel level1 = new SecurityLevel1();
		SecurityLevel level2 = new SecurityLevel2();
		SecurityLevel level3 = new SecurityLevel3();
		SecurityLevel level4 = new SecurityLevel4();
		SecurityLevel level5 = new SecurityLevel5();


		// all possible software combos - for testing
		Software hilfS1 = new HilfskraefteSoftware(level1);
		Software hilfS2 = new HilfskraefteSoftware(level2);
		Software hilfS3 = new HilfskraefteSoftware(level3);
		Software hilfS4 = new HilfskraefteSoftware(level4);
		Software hilfS5 = new HilfskraefteSoftware(level5);

		Software gesellS1 = new GesellschaftlerSoftware(level1);
		Software gesellS2 = new GesellschaftlerSoftware(level2);
		Software gesellS3 = new GesellschaftlerSoftware(level3);
		Software gesellS4 = new GesellschaftlerSoftware(level4);
		Software gesellS5 = new GesellschaftlerSoftware(level5);


		Software bauS1 = new BauarbeiterSoftware(level1);
		Software bauS2 = new BauarbeiterSoftware(level2);
		Software bauS3 = new BauarbeiterSoftware(level3);
		Software bauS4 = new BauarbeiterSoftware(level4);
		Software bauS5 = new BauarbeiterSoftware(level5);

		Software serviceS1 = new ServiceTechnikerSoftware(level1);
		Software serviceS2 = new ServiceTechnikerSoftware(level2);
		Software serviceS3 = new ServiceTechnikerSoftware(level3);
		Software serviceS4 = new ServiceTechnikerSoftware(level4);
		Software serviceS5 = new ServiceTechnikerSoftware(level5);

		Software transportS1 = new TransportarbeiterSoftware(level1);
		Software transportS2 = new TransportarbeiterSoftware(level2);
		Software transportS3 = new TransportarbeiterSoftware(level3);
		Software transportS4 = new TransportarbeiterSoftware(level4);
		Software transportS5 = new TransportarbeiterSoftware(level5);


		Software kampfS1 = new KaempferSoftware(level1);
		Software kampfS2 = new KaempferSoftware(level2);
		Software kampfS3 = new KaempferSoftware(level3);
		Software kampfS4 = new KaempferSoftware(level4);
		Software kampfS5 = new KaempferSoftware(level5);

		Software leibS1 = new LeibwaechterSoftware(level1);
		Software leibS2 = new LeibwaechterSoftware(level2);
		Software leibS3 = new LeibwaechterSoftware(level3);
		Software leibS4 = new LeibwaechterSoftware(level4);
		Software leibS5 = new LeibwaechterSoftware(level5);

		Software objectS1 = new ObjektbewacherSoftware(level1);
		Software objectS2 = new ObjektbewacherSoftware(level2);
		Software objectS3 = new ObjektbewacherSoftware(level3);
		Software objectS4 = new ObjektbewacherSoftware(level4);
		Software objectS5 = new ObjektbewacherSoftware(level5);

		
		hilf.softwareInstallieren(gesellS1);
		Validator.report(hilf.getSoftware() == null, "versuchen Gesellschaflersoftware(1) in einem Hilfsroboter zu installieren");
		
		hilf.softwareInstallieren(bauS1);
		Validator.report(hilf.getSoftware() == null, "versuchen Bausoftware(1) in einem Hilfsroboter zu installieren");
		
		hilf.softwareInstallieren(serviceS1);
		Validator.report(hilf.getSoftware() == null, "versuchen Servicesoftware(1) in einem Hilfsroboter zu installieren");
		
		hilf.softwareInstallieren(transportS1);
		Validator.report(hilf.getSoftware() == null, "versuchen Transportsoftware(1) in einem Hilfsroboter zu installieren");
		
		hilf.softwareInstallieren(kampfS1);
		Validator.report(hilf.getSoftware() == null, "versuchen Kampfsoftware(1) in einem Hilfsroboter zu installieren");
		
		hilf.softwareInstallieren(leibS1);
		Validator.report(hilf.getSoftware() == null, "versuchen Leibwaechtersoftware(1) in einem Hilfsroboter zu installieren");
		
		hilf.softwareInstallieren(objectS1);
		Validator.report(hilf.getSoftware() == null, "versuchen Objektbewachersoftware(1) in einem Hilfsroboter zu installieren");

		hilf.softwareInstallieren(hilfS1);
		Validator.report(hilf.getSoftware() instanceof HilfskraefteSoftware, "versuchen Hilfssoftware(1) in einem Hilfsroboter zu installieren");
		
		hilf = new Hilfskraft("Hilfsroboter");
		hilf.softwareInstallieren(hilfS2);
		Validator.report(hilf.getSoftware() instanceof HilfskraefteSoftware, "versuchen Hilfssoftware(2) in einem Hilfsroboter zu installieren");
		
		hilf = new Hilfskraft("Hilfsroboter");
		hilf.softwareInstallieren(hilfS3);
		Validator.report(hilf.getSoftware() == null, "versuchen Hilfssoftware(3) in einem Hilfsroboter zu installieren");
		
		hilf = new Hilfskraft("Hilfsroboter");
		hilf.softwareInstallieren(hilfS4);
		Validator.report(hilf.getSoftware() == null, "versuchen Hilfssoftware(4) in einem Hilfsroboter zu installieren");
		
		hilf = new Hilfskraft("Hilfsroboter");
		hilf.softwareInstallieren(hilfS5);
		Validator.report(hilf.getSoftware() == null, "versuchen Hilfssoftware(5) in einem Hilfsroboter zu installieren");
		
		
		
		
		gesell.softwareInstallieren(bauS1);
		Validator.report(gesell.getSoftware() == null, "versuchen Bausoftware(1) in einem Gesellschaftsroboter zu installieren");
		
		gesell.softwareInstallieren(serviceS1);
		Validator.report(gesell.getSoftware() == null, "versuchen Servicesoftware(1) in einem Gesellschaftsroboter zu installieren");
		
		gesell.softwareInstallieren(transportS1);
		Validator.report(gesell.getSoftware() == null, "versuchen Transportsoftware(1) in einem Gesellschaftsroboter zu installieren");
		
		gesell.softwareInstallieren(kampfS1);
		Validator.report(gesell.getSoftware() == null, "versuchen Kampfsoftware(1) in einem Gesellschaftsroboter zu installieren");
		
		gesell.softwareInstallieren(leibS1);
		Validator.report(gesell.getSoftware() == null, "versuchen Leibwaechtersoftware(1) in einem Gesellschaftsroboter zu installieren");
		
		gesell.softwareInstallieren(objectS1);
		Validator.report(gesell.getSoftware() == null, "versuchen Objektbewachersoftware(1) in einem Gesellschaftsroboter zu installieren");

		gesell.softwareInstallieren(hilfS1);
		Validator.report(gesell.getSoftware() == null, "versuchen Hilfssoftware(1) in einem Gesellschaftsroboter zu installieren");
		
		gesell.softwareInstallieren(gesellS1);
		Validator.report(gesell.getSoftware() instanceof GesellschaftlerSoftware, "versuchen Gesellschaflersoftware(1) in einem Gesellschaftsroboter zu installieren");
		
		gesell = new Gesellschaftler("Gesellschaftsroboter");
		gesell.softwareInstallieren(gesellS2);
		Validator.report(gesell.getSoftware() == null, "versuchen Gesellschaflersoftware(2) in einem Gesellschaftsroboter zu installieren");
		
		gesell = new Gesellschaftler("Gesellschaftsroboter");
		gesell.softwareInstallieren(gesellS3);
		Validator.report(gesell.getSoftware() == null, "versuchen Gesellschaflersoftware(3) in einem Gesellschaftsroboter zu installieren");
		
		gesell = new Gesellschaftler("Gesellschaftsroboter");
		gesell.softwareInstallieren(gesellS4);
		Validator.report(gesell.getSoftware() == null, "versuchen Gesellschaflersoftware(4) in einem Gesellschaftsroboter zu installieren");
		
		gesell = new Gesellschaftler("Gesellschaftsroboter");
		gesell.softwareInstallieren(gesellS5);
		Validator.report(gesell.getSoftware() == null, "versuchen Gesellschaflersoftware(5) in einem Gesellschaftsroboter zu installieren");
		
		
		
		
		
		bau.softwareInstallieren(serviceS3);
		Validator.report(bau.getSoftware() == null, "versuchen Servicesoftware(3) in einem Bauroboter zu installieren");
		
		bau.softwareInstallieren(transportS3);
		Validator.report(bau.getSoftware() == null, "versuchen Transportsoftware(3) in einem Bauroboter zu installieren");
		
		bau.softwareInstallieren(kampfS3);
		Validator.report(bau.getSoftware() == null, "versuchen Kampfsoftware(3) in einem Bauroboter zu installieren");
		
		bau.softwareInstallieren(leibS3);
		Validator.report(bau.getSoftware() == null, "versuchen Leibwaechtersoftware(3) in einem Bauroboter zu installieren");
		
		bau.softwareInstallieren(objectS3);
		Validator.report(bau.getSoftware() == null, "versuchen Objektbewachersoftware(3) in einem Bauroboter zu installieren");

		bau.softwareInstallieren(hilfS3);
		Validator.report(bau.getSoftware() == null, "versuchen Hilfssoftware(3) in einem Bauroboter zu installieren");
		
		bau.softwareInstallieren(gesellS3);
		Validator.report(bau.getSoftware() == null, "versuchen GesellschaftlerSoftware(3) in einem Bauroboter zu installieren");
		
		bau = new Bauarbeiter("Bauroboter");
		bau.softwareInstallieren(bauS1);
		Validator.report(bau.getSoftware() == null, "versuchen Bausoftware(1) in einem Bauroboter zu installieren");
		
		bau = new Bauarbeiter("Bauroboter");
		bau.softwareInstallieren(bauS2);
		Validator.report(bau.getSoftware() == null, "versuchen Bausoftware(2) in einem Bauroboter zu installieren");
		
		bau = new Bauarbeiter("Bauroboter");
		bau.softwareInstallieren(bauS3);
		Validator.report(bau.getSoftware() instanceof BauarbeiterSoftware, "versuchen Bausoftware(3) in einem Bauroboter zu installieren");
		
		bau = new Bauarbeiter("Bauroboter");
		bau.softwareInstallieren(bauS4);
		Validator.report(bau.getSoftware() instanceof BauarbeiterSoftware, "versuchen Bausoftware(4) in einem Bauroboter zu installieren");
		
		bau = new Bauarbeiter("Bauroboter");
		bau.softwareInstallieren(bauS5);
		Validator.report(bau.getSoftware() == null, "versuchen Bausoftware(5) in einem Bauroboter zu installieren");
		
		
		
		
		transport.softwareInstallieren(serviceS3);
		Validator.report(transport.getSoftware() == null, "versuchen Servicesoftware(3) in einem Transportroboter zu installieren");
		
		transport.softwareInstallieren(bauS3);
		Validator.report(transport.getSoftware() == null, "versuchen Bausoftware(3) in einem Transportroboter zu installieren");
		
		transport.softwareInstallieren(kampfS3);
		Validator.report(transport.getSoftware() == null, "versuchen Kampfsoftware(3) in einem Transportroboter zu installieren");
		
		transport.softwareInstallieren(leibS3);
		Validator.report(transport.getSoftware() == null, "versuchen Leibwaechtersoftware(3) in einem Transportroboter zu installieren");
		
		transport.softwareInstallieren(objectS3);
		Validator.report(transport.getSoftware() == null, "versuchen Objektbewachersoftware(3) in einem Transportroboter zu installieren");

		transport.softwareInstallieren(hilfS3);
		Validator.report(transport.getSoftware() == null, "versuchen Hilfssoftware(3) in einem Transportroboter zu installieren");
		
		transport.softwareInstallieren(gesellS3);
		Validator.report(transport.getSoftware() == null, "versuchen GesellschaftlerSoftware(3) in einem Transportroboter zu installieren");
		
		transport = new Transportarbeiter("Transportroboter");
		transport.softwareInstallieren(transportS1);
		Validator.report(transport.getSoftware() == null, "versuchen transportsoftware(1) in einem Transportroboter zu installieren");
		
		transport = new Transportarbeiter("Transportroboter");
		transport.softwareInstallieren(transportS2);
		Validator.report(transport.getSoftware() == null, "versuchen transportsoftware(2) in einem Transportroboter zu installieren");
		
		transport = new Transportarbeiter("Transportroboter");
		transport.softwareInstallieren(transportS3);
		Validator.report(transport.getSoftware() instanceof TransportarbeiterSoftware, "versuchen TransportSoftware(3) in einem Transportroboter zu installieren");
		
		transport = new Transportarbeiter("Transportroboter");
		transport.softwareInstallieren(transportS4);
		Validator.report(transport.getSoftware() instanceof TransportarbeiterSoftware, "versuchen TransportSoftware(4) in einem Transportroboter zu installieren");
		
		transport = new Transportarbeiter("Transportroboter");
		transport.softwareInstallieren(transportS5);
		Validator.report(transport.getSoftware() == null, "versuchen TransportSoftware(5) in einem Transportroboter zu installieren");

		
		service.softwareInstallieren(transportS3);
		Validator.report(service.getSoftware() == null, "versuchen Transportsoftware(3) in einem ServiceRoboter zu installieren");
		
		service.softwareInstallieren(bauS3);
		Validator.report(service.getSoftware() == null, "versuchen Bausoftware(3) in einem ServiceRoboter zu installieren");
		
		service.softwareInstallieren(kampfS3);
		Validator.report(service.getSoftware() == null, "versuchen Kampfsoftware(3) in einem ServiceRoboter zu installieren");
		
		service.softwareInstallieren(leibS3);
		Validator.report(service.getSoftware() == null, "versuchen Leibwaechtersoftware(3) in einem ServiceRoboter zu installieren");
		
		service.softwareInstallieren(objectS3);
		Validator.report(service.getSoftware() == null, "versuchen Objektbewachersoftware(3) in einem ServiceRoboter zu installieren");

		service.softwareInstallieren(hilfS3);
		Validator.report(service.getSoftware() == null, "versuchen Hilfssoftware(3) in einem ServiceRoboter zu installieren");
		
		service.softwareInstallieren(gesellS3);
		Validator.report(service.getSoftware() == null, "versuchen GesellschaftlerSoftware(3) in einem ServiceRoboter zu installieren");
		
		service = new ServiceTechniker("ServiceRoboter");
		service.softwareInstallieren(serviceS1);
		Validator.report(service.getSoftware() == null, "versuchen servicesoftware(1) in einem ServiceRoboter zu installieren");
		
		service = new ServiceTechniker("ServiceRoboter");
		service.softwareInstallieren(serviceS2);
		Validator.report(service.getSoftware() == null, "versuchen servicesoftware(2) in einem ServiceRoboter zu installieren");
		
		service = new ServiceTechniker("ServiceRoboter");
		service.softwareInstallieren(serviceS3);
		Validator.report(service.getSoftware() instanceof ServiceTechnikerSoftware, "versuchen serviceSoftware(3) in einem ServiceRoboter zu installieren");
		
		service = new ServiceTechniker("ServiceRoboter");
		service.softwareInstallieren(serviceS4);
		Validator.report(service.getSoftware() instanceof ServiceTechnikerSoftware, "versuchen serviceSoftware(4) in einem ServiceRoboter zu installieren");
		
		service = new ServiceTechniker("ServiceRoboter");
		service.softwareInstallieren(serviceS5);
		Validator.report(service.getSoftware() == null, "versuchen serviceSoftware(5) in einem ServiceRoboter zu installieren");
		
		
		
		
		kampf.softwareInstallieren(transportS5);
		Validator.report(kampf.getSoftware() == null, "versuchen Transportsoftware(5) in einem Kampfroboter zu installieren");
		
		kampf.softwareInstallieren(bauS5);
		Validator.report(kampf.getSoftware() == null, "versuchen BauSoftware(5) in einem Kampfroboter zu installieren");
		
		kampf.softwareInstallieren(serviceS5);
		Validator.report(kampf.getSoftware() == null, "versuchen ServiceSoftware(5) in einem Kampfroboter zu installieren");
		
		kampf.softwareInstallieren(leibS5);
		Validator.report(kampf.getSoftware() == null, "versuchen Leibwaechtersoftware(5) in einem Kampfroboter zu installieren");
		
		kampf.softwareInstallieren(objectS5);
		Validator.report(kampf.getSoftware() == null, "versuchen Objektbewachersoftware(5) in einem Kampfroboter zu installieren");

		kampf.softwareInstallieren(hilfS5);
		Validator.report(kampf.getSoftware() == null, "versuchen Hilfssoftware(5) in einem Kampfroboter zu installieren");
		
		kampf.softwareInstallieren(gesellS5);
		Validator.report(kampf.getSoftware() == null, "versuchen GesellschaftlerSoftware(5) in einem Kampfroboter zu installieren");
		
		kampf = new Kaempfer("Kampfroboter");
		kampf.softwareInstallieren(kampfS1);
		Validator.report(kampf.getSoftware() == null, "versuchen Kampfsoftware(1) in einem Kampfroboter zu installieren");
		
		kampf = new Kaempfer("Kampfroboter");
		kampf.softwareInstallieren(kampfS2);
		Validator.report(kampf.getSoftware() == null, "versuchen Kampfsoftware(2) in einem Kampfroboter zu installieren");
		
		kampf = new Kaempfer("Kampfroboter");
		kampf.softwareInstallieren(kampfS3);
		Validator.report(kampf.getSoftware() == null, "versuchen Kampfsoftware(3) in einem Kampfroboter zu installieren");
		
		kampf = new Kaempfer("Kampfroboter");
		kampf.softwareInstallieren(kampfS4);
		Validator.report(kampf.getSoftware() == null, "versuchen Kampfsoftware(4) in einem Kampfroboter zu installieren");
		
		kampf = new Kaempfer("Kampfroboter");
		kampf.softwareInstallieren(kampfS5);
		Validator.report(kampf.getSoftware() instanceof KaempferSoftware, "versuchen Kampfsoftware(5) in einem Kampfroboter zu installieren");
		
		
		
		leib.softwareInstallieren(transportS4);
		Validator.report(leib.getSoftware() == null, "versuchen Transportsoftware(4) in einem LeibwaechterRoboter zu installieren");
		
		leib.softwareInstallieren(bauS4);
		Validator.report(leib.getSoftware() == null, "versuchen BauSoftware(4) in einem LeibwaechterRoboter zu installieren");
		
		leib.softwareInstallieren(serviceS4);
		Validator.report(leib.getSoftware() == null, "versuchen ServiceSoftware(4) in einem LeibwaechterRoboter zu installieren");
		
		leib.softwareInstallieren(kampfS4);
		Validator.report(leib.getSoftware() == null, "versuchen Kampfsoftware(4) in einem LeibwaechterRoboter zu installieren");
		
		leib.softwareInstallieren(objectS4);
		Validator.report(leib.getSoftware() == null, "versuchen Objektbewachersoftware(4) in einem LeibwaechterRoboter zu installieren");

		leib.softwareInstallieren(hilfS4);
		Validator.report(leib.getSoftware() == null, "versuchen Hilfssoftware(4) in einem LeibwaechterRoboter zu installieren");
		
		leib.softwareInstallieren(gesellS4);
		Validator.report(leib.getSoftware() == null, "versuchen GesellschaftlerSoftware(4) in einem LeibwaechterRoboter zu installieren");
		
		leib = new Leibwaechter("Kampfroboter");
		leib.softwareInstallieren(leibS1);
		Validator.report(leib.getSoftware() == null, "versuchen LeibwaechterSoftware(1) in einem Kampfroboter zu installieren");
		
		leib = new Leibwaechter("Kampfroboter");
		leib.softwareInstallieren(leibS2);
		Validator.report(leib.getSoftware() == null, "versuchen LeibwaechterSoftware(2) in einem Kampfroboter zu installieren");
		
		leib = new Leibwaechter("Kampfroboter");
		leib.softwareInstallieren(leibS3);
		Validator.report(leib.getSoftware() == null, "versuchen LeibwaechterSoftware(3) in einem Kampfroboter zu installieren");
		
		leib = new Leibwaechter("Kampfroboter");
		leib.softwareInstallieren(leibS4);
		Validator.report(leib.getSoftware() instanceof LeibwaechterSoftware, "versuchen LeibwaechterSoftware(4) in einem Kampfroboter zu installieren");
		
		leib = new Leibwaechter("Kampfroboter");
		leib.softwareInstallieren(leibS5);
		Validator.report(leib.getSoftware() == null, "versuchen LeibwaechterSoftware(5) in einem Kampfroboter zu installieren");
		
		
		
		object.softwareInstallieren(transportS4);
		Validator.report(object.getSoftware() == null, "versuchen Transportsoftware(4) in einem Objektwaechterroboter zu installieren");
		
		object.softwareInstallieren(bauS4);
		Validator.report(object.getSoftware() == null, "versuchen BauSoftware(4) in einem Objektwaechterroboter zu installieren");
		
		object.softwareInstallieren(serviceS4);
		Validator.report(object.getSoftware() == null, "versuchen ServiceSoftware(4) in einem Objektwaechterroboter zu installieren");
		
		object.softwareInstallieren(kampfS4);
		Validator.report(object.getSoftware() == null, "versuchen Kampfsoftware(4) in einem Objektwaechterroboter zu installieren");
		
		object.softwareInstallieren(leibS4);
		Validator.report(object.getSoftware() == null, "versuchen Leibwaechtersoftware(4) in einem Objektwaechterroboter zu installieren");

		object.softwareInstallieren(hilfS4);
		Validator.report(object.getSoftware() == null, "versuchen Hilfssoftware(4) in einem Objektwaechterroboter zu installieren");
		
		object.softwareInstallieren(gesellS4);
		Validator.report(object.getSoftware() == null, "versuchen GesellschaftlerSoftware(4) in einem Objektwaechterroboter zu installieren");
		
		object = new Objektbewacher("Kampfroboter");
		object.softwareInstallieren(objectS1);
		Validator.report(object.getSoftware() == null, "versuchen ObjektwaechterSoftware(1) in einem Objektwaechterroboter zu installieren");
		
		object = new Objektbewacher("Kampfroboter");
		object.softwareInstallieren(objectS2);
		Validator.report(object.getSoftware() == null, "versuchen ObjektwaechterSoftware(2) in einem Objektwaechterroboter zu installieren");
		
		object = new Objektbewacher("Kampfroboter");
		object.softwareInstallieren(objectS3);
		Validator.report(object.getSoftware() == null, "versuchen ObjektwaechterSoftware(3) in einem Objektwaechterroboter zu installieren");
		
		object = new Objektbewacher("Kampfroboter");
		object.softwareInstallieren(objectS4);
		Validator.report(object.getSoftware() instanceof ObjektbewacherSoftware, "versuchen ObjektwaechterSoftware(4) in einem Objektwaechterroboter zu installieren");
		
		object = new Objektbewacher("Kampfroboter");
		object.softwareInstallieren(objectS5);
		Validator.report(object.getSoftware() == null, "versuchen ObjektwaechterSoftware(5) in einem Objektwaechterroboter zu installieren");
		
	}

}
