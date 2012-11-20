
/**
 * contains all test cases for the OrderedMap and its Iterators
 * @author OOP Gruppe 187
 *
 */
public class OrderedMapTester implements Tester {
	
	public void runTests() {
		// TODO Auto-generated method stub
		OrderedMap<Description, String> om = new OrderedMap<Description, String>();
		OrderedMap<Description, String> omCheck = new OrderedMap<Description, String>();
		
		Description first = new Description("A");
		Description second = new Description("BB");
		Description third = new Description("CCC");
		Description fourth = new Description("DDDD");
		
		String name1 = "Thomas";
		String name2 = "Markus";
		String name3 = "Dominic";
		String name4 = "Manuel";
		String name5 = "Patrick";
		String name6 = "Lisa";
		
		om.insert(first);
		
		if(om.insert(first) == false) {
			Validator.report(true, "check that the same value can't be added twice");
		} else {
			Validator.report(false, "check that the same value can't be added twice");
		}
		
		om.insert(third);
		om.insert(fourth);
		om.insert(second);
		
		omCheck.insert(first);
		omCheck.insert(second);
		omCheck.insert(third); 
		omCheck.insert(fourth); 
		
		Validator.report(Validator.compareTo(om, omCheck) == true, "check that the map is actually ordered");
		
		
		om = new OrderedMap<Description, String>();
		om.insert(first);
		om.insert(second);
		om.insert(third); 
		om.insert(fourth); 
		
		MapIterator<Description, String> it = om.iterator();
		
		try {
			it.remove();
			Validator.report(false, "check that remove can't be called before next");
		} catch(RuntimeException e) {
			Validator.report(true, "check that remove can't be called before next");
		}
		
		
		Validator.report(it.next() == first, "check that the iterators returns the first element successfully");
		it.next();
		Validator.report(it.next() == third, "check that the iterators returns an element in the middle successfully");
		Validator.report(it.next() == fourth, "check that the iterators returns the last element");
		
		Validator.report(it.hasNext() == false, "check that the iterator doesn't report anymore elements if it shouldn't");
		
		/**************/
		
		it = om.iterator();
		it.next();
		it.remove();
		
		omCheck = new OrderedMap<Description, String>();
		omCheck.insert(second);
		omCheck.insert(third); 
		omCheck.insert(fourth); 
		
		Validator.report(Validator.compareTo(om, omCheck), "remove the first element of an OrderedMap");
		
		/**************/
		
		om = new OrderedMap<Description, String>();
		om.insert(first);
		om.insert(second);
		om.insert(third); 
		om.insert(fourth); 
		
		it = om.iterator();
		it.next();
		it.next();
		it.next();
		it.remove();
		
		omCheck = new OrderedMap<Description, String>();
		omCheck.insert(first);
		omCheck.insert(second);
		omCheck.insert(fourth); 
		
		Validator.report(Validator.compareTo(om, omCheck), "remove an element in the middle of an OrderedMap");
		
		/**************/
		
		om = new OrderedMap<Description, String>();
		om.insert(first);
		om.insert(second);
		om.insert(third); 
		om.insert(fourth); 
		
		it = om.iterator();
		while(it.hasNext()) {
			it.next();
		}
		it.remove();
		
		omCheck = new OrderedMap<Description, String>();
		omCheck.insert(first);
		omCheck.insert(second);
		omCheck.insert(third); 
		
		Validator.report(Validator.compareTo(om, omCheck), "remove the last element of an OrderedMap");
		
		/**************/
		
		om = new OrderedMap<Description, String>();
		om.insert(first);
		om.insert(second);
		om.insert(third); 
		om.insert(fourth); 
		
		om.addValueToKey(first, name1);
		om.addValueToKey(first, name2);
		om.addValueToKey(first, name5);
		om.addValueToKey(first, name3);
		om.addValueToKey(second, name3);
		om.addValueToKey(third, name4);
		om.addValueToKey(third, name5);
		om.addValueToKey(fourth, name6);
		
		it = om.iterator();
		it.next();
		
		InMapIterator<String> inIt = it.iterator();
		
		Validator.report(inIt.next() == name1, "check if the InMap-Iterators correctly returns first elements");
		Validator.report(inIt.next() == name2, "check if the InMap-Iterators correctly returns an element in the middle");
		inIt.next();
		Validator.report(inIt.next() == name3, "check if the InMap-Iterators correctly returns the last element");
		
		/**************/
		
		om = new OrderedMap<Description, String>();
		om.insert(first);
		om.insert(second);
		om.insert(third); 
		om.insert(fourth); 
		
		om.addValueToKey(first, name1);
		om.addValueToKey(first, name2);
		om.addValueToKey(first, name5);
		om.addValueToKey(second, name3);
		om.addValueToKey(third, name4);
		om.addValueToKey(third, name5);
		om.addValueToKey(fourth, name6);
		
		it = om.iterator();
		it.next();
		
		inIt = it.iterator();
		try {
			inIt.add(name1);
			Validator.report(false, "attempt to call add() prior to next()");
		} catch (RuntimeException e) {
			Validator.report(true, "attempt to call add() prior to next()");
		}
		
		inIt.next();
		inIt.add(name4);
		
		inIt = it.iterator();
		Validator.report(inIt.next() == name4, "add a new first value in a subset of a map");
		inIt.remove();
		Validator.report(inIt.next() == name1, "remove the first value in a subset of a map");
		
		inIt = it.iterator();
		
		// Thomas -> Markus -> Patrick; nach Markus einfuegen
		inIt.next();
		inIt.next();
		inIt.add(name4);
		Validator.report(inIt.next() == name4, "add a value in the middle of a subset of a map");
		
		
		inIt = it.iterator();
		while(inIt.hasNext()) {
			inIt.next();
		}
		
		inIt.add(name6);
		Validator.report(inIt.next() == name6, "add a value at the end of a subset of a map");
	}
}
