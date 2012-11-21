import java.util.ArrayList;
import java.util.Iterator;

/**
 * is used to validate test cases
 * @author OOP Gruppe 187
 *
 */
public class Validator {
	static int successfulTests = 0;
	static int failedTests = 0;
	
	static boolean debug = false;

	static ArrayList<String> failedDesc = new ArrayList<String>();
	static ArrayList<String> allTests = new ArrayList<String>();
	
	static StringBuilder debuggingLog = new StringBuilder();

	/**
	 * reports a test case as successful or failed
	 * @param expected boolean describing the outcome of the test case
	 * @param desc description of the test case
	 */
	static void report(boolean expected, String desc) {

		if(expected) {
			successfulTests++;
		} else {
			failedTests++;
			failedDesc.add(desc);
		}
		
		if(debug) {
			allTests.add(desc);
		}
		
	}
	
	/**
	 * enables debugging output
	 */
	static void enableDebug() {
		debug = true;
	}
	
	/**
	 * disables debugging output
	 */
	static void disableDebug() {
		debug = false;
	}

	/**
	 * prints an overview of all tests cases that have been run thus far
	 */
	static void printOverview() {
		if (debug) {
			System.out.println("Descriptions of the test cases: ");

			for(String s : allTests) {
				System.out.println(s);
			}
			
			System.out.print("\nDebugging log:");
			System.out.println(debuggingLog.toString());
		}
		
		System.out.println("\nNumber of successful tests: " + successfulTests);
		System.out.println("Number of failed tests: " + failedTests);

		if(failedTests > 0) {
			System.out.println("\nThe following test cases failed: ");
			for(String s : failedDesc) {
				System.out.println(s);
			}
		}
		
		
	}

	/**
	 * compares two sets with each other (regarless of order)
	 * @param a set a
	 * @param b set b
	 * @return true if a contains all elements of b and vice-verca
	 */
	static <T> boolean compareTo(Set<T> a, Set<T> b) {
		if(a == null &&  b != null) {
			return false;
		} else if(a != null && b == null) {
			return false;
		}
		
		ArrayList<T> list1 = new ArrayList<T>();
		
		for(T ele : a) {
			list1.add(ele);
		}
		
		int count = 0;
		for(T ele : b) {
			count++;
			if(!list1.contains(ele)) {
				return false;
			}
		}
		
		if(count != list1.size()) {
			return false;
		}
		
		return true;
	}
	
	/**
	 * compares to orderedsets with each other (the order is important!) 
	 * @param a set a
	 * @param b set b
	 * @return true if a is equal to b
	 */
	static <T extends Shorter<? super T>> boolean compareTo(OrderedSet<T> a, OrderedSet<T> b) {
		if(a == null &&  b != null) {
			return false;
		} else if(a != null && b == null) {
			return false;
		}
		
		Iterator<T> it = b.iterator();
		
		for(T ele : a) {
			if(it.next() == ele) {
				
			} else {
				return false;
			}
		}
		
		return true;
	}
}
