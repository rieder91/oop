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
	 */
	public boolean insert(T e) {
		Set<T> tmpSet = this.getNext();
		
		// if e is already in the set, return false
		if(contains(e)) {
			return false;
		}
		
		if(this.getValue() == null) {
			this.setValue(e);
			return true;
		}
		
		if(e.shorter(this.getValue())) {
			Set<T> tmp = this.getNext();
			T v = this.getValue();
			this.setValue(e);
			this.setNext(new Set<T>(v));
			this.getNext().setNext(tmp);
			return true;
		}
		
		if(this.getNext() == null) {
			this.setNext(new Set<T>(e));
			return true;
		}
		
		while(!e.shorter(tmpSet.getValue()) && tmpSet.getNext() != null) {
			tmpSet = tmpSet.getNext();
		}
		
		if(e.shorter(tmpSet.getValue())) {
			Set<T> tmp2 = tmpSet.getNext();
			T v2 = tmpSet.getValue();
			tmpSet.setValue(e);
			tmpSet.setNext(new Set<T>(v2));
			tmpSet.getNext().setNext(tmp2);
			return true;
		} else {
			tmpSet.setNext(new Set<T>(e));
			return true;
		}
	}
	
	/**
	 * check if the set contains an element
	 * @param e element which is searched for
	 * @return true if the set contains the element
	 */
	public boolean contains(T e) {
		Iterator<T> it = this.iterator();
		
		while(it.hasNext()) {
			if(it.next() == e) {
				return true;
			}
		}
		
		return false;
	}
}
