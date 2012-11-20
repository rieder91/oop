import java.util.Iterator;


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
		
		
		Validator.report(Validator.compareTo(eq1, eq2) == true, "check if two sets are equal regardless of the order");
		
		eq2 = new Set<String>();
		eq2.insert("Dominic");
		eq2.insert("Markus");
		
		Validator.report(Validator.compareTo(eq1, eq2) == false, "check if equals also returns false");
		
		eq2 = new Set<String>();
		Iterator<String> itEq = eq2.iterator();
		if(itEq.hasNext()) {
			Validator.report(false, "check if set iterators return false if set is empty");
		} else {
			Validator.report(true, "check if set iterators return false if set is empty");
		}
		
		eq2.insert("Thomas");
		eq2.insert("Patrick");
		itEq = eq2.iterator();
		
		Validator.report("Thomas".equals(itEq.next()), "use the iterator to get the 1st element");
		
		Validator.report("Patrick".equals(itEq.next()), "use the iterator to get the last element");
		
		Validator.report(!"".equals(itEq.next()), "use the iterator to get a non existant element");
		
		itEq = eq1.iterator();
		
		try {
			itEq.remove();
			Validator.report(false, "attempt to remove an element prior to calling next()");
		} catch (RuntimeException e) {
			Validator.report(true, "attempt to remove an element prior to calling next()");
		}
		
		eq2 = new Set<String>();
		eq2.insert("Dominic");
		eq2.insert("Markus");
		
		itEq.next();
		itEq.remove();
		
		Validator.report(Validator.compareTo(eq1, eq2) == true, "remove the first element");
		
		eq2 = new Set<String>();
		eq2.insert("Thomas");
		eq2.insert("Markus");
		
		eq1.insert("Thomas");
		
		itEq = eq1.iterator();
		itEq.next();
		itEq.next();
		itEq.remove();
		
		Validator.report(Validator.compareTo(eq1, eq2) == true, "remove an element in the \"middle\" of the set");
		
		eq2 = new Set<String>();
		eq2.insert("Thomas");
		eq2.insert("Markus");
		
		eq1.insert("Dominic");

		itEq = eq1.iterator();
		while(itEq.hasNext()) {
			itEq.next();
		}
		itEq.remove();
		
		Validator.report(Validator.compareTo(eq2, eq1) == true, "remove the last element of a set via iterator");
		
	}
}
