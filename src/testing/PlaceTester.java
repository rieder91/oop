
package testing;

import helper.Validator;
import java.util.ArrayList;
import java.util.HashMap;
import band.Infrastructure;
import band.Place;
import band.PlaceManager;

/**
 * test-class for place-requirements
 * 
 * @author OOP Gruppe 187
 */
public class PlaceTester implements Tester {

	private static final String moduleName = "Place";

	private Integer successfulTests;
	private Integer overallTests;
	//successfulTests >= 0; overallTests >= 0

	private ArrayList<Integer> failedTestNumbers;

	private HashMap<Integer, String> testCases;

	
	public PlaceTester() {

		this.successfulTests = 0;

		this.failedTestNumbers = new ArrayList<Integer>();
		this.testCases = new HashMap<Integer, String>();

		this.testCases.put(1, "Add an infrastructure to a place");
		this.testCases.put(2, "Remove an existing infrastructure");
		this.testCases.put(3, "Perform a require-infrastructure check");
		this.testCases.put(4, "Get all places which have the required-infrastructure");
		this.testCases.put(5, "Try to get a place with too much requirements");

		this.overallTests = this.testCases.size();
		Validator.addTests(this.overallTests);
	}

	/**
	 * a description of the place test module is displayed
	 * should be the first method to be called
	 */
	@Override
	public void printTestDescription() {

		System.out.println("Test cases for the " + moduleName + " module: ");
		for (Integer i : this.testCases.keySet()) {
			System.out.println("#" + (i < 10 ? "0" + i : i) + ": " + this.testCases.get(i));
		}
		System.out.println();
	}

	/**
	 * the results of the place test module is displayed
	 * must be called after method runTests()
	 */
	@Override
	public void printTestResults() {

		System.out.println("Test results for the " + moduleName + " module: ");
		System.out.println("Successful tests: " + this.successfulTests);
		System.out.println("Failed tests: " + (this.overallTests - this.successfulTests));

		if (!this.failedTestNumbers.isEmpty()) {
			System.out.println("The following test cases have failed: ");
			for (Integer i : this.failedTestNumbers) {
				System.out.println("#" + i + " " + this.testCases.get(i));
			}
		}
		System.out.println();
	}

	/**
	 * run through various test cases of the place module
	 * must be called before method printTestResults()
	 */
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

		if (stadtHalle.hasInfrastructure(Infrastructure.Toilet)) {
			this.successfulTests++;
			Validator.report(true);
		}
		else {
			this.failedTestNumbers.add(1);
			Validator.report(false);
		}

		stadtHalle.removeInfrastructure(Infrastructure.ParkingGarage);

		if (!stadtHalle.hasInfrastructure(Infrastructure.ParkingGarage)) {
			this.successfulTests++;
			Validator.report(true);
		}
		else {
			this.failedTestNumbers.add(2);
			Validator.report(false);
		}

		if (Validator.check(someInf, stadtHalle.getInfrastructure(), 3)) {
			this.successfulTests++;
		}
		else {
			this.failedTestNumbers.add(3);
		}

		if (Validator.check(places.getPlacesByFilter(testReq1), testReq1Result, 4)) {
			this.successfulTests++;
		}
		else {
			this.failedTestNumbers.add(4);
		}

		if (Validator.check(places.getPlacesByFilter(testReq2), new ArrayList<Place>(), 5)) {
			this.successfulTests++;
		}
		else {
			this.failedTestNumbers.add(5);
		}
	}

}
