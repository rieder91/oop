/**
 * Box class which implements is a pictogramm
 * 
 * @author OOP Gruppe 187
 * 
 */
public class Box implements Pict {
	private Double height;
	private Double width;

	final private char border;
	final private char fill;

	/**
	 * Constructor which requires four arguments neither height nor width can be
	 * < 0
	 * 
	 * @param height
	 *            height of the box
	 * @param width
	 *            width of the box
	 * @param border
	 *            border-style of the box
	 * @param fill
	 *            fill-style of the box
	 */
	public Box(Double height, Double width, char border, char fill) {
		assert (height > 0);
		assert (width > 0);

		this.height = height;
		this.width = width;

		assert (border != ' ');

		this.border = border;
		this.fill = fill;
	}

	/**
	 * returns the string-representation of the box; height and width are
	 * calculated using ceiling; increases the interior size when scaling
	 * @return string-representation
	 */
	public String toString() {
		StringBuilder ret = new StringBuilder();

		int h = (int) Math.ceil(height);
		int w = (int) Math.ceil(width);

		for (int i = 0; i < h; i++) {
			if (i == 0 || i == (h - 1)) {
				for (int j = 0; j < w; j++) {
					ret.append(border);
				}
			} else {
				for (int j = 0; j < w; j++) {
					if (j == 0 || j == (w - 1)) {
						ret.append(border);
					} else {
						ret.append(fill);
					}
				}
			}
			if (i != (h - 1)) {
				ret.append('\n');
			}
		}

		return ret.toString();
	}

	/**
	 * scales the size of the box by factor
	 * 
	 * @param factor
	 */
	public void scale(double factor) {
		assert (0.1 <= factor && factor <= 10.0) : "invalid factor";

		height *= factor;
		width *= factor;
	}

	/**
	 * @return height of the box
	 */
	public Double getHeight() {
		return height;
	}

	/**
	 * @return width of the box
	 */
	public Double getWidth() {
		return width;
	}

}
