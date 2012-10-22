
package helper;

import java.util.ArrayList;

/**
 * A class which is meant to make running test cases easier. In my opinion it makes the Test-class more readable.
 * Compared to static methods in the test-class itself, this class is more portable
 * 
 * @author OOP Gruppe 187
 */
public class Validator {

	private static Integer successfulCount = 0;
	private static Integer overallCount = 0;

	/**
	 * adds a number of test cases
	 * 
	 * @param n
	 *            count of test cases
	 */
	public static void addTests(Integer n) {

		if (n >= 0) {
			overallCount += n;
		}
	}

	/**
	 * @param a
	 *            first param to be compared
	 * @param b
	 *            second param to be compared
	 * @param caseNum
	 *            number of the test case
	 * @return true of the params are equal
	 */
	public static <T> boolean check(ArrayList<T> a, ArrayList<T> b, Integer caseNum) {

		for (T object : a) {
			if (!b.contains(object)) { return false; }
		}
		successfulCount++;
		return true;
	}

	/**
	 * @param a
	 *            first param to be compared
	 * @param b
	 *            second param to be compared
	 * @param caseNum
	 *            number of the test case
	 * @return true of the params are equal
	 */
	public static <T> boolean check(T a, T b, Integer caseNum) {

		if (a.equals(b)) {
			successfulCount++;
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * prints the test-case overview to stdout
	 */
	public static void report() {

		System.out.println("\nOverall successful tests: " + successfulCount);
		System.out.println("Overall failed tests: " + (overallCount - successfulCount));
	}

	/**
	 * @param status
	 *            true if successful test; false otherwise
	 */
	public static void report(boolean status) {

		if (status) {
			successfulCount++;
		}
	}
}
