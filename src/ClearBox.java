/**
 * the clearbox extends a normal box and satifises all inheritied
 * conditions/invariants
 * 
 * @author OOP Gruppe 187
 * 
 */
public class ClearBox extends Box {

	/**
	 * two argument constructor; the border- and fill-style of the clear box are
	 * predefined
	 * 
	 * @param height
	 *            height of the box
	 * @param width
	 *            width of the box
	 */
	public ClearBox(Double height, Double width) {
		super(height, width, '*', ' ');
	}

	/**
	 * calculates the aspect ratio of the box
	 * 
	 * @return aspect ratio (width / height)
	 */
	public Double getAspectRatio() {
		return getWidth() / getHeight();
	}

}
