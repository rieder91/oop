//import java.util.Iterator;

/**
 * This class implements an Iterator for Maps
 * 
 * @author OOP Gruppe 187
 */

public class MapIterator<T extends Shorter<? super T>,U> extends SetIterator<T> {
	
	private Set<U> elem;

	/**
	 * Constructor with one parameter
	 * 
	 * @param start
	 * 			The Map were the iterator is used
	 */
	public MapIterator(OrderedMap<T,U> start) {
		
		super(start);
		this.elem = start.elements;
	}
	
	/**
	 * @return an iterator for the Set in the Map
	 */
	public InMapIterator<U> iterator() {

		return new InMapIterator<U>(this.elem);
	}
	
	/*
	 * Inner Class Begin
	 */
	//public class InMapIterator<N> extends SetIterator<N>{
		
		/**
		 * Constructor with one parameter
		 * 
		 * @param start
		 * 			The Map were the iterator is used
		 *//*
		public InMapIterator(Set<N> in) {
			super(in);
		}*/
		
		/**
		 * Adds an element at the position where the iterator points at
		 * 
		 * @param e
		 * 			Element to be added
		 *//*
		public void add(N e) {
		
			if(entry.value == null) {
				entry.value = e;
			} else {
				Set<N> tmp = entry.next;
				N v = entry.value;
				entry.value = e;
				entry.next = new Set<N>(v);
				entry.next.next = tmp;
			}
		}
	}
	/*
	 * Inner Class End
	 */
}
