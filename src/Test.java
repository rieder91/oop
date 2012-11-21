
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
		
		BeruehrungsSkinFactory bSkinFactory = new BeruehrungsSkinFactory();
		HochfesterSkinFactory hSkinFactory = new HochfesterSkinFactory();
		GepanzerterSkinFactory gSkinFactory = new GepanzerterSkinFactory();
		
		Hilfskraft sonnic;
		sonnic = new Hilfskraft("R2-D2");
		
		Hilfskraft sonnic2;
		sonnic2 = new Hilfskraft("R4-D2");
		
		hSkinFactory.einbauenIn(sonnic);
		
		
		System.out.println();
		
		
	}
}
