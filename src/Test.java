import helper.Validator;
import java.util.ArrayList;
import testing.AuthenticationTester;
import testing.BandTester;
import testing.EventTester;
import testing.FinanceTester;
import testing.MemberTester;
import testing.PlaceTester;
import testing.Tester;

/**
 * Class which runs several test cases for the program's core and validates the results
 * 
 * @author OOP Gruppe 187
 */

public class Test {

	/**
	 * Test class for assignment1
	 * 
	 * @param args
	 *            command line arguments
	 */
	public static void main(String[] args) {

		boolean verbose = false;
		
		/*
		 * GOOD: dynamic binding makes the testing of new modules relatively easy
		 * 		 and helps keep the main-class clean
		 */
		
		ArrayList<Tester> testedModules = new ArrayList<Tester>();
		testedModules.add(new AuthenticationTester());
		testedModules.add(new BandTester());
		testedModules.add(new MemberTester());
		testedModules.add(new PlaceTester());
		testedModules.add(new EventTester());
		testedModules.add(new FinanceTester());

		for (Tester t : testedModules) {
			if (verbose) {
				t.printTestDescription();
			}
			/*
			 * BAD: there is a unchecked history-constraint in each Tester:
			 * 		if printTestResults() is executed before runTests() all tests
			 * 	  	of the module are considered failed; also runTests() mustn't be
			 * 		executed twice
			 */
			t.runTests();
			t.printTestResults();
		}

		/*
		 * BAD: in the same way that there is an unchecked history-constraint in each
		 *      class that implements the Tester-interface - Validator.report 
		 *      has to be called after each Testing-module was run otherwise it will
		 *      consider all tests failed
		 */
		Validator.report();
	}
}
