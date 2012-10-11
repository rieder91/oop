package assignment1;

public class Member {

	private String firstName;
	private String lastName;
	private String instrument;
	private String telephoneNumber;

	/**
	 * Constructor which requires four arguments
	 * 
	 * @param firstName
	 *            the first name of the member
	 * @param lastName
	 *            the last name of the member
	 * @param instrument
	 *            the instrument of the member
	 * @param telephoneNumber
	 *            the telephone number of the member
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
	 * @return a string representation of an member
	 */
	public String toString() {
		String ret = "First name: " + this.firstName + " Last name: "
				+ this.lastName + " Instrument: " + this.instrument
				+ " Telephone number: " + this.telephoneNumber;
		return ret;
	}

	/**
	 * 
	 * @return a hash value that represents the member
	 */
	public int hashCode() {

		return this.firstName.hashCode() + this.instrument.hashCode()
				+ this.lastName.hashCode() + this.telephoneNumber.hashCode();

	}

	/** 
	 * compares two member
	 * 
	 * @return 
	 * 			true if the member are equal
	 * 			false if the member are not equal
	 */
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!this.getClass().equals(o.getClass())) {
			return false;

		}
		if (this.firstName.equals(((Member) o).firstName)
				&& this.instrument.equals(((Member) o).instrument)
				&& this.lastName.equals(((Member) o).lastName)
				&& this.telephoneNumber.equals(((Member) o).telephoneNumber)) {
			return true;

		}
		return false;
	}
}