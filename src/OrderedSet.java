import java.util.Iterator;

/**
 * An OrderedSet is a sorted Set<T>.
 * 
 * @author OOP Gruppe 187
 */

public class OrderedSet<T extends Shorter<? super T>> extends Set<T> {
	
	/**
	 * Default constructor
	 */
	public OrderedSet() {
		
		super();
	}
	
	/**
	 * Constructor with one parameter
	 * 
	 * @param e
	 * 			element to be inserted
	 */
	public OrderedSet(T e) {
		
		super(e);
	}
	
	/**
	 * Element @e is added in Set were @e is shorter than the following entries,
	 * if no identical entry exists
	 * 
	 * @param e
	 * 			element to be inserted
	 * @return false if e is identical to another entry, true if successful
	 *//*
	public boolean insert(T e) {
		
		if(this.value == e)
			return false;
		
		if(this.value == null) {
			this.value = e;
			return true;
		}
		
		if(e.shorter(this.value)) {
			Set<T> tmp = this.next;
			T v = this.value;
			this.value = e;
			this.next = new Set<T>(v);
			this.next.next = tmp;
			return true;
		}
		if(this.next == null) {
			this.next = new Set<T>(e);
			return true;
		} else {
			return this.next.insert(e);
		}
	}*/
	
	/**
	 * @return an iterator for the Set
	 */
	public Iterator<T> iterator(){
		
		return new OrderedSetIterator<T>(this);
	}
}
