public enum Form {
	RUND("Rund"), MOND("Mond"), WEIHNACHTSMANN("Weihnachtsmann");
	private String bez;

	Form(String f) {
		this.bez = f;
	}

	@Override
	public String toString() {
		return this.bez;
	}
}
