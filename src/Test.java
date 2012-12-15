/**
 * Test class for Assignment 9
 * 
 * @author OOP Gruppe 187
 */

public class Test {

	/**
	 * Test class for Assignment 9
	 * 
	 * @param args
	 *            command line arguments
	 */
	public static void main(String[] args) {

		System.out.println("Objektorientierte Programmiertechniken                  \n"
				+ "Datum: 12.12.2012                                      \n"
				+ "Aufgabe 9                                              \n"
				+ "Gruppe 187: Dominic Riedl, Thomas Rieder, Markus Zisser\n");
		
		Bestellung b1=new Bestellung();
		b1.addPosition(new Position(5, Form.RUND, Teigart.SCHOKOLADENTEIG, Fuellung.MARMELADE));
		b1.addPosition(new Position(2, Form.RUND, Teigart.SCHOKOLADENTEIG, null));
		b1.addPosition(new Position(0, Form.MOND, Teigart.MUERBTEIG, Fuellung.SCHOKOLADE));
		b1.addPosition(new Position(4, Form.MOND, Teigart.MUERBTEIG, null));
		b1.addPosition(new Position(3, Form.WEIHNACHTSMANN, Teigart.ZIMTSTERNTEIG, Fuellung.MARMELADE));
		b1.addPosition(new Position(1, Form.WEIHNACHTSMANN, Teigart.ZIMTSTERNTEIG, null));
		
		b1.drucke();
		b1.backe().inhalt();
	}
}
