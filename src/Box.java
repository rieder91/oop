/** 
 * 
 * a box is a special type of pictogram and does not extend repeated<character> 
 * as it scales differently
 * 
 * ASSERTIONS (Zusicherungen):
 *  - height and width > 0
 *  - border cant be blank
 *  - the scale has to be between 0 and 10
 *  - border, fill and the aspect ratio are final
 *  - the border is always 1 char wide
 *  - fixed aspect ratio
 * 
 * @author OOP Gruppe 187
 * 
 */
public class Box implements Pict {
	final private char border;
	final private char fill;

	private Double height;
	private Double width;

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
		assert (height > 0) : "height must be > 0";
		assert (width > 0) : "width must be > 0";
		assert (border != ' ') : "border cant be blank";

		if (height < 0 || width < 0 || border == ' ') {
			throw new IllegalArgumentException("invalid box-creation arguments");
		}

		this.height = height;
		this.width = width;

		this.border = border;
		this.fill = fill;
	}

	/**
	 * returns the string-representation of the box; height and width are
	 * calculated using ceiling; increases the interior size when scaling
	 * 
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

		if (factor < 0.1 || factor > 10.0) {
			throw new IllegalArgumentException("illegal factor");
		}

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
