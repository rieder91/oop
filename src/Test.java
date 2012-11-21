
/**
 * Test class for Assignment 5
 * 
 * @author OOP Gruppe 187
 */

public class Test {

	/**
	 * Test class for Assignment 5
	 * 
	 * @param args
	 *            command line arguments
	 */
	public static void main(String[] args) {
		System.out
				.println("Objektorientierte Programmiertechniken                  \n"
						+ "Datum: 21.11.2012                                      \n"
						+ "Aufgabe 6                                              \n"
						+ "Gruppe 187: Dominic Riedl, Thomas Rieder, Markus Zisser\n");
		
		
		Hilfskraft sonnic;
		sonnic = new Hilfskraft("R2-D2");
		
		Hilfskraft sonnic2;
		sonnic2 = new Hilfskraft("R4-D2");
		
		Hilfskraft sonnic3;
		sonnic3 = new Hilfskraft("R6-D2");
		
		Hilfskraft sonnic4;
		sonnic4 = new Hilfskraft("R8-D2");
		
		
		BeruehrungssensitiverSkin bSkin = new BeruehrungssensitiverSkin();
		HochfesterSkin hSkin = new HochfesterSkin();
		GepanzerterSkin gSkin = new GepanzerterSkin();
		
		bSkin.integrate(sonnic);
		bSkin.integrate(sonnic2);
		
		sonnic3.einbauen(hSkin);
		sonnic4.einbauen(gSkin);
		
		System.out.println();
		
		HilfskraefteSoftware winWord = new HilfskraefteSoftware(new SecurityLevel1());
		
		sonnic.einbauen(winWord);
		
		
	}
}
