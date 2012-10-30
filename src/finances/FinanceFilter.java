
package finances;

import java.util.ArrayList;
import java.util.Date;

/**
 * This class implements a filter for enhanced search in finances.
 * 
 * @author OOP Gruppe 187
 * 
 * GOOD: Names describe variables and methods well and if a variable is removed,
 * 		 something important would be missing.
 * 
 * BAD: low Klassenzusammenhalt due to duplicate constructors
 */
public class FinanceFilter {

	private ArrayList<String> reason;
	private Date startDate;
	private Date endDate;
	private boolean expense;
	private boolean income;
	private boolean total;

	/**
	 * Constructor with six parameters.
	 * At least one of expense, income and total should be true.
	 * 
	 * @param startDate
	 * 				start of search-period (before or equal endDate)
	 * @param endDate
	 * 				end of search-period (after or equal startDate)
	 * @param reason
	 *            	an ArrayList with information for filtering
	 * @param expense
	 *            	true if expense should be used, otherwise false
	 * @param income
	 *            	true if income should be used, otherwise false
	 * @param total
	 *            	true if turnover should be used, otherwise false
	 *            
	 * PRECONDITION: the startDate must be BEFORE the endDate
	 */
	public FinanceFilter(Date startDate, Date endDate, ArrayList<String> reason, boolean expense, boolean income,
			boolean total) {

		this.startDate = startDate;
		this.endDate = endDate;
		this.reason = reason;
		this.expense = expense;
		this.income = income;
		this.total = total;
	}

	/**
	 * Constructor with three parameters (reason is empty by default).
	 * At least one of expense, income and total should be true.
	 * 
	 * @param startDate
	 * 				start of search-period (before or equal endDate)
	 * @param endDate
	 * 				end of search-period (after or equal startDate)
	 * @param expense
	 *            true if expense should be used, otherwise false
	 * @param income
	 *            true if income should be used, otherwise false
	 * @param total
	 *            true if turnover should be used, otherwise false
	 *            
	 * PRECONDITION: the startDate must be BEFORE the endDate
	 */
	public FinanceFilter(Date startDate, Date endDate, boolean expense, boolean income, boolean total) {

		this.startDate = startDate;
		this.endDate = endDate;
		this.reason = new ArrayList<String>();
		this.expense = expense;
		this.income = income;
		this.total = total;
	}

	/**
	 * @reason will be added to ArrayList if it wasn't already
	 * @param reason
	 *            reason to be added
	 *            
	 * PRECONDITION: reason must not be null
	 */
	public void addReason(String reason) {

		if (!this.reason.contains(reason)) {
			this.reason.add(reason);
		}
	}

	/**
	 * @return end date of the filter
	 */
	public Date getEndDate() {

		return this.endDate;
	}

	/**
	 * @return ArrayList with reasons
	 */
	public ArrayList<String> getReason() {

		return this.reason;
	}

	/**
	 * @return start date of the filter
	 */
	public Date getStartDate() {

		return this.startDate;
	}

	/**
	 * @return true if expense shall be used, otherwise false
	 */
	public boolean isExpense() {

		return this.expense;
	}

	/**
	 * @return true if income shall be used, otherwise false
	 */
	public boolean isIncome() {

		return this.income;
	}

	/**
	 * @return true if total turnover shall be used, otherwise false
	 */
	public boolean isTotal() {

		return this.total;
	}

}
