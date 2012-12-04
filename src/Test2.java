/**
 * the second test class
 * 
 * @author OOP Gruppe 187
 */

public class Test2 implements Tester {

	/**
	 * only fast cars on a small to medium sized map
	 */
	@Override
	public void runTests() {
		System.out.println("Test2:");
		Track t = new Track(40, 20, 400);
		Car c1 = new FastCar(6, new RandomStrategy(), 20, 10, Direction.South, t);
		Car c2 = new FastCar(4, new CircleStrategy(), 20, 12, Direction.North, t);
		Car c3 = new FastCar(5, new ZigzagStrategy(), 20, 8, Direction.North, t);
		Car c4 = new FastCar(6, new ZigzagStrategy(), 22, 10, Direction.West, t);
		Car c5 = new FastCar(4, new ZigzagStrategy(), 22, 8, Direction.West, t);
		Car c6 = new FastCar(6, new CircleStrategy(), 22, 12, Direction.West, t);
		Car c7 = new FastCar(4, new RandomStrategy(), 18, 10, Direction.East, t);
		Car c8 = new FastCar(6, new CircleStrategy(), 18, 12, Direction.East, t);
		Car c9 = new FastCar(4, new RandomStrategy(), 18, 8, Direction.East, t);
		t.addCar(c1);
		t.addCar(c2);
		t.addCar(c3);
		t.addCar(c4);
		t.addCar(c5);
		t.addCar(c6);
		t.addCar(c7);
		t.addCar(c8);
		t.addCar(c9);
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
