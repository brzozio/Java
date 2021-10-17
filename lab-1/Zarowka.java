public class Zarowka {

	int Moc;
	boolean Wlaczona = false;
	String name;
	
	public void wlacz() { // Wlaczanie zarowki
		Wlaczona = true;
		System.out.println("Zarowka: " + this.name + "\nWlaczona: "+Wlaczona);
	};

	public void wylacz() { // Wylaczanie zarowki
		Wlaczona = false;
		System.out.println("Zarowka: " + this.name + "\nWlaczona: "+Wlaczona);
	};
	
	public Zarowka(int Moc, boolean Wlaczona, String name){ // Konstruktor zarowki
		this.Moc = Moc;
		this.Wlaczona = Wlaczona;
		this.name = name;
	}
	
}	
