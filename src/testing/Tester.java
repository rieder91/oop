package testing;

/**
 * @author Thomas
 * 
 */
public interface Tester {
	/**
	 * return a description of all test cases
	 */
	public void printTestDescription();

	/**
	 * prints the number of failed/successful tests; if any tests have failed;
	 * it prints the description of these test cases
	 */
	public void printTestResults();
	
	/**
	 * runs all test cases that were specified
	 */
	public void runTests();
	
}
