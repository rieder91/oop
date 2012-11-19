/**
 * An OrderedMap is similar to a sorted Set<T>.
 * The sorted elements of the Map can point to other elements of type <U>.
 * 
 * @author OOP Gruppe 187
 */
//TODO Untertyp von Set/Ordered Set
// nur ein Typparameter
public class OrderedMap<T extends Shorter<? super T>, U> {
	
	protected OrderedMap<T,U> next;
	protected T value;
	protected Set<U> elements;
	
	//TODO
	public OrderedMap() {
		
		this.next = null;
		this.value = null;
		this.elements = null;
	}
	
	public OrderedMap(T e) {
		
		this.next = null;
		this.value = e;
		this.elements = null;
	}
	
	public boolean insert(T e) {
		
		if(this.value == e)
			return false;
		
		if(this.value == null) {
			this.value = e;
			return true;
		}
		
		if(this.next == null) {
			this.next = new OrderedMap<T,U>(e);
			return true;
		}
		
		if(e.shorter(this.value)) {
			OrderedMap<T,U> tmp = this.next;
			T v = this.value;
			this.value = e;
			this.next = new OrderedMap<T,U>(v);
			this.next.next = tmp;
			return true;
		}
		
		return this.next.insert(e);
	}
	
	public MapIterator<T,U> iterator() {
		
		return new MapIterator<T,U>(this);
	}
}
