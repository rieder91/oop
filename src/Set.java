import java.util.Iterator;

/**
 * A Set is an unsorted collection of elements of type <T>.
 * 
 * @author OOP Gruppe 187
 */

public class Set<T> implements Iterable<T> {
	private T value;
	private Set<T> next;

	/**
	 * Default constructor
	 */
	public Set() {
		this.value = null;
		this.next = null;
	}

	/**
	 * Constructor with one parameter
	 * 
	 * @param e
	 * 			element to be inserted
	 */
	public Set(T e) {

		this.value = e;
		this.next = null;
	}

	/**
	 * Constructor for deep copy
	 * 
	 * @param s
	 * 			Set, which shall be copied
	 */
	public Set(Set<T> s) {

		Iterator<T> it = s.iterator();
		while(it.hasNext()) {
			this.insert(it.next());
		}
	}

	/**
	 * Element @e is added in Set, if no identical entry exists
	 * 
	 * @param e
	 * 			element to be inserted
	 * @return false if e is identical to another entry, true if successful
	 */
	public boolean insert(T e) {
		if(e == null) {
			return false;
		}

		if(this.value == e) {
			return false;
		}

		if(this.value == null) {
			this.value = e;
			return true;
		}

		if(this.next == null) {
			this.next = new Set<T>(e);
			return true;
		} else {
			return this.next.insert(e);
		}
	}

	/**
	 * @return an iterator for the Set
	 */
	public Iterator<T> iterator(){

		return new SetIterator<T>(this);
	}

	/**
	 * getter for the value
	 * @return value
	 */
	public T getValue() {
		return value;
	}

	/**
	 * getter for the next value
	 * @return the next element in the set
	 */
	public Set<T> getNext() {
		return next;
	}

	/**
	 * setter for the value
	 * @param value new value
	 */
	protected void setValue(T value) {
		this.value = value;
	}

	/**
	 * setter for the next element
	 * @param next next element
	 */
	protected void setNext(Set<T> next) {
		this.next = next;
	}
}
