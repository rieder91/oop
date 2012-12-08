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
		
		
		Liste myTests = new Liste();
		myTests.add(new AnnotationTester());
		
		MyIterator it = myTests.iterator();
		
		while(it.hasNext()) {
			((Tester) it.next()).runTests();
		}
		
//		Bauernhof b = new Bauernhof("Tony's Freilandeier");
//		
//		
//		Traktor bio = new BiogasTraktor("Bio #1", 15);
//		bio.setEinsatzart(new Duengerstreuer(5.5));
//		
//		Traktor t = new DieselTraktor("Diesel #1", 14);
//		
//		
//		Traktor t2 = new DieselTraktor("Diesel #2", 1);
//		t2.setEinsatzart(new Duengerstreuer(6.5));
//		
//		
//		
//		Traktor t3 = new DieselTraktor("Diesel #3", 3);
//		t3.setEinsatzart(new Drillmaschine(10));
//		
//		Traktor t4 = new DieselTraktor("Diesel #4", 4);
//		t4.setEinsatzart(new Drillmaschine(1));
//		
//		Traktor t5 = new BiogasTraktor("Bio #5", 5);
//		t5.setEinsatzart(new Drillmaschine(2));
//		
//		Traktor t6 = new BiogasTraktor("Bio #6", 6);
//		t6.setEinsatzart(new Drillmaschine(15));
//		
//		
//		b.addTraktor(t);
//		b.addTraktor(t2);
//		b.addTraktor(t3);
//		b.addTraktor(t4);
//		b.addTraktor(t5);
//		b.addTraktor(t6);
//		b.addTraktor(bio);
//		
//		System.out.println(b);
//		
//		b.increaseHoursOfTraktor(15, 10);
//		b.increaseDieselUsage(14, 10);
//		b.increaseDieselUsage(15, 10);
//		b.increaseDieselUsage(10, 10);
//		b.increaseGasUsage(15, 10);
//		b.increaseGasUsage(14, 10);
//		b.increaseGasUsage(10, 10);
//		
//		b.changeUsageOfTraktor(14, new Drillmaschine(10));
//		
//		System.out.println(b);
//		
//		
//		System.out.println(b.getSaescharenStats());
//		
//		System.out.println(b.getCapacityStats());
		
	}
}
