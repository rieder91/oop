package assignment1;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy HH:mm");

		try {
			System.out.println("Band Test");
			Band ultraCoders = new Band("Ultra Coders", "Rock");

			Member thomas = new Member("Thomas", "Rieder", "Piano",
					"+43699123123");
			Member markus = new Member("Markus", "Zisser", "Guitar",
					"01123123123");
			Member dominic = new Member("Dominic", "Riedl", "Drums",
					"0699123456");

			ultraCoders.addMember(thomas, format.parse("17.06.2010 09:13"));
			ultraCoders.addMember(markus, format.parse("02.01.2011 07:43"));
			ultraCoders.addMember(dominic, format.parse("06.11.2012 17:07"));

			// generate band objects

			System.out.println("Event Test");
			// generate event objects

			System.out.println("Complete Test");
			// generate everything

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			System.out.println("Date parsing failed");
			e.printStackTrace();
		}
	}
}