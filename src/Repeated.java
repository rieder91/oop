/**
 * a grid of the string-representations of an object-array
 * @author OOP Gruppe 187
 * 
 */

public class Repeated<P> implements Pict {
	// </3 array that cant be generic
	private Object data[][];
	private Double scale;
	
	private int maxHeight;
	private int maxWidth;

	/** 
	 * empty constructor for inheritance req.
	 */
	protected Repeated() {

	}
	
	/**
	 * constructors which deconstructs a string into an array
	 * @param s string that is deconstructed
	 */
	protected Repeated(String s) {
		assert(s != "") : "string cant be null";
		assert(PictHelper.isSquare(s)) : "string has to be square!";
		
		int h = PictHelper.getHeight(s);
		int w = PictHelper.getWidth(s) - 1;
		
		this.data = new Character[h][w];
		s = s.replaceAll("\\n", "");
		
		for(int i = 0; i < h; i++) {
			for(int j = 0; j < w; j++) {
				this.data[i][j] = s.charAt(i * w + j);
			}
		}
		
		this.scale = 1.0;
		this.maxHeight = 1;
		this.maxWidth = 1;
		
	}

	/**
	 * constructor which takes an object array
	 * 
	 * @param data
	 *            object array
	 */
	public Repeated(P data[][]) {
		assert (data != null) : "array cant be null";
		assert (data[0] != null) : "array cant be null";
		
		if(data == null || data[0] == null) {
			throw new IllegalArgumentException("array cant be null");
		}

		this.data = new Object[data.length][data[0].length];

		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[0].length; j++) {
				assert (data[i][j] != null) : "array-element cannot be null";
				assert (PictHelper.isSquare(data[i][j].toString()));
				
				if(data[i][j] == null) {
					throw new RuntimeException("the array element cannot be null");
				}
				
				this.data[i][j] = data[i][j];
			}
		}

		maxHeight = PictHelper.getMaxHeight(this.data);
		maxWidth = PictHelper.getMaxWidth(this.data);

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
		
		int correction = maxWidth == 1 ? 0 : 1;

		if (scale < 1.0) {
			int lastHeight = (int) Math.ceil(maxHeight * scale * data.length);
			int lastWidth = (int) Math.ceil((maxWidth - correction) * scale
					* data[0].length);
			String text = ret.toString();

			for (int i = 0; i < lastHeight; i++) {
				ret2.append(getLine(text, i).substring(0, lastWidth) + "\n");
			}

			ret = ret2;

		} else if (scale > 1.0) {

			String text = ret.toString();
			int lastHeight = (int) Math.ceil(maxHeight * scale * data.length);
			int lastWidth = (int) Math.ceil((maxWidth - correction) * scale
					* data[0].length);
			int currentWidth = PictHelper.getWidth(ret.toString()) - 1;
			int numLines = PictHelper.getHeight(ret.toString());

			for (int i = 0; i < lastHeight; i++) {

				String newLine = getLine(text, i % numLines);

				for (int j = 0; j < lastWidth; j++) {
					ret2.append(newLine.charAt(j % (currentWidth)));
				}
				if (i + 1 != lastHeight) {
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
	public static String getLine(String e, int n) {
		int h = PictHelper.getHeight(e);
		int width = PictHelper.getWidth(e.toString());

		if (h <= n) {
			return "";
		} else if (h == 1) {
			return e;
		}

		return e.toString().substring(n * width, n * width + width - 1);

	}

	/**
	 * scales the size the grid itself
	 * 
	 * @param factor
	 */
	public void scale(double factor) {
		assert (0.1 <= factor && factor <= 10.0) : "invalid factor";
		
		if(factor < 0.1 || factor > 10.0) {
			throw new IllegalArgumentException("illegal factor");
		}

		scale = factor;

	}
	
	/**
	 * getter for the data-array
	 * @return data-array
	 */
	public Object[][] getData() {
		return data;
	}

}
