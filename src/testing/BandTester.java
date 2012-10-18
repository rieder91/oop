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
 * This class was refactored from the previous Main()
 * @author Thomas
 *
 */
public class BandTester implements Tester {
	private static final String moduleName = "Band";

	// number of successful/failed tests
	private Integer successfulTests;
	private Integer failedTests;

	// the test case numbers of all failed tests
	private ArrayList<Integer> failedTestNumbers;

	private HashMap<Integer, String> testCases;

	public BandTester() {
		successfulTests = 0;
		failedTests = 0;

		failedTestNumbers = new ArrayList<Integer>();
		testCases = new HashMap<Integer, String>();

		testCases.put(1, "Add several valid members");
		testCases.put(2, "Try to remove a member with an invalid date ");
		testCases.put(3, "Remove a member with a valid date");
		testCases.put(4, "Try to add a member with an invalid date ");
		testCases.put(5, "Try to add the same member for the second time");
		testCases.put(6, "Get all members before one was removed");
		testCases.put(7, "Get all members after one was removed");
		testCases.put(8, "Get all members after one was removed and added again");
		testCases.put(9, "Try to add a member which already exists ");
		testCases.put(10, "Try to remove a member before it joined the band");
		testCases.put(11, "Remove a valid member for the second time");
		testCases.put(12, "Try to remove a member which doesnt exist");
		testCases.put(13, "Add several valid tracks");
		testCases.put(14, "Add a track which already exists");
		testCases.put(15, "Try to remove a track before it was added");
		testCases.put(16, "Remove a valid track");
		testCases.put(17, "Remove a track which doesnt exist");
		testCases.put(18, "Add a track before its last removal date");
		testCases.put(19, "Add a valid track for the second time");
		testCases.put(20, "Get the tracklist at a time at which all tracks were present");
		testCases.put(21, "Get the tracklist at a time at which some tracks were present");
		testCases.put(22, "Get the tracklist at a time at which one track was removed");
		testCases.put(23, "Get the tracklist at a time at which the removed track was added again");
		testCases.put(24, "Add several valid events ");
		testCases.put(25, "Try to add an event which already exists");
		testCases.put(26, "Try to remove a valid event");
		testCases.put(27, "Try to remove an event which doesnt exist");
		testCases.put(28, "Try to add an event which was removed before");
		testCases.put(29, "Get ALL events");
		testCases.put(30, "Get a subset of all events ");
		testCases.put(31, "Get the gigs only");
		testCases.put(32, "Get the rehearsals only");
		testCases.put(33, "Get no events at all; check for handling of empty ArrayList-param");
		testCases.put(34, "Get the billing over the entire time period");
		testCases.put(35, "Get the billing over the entire time period of gigs only");
		testCases.put(36, "Get the billing over the entire time period of rehearsals only");
		testCases.put(37, "Get the billing over no events; check for handling of empty ArrayList-param");
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
	@SuppressWarnings("deprecation")
	@Override
	public void runTests() {

		// Stuff needed for date parsing
		SimpleDateFormat formatTime = new SimpleDateFormat("dd.MM.yyyy HH:mm");
		SimpleDateFormat formatDate = new SimpleDateFormat("dd.MM.yyyy");

		// Create all the necessary members, tracks, events, ...
		Band ultraCoders = new Band("Ultra Coders", "Rock");

		ArrayList<Class<? extends Event>> allTypes = new ArrayList<Class<? extends Event>>();
		allTypes.add(Gig.class);
		allTypes.add(Rehearsal.class);

		ArrayList<Class<? extends Event>> gigsOnly = new ArrayList<Class<? extends Event>>();
		gigsOnly.add(Gig.class);

		ArrayList<Class<? extends Event>> rehearsalOnly = new ArrayList<Class<? extends Event>>();
		rehearsalOnly.add(Rehearsal.class);

		ArrayList<Class<? extends Event>> noTypes = new ArrayList<Class<? extends Event>>();

		Member thomas = new Member("Thomas", "Rieder", "Keyboard",
				"+436991221", true);
		Member markus = new Member("Markus", "Zisser", "Guitar", "01123123123",
				true);
		Member dominic = new Member("Dominic", "Riedl", "Drums", "0699123456",
				true);
		Member jens = new Member("Jens", "Mander", "Violin", "129081091", false);
		Member jane = new Member("Jane", "Doe", "Bass", "203957892035", false);

		Track thunderstruck = new Track("Thunderstruck", 321);
		Track stairway = new Track("Stairway to Heaven", 482);
		Track prayer = new Track("Prayer of the Refugee", 199);
		Track bloodBrothers = new Track("Blood Brothers", 214);
		Track byob = new Track("B.Y.O.B.", 256);
		Track myCurse = new Track("My Curse", 245);

		// init variables which throw exceptions
		Gig novarock2010 = null, novarock2011 = null, novarock2012 = null;
		Rehearsal postNova2010 = null, postNova2011 = null;

		try {
			novarock2010 = new Gig(formatTime.parse("11.07.2010 12:00"),
					"Pannonia Fields II", 72, 2500.0);
			novarock2011 = new Gig(formatTime.parse("11.07.2011 13:00"),
					"Pannonia Fields II", 72, 5000.0);
			novarock2012 = new Gig(formatTime.parse("08.07.2012 14:00"),
					"Pannonia Fields II", 72, 10000.0);

			postNova2010 = new Rehearsal(formatTime.parse("15.08.2010 20:00"),
					"Vienna Sound Studio", 5, 100.0);
			postNova2011 = new Rehearsal(formatTime.parse("15.08.2011 20:00"),
					"Vienna Sound Studio Mk II", 7, 1000.0);
		} catch (ParseException e) {
			System.out.println("Date parsing failed");
		}



		// used in cases: 13, 19, 20, 23
		ArrayList<Track> allTracks = new ArrayList<Track>();
		allTracks.add(thunderstruck);
		allTracks.add(stairway);
		allTracks.add(prayer);
		allTracks.add(bloodBrothers);
		allTracks.add(byob);
		allTracks.add(myCurse);

		// used in cases: 16, 22
		ArrayList<Track> tracksNoCurse = new ArrayList<Track>();
		tracksNoCurse.addAll(allTracks);
		tracksNoCurse.remove(myCurse);

		// used in cases: 21
		ArrayList<Track> someTracks = new ArrayList<Track>();
		someTracks.add(thunderstruck);
		someTracks.add(stairway);
		someTracks.add(prayer);

		// used in cases: 1, 5, 6, 8
		ArrayList<Member> allMembers = new ArrayList<Member>();
		allMembers.add(markus);
		allMembers.add(thomas);
		allMembers.add(jens);
		allMembers.add(dominic);
		allMembers.add(jane);

		// used in cases: 3, 7, 11
		ArrayList<Member> membersNoTom = new ArrayList<Member>();
		membersNoTom.addAll(allMembers);
		membersNoTom.remove(thomas);

		// used in cases: 24, 28, 29
		ArrayList<Event> allEvents = new ArrayList<Event>();
		allEvents.add(novarock2010);
		allEvents.add(novarock2011);
		allEvents.add(novarock2012);
		allEvents.add(postNova2010);
		allEvents.add(postNova2011);

		// used in cases: 26
		ArrayList<Event> eventsNo2010 = new ArrayList<Event>();
		eventsNo2010.addAll(allEvents);
		eventsNo2010.remove(novarock2010);

		// used in cases: 31
		ArrayList<Event> gigEventsOnly = new ArrayList<Event>();
		gigEventsOnly.add(novarock2010);
		gigEventsOnly.add(novarock2011);
		gigEventsOnly.add(novarock2012);

		// used in cases: 32
		ArrayList<Event> rehearsalEventsOnly = new ArrayList<Event>();
		rehearsalEventsOnly.add(postNova2010);
		rehearsalEventsOnly.add(postNova2011);

		// used in cases: 30
		ArrayList<Event> someEvents = new ArrayList<Event>();
		someEvents.add(novarock2010);
		someEvents.add(novarock2011);
		someEvents.add(postNova2010);

		// used in cases: 34, 35, 36, 37 (DUH!)
		BigDecimal case34, case35, case36, case37;
		case34 = new BigDecimal(16400);
		case35 = new BigDecimal(17500);
		case36 = new BigDecimal(-1100);
		case37 = new BigDecimal(0);
		
		try {
			/*
			 * 
			 * Test Case #1 Add several valid members
			 * 
			 * should be: thomas, markus, dominic, jens, jane
			 */
			ultraCoders.addMember(thomas, formatDate.parse("17.06.2010"));
			ultraCoders.addMember(markus, formatDate.parse("02.01.2010"));
			ultraCoders.addMember(dominic, formatDate.parse("06.11.2009"));
			ultraCoders.addMember(jens, formatDate.parse("06.01.2001"));
			ultraCoders.addMember(jane, formatDate.parse("06.06.2004"));

			if(Validator.check(ultraCoders.getMembers(), allMembers, 1)) {
				successfulTests++;
			} else {
				failedTests++;
				failedTestNumbers.add(1);
			}
			
			/*
			 * 
			 * Test Case #2 Try to remove a member with an invalid date
			 * 
			 * should: throw exception
			 */

			try {
				ultraCoders.removeMember(thomas, formatDate.parse("25.05.2010"));
				failedTests++;
				failedTestNumbers.add(2);
				Validator.report(false);
			} catch (InvalidDateException e) {
				successfulTests++;
				Validator.report(true);
			}
			
			/*
			 * 
			 * Test Case #3 Remove a member with a valid date
			 * 
			 * should be: markus, dominic, jens, jane
			 */

			ultraCoders.removeMember(thomas, formatDate.parse("25.05.2011"));
			if(Validator.check(ultraCoders.getMembers(), membersNoTom, 3)) {
				successfulTests++;
			} else {
				failedTests++;
				failedTestNumbers.add(3);
			}

			/*
			 * 
			 * Test Case #4 Try to add a member with an invalid date
			 * 
			 * should: throw exception
			 */

			try {
				ultraCoders.addMember(thomas, formatDate.parse("25.04.2011"));
				failedTests++;
				failedTestNumbers.add(4);
				Validator.report(false);
			} catch (InvalidDateException e) {
				successfulTests++;
				Validator.report(true);
			}

			/*
			 * 
			 * Test Case #5 Try to add the same member for the second time
			 * 
			 * should be: thomas, markus, dominic, jens, jane
			 */

			ultraCoders.addMember(thomas, formatDate.parse("19.07.2011"));
			if(Validator.check(ultraCoders.getMembers(), allMembers, 5)) {
				successfulTests++;
			} else {
				failedTests++;
				failedTestNumbers.add(5);
			}

			/*
			 * 
			 * Test Case #6 Get all members before one was removed
			 * 
			 * should be: thomas, markus, dominic, jane, joe
			 */

			if(Validator.check(
					ultraCoders.getMembers(formatDate.parse("25.04.2011")),
					allMembers, 6)) {
				successfulTests++;
			} else {
				failedTests++;
				failedTestNumbers.add(6);
			}

			// Should be:

			/*
			 * 
			 * Test Case #7 Get all members after one was removed
			 * 
			 * should be: markus, dominic, jane, joe
			 */

			if(Validator.check(
					ultraCoders.getMembers(formatDate.parse("25.06.2011")),
					membersNoTom, 7)) {
				successfulTests++;
			} else {
				failedTests++;
				failedTestNumbers.add(7);
			}

			/*
			 * 
			 * Test Case #8 Get all members after one was removed and added
			 * again
			 * 
			 * Should be: thomas, markus, dominic, jane, joe
			 */

			if(Validator.check(
					ultraCoders.getMembers(formatDate.parse("25.04.2012")),
					allMembers, 8)) {
				successfulTests++;
			} else {
				failedTests++;
				failedTestNumbers.add(8);
			}

			/*
			 * 
			 * Test Case #9 Try to add a member which already exists
			 * 
			 * should: throw exception
			 */

			try {
				ultraCoders.addMember(thomas, formatDate.parse("10.04.2012"));
				failedTests++;
				failedTestNumbers.add(9);
				Validator.report(false);
			} catch (InvalidBandObjectException e) {
				successfulTests++;
				Validator.report(true);
			}

			/*
			 * 
			 * Test Case #10 Try to remove a member before it joined the band
			 * 
			 * should: throw exception
			 */

			try {
				ultraCoders
				.removeMember(thomas, formatDate.parse("11.04.2001"));
				failedTests++;
				failedTestNumbers.add(10);
				Validator.report(false);
			} catch (InvalidDateException e) {
				successfulTests++;
				Validator.report(true);
			}
			
			/*
			 * 
			 * Test Case #11 Remove a valid member for the second time
			 * 
			 * should be: thomas, markus, dominic, jane, joe
			 */

			ultraCoders.removeMember(thomas, formatDate.parse("11.04.2012"));
			if(Validator.check(ultraCoders.getMembers(), membersNoTom, 11)) {
				successfulTests++;
			} else {
				failedTests++;
				failedTestNumbers.add(11);
			}

			/*
			 * 
			 * Test Case #12 Try to remove a member which doesnt exist
			 * 
			 * should: throw exception
			 */

			try {
				ultraCoders
				.removeMember(thomas, formatDate.parse("10.04.2012"));
				failedTests++;
				failedTestNumbers.add(12);
				Validator.report(false);
			} catch (InvalidBandObjectException e) {
				successfulTests++;
				Validator.report(true);
			}

			/*
			 * 
			 * Test Case #13 Add several valid tracks
			 * 
			 * should be: thunderstruck, stairway, prayer, bloodbrothers, byob,
			 * mycurse
			 */

			ultraCoders.addTrack(thunderstruck, formatDate.parse("30.3.2010"));
			ultraCoders.addTrack(stairway, formatDate.parse("16.06.2011"));
			ultraCoders.addTrack(prayer, formatDate.parse("10.09.2011"));
			ultraCoders.addTrack(bloodBrothers, formatDate.parse("15.09.2011"));
			ultraCoders.addTrack(byob, formatDate.parse("30.11.2011"));
			ultraCoders.addTrack(myCurse, formatDate.parse("05.03.2012"));

			if(Validator.check(allTracks, ultraCoders.getTracks(), 13)) {
				successfulTests++;
			} else {
				failedTests++;
				failedTestNumbers.add(13);
			}

			/*
			 * 
			 * Test Case #14 Add a track which already exists
			 * 
			 * should: throw exception
			 */

			try {
				ultraCoders.addTrack(myCurse, formatDate.parse("05.03.2012"));
				failedTests++;
				failedTestNumbers.add(14);
				Validator.report(false);
			} catch (InvalidBandObjectException e) {
				successfulTests++;
				Validator.report(true);
			}

			/*
			 * 
			 * Test Case #15 Try to remove a track before it was added
			 * 
			 * should: throw exception
			 */

			try {
				ultraCoders
				.removeTrack(myCurse, formatDate.parse("05.02.2012"));
				failedTests++;
				failedTestNumbers.add(15);
				Validator.report(false);
			} catch (InvalidDateException e) {
				successfulTests++;
				Validator.report(true);
			}

			/*
			 * 
			 * Test Case #16 Remove a valid track
			 * 
			 * should be: thunderstruck, stairway, prayer, bloodbrothers, byob
			 */

			ultraCoders.removeTrack(myCurse, formatDate.parse("05.04.2012"));
			if(Validator.check(ultraCoders.getTracks(), tracksNoCurse, 16)) {
				successfulTests++;
			} else {
				failedTests++;
				failedTestNumbers.add(16);
			}

			/*
			 * 
			 * Test Case #17 Remove a track which doesnt exist
			 * 
			 * should: throw exception
			 */

			try {
				ultraCoders
				.removeTrack(myCurse, formatDate.parse("05.05.2012"));
				failedTests++;
				failedTestNumbers.add(17);
				Validator.report(false);
			} catch (InvalidBandObjectException e) {
				successfulTests++;
				Validator.report(true);
			}

			/*
			 * 
			 * Test Case #18 Add a track before its last removal date
			 * 
			 * should: throw exception
			 */

			try {
				ultraCoders.addTrack(myCurse, formatDate.parse("05.05.2011"));
				failedTests++;
				failedTestNumbers.add(18);
				Validator.report(false);
			} catch (InvalidDateException e) {
				successfulTests++;
				Validator.report(true);
			}

			/*
			 * 
			 * Test Case #19 Add a valid track for the second time
			 * 
			 * should be: thunderstruck, stairway, prayer, bloodbrothers, byob,
			 * mycurse
			 */

			ultraCoders.addTrack(myCurse, formatDate.parse("05.05.2012"));
			if(Validator.check(ultraCoders.getTracks(), allTracks, 19)) {
				successfulTests++;
			} else {
				failedTests++;
				failedTestNumbers.add(19);
			}

			/*
			 * 
			 * Test Case #20 Gets the tracklist to a time at which all tracks
			 * were present
			 * 
			 * should be: thunderstruck, stairway, prayer, bloodbrothers, byob,
			 * mycurse
			 */

			if(Validator.check(
					ultraCoders.getTracks(formatDate.parse("05.03.2012")),
					allTracks, 20)) {
				successfulTests++;
			} else {
				failedTests++;
				failedTestNumbers.add(20);
			}

			/*
			 * 
			 * Test Case #21 Gets the tracklist to a time at which some tracks
			 * were present
			 * 
			 * should be: thunderstruck, stairway, prayer
			 */

			if(Validator.check(
					ultraCoders.getTracks(formatDate.parse("15.09.2011")),
					someTracks, 21)) {
				successfulTests++;
			} else {
				failedTests++;
				failedTestNumbers.add(21);
			}

			/*
			 * 
			 * Test Case #22 Gets the tracklist to a time at which one track was
			 * removed
			 * 
			 * should be: thunderstruck, stairway, prayer, bloodbrothers, byob
			 */

			if(Validator.check(
					ultraCoders.getTracks(formatDate.parse("10.04.2012")),
					tracksNoCurse, 22)) {
				successfulTests++;
			} else {
				failedTests++;
				failedTestNumbers.add(22);
			}

			/*
			 * 
			 * Test Case #23 Gets the tracklist to a time at which the removed
			 * track was added again
			 */

			if(Validator.check(
					ultraCoders.getTracks(formatDate.parse("05.10.2012")),
					allTracks, 23)) {
				successfulTests++;
			} else {
				failedTests++;
				failedTestNumbers.add(23);
			}

			/*
			 * 
			 * Test Case #24 Adds several valid events
			 * 
			 * should be: novarock2010, novarock2011, novarock2012,
			 * postnova2010, postnova2011
			 */

			ultraCoders.addEvent(novarock2010);
			ultraCoders.addEvent(novarock2011);
			ultraCoders.addEvent(novarock2012);
			ultraCoders.addEvent(postNova2010);
			ultraCoders.addEvent(postNova2011);

			if(Validator.check(ultraCoders.getEvents(), allEvents, 24)) {
				successfulTests++;
			} else {
				failedTests++;
				failedTestNumbers.add(24);
			}

			/*
			 * 
			 * Test Case #25 Try to add an event which already exists
			 * 
			 * should: throw exception
			 */

			try {
				ultraCoders.addEvent(novarock2010);
				failedTests++;
				failedTestNumbers.add(25);
				Validator.report(false);
			} catch (InvalidBandObjectException e) {
				successfulTests++;
				Validator.report(true);
			}

			/*
			 * 
			 * Test Case #26 Try to remove a valid event
			 * 
			 * should be: novarock2011, novarock2012, postnova2010, postnova2011
			 */

			ultraCoders.removeEvent(novarock2010);
			if(Validator.check(ultraCoders.getEvents(), eventsNo2010, 26)) {
				successfulTests++;
			} else {
				failedTests++;
				failedTestNumbers.add(26);
			}

			/*
			 * 
			 * Test Case #27 Try to remove an event which doesnt exist
			 * 
			 * should: throw exception
			 */

			try {
				ultraCoders.removeEvent(novarock2010);
				Validator.report(false);
				failedTests++;
				failedTestNumbers.add(27);
			} catch (InvalidBandObjectException e) {
				successfulTests++;
				Validator.report(true);
			}

			/*
			 * 
			 * Test Case #28 Try to add an event which was removed before
			 * 
			 * should be: novarock2010, novarock2011, novarock2012,
			 * postnova2010, postnova2011
			 */

			ultraCoders.addEvent(novarock2010);
			if(Validator.check(ultraCoders.getEvents(), allEvents, 28)) {
				successfulTests++;
			} else {
				failedTests++;
				failedTestNumbers.add(28);
			}

			// Check if add was successful

			/*
			 * 
			 * Test Case #29 Get ALL events
			 * 
			 * should be: novarock2010, novarock2011, novarock2012,
			 * postnovarock2010, postnovarock2011
			 */

			if(Validator.check(ultraCoders.getEvents(
					formatDate.parse("01.01.2010"),
					formatDate.parse("01.01.2013"), allTypes), allEvents, 29)) {
				successfulTests++;
			} else {
				failedTests++;
				failedTestNumbers.add(29);
			}

			/*
			 * 
			 * Test Case #30 Get a subset of all events
			 * 
			 * should be: novarock2010, novarock2011, postnovarock2010
			 */

			if(Validator.check(ultraCoders.getEvents(
					formatDate.parse("01.01.2010"),
					formatDate.parse("01.08.2011"), allTypes), someEvents, 30)) {
				successfulTests++;
			} else {
				failedTests++;
				failedTestNumbers.add(30);
			}

			/*
			 * 
			 * Test Case #31 Get the gigs only
			 * 
			 * should be: novarock2010, novarock2011, novarock2012
			 */

			if(Validator.check(ultraCoders.getEvents(
					formatDate.parse("01.01.2010"),
					formatDate.parse("01.01.2013"), gigsOnly), gigEventsOnly,
					31)) {
				successfulTests++;
			} else {
				failedTests++;
				failedTestNumbers.add(31);
			}

			/*
			 * 
			 * Test Case #32 Get the rehearsals only
			 * 
			 * should be: postnovarock2010, postnovarock2011
			 */

			if(Validator.check(ultraCoders.getEvents(
					formatDate.parse("01.01.2010"),
					formatDate.parse("01.01.2013"), rehearsalOnly),
					rehearsalEventsOnly, 32)) {
				successfulTests++;
			} else {
				failedTests++;
				failedTestNumbers.add(32);
			}

			/*
			 * 
			 * Test Case #33 Get no events at all; check for handling of empty
			 * ArrayList-param
			 * 
			 * should be: empty
			 */

			if(Validator.check(ultraCoders.getEvents(
					formatDate.parse("01.01.2010"),
					formatDate.parse("01.01.2013"), noTypes),
					new ArrayList<Event>(), 33)) {
				successfulTests++;
			} else {
				failedTests++;
				failedTestNumbers.add(33);
			}

			/*
			 * 
			 * Test Case #34 Get the billing over the entire time period
			 * 
			 * should be: 16400
			 */

			if(Validator.check(ultraCoders.getBilling(
					formatDate.parse("01.01.2010"),
					formatDate.parse("01.01.2013"), allTypes), case34, 34)) {
				successfulTests++;
			} else {
				failedTests++;
				failedTestNumbers.add(34);
			}

			/*
			 * 
			 * Test Case #35 Get the billing over the entire time period of gigs
			 * only
			 * 
			 * should be: 17500
			 */

			if(Validator.check(ultraCoders.getBilling(
					formatDate.parse("01.01.2010"),
					formatDate.parse("01.01.2013"), gigsOnly), case35, 35)) {
				successfulTests++;
			} else {
				failedTests++;
				failedTestNumbers.add(35);
			}
			/*
			 * 
			 * Test Case #36 Get the billing over the entire time period of
			 * rehearsals only
			 * 
			 * should be: -1100
			 */

			if(Validator.check(ultraCoders.getBilling(
					formatDate.parse("01.01.2010"),
					formatDate.parse("01.01.2013"), rehearsalOnly), case36, 36)) {
				successfulTests++;
			} else {
				failedTests++;
				failedTestNumbers.add(36);
			}

			/*
			 * 
			 * Test Case #37 Get the billing over no events; check for handling
			 * of empty ArrayList-param
			 * 
			 * should be: 0
			 */

			if(Validator.check(ultraCoders.getBilling(
					formatDate.parse("01.01.2010"),
					formatDate.parse("01.01.2013"), noTypes), case37, 37)) {
				successfulTests++;
			} else {
				failedTests++;
				failedTestNumbers.add(37);
			}
			
		} catch (InvalidDateException e) {
			System.out.println(e.getMessage());
		} catch (ParseException e) {
			System.out.println("Date parsing failed");
		} catch (InvalidBandObjectException e) {
			System.out.println(e.getMessage());
		}

	}

}
