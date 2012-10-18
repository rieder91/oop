package testing;

import helper.Validator;

import java.util.ArrayList;
import java.util.HashMap;

import band.Infrastructure;
import band.Place;

public class PlaceTester implements Tester {
	private static final String moduleName = "Place";

	// number of successful/failed tests
	private Integer successfulTests;
	private Integer failedTests;

	// the test case numbers of all failed tests
	private ArrayList<Integer> failedTestNumbers;

	private HashMap<Integer, String> testCases;

	public PlaceTester() {
		successfulTests = 0;
		failedTests = 0;

		failedTestNumbers = new ArrayList<Integer>();
		testCases = new HashMap<Integer, String>();
		
		testCases.put(1, "Add an infrastructure to a place");
		testCases.put(2, "Remove an existing infrastructure");
		testCases.put(3, "Perform a require-infrastructure check");
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
		// TODO Auto-generated method stub
		
		Place stadtHalle = new Place("Stadthalle");
		stadtHalle.addInfrastructure(Infrastructure.Toilet);
		stadtHalle.addInfrastructure(Infrastructure.PublicTransport);
		stadtHalle.addInfrastructure(Infrastructure.ParkingGarage);
		
		ArrayList<Infrastructure> someInf = new ArrayList<Infrastructure>();
		someInf.add(Infrastructure.PublicTransport);
		someInf.add(Infrastructure.Toilet);
		
		if(stadtHalle.hasInfrastructure(Infrastructure.Toilet)) {
			successfulTests++;
			Validator.report(true);
		} else {
			failedTests++;
			failedTestNumbers.add(1);
			Validator.report(false);
		}
		
		// parking garage caved in
		stadtHalle.removeInfrastructure(Infrastructure.ParkingGarage);
		
		if(!stadtHalle.hasInfrastructure(Infrastructure.ParkingGarage)) {
			successfulTests++;
			Validator.report(true);
		} else {
			failedTests++;
			failedTestNumbers.add(2);
			Validator.report(false);
		}
		
		
		if(Validator.check(someInf, stadtHalle.getInfrastructure(), 3)) {
			successfulTests++;
		} else {
			failedTests++;
			failedTestNumbers.add(1);
		}
	}

}
