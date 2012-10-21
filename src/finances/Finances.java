package finances;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.TreeMap;

/**
 * This class stores information for any kind of income and expense.
 * It is used in the FinanceHandler class.
 * 
 * @author OOP Gruppe 187
 *
 */
public class Finances {
	
	// income
	private TreeMap<Date,HashMap<String,BigDecimal>> income;
	private BigDecimal totalIncome;
	
	// expense
	private TreeMap<Date,HashMap<String,BigDecimal>> expense;
	private BigDecimal totalExpense;
	
	/**
	 * all possible types of costs
	 * @author OOP Gruppe 187
	 *
	 */
	public enum FinanceTypes {
		Income,
		Expense,
		Turnover
	}
	
	/**
	 * Constructor without parameters
	 */
	public Finances() {
		this.income = new TreeMap<Date,HashMap<String,BigDecimal>>();
		this.totalIncome = new BigDecimal(0);
		
		this.expense = new TreeMap<Date,HashMap<String,BigDecimal>>();
		this.totalExpense = new BigDecimal(0);
	}
	
	/**
	 * adds income with its information
	 * 
	 * @param currentDate
	 * 			date of entry
	 * @param reason
	 * 			short info why money was get or spent (i.e. "Merchandise" or "Advertisment")
	 * @param income
	 * 			positive value
	 */
	public void add(Date currentDate, String reason, BigDecimal income) {
		if(this.income.containsKey(currentDate)) {
			this.income.get(currentDate).put(reason, income);
		} else {
			HashMap<String,BigDecimal> hM = new HashMap<String,BigDecimal>();
			hM.put(reason, income);
			this.income.put(currentDate, hM);
		}
		this.totalIncome = this.totalIncome.add(income);
	}
	
	/**
	 * adds expense with its information
	 * 
	 * @param currentDate
	 * 			date of entry
	 * @param reason
	 * 			short info why money was get or spent (i.e. "Merchandise" or "Advertisment")
	 * @param expense
	 * 			negative value
	 */
	public void subtract(Date currentDate, String reason, BigDecimal expense) {
		if(this.expense.containsKey(currentDate)) {
			this.expense.get(currentDate).put(reason, expense);
		} else {
			HashMap<String,BigDecimal> hM = new HashMap<String,BigDecimal>();
			hM.put(reason, expense);
			this.expense.put(currentDate, hM);
		}
		this.totalExpense = this.totalExpense.add(expense);
	}
	
	/**
	 * 
	 * @return
	 * 			turnover of all entries
	 */
	public BigDecimal turnover() {
		return this.totalIncome.add(this.totalExpense);
	}

	/**
	 * 
	 * @return
	 * 			a TreeMap of current income with its information
	 */
	public TreeMap<Date, HashMap<String, BigDecimal>> getIncome() {
		return income;
	}

	/**
	 * 
	 * @return
	 * 			total income since first entry
	 */
	public BigDecimal getTotalIncome() {
		return totalIncome;
	}

	/**
	 * 
	 * @return
	 * 			a TreeMap of current expense with its information
	 */
	public TreeMap<Date, HashMap<String, BigDecimal>> getExpense() {
		return expense;
	}

	/**
	 * 
	 * @return
	 * 			total expense since first entry
	 */
	public BigDecimal getTotalExpense() {
		return totalExpense;
	}
}
