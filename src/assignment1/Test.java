package assignment1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class Test {

	/**
	 * Test class for assignment1
	 * 
	 * @param args
	 *            command line arguments
	 */
	public static void main(String[] args) {
		SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");

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

			Gig novarock2010 = new Gig(format.parse("11.07.2010"),
					"Pannonia Fields II", 72, 2500.0);
			Gig novarock2011 = new Gig(format.parse("11.07.2011"),
					"Pannonia Fields II", 72, 5000.0);
			Gig novarock2012 = new Gig(format.parse("08.07.2012"),
					"Pannonia Fields II", 72, 10000.0);

			Rehearsal postNova2010 = new Rehearsal(format.parse("15.08.2010"),
					"Vienna Sound Studio", 5, 100.0);
			Rehearsal postNova2011 = new Rehearsal(format.parse("15.08.2011"),
					"Vienna Sound Studio Mk II", 7, 1000.0);

			Track thunderstruck = new Track("Thunderstruck", 321);
			Track stairway = new Track("Stairway to Heaven", 482);

			// Creating the band history
			try {
				ultraCoders.addMember(thomas, format.parse("17.06.2010"));
				ultraCoders.addMember(markus, format.parse("02.01.2010"));
				ultraCoders.addMember(dominic, format.parse("06.11.2012"));

				ultraCoders.addEvent(novarock2010);
				ultraCoders.addEvent(novarock2011);
				ultraCoders.addEvent(novarock2012);

				ultraCoders.addEvent(postNova2010);
				ultraCoders.addEvent(postNova2011);

				ultraCoders.addTrack(thunderstruck, format.parse("30.3.2010"));
				ultraCoders.addTrack(stairway, format.parse("16.06.2011"));

				ultraCoders.removeMember(thomas, format.parse("25.05.2011"));
				ultraCoders.addMember(thomas, format.parse("30.05.2011"));
				ultraCoders.removeMember(thomas, format.parse("25.06.2011"));
				ultraCoders.addMember(thomas, format.parse("30.06.2011"));

			} catch (InvalidDateException e) {
				System.out.println(e.getMessage());
			} catch (InvalidBandObjectException e) {
				System.out.println(e.getMessage());
			} finally {
				System.out.println(ultraCoders);
			}

			// Several queries
			try {
				System.out.println(ultraCoders.getTracks(format
						.parse("29.05.2011")));
				System.out.println(ultraCoders.getMembers(format
						.parse("29.06.2011")));
				System.out.println(ultraCoders.getEvents(
						format.parse("01.01.2010"), format.parse("01.01.2012"),
						types));
				System.out.println(ultraCoders.getBilling(
						format.parse("01.01.2010"), format.parse("01.01.2012"),
						types));
			} catch (InvalidDateException e) {
				System.out.println(e.getMessage());
			}

		} catch (ParseException e) {
			System.out.println("Date parsing failed");
		}
	}
}