/**
 * This class represents a describing text.
 * It implements the Shorter interface.
 * 
 * @author OOP Gruppe 187
 */

public class Description implements Shorter<Description>{

	private String desc;
	
	/**
	 * Constructor with one parameter
	 * 
	 * @param desc
	 * 			The String used for the description
	 */
	public Description(String desc) {
		this.desc = desc;
	}
	
	/**
	 * Compares @this with @other
	 * 
	 * @param other
	 * 			Description to compare with
	 * @return 	true - if this is shorter than other
	 * 			false - otherwise
	 */
	public boolean shorter(Description other) {
		return(this.length() < other.length())?true:false;
	}
	
	/**
	 * Returns the number of characters of the description
	 * 
	 * @return the number of characters of the description
	 */
	public int length() {
		return this.desc.length();
	}
	
	/**
	 * Returns a readable String of the description
	 * 
	 * @return a readable String of the description
	 */
	public String toString() {
		return this.desc;
	}
	
	/**
	 * Returns the number of lines in the description
	 * 
	 * @return the number of lines in the description
	 */
	public int lines(){
		return this.desc.split("\n").length;
	}
}
