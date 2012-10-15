
package assignment1;

/**
 * Class that contains all the information belonging to a member.
 * 
 * @author OOP Gruppe 187
 */
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
	 * @return a string representation of an member
	 */
	@Override
	public String toString() {

		String ret = "First name: " + this.firstName + " Last name: "
				+ this.lastName + " Instrument: " + this.instrument
				+ " Telephone number: " + this.telephoneNumber;
		return ret;
	}

	/**
	 * @return a hash value representing the track
	 */
	@Override
	public int hashCode() {

		final int prime = 31;
		int result = 1;
		result = (prime * result)
				+ ((firstName == null) ? 0 : firstName.hashCode());
		result = (prime * result)
				+ ((instrument == null) ? 0 : instrument.hashCode());
		result = (prime * result)
				+ ((lastName == null) ? 0 : lastName.hashCode());
		result = (prime * result)
				+ ((telephoneNumber == null) ? 0 : telephoneNumber.hashCode());
		return result;
	}

	/**
	 * compares two members
	 * 
	 * @return true if the members are equal false otherwise
	 */
	@Override
	public boolean equals(Object obj) {

		if (this == obj) { return true; }
		if (obj == null) { return false; }
		if (!(obj instanceof Member)) { return false; }
		Member other = (Member) obj;
		if (firstName == null) {
			if (other.firstName != null) { return false; }
		} else
			if (!firstName.equals(other.firstName)) { return false; }
		if (instrument == null) {
			if (other.instrument != null) { return false; }
		} else
			if (!instrument.equals(other.instrument)) { return false; }
		if (lastName == null) {
			if (other.lastName != null) { return false; }
		} else
			if (!lastName.equals(other.lastName)) { return false; }
		if (telephoneNumber == null) {
			if (other.telephoneNumber != null) { return false; }
		} else
			if (!telephoneNumber.equals(other.telephoneNumber)) { return false; }
		return true;
	}
}
