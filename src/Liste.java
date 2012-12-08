
/**
 * a list that is not type-safe
 * 
 * in our case the client ensure that everything is type-safe (the same way the
 * list is implemented in the Skriptum)
 * 
 * @author Thomas
 * 
 */
public class Liste {
	private Object value;
	private Liste next;
	private Liste previous;

	public Liste() {
		next = null;
		previous = null;
		value = null;
	}

	public Liste(Object o) {
		this(o, null);
	}

	private Liste(Object o, Liste previous) {
		this.value = o;
		this.previous = previous;
	}

	public Object searchFor(Object o) {
		MyIterator it = iterator();
		while (it.hasNext()) {
			Object nextValue = it.next();
			if (nextValue.equals(o)) {
				return nextValue;
			}
		}
		return null;

	}

	public void add(Object o) {
		if (value == null) {
			value = o;
		} else if (next == null) {
			next = new Liste(o, this);
		} else if (next != null) {
			next.add(o);
		}
	}

	public MyIterator iterator() {
		return new ListIterator(this);
	}

	public String toString() {
		StringBuilder ret = new StringBuilder("[");

		MyIterator it = iterator();
		while (it.hasNext()) {
			ret.append(it.next());
			if (it.hasNext()) {
				ret.append(",\n ");
			}
		}
		
		ret.append("]");

		return ret.toString();
	}

	public boolean contains(Object o) {
		MyIterator it = new ListIterator(this);

		while (it.hasNext()) {
			if (it.next().equals(o)) {
				return true;
			}
		}

		return false;
	}

	private class ListIterator implements MyIterator {

		private Liste current;
		private Liste lastReturned;

		public ListIterator(Liste l) {
			current = l;
			lastReturned = null;
		}

		public boolean hasNext() {
			if (current == null || current.value == null) {
				return false;
			} else {
				return true;
			}
		}

		public Object next() {
			if (hasNext()) {
				Object tmp = current.value;
				lastReturned = current;
				if (current.next == null) {
					current = null;
				} else {
					current = current.next;
				}

				return tmp;
			} else {
				return null;
			}

		}

		public void remove() {
			if (lastReturned.next == null && lastReturned.previous == null) {
				lastReturned.value = null;
			} else if (lastReturned.next == null) {
				lastReturned.previous.next = null;
			} else if (lastReturned.previous == null) {
				lastReturned.value = lastReturned.next.value;

				if (lastReturned.next.next != null) {
					lastReturned.next.next.previous = lastReturned;
				} else {
					lastReturned.next.previous = null;
				}

				lastReturned.next = lastReturned.next.next;

				current = lastReturned;
			} else {
				lastReturned.previous.next = lastReturned.next;
				lastReturned.next.previous = lastReturned.previous;
			}
			lastReturned = null;
		}
	}
}
