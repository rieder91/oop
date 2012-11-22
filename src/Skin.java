/**
 * skin interface used by all the different skin types
 * 
 * each skin has a unique serial tied to the android it is used by
 * 
 * @author Thomas
 *
 */
public interface Skin {
	/**
	 * deploys the skin on the android, if allowed
	 * @param android android that gets the new skin
	 */
	public void einbauen(Android android);
}
