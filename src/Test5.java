/**
 * the fifth test class
 * 
 * a lot of cars on a tiny map
 * 
 * @author OOP Gruppe 187
 */

public class Test5 implements Tester {

	@Override
	public void runTests() {
		System.out.println("Test5:");

		int waitingTime = 4;

		Track t = new Track(3, 15, 20);
		Car c0 = new FastCar(waitingTime, new RandomStrategy(), 2, 1, Direction.South, t);
		Car c1 = new FastCar(waitingTime, new RandomStrategy(), 2, 2, Direction.South, t);
		Car c2 = new FastCar(waitingTime, new RandomStrategy(), 2, 3, Direction.East, t);
		Car c3 = new FastCar(waitingTime, new RandomStrategy(), 2, 4, Direction.North, t);
		Car c4 = new FastCar(waitingTime, new RandomStrategy(), 2, 5, Direction.North, t);
		Car c5 = new FastCar(waitingTime, new RandomStrategy(), 2, 6, Direction.South, t);
		Car c6 = new FastCar(waitingTime, new RandomStrategy(), 2, 7, Direction.East, t);
		Car c7 = new FastCar(waitingTime, new RandomStrategy(), 2, 8, Direction.East, t);
		Car c8 = new FastCar(waitingTime, new RandomStrategy(), 2, 9, Direction.East, t);
		Car c9 = new FastCar(waitingTime, new RandomStrategy(), 2, 10, Direction.North, t);
		Car c10 = new FastCar(waitingTime, new RandomStrategy(), 2, 1, Direction.South, t);
		Car c11 = new FastCar(waitingTime, new RandomStrategy(), 2, 2, Direction.South, t);
		Car c12 = new FastCar(waitingTime, new RandomStrategy(), 2, 3, Direction.East, t);
		Car c13 = new FastCar(waitingTime, new RandomStrategy(), 2, 4, Direction.North, t);
		Car c14 = new FastCar(waitingTime, new RandomStrategy(), 2, 5, Direction.North, t);
		Car c15 = new FastCar(waitingTime, new RandomStrategy(), 2, 6, Direction.South, t);
		Car c16 = new FastCar(waitingTime, new RandomStrategy(), 2, 7, Direction.East, t);
		Car c17 = new FastCar(waitingTime, new RandomStrategy(), 2, 8, Direction.East, t);
		Car c18 = new FastCar(waitingTime, new RandomStrategy(), 2, 9, Direction.East, t);
		Car c19 = new FastCar(waitingTime, new RandomStrategy(), 2, 10, Direction.North, t);
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
