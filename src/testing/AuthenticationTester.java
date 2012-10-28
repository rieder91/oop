
package testing;

import helper.InsufficientPermissionsException;
import helper.InvalidBandObjectException;
import helper.InvalidDateException;
import helper.Validator;

import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import auth.Authenticatable.Permission;
import auth.Authenticator;
import band.Band;
import band.Gig;
import band.Member;

/**
 * testing class for the authentication requirements
 * 
 * 
 * NOTE: this class inherits all pre- and postconditions the interface Tester has
 * 
 * GOOD: there are no additional pre- or postconditions in any of the methods inherited
 * 		 from the interface
 * 
 * BAD: duplicate code common to all other Tester-classes in the print()-methods
 * 
 * @author OOP Gruppe 187
 */
public class AuthenticationTester implements Tester {

	private static final String moduleName = "Authentication";

	// NOTE: number of successful/failed tests
	private Integer successfulTests;
	private Integer overallTests;

	// NOTE: the test case numbers of all failed tests
	private ArrayList<Integer> failedTestNumbers;

	private HashMap<Integer, String> testCases;

	/*
	 * POSTCONDITION: all test cases which are references in runTests() have been
	 * 				  added to testCases
	 * POSTCONDITION: the number of successfulTests is set to 0
	 * POSTCONDITION: the Validator-class knows the total number of test cases in this
	 * 				  module
	 */
	public AuthenticationTester() {

		this.successfulTests = 0;

		this.failedTestNumbers = new ArrayList<Integer>();
		this.testCases = new HashMap<Integer, String>();

		this.testCases.put(1, "Every Authenticatable must be its own OWNER");
		this.testCases.put(2, "The roles of each Auth. to each other can be changed");
		this.testCases.put(3, "Once permissions have been granted, they can be removed again");
		this.testCases.put(4, "Objects whose permissions have not been set are denied access");
		this.testCases.put(5, "A method cannot be invoked without permissions");
		this.testCases.put(6, "After the permissions where granted, the method can be invoked");
		this.testCases.put(7, "Once the members join a band their permissions to each other are set to GROUP");
		this.testCases.put(8, "Once the members leave a band their permissions to each other are set to NONE");
		this.testCases.put(9,
				"Once the members join a band their permission to all of the band's events are set to GROUP");
		this.testCases.put(10,
				"Once the members leave a band their permission to all of the band's events are set to NONE");
		this.testCases.put(11, "A band member can only invoke a method of it's own band");
		this.testCases.put(12, "Everyone has the permission to get the band's members");

		this.overallTests = this.testCases.size();
		Validator.addTests(this.overallTests);
	}

	@Override
	public void printTestDescription() {

		System.out.println("Test cases for the " + moduleName + " module: ");
		for (Integer i : this.testCases.keySet()) {
			System.out.println("#" + (i < 10 ? "0" + i : i) + ": " + this.testCases.get(i));
		}
		System.out.println();
	}

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

	/*
	 * NOTE: deprecation suppression is only used to ignore the warning of the methods we declared deprecated ourselves due to
	 * the enhancements made in assignment #2
	 * 
	 * (non-Javadoc)
	 * 
	 * @see testing.Tester#runTests()
	 * 
	 * 
	 * 
	 * NOTE: as this class it meant to check all existing contracts of the class it's meant
	 * 		 to test, there are no further details on the pre- and post-conditions provided
	 * 		 here; these are explained in the respective classes themselves
	 */
	@SuppressWarnings("deprecation")
	@Override
	public void runTests() {

		SimpleDateFormat formatDate = new SimpleDateFormat("dd.MM.yyyy");

		Member thomas = new Member("Thomas", "Rieder", "Guitar", "123456", false);
		Member markus = new Member("Markus", "Zisser", "Bass", "532423", true);
		Member dominic = new Member("Dominic", "Riedl", "Keyboard", "389235", true);

		Band tempBand = new Band("/tmp", "Math Rock");
		Band anotherBand = new Band("/bin", "Progressive Metal");

		Gig tempGig = null;
		try {
			tempGig = new Gig(formatDate.parse("10.10.2010"), "Wien", 10, new BigDecimal(500));
		}
		catch (ParseException e1) {
			e1.printStackTrace();
		}

		try {
			tempBand.addEvent(tempGig);
		}
		catch (InvalidBandObjectException e1) {
			e1.printStackTrace();
		}

		Method isSubstituteMemberMethod = null, bandAddMember = null, bandGetMembers = null;
		Class<?> isSubstituteMemberArgs[] = new Class<?>[] {
				Member.class, Date.class};
		Class<?> emptyArgs[] = new Class<?>[0];
		
		try {
			isSubstituteMemberMethod = Member.class.getMethod("isSubstituteMember", emptyArgs);
			bandAddMember = Band.class.getMethod("addMember", isSubstituteMemberArgs);
			bandGetMembers = Band.class.getMethod("getMembers", emptyArgs);
		}
		catch (SecurityException e) {
			e.printStackTrace();
		}
		catch (NoSuchMethodException e) {
			e.printStackTrace();
		}

		if (Validator.check(Permission.OWNER, thomas.getRole(thomas), 1)) {
			this.successfulTests++;
		}
		else {
			this.failedTestNumbers.add(1);
		}

		thomas.setRole(markus, Permission.GROUP);
		if (Validator.check(Permission.GROUP, thomas.getRole(markus), 2)) {
			this.successfulTests++;
		}
		else {
			this.failedTestNumbers.add(2);
		}

		thomas.setRole(markus, Permission.NONE);
		if (Validator.check(Permission.NONE, thomas.getRole(markus), 3)) {
			this.successfulTests++;
		}
		else {
			this.failedTestNumbers.add(3);
		}

		if (Validator.check(Permission.NONE, thomas.getRole(dominic), 4)) {
			this.successfulTests++;
		}
		else {
			this.failedTestNumbers.add(4);
		}

		try {
			Authenticator.checkPermissions(markus, thomas, isSubstituteMemberMethod);
			this.failedTestNumbers.add(5);
		}
		catch (InsufficientPermissionsException e) {
			this.successfulTests++;
			Validator.report(true);
		}

		thomas.setRole(markus, Permission.GROUP);
		try {
			Authenticator.checkPermissions(markus, thomas, isSubstituteMemberMethod);
			this.successfulTests++;
			Validator.report(true);
		}
		catch (InsufficientPermissionsException e) {
			this.failedTestNumbers.add(6);
		}

		try {
			tempBand.addMember(thomas, formatDate.parse("01.01.2010"));
			tempBand.addMember(markus, formatDate.parse("01.01.2010"));
			tempBand.addMember(dominic, formatDate.parse("01.01.2010"));
		}
		catch (InvalidDateException e) {
			e.printStackTrace();
		}
		catch (InvalidBandObjectException e) {
			e.printStackTrace();
		}
		catch (ParseException e) {
			e.printStackTrace();
		}

		if (Validator.check(Permission.GROUP, thomas.getRole(dominic), 7)) {
			this.successfulTests++;
		}
		else {
			this.failedTestNumbers.add(7);
		}

		try {
			tempBand.removeMember(dominic, formatDate.parse("01.01.2011"));
		}
		catch (InvalidDateException e) {
			e.printStackTrace();
		}
		catch (InvalidBandObjectException e) {
			e.printStackTrace();
		}
		catch (ParseException e) {
			e.printStackTrace();
		}

		if (Validator.check(Permission.NONE, thomas.getRole(dominic), 8)) {
			this.successfulTests++;
		}
		else {
			this.failedTestNumbers.add(8);
		}

		Gig t = (Gig) tempBand.getEvents().get(0);

		if (Validator.check(Permission.GROUP, t.getRole(thomas), 9)) {
			this.successfulTests++;
		}
		else {
			this.failedTestNumbers.add(9);
		}

		if (Validator.check(Permission.NONE, t.getRole(dominic), 10)) {
			this.successfulTests++;
		}
		else {
			this.failedTestNumbers.add(10);
		}

		try {
			Authenticator.checkPermissions(thomas, anotherBand, bandAddMember);
			this.failedTestNumbers.add(11);
		}
		catch (InsufficientPermissionsException e) {
			this.successfulTests++;
			Validator.report(true);

		}

		try {
			Authenticator.checkPermissions(dominic, tempBand, bandGetMembers);
			this.successfulTests++;
			Validator.report(true);
		}
		catch (InsufficientPermissionsException e) {
			this.failedTestNumbers.add(12);
		}

	}

}
