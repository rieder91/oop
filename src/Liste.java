

public class Liste {
	Object value;
	Liste next;
	Liste previous;
	
	
	public Liste() {
	}
	
	public Liste(Object o) {
		this(o, null);
	}
	
	private Liste(Object o, Liste previous) {
		this.value = o;
		this.previous = previous;
	}
	
	public void add(Object o) {
		if(value == null) {
			value = o;
		} else if (next == null ){
			next = new Liste(o, this);
		} else if (next != null) {
			next.add(o);
		}
	}
	
	public ListIterator iterator() {
		return new ListIterator(this);
	}
	
	private class ListIterator {
		
		Liste current;
		Liste lastReturned;
		
		public ListIterator(Liste l) {
			current = l;
			lastReturned = null;
		}
		
		public boolean hasNext() {
			if(current.value == null) {
				return false;
			} else if (current.next == null) {
				return false;
			} else {
				return true;
			}
		}
		
		public Object next() {
			if(hasNext()) {
				Object tmp = current.value;
				lastReturned = current;
				current = current.next;
				return tmp;
			} else  {
				return null;
			}
			
		}
		
		public void remove() {
			if(lastReturned.next == null && lastReturned.previous == null) {
				lastReturned.value = null;
			} else if(lastReturned.next == null) {
				lastReturned.previous.next = null;
			} else if(lastReturned.previous == null) {
				lastReturned.value = lastReturned.next.value;
				if(lastReturned.next.next != null) {
					lastReturned.next.next.previous = lastReturned;
				}
				lastReturned.next = lastReturned.next.next;
			} else {
				lastReturned.previous.next = lastReturned.next;
				lastReturned.next.previous = lastReturned.previous;
			}
		}
	}
	
}
