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

		Baeckerrei b = new Baeckerrei();
		
		// mix of cookies
		Bestellung b1 = new Bestellung();
		b1.addPosition(new Position(5, Form.RUND, Teigart.SCHOKOLADENTEIG, Fuellung.MARMELADE));
		b1.addPosition(new Position(2, Form.RUND, Teigart.SCHOKOLADENTEIG, null));
		b1.addPosition(new Position(0, Form.MOND, Teigart.MUERBTEIG, Fuellung.SCHOKOLADE));
		b1.addPosition(new Position(4, Form.MOND, Teigart.MUERBTEIG, null));
		b1.addPosition(new Position(3, Form.WEIHNACHTSMANN, Teigart.ZIMTSTERNTEIG, Fuellung.MARMELADE));
		b1.addPosition(new Position(1, Form.WEIHNACHTSMANN, Teigart.ZIMTSTERNTEIG, null));
		b1.addPosition(new Position(10, Form.RUND, Teigart.SCHOKOLADENTEIG, Fuellung.SCHOKOLADE));

		System.out.println("Ein Mix verschiedener Kekse mit unterschiedlicher Anzahl:");
		b1.drucke();
		System.out.println();
		b.backe(b1).inhalt();
		
		
		// Doppelkekse with Zimtsternteig only
		Bestellung b2 = new Bestellung();
		b2.addPosition(new Position(1, Form.RUND, Teigart.ZIMTSTERNTEIG, Fuellung.SCHOKOLADE));
		b2.addPosition(new Position(1, Form.MOND, Teigart.ZIMTSTERNTEIG, Fuellung.SCHOKOLADE));
		b2.addPosition(new Position(1, Form.WEIHNACHTSMANN, Teigart.ZIMTSTERNTEIG, Fuellung.SCHOKOLADE));
		b2.addPosition(new Position(1, Form.RUND, Teigart.ZIMTSTERNTEIG, Fuellung.MARMELADE));
		b2.addPosition(new Position(1, Form.MOND, Teigart.ZIMTSTERNTEIG, Fuellung.MARMELADE));
		b2.addPosition(new Position(1, Form.WEIHNACHTSMANN, Teigart.ZIMTSTERNTEIG, Fuellung.MARMELADE));
		
		System.out.println("\nAlle Kombinationen von Doppelkeksen mit Zimtsternteig:");
		b2.drucke();
		System.out.println();
		b.backe(b2).inhalt();
		
		
		// Doppelkekse with Muerbteig only
		Bestellung b3 = new Bestellung();
		b3.addPosition(new Position(1, Form.RUND, Teigart.MUERBTEIG, Fuellung.SCHOKOLADE));
		b3.addPosition(new Position(1, Form.MOND, Teigart.MUERBTEIG, Fuellung.SCHOKOLADE));
		b3.addPosition(new Position(1, Form.WEIHNACHTSMANN, Teigart.MUERBTEIG, Fuellung.SCHOKOLADE));
		b3.addPosition(new Position(1, Form.RUND, Teigart.MUERBTEIG, Fuellung.MARMELADE));
		b3.addPosition(new Position(1, Form.MOND, Teigart.MUERBTEIG, Fuellung.MARMELADE));
		b3.addPosition(new Position(1, Form.WEIHNACHTSMANN, Teigart.MUERBTEIG, Fuellung.MARMELADE));

		System.out.println("\nAlle Kombinationen von Doppelkeksen mit Muerbteig:");
		b3.drucke();
		System.out.println();
		b.backe(b3).inhalt();
		
		
		// Doppelkekse with Schokoladenteig only
		Bestellung b4 = new Bestellung();
		b4.addPosition(new Position(1, Form.RUND, Teigart.SCHOKOLADENTEIG, Fuellung.SCHOKOLADE));
		b4.addPosition(new Position(1, Form.MOND, Teigart.SCHOKOLADENTEIG, Fuellung.SCHOKOLADE));
		b4.addPosition(new Position(1, Form.WEIHNACHTSMANN, Teigart.SCHOKOLADENTEIG, Fuellung.SCHOKOLADE));
		b4.addPosition(new Position(1, Form.RUND, Teigart.SCHOKOLADENTEIG, Fuellung.MARMELADE));
		b4.addPosition(new Position(1, Form.MOND, Teigart.SCHOKOLADENTEIG, Fuellung.MARMELADE));
		b4.addPosition(new Position(1, Form.WEIHNACHTSMANN, Teigart.SCHOKOLADENTEIG, Fuellung.MARMELADE));

		System.out.println("\nAlle Kombinationen von Doppelkeksen mit Schokoladenteig:");
		b4.drucke();
		System.out.println();
		b.backe(b4).inhalt();
		
		
		// Einfache Kekse with Zimtsternteig only
		Bestellung b5 = new Bestellung();
		b5.addPosition(new Position(1, Form.RUND, Teigart.ZIMTSTERNTEIG, null));
		b5.addPosition(new Position(1, Form.MOND, Teigart.ZIMTSTERNTEIG, null));
		b5.addPosition(new Position(1, Form.WEIHNACHTSMANN, Teigart.ZIMTSTERNTEIG, null));

		System.out.println("\nAlle Kombinationen einfacher Kekse mit Zimtsternteig: ");
		b5.drucke();
		System.out.println();
		b.backe(b5).inhalt();
		
		
		// Einfache Kekse with Muerbteig only
		Bestellung b6 = new Bestellung();
		b6.addPosition(new Position(1, Form.RUND, Teigart.MUERBTEIG, null));
		b6.addPosition(new Position(1, Form.MOND, Teigart.MUERBTEIG, null));
		b6.addPosition(new Position(1, Form.WEIHNACHTSMANN, Teigart.MUERBTEIG, null));

		System.out.println("\nAlle Kombinationen einfacher Kekse mit Muerbteig:");
		b6.drucke();
		System.out.println();
		b.backe(b6).inhalt();
		
		
		// Einfache Kekse with Schokoladenteig only
		Bestellung b7 = new Bestellung();
		b7.addPosition(new Position(1, Form.RUND, Teigart.SCHOKOLADENTEIG, null));
		b7.addPosition(new Position(1, Form.MOND, Teigart.SCHOKOLADENTEIG, null));
		b7.addPosition(new Position(1, Form.WEIHNACHTSMANN, Teigart.SCHOKOLADENTEIG, null));

		System.out.println("\nAlle Kombinationen einfacher Kekse mit Schokoladenteig:");
		b7.drucke();
		System.out.println();
		b.backe(b7).inhalt();
		
		
		// Bestellung with negative number or Zero
		Bestellung b8 = new Bestellung();
		b8.addPosition(new Position(-7, Form.MOND, Teigart.SCHOKOLADENTEIG, null));
		b8.addPosition(new Position(-2, Form.RUND, Teigart.ZIMTSTERNTEIG, null));
		b8.addPosition(new Position(0, Form.WEIHNACHTSMANN, Teigart.SCHOKOLADENTEIG, null));
		b8.addPosition(new Position(-437, Form.MOND, Teigart.MUERBTEIG, null));

		
		System.out.println("\nBestellung mit negativer Anzahl bzw. 0:");
		b8.drucke();
		System.out.println();
		b.backe(b8).inhalt();

		
		// TODO MOAR TEST CASES
		
	}
}
