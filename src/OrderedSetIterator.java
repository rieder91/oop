import java.util.Iterator;


public class OrderedSetIterator<T extends Shorter<? super T>> extends SetIterator<T> {

	/**
	 * Constructor with one parameter
	 * 
	 * @param start
	 * 			The Set were the iterator is used
	 */
	public OrderedSetIterator(Set<T> inSet) {
		
		super();
		
		Iterator<T> it = inSet.iterator();
		
		while(it.hasNext()) {
			
			T in = it.next();
			Set<T> tmpSet = entry;
			
			while(true) {
				if(tmpSet.value == null) {
					tmpSet.value = in;
					break;
				}
				
				if(in.shorter(tmpSet.value)) {
					Set<T> tmp = tmpSet.next;
					T v = tmpSet.value;
					tmpSet.value = in;
					tmpSet.next = new Set<T>(v);
					tmpSet.next.next = tmp;
					break;
				}
				
				if(tmpSet.next == null) {
					tmpSet.next = new Set<T>(in);
					break;
				} else {
					tmpSet = tmpSet.next;
				}
			}
		}
	}
}
