/**
 * Pictogram interface as per Assignment
 * @author OOP Gruppe 187
 *
 */

public interface Pict {
	// instances represent 2-dimensional pictures
	// consisting of printable characters
	String toString();

	// returns the picture as String
	void scale(double factor);
	// 0.1 <= factor <= 10.0; resize the picture
}