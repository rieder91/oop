
/**
 * 
 * @author Markus
 *
 */
public abstract class Car implements Runnable{

	private Direction dir;
	private int interval;
	private Strategy s;
	private int x;
	private int y;
	
	/**
	 * 
	 * @return
	 */
	public Direction getDirection(){
		return this.dir;
	}
	
	/**
	 * 
	 * @return
	 */
	public int getX(){
		return this.x;
	}
	
	/**
	 * 
	 * @return
	 */
	public int getY(){
		return this.y;
	}
	
	/**
	 * 
	 * @param ival
	 * @param s
	 * @param x
	 * @param y
	 * @param dir
	 */
	public Car(int ival,Strategy s, int x, int y, Direction dir){
		this.interval=ival;
		this.s=s;
		this.x=x;
		this.y=y;
		this.dir=dir;
	}
	
	/**
	 * 
	 * @return
	 */
	protected Strategy getStrategy(){
		return this.s;
	}
	
	/**
	 * 
	 */
	@Override
	public void run() {
		while(true){
			try {
				Thread.sleep(this.interval);
				this.drive();
			}
			catch (InterruptedException e) {
				return;
			}
			
		}
		
	}

	/**
	 * 
	 */
	protected abstract void drive();
}
