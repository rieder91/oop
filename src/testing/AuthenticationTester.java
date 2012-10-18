package testing;

import java.util.ArrayList;

public class AuthenticationTester implements Tester {
	// number of successful/failed tests
	private Integer successfulTests;
	private Integer failedTests;
	
	// the test case numbers of all failed tests
	private ArrayList<Integer> failedTestNumbers;

	public AuthenticationTester() {
		successfulTests = 0;
		failedTests = 0;
		
		failedTestNumbers = new ArrayList<Integer>();
	}

	@Override
	public void printTestDescription() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void printTestResults() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void runTests() {
		// TODO Auto-generated method stub
		
	}

}
