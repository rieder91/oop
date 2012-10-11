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

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		String ret = "First name: " + this.firstName + " Last name: "
				+ this.lastName + " Instrument: " + this.instrument
				+ " Telephone number: " + this.telephoneNumber;
		return ret;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {

		return this.firstName.hashCode() + this.instrument.hashCode()
				+ this.lastName.hashCode() + this.telephoneNumber.hashCode();

	}
}