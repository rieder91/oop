package assignment1;

public class Member {

	private String firstName;
	private String lastName;
	private String instrument;
	private String telephoneNumber;

	/**
	 * 
	 * @param firstName
	 * @param lastName
	 * @param instrument
	 * @param telephoneNumber
	 */
	public Member(String firstName, String lastName, String instrument,
			String telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
		this.firstName = firstName;
		this.lastName = lastName;
		this.instrument = instrument;
	}

	/**
	 * 
	 * @return
	 */
	public String toString() {
		String ret = "Vorname: " + this.firstName + " Nachname: "
				+ this.lastName + " Instrument: " + this.instrument
				+ " Telephonnummer: " + this.telephoneNumber;
		return ret;
	}

}