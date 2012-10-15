package assignment1;

import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * A class which is meant to make running test cases easier. In my opinion it
 * makes the Test-class more readable. Compared to static methods in the
 * test-class itself, this class is more portable
 * 
 * @author OOP Gruppe 187
 * 
 */
public class Validator {
	static Integer successfulCount = 0;
	static Integer failedCount = 0;

	/**
	 * 
	 * @param a
	 * @param b
	 * @param caseNum
	 * @return
	 */
	public static boolean check(BigDecimal a, BigDecimal b, Integer caseNum) {
		if (a.equals(b)) {
			System.out.println("Test case #"
					+ ((caseNum <= 9) ? ("0" + caseNum) : caseNum)
					+ " successful");
			successfulCount++;
			return true;
		} else {
			System.out.println("Test case #"
					+ ((caseNum <= 9) ? ("0" + caseNum) : caseNum) + " failed");
			failedCount++;
			return false;
		}
	}

	/**
	 * 
	 * @param a
	 * @param b
	 * @param caseNum
	 * @return
	 */
	public static <T> boolean check(ArrayList<T> a, ArrayList<T> b,
			Integer caseNum) {
		for (T object : a) {
			if (!b.contains(object)) {
				System.out.println("Test case #"
						+ ((caseNum <= 9) ? ("0" + caseNum) : caseNum)
						+ " failed");
				failedCount++;
				return false;
			}
		}
		System.out.println("Test case #"
				+ ((caseNum <= 9) ? ("0" + caseNum) : caseNum) + " successful");
		successfulCount++;
		return true;
	}

	/**
	 * 
	 * @param status
	 *            true if successful test; false otherwise
	 * @param caseNum
	 *            the number of the test case for debugging purposes
	 */
	public static void report(boolean status, Integer caseNum) {
		if (status) {
			System.out.println("Test case #"
					+ ((caseNum <= 9) ? ("0" + caseNum) : caseNum)
					+ " successful");
			successfulCount++;
		} else {
			System.out.println("Test case #"
					+ ((caseNum <= 9) ? ("0" + caseNum) : caseNum) + " failed");
			failedCount++;
		}
	}

	/**
	 * prints the test-case overview to stdout
	 */
	public static void report() {
		System.out.println("\nNumber of successful tests: " + successfulCount);
		System.out.println("Number of failed tests: " + failedCount);
	}
}
