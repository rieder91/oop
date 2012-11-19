
public class InMapIterator<T> extends SetIterator<T> {
	
	/**
	 * Constructor with one parameter
	 * 
	 * @param start
	 * 			The Map were the iterator is used
	 */
	public InMapIterator(Set<T> in) {
		super(in);
	}
	
	/**
	 * Adds an element at the position where the iterator points at
	 * 
	 * @param e
	 * 			Element to be added
	 */
	public void add(T e) {
		
		if(this.getEntries() == null) {
			this.setEntries(new Set<T>(e));
			return;
		}
		if(this.getEntries().value == null) {
			this.getEntries().value = e;
			return;
		} else {
			Set<T> tmp = this.getEntries().next;
			T v = this.getEntries().value;
			this.getEntries().value = e;
			this.getEntries().next = new Set<T>(v);
			this.getEntries().next.next = tmp;
		}
	}
}

