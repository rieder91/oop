import java.util.ArrayList;

/**
 * Test class for Assignment 7
 * 
 * @author OOP Gruppe 187
 */

public class Test {

	/**
	 * Test class for Assignment 7
	 * 
	 * @param args
	 *            command line arguments
	 */
	public static void main(String[] args) {
		System.out.println("Objektorientierte Programmiertechniken                  \n"
				+ "Datum: 28.11.2012                                      \n"
				+ "Aufgabe 7                                              \n"
				+ "Gruppe 187: Dominic Riedl, Thomas Rieder, Markus Zisser\n");
		Track t = new Track(80, 20, 500);
		Car c0 = new maneuverableCar(12, new circleStrategy(), 0, 10, 5, t);
		Car c1 = new maneuverableCar(15, new randomStrategy(), 10, 12, 3, t);
		Car c2 = new maneuverableCar(12, new circleStrategy(), 20, 8, 5, t);
		Car c3 = new maneuverableCar(13, new randomStrategy(), 30, 14, 3, t);
		Car c4 = new maneuverableCar(12, new circleStrategy(), 40, 6, 5, t);
		Car c5 = new maneuverableCar(15, new randomStrategy(), 50, 10, 3, t);
		Car c6 = new maneuverableCar(12, new circleStrategy(), 60, 8, 5, t);
		Car c7 = new maneuverableCar(13, new randomStrategy(), 70, 12, 3, t);
		Car c8 = new fastCar(5, new circleStrategy(), 0, 8, 1, t);
		Car c9 = new fastCar(6, new randomStrategy(), 0, 12, 3, t);
		Car c10 = new fastCar(4, new circleStrategy(), 10, 10, 7, t);
		Car c11 = new fastCar(5, new randomStrategy(), 10, 14, 1, t);
		Car c12 = new fastCar(6, new circleStrategy(), 20, 6, 3, t);
		Car c13 = new fastCar(4, new randomStrategy(), 20, 10, 7, t);
		Car c14 = new fastCar(5, new circleStrategy(), 30, 12, 1, t);
		Car c15 = new fastCar(6, new randomStrategy(), 30, 16, 3, t);
		Car c16 = new fastCar(4, new circleStrategy(), 40, 4, 7, t);
		Car c17 = new fastCar(5, new randomStrategy(), 40, 8, 1, t);
		Car c18 = new fastCar(6, new circleStrategy(), 50, 8, 3, t);
		Car c19 = new fastCar(4, new randomStrategy(), 50, 12, 7, t);
		Car c20 = new fastCar(6, new circleStrategy(), 60, 6, 3, t);
		Car c21 = new fastCar(4, new randomStrategy(), 60, 10, 7, t);
		Car c22 = new fastCar(6, new circleStrategy(), 70, 10, 3, t);
		Car c23 = new fastCar(4, new randomStrategy(), 70, 14, 7, t);
		t.addCar(c1);
		t.addCar(c2);
		t.addCar(c3);
		t.addCar(c4);
		t.addCar(c5);
		t.addCar(c0);
		t.addCar(c6);
		t.addCar(c7);
		t.addCar(c8);
		t.addCar(c9);
		t.addCar(c10);
		t.addCar(c11);
		t.addCar(c12);
		t.addCar(c13);
		t.addCar(c14);
		t.addCar(c15);
		t.addCar(c16);
		t.addCar(c17);
		t.addCar(c18);
		t.addCar(c19);
		t.addCar(c20);
		t.addCar(c21);
		t.addCar(c22);
		t.addCar(c23);
		t.start();
		synchronized (t) {
			try {
				t.wait();
			}
			catch (InterruptedException e) {
			}
		}
		System.out.println(t.points());
		 try {
			Thread.sleep(500);
		}
		catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		 
		
		ArrayList<char[][]> map = t.getMap();
		for (int i = 0; i < map.size(); i++) {
			for (char[] line : map.get(i)) {
				System.out.println(String.valueOf(line));
			}
			System.out.println();
			try {
				Thread.sleep(50);
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}
}
