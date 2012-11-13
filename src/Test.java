import java.util.ArrayList;

/**
 * Test class for Assignment 4
 * 
 * @author OOP Gruppe 187
 */

public class Test {

	/**
	 * Test class for Assignment 4
	 * 
	 * @param args
	 *            command line arguments
	 */
	public static void main(String[] args) {
		System.out
				.println("Objektorientierte Programmiertechniken                 \n"
						+ "Datum: 08.11.2012                                      \n"
						+ "Aufgabe 4                                              \n"
						+ "Gruppe 187: Dominic Riedl, Thomas Rieder, Markus Zisser\n");

		/*
		 * Zusammenfassung der Beziehungen zwischen den Klassen:
		 * 
		 * Repeated ist ein Pictogramm (also eine rechteckige Ascii-Grafik);
		 * dieses Pictogramm wird aus den toString-Methoden der Objekte des beim
		 * Konstruktor initalisierten Arrays erstellt
		 * 
		 * 
		 * Scaled ist ein Untertyp von Repeated, da es alle Zusicherungen von
		 * Repeated erfuellt und zusaetzlich vorrausetzt, dass seine Elemente
		 * Pict implementieren
		 * 
		 * 
		 * Auch eine FreeBox ist ein Untertyp von Repeated, da es sich dabei um
		 * Repeated<Character> handelt und die Zusicherungen der Oberklasse
		 * erfuellt
		 * 
		 * 
		 * Box ist KEIN Untertyp von Repeated, da im Gegensatz zu Repeated das
		 * Aussehen dynamisch berechnet wird und nicht im Konstruktor gesetzt
		 * wird
		 * 
		 * ClearBox ist ein Untertyp von Box, da es alle Zusicherungen von Box
		 * (rand != " " und finaler Stil) uebernimmt und der Stil nur von Anfang
		 * an festgelegt ist
		 * 
		 * 
		 * DarkBox ist WEDER Untertyp von Repeated NOCH von Box, da es deren
		 * Zusicherungen verletzen wuerde: der Stil laesst sich naemlich im
		 * Nachhinein aendern - sie implementiert Pict direkt
		 */

		Box plainBox = new Box(2.1, 3.7, 'o', '.');
		Box plainBox2 = new Box(4.0, 4.0, '*', '.');
		ClearBox clearBox = new ClearBox(5.3, 7.0);
		DarkBox darkBox = new DarkBox(9.2, 14.8, '#');
		FreeBox freeBox = new FreeBox("1234\n" + "5678");
		FreeBox checkBox = new FreeBox("****\n" + "*..*\n" + "*..*\n" + "****");
		DarkBox changeling = new DarkBox(5.0, 5.0, '-');

		Pict myPicts[][] = new Pict[2][2];
		Pict[][] testDataP = new Pict[1][1];
		Pict[][] testDataS = new Pict[1][1];

		testDataP[0][0] = new Box(2.0, 2.0, '.', '#');
		testDataS[0][0] = new Box(2.0, 2.0, '.', '#');

		myPicts[0][0] = plainBox;
		myPicts[0][1] = clearBox;
		myPicts[1][0] = darkBox;
		myPicts[1][1] = freeBox;

		String myStrings[][] = new String[3][2];
		myStrings[0][0] = "Das";
		myStrings[0][1] = "ist";
		myStrings[1][0] = "ein";
		myStrings[1][1] = "Test";
		myStrings[2][0] = "mit";
		myStrings[2][1] = "Leer zeichen!";

		Character myBox[][] = new Character[][] { { '*', '*', '*', '*' },
				{ '*', '.', '.', '*' }, { '*', '.', '.', '*' },
				{ '*', '*', '*', '*' } };

		Repeated<Pict> myP = new Repeated<Pict>(testDataP);
		Scaled<Pict> myS = new Scaled<Pict>(testDataS);

		System.out.println("Aspect Ratio of the ClearBox: "
				+ clearBox.getAspectRatio());

		System.out.println("\nTesting the Repeated-Grid: ");
		Repeated<Pict> myGrid = new Repeated<Pict>(myPicts);
		myGrid.scale(1.0);
		System.out.println(myGrid);

		System.out.println("\nTesting the Scaled-Grid with scale 3.0: ");
		Scaled<Pict> myScaled = new Scaled<Pict>(myPicts);
		myScaled.scale(3.0);
		System.out.println(myScaled);

		System.out.println("\nTesting a String-Grid with scale 3.0: ");
		Repeated<String> myStringGrid = new Repeated<String>(myStrings);
		myStringGrid.scale(3.0);
		System.out.println(myStringGrid);

		System.out.println("\nTesting a Character-Grid with scale 0.5: ");
		Repeated<Character> selfmadeBox = new Repeated<Character>(myBox);
		selfmadeBox.scale(0.5);
		System.out.println(selfmadeBox);

		System.out
				.println("\nTesting whether a FreeBox and a Repeated<Character> scale equally: ");
		checkBox.scale(0.5);
		plainBox2.scale(0.5);
		System.out.println(checkBox.toString().equals(selfmadeBox.toString()));

		System.out
				.println("\nTesting whether a Box and a Repeated<Character> scale equally: ");
		System.out.println(checkBox.toString().equals(plainBox2.toString()));

		System.out.println("\nAttemp to create a Box with a blank border: ");
		try {
			Box blankBox = new Box(1.0, 1.0, ' ', ' ');
			System.out.println("! error" + blankBox);
		} catch (IllegalArgumentException e) {
			System.out.println("not allowed");
		}

		System.out.println("\nAttempt to create a Box with an invalid size: ");
		try {
			Box sizeBox = new Box(-10.0, 1.0, '.', '.');
			System.out.println("! error" + sizeBox);
		} catch (IllegalArgumentException e) {
			System.out.println("not allowed");
		}

		System.out.println("\nAttempt to scale a Box with an invalid size: ");
		try {
			plainBox.scale(50.0);
			System.out.println("! error" + plainBox);
		} catch (IllegalArgumentException e) {
			System.out.println("not allowed");
		}

		System.out.println("\nAttemp to scale several Boxes: ");
		ArrayList<Pict> myBoxes = new ArrayList<Pict>();
		myBoxes.add(plainBox);
		myBoxes.add(clearBox);
		myBoxes.add(myScaled);
		myBoxes.add(darkBox);
		myBoxes.add(freeBox);
		for (Pict p : myBoxes) {
			try {
				p.scale(2.0);
			} catch (IllegalArgumentException e) {
				System.out.println("Scaling failed with box: " + p);
			}
		}
		System.out.println("Scaling successful");

		System.out.println("\nAttempt to change box style: ");
		System.out.println("Before: ");
		System.out.println(changeling);
		changeling.setStyle('#');
		System.out.println("After: ");
		System.out.println(changeling);

		System.out
				.println("\nTesting whether Repeated<Pict> and Scaled<Pict> scale equally");
		myP.scale(1.5);
		myS.scale(1.5);
		System.out.println(myP.toString().equals(myS.toString()));

	}
}
