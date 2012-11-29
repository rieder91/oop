import java.util.ArrayList;



public class Track {
	ArrayList<CarCoords> cars;
	ArrayList<Thread> carthread;
	int maxx;
	int maxy;
	private class CarCoords{
		private Car car;
		private int x;
		private int y;
		private int dir;
		
		private CarCoords(Car c, int x, int y, int dir){
			this.car=c;
			this.x=x;
			this.y=y;			
		}
		
		
	}
	
	public Track(){
		cars = new ArrayList<CarCoords>();
		this.maxx=80;
		this.maxy=20;
	}
	
	public void addCar(Car car,int x, int y, int dir){
		this.cars.add(new CarCoords(car,x,y,dir));
		carthread.add(new Thread(car));
	}
	
	public void start(){
		for(Thread t:this.carthread){
			t.start();
		}
	}
	
	public boolean validMove(Car c,int move){
		boolean exists=false;
		boolean valid=false;
		int newx;
		int newy;
		
		for(CarCoords cc:cars){
			if(cc.car==c){
				exists=true;
				newx=cc.x;
				newy=cc.y;
			}
		}
		return false;
		
	}
	
	public void stop(){
		for(Thread t:this.carthread){
			t.interrupt();
		}
	}
}
