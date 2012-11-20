
/**
 * 
 * @author OOP Gruppe 187
 *
 * @param <T>
 */
public class InMapIterator<T> extends SetIterator<T> {
	
	
	public InMapIterator() {
		super();
	}
	
	/**
	 * Constructor with one parameter
	 * 
	 * @param start
	 * 			The Map were the iterator is used
	 */
	public InMapIterator(Set<T> in) {
		super(in);
	}
	
	
	/**
	 * Adds an element at the position where the iterator points at
	 * 
	 * @param e
	 * 			Element to be added
	 */
	public void add(T e) {
		Integer lastIndex = this.getLastIndexReturned();
		
		if(e == null) {
			return;
		}
		
		if(lastIndex < 0) {
			throw new RuntimeException("next() needs to be called prior to calling add()");
		} else if(lastIndex == 0) {
			Set<T> firstSet = this.getEntries();
			Set<T> secondSet = new Set<T>(firstSet.getValue());
			secondSet.setNext(firstSet.getNext());
			firstSet.setValue(e);
			firstSet.setNext(secondSet);
			this.setCursor(firstSet);
			
		} else {
			Set<T> nextSet = this.getEntries();
			Set<T> previousSet = new Set<T>();
			for(int i = 0; i < lastIndex + 1; i++) {
				if(i == lastIndex) {
					previousSet = nextSet;
				}
				nextSet = nextSet.getNext();
			}
			
			Set<T> newSet = new Set<T>(e);
			previousSet.setNext(newSet);
			newSet.setNext(nextSet);
			this.setCursor(newSet);
		}
		
		
//		if(this.getEntries() == null) {
//			this.setEntries(new Set<T>(e));
//			return;
//		}
//		if(this.getEntries().getValue() == null) {
//			this.getEntries().setValue(e);
//			return;
//		} else {
//			Set<T> tmp = this.getEntries().getNext();
//			T v = this.getEntries().getValue();
//			this.getEntries().setValue(e);
//			this.getEntries().setNext(new Set<T>(v));
//			this.getEntries().getNext().setNext(tmp);
//		}
	}
}

