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
	private Set<T> lastElement;
	private Set<T> previousElement;

	/**
	 * Default constructor
	 */
	public SetIterator() {
		this.lastIndexReturned = -1;
		this.cursor = null;
		this.entries = null;
		this.lastElement = null;
		this.previousElement = null;
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
		this.lastElement = null;
		this.previousElement = null;
	}

	/**
	 * @return true if the iteration has more elements, false otherwise
	 */
	@Override
	public boolean hasNext() {
		return this.cursor != null && cursor.getValue() != null;
	}

	/**
	 * @return the next element of the iteration.
	 */
	@Override
	public T next() {
		if (this.hasNext()) {

			T result = this.cursor.getValue();
			this.lastIndexReturned++;
			if(this.lastElement != null) {
				this.previousElement = this.lastElement;
			}


			this.lastElement = this.cursor;
			this.cursor = this.cursor.getNext();

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
		if(this.lastIndexReturned == -1) {
			throw new RuntimeException("SetIterator: next() was never called");
		} else if(this.lastIndexReturned == 0 && hasNext()) {
			// there is a next element and we remove the 1st element
			this.entries.setValue(this.entries.getNext().getValue());
			this.entries.setNext(this.entries.getNext().getNext());
			
			lastIndexReturned--;
		} else if(this.lastIndexReturned == 0 && !hasNext()) {
			// there is no next element and we remove the 1st element
			this.entries.setValue(null);
			this.entries.setNext(null);
		} else {
			Set<T> previous = previousElement;
			Set<T> current = lastElement;

			previous.setNext(current.getNext());

			this.cursor = entries.getNext();
			this.lastElement = previous;
			this.previousElement = null;
			
			lastIndexReturned--;

		}
	}

	/**
	 * getter for the set behind the iterator
	 * @return set behind the iterator
	 */
	public Set<T> getEntries() {
		return entries;
	}

	/**
	 * setter for the set the iterator points to; used by InMapIterator
	 * @param entries 
	 */
	protected void setEntries(Set<T> entries) {
		this.entries = entries;
	}

	/**
	 * getter for the current element the iterator points to; similar to peek()
	 * @return the current posiiton of the iterator
	 */
	public Set<T> getCursor() {
		return cursor;
	}

	/**
	 * @return the index of the last element that was returned
	 */
	public Integer getLastIndexReturned() {
		return lastIndexReturned;
	}
	
	/**
	 * sets the iterator-cursor to a new target
	 * @param cursor new target
	 */
	protected void setCursor(Set<T> cursor) {
		this.cursor = cursor;
	}

	/**
	 * setter for the last index returned by the iterator
	 * @param lastIndexReturned last index returned
	 */
	protected void setLastIndexReturned(Integer lastIndexReturned) {
		this.lastIndexReturned = lastIndexReturned;
	}
}
