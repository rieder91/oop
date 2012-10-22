
package testing;

/**
 * testing-interfaces which all tester-classes implement; each tester-class runs the testcases to verify the use-cases
 * of another class
 * 
 * @author OOP Gruppe 187
 */
public interface Tester {

	/**
	 * return a description of all test cases
	 */
	public void printTestDescription();

	/**
	 * prints the number of failed/successful tests; if any tests have failed; it prints the description of these test
	 * cases
	 */
	public void printTestResults();

	/**
	 * runs all test cases that were specified
	 */
	public void runTests();

}
