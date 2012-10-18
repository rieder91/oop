package testing;

/**
 * @author Thomas
 * 
 */
public interface Tester {
	/**
	 * return a description of all test cases
	 */
	public void getTestDescription();

	/**
	 * returns the number of failed/successful tests; if any tests have failed;
	 * it returns the description of these test cases
	 */
	public void getTestResults();
	
	/**
	 * runs all test cases that were specified
	 */
	public void runTests();
}
