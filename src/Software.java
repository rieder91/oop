/**
 * software interface that all different software-types implements
 * 
 * each software has a unique serial tied to the android it is used by and
 * a security level
 * 
 * @author OOP Gruppe 187
 *
 */
public interface Software {
	
	/**
	 * attempts to install the software within the android if it satisfies all requirements
	 * @param android android that software is installed in
	 */
	public void installiertIn(Android android);
	
	/**
	 * returns the security level of the software
	 * @return security level
	 */
	public SecurityLevel getSecurityLevel();
}
