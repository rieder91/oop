package testing;

import finances.FinanceFilter;
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

public class FinanceTester implements Tester {
	
	private static final String moduleName = "Finances";
	
	// number of successful/failed tests
	private Integer successfulTests;
	private Integer failedTests;
	
	// the test case numbers of all failed tests
	private ArrayList<Integer> failedTestNumbers;
	
	private HashMap<Integer, String> testCases;
	
	public FinanceTester() {
		successfulTests = 0;
		failedTests = 0;
		
		failedTestNumbers = new ArrayList<Integer>();
		testCases = new HashMap<Integer, String>();
		
		testCases.put(1, "Total turnover and adding of finances");
		testCases.put(2, "Income of Events");
		testCases.put(3, "Expense of Events");
		testCases.put(4, "Turnover of Merchandise in a period");
		testCases.put(5, "Turnover of Merchandise in another period");
		testCases.put(6, "Turnover of Other in a period");
		testCases.put(7, "Filter with expense");
		testCases.put(8, "Filter with income");
		testCases.put(9, "Filter with expense and income");
		testCases.put(10, "Filter with expense, income and turnover");
		testCases.put(11, "Filter with turnover");
	}
	
	@Override
	public void printTestDescription() {
		System.out.println("Test cases for the " + moduleName + " module: ");
		for (Integer i : testCases.keySet()) {
			System.out.println("#" + ((i < 10) ? "0" + i : i) + ": " + testCases.get(i));
		}
		System.out.println();
	}

	@Override
	public void printTestResults() {
		System.out.println("Test results for the " + moduleName + " module: ");
		System.out.println("Successful tests: " + successfulTests);
		System.out.println("Failed tests: " + failedTests);

		if (!failedTestNumbers.isEmpty()) {
			System.out.println("The following test cases have failed: ");
			for (Integer i : failedTestNumbers) {
				System.out.println("#" + i + " " + testCases.get(i));
			}
		}
		System.out.println();
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public void runTests() {
		// Stuff needed for date parsing
		SimpleDateFormat formatTime = new SimpleDateFormat("dd.MM.yyyy HH:mm");
				
		Band rofl = new Band("ROFL-copter", "Metal");
		
		Gig novarock2010 = null, novarock2011 = null, novarock2012 = null;
		Rehearsal postNova2010 = null, postNova2011 = null;
		
		ArrayList<String> reasons = new ArrayList<String>();
		reasons.add("Other");
		reasons.add("Advertisement");
		
		FinanceFilter f1 = null,f2 = null,f3 = null,f4 = null,f5 = null;
		
		try {
			novarock2010 = new Gig(formatTime.parse("11.07.2010 12:00"),
					"Pannonia Fields II", 72, 2500.0);
			novarock2011 = new Gig(formatTime.parse("11.07.2011 13:00"),
					"Pannonia Fields II", 72, 5000.0);
			novarock2012 = new Gig(formatTime.parse("08.07.2012 14:00"),
					"Pannonia Fields II", 72, 10000.0);

			postNova2010 = new Rehearsal(formatTime.parse("15.08.2010 20:00"),
					"Vienna Sound Studio", 5, 100.0);
			postNova2011 = new Rehearsal(formatTime.parse("15.08.2011 20:00"),
					"Vienna Sound Studio Mk II", 7, 1000.0);
			
			f1 = new FinanceFilter(formatTime.parse("01.02.2010 20:00"),formatTime.parse("01.01.2012 20:00"),
					reasons,true,false,false);
			f2 = new FinanceFilter(formatTime.parse("01.02.2010 20:00"),formatTime.parse("01.01.2012 20:00"),
					reasons,false,true,false);
			f3 = new FinanceFilter(formatTime.parse("01.02.2010 20:00"),formatTime.parse("01.01.2012 20:00"),
					reasons,true,true,false);
			f4 = new FinanceFilter(formatTime.parse("01.02.2010 20:00"),formatTime.parse("01.01.2012 20:00"),
					reasons,true,true,true);
			f5 = new FinanceFilter(formatTime.parse("01.02.2010 20:00"),formatTime.parse("01.01.2012 20:00"),
					reasons,false,false,true);
			
		} catch (ParseException e) {
			System.out.println("Date parsing failed");
		}
		
		String s1 = "Expense of Other, Advertisement: -18000\n";
		String s2 = "Income of Other, Advertisement: 30000\n";
		String s3 = s2 + s1;
		String s5 = "Turnover of Other, Advertisement: 12000\n";
		String s4 = s2 + s1 + s5;
		
		try{
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
			
		} catch (InvalidBandObjectException e1) {
			e1.printStackTrace();
		} catch (ParseException e2) {
			e2.printStackTrace();
		}
		
		
		
		
		
		/*
		 * Test Case #1 Total turnover and adding of finances
		 * 
		 * should be: 18900
		 */
		
		if(Validator.check(rofl.totalTurnover(), new BigDecimal(18900), 1)){
			successfulTests++;
		} else {
			failedTests++;
			failedTestNumbers.add(1);
		}
		
		
		/*
		 * Test Case #2 Income of Events
		 * 
		 * should be: 17500
		 */
		
		if(Validator.check(rofl.totalEventIncome(), new BigDecimal(17500), 2)){
			successfulTests++;
		} else {
			failedTests++;
			failedTestNumbers.add(2);
		}
		
		
		/*
		 * Test Case #3 Expense of Events
		 * 
		 * should be: -1100
		 */
		
		if(Validator.check(rofl.totalEventExpense(), new BigDecimal(-1100), 3)){
			successfulTests++;
		} else {
			failedTests++;
			failedTestNumbers.add(3);
		}
		
		try{
			
			/*
			 * Test Case #4 Turnover of Merchandise in a period
			 * 
			 * should be: 10000
			 */
			
			if(Validator.check(rofl.getFinancesSinceUntilOf(formatTime.parse("01.01.2010 20:00"), formatTime.parse("01.01.2011 20:00"), "Merchandise"),
					new BigDecimal(10000), 4)){
				successfulTests++;
			} else {
				failedTests++;
				failedTestNumbers.add(4);
			}
			
			
			/*
			 * Test Case #5 Turnover of Merchandise in another period
			 * 
			 * should be: 16000
			 */
			
			if(Validator.check(rofl.getFinancesSinceUntilOf(formatTime.parse("01.01.2010 20:00"), formatTime.parse("01.01.2013 20:00"), "Merchandise"),
					new BigDecimal(16000), 5)){
				successfulTests++;
			} else {
				failedTests++;
				failedTestNumbers.add(5);
			}
			
			
			/*
			 * Test Case #6 Turnover of Other in a period
			 * 
			 * should be: -5000
			 */
			
			if(Validator.check(rofl.getFinancesSinceUntilOf(formatTime.parse("01.01.2010 20:00"), formatTime.parse("18.05.2012 20:00"), "Other"),
					new BigDecimal(-5000), 6)){
				successfulTests++;
			} else {
				failedTests++;
				failedTestNumbers.add(6);
			}
			
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		
		
		/*
		 * Test Case #7 Filter with expense
		 * 
		 * should be: "Expense of Other, Advertisement: -18000\n"
		 */
		
		if(Validator.check(rofl.getFinancesFiltered(f1), s1, 7)) {
			successfulTests++;
		} else {
			failedTests++;
			failedTestNumbers.add(7);
		}
		
		
		/*
		 * Test Case #8 Filter with income
		 * 
		 * should be: "Income of Other, Advertisement: 30000\n"
		 */
		
		if(Validator.check(rofl.getFinancesFiltered(f2), s2, 8)) {
			successfulTests++;
		} else {
			failedTests++;
			failedTestNumbers.add(8);
		}

		
		/*
		 * Test Case #9 Filter with expense and income
		 * 
		 * should be: "Expense of Other, Advertisement: -18000\nIncome of Other, Advertisement: 30000\n"
		 */
		
		if(Validator.check(rofl.getFinancesFiltered(f3), s3, 9)) {
			successfulTests++;
		} else {
			failedTests++;
			failedTestNumbers.add(9);
		}
		
		
		/*
		 * Test Case #10 Filter with expense, income and turnover
		 * 
		 * should be: "Expense of Other, Advertisement: -18000\nIncome of Other, Advertisement: 30000\nTurnover of Other, Advertisement: 12000\n"
		 */
		
		if(Validator.check(rofl.getFinancesFiltered(f4), s4, 10)) {
			successfulTests++;
		} else {
			failedTests++;
			failedTestNumbers.add(10);
		}

		
		/*
		 * Test Case #11 Filter with turnover
		 * 
		 * should be: "Turnover of Other, Advertisement: 12000\n"
		 */
		
		if(Validator.check(rofl.getFinancesFiltered(f5), s5, 11)) {
			successfulTests++;
		} else {
			failedTests++;
			failedTestNumbers.add(11);
		}
	}
}
