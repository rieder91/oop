package assignment1;

public class ProposedDate{
	private Event e;
	private boolean agreed;
	private String reason;
	
	/**
	 * Constructor which requires threee arguments
	 * 
	 * @param e
	 * 			event to agree
	 */
	public ProposedDate(Event e, String reason) {
		this.e = e;
	}

	/**
	 * @return 
	 * 			true if the member agreed
	 * 			false if the member declined			
	 */
	public boolean isAgreed() {
		return agreed;
	}

	/**
	 * @param agreed 
	 * 			the agreed to set
	 */
	public void agree(boolean agreed) {
		this.agreed = agreed;
	}

	/**
	 * @param agreed 
	 * 			the agreed to set
	 */
	public void agree(boolean agreed, String reason) {
		this.agreed = agreed;
		this.reason=reason;
	}
	
	/**
	 * @return 
	 * 			the reason why the member acceptet oder declined the date
	 */
	public String getReason() {
		return reason;
	}


	/**
	 * @return 
	 * 			the event
	 */
	public Event getE() {
		return e;
	}

	/**
	 * 
	 * 
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (agreed ? 1231 : 1237);
		result = prime * result + ((e == null) ? 0 : e.hashCode());
		result = prime * result + ((reason == null) ? 0 : reason.hashCode());
		return result;
	}

	/** 
	 * 
	 * 
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof ProposedDate)) {
			return false;
		}
		ProposedDate other = (ProposedDate) obj;
		if (e == null) {
			if (other.e != null) {
				return false;
			}
		} else if (!e.equals(other.e)) {
			return false;
		}
		return true;
	}
	
	
}