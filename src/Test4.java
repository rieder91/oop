/**
 * the fourth test class
 * 
 * @author OOP Gruppe 187
 *
 */

public class Test4 implements Tester {

	/**
	 * a lot of cars on a large map
	 */
	@Override
	public void runTests() {
		System.out.println("Test4:");
		Track t = new Track(120, 60, 200);
		Car c0 = new maneuverableCar(12, new circleStrategy(), 	60, 40, Direction.South, t);
		Car c1 = new maneuverableCar(15, new zigzagStrategy(), 	60, 35, Direction.South, t);
		Car c8 = new fastCar(5, new zigzagStrategy(), 			60, 30, Direction.East, t);
		Car c9 = new fastCar(6, new randomStrategy(), 			60, 25, Direction.North, t);
		Car c2 = new maneuverableCar(12, new circleStrategy(), 	60, 20, Direction.North, t);
		Car c3 = new maneuverableCar(13, new zigzagStrategy(), 	65, 40, Direction.South, t);
		Car c10 = new fastCar(4, new zigzagStrategy(), 			65, 35, Direction.East, t);
		Car c11 = new fastCar(5, new randomStrategy(), 			65, 30, Direction.East, t);
		Car c12 = new fastCar(6, new circleStrategy(), 			65, 25, Direction.East, t);
		Car c13 = new fastCar(4, new zigzagStrategy(), 			65, 20, Direction.North, t);
		Car c14 = new fastCar(5, new zigzagStrategy(), 			55, 40, Direction.South, t);
		Car c15 = new fastCar(6, new randomStrategy(), 			55, 35, Direction.West, t);
		Car c4 = new maneuverableCar(12, new circleStrategy(), 	55, 30, Direction.West, t);
		Car c5 = new maneuverableCar(15, new zigzagStrategy(), 	55, 25, Direction.West, t);
		Car c16 = new fastCar(4, new zigzagStrategy(), 			55, 20, Direction.North, t);
		Car c17 = new fastCar(5, new randomStrategy(), 			70, 40, Direction.South, t);
		Car c18 = new fastCar(6, new circleStrategy(), 			70, 35, Direction.East, t);
		Car c19 = new fastCar(4, new randomStrategy(), 			70, 30, Direction.East, t);
		Car c20 = new fastCar(6, new zigzagStrategy(), 			70, 25, Direction.East, t);
		Car c21 = new fastCar(4, new zigzagStrategy(), 			70, 20, Direction.North, t);
		Car c6 = new maneuverableCar(12, new circleStrategy(), 	50, 40, Direction.South, t);
		Car c7 = new maneuverableCar(13, new zigzagStrategy(), 	50, 35, Direction.West, t);
		Car c22 = new fastCar(6, new circleStrategy(), 			50, 30, Direction.West, t);
		Car c23 = new fastCar(4, new randomStrategy(), 			50, 25, Direction.West, t);
		Car c24 = new maneuverableCar(13, new randomStrategy(), 50, 20, Direction.North, t);
		t.addCar(c0);
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
		t.addCar(c24);
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
