/**
 * our own iterator-class as Iterator requires a type
 * 
 * @author Dominic
 * 
 */
@Creator(name = "Dominic", lastUpdate = "08.12.2012")
public interface MyIterator {

	/**
	 * @return true if there is a next element
	 */
	@Creator(name = "Dominic", lastUpdate = "08.12.2012")
	public boolean hasNext();

	/**
	 * removes the element which was last returned by next()
	 */
	@Creator(name = "Dominic", lastUpdate = "08.12.2012")
	public void remove();

	/**
	 * returns the next element in the list - if there is one
	 * 
	 * @return next element
	 */
	@Creator(name = "Dominic", lastUpdate = "08.12.2012")
	public Object next();
}
