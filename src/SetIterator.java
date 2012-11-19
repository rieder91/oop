import java.util.Iterator;

/**
 * This class implements an Iterator for Sets
 * 
 * @author OOP Gruppe 187
 */

public class SetIterator<T> implements Iterator<T> {

	protected Set<T> entry;
	
	/**
	 * Default constructor
	 */
	public SetIterator() {
		this.entry = null;
	}
	
	/**
	 * Constructor with one parameter
	 * 
	 * @param start
	 * 			The Set were the iterator is used
	 */
	public SetIterator(Set<T> start) {
		
		this.entry = start;
	}

	/**
	 * @return true if the iteration has more elements, false otherwise
	 */
	@Override
	public boolean hasNext() {
		
		return this.entry != null;
	}

	/**
	 * @return the next element of the iteration.
	 */
	@Override
	public T next() {
		
		if(this.entry.value != null) {
			T res = this.entry.value;
			this.entry = this.entry.next;
			return res;
			
		}
		return null;
	}

	/**
	 * Removes the last element returned by the iterator
	 */
	@Override
	public void remove() {
		//TODO: null pointer exception if next is null
		this.entry.value = this.entry.next.value;
		this.entry.next = this.entry.next.next;
	}
}
