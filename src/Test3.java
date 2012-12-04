/**
 * the fourth third class
 * 
 * @author OOP Gruppe 187
 */

public class Test3 implements Tester {

	/**
	 * only maneuverable cars on a smal map
	 */
	@Override
	public void runTests() {
		System.out.println("Test3:");
		Track t = new Track(10, 10, 50);
		Car c1 = new ManeuverableCar(15, new RandomStrategy(), 5, 7, Direction.South, t);
		Car c2 = new ManeuverableCar(12, new ZigzagStrategy(), 5, 5, Direction.South, t);
		Car c3 = new ManeuverableCar(13, new ZigzagStrategy(), 5, 3, Direction.North, t);
		Car c4 = new ManeuverableCar(12, new CircleStrategy(), 4, 5, Direction.East, t);
		Car c5 = new ManeuverableCar(15, new RandomStrategy(), 6, 5, Direction.West, t);
		t.addCar(c1);
		t.addCar(c2);
		t.addCar(c3);
		t.addCar(c4);
		t.addCar(c5);
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

		if (((sum % 2) == 0) && (sum >= 0)) {
			System.out.println("Test erfolgreich.");
		}
		else {
			System.out.println("Test fehlgeschlagen.");
		}
	}

}
