
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
		
		Pict scaled[]  = new Pict[4];
		scaled[0] = plainBox;
		scaled[1] = clearBox;
		scaled[2] = darkBox;
		scaled[3] = freeBox;
		
		Repeated<Pict> myGrid = new Repeated<Pict>(myPicts);
		myGrid.scale(0.5);
		
		System.out.println(myGrid.toString());
		
		Scaled<Pict> myScaled = new Scaled<Pict>(scaled);
		myScaled.scale(2.0);
		
		System.out.println(myScaled.toString());
		
	}
}
