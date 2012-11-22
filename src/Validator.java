import java.util.ArrayList;

/**
 * validator class only used to verify test cases
 * @author Thomas
 *
 */
public class Validator {
	private static Integer successfulTests = 0;
	private static Integer failedTests = 0;
	
	private static ArrayList<String> allTests = new ArrayList<String>();
	private static ArrayList<String> failTests = new ArrayList<String>();
	
	private static boolean debug = false;
	
	private Validator() { }
	
	public static void enableDebug() {
		debug = true;
	}
	
	public static void disableDebug() {
		debug = false;
	}
	
	public static void report(boolean result, String testCaseDescription) {
		allTests.add(testCaseDescription);
		
		if(result) {
			successfulTests++;
		} else {
			failedTests++;
			failTests.add(testCaseDescription);
		}
	}
	
	public static void printOverview() {
		if(debug) {
			System.out.println("These test cases were run: ");
			for(String s : allTests) {
				System.out.println(s);
			}
		}
		
		if(failedTests > 0) {
			System.out.println("\nThe following test cases failed: ");
			for(String s : failTests) {
				System.out.println(s);
			}
		}
		
		
		System.out.println("\nNumber of successful tests: " + successfulTests);
		System.out.println("Number of failed tests: " + failedTests);
	}
	
}
