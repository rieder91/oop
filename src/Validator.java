import java.util.ArrayList;


public class Validator {
	static int successfulTests = 0;
	static int failedTests = 0;

	static ArrayList<String> failedDesc = new ArrayList<String>();

	static void report(boolean expected, String desc) {

		if(expected) {
			successfulTests++;
		} else {
			failedTests++;
			failedDesc.add(desc);
		}
		
	}

	static void printOverview() {
		System.out.println("Number of successful tests: " + successfulTests);
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
}