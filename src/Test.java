import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import assignment1.*;

public class Test {

	/**
	 * Test class for assignment1
	 * 
	 * @param args
	 *            command line arguments
	 */
	public static void main(String[] args) {
		SimpleDateFormat formatTime = new SimpleDateFormat("dd.MM.yyyy HH:mm");
		SimpleDateFormat formatDate = new SimpleDateFormat("dd.MM.yyyy");

		try {
			System.out.println("=== Band Test ===\n");
			Band ultraCoders = new Band("Ultra Coders", "Rock");

			ArrayList<Class<? extends Event>> types = new ArrayList<Class<? extends Event>>();
			types.add(Gig.class);
			types.add(Rehearsal.class);

			Member thomas = new Member("Thomas", "Rieder", "Keyboard",
					"+43699123123");
			Member markus = new Member("Markus", "Zisser", "Guitar",
					"01123123123");
			Member dominic = new Member("Dominic", "Riedl", "Drums",
					"0699123456");

			Gig novarock2010 = new Gig(formatTime.parse("11.07.2010 12:00"),
					"Pannonia Fields II", 72, 2500.0);
			Gig novarock2011 = new Gig(formatTime.parse("11.07.2011 13:00"),
					"Pannonia Fields II", 72, 5000.0);
			Gig novarock2012 = new Gig(formatTime.parse("08.07.2012 14:00"),
					"Pannonia Fields II", 72, 10000.0);

			Rehearsal postNova2010 = new Rehearsal(
					formatTime.parse("15.08.2010 20:00"),
					"Vienna Sound Studio", 5, 100.0);
			Rehearsal postNova2011 = new Rehearsal(
					formatTime.parse("15.08.2011 20:00"),
					"Vienna Sound Studio Mk II", 7, 1000.0);

			Track thunderstruck = new Track("Thunderstruck4", 321);
			Track stairway = new Track("Stairway to Heaven", 482);
			Track prayer = new Track("Prayer of the Refugee", 199);
			Track bloodBrothers = new Track("Blood Brothers", 214);
			Track byob = new Track("B.Y.O.B.", 256);
			Track myCurse = new Track("My Curse", 245);

			// Creating the band history
			try {
				ultraCoders.addMember(thomas, formatDate.parse("17.06.2010"));
				ultraCoders.addMember(markus, formatDate.parse("02.01.2010"));
				ultraCoders.addMember(dominic, formatDate.parse("06.11.2009"));

				ultraCoders.addEvent(novarock2010);
				ultraCoders.addEvent(novarock2011);
				ultraCoders.addEvent(novarock2012);

				ultraCoders.addEvent(postNova2010);
				ultraCoders.addEvent(postNova2011);

				ultraCoders.addTrack(thunderstruck,
						formatDate.parse("30.3.2010"));
				ultraCoders.addTrack(stairway, formatDate.parse("16.06.2011"));
				ultraCoders.addTrack(prayer, formatDate.parse("10.09.2011"));
				ultraCoders.addTrack(bloodBrothers,
						formatDate.parse("15.09.2011"));
				ultraCoders.addTrack(byob, formatDate.parse("30.11.2011"));
				ultraCoders.addTrack(myCurse, formatDate.parse("05.03.2012"));

				ultraCoders
				.removeMember(thomas, formatDate.parse("25.05.2011"));
				ultraCoders.addMember(thomas, formatDate.parse("30.05.2011"));
				ultraCoders
				.removeMember(thomas, formatDate.parse("25.06.2011"));
				ultraCoders.addMember(thomas, formatDate.parse("30.08.2012"));

				ultraCoders.removeTrack(stairway,
						formatDate.parse("20.04.2012"));
				ultraCoders.removeTrack(byob, formatDate.parse("10.03.2012"));

				ultraCoders.addTrack(stairway, formatDate.parse("30.05.2012"));
				
			} catch (InvalidDateException e) {
				System.out.println(e.getMessage());
			} catch (InvalidBandObjectException e) {
				System.out.println(e.getMessage());
			} finally {
				System.out.println("Printing the whole band...");
				System.out.println(ultraCoders);
			}

			// Several queries
			try {
				System.out.println("\nAll Tracks at 29.05.2011");
				System.out.println(ultraCoders.getTracks(formatDate
						.parse("29.05.2011")));
				
				System.out.println("\nAll Tracks at 29.04.2012");
				System.out.println(ultraCoders.getTracks(formatDate
						.parse("29.04.2012")));
				
				System.out.println("\nAll Tracks at 30.06.2012");
				System.out.println(ultraCoders.getTracks(formatDate
						.parse("30.06.2012")));
				
				System.out.println("\nAll Members at 27.05.2011");
				System.out.println(ultraCoders.getMembers(formatDate
						.parse("27.05.2011")));
				
				System.out.println("\nAll Members at 11.06.2011");
				System.out.println(ultraCoders.getMembers(formatDate
						.parse("11.06.2011")));
				
				System.out.println("\nAll Members at 11.09.2012");
				System.out.println(ultraCoders.getMembers(formatDate
						.parse("11.09.2012")));

				System.out.println("\nAll Events from 01.01.2010 to 01.01.2012");
				System.out.println(ultraCoders.getEvents(
						formatDate.parse("01.01.2010"),
						formatDate.parse("01.01.2012"), types));
				
				System.out.println("\nRevenue from 01.01.2010 to 01.06.2012");
				System.out.println(ultraCoders.getBilling(
						formatDate.parse("01.01.2010"),
						formatDate.parse("01.06.2012"), types));
				
			} catch (InvalidDateException e) {
				System.out.println(e.getMessage());
			}

		} catch (ParseException e) {
			System.out.println("Date parsing failed");
		}
	}
}