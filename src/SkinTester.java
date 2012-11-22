
/**
 * This class tests the implementation of Skin
 * 
 * THIS CLASS IS FOR TESTING PURPOSES ONLY AND NOT PART OF THE 
 * ACTUAL SOLUTION FOR THE ASSIGNMENT - THAT IS WHY WE USED INSTANCEOF!
 * 
 * @author Thomas
 *
 */
public class SkinTester implements Tester {

	/**
	 * default constructor
	 */
	public SkinTester() { }

	@Override
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

		// alle Skins
		Skin bSkin = new BeruehrungssensitiverSkin();
		Skin hSkin = new HochfesterSkin();
		Skin gSkin = new GepanzerterSkin();
		
		/*
		 * Test cases that do android.einbauen(skin)
		 * 
		 */
		
		/**************** BEDIENER */
		
		hilf.skinEinbauen(hSkin);
		Validator.report(hilf.getSkin() == null, "versuchen einen hochfesten Skin in einen Hilfsroboter einzubauen");
		
		hilf.skinEinbauen(gSkin);
		Validator.report(hilf.getSkin() == null, "versuchen einen gepanzerten Skin in einen Hilfsroboter einzubauen");
		
		hilf.skinEinbauen(bSkin);
		Validator.report(hilf.getSkin() instanceof BeruehrungssensitiverSkin, "versuchen einen beruehrungssensitiven Skin in einen Hilfsroboter einzubauen");
		
		
		gesell.skinEinbauen(hSkin);
		Validator.report(gesell.getSkin() == null, "versuchen einen hochfesten Skin in einen Gesellschaftler einzubauen");
		
		gesell.skinEinbauen(gSkin);
		Validator.report(gesell.getSkin() == null, "versuchen einen gepanzerten Skin in einen Gesellschaftler einzubauen");
		
		gesell.skinEinbauen(bSkin);
		Validator.report(gesell.getSkin() instanceof BeruehrungssensitiverSkin, "versuchen einen beruehrungssensitiven Skin in einen Gesellschaftler einzubauen");
		
		/*************** SCHWERARBEITER*/
		
		bau.skinEinbauen(gSkin);
		Validator.report(bau.getSkin() == null, "versuchen einen gepanzerten Skin in einen Bauroboter einzubauen");
		
		bau.skinEinbauen(hSkin);
		Validator.report(bau.getSkin() instanceof HochfesterSkin, "versuchen einen hochfesten Skin in einen Bauroboter einzubauen");
		
		bau.skinEinbauen(bSkin);
		Validator.report(bau.getSkin() instanceof BeruehrungssensitiverSkin, "versuchen einen beruehrungssensitiven Skin in einen Bauroboter einzubauen");
		
		
		service.skinEinbauen(gSkin);
		Validator.report(service.getSkin() == null, "versuchen einen gepanzerten Skin in einen Serviceroboter einzubauen");
		
		service.skinEinbauen(hSkin);
		Validator.report(service.getSkin() instanceof HochfesterSkin, "versuchen einen hochfesten Skin in einen Serviceroboter einzubauen");	
	
		service.skinEinbauen(bSkin);
		Validator.report(service.getSkin() instanceof BeruehrungssensitiverSkin, "versuchen einen beruehrungssensitiven Skin in einen Serviceroboter einzubauen");
		
		
		transport.skinEinbauen(gSkin);
		Validator.report(transport.getSkin() == null, "versuchen einen gepanzerten Skin in einen Transportroboter einzubauen");
		
		transport.skinEinbauen(hSkin);
		Validator.report(transport.getSkin() instanceof HochfesterSkin, "versuchen einen hochfesten Skin in einen Transportroboter einzubauen");

		transport.skinEinbauen(bSkin);
		Validator.report(transport.getSkin() instanceof BeruehrungssensitiverSkin, "versuchen einen beruehrungssensitiven Skin in einen Transportroboter einzubauen");
		
		/*************** BESCHUETZER*/
		
		kampf.skinEinbauen(hSkin);
		Validator.report(kampf.getSkin() instanceof HochfesterSkin, "versuchen einen hochfesten Skin in einen Kaempfer einzubauen");
		
		kampf.skinEinbauen(gSkin);
		Validator.report(kampf.getSkin() instanceof GepanzerterSkin, "versuchen einen gepanzerten Skin in einen Kaempfer einzubauen");
		
		kampf.skinEinbauen(bSkin);
		Validator.report(kampf.getSkin() instanceof BeruehrungssensitiverSkin, "versuchen einen beruehrungssensitiven Skin in einen Kaempfer einzubauen");
		
		
		leib.skinEinbauen(hSkin);
		Validator.report(leib.getSkin() instanceof HochfesterSkin, "versuchen einen hochfesten Skin in einen Leibwaechter einzubauen");
		
		leib.skinEinbauen(gSkin);
		Validator.report(leib.getSkin() instanceof GepanzerterSkin, "versuchen einen gepanzerten Skin in einen Leibwaechter einzubauen");
		
		leib.skinEinbauen(bSkin);
		Validator.report(leib.getSkin() instanceof BeruehrungssensitiverSkin, "versuchen einen beruehrungssensitiven Skin in einen Leibwaechter einzubauen");
		
		
		object.skinEinbauen(hSkin);
		Validator.report(object.getSkin() instanceof HochfesterSkin, "versuchen einen hochfesten Skin in einen Objektbewacher einzubauen");
		
		object.skinEinbauen(gSkin);
		Validator.report(object.getSkin() instanceof GepanzerterSkin, "versuchen einen gepanzerten Skin in einen Objektbewacher einzubauen");
		
		object.skinEinbauen(bSkin);
		Validator.report(object.getSkin() instanceof BeruehrungssensitiverSkin, "versuchen einen beruehrungssensitiven Skin in einen Objektbewacher einzubauen");
		
		/****************/
		
		
		/*
		 * Test cases that do skin.einbauen(android)
		 * 
		 */
		
		// reset robots
		
		hilf = new Hilfskraft("Hilfroboter");
		gesell = new Gesellschaftler("Gesellschaftsroboter");

		// Schwerarbeiter
		bau = new Bauarbeiter("Bauroboter");
		service = new ServiceTechniker("Serviceroboter");
		transport = new Transportarbeiter("Transportroboter");

		// Beschuetzer
		kampf = new Kaempfer("Kampfroboter");
		leib = new Leibwaechter("Leibwaechteroboter");
		object = new Objektbewacher("Objektroboter");
		
		/* BEDIENER */
		
		hSkin.einbauen(hilf);
		Validator.report(hilf.getSkin() == null, "versuchen einen hochfesten Skin in einen Hilfsroboter einzubauen - reverse calling");
		
		gSkin.einbauen(hilf);
		Validator.report(hilf.getSkin() == null, "versuchen einen gepanzerten Skin in einen Hilfsroboter einzubauen - reverse calling");
		
		bSkin.einbauen(hilf);
		Validator.report(hilf.getSkin() instanceof BeruehrungssensitiverSkin, "versuchen einen beruehrungssensitiven Skin in einen Hilfsroboter einzubauen - reverse calling");
		
		
		hSkin.einbauen(gesell);
		Validator.report(gesell.getSkin() == null, "versuchen einen hochfesten Skin in einen Gesellschaftler einzubauen - reverse calling");
		
		gSkin.einbauen(gesell);
		Validator.report(gesell.getSkin() == null, "versuchen einen gepanzerten Skin in einen Gesellschaftler einzubauen - reverse calling");
		
		bSkin.einbauen(gesell);
		Validator.report(gesell.getSkin() instanceof BeruehrungssensitiverSkin, "versuchen einen beruehrungssensitiven Skin in einen Gesellschaftler einzubauen - reverse calling");
		
		/* SCHWERARBEITER */
		
		gSkin.einbauen(bau);
		Validator.report(bau.getSkin() == null, "versuchen einen gepanzerten Skin in einen Bauroboter einzubauen - reverse calling");
		
		hSkin.einbauen(bau);
		Validator.report(bau.getSkin() instanceof HochfesterSkin, "versuchen einen hochfesten Skin in einen Bauroboter einzubauen - reverse calling");
		
		bSkin.einbauen(bau);
		Validator.report(bau.getSkin() instanceof BeruehrungssensitiverSkin, "versuchen einen beruehrungssensitiven Skin in einen Bauroboter einzubauen - reverse calling");
		
		
		gSkin.einbauen(service);
		Validator.report(service.getSkin() == null, "versuchen einen gepanzerten Skin in einen Serviceroboter einzubauen - reverse calling");
		
		hSkin.einbauen(service);
		Validator.report(service.getSkin() instanceof HochfesterSkin, "versuchen einen hochfesten Skin in einen Serviceroboter einzubauen - reverse calling");
		
		bSkin.einbauen(service);
		Validator.report(service.getSkin() instanceof BeruehrungssensitiverSkin, "versuchen einen beruehrungssensitiven Skin in einen Serviceroboter einzubauen - reverse calling");
		
		
		gSkin.einbauen(transport);
		Validator.report(transport.getSkin() == null, "versuchen einen gepanzerten Skin in einen Transportroboter einzubauen - reverse calling");
		
		hSkin.einbauen(transport);
		Validator.report(transport.getSkin() instanceof HochfesterSkin, "versuchen einen hochfesten Skin in einen Transportroboter einzubauen - reverse calling");
		
		bSkin.einbauen(transport);
		Validator.report(transport.getSkin() instanceof BeruehrungssensitiverSkin, "versuchen einen beruehrungssensitiven Skin in einen Transportroboter einzubauen - reverse calling");
		
		
		/* BESCHUETZER */
		
		gSkin.einbauen(kampf);
		Validator.report(kampf.getSkin() instanceof GepanzerterSkin, "versuchen einen gepanzerten Skin in einen Kampfroboter einzubauen - reverse calling");
		
		hSkin.einbauen(kampf);
		Validator.report(kampf.getSkin() instanceof HochfesterSkin, "versuchen einen hochfesten Skin in einen Kampfroboter einzubauen - reverse calling");
		
		bSkin.einbauen(kampf);
		Validator.report(kampf.getSkin() instanceof BeruehrungssensitiverSkin, "versuchen einen beruehrungssensitiven Skin in einen Kampfroboter einzubauen - reverse calling");
		
		
		gSkin.einbauen(object);
		Validator.report(object.getSkin() instanceof GepanzerterSkin, "versuchen einen gepanzerten Skin in einen Objektbewacher einzubauen - reverse calling");
		
		hSkin.einbauen(object);
		Validator.report(object.getSkin() instanceof HochfesterSkin, "versuchen einen hochfesten Skin in einen Objektbewacher einzubauen - reverse calling");
		
		bSkin.einbauen(object);
		Validator.report(object.getSkin() instanceof BeruehrungssensitiverSkin, "versuchen einen beruehrungssensitiven Skin in einen Objektbewacher einzubauen - reverse calling");
		
		
		gSkin.einbauen(leib);
		Validator.report(leib.getSkin() instanceof GepanzerterSkin, "versuchen einen gepanzerten Skin in einen Leibwaechter einzubauen - reverse calling");
		
		hSkin.einbauen(leib);
		Validator.report(leib.getSkin() instanceof HochfesterSkin, "versuchen einen hochfesten Skin in einen Leibwaechter einzubauen - reverse calling");
		
		bSkin.einbauen(leib);
		Validator.report(leib.getSkin() instanceof BeruehrungssensitiverSkin, "versuchen einen beruehrungssensitiven Skin in einen Leibwaechter einzubauen - reverse calling");
	}
}
