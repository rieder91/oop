/**
 * 
 * @author OOP Gruppe 187
 * 
 */

public class Repeated<P> {
	// </3 array that cant be generic
	private Object data[][];

	private int maxHeight;
	private int maxWidth;

	private Double scale;

	/**
	 * constructor which takes an object array
	 * 
	 * @param data
	 *            object array
	 */
	public Repeated(Object data[][]) {
		assert (data != null) : "array cant be null";
		assert (data[0] != null) : "array cant be null";

		this.data = new Object[data.length][data[0].length];

		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[0].length; j++) {
				assert (data[i][j] != null) : "array-element cannot be null";
				this.data[i][j] = data[i][j];
			}
		}

		maxHeight = getMaxHeight();
		maxWidth = getMaxWidth();

		scale = 1.0;
	}

	/**
	 * returns the string-representation of the object-grid; repeats if scale >
	 * 1.0 truncates if scale < 1.0
	 * 
	 * @return string-representation
	 */
	public String toString() {
		StringBuilder ret = new StringBuilder();
		StringBuilder ret2 = new StringBuilder();
		String line;

		for (int i = 0; i < data.length; i++) {
			for (int k = 0; k < Math.ceil(maxHeight); k++) {
				for (int j = 0; j < data[0].length && data[i][j] != null; j++) {
					line = getLine(data[i][j].toString(), k);
					ret.append(line);

					for (int l = line.length() + 1; l < Math.ceil(maxWidth); l++) {
						ret.append(" ");
					}
				}
				if (i != (data.length - 1) || k != (Math.ceil(maxHeight) - 1)) {
					ret.append('\n');
				}
			}
		}

		if (scale < 1.0) {
			int lastHeight = (int) Math.ceil(maxHeight * scale * data.length);
			int lastWidth = (int) Math.ceil((maxWidth - 1) * scale * data[0].length);
			String text = ret.toString();
			
			for (int i = 0; i < lastHeight; i++) {
				ret2.append(getLine(text, i).substring(0, lastWidth) + "\n");
			}

			ret = ret2;

		} else if (scale > 1.0) {
			ret2.append('\n');

			String text = ret.toString();
			int lastHeight = (int) Math.ceil(maxHeight * scale * data.length);
			int lastWidth = (int) Math.ceil((maxWidth - 1) * scale * data[0].length);
			int currentWidth = getWidth(ret.toString()) - 1;
			int numLines = getHeight(ret.toString());

			for(int i = 0; i < lastHeight; i++) {

				String newLine = getLine(text, i % numLines);

				for(int j = 0; j < lastWidth; j++) {
					ret2.append(newLine.charAt(j % (currentWidth)));
				}
				if(i + 1 != lastHeight) {
					ret2.append('\n');
				}
			}
			ret = ret2;
		}
		return ret.toString();
	}

	/**
	 * returns the n-th of the string-representation of an object
	 * 
	 * @param e
	 *            object that is being examined
	 * @param n
	 *            number of the line
	 * @return the n-th line in the string-representation of the object e
	 */
	private String getLine(String e, int n) {
		if (getHeight(e) <= n) {
			return "";
		}

		int width = getWidth(e.toString());

		return e.toString().substring(n * width, n * width + width - 1);
	}

	/**
	 * return the n-th of and object an repeat the object itself if the scale is
	 * high enough
	 * 
	 * @param e
	 *            object that is being examined
	 * @param n
	 *            number of the line
	 * @return the n-th line in the string-representation of the object e
	 * 
	 */
	@SuppressWarnings("unused")
	@Deprecated
	private String getLineRepeat(Object e, int n) {
		int height = getHeight(e.toString());
		Double scaledHeight = Math.ceil(height * scale);

		if (scaledHeight <= n) {
			return "";
		} else if (height < scaledHeight && n != 1) {
			scaledHeight = scaledHeight % height;
			if (scaledHeight != 0) {
				n = n % scaledHeight.intValue();
			} else {
				n = n % height;
			}
		}

		int width = getWidth(e.toString());
		String retT = e.toString().substring(n * width, n * width + width - 1);
		String ret = "";
		Double end = Math.ceil((retT.length()) * scale);

		if (scale < 1.0) {
			ret = retT.substring(0, end.intValue());
		} else if (scale >= 1.0) {
			while (end >= retT.length() - 1) {
				end -= retT.length();
				ret += retT;
			}
			ret += retT.substring(0, end.intValue());
		}

		return ret;
	}

	/**
	 * returns the height of one object's string representation
	 * 
	 * @param e
	 *            object that is being examined
	 * @return number of lines
	 */
	private int getHeight(String t) {
		int ret = 1;

		for (int i = 0; i < t.length(); i++) {
			if (t.charAt(i) == '\n') {
				ret++;
			}
		}
		return ret;
	}

	/**
	 * returns the width of one object's string representation
	 * 
	 * @param e
	 *            object that is being examined
	 * @return number of chars in each line
	 */
	private int getWidth(String t) {
		int idx = t.indexOf('\n');
		return idx == -1 ? t.length() : idx + 1;
	}

	/**
	 * gets the maximum height of the string-representation of an item in the
	 * data-array
	 * 
	 * @return maximum height
	 */
	private int getMaxHeight() {
		int val;
		int max = 0;

		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[0].length; j++) {
				val = getHeight(data[i][j].toString());
				if (val > max) {
					max = val;
				}
			}
		}

		return max;
	}

	/**
	 * gets the maximum width of the string-representation of an item in the
	 * data-array
	 * 
	 * @return maximum width
	 */
	private int getMaxWidth() {
		int val;
		int max = 0;

		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[0].length; j++) {
				val = getWidth(data[i][j].toString());

				if (val > max) {
					max = val;
				}
			}
		}
		return max;
	}

	/**
	 * scales the size the grid itself
	 * 
	 * @param factor
	 */
	public void scale(double factor) {
		assert (0.1 <= factor && factor <= 10.0) : "invalid factor";

		scale = factor;

		// only useful if the objects are being scaled too
		// maxHeight *= scale;
		// maxWidth *= scale;
	}
}
