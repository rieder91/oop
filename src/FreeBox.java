/**
 * this class is the box with the loosest conditions and extends repeated as
 * it has the same scaling-behaviour
 * 
 * a freebox is a character-grid
 * 
 * @author OOP Gruppe 187
 * 
 */
public class FreeBox extends Repeated<Character> {
	private String boxText;
	
	protected Double height;
	protected Double width;
	
	protected FreeBox() {
		
	}

	/**
	 * constructors which takes the contents of the box as an arguments
	 * and calculates the height and width
	 * @param boxText content of the box
	 */
	public FreeBox(String boxText) {
		assert(!"".equals(boxText)) : "FreeBox-Text cannot be empty!";
		
		this.boxText = boxText;
		this.width = new Double(extractWidth(boxText));
		this.height = new Double(extractHeight(boxText));
	}
	
	/**
	 * returns the string-representation of the box; height and width are
	 * calculated using ceiling; when scaling the contents of the box are
	 * repeated
	 * 
	 * @return string-representation
	 */
	public String toString() {
		StringBuilder ret = new StringBuilder();
		
		String line, sanatizedText;
		sanatizedText = boxText.replaceAll("\\n", "");
	
		int h = (int) Math.ceil(height);
		int w = (int) Math.ceil(width);
		
		int textW = extractWidth(boxText).intValue();
		int textH = extractHeight(boxText).intValue();
		
		for(int i = 0; i < h; i++) {
			line = sanatizedText.substring((i % textH) * textW, (i % textH) * textW + textW);
			for(int j = 0; j < w; j++) {
				ret.append(line.charAt(j % textW));
			}
			if(i != (h - 1)) {
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
	 * returns the "height" of a given string (the number of lines it occupies
	 * when printed)
	 * @param s string that is being examined
	 * @return the number of lines
	 */
	public Integer extractHeight(String s) {
		Integer index = 1;
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == '\n') {
				index++;
			}
		}
		
		return index;
	}
	
	/** 
	 * returns the number of chars each line of a string has
	 * @param s string that is being examined
	 * @return number of chars in each line
	 */
	public Integer extractWidth(String s) {
		Integer idx = s.indexOf('\n');
		return idx == -1 ? s.length() : idx;
	}
	
}
