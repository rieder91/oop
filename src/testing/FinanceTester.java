
package testing;

import finances.FinanceFilter;
import finances.Finances.FinanceTypes;
import helper.InvalidBandObjectException;
import helper.Validator;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import band.Band;
import band.Gig;
import band.Rehearsal;

/**
 * test-class for finance-requirements
 * 
 * @author OOP Gruppe 187
 */
public class FinanceTester implements Tester {

	private static final String moduleName = "Finances";

	private Integer successfulTests;
	private Integer overallTests;
	//successfulTests >= 0; overallTests >= 0

	private ArrayList<Integer> failedTestNumbers;

	private HashMap<Integer, String> testCases;

	public FinanceTester() {

		this.successfulTests = 0;

		this.failedTestNumbers = new ArrayList<Integer>();
		this.testCases = new HashMap<Integer, String>();

		this.testCases.put(1, "Total turnover and adding of finances");
		this.testCases.put(2, "Income of Events");
		this.testCases.put(3, "Expense of Events");
		this.testCases.put(4, "Turnover of Merchandise in a period");
		this.testCases.put(5, "Turnover of Merchandise in another period");
		this.testCases.put(6, "Turnover of Other in a period");
		this.testCases.put(7, "Filter with expense");
		this.testCases.put(8, "Filter with income");
		this.testCases.put(9, "Filter with expense and income");
		this.testCases.put(10, "Filter with expense, income and turnover");
		this.testCases.put(11, "Filter with turnover");

		this.overallTests = this.testCases.size();
		Validator.addTests(this.overallTests);
	}

	/**
	 * a description of the finance test module is displayed
	 * should be the first method to be called
	 */
	@Override
	public void printTestDescription() {

		System.out.println("Test cases for the " + moduleName + " module: ");
		for (Integer i : this.testCases.keySet()) {
			System.out.println("#" + (i < 10 ? "0" + i : i) + ": " + this.testCases.get(i));
		}
		System.out.println();
	}
	
	/**
	 * the results of the finance test module is displayed
	 * must be called after method runTests()
	 */
	@Override
	public void printTestResults() {

		System.out.println("Test results for the " + moduleName + " module: ");
		System.out.println("Successful tests: " + this.successfulTests);
		System.out.println("Failed tests: " + (this.overallTests - this.successfulTests));

		if (!this.failedTestNumbers.isEmpty()) {
			System.out.println("The following test cases have failed: ");
			for (Integer i : this.failedTestNumbers) {
				System.out.println("#" + i + " " + this.testCases.get(i));
			}
		}
		System.out.println();
	}

	/**
	 * run through various test cases of the finance module
	 * must be called before method printTestResults()
	 */
	@SuppressWarnings("deprecation")
	@Override
	public void runTests() {

		SimpleDateFormat formatTime = new SimpleDateFormat("dd.MM.yyyy HH:mm");

		Band rofl = new Band("ROFL-copter", "Metal");

		Gig novarock2010 = null, novarock2011 = null, novarock2012 = null;
		Rehearsal postNova2010 = null, postNova2011 = null;

		ArrayList<String> reasons = new ArrayList<String>();
		reasons.add("Other");
		reasons.add("Advertisement");

		FinanceFilter f1 = null, f2 = null, f3 = null, f4 = null, f5 = null;

		try {
			novarock2010 = new Gig(formatTime.parse("11.07.2010 12:00"), "Pannonia Fields II", 72, 2500.0);
			novarock2011 = new Gig(formatTime.parse("11.07.2011 13:00"), "Pannonia Fields II", 72, 5000.0);
			novarock2012 = new Gig(formatTime.parse("08.07.2012 14:00"), "Pannonia Fields II", 72, 10000.0);

			postNova2010 = new Rehearsal(formatTime.parse("15.08.2010 20:00"), "Vienna Sound Studio", 5, 100.0);
			postNova2011 = new Rehearsal(formatTime.parse("15.08.2011 20:00"), "Vienna Sound Studio Mk II", 7, 1000.0);

			f1 = new FinanceFilter(formatTime.parse("01.02.2010 20:00"), formatTime.parse("01.01.2012 20:00"), reasons,
					true, false, false);
			f2 = new FinanceFilter(formatTime.parse("01.02.2010 20:00"), formatTime.parse("01.01.2012 20:00"), reasons,
					false, true, false);
			f3 = new FinanceFilter(formatTime.parse("01.02.2010 20:00"), formatTime.parse("01.01.2012 20:00"), reasons,
					true, true, false);
			f4 = new FinanceFilter(formatTime.parse("01.02.2010 20:00"), formatTime.parse("01.01.2012 20:00"), reasons,
					true, true, true);
			f5 = new FinanceFilter(formatTime.parse("01.02.2010 20:00"), formatTime.parse("01.01.2012 20:00"), reasons,
					false, false, true);

		}
		catch (ParseException e) {
			System.out.println("Date parsing failed");
		}

		HashMap<FinanceTypes, BigDecimal> s1 = new HashMap<FinanceTypes, BigDecimal>();
		HashMap<FinanceTypes, BigDecimal> s2 = new HashMap<FinanceTypes, BigDecimal>();
		HashMap<FinanceTypes, BigDecimal> s3 = new HashMap<FinanceTypes, BigDecimal>();
		HashMap<FinanceTypes, BigDecimal> s4 = new HashMap<FinanceTypes, BigDecimal>();
		HashMap<FinanceTypes, BigDecimal> s5 = new HashMap<FinanceTypes, BigDecimal>();

		s1.put(FinanceTypes.Expense, new BigDecimal(-18000));
		s2.put(FinanceTypes.Income, new BigDecimal(30000));
		s3.put(FinanceTypes.Expense, new BigDecimal(-18000));
		s3.put(FinanceTypes.Income, new BigDecimal(30000));
		s4.put(FinanceTypes.Turnover, new BigDecimal(12000));
		s5.put(FinanceTypes.Expense, new BigDecimal(-18000));
		s5.put(FinanceTypes.Income, new BigDecimal(30000));
		s5.put(FinanceTypes.Turnover, new BigDecimal(12000));

		try {
			rofl.addEvent(novarock2010);
			rofl.addEvent(novarock2011);
			rofl.addEvent(novarock2012);
			rofl.addEvent(postNova2010);
			rofl.addEvent(postNova2011);

			rofl.addFinance(formatTime.parse("01.01.2010 20:00"), "Merchandise", new BigDecimal(10000.0));
			rofl.addFinance(formatTime.parse("09.02.2010 20:00"), "Other", new BigDecimal(5000.0));
			rofl.addFinance(formatTime.parse("21.11.2012 20:00"), "Merchandise", new BigDecimal(6000.0));
			rofl.addFinance(formatTime.parse("01.03.2010 20:00"), "Advertisement", new BigDecimal(-10000.0));
			rofl.addFinance(formatTime.parse("01.08.2011 20:00"), "Advertisement", new BigDecimal(-3000.0));
			rofl.addFinance(formatTime.parse("18.08.2010 20:00"), "Other", new BigDecimal(25000.0));
			rofl.addFinance(formatTime.parse("18.05.2012 20:00"), "Other", new BigDecimal(-30000.0));
			rofl.addFinance(formatTime.parse("18.08.2012 20:00"), "Other", new BigDecimal(4500.0));
			rofl.addFinance(formatTime.parse("18.08.2011 20:00"), "Other", new BigDecimal(-5000.0));

		}
		catch (InvalidBandObjectException e1) {
			e1.printStackTrace();
		}
		catch (ParseException e2) {
			e2.printStackTrace();
		}


		if (Validator.check(rofl.totalTurnover(), new BigDecimal(18900), 1)) {
			this.successfulTests++;
		}
		else {

			this.failedTestNumbers.add(1);
		}


		if (Validator.check(rofl.totalEventIncome(), new BigDecimal(17500), 2)) {
			this.successfulTests++;
		}
		else {

			this.failedTestNumbers.add(2);
		}


		if (Validator.check(rofl.totalEventExpense(), new BigDecimal(-1100), 3)) {
			this.successfulTests++;
		}
		else {

			this.failedTestNumbers.add(3);
		}

		try {


			if (Validator.check(
					rofl.getFinancesSinceUntilOf(formatTime.parse("01.01.2010 20:00"),
							formatTime.parse("01.01.2011 20:00"), "Merchandise"), new BigDecimal(10000), 4)) {
				this.successfulTests++;
			}
			else {

				this.failedTestNumbers.add(4);
			}


			if (Validator.check(
					rofl.getFinancesSinceUntilOf(formatTime.parse("01.01.2010 20:00"),
							formatTime.parse("01.01.2013 20:00"), "Merchandise"), new BigDecimal(16000), 5)) {
				this.successfulTests++;
			}
			else {

				this.failedTestNumbers.add(5);
			}


			if (Validator.check(
					rofl.getFinancesSinceUntilOf(formatTime.parse("01.01.2010 20:00"),
							formatTime.parse("18.05.2012 20:00"), "Other"), new BigDecimal(-5000), 6)) {
				this.successfulTests++;
			}
			else {

				this.failedTestNumbers.add(6);
			}

		}
		catch (ParseException e1) {
			e1.printStackTrace();
		}


		if (Validator.check(rofl.getFinancesFiltered(f1), s1, 7)) {
			this.successfulTests++;
		}
		else {

			this.failedTestNumbers.add(7);
		}


		if (Validator.check(rofl.getFinancesFiltered(f2), s2, 8)) {
			this.successfulTests++;
		}
		else {

			this.failedTestNumbers.add(8);
		}


		if (Validator.check(rofl.getFinancesFiltered(f3), s3, 9)) {
			this.successfulTests++;
		}
		else {

			this.failedTestNumbers.add(9);
		}


		if (Validator.check(rofl.getFinancesFiltered(f4), s5, 10)) {
			this.successfulTests++;
		}
		else {

			this.failedTestNumbers.add(10);
		}


		if (Validator.check(rofl.getFinancesFiltered(f5), s4, 11)) {
			this.successfulTests++;
		}
		else {

			this.failedTestNumbers.add(11);
		}
	}
}
