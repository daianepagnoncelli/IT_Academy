package n1exercise1;

class WindInstrument extends MusicalInstrument {
	public WindInstrument(String name, double price) {
		super(name, price);
	}

	public void play() {
		System.out.println("A wind instrument is being played");
	}
}
