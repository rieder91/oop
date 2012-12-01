

public class Test2 implements Tester {

	@Override
	public void runTests() {
		System.out.println("Test2:");
		Track t = new Track(40, 20, 400);
		Car c1 = new fastCar(6, new randomStrategy(), 20, 10, Direction.South, t);
		Car c2 = new fastCar(4, new circleStrategy(), 20, 12, Direction.North, t);
		Car c3 = new fastCar(5, new zigzagStrategy(), 20, 8, Direction.North, t);
		Car c4 = new fastCar(6, new zigzagStrategy(), 22, 10, Direction.West, t);
		Car c5 = new fastCar(4, new zigzagStrategy(), 22, 8, Direction.West, t);
		Car c6 = new fastCar(6, new circleStrategy(), 22, 12, Direction.West, t);
		Car c7 = new fastCar(4, new randomStrategy(), 18, 10, Direction.East, t);
		Car c8 = new fastCar(6, new circleStrategy(), 18, 12, Direction.East, t);
		Car c9 = new fastCar(4, new randomStrategy(), 18, 8, Direction.East, t);
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

	}

}
