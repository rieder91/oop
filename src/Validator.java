import java.util.ArrayList;
import java.util.Iterator;


public class Validator {
	static int successfulTests = 0;
	static int failedTests = 0;
	
	static boolean debug = false;

	static ArrayList<String> failedDesc = new ArrayList<String>();
	static ArrayList<String> allTests = new ArrayList<String>();

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
	
	static void enableDebug() {
		debug = true;
	}
	
	static void disableDebug() {
		debug = false;
	}

	static void printOverview() {
		System.out.println("Descriptions of the test cases: ");
		for(String s : allTests) {
			System.out.println(s);
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
