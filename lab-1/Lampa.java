import java.util.Random;

public class Lampa {	
		 Zarowka zarowa1 = new Zarowka(80,false,"zarowa1");
		 Zarowka zarowa2 = new Zarowka(120,false,"zarowa2");
	
		public void turnOn(){ // Wlaczanie lampy
			System.out.println("Trwa wlaczanie zarowki ...");
				zarowa1.wlacz();
			System.out.println("Trwa wlaczanie zarowki ...");
				zarowa2.wlacz();
		}
		
		public void turnOff() { // Wylaczanie lampy
			System.out.println("Trwa wylaczanie zarowki ...");
				zarowa1.wylacz();
			System.out.println("Trwa wylaczanie zarowki ...");
				zarowa2.wylacz();
		}

		public int mocOgolna;	
			public  void obliczMoc() { // Liczenie mocy ogolnej lampy
				mocOgolna = zarowa1.Moc + zarowa2.Moc;
			}

		public void wlaczLosowaZarowke(){ // Wlaczanie losowej zarowki w lampie
			Random randomNumber = new Random();
				Zarowka tab[] = {zarowa1, zarowa2};
				int zmiennaPseudoLosowa = randomNumber.nextInt(2);
			System.out.println("Trwa wlaczanie zarowki nr: " + (zmiennaPseudoLosowa + 1) + " ...");
				tab[zmiennaPseudoLosowa].wlacz();
		}
}