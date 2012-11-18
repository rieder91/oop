//import java.util.Iterator;

/**
 * An OrderedMap is a sorted Set<T>.
 * The elements of the Set can point to other elements of type <U>.
 * 
 * @author OOP Gruppe 187
 */

public class OrderedMap<T extends Shorter<? super T>, U> extends OrderedSet<T>{
	
	protected Set<U> elements;
	
	/**
	 * Default constructor
	 */
	public OrderedMap() {
		
		super();
		this.elements = null;
	}
	
	/**
	 * Constructor with one parameter
	 * 
	 * @param e
	 * 			element to be inserted
	 */
	public OrderedMap(T e) {
		
		super(e);
		this.elements = null;
	}
	
	public OrderedMap(T e, Set<U> elements) {
		
		super(e);
		this.elements = new Set<U>(elements);
	}
	
	/**
	 * @return an iterator for the Map
	 */
	public MapIterator<T,U> iterator() {

		return new MapIterator<T,U>(this);
	}
}
