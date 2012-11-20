import java.util.Iterator;

/**
 * contains all tests cases for the OrderedSet and its Iterators
 * @author OOP Gruppe 187
 *
 */
public class OrderedSetTester implements Tester {
	public void runTests() {
		OrderedSet<Description> os1 = new OrderedSet<Description>();
		Iterator<Description> it = (SetIterator<Description>) os1.iterator();
		
		
		
		System.out.println("i am run");
		
		it.next();
		it.next();

	}
}
