/**
 * the first test class
 * 
 * @author OOP Gruppe 187
 *
 */

public class Test1 implements Tester {

	/**
	 * mixed car types on a medium sized map
	 */
	@Override
	public void runTests() {
		System.out.println("Test1:");
		Track t = new Track(80, 20, 200);
		Car c1 = new maneuverableCar(15, new randomStrategy(), 	40, 10, Direction.South, t);
		Car c2 = new maneuverableCar(12, new circleStrategy(), 	40, 12, Direction.South, t);
		Car c3 = new maneuverableCar(13, new zigzagStrategy(), 	40, 8, Direction.North, t);
		Car c4 = new maneuverableCar(12, new circleStrategy(), 	42, 10, Direction.West, t);
		Car c5 = new maneuverableCar(15, new randomStrategy(), 	38, 10, Direction.East, t);
		Car c6 = new fastCar(4, new randomStrategy(), 			42, 12, Direction.West, t);
		Car c7 = new fastCar(6, new circleStrategy(), 			42, 8, Direction.West, t);
		Car c8 = new fastCar(4, new zigzagStrategy(), 			38, 12, Direction.East, t);
		Car c9 = new fastCar(6, new circleStrategy(), 			38, 8, Direction.East, t);
		Car c10 = new fastCar(4, new randomStrategy(), 			40, 14, Direction.South, t);
		Car c11 = new maneuverableCar(12, new circleStrategy(), 40, 6, Direction.North, t);
		Car c12 = new maneuverableCar(15, new randomStrategy(), 36, 10, Direction.East, t);
		Car c13 = new fastCar(6, new circleStrategy(), 			42, 10, Direction.West, t);
		t.addCar(c1);
		t.addCar(c2);
		t.addCar(c3);
		t.addCar(c4);
		t.addCar(c5);
		t.addCar(c6);
		t.addCar(c7);
		t.addCar(c8);
		t.addCar(c9);
		t.addCar(c10);
		t.addCar(c11);
		t.addCar(c12);
		t.addCar(c13);
		t.start();
		synchronized (t) {
			try {
				t.wait();
			}
			catch (InterruptedException e) {
			}
		}
		System.out.println(t.points());

	}

}
