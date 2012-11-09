
public class PictHelper {

	/**
	 * returns the height of one object's string representation
	 * 
	 * @param e
	 *            object that is being examined
	 * @return number of lines
	 */
	public static int getHeight(String t) {
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
	public static int getWidth(String t) {
		int idx = t.indexOf('\n');
		return idx == -1 ? t.length() : idx + 1;
	}

	/**
	 * gets the maximum height of the string-representation of an item in the
	 * data-array
	 * 
	 * @return maximum height
	 */
	public static int getMaxHeight(Object data[][]) {
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
	public static int getMaxWidth(Object data[][]) {
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
	 * checks whether an object's string representation is shaped as a square
	 * @param s object that is being checked
	 * @return true if shaped like a square
	 */
	public static boolean isSquare(String s) {
		
		if(s.charAt(s.length() - 1) == '\n') {
			return false;
		}
		
		
		int h = getHeight(s);
		int newL = s.indexOf('\n');
		
		if(h == 1) {
			return true;
		} else if (s.replaceAll("\\n", "").length() % newL != 0) {
				return false;
		}
		
		return true;
	}

}
