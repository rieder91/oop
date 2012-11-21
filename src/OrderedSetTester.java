import java.util.Iterator;

/**
 * contains all tests cases for the OrderedSet and its Iterators
 * @author OOP Gruppe 187
 *
 */
public class OrderedSetTester implements Tester {
	public void runTests() {
		OrderedSet<Description> os1 = new OrderedSet<Description>();
		OrderedSet<Description> os2 = new OrderedSet<Description>();
		Iterator<Description> it = os2.iterator();
		
		Description first = new Description("A");
		Description second = new Description("BB");
		Description third = new Description("CCC");
		Description fourth = new Description("DDDD");
		
		os1.insert(first);
		os1.insert(second);
		os1.insert(third);
		os1.insert(fourth);
		
		os2.insert(fourth);
		os2.insert(third);
		os2.insert(second);
		os2.insert(first);
		
		Validator.report(Validator.compareTo(os1, os2) == true, "OrderedSetTester: check that the sets are actually sorted");
		
		os1 = new OrderedSet<Description>();
		os1.insert(first);
		if(os1.insert(first) == false) {
			Validator.report(true, "OrderedSetTester: check that the same element cant be added twice");
		} else {
			Validator.report(false, "OrderedSetTester: check that the same element cant be added twice");
		}
		
		try {
			it.remove();
			Validator.report(false, "OrderedSetTester: try to call remove before next() was called");
		} catch (RuntimeException e) {
			Validator.report(true, "OrderedSetTester: try to call remove before next() was called");
		}
		
		
		it.next();
		it.remove();
		
		os1 = new OrderedSet<Description>();
		os1.insert(second);
		os1.insert(third);
		os1.insert(fourth);
		
		Validator.report(Validator.compareTo(os1, os2) == true, "OrderedSetTester: remove the first element");
		
		os1 = new OrderedSet<Description>();
		os1.insert(first);
		os1.insert(second);
		os1.insert(fourth);
		
		os2 = new OrderedSet<Description>();
		os2.insert(first);
		os2.insert(second);
		os2.insert(third);
		os2.insert(fourth);
		
		it = os2.iterator();
		it.next();
		it.next();
		it.next();
		it.remove();
		
		Validator.report(Validator.compareTo(os1, os2) == true, "OrderedSetTester: remove an element in the middle");
		
		
		os1 = new OrderedSet<Description>();
		os1.insert(first);
		os1.insert(second);
		os1.insert(third);
		
		os2 = new OrderedSet<Description>();
		os2.insert(first);
		os2.insert(second);
		os2.insert(third);
		os2.insert(fourth);
		
		it = os2.iterator();
		while(it.hasNext()) {
			it.next();
		}
		
		it.remove();
		
		Validator.report(Validator.compareTo(os1, os2) == true, "OrderedSetTester: remove the last element");
	}
}
