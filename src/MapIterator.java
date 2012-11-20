
/**
 * This class implements an Iterator for Maps
 * 
 * @author OOP Gruppe 187
 */
public class MapIterator<T extends Shorter<? super T>,U> extends SetIterator<T> {
	private OrderedMap<T, U> orderedMap;
	
	/**
	 * Constructor with one parameter
	 * 
	 * @param start
	 * 			The Map were the iterator is used
	 */
	public MapIterator(OrderedMap<T,U> start) {
		super(start);
		orderedMap = start;
	}
	
	/**
	 * @return an iterator for the Set in the Map
	 */
	public InMapIterator<U> iterator() {
		OrderedMap<T, U> tempCursor = orderedMap;
		
		for(int i = 0; i < this.getLastIndexReturned(); i++) {
			tempCursor = tempCursor.getNextMap();
		}
		
		return new InMapIterator<U>(tempCursor.getElements());
	}
}
