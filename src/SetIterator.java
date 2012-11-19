import java.util.Iterator;

/**
 * This class implements an Iterator for Sets
 * 
 * @author OOP Gruppe 187
 */

public class SetIterator<T> implements Iterator<T> {

	private Integer lastIndexReturned;
	private Set<T> cursor;
	private Set<T> entries;
	
	/**
	 * Default constructor
	 */
	public SetIterator() {
		this.lastIndexReturned = -1;
		this.cursor = null;
		this.entries = null;
	}
	
	/**
	 * Constructor with one parameter
	 * 
	 * @param start
	 * 			The Set were the iterator is used
	 */
	public SetIterator(Set<T> start) {
		this.cursor = start;
		this.entries = start;
		this.lastIndexReturned = -1;
	}

	/**
	 * @return true if the iteration has more elements, false otherwise
	 */
	@Override
	public boolean hasNext() {
		return this.cursor != null;
	}

	/**
	 * @return the next element of the iteration.
	 */
	@Override
	public T next() {
		if (this.hasNext()) {
			T result = this.cursor.value;
			this.lastIndexReturned++;
			this.cursor = this.cursor.next;
			
			return result;
		} else {
			return null;
		}
	}

	/**
	 * Removes the last element returned by the iterator
	 */
	@Override
	public void remove() {
		if(this.lastIndexReturned == 0) {
			this.entries = this.entries.next;
		} else {
			Set<T> previous = null;
			Set<T> current = entries;
			for(int i = 0; i < this.lastIndexReturned; i++) {
				if(i == this.lastIndexReturned - 1) {
					previous = current;
				}
				current = current.next;
			}
			
			if(current.next != null) {
				previous.next = current.next;
			} else {
				previous.next = null;
			}
		}
	}
}
