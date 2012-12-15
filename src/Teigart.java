public enum Teigart {
	MUERBTEIG("Muerbteig"), ZIMTSTERNTEIG("Zimtsternteig"), SCHOKOLADENTEIG(
			"Schokoladenteig");
	private String bez;

	Teigart(String f) {
		this.bez = f;
	}

	@Override
	public String toString() {
		return this.bez;
	}
}
