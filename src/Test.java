import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import assignment1.Band;
import assignment1.Event;
import assignment1.Gig;
import assignment1.InvalidBandObjectException;
import assignment1.InvalidDateException;
import assignment1.Member;
import assignment1.Rehearsal;
import assignment1.Track;
import assignment1.Validator;
import auth.Authenticator;
import auth.InsufficientPermissionsException;

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
	// the deprecation suppression is only used for our own classes and not for
	// any in the jdk
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
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

		/*
		 * Print program info
		 */
		System.out.println(""
				+ "Objektorientierte Programmiertechniken - Assignment 1\n"
				+ "Deadline: 17.10.2012\n" + "Group: 187\n"
				+ "Members: Dominic Riedl, Thomas Rieder, Markus Zisser\n");

		/*
		 * Print test case summary
		 */
		System.out
				.println(""
						+ "Test case #01\t Add several valid members                                                  \n"
						+ "Test case #02\t Try to remove a member with an invalid date                                \n"
						+ "Test case #03\t Remove a member with a valid date                                          \n"
						+ "Test case #04\t Try to add a member with an invalid date                                   \n"
						+ "Test case #05\t Try to add the same member for the second time                             \n"
						+ "Test case #06\t Get all members before one was removed                                     \n"
						+ "Test case #07\t Get all members after one was removed                                      \n"
						+ "Test case #08\t Get all members after one was removed and added again                      \n"
						+ "Test case #09\t Try to add a member which already exists                                   \n"
						+ "Test case #10\t Try to remove a member before it joined the band                           \n"
						+ "Test case #11\t Remove a valid member for the second time                                  \n"
						+ "Test case #12\t Try to remove a member which doesnt exist                                  \n"
						+ "Test case #13\t Add several valid tracks                                                   \n"
						+ "Test case #14\t Add a track which already exists                                           \n"
						+ "Test case #15\t Try to remove a track before it was added                                  \n"
						+ "Test case #16\t Remove a valid track                                                       \n"
						+ "Test case #17\t Remove a track which doesnt exist                                          \n"
						+ "Test case #18\t Add a track before its last removal date                                   \n"
						+ "Test case #19\t Add a valid track for the second time                                      \n"
						+ "Test case #20\t Gets the Tracklist to a time at which all tracks were present              \n"
						+ "Test case #21\t Gets the tracklist to a time at which some tracks were present             \n"
						+ "Test case #22\t Gets the tracklist to a time at which one track was removed                \n"
						+ "Test case #23\t Gets the tracklist to a time at which the removed track was added again    \n"
						+ "Test case #24\t Adds several valid events                                                  \n"
						+ "Test case #25\t Try to add an event which already exists                                   \n"
						+ "Test case #26\t Try to remove a valid event                                                \n"
						+ "Test case #27\t Try to remove an event which doesnt exist                                  \n"
						+ "Test case #28\t Try to add an event which was removed before                               \n"
						+ "Test case #29\t Get ALL events                                                             \n"
						+ "Test case #30\t Get a subset of all events                                                 \n"
						+ "Test case #31\t Get the gigs only                                                          \n"
						+ "Test case #32\t Get the rehearsals only                                                    \n"
						+ "Test case #33\t Get no events at all; check for handling of empty ArrayList-param          \n"
						+ "Test case #34\t Get the billing over the entire time period                                \n"
						+ "Test case #35\t Get the billing over the entire time period of gigs only                   \n"
						+ "Test case #36\t Get the billing over the entire time period of rehearsals only             \n"
						+ "Test case #37\t Get the billing over no events; check for handling of empty ArrayList-param\n\n");

		/*
		 * All variables needed for validation of test cases
		 */

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
			 * Run ALL the test cases
			 */

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

			Validator.check(ultraCoders.getMembers(), allMembers, 1);

			/*
			 * 
			 * Test Case #2 Try to remove a member with an invalid date
			 * 
			 * should: throw exception
			 */

			try {
				ultraCoders
						.removeMember(thomas, formatDate.parse("25.05.2010"));
				Validator.report(false, 2);
			} catch (InvalidDateException e) {
				Validator.report(true, 2);
			}

			/*
			 * 
			 * Test Case #3 Remove a member with a valid date
			 * 
			 * should be: markus, dominic, jens, jane
			 */

			ultraCoders.removeMember(thomas, formatDate.parse("25.05.2011"));
			Validator.check(ultraCoders.getMembers(), membersNoTom, 3);

			/*
			 * 
			 * Test Case #4 Try to add a member with an invalid date
			 * 
			 * should: throw exception
			 */

			try {
				ultraCoders.addMember(thomas, formatDate.parse("25.04.2011"));
				Validator.report(false, 4);
			} catch (InvalidDateException e) {
				Validator.report(true, 4);
			}

			/*
			 * 
			 * Test Case #5 Try to add the same member for the second time
			 * 
			 * should be: thomas, markus, dominic, jens, jane
			 */

			ultraCoders.addMember(thomas, formatDate.parse("19.07.2011"));
			Validator.check(ultraCoders.getMembers(), allMembers, 5);

			/*
			 * 
			 * Test Case #6 Get all members before one was removed
			 * 
			 * should be: thomas, markus, dominic, jane, joe
			 */

			Validator.check(
					ultraCoders.getMembers(formatDate.parse("25.04.2011")),
					allMembers, 6);

			// Should be:

			/*
			 * 
			 * Test Case #7 Get all members after one was removed
			 * 
			 * should be: markus, dominic, jane, joe
			 */

			Validator.check(
					ultraCoders.getMembers(formatDate.parse("25.06.2011")),
					membersNoTom, 7);

			/*
			 * 
			 * Test Case #8 Get all members after one was removed and added
			 * again
			 * 
			 * Should be: thomas, markus, dominic, jane, joe
			 */

			Validator.check(
					ultraCoders.getMembers(formatDate.parse("25.04.2012")),
					allMembers, 8);

			/*
			 * 
			 * Test Case #9 Try to add a member which already exists
			 * 
			 * should: throw exception
			 */

			try {
				ultraCoders.addMember(thomas, formatDate.parse("10.04.2012"));
				Validator.report(false, 9);
			} catch (InvalidBandObjectException e) {
				Validator.report(true, 9);
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
				Validator.report(false, 10);
			} catch (InvalidDateException e) {
				Validator.report(true, 10);
			}

			/*
			 * 
			 * Test Case #11 Remove a valid member for the second time
			 * 
			 * should be: thomas, markus, dominic, jane, joe
			 */

			ultraCoders.removeMember(thomas, formatDate.parse("11.04.2012"));
			Validator.check(ultraCoders.getMembers(), membersNoTom, 11);

			/*
			 * 
			 * Test Case #12 Try to remove a member which doesnt exist
			 * 
			 * should: throw exception
			 */

			try {
				ultraCoders
						.removeMember(thomas, formatDate.parse("10.04.2012"));
				Validator.report(false, 12);
			} catch (InvalidBandObjectException e) {
				Validator.report(true, 12);
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

			Validator.check(allTracks, ultraCoders.getTracks(), 13);

			/*
			 * 
			 * Test Case #14 Add a track which already exists
			 * 
			 * should: throw exception
			 */

			try {
				ultraCoders.addTrack(myCurse, formatDate.parse("05.03.2012"));
				Validator.report(false, 14);
			} catch (InvalidBandObjectException e) {
				Validator.report(true, 14);
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
				Validator.report(false, 15);
			} catch (InvalidDateException e) {
				Validator.report(true, 15);
			}

			/*
			 * 
			 * Test Case #16 Remove a valid track
			 * 
			 * should be: thunderstruck, stairway, prayer, bloodbrothers, byob
			 */

			ultraCoders.removeTrack(myCurse, formatDate.parse("05.04.2012"));
			Validator.check(ultraCoders.getTracks(), tracksNoCurse, 16);

			/*
			 * 
			 * Test Case #17 Remove a track which doesnt exist
			 * 
			 * should: throw exception
			 */

			try {
				ultraCoders
						.removeTrack(myCurse, formatDate.parse("05.05.2012"));
				Validator.report(false, 17);
			} catch (InvalidBandObjectException e) {
				Validator.report(true, 17);
			}

			/*
			 * 
			 * Test Case #18 Add a track before its last removal date
			 * 
			 * should: throw exception
			 */

			try {
				ultraCoders.addTrack(myCurse, formatDate.parse("05.05.2011"));
				Validator.report(false, 18);
			} catch (InvalidDateException e) {
				Validator.report(true, 18);
			}

			/*
			 * 
			 * Test Case #19 Add a valid track for the second time
			 * 
			 * should be: thunderstruck, stairway, prayer, bloodbrothers, byob,
			 * mycurse
			 */

			ultraCoders.addTrack(myCurse, formatDate.parse("05.05.2012"));
			Validator.check(ultraCoders.getTracks(), allTracks, 19);

			/*
			 * 
			 * Test Case #20 Gets the tracklist to a time at which all tracks
			 * were present
			 * 
			 * should be: thunderstruck, stairway, prayer, bloodbrothers, byob,
			 * mycurse
			 */

			Validator.check(
					ultraCoders.getTracks(formatDate.parse("05.03.2012")),
					allTracks, 20);

			/*
			 * 
			 * Test Case #21 Gets the tracklist to a time at which some tracks
			 * were present
			 * 
			 * should be: thunderstruck, stairway, prayer
			 */

			Validator.check(
					ultraCoders.getTracks(formatDate.parse("15.09.2011")),
					someTracks, 21);

			/*
			 * 
			 * Test Case #22 Gets the tracklist to a time at which one track was
			 * removed
			 * 
			 * should be: thunderstruck, stairway, prayer, bloodbrothers, byob
			 */

			Validator.check(
					ultraCoders.getTracks(formatDate.parse("10.04.2012")),
					tracksNoCurse, 22);

			/*
			 * 
			 * Test Case #23 Gets the tracklist to a time at which the removed
			 * track was added again
			 */

			Validator.check(
					ultraCoders.getTracks(formatDate.parse("05.10.2012")),
					allTracks, 23);

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

			Validator.check(ultraCoders.getEvents(), allEvents, 24);

			/*
			 * 
			 * Test Case #25 Try to add an event which already exists
			 * 
			 * should: throw exception
			 */

			try {
				ultraCoders.addEvent(novarock2010);
				Validator.report(false, 25);
			} catch (InvalidBandObjectException e) {
				Validator.report(true, 25);
			}

			/*
			 * 
			 * Test Case #26 Try to remove a valid event
			 * 
			 * should be: novarock2011, novarock2012, postnova2010, postnova2011
			 */

			ultraCoders.removeEvent(novarock2010);
			Validator.check(ultraCoders.getEvents(), eventsNo2010, 26);

			/*
			 * 
			 * Test Case #27 Try to remove an event which doesnt exist
			 * 
			 * should: throw exception
			 */

			try {
				ultraCoders.removeEvent(novarock2010);
				Validator.report(false, 27);
			} catch (InvalidBandObjectException e) {
				Validator.report(true, 27);
			}

			/*
			 * 
			 * Test Case #28 Try to add an event which was removed before
			 * 
			 * should be: novarock2010, novarock2011, novarock2012,
			 * postnova2010, postnova2011
			 */

			ultraCoders.addEvent(novarock2010);
			Validator.check(ultraCoders.getEvents(), allEvents, 28);

			// Check if add was successful

			/*
			 * 
			 * Test Case #29 Get ALL events
			 * 
			 * should be: novarock2010, novarock2011, novarock2012,
			 * postnovarock2010, postnovarock2011
			 */

			Validator.check(ultraCoders.getEvents(
					formatDate.parse("01.01.2010"),
					formatDate.parse("01.01.2013"), allTypes), allEvents, 29);

			/*
			 * 
			 * Test Case #30 Get a subset of all events
			 * 
			 * should be: novarock2010, novarock2011, postnovarock2010
			 */

			Validator.check(ultraCoders.getEvents(
					formatDate.parse("01.01.2010"),
					formatDate.parse("01.08.2011"), allTypes), someEvents, 30);
			// should be:

			/*
			 * 
			 * Test Case #31 Get the gigs only
			 * 
			 * should be: novarock2010, novarock2011, novarock2012
			 */

			Validator.check(ultraCoders.getEvents(
					formatDate.parse("01.01.2010"),
					formatDate.parse("01.01.2013"), gigsOnly), gigEventsOnly,
					31);

			/*
			 * 
			 * Test Case #32 Get the rehearsals only
			 * 
			 * should be: postnovarock2010, postnovarock2011
			 */

			Validator.check(ultraCoders.getEvents(
					formatDate.parse("01.01.2010"),
					formatDate.parse("01.01.2013"), rehearsalOnly),
					rehearsalEventsOnly, 32);

			/*
			 * 
			 * Test Case #33 Get no events at all; check for handling of empty
			 * ArrayList-param
			 * 
			 * should be: empty
			 */

			Validator.check(ultraCoders.getEvents(
					formatDate.parse("01.01.2010"),
					formatDate.parse("01.01.2013"), noTypes),
					new ArrayList<Event>(), 33);

			/*
			 * 
			 * Test Case #34 Get the billing over the entire time period
			 * 
			 * should be: 16400
			 */

			Validator.check(ultraCoders.getBilling(
					formatDate.parse("01.01.2010"),
					formatDate.parse("01.01.2013"), allTypes), case34, 34);

			/*
			 * 
			 * Test Case #35 Get the billing over the entire time period of gigs
			 * only
			 * 
			 * should be: 17500
			 */

			Validator.check(ultraCoders.getBilling(
					formatDate.parse("01.01.2010"),
					formatDate.parse("01.01.2013"), gigsOnly), case35, 35);
			/*
			 * 
			 * Test Case #36 Get the billing over the entire time period of
			 * rehearsals only
			 * 
			 * should be: -1100
			 */

			Validator.check(ultraCoders.getBilling(
					formatDate.parse("01.01.2010"),
					formatDate.parse("01.01.2013"), rehearsalOnly), case36, 36);

			/*
			 * 
			 * Test Case #37 Get the billing over no events; check for handling
			 * of empty ArrayList-param
			 * 
			 * should be: 0
			 */

			Validator.check(ultraCoders.getBilling(
					formatDate.parse("01.01.2010"),
					formatDate.parse("01.01.2013"), noTypes), case37, 37);

			/*
			 * Test Case #38 Change the details of an event
			 * 
			 * should be:
			 */

			// used in: 38
			Gig case38 = new Gig(formatDate.parse("01.01.2013"), "Wien", 10,
					new BigDecimal(10000));

			novarock2010.updateEvent(new Gig(formatDate.parse("01.01.2013"),
					"Wien", 10, new BigDecimal(10000)), formatDate
					.parse("05.10.2012"));

			Validator.check(novarock2010, case38, 38);

			/*
			 * Test case #39 Revert the changes made to an event
			 */

			novarock2010.restoreEvent(formatDate.parse("05.10.2012"),
					formatDate.parse("06.10.2012"));

			// used in: 39, 40
			Gig case39 = new Gig(formatTime.parse("11.07.2010 12:00"),
					"Pannonia Fields II", 72, 2500.0);

			Validator.check(novarock2010, case39, 39);

			/*
			 * Test case #40 Try to edit an event with a invalid changeDate
			 */

			try {
				novarock2010
						.updateEvent(case39, formatDate.parse("01.01.1990"));
				Validator.report(false, 40);
			} catch (InvalidDateException e) {
				Validator.report(true, 40);
			}

			/*
			 * Test case #41 remove Event and restore it
			 */

			ultraCoders.removeEvent(novarock2010,
					formatDate.parse("17.10.2012"));
			ultraCoders.restoreEvent("Pannonia Fields II", 72,
					formatTime.parse("11.07.2010 12:00"));
			Validator.check(ultraCoders.getEvents(), allEvents, 41);

			/*
			 * Test case #42 restore not existing Event
			 */

			try {
				ultraCoders.restoreEvent("Pannonia Fields II", 72,
						formatTime.parse("11.07.2010 12:00"));
				Validator.report(false, 42);
			} catch (InvalidBandObjectException e) {
				Validator.report(true, 42);
			}

			Validator.report();

			/**
			 * 
			 * 
			 * Testing Part
			 * 
			 * 
			 * 
			 */

			Method memberAddTrack, bandAddMember;
			try {
				memberAddTrack = Member.class.getMethod("addTrack",
						new Class[] { Track.class });
				bandAddMember = Band.class.getMethod("addMember", new Class[] {
						Member.class, Date.class });

				// markus.setRole(markus, Permission.OWNER);

				Authenticator.checkPermissions(markus, markus, memberAddTrack);

				Authenticator.checkPermissions(markus, ultraCoders,
						bandAddMember);

			} catch (InsufficientPermissionsException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
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
