/**
 * a doubly linked list that is not type-safe - obviously as type-parameters are
 * forbidden
 * 
 * in our case the client ensure that everything is type-safe (the same way the
 * list is implemented in the Skriptum 3.3.2)
 * 
 * @author Dominic
 * 
 */
@Creator(name = "Dominic", lastUpdate = "06.12.2012")
public class Liste {
	private Object value;
	private Liste next;
	private Liste previous;

	/**
	 * default constructor for an empty list
	 */
	@Creator(name = "Dominic", lastUpdate = "06.12.2012")
	public Liste() {
		next = null;
		previous = null;
		value = null;
	}

	/**
	 * default constructor for a list with one element
	 * 
	 * @param o
	 *            first element
	 */
	@Creator(name = "Dominic", lastUpdate = "06.12.2012")
	public Liste(Object o) {
		this(o, null);
	}

	/**
	 * private constructor used to append new elements
	 * 
	 * @param o
	 *            new element
	 * @param previous
	 *            previous element
	 */
	@Creator(name = "Dominic", lastUpdate = "06.12.2012")
	private Liste(Object o, Liste previous) {
		this.value = o;
		this.previous = previous;
	}

	/**
	 * searches for an returns an object that is equal to the argument - if it
	 * exists
	 * 
	 * @param o
	 *            object which is searched for
	 * @return the object if one is found - null otherwise
	 * 
	 *         NOTE: used to search a list for a traktor given only the serial
	 */
	@Creator(name = "Dominic", lastUpdate = "06.12.2012")
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

	/**
	 * adds an object to the list - type-safety has to be ensured by the client
	 * 
	 * @param o
	 *            new object
	 */
	@Creator(name = "Dominic", lastUpdate = "06.12.2012")
	public void add(Object o) {
		if (value == null) {
			value = o;
		} else if (next == null) {
			next = new Liste(o, this);
		} else if (next != null) {
			next.add(o);
		}
	}

	/**
	 * returns an iterator to traverse the list
	 * 
	 * @return iterator
	 */
	@Creator(name = "Dominic", lastUpdate = "06.12.2012")
	public MyIterator iterator() {
		return new ListIterator(this);
	}

	/**
	 * string representation of the list for easier debugging
	 */
	@Creator(name = "Dominic", lastUpdate = "06.12.2012")
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

	/**
	 * returns true if the list contains an object
	 * 
	 * @param o
	 *            object which we seek
	 * @return true if the list contains the object
	 */
	@Creator(name = "Dominic", lastUpdate = "06.12.2012")
	public boolean contains(Object o) {
		return this.searchFor(o) != null ? true : false;
	}

	/**
	 * nested class for the iterator to access the list elements
	 * 
	 * @author Dominic
	 * 
	 */
	@Creator(name = "Dominic", lastUpdate = "06.12.2012")
	private class ListIterator implements MyIterator {

		private Liste current;
		private Liste lastReturned;

		/**
		 * default constructor which takes the list over which we are going to
		 * iterator as an argument
		 * 
		 * @param l
		 *            target list
		 */
		@Creator(name = "Dominic", lastUpdate = "06.12.2012")
		public ListIterator(Liste l) {
			current = l;
			lastReturned = null;
		}

		@Override
		@Creator(name = "Dominic", lastUpdate = "06.12.2012")
		public boolean hasNext() {
			if (current == null || current.value == null) {
				return false;
			} else {
				return true;
			}
		}

		@Override
		@Creator(name = "Dominic", lastUpdate = "06.12.2012")
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

		@Override
		@Creator(name = "Dominic", lastUpdate = "06.12.2012")
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
