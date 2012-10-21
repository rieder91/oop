
package testing;

import helper.EventNotification;
import helper.InvalidBandObjectException;
import helper.InvalidDateException;
import helper.Status;
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
import band.Place;
import band.ProposedDate;
import band.Rehearsal;
import band.Track;

public class MemberTester implements Tester {

	private static final String moduleName = "Member";

	// number of successful/failed tests
	private Integer successfulTests;
	private Integer failedTests;
	private Integer overallTests;

	// the test case numbers of all failed tests
	private ArrayList<Integer> failedTestNumbers;

	private HashMap<Integer, String> testCases;

	public MemberTester() {

		successfulTests = 0;
		failedTests = 0;

		failedTestNumbers = new ArrayList<Integer>();
		testCases = new HashMap<Integer, String>();

		testCases.put(1, "Add some valid Tracks to Member");
		testCases.put(2, "Gets the tracklist to a time at which all tracks were present");
		testCases.put(3, "get all substitute member");
		testCases.put(4, "get all permanent member");
		testCases.put(5, "Add a track which already exists");
		testCases.put(6, "Try to remove a track before it was added");
		testCases.put(7, "Remove a valid track");
		testCases.put(8, "Remove a track which doesn't exist");
		testCases.put(9, "Add a track before its last removal date");
		testCases.put(10, "Add a valid track for the second time");
		testCases.put(11, "Gets the tracklist to a time at which all tracks were present");
		testCases.put(12, "Gets the tracklist to a time at which some tracks were present");
		testCases.put(13, "Gets the tracklist to a time at which one track was removed");
		testCases.put(14, "Gets the tracklist to a time at which the removed track was added again");
		testCases.put(15, "Gets the event notifications from one member");
		testCases.put(16, "make some date proposals to a member");
		testCases.put(17, "accept/decline some date proposals");

		overallTests = testCases.size();
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
	 * deprecation suppression is only used to ignore the warning of the methods we declared deprecated ourselves due to
	 * the enhancements made in assignment #2
	 * 
	 * (non-Javadoc)
	 * 
	 * @see testing.Tester#runTests()
	 */
	// @SuppressWarnings("deprecation")
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

		Member thomas = new Member("Thomas", "Rieder", "Keyboard", "+436991221", false);
		Member markus = new Member("Markus", "Zisser", "Guitar", "01123123123", false);
		Member dominic = new Member("Dominic", "Riedl", "Drums", "0699123456", false);
		Member jens = new Member("Jens", "Mander", "Violin", "129081091", true);
		Member jane = new Member("Jane", "Doe", "Bass", "203957892035", true);

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
			novarock2010 = new Gig("test1", formatTime.parse("11.07.2010 12:00"), new Place("Pannonia Fields II"), 72,
					new BigDecimal(2500.0));
			novarock2011 = new Gig("test2", formatTime.parse("11.07.2011 13:00"), new Place("Pannonia Fields II"), 72,
					new BigDecimal(5000.0));
			novarock2012 = new Gig("test3", formatTime.parse("08.07.2012 14:00"), new Place("Pannonia Fields II"), 72,
					new BigDecimal(10000.0));

			postNova2010 = new Rehearsal("test1", formatTime.parse("15.08.2010 20:00"),
					new Place("Vienna Sound Studio"), 5, new BigDecimal(100.0));
			postNova2011 = new Rehearsal("test2", formatTime.parse("15.08.2011 20:00"), new Place(
					"Vienna Sound Studio Mk II"), 7, new BigDecimal(1000.0));
		}
		catch (ParseException e) {
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

		// used in cases: 1, 5, 6, 8
		ArrayList<Member> allMembers = new ArrayList<Member>();
		allMembers.add(markus);
		allMembers.add(thomas);
		allMembers.add(jens);
		allMembers.add(dominic);
		allMembers.add(jane);

		//
		ArrayList<Member> allSubstitute = new ArrayList<Member>();
		allSubstitute.add(jens);
		allSubstitute.add(jane);

		ArrayList<Member> allNonSubstitute = new ArrayList<Member>();
		allNonSubstitute.add(markus);
		allNonSubstitute.add(thomas);
		allNonSubstitute.add(dominic);

		// used in cases: 24, 28, 29
		ArrayList<Event> allEvents = new ArrayList<Event>();
		allEvents.add(novarock2010);
		allEvents.add(novarock2011);
		allEvents.add(novarock2012);
		allEvents.add(postNova2010);
		allEvents.add(postNova2011);

		// used in cases: 31
		ArrayList<Event> gigEventsOnly = new ArrayList<Event>();
		gigEventsOnly.add(novarock2010);
		gigEventsOnly.add(novarock2011);
		gigEventsOnly.add(novarock2012);

		// used in cases: 32
		ArrayList<Event> rehearsalEventsOnly = new ArrayList<Event>();
		rehearsalEventsOnly.add(postNova2010);
		rehearsalEventsOnly.add(postNova2011);

		//
		ArrayList<Track> tracksNobyob = new ArrayList<Track>();
		tracksNobyob.addAll(allTracks);
		tracksNobyob.remove(byob);

		//
		ArrayList<Track> someTracks = new ArrayList<Track>();
		someTracks.add(thunderstruck);
		someTracks.add(stairway);
		someTracks.add(prayer);

		try {

			/*
			 * 
			 * Test Case #1 Add some valid members to band
			 * 
			 * should be: thomas, markus, dominic, jens, jane
			 */

			ultraCoders.addMember(thomas, formatDate.parse("17.06.2010"));
			ultraCoders.addMember(markus, formatDate.parse("02.01.2010"));
			ultraCoders.addMember(dominic, formatDate.parse("06.11.2009"));
			ultraCoders.addMember(jens, formatDate.parse("06.01.2001"));
			ultraCoders.addMember(jane, formatDate.parse("06.06.2004"));

			if (Validator.check(ultraCoders.getMembers(), allMembers, 1)) {
				successfulTests++;
			}
			else {
				failedTests++;
				failedTestNumbers.add(1);
			}

			/*
			 * 
			 * Test Case #2 Gets the tracklist to a time at which all tracks were present
			 * 
			 * should be: thunderstruck, stairway, prayer, bloodbrothers, byob, mycurse
			 */
			for (Member m : ultraCoders.getMembers()) {
				m.addTrack(thunderstruck, formatDate.parse("30.3.2010"));
				m.addTrack(stairway, formatDate.parse("16.06.2011"));
				m.addTrack(prayer, formatDate.parse("10.09.2011"));
				m.addTrack(bloodBrothers, formatDate.parse("15.09.2011"));
				m.addTrack(byob, formatDate.parse("30.11.2011"));
				m.addTrack(myCurse, formatDate.parse("05.03.2012"));
			}

			if (Validator.check(ultraCoders.getTracks(formatDate.parse("05.03.2012")), allTracks, 2)) {
				successfulTests++;
			}
			else {
				failedTests++;
				failedTestNumbers.add(2);
			}

			/*
			 * 
			 * Test Case #3 get all substitute member
			 * 
			 * should be: jens, jane
			 */
			if (Validator.check(ultraCoders.getMembers(true), allSubstitute, 3)) {
				successfulTests++;
			}
			else {
				failedTests++;
				failedTestNumbers.add(3);
			}

			/*
			 * 
			 * Test Case #4 get all permanent member
			 * 
			 * should be: markus, thomas, dominik
			 */
			if (Validator.check(ultraCoders.getMembers(false), allNonSubstitute, 4)) {
				successfulTests++;
			}
			else {
				failedTests++;
				failedTestNumbers.add(4);
			}

			/*
			 * 
			 * Test Case #5 Add a track which already exists
			 * 
			 * should: throw exception
			 */

			try {
				thomas.addTrack(myCurse, formatDate.parse("05.03.2012"));
				failedTests++;
				failedTestNumbers.add(5);
				Validator.report(false);
			}
			catch (InvalidBandObjectException e) {
				successfulTests++;
				Validator.report(true);
			}

			/*
			 * 
			 * Test Case #6 Try to remove a track before it was added
			 * 
			 * should: throw exception
			 */

			try {
				thomas.removeTrack(myCurse, formatDate.parse("05.02.2012"));
				failedTests++;
				failedTestNumbers.add(6);
				Validator.report(false);
			}
			catch (InvalidDateException e) {
				successfulTests++;
				Validator.report(true);
			}

			/*
			 * 
			 * Test Case #7 Remove a valid track
			 * 
			 * should be: thunderstruck, stairway, prayer, bloodbrothers, byob
			 */
			thomas.removeTrack(byob, formatDate.parse("05.04.2012"));

			if (Validator.check(ultraCoders.getTracks(), tracksNobyob, 7)) {
				successfulTests++;
			}
			else {
				failedTests++;
				failedTestNumbers.add(7);
			}

			/*
			 * 
			 * Test Case #8 Remove a track which doesn't exist
			 * 
			 * should: throw exception
			 */

			try {
				thomas.removeTrack(byob, formatDate.parse("05.05.2012"));
				failedTests++;
				failedTestNumbers.add(8);
				Validator.report(false);
			}
			catch (InvalidBandObjectException e) {
				successfulTests++;
				Validator.report(true);
			}

			/*
			 * 
			 * Test Case #9 Add a track before its last removal date
			 * 
			 * should: throw exception
			 */

			try {
				thomas.addTrack(byob, formatDate.parse("05.05.2011"));
				failedTests++;
				failedTestNumbers.add(9);
				Validator.report(false);
			}
			catch (InvalidDateException e) {
				successfulTests++;
				Validator.report(true);
			}

			/*
			 * 
			 * Test Case #10 Add a valid track for the second time
			 * 
			 * should: throw exception
			 */

			try {
				markus.addTrack(byob, formatDate.parse("05.05.2012"));
				failedTests++;
				failedTestNumbers.add(9);
				Validator.report(false);
			}
			catch (InvalidBandObjectException e) {
				successfulTests++;
				Validator.report(true);
			}

			/*
			 * 
			 * Test Case #11 Gets the tracklist to a time at which all tracks were present
			 * 
			 * should be: thunderstruck, stairway, prayer, bloodbrothers, byob, mycurse
			 */

			if (Validator.check(ultraCoders.getTracks(formatDate.parse("05.03.2012")), allTracks, 11)) {
				successfulTests++;
			}
			else {
				failedTests++;
				failedTestNumbers.add(11);
			}

			/*
			 * 
			 * Test Case #12 Gets the tracklist to a time at which some tracks were present
			 * 
			 * should be: thunderstruck, stairway, prayer
			 */

			if (Validator.check(ultraCoders.getTracks(formatDate.parse("15.09.2011")), someTracks, 12)) {
				successfulTests++;
			}
			else {
				failedTests++;
				failedTestNumbers.add(12);
			}

			/*
			 * 
			 * Test Case #13 Gets the tracklist to a time at which one track was removed
			 * 
			 * should be: thunderstruck, stairway, prayer, bloodbrothers, byob
			 */

			if (Validator.check(ultraCoders.getTracks(formatDate.parse("10.04.2012")), tracksNobyob, 13)) {
				successfulTests++;
			}
			else {
				failedTests++;
				failedTestNumbers.add(13);
			}

			/*
			 * 
			 * Test Case #14 Gets the tracklist to a time at which the removed track was added again
			 */

			if (Validator.check(ultraCoders.getTracks(formatDate.parse("05.10.2012")), allTracks, 14)) {
				successfulTests++;
			}
			else {
				failedTests++;
				failedTestNumbers.add(14);
			}

			/*
			 * 
			 * Test Case #15 Gets the event notifications from one member.
			 */

			ArrayList<EventNotification> case15 = new ArrayList<EventNotification>();
			case15.add(new EventNotification(postNova2011, Status.scheduled));
			case15.add(new EventNotification(novarock2010, Status.scheduled));
			case15.add(new EventNotification(postNova2010, Status.scheduled));
			case15.add(new EventNotification(novarock2010, Status.canceled));
			case15.add(new EventNotification(novarock2012, Status.scheduled));
			case15.add(new EventNotification(postNova2011, Status.deferred));

			ultraCoders.addEvent(postNova2011);
			ultraCoders.addEvent(novarock2010);
			ultraCoders.addEvent(postNova2010);
			ultraCoders.removeEvent(novarock2010);
			ultraCoders.addEvent(novarock2012);
			ultraCoders.deferreEvent(postNova2011, formatDate.parse("05.10.2012"));

			if (Validator.check(thomas.getNotifications(true), case15, 15)) {
				successfulTests++;
			}
			else {
				failedTests++;
				failedTestNumbers.add(15);
			}

			/*
			 * 
			 * Test Case #16 make some date proposals to a member
			 */
			ArrayList<ProposedDate> propd = new ArrayList<ProposedDate>();

			propd.add(new ProposedDate(novarock2010, formatTime.parse("15.08.2010 20:00")));
			propd.add(new ProposedDate(novarock2011, formatTime.parse("15.08.2010 20:00")));
			propd.add(new ProposedDate(postNova2010, formatTime.parse("15.08.2010 20:00")));
			dominic.addProposedDate(new ProposedDate(novarock2010, formatTime.parse("15.08.2010 20:00")));
			dominic.addProposedDate(new ProposedDate(novarock2011, formatTime.parse("15.08.2010 20:00")));
			dominic.addProposedDate(new ProposedDate(postNova2010, formatTime.parse("15.08.2010 20:00")));

			if (Validator.check(dominic.getProposedDates(), propd, 16)) {
				successfulTests++;
			}
			else {
				failedTests++;
				failedTestNumbers.add(15);
			}

			/*
			 * 
			 * Test Case #17 accept/decline some date proposals
			 */
			ArrayList<ProposedDate> case17 = new ArrayList<ProposedDate>(propd);

			case17.get(0).agree(true);
			case17.get(1).agree(false);
			case17.get(2).agree(true, "good date");
			dominic.agree(new ProposedDate(novarock2010, formatTime.parse("15.08.2010 20:00")), true);
			dominic.agree(new ProposedDate(novarock2011, formatTime.parse("15.08.2010 20:00")), false);
			dominic.agree(new ProposedDate(postNova2010, formatTime.parse("15.08.2010 20:00")), "good date", true);

			if (Validator.check(dominic.getProposedDates(), case17, 17)) {
				successfulTests++;
			}
			else {
				failedTests++;
				failedTestNumbers.add(15);
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
