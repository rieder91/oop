public enum Fuellung {
	SCHOKOLADE("Schokolade"), MARMELADE("Marmelade");
	private String bez;

	Fuellung(String f) {
		this.bez = f;
	}

	@Override
	public String toString() {
		return this.bez;
	}
}
