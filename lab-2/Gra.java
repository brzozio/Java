// Okienko glowne gry
import java.util.Scanner;

public class Gra {
	public static void main(String[] args) {
		Connect4 gra = new Connect4();
			// Zerowanie tablicy przed gra
			gra.zerujTablice();

		// URUCHOMIENIE GFY
		System.out.println("Witaj w Connect4");	
			Scanner scan = new Scanner(System.in);

		while(true){
			if(gra.kolej == 0){
				gra.czyjaKolej();
			}
			System.out.println("\n\nPodaj numer kolumny"); 
				int graKolumna = scan.nextInt(); // skaner linii
				while(graKolumna > 7){ // error jesli kolumna > 7
					System.out.println("\nError\nTwoja kolumna musi byc w zakresie <1,7>");
					graKolumna = scan.nextInt(); // skaner linii
				}
				System.out.println("\nTwoja kolumna to: " + graKolumna);
			if(gra.wrzucKrazek(graKolumna -1) == false){
				System.out.println("Dana kolumna jest pelna!");
				System.out.println("\nPodaj inna kolumne");
				graKolumna = scan.nextInt(); // skaner linii
				gra.wrzucKrazek(graKolumna - 1);
			}
			 // -1 bo zaczynamy iteracje od 0
			//gra.ktoWygral(); // sprawdzanie czy gracz wrzucajacy krążek wygrał grę
			gra.wyswietlajTablice(); // wyswietlanie tablicy po kazdej rundzie
			gra.czyjaKolej(); // przekazywanie kolejki do kolejnego gracza
		}
	}
}
