package testing;

import java.util.ArrayList;
import java.util.HashMap;

public class AuthenticationTester implements Tester {
	private static final String moduleName = "Authentication";
	
	// number of successful/failed tests
	private Integer successfulTests;
	private Integer failedTests;
	
	// the test case numbers of all failed tests
	private ArrayList<Integer> failedTestNumbers;
	
	private HashMap<Integer, String> testCaseDescriptions;

	public AuthenticationTester() {
		successfulTests = 0;
		failedTests = 0;
		
		failedTestNumbers = new ArrayList<Integer>();
		testCaseDescriptions = new HashMap<Integer, String>();
	}

	@Override
	public void printTestDescription() {
		System.out.println("Test cases for the " + moduleName + " module: ");
		for(Integer i : testCaseDescriptions.keySet()) {
			System.out.println("#" + i + ": " + testCaseDescriptions.get(i));
		}
	}

	@Override
	public void printTestResults() {
		System.out.println("Test results for the " + moduleName + " module: ");
		System.out.println("Successful tests: " + successfulTests);
		System.out.println("Failed tests: " + failedTests);
		
		if(!failedTestNumbers.isEmpty()) {
			System.out.println("The following test cases have failed: ");
			for(Integer i : failedTestNumbers) {
				System.out.println("#" + i + testCaseDescriptions.get(i));
			}
		}
	}

	@Override
	public void runTests() {
		// TODO Auto-generated method stub
		
	}

}
