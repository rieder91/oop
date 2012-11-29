

public abstract class Autodrom implements Runnable{

	private int interval;
	private Strategy s;
	
	public Autodrom(int ival,Strategy s){
		this.interval=ival;
		this.s=s;
	}
	
	protected Strategy getStrategy(){
		return this.s;
	}
	
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

	protected abstract void drive();
}
