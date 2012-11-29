import java.util.ArrayList;

/**
 * 
 * @author Markus
 *
 */

public class Track {
	ArrayList<Car> cars;
	ArrayList<Thread> carthread;
	int maxx;
	int maxy;
	
	/**
	 * 
	 */
	public Track(){
		cars = new ArrayList<Car>();
		this.maxx=80;
		this.maxy=20;
	}
	
	/**
	 * 
	 * @param car
	 */
	public void addCar(Car car){
		this.cars.add(car);
		carthread.add(new Thread(car));
	}
	
	/**
	 * 
	 */
	public void start(){
		for(Thread t:this.carthread){
			t.start();
		}
	}
	
	/**
	 * 
	 * @param c
	 * @param move
	 * @return
	 */
	public boolean validMove(Car c,int move){
		boolean exists=false;
		boolean valid=false;
		int newx;
		int newy;
		
		for(Car cc:cars){
			if(cc==c){
				exists=true;
			}
		}
		return valid&&exists;
		
	}
	
	/**
	 * 
	 */
	public void stop(){
		for(Thread t:this.carthread){
			t.interrupt();
		}
	}
}
