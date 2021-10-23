// Okienko glowne gry
import java.util.Scanner;

public class Gra {
	public static void main(String[] args) {
		Connect4 gra = new Connect4();
			// Zerowanie tablicy przed gra
			gra.zerujTablice();
			Scanner scan = new Scanner(System.in);

		// URUCHOMIENIE GFY
		System.out.println("Witaj w Connect4");	

		while(true){
			if(gra.kolej == 0){
				gra.czyjaKolej();
			}
			System.out.println("\n\nPodaj numer kolumny");
				int graKolumna = scan.nextInt();
				System.out.println("\nTwoja kolumna to: " + graKolumna);
			gra.wrzucKrazek(graKolumna - 1); // -1 bo zaczynamy iteracje od 0
			gra.wyswietlajTablice();
			gra.czyjaKolej();
		}
	}
}
