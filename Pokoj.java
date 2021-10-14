public class Pokoj {
	public static void main(String[] args){

		Lampa lampa = new Lampa(); // instancja Lampy w klasie Pokoj
			lampa.obliczMoc();
			System.out.println("Sumowalna moc zarowek w lampie to: " + (lampa.mocOgolna) + "W");
			lampa.wlaczLosowaZarowke();
	}	
}