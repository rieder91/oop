import java.util.Iterator;

/**
 * test class for the set and the setiterator
 * @author OOP Gruppe 187
 *
 */
public class SetTester implements Tester {
	
	public void runTests() {
		Set<String> eq1 = new Set<String>();
		Set<String> eq2 = new Set<String>();
		eq1.insert("Thomas");
		eq1.insert("Markus");
		eq1.insert("Dominic");
		
		eq2.insert("Thomas");
		eq2.insert("Dominic");
		eq2.insert("Markus");
		
		
		Validator.report(Validator.compareTo(eq1, eq2) == true, "SetTester: check if two sets are equal regardless of the order");
		
		eq2 = new Set<String>();
		eq2.insert("Dominic");
		eq2.insert("Markus");
		
		Validator.report(Validator.compareTo(eq1, eq2) == false, "SetTester: check if equals also returns false");
		
		eq2 = new Set<String>();
		Iterator<String> itEq = eq2.iterator();
		if(itEq.hasNext()) {
			Validator.report(false, "SetTester: check if set iterators return false if set is empty");
		} else {
			Validator.report(true, "SetTester: check if set iterators return false if set is empty");
		}
		
		eq2.insert("Thomas");
		eq2.insert("Patrick");
		itEq = eq2.iterator();
		
		Validator.report("Thomas".equals(itEq.next()), "SetTester: use the iterator to get the 1st element");
		
		Validator.report("Patrick".equals(itEq.next()), "SetTester: use the iterator to get the last element");
		
		Validator.report(!"".equals(itEq.next()), "SetTester: use the iterator to get a non existant element");
		
		itEq = eq1.iterator();
		
		try {
			itEq.remove();
			Validator.report(false, "SetTester: attempt to remove an element prior to calling next()");
		} catch (RuntimeException e) {
			Validator.report(true, "SetTester: attempt to remove an element prior to calling next()");
		}
		
		eq2 = new Set<String>();
		eq2.insert("Dominic");
		eq2.insert("Markus");
		
		itEq.next();
		itEq.remove();
		
		Validator.report(Validator.compareTo(eq1, eq2) == true, "SetTester: remove the first element");
		
		eq2 = new Set<String>();
		eq2.insert("Thomas");
		eq2.insert("Markus");
		
		eq1.insert("Thomas");
		
		itEq = eq1.iterator();
		itEq.next();
		itEq.next();
		itEq.remove();
		
		Validator.report(Validator.compareTo(eq1, eq2) == true, "SetTester: remove an element in the \"middle\" of the set");
		
		eq2 = new Set<String>();
		eq2.insert("Thomas");
		eq2.insert("Markus");
		
		eq1.insert("Dominic");

		itEq = eq1.iterator();
		while(itEq.hasNext()) {
			itEq.next();
		}
		itEq.remove();
		
		Validator.report(Validator.compareTo(eq2, eq1) == true, "SetTester: remove the last element of a set via iterator");
		
	}
}
