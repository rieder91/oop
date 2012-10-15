package assignment1;

import java.math.BigDecimal;

public class Validator {
	public static boolean check(BigDecimal a, BigDecimal b, Integer caseNum) {
		if(a.equals(b)) {
			System.out.println("Test case #" + caseNum + " successful");
			return true;
		} else {
			System.out.println("Test case #" + caseNum + " failed");
			return false;
		}
	}

}
