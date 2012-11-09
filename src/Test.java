
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
		System.out.println("Objektorientierte Programmiertechniken                 \n"
		 				+  "Datum: 07.11.2012                                      \n"
		 				+  "Aufgabe 4                                              \n"
		 				+  "Gruppe 187: Dominic Riedl, Thomas Rieder, Markus Zisser\n");
		

		Box plainBox = new Box(2.1, 3.7, 'o', '.');
		ClearBox clearBox = new ClearBox(5.3, 7.0);
		DarkBox darkBox = new DarkBox(9.2, 14.8, '#');
		FreeBox freeBox = new FreeBox("1234\n" +
									  "5678");
		
		Pict myPicts[][]  = new Pict[2][2];
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
		
		Repeated<Pict> myGrid = new Repeated<Pict>(myPicts);
		myGrid.scale(1.5);
		System.out.println(myGrid);
		
		Scaled<Pict> myScaled = new Scaled<Pict>(myPicts);
		myScaled.scale(3.0);
		System.out.println(myScaled);
		
		Repeated<String> myStringGrid = new Repeated<String>(myStrings);
		myStringGrid.scale(5.0);
		System.out.println(myStringGrid);
		
		
		
		
		
		
		
	}
}
