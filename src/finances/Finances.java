
package finances;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.TreeMap;

/**
 * This class stores information for any kind of income and expense. It is used in the FinanceHandler class.
 * 
 * @author OOP Gruppe 187
 * 
 * GOOD: Names describe variables and methods well.
 * GOOD: weak object coupling
 * GOOD: high Klassenzusammenhalt
 */
public class Finances {

	/**
	 * all possible types of costs
	 * 
	 * @author OOP Gruppe 187
	 */
	public enum FinanceTypes {
		Income, Expense, Turnover
	}


	private TreeMap<Date, HashMap<String, BigDecimal>> income;

	private BigDecimal totalIncome;
	
	private TreeMap<Date, HashMap<String, BigDecimal>> expense;

	private BigDecimal totalExpense;
	
	/**
	 * Constructor without parameters
	 */
	public Finances() {

		this.income = new TreeMap<Date, HashMap<String, BigDecimal>>();
		this.totalIncome = new BigDecimal(0);

		this.expense = new TreeMap<Date, HashMap<String, BigDecimal>>();
		this.totalExpense = new BigDecimal(0);
	}

	/**
	 * adds income with specified information to finances and updates totalIncome
	 * 
	 * @param currentDate
	 *            date of entry (now)
	 * @param reason
	 *            short info why money was get or spent (i.e. "Merchandise" or "Advertisment")
	 * @param income
	 *            must be a positive value
	 *            
	 * PRECONDITION: the income must be positive
	 * PRECONDITION: the currentDate must not be null
	 */
	public void add(Date currentDate, String reason, BigDecimal income) {

		if (this.income.containsKey(currentDate)) {
			this.income.get(currentDate).put(reason, income);
		}
		else {
			HashMap<String, BigDecimal> hM = new HashMap<String, BigDecimal>();
			hM.put(reason, income);
			this.income.put(currentDate, hM);
		}
		this.totalIncome = this.totalIncome.add(income);
	}

	/**
	 * @return a TreeMap of current expense with its information
	 */
	public TreeMap<Date, HashMap<String, BigDecimal>> getExpense() {

		return this.expense;
	}

	/**
	 * @return a TreeMap of current income with its information
	 */
	public TreeMap<Date, HashMap<String, BigDecimal>> getIncome() {

		return this.income;
	}

	/**
	 * @return total expense since first entry
	 */
	public BigDecimal getTotalExpense() {

		return this.totalExpense;
	}

	/**
	 * @return total income since first entry
	 */
	public BigDecimal getTotalIncome() {

		return this.totalIncome;
	}

	/**
	 * adds expense with specified information to finances and updates totalExpense
	 * 
	 * @param currentDate
	 *            date of entry (now)
	 * @param reason
	 *            short info why money was get or spent (i.e. "Merchandise" or "Advertisment")
	 * @param expense
	 *            must be a negative value
	 *            
	 * PRECONDITION: the expense must be negative
	 * PRECONDITION: the currentDate must not be null
	 */
	public void subtract(Date currentDate, String reason, BigDecimal expense) {

		if (this.expense.containsKey(currentDate)) {
			this.expense.get(currentDate).put(reason, expense);
		}
		else {
			HashMap<String, BigDecimal> hM = new HashMap<String, BigDecimal>();
			hM.put(reason, expense);
			this.expense.put(currentDate, hM);
		}
		this.totalExpense = this.totalExpense.add(expense);
	}

	/**
	 * @return turnover of all entries
	 */
	public BigDecimal turnover() {

		return this.totalIncome.add(this.totalExpense);
	}
}
