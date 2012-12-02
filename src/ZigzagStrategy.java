/**
 * in this Strategy the car drives in a zigzag line
 * 
 * @author OOP Gruppe 187
 */
public class ZigzagStrategy implements Strategy {

	boolean last, beforelast;
	boolean left;

	ZigzagStrategy() {
		this.last = false;
		this.beforelast = false;
	}

	/**
	 * @return the direction of the next move
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

}
