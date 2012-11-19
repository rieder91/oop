import java.util.Iterator;

/**
 * A Set is an unsorted collection of elements of type <T>.
 * 
 * @author OOP Gruppe 187
 */

public class Set<T> implements Iterable<T> {
	protected T value;
	protected Set<T> next;
	
	/**
	 * Default constructor
	 */
	//TODO
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
}
