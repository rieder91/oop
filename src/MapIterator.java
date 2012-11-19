import java.util.Iterator;

/**
 * This class implements an Iterator for Maps
 * 
 * @author OOP Gruppe 187
 */
//TODO: extends Set Iterator (nur möglich, wenn OrderedMap extends Set, glaub ich)
public class MapIterator<T extends Shorter<? super T>,U> implements Iterator<T> {
	
	private Integer lastIndexReturned;
	private OrderedMap<T,U> elem;
	private OrderedMap<T,U> cursor;

	/**
	 * Constructor with one parameter
	 * 
	 * @param start
	 * 			The Map were the iterator is used
	 */
	public MapIterator(OrderedMap<T,U> start) {

		this.elem = start;
		this.cursor = start;
		this.lastIndexReturned = -1;
	}
	
	/**
	 * @return an iterator for the Set in the Map
	 */
	public InMapIterator<U> iterator() {

		return new InMapIterator<U>(this.cursor.elements);
	}

	@Override
	public boolean hasNext() {
		
		return this.cursor != null;
	}

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

	@Override
	public void remove() {
		if(this.lastIndexReturned == -1) {
			throw new RuntimeException("SetIterator: next() was never called");
		} else if(this.lastIndexReturned == 0 && hasNext()) {
			// there is a next element and we remove the 1st element
			this.elem.value = this.elem.next.value;
			this.elem.next = this.elem.next.next;
		} else if(this.lastIndexReturned == 0 && !hasNext()) {
			// there is no next element and we remove the 1st element
			this.elem.value = null;
			this.elem.next = null;
		} else {
			OrderedMap<T,U> previous = null;
			OrderedMap<T,U> current = this.elem;
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
