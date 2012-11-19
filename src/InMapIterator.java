
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
		/*
		if(this.entry == null) {
			this.entry = new Set<N>(e);
			return;
		}
		if(this.entry.value == null) {
			this.entry.value = e;
			return;
		} else {
			Set<N> tmp = this.entry.next;
			N v = this.entry.value;
			this.entry.value = e;
			this.entry.next = new Set<N>(v);
			this.entry.next.next = tmp;
		}*/
	}
}

