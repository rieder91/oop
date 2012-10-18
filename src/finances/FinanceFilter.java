package finances;

import java.util.ArrayList;
import java.util.Date;

/**
 * This class implements a filter for enhanced search in finances.
 * 
 * @author OOP Gruppe 187
 *
 */
public class FinanceFilter {
	
	private ArrayList<String> reason;
	private Date startDate;
	private Date endDate;
	private boolean expense;
	private boolean income;
	private boolean total;
	
	/**
	 * Constructor with three parameters (reason is empty by default)
	 * 
	 * @param expense
	 * 				true if expense should be used
	 * @param income
	 * 				true if income should be used
	 * @param total
	 * 				true if turnover should be used
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
	 * Constructor with four parameters
	 * 
	 * @param reason
	 * 				an ArrayList with information for filtering
	 * @param expense
	 * 				true if expense should be used
	 * @param income
	 * 				true if income should be used
	 * @param total
	 * 				true if turnover should be used
	 */
	public FinanceFilter(Date startDate, Date endDate, ArrayList<String> reason, boolean expense, boolean income, boolean total) {
		this.startDate = startDate;
		this.endDate = endDate;
		this.reason = reason;
		this.expense = expense;
		this.income = income;
		this.total = total;
	}
	
	/**
	 * @reason will be added to ArrayList if it wasn't already
	 * 
	 * @param reason
	 * 				reason to be added
	 */
	public void addReason(String reason) {
		if (!this.reason.contains(reason))
			this.reason.add(reason);
	}
	
	/**
	 * 
	 * @return
	 * 				ArrayList with reasons
	 */
	public ArrayList<String> getReason() {
		return this.reason;
	}

	/**
	 * 
	 * @return
	 * 				true if expense shall be used
	 */
	public boolean isExpense() {
		return expense;
	}

	/**
	 * 
	 * @return
	 * 				true if income shall be used
	 */
	public boolean isIncome() {
		return income;
	}

	/**
	 * 
	 * @return
	 * 				true if total turnover shall be used
	 */
	public boolean isTotal() {
		return total;
	}

	public Date getStartDate() {
		return startDate;
	}

	public Date getEndDate() {
		return endDate;
	}
	
}
