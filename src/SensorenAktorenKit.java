/**
 * interface used by differently sized Kits
 * @author Thomas
 *
 */
public interface SensorenAktorenKit {
	/**
	 * integrates the kit into an android if all requirements
	 * are satisfied
	 * @param android android that gets the new kits
	 */
	public void integrieren(Android android);
}
