/**
 * in this Strategy the car drives in a zigzag line
 * 
 * @author OOP Gruppe 187
 */
public class ZigzagStrategy implements Strategy {

	private boolean last, beforelast;
	private boolean left;

	/**
	 * default constructor
	 */
	public ZigzagStrategy() {
		this.last = false;
		this.beforelast = false;
	}

	/**
	 * used to get the next move direction 
	 * 
	 * @return the direction of the next move (between -1 and 1)
	 * 		2 times -1 and then 2 times 1
	 */
	@Override
	public int next() {
		if (this.last && this.beforelast) {
			this.left = !this.left;
			this.last = false;
			this.beforelast = false;
		}
		this.beforelast = this.last;
		this.last = false;
		if (this.left) {
			this.last = true;
			return -1;
		}
		else {
			this.last = true;
			return 1;
		}
	}

	@Override
	public String toString() {
		return "Zigzag";
	}

}
