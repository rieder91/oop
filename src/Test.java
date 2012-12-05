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
		bio.setEinsatzart(new Duengerstreuer(5));
		
		Liste myList = new Liste();
		myList.add(new Double(10));
		myList.add(new Double(15));
		myList.add(new Double(20));
		myList.add(new Double(25));
		
		Bauernhof b = new Bauernhof("Tony's Freilandeier");
		Traktor t = new DieselTraktor("Diesel #1");
		b.addTraktor(t);
		b.addTraktor(bio);
//		b.removeTraktor(2);
		
		System.out.println();
		
		System.out.println(b);

	}
}
