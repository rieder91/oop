
package testing;

import helper.InvalidBandObjectException;
import helper.InvalidDateException;
import helper.Validator;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import band.Band;
import band.Event;
import band.Gig;
import band.Member;
import band.Rehearsal;
import band.Track;

/**
 * This class was refactored from the previous Main() test class for band requirements
 * 
 * @author OOP Gruppe 187
 * 
 * 
 * NOTE: this class inherits all pre- and postconditions the interface Tester has
 * 
 * GOOD: there are no additional pre- or postconditions in any of the methods inherited
 * 		 from the interface
 * 
 * BAD: duplicate code common to all other Tester-classes in the print()-methods
 * 
 * 
 */
public class BandTester implements Tester {

	private static final String moduleName = "Band";

	// number of successful/failed tests
	private Integer successfulTests;
	private Integer overallTests;

	// the test case numbers of all failed tests
	private ArrayList<Integer> failedTestNumbers;

	private HashMap<Integer, String> testCases;

	
	/*
	 * POSTCONDITION: all test cases which are references in runTests() have been
	 * 				  added to testCases
	 * POSTCONDITION: the number of successfulTests is set to 0
	 * POSTCONDITION: the Validator-class knows the total number of test cases in this
	 * 				  module
	 */
	public BandTester() {

		this.successfulTests = 0;

		this.failedTestNumbers = new ArrayList<Integer>();
		this.testCases = new HashMap<Integer, String>();

		this.testCases.put(1, "Add several valid members");
		this.testCases.put(2, "Try to remove a member with an invalid date ");
		this.testCases.put(3, "Remove a member with a valid date");
		this.testCases.put(4, "Try to add a member with an invalid date ");
		this.testCases.put(5, "Try to add the same member for the second time");
		this.testCases.put(6, "Get all members before one was removed");
		this.testCases.put(7, "Get all members after one was removed");
		this.testCases.put(8, "Get all members after one was removed and added again");
		this.testCases.put(9, "Try to add a member which already exists ");
		this.testCases.put(10, "Try to remove a member before it joined the band");
		this.testCases.put(11, "Remove a valid member for the second time");
		this.testCases.put(12, "Try to remove a member which doesnt exist");
		this.testCases.put(13, "Add several valid events ");
		this.testCases.put(14, "Try to add an event which already exists");
		this.testCases.put(15, "Try to remove a valid event");
		this.testCases.put(16, "Try to remove an event which doesnt exist");
		this.testCases.put(17, "Try to add an event which was removed before");
		this.testCases.put(18, "Get ALL events");
		this.testCases.put(19, "Get a subset of all events ");
		this.testCases.put(20, "Get the gigs only");
		this.testCases.put(21, "Get the rehearsals only");
		this.testCases.put(22, "Get no events at all; check for handling of empty ArrayList-param");
		this.testCases.put(23, "Get the billing over the entire time period");
		this.testCases.put(24, "Get the billing over the entire time period of gigs only");
		this.testCases.put(25, "Get the billing over the entire time period of rehearsals only");
		this.testCases.put(26, "Get the billing over no events; check for handling of empty ArrayList-param");

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
	 * deprecation suppression is only used to ignore the warning of the methods we declared deprecated ourselves due to
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
	 * 
	 * 
	 */
	@SuppressWarnings("deprecation")
	@Override
	public void runTests() {

		// NOTE: Stuff needed for date parsing
		SimpleDateFormat formatTime = new SimpleDateFormat("dd.MM.yyyy HH:mm");
		SimpleDateFormat formatDate = new SimpleDateFormat("dd.MM.yyyy");

		// NOTE: Create all the necessary members, tracks, events, ...
		Band ultraCoders = new Band("Ultra Coders", "Rock");

		ArrayList<Class<? extends Event>> allTypes = new ArrayList<Class<? extends Event>>();
		allTypes.add(Gig.class);
		allTypes.add(Rehearsal.class);

		ArrayList<Class<? extends Event>> gigsOnly = new ArrayList<Class<? extends Event>>();
		gigsOnly.add(Gig.class);

		ArrayList<Class<? extends Event>> rehearsalOnly = new ArrayList<Class<? extends Event>>();
		rehearsalOnly.add(Rehearsal.class);

		ArrayList<Class<? extends Event>> noTypes = new ArrayList<Class<? extends Event>>();

		Member thomas = new Member("Thomas", "Rieder", "Keyboard", "+436991221", true);
		Member markus = new Member("Markus", "Zisser", "Guitar", "01123123123", true);
		Member dominic = new Member("Dominic", "Riedl", "Drums", "0699123456", true);
		Member jens = new Member("Jens", "Mander", "Violin", "129081091", false);
		Member jane = new Member("Jane", "Doe", "Bass", "203957892035", false);

		Track thunderstruck = new Track("Thunderstruck", 321);
		Track stairway = new Track("Stairway to Heaven", 482);
		Track prayer = new Track("Prayer of the Refugee", 199);
		Track bloodBrothers = new Track("Blood Brothers", 214);
		Track byob = new Track("B.Y.O.B.", 256);
		Track myCurse = new Track("My Curse", 245);

		// NOTE: init variables which throw exceptions
		Gig novarock2010 = null, novarock2011 = null, novarock2012 = null;
		Rehearsal postNova2010 = null, postNova2011 = null;

		try {
			novarock2010 = new Gig(formatTime.parse("11.07.2010 12:00"), "Pannonia Fields II", 72, 2500.0);
			novarock2011 = new Gig(formatTime.parse("11.07.2011 13:00"), "Pannonia Fields II", 72, 5000.0);
			novarock2012 = new Gig(formatTime.parse("08.07.2012 14:00"), "Pannonia Fields II", 72, 10000.0);

			postNova2010 = new Rehearsal(formatTime.parse("15.08.2010 20:00"), "Vienna Sound Studio", 5, 100.0);
			postNova2011 = new Rehearsal(formatTime.parse("15.08.2011 20:00"), "Vienna Sound Studio Mk II", 7, 1000.0);
		}
		catch (ParseException e) {
			System.out.println("Date parsing failed");
		}

		// NOTE: used in cases: 13, 19, 20, 23
		ArrayList<Track> allTracks = new ArrayList<Track>();
		allTracks.add(thunderstruck);
		allTracks.add(stairway);
		allTracks.add(prayer);
		allTracks.add(bloodBrothers);
		allTracks.add(byob);
		allTracks.add(myCurse);

		// NOTE: used in cases: 16, 22
		ArrayList<Track> tracksNoCurse = new ArrayList<Track>();
		tracksNoCurse.addAll(allTracks);
		tracksNoCurse.remove(myCurse);

		// NOTE: used in cases: 21
		ArrayList<Track> someTracks = new ArrayList<Track>();
		someTracks.add(thunderstruck);
		someTracks.add(stairway);
		someTracks.add(prayer);

		// NOTE: used in cases: 1, 5, 6, 8
		ArrayList<Member> allMembers = new ArrayList<Member>();
		allMembers.add(markus);
		allMembers.add(thomas);
		allMembers.add(jens);
		allMembers.add(dominic);
		allMembers.add(jane);

		// NOTE: used in cases: 3, 7, 11
		ArrayList<Member> membersNoTom = new ArrayList<Member>();
		membersNoTom.addAll(allMembers);
		membersNoTom.remove(thomas);

		// NOTE:  used in cases: 24, 28, 29
		ArrayList<Event> allEvents = new ArrayList<Event>();
		allEvents.add(novarock2010);
		allEvents.add(novarock2011);
		allEvents.add(novarock2012);
		allEvents.add(postNova2010);
		allEvents.add(postNova2011);

		// NOTE: used in cases: 26
		ArrayList<Event> eventsNo2010 = new ArrayList<Event>();
		eventsNo2010.addAll(allEvents);
		eventsNo2010.remove(novarock2010);

		// NOTE: used in cases: 31
		ArrayList<Event> gigEventsOnly = new ArrayList<Event>();
		gigEventsOnly.add(novarock2010);
		gigEventsOnly.add(novarock2011);
		gigEventsOnly.add(novarock2012);

		// NOTE: used in cases: 32
		ArrayList<Event> rehearsalEventsOnly = new ArrayList<Event>();
		rehearsalEventsOnly.add(postNova2010);
		rehearsalEventsOnly.add(postNova2011);

		// NOTE: used in cases: 30
		ArrayList<Event> someEvents = new ArrayList<Event>();
		someEvents.add(novarock2010);
		someEvents.add(novarock2011);
		someEvents.add(postNova2010);

		// NOTE: used in cases: 34, 35, 36, 37 (DUH!)
		BigDecimal case34, case35, case36, case37;
		case34 = new BigDecimal(16400);
		case35 = new BigDecimal(17500);
		case36 = new BigDecimal(-1100);
		case37 = new BigDecimal(0);

		try {
			/*
			 * NOTE: 
			 * Test Case #1 Add several valid members
			 * 
			 * should be: thomas, markus, dominic, jens, jane
			 */
			ultraCoders.addMember(thomas, formatDate.parse("17.06.2010"));
			ultraCoders.addMember(markus, formatDate.parse("02.01.2010"));
			ultraCoders.addMember(dominic, formatDate.parse("06.11.2009"));
			ultraCoders.addMember(jens, formatDate.parse("06.01.2001"));
			ultraCoders.addMember(jane, formatDate.parse("06.06.2004"));

			if (Validator.check(ultraCoders.getMembers(), allMembers, 1)) {
				this.successfulTests++;
			}
			else {

				this.failedTestNumbers.add(1);
			}

			/*
			 * NOTE: 
			 * Test Case #2 Try to remove a member with an invalid date
			 * 
			 * should: throw exception
			 */

			try {
				ultraCoders.removeMember(thomas, formatDate.parse("25.05.2010"));

				this.failedTestNumbers.add(2);

			}
			catch (InvalidDateException e) {
				this.successfulTests++;
				Validator.report(true);
			}

			/*
			 * NOTE: 
			 * Test Case #3 Remove a member with a valid date
			 * 
			 * should be: markus, dominic, jens, jane
			 */

			ultraCoders.removeMember(thomas, formatDate.parse("25.05.2011"));
			if (Validator.check(ultraCoders.getMembers(), membersNoTom, 3)) {
				this.successfulTests++;
			}
			else {

				this.failedTestNumbers.add(3);
			}

			/*
			 * NOTE: 
			 * Test Case #4 Try to add a member with an invalid date
			 * 
			 * should: throw exception
			 */

			try {
				ultraCoders.addMember(thomas, formatDate.parse("25.04.2011"));

				this.failedTestNumbers.add(4);

			}
			catch (InvalidDateException e) {
				this.successfulTests++;
				Validator.report(true);
			}

			/*
			 * NOTE: 
			 * Test Case #5 Try to add the same member for the second time
			 * 
			 * should be: thomas, markus, dominic, jens, jane
			 */

			try {
				ultraCoders.addMember(thomas, formatDate.parse("19.07.2011"));

				this.failedTestNumbers.add(5);

			}
			catch (InvalidBandObjectException e) {
				if (Validator.check(ultraCoders.getMembers(), allMembers, 5)) {
					this.successfulTests++;
				}
				else {

					this.failedTestNumbers.add(5);
				}
			}
			/*
			 * NOTE: 
			 * Test Case #6 Get all members before one was removed
			 * 
			 * should be: thomas, markus, dominic, jane, joe
			 */

			if (Validator.check(ultraCoders.getMembers(formatDate.parse("25.04.2011")), allMembers, 6)) {
				this.successfulTests++;
			}
			else {

				this.failedTestNumbers.add(6);
			}


			/*
			 * NOTE: 
			 * Test Case #7 Get all members after one was removed
			 * 
			 * should be: markus, dominic, jane, joe
			 */

			if (Validator.check(ultraCoders.getMembers(formatDate.parse("25.06.2011")), membersNoTom, 7)) {
				this.successfulTests++;
			}
			else {

				this.failedTestNumbers.add(7);
			}

			/*
			 * NOTE: 
			 * Test Case #8 Get all members after one was removed and added again
			 * 
			 * Should be: thomas, markus, dominic, jane, joe
			 */

			if (Validator.check(ultraCoders.getMembers(formatDate.parse("25.04.2012")), allMembers, 8)) {
				this.successfulTests++;
			}
			else {

				this.failedTestNumbers.add(8);
			}

			/*
			 * NOTE: 
			 * Test Case #9 Try to add a member which already exists
			 * 
			 * should: throw exception
			 */

			try {
				ultraCoders.addMember(thomas, formatDate.parse("10.04.2012"));

				this.failedTestNumbers.add(9);

			}
			catch (InvalidBandObjectException e) {
				this.successfulTests++;
				Validator.report(true);
			}

			/*
			 * NOTE: 
			 * Test Case #10 Try to remove a member before it joined the band
			 * 
			 * should: throw exception
			 */

			try {
				ultraCoders.removeMember(thomas, formatDate.parse("11.04.2001"));

				this.failedTestNumbers.add(10);

			}
			catch (InvalidDateException e) {
				this.successfulTests++;
				Validator.report(true);
			}

			/*
			 * NOTE: 
			 * Test Case #11 Remove a valid member for the second time
			 * 
			 * should be: thomas, markus, dominic, jane, joe
			 */

			ultraCoders.removeMember(thomas, formatDate.parse("11.04.2012"));
			if (Validator.check(ultraCoders.getMembers(), membersNoTom, 11)) {
				this.successfulTests++;
			}
			else {

				this.failedTestNumbers.add(11);
			}

			/*
			 * NOTE: 
			 * Test Case #12 Try to remove a member which doesnt exist
			 * 
			 * should: throw exception
			 */

			try {
				ultraCoders.removeMember(thomas, formatDate.parse("10.04.2012"));

				this.failedTestNumbers.add(12);

			}
			catch (InvalidBandObjectException e) {
				this.successfulTests++;
				Validator.report(true);
			}

			/*
			 * NOTE: 
			 * Test Case #13 Adds several valid events
			 * 
			 * should be: novarock2010, novarock2011, novarock2012, postnova2010, postnova2011
			 */

			ultraCoders.addEvent(novarock2010);
			ultraCoders.addEvent(novarock2011);
			ultraCoders.addEvent(novarock2012);
			ultraCoders.addEvent(postNova2010);
			ultraCoders.addEvent(postNova2011);

			if (Validator.check(ultraCoders.getEvents(), allEvents, 13)) {
				this.successfulTests++;
			}
			else {

				this.failedTestNumbers.add(13);
			}

			/*
			 * NOTE: 
			 * Test Case #14 Try to add an event which already exists
			 * 
			 * should: throw exception
			 */

			try {
				ultraCoders.addEvent(novarock2010);

				this.failedTestNumbers.add(14);

			}
			catch (InvalidBandObjectException e) {
				this.successfulTests++;
				Validator.report(true);
			}

			/*
			 * NOTE: 
			 * Test Case #15 Try to remove a valid event
			 * 
			 * should be: novarock2011, novarock2012, postnova2010, postnova2011
			 */

			ultraCoders.removeEvent(novarock2010);
			if (Validator.check(ultraCoders.getEvents(), eventsNo2010, 15)) {
				this.successfulTests++;
			}
			else {

				this.failedTestNumbers.add(15);
			}

			/*
			 * NOTE: 
			 * Test Case #16 Try to remove an event which doesnt exist
			 * 
			 * should: throw exception
			 */

			try {
				ultraCoders.removeEvent(novarock2010);

				this.failedTestNumbers.add(16);
			}
			catch (InvalidBandObjectException e) {
				this.successfulTests++;
				Validator.report(true);
			}

			/*
			 * NOTE: 
			 * Test Case #17 Try to add an event which was removed before
			 * 
			 * should be: novarock2010, novarock2011, novarock2012, postnova2010, postnova2011
			 */

			ultraCoders.addEvent(novarock2010);
			if (Validator.check(ultraCoders.getEvents(), allEvents, 17)) {
				this.successfulTests++;
			}
			else {

				this.failedTestNumbers.add(17);
			}


			/*
			 * NOTE: 
			 * Test Case #18 Get ALL events
			 * 
			 * should be: novarock2010, novarock2011, novarock2012, postnovarock2010, postnovarock2011
			 */

			if (Validator.check(
					ultraCoders.getEvents(formatDate.parse("01.01.2010"), formatDate.parse("01.01.2013"), allTypes),
					allEvents, 18)) {
				this.successfulTests++;
			}
			else {

				this.failedTestNumbers.add(18);
			}

			/*
			 * NOTE: 
			 * Test Case #19 Get a subset of all events
			 * 
			 * should be: novarock2010, novarock2011, postnovarock2010
			 */

			if (Validator.check(
					ultraCoders.getEvents(formatDate.parse("01.01.2010"), formatDate.parse("01.08.2011"), allTypes),
					someEvents, 19)) {
				this.successfulTests++;
			}
			else {

				this.failedTestNumbers.add(19);
			}

			/*
			 * NOTE: 
			 * Test Case #20 Get the gigs only
			 * 
			 * should be: novarock2010, novarock2011, novarock2012
			 */

			if (Validator.check(
					ultraCoders.getEvents(formatDate.parse("01.01.2010"), formatDate.parse("01.01.2013"), gigsOnly),
					gigEventsOnly, 20)) {
				this.successfulTests++;
			}
			else {

				this.failedTestNumbers.add(20);
			}

			/*
			 * NOTE: 
			 * Test Case #21 Get the rehearsals only
			 * 
			 * should be: postnovarock2010, postnovarock2011
			 */

			if (Validator.check(ultraCoders.getEvents(formatDate.parse("01.01.2010"), formatDate.parse("01.01.2013"),
					rehearsalOnly), rehearsalEventsOnly, 21)) {
				this.successfulTests++;
			}
			else {

				this.failedTestNumbers.add(21);
			}

			/*
			 * NOTE: 
			 * Test Case #22 Get no events at all; check for handling of empty ArrayList-param
			 * 
			 * should be: empty
			 */

			if (Validator.check(
					ultraCoders.getEvents(formatDate.parse("01.01.2010"), formatDate.parse("01.01.2013"), noTypes),
					new ArrayList<Event>(), 22)) {
				this.successfulTests++;
			}
			else {

				this.failedTestNumbers.add(22);
			}

			/*
			 * NOTE: 
			 * Test Case #23 Get the billing over the entire time period
			 * 
			 * should be: 16400
			 */

			if (Validator.check(
					ultraCoders.getBilling(formatDate.parse("01.01.2010"), formatDate.parse("01.01.2013"), allTypes),
					case34, 23)) {
				this.successfulTests++;
			}
			else {

				this.failedTestNumbers.add(23);
			}

			/*
			 * NOTE: 
			 * Test Case #24 Get the billing over the entire time period of gigs only
			 * 
			 * should be: 17500
			 */

			if (Validator.check(
					ultraCoders.getBilling(formatDate.parse("01.01.2010"), formatDate.parse("01.01.2013"), gigsOnly),
					case35, 24)) {
				this.successfulTests++;
			}
			else {

				this.failedTestNumbers.add(24);
			}
			/*
			 * NOTE: 
			 * Test Case #25 Get the billing over the entire time period of rehearsals only
			 * 
			 * should be: -1100
			 */

			if (Validator.check(ultraCoders.getBilling(formatDate.parse("01.01.2010"), formatDate.parse("01.01.2013"),
					rehearsalOnly), case36, 25)) {
				this.successfulTests++;
			}
			else {

				this.failedTestNumbers.add(25);
			}

			/*
			 * NOTE: 
			 * Test Case #26 Get the billing over no events; check for handling of empty ArrayList-param
			 * 
			 * should be: 0
			 */

			if (Validator.check(
					ultraCoders.getBilling(formatDate.parse("01.01.2010"), formatDate.parse("01.01.2013"), noTypes),
					case37, 26)) {
				this.successfulTests++;
			}
			else {

				this.failedTestNumbers.add(26);
			}

		}
		catch (InvalidDateException e) {
			System.out.println(e.getMessage());
		}
		catch (ParseException e) {
			System.out.println("Date parsing failed");
		}
		catch (InvalidBandObjectException e) {
			System.out.println(e.getMessage());
		}

	}

}
