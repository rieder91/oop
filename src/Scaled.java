import java.util.ArrayList;

/**
 * as this class uses the scale-method which all classes that implement Pict
 * must have definied, the generic type of the class must extend Pict
 * 
 * As there was no indication that the internal representation of the
 * Pictogramms had to be an two-dimensional array (as with Repeated) we used an
 * arraylist due to it's type-safety [generic arrays are not possible in java]
 * 
 * @author OOP Gruppe 187
 * 
 */

public class Scaled<P extends Pict> {
	final private ArrayList<P> data;

	/**
	 * constructor which takes an array of pictograms; only used to make
	 * debugging easier
	 * 
	 * @param data
	 *            array with all the values
	 */
	public Scaled(P data[]) {
		assert (data != null) : "array cant be null";

		this.data = new ArrayList<P>();

		for (int i = 0; i < data.length; i++) {
			assert (data[i] != null) : "array-element should not be null";
			this.data.add(data[i]);
		}
	}

	/**
	 * constructor which takes an arraylist as an argument
	 * 
	 * @param l
	 *            arraylist with the pictogramms
	 */
	public Scaled(ArrayList<P> l) {
		data = new ArrayList<P>(l);
	}

	/**
	 * scales the size of each box by calling their scale-method
	 * 
	 * @param factor
	 */
	public void scale(double factor) {
		assert (0.1 <= factor && factor <= 10.0) : "invalid factor";

		for (P e : data) {
			e.scale(factor);
		}
	}

	/**
	 * returns a string-list of all boxes
	 * 
	 * @return string-representation
	 */
	public String toString() {
		StringBuilder ret = new StringBuilder();

		for (P e : data) {
			ret.append(e + "\n");
		}

		return ret.toString();
	}

}
