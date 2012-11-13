/**
 * 
 * the dark box does not extend box as it violates the condition of the
 * border- and fill-style being final
 * 
 * a darkbox doesn't extend repeated as the style can be changed
 * 
 * 
 * ASSERTIONS (Zusicherungen):
 *  - height and width are > 0
 *  - the scale has to be between 0 and 10
 *  - fill-char equals border-char
 *  - this char can be changed
 * 
 * @author OOP Gruppe 187
 * 
 */
public class DarkBox implements Pict {
	private Double height;
	private Double width;

	private char style;

	/**
	 * 
	 * @param height
	 *            height of the box
	 * @param width
	 *            height of the box
	 * @param style
	 *            style of the box
	 */
	public DarkBox(Double height, Double width, char style) {
		assert (height > 0) : "height must be > 0";
		assert (width > 0) : "width must be > 0";

		if (height < 0 || width < 0) {
			throw new IllegalArgumentException("invalid box-creation arguments");
		}

		this.height = height;
		this.width = width;

		this.style = style;
	}

	/**
	 * scales the size of the box by factor
	 * 
	 * @param factor
	 */
	public void scale(double factor) {
		assert (0.1 <= factor && factor <= 10.0) : "invalid factor";

		if (factor < 0.1 || factor > 10.0) {
			throw new IllegalArgumentException("illegal factor");
		}

		height *= factor;
		width *= factor;
	}

	/**
	 * returns the string-representation of the box; height and width are
	 * calculated using ceiling
	 * 
	 * @return string-representation
	 */
	public String toString() {
		StringBuilder ret = new StringBuilder();

		int h = (int) Math.ceil(height);
		int w = (int) Math.ceil(width);

		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				ret.append(style);
			}
			if (i != (h - 1)) {
				ret.append('\n');
			}
		}

		return ret.toString();
	}

	/**
	 * changes the style of the box
	 * 
	 * @param style
	 *            new style
	 */
	public void setStyle(char style) {
		this.style = style;
	}
}
