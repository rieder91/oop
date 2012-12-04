/**
 * the fourth test class
 * 
 * a lot of cars on a large map
 * 
 * @author OOP Gruppe 187
 */

public class Test4 implements Tester {

	@Override
	public void runTests() {
		System.out.println("Test4:");
		Track t = new Track(120, 60, 200);
		Car c0 = new ManeuverableCar(12, new LeftCircleStrategy(), 60, 40, Direction.South, t);
		Car c1 = new ManeuverableCar(15, new ZigzagStrategy(), 60, 35, Direction.South, t);
		Car c8 = new FastCar(5, new ZigzagStrategy(), 60, 30, Direction.East, t);
		Car c9 = new FastCar(6, new RandomStrategy(), 60, 25, Direction.North, t);
		Car c2 = new ManeuverableCar(12, new LeftCircleStrategy(), 60, 20, Direction.North, t);
		Car c3 = new ManeuverableCar(13, new ZigzagStrategy(), 65, 40, Direction.South, t);
		Car c10 = new FastCar(4, new ZigzagStrategy(), 65, 35, Direction.East, t);
		Car c11 = new FastCar(5, new RandomStrategy(), 65, 30, Direction.East, t);
		Car c12 = new FastCar(6, new LeftCircleStrategy(), 65, 25, Direction.East, t);
		Car c13 = new FastCar(4, new ZigzagStrategy(), 65, 20, Direction.North, t);
		Car c14 = new FastCar(5, new ZigzagStrategy(), 55, 40, Direction.South, t);
		Car c15 = new FastCar(6, new RandomStrategy(), 55, 35, Direction.West, t);
		Car c4 = new ManeuverableCar(12, new LeftCircleStrategy(), 55, 30, Direction.West, t);
		Car c5 = new ManeuverableCar(15, new ZigzagStrategy(), 55, 25, Direction.West, t);
		Car c16 = new FastCar(4, new ZigzagStrategy(), 55, 20, Direction.North, t);
		Car c17 = new FastCar(5, new RandomStrategy(), 70, 40, Direction.South, t);
		Car c18 = new FastCar(6, new LeftCircleStrategy(), 70, 35, Direction.East, t);
		Car c19 = new FastCar(4, new RandomStrategy(), 70, 30, Direction.East, t);
		Car c20 = new FastCar(6, new ZigzagStrategy(), 70, 25, Direction.East, t);
		Car c21 = new FastCar(4, new ZigzagStrategy(), 70, 20, Direction.North, t);
		Car c6 = new ManeuverableCar(12, new LeftCircleStrategy(), 50, 40, Direction.South, t);
		Car c7 = new ManeuverableCar(13, new ZigzagStrategy(), 50, 35, Direction.West, t);
		Car c22 = new FastCar(6, new LeftCircleStrategy(), 50, 30, Direction.West, t);
		Car c23 = new FastCar(4, new RandomStrategy(), 50, 25, Direction.West, t);
		Car c24 = new ManeuverableCar(13, new RandomStrategy(), 50, 20, Direction.North, t);
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
		int sum = t.pointSum();
		System.out.println("Punktesumme: " + sum);

	}

}
