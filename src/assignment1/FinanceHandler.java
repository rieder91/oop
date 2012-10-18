package assignment1;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;

/**
 * A finance handler for any kind of income or expense.
 * It uses the Finances class to store information for any kind of
 * income and expense and provides methods to search for them.
 * 
 * @author OOP Gruppe 187
 *
 */
public class FinanceHandler {
	
	private Finances fin;	
	
	/**
	 * Constructor without parameters
	 */
	public FinanceHandler() {
		this.fin = new Finances();
	}
	
	/**
	 * the method adds positive @money to income and negative to expense.
	 * if @money is zero, nothing will be done.
	 * 
	 * @param currentDate
	 * 				date of entry
	 * @param reason
	 * 				short info why money was get or spent (i.e. "Merchandise" or "Advertisment")
	 * @param money
	 * 				income if positive, expense if negative
	 */
	public void addFinance(Date currentDate, String reason, BigDecimal money) {
		if(money.signum() == 1) {
			fin.add(currentDate, reason, money);
		} else if(money.signum() == -1) {
			fin.subtract(currentDate, reason, money);
		}
	}
	
	/**
	 * total turnover of events and others since first entry of a band
	 * 
	 * @param b
	 * 			band object where the handler is used to get finances of their events
	 * @return
	 * 			total turnover
	 */
	public BigDecimal totalTurnover(Band b) {
		BigDecimal eventTurnover = new BigDecimal(0);
		for (Event e : b.getEvents()) {
			eventTurnover.add(e.getFinances());
		}
		return eventTurnover.add(fin.turnover());
	}
	
	/**
	 * total income of events since first entry of a band
	 * 
	 * @param b
	 * 			band object where the handler is used to get finances of their events
	 * @return
	 * 			total income of events
	 */
	public BigDecimal totalEventIncome(Band b) {
		BigDecimal ret = new BigDecimal(0);
		for (Event e : b.getEvents()) {
			if (e.getFinances().signum() == 1)
				ret.add(e.getFinances());
		}
		return ret;
	}
	
	/**
	 * total expense of events since first entry of a band
	 * 
	 * @param b
	 * 			band object where the handler is used to get finances of their events
	 * @return
	 * 			total expense of events
	 */
	public BigDecimal totalEventExpense(Band b) {
		BigDecimal ret = new BigDecimal(0);
		for (Event e : b.getEvents()) {
			if (e.getFinances().signum() == -1)
				ret.add(e.getFinances());
		}
		return ret;
	}
	
	/**
	 * the turnover of a specified reason in a period
	 * 
	 * @param startDate
	 * 			first date of a period
	 * @param endDate
	 * 			end date of a period
	 * @param reason
	 * 			short info why money was get or spent (i.e. "Merchandise" or "Advertisment")
	 * @return
	 * 			total finances of @reason, 0 if no entries where found
	 */
	public BigDecimal getFinancesSinceToOf(Date startDate, Date endDate, String reason) {
		BigDecimal ret = new BigDecimal(0);
		for (Date d : fin.getIncome().keySet()) {
			if(endDate.after(d)) {
				break;
			}
			if (startDate.after(d) || startDate.equals(d)) {
				if (fin.getIncome().get(d).containsKey(reason)) {
					ret.add(fin.getIncome().get(d).get(reason));
				}
			}
		}
		for (Date d : fin.getExpense().keySet()) {
			if(endDate.after(d)) {
				break;
			}
			if (startDate.after(d) || startDate.equals(d)) {
				if (fin.getExpense().get(d).containsKey(reason)) {
					ret.add(fin.getExpense().get(d).get(reason));
				}
			}
		}
		return ret;
	}
	
	/**
	 * with the use of a filter it is possible to get income/expense/total
	 * of various reasons in a specified period at once
	 * 
	 * @param f
	 * 			a filter used for enhanced search
	 * @return
	 * 			a string with the specified filter information
	 */
	public String getFinancesSinceTo(FinanceFilter f) {
		BigDecimal tmp;
		BigDecimal total = new BigDecimal(0);
		String retS = new String();
		String reasons = listReason(f.getReason());
		Date startDate = f.getStartDate();
		Date endDate = f.getEndDate();
		
		tmp = new BigDecimal(0);
		for (Date d : fin.getIncome().keySet()) {
			if(endDate.after(d)) {
				break;
			}
			if (startDate.after(d) || startDate.equals(d)) {
				for (String s : f.getReason()){
					if (fin.getIncome().get(d).containsKey(s)) {
						tmp.add(fin.getIncome().get(d).get(s));
					}
				}
			}
		}
		if (f.isIncome()) {
			retS += "Income of ";
			retS += reasons;
			retS += tmp.toString() + "\n";
		}
		total.add(tmp);
		
		tmp = new BigDecimal(0);
		for (Date d : fin.getExpense().keySet()) {
			if(endDate.after(d)) {
				break;
			}
			if (startDate.after(d) || startDate.equals(d)) {
				for (String s : f.getReason()){
					if (fin.getExpense().get(d).containsKey(s)) {
						tmp.add(fin.getExpense().get(d).get(s));
					}
				}
			}
		}
		if (f.isExpense()) {
			retS += "Expense of ";
			retS += reasons;
			retS += tmp.toString() + "\n";
		}
		total.add(tmp);
		
		if (f.isTotal()) {
			retS += "Turnover of ";
			retS += reasons;
			retS += total.toString() + "\n";
		}
		return retS;
	}
	
	/**
	 * 
	 * @param reason
	 * 				an ArrayList with reasons
	 * @return
	 * 				a readable string with all reasons (i.e. "Merchandise, Advertisment, Others: ")
	 */
	private String listReason(ArrayList<String> reason) {
		String retS = new String();
		int i = 1;
		int size = reason.size();
		for (String s : reason) {
			retS += (!((i++) == size)) ?  (s + ", ") : (s + ": ");
		}
		return retS;
	}
}
