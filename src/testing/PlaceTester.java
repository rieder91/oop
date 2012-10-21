package testing;

import helper.Validator;

import java.util.ArrayList;
import java.util.HashMap;

import band.Infrastructure;
import band.Place;
import band.PlaceManager;

/**
 * 
 * @author Thomas
 *
 */
public class PlaceTester implements Tester {
	private static final String moduleName = "Place";

	// number of successful/failed tests
	private Integer successfulTests;
	private Integer overallTests;

	// the test case numbers of all failed tests
	private ArrayList<Integer> failedTestNumbers;

	private HashMap<Integer, String> testCases;

	/**
	 * 
	 */
	public PlaceTester() {
		successfulTests = 0;

		failedTestNumbers = new ArrayList<Integer>();
		testCases = new HashMap<Integer, String>();
		
		testCases.put(1, "Add an infrastructure to a place");
		testCases.put(2, "Remove an existing infrastructure");
		testCases.put(3, "Perform a require-infrastructure check");
		testCases.put(4, "Get all places which have the required-infrastructure");
		testCases.put(5, "Try to get a place with too much requirements");
		
		overallTests = testCases.size();
		Validator.addTests(overallTests);
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
		System.out.println("Failed tests: " + (overallTests - successfulTests));

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
	//@SuppressWarnings("deprecation")
	@Override
	public void runTests() {
		Place stadtHalle = new Place("Stadthalle");
		stadtHalle.addInfrastructure(Infrastructure.Toilet);
		stadtHalle.addInfrastructure(Infrastructure.PublicTransport);
		stadtHalle.addInfrastructure(Infrastructure.ParkingGarage);
		stadtHalle.addInfrastructure(Infrastructure.Stage);
		
		Place oper = new Place("Staatsoper");
		oper.addInfrastructure(Infrastructure.Toilet);
		oper.addInfrastructure(Infrastructure.ParkingGarage);
		oper.addInfrastructure(Infrastructure.PublicTransport);
		oper.addInfrastructure(Infrastructure.Stage);
		
		Place soundStudio = new Place("Sound Studio");
		soundStudio.addInfrastructure(Infrastructure.DemoRoom);
		soundStudio.addInfrastructure(Infrastructure.Toilet);
		
		PlaceManager places = new PlaceManager();
		places.addPlace(stadtHalle);
		places.addPlace(oper);
		places.addPlace(soundStudio);
		
		ArrayList<Place> testReq1Result = new ArrayList<Place>();
		
		testReq1Result.add(stadtHalle);
		testReq1Result.add(oper);
		
		ArrayList<Infrastructure> testReq1 = new ArrayList<Infrastructure>();
		ArrayList<Infrastructure> testReq2 = new ArrayList<Infrastructure>();
		
		testReq1.add(Infrastructure.Toilet);
		testReq1.add(Infrastructure.PublicTransport);
		
		testReq2.add(Infrastructure.DemoRoom);
		testReq2.add(Infrastructure.PublicTransport);
		
		ArrayList<Infrastructure> someInf = new ArrayList<Infrastructure>();
		someInf.add(Infrastructure.PublicTransport);
		someInf.add(Infrastructure.Toilet);
		
		if(stadtHalle.hasInfrastructure(Infrastructure.Toilet)) {
			successfulTests++;
			Validator.report(true);
		} else {
			failedTestNumbers.add(1);
			Validator.report(false);
		}
		
		// parking garage caved in
		stadtHalle.removeInfrastructure(Infrastructure.ParkingGarage);
		
		if(!stadtHalle.hasInfrastructure(Infrastructure.ParkingGarage)) {
			successfulTests++;
			Validator.report(true);
		} else {
			failedTestNumbers.add(2);
			Validator.report(false);
		}
		
		
		if(Validator.check(someInf, stadtHalle.getInfrastructure(), 3)) {
			successfulTests++;
		} else {
			failedTestNumbers.add(3);
		}
		
		if(Validator.check(places.getPlacesByFilter(testReq1), testReq1Result, 4)) {
			successfulTests++;
		} else {
			failedTestNumbers.add(4);
		}
		
		if(Validator.check(places.getPlacesByFilter(testReq2), new ArrayList<Place>(), 5)) {
			successfulTests++;
		} else {
			failedTestNumbers.add(5);
		}
	}

}
