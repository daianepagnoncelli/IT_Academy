package n1exercise1;

abstract class MusicalInstrument {
	protected String name;
	protected double price;

	public MusicalInstrument(String name, double price) {
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}

	abstract void play();
}