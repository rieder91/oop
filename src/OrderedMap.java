
/**
 * An OrderedMap is similar to a sorted Set<T>.
 * The sorted elements of the Map can point to other elements of type <U>.
 * 
 * @author OOP Gruppe 187
 */
public class OrderedMap<T extends Shorter<? super T>, U> extends OrderedSet<T> {

	private Set<U> elements;
	private OrderedMap<T, U> nextMap;


	/**
	 * default constructor
	 */
	public OrderedMap() {
		super();
		this.elements = new Set<U>();
	}

	/**
	 * default constructor which requires one value
	 * @param e first element of the map
	 */
	public OrderedMap(T e) {
		super(e);
		this.elements = new Set<U>();
	}

	/**
	 * returns the iterator for the map
	 * @return appropriate iterator
	 */
	public MapIterator<T,U> iterator() {
		return new MapIterator<T,U>(this);
	}

	/**
	 * gets the values of the map-key 
	 * @return
	 */
	protected Set<U> getElements() {
		return elements;
	}

	/**
	 * sets the elements of the map-key
	 * @param elements new elements
	 */
	protected void setElements(Set<U> elements) {
		this.elements = elements;
	}
	
	@Override
	public boolean insert(T e) {

		OrderedMap<T, U> tmpSet = this.getNextMap();

		// if e is already in the set, return false
		if(super.contains(e)) {
			return false;
		}

		if(this.getValue() == null) {
			this.setValue(e);
			return true;
		}

		if(e.shorter(this.getValue())) {
			OrderedMap<T, U> tmp = this.getNextMap();
			T v = this.getValue();
			this.setValue(e);
			this.setNextMap(new OrderedMap<T, U>(v));
			this.getNextMap().setNextMap(tmp);
			return true;
		}

		if(this.getNextMap() == null) {
			this.setNextMap(new OrderedMap<T, U>(e));
			return true;
		}

		while(!e.shorter(tmpSet.getValue()) && tmpSet.getNextMap() != null) {
			tmpSet = tmpSet.getNextMap();
		}

		if(e.shorter(tmpSet.getValue())) {
			OrderedMap<T, U> tmp2 = tmpSet.getNextMap();
			T v2 = tmpSet.getValue();
			tmpSet.setValue(e);
			tmpSet.setNextMap(new OrderedMap<T, U>(v2));
			tmpSet.getNextMap().setNextMap(tmp2);
			return true;
		} else {
			tmpSet.setNextMap(new OrderedMap<T, U>(e));
			return true;
		}
	}
	
	/**
	 * @return returns the pointer to the next map inside the data-structure
	 */
	protected OrderedMap<T, U> getNextMap() {
		return nextMap;
	}

	/**
	 * @param nextMap sets the next map inside the data-structure
	 */
	protected void setNextMap(OrderedMap<T, U> nextMap) {
		this.nextMap = nextMap;
		super.setNext(nextMap); // makes the map iterator easier
	}
	
	
	/**
	 * 
	 * @param value
	 * @param key
	 * @return
	 */
	public boolean addValueToKey(T value, U key) {
		OrderedMap<T, U> temp = this;
		
		while(temp != null) {
			if(temp.getValue() == value) {
				return temp.getElements().insert(key);
			}
			temp = temp.nextMap;
		}
		
		return false;
		
	}

}
