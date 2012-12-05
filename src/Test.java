/**
 * Test class for Assignment 8
 * 
 * @author OOP Gruppe 187
 */

public class Test {

	/**
	 * Test class for Assignment 8
	 * 
	 * @param args
	 *            command line arguments
	 */
	public static void main(String[] args) {

		System.out.println("Objektorientierte Programmiertechniken                  \n"
				+ "Datum: 05.12.2012                                      \n"
				+ "Aufgabe 8                                              \n"
				+ "Gruppe 187: Dominic Riedl, Thomas Rieder, Markus Zisser\n");
		
		BiogasTraktor bio = new BiogasTraktor("Bio #1");
//		System.out.println(bio.getDuengerCapacity());
		
		bio.setEinsatzart(new Duengerstreuer(5));
		
//		System.out.println(bio.getDuengerCapacity());
		
		
		Liste myList = new Liste(new Double(5), Double.class);
		myList.add(new Double(10));
		myList.add(new Double(15));
		System.out.println("FAIL");
		myList.add(new Object());
		

	}
}
