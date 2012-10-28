
package testing;

/**
 * testing-interfaces which all tester-classes implement; each tester-class runs the testcases to verify the use-cases
 * of another class
 * 
 * @author OOP Gruppe 187
 */
public interface Tester {

	/*
	 * BAD: there is a history constraint that printTestResults() has to be called
	 * AFTER runTests(); this constraint is not checked; it is also not checked
	 * if runTests() is called more than once
	 * 
	 * 
	 * NOTE: it is debatable why this class was implemented as an interface;
	 * 		 if it were realized with an abstract class there would be less duplicate 
	 * 		 code in it's children but there would also be less flexibility to implement
	 *   	 test-modules which require a different approach than the successful/failed
	 *   	 approach; one example would be test cases that do not return boolean but
	 *   	 the efficiency of a given algorithm as float
	 */
	
	/**
	 * return a description of all test cases
	 * PRECONDITION: the class knows of all test-cases that are being tested
	 */
	public void printTestDescription();

	/**
	 * prints the number of failed/successful tests; if any tests have failed; it prints the description of these test
	 * cases
	 * PRECONDITION: runTests() has been invoked
	 */
	public void printTestResults();

	/**
	 * runs all test cases that were specified
	 * PRECONDTITION: runTests() has not been called before
	 * PRECONDTITION: the counter of successful tests is 0
	 * PRECONDTITION: all test cases referenced in this method are known to the class
	 * POSTCONDITION: sum of failed and successful tests will never be greater than the total amount
	 */
	public void runTests();

}
