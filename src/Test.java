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
 * Class which runs several test cases for the program's core and validates the
 * results
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
			t.runTests();
			t.printTestResults();
		}

		// Get Overview
		Validator.report();
	}
}
