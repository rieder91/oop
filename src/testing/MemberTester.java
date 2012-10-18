package testing;

import java.util.ArrayList;
import java.util.HashMap;

public class MemberTester implements Tester {
	private static final String moduleName = "Member";

	// number of successful/failed tests
	private Integer successfulTests;
	private Integer failedTests;

	// the test case numbers of all failed tests
	private ArrayList<Integer> failedTestNumbers;

	private HashMap<Integer, String> testCases;

	public MemberTester() {
		successfulTests = 0;
		failedTests = 0;

		failedTestNumbers = new ArrayList<Integer>();
		testCases = new HashMap<Integer, String>();
	}

	@Override
	public void printTestDescription() {
		System.out.println("Test cases for the " + moduleName + " module: ");
		for (Integer i : testCases.keySet()) {
			System.out.println("#" + ((i < 10) ? "0" + i : i) + ": " + testCases.get(i));
		}
		System.out.println();
	}

	@Override
	public void printTestResults() {
		System.out.println("Test results for the " + moduleName + " module: ");
		System.out.println("Successful tests: " + successfulTests);
		System.out.println("Failed tests: " + failedTests);

		if (!failedTestNumbers.isEmpty()) {
			System.out.println("The following test cases have failed: ");
			for (Integer i : failedTestNumbers) {
				System.out.println("#" + i + " " + testCases.get(i));
			}
		}
		System.out.println();
	}
	
	/*
	 * deprecation suppression is only used to ignore the warning of the methods we declared 
	 * deprecated ourselves due to the enhancements made in assignment #2
	 * 
	 * (non-Javadoc)
	 * @see testing.Tester#runTests()
	 */
//	@SuppressWarnings("deprecation")
	@Override
	public void runTests() {
		// TODO Implement tests for Ersatzmitglieder, Member-dependand repertoire

	}

}
