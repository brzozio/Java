// Okienko glowne gry, glowne polecnia do gry
import java.util.Scanner;

public class Gra {
	public static void main(String[] args) {
		// URUCHOMIENIE GFY
		System.out.println("Witaj w Connect4");	
		Scanner scan = new Scanner(System.in);
		System.out.println("Podaj co chcesz utworzyc: \n1) Plansza 6x7\n2) Plansza XxY");
		int opcjaWyborKonstruktora = scan.nextInt(); // skaner linii do wyboru konstruktora

		Connect4 gra = new Connect4();
		if(opcjaWyborKonstruktora == 1){
			gra = new Connect4(); // twrorzenie planszy 6x7
		} else if(opcjaWyborKonstruktora == 2){
			System.out.println("Podaj liczbe wierszy");
				int liczbaWierszyPrzekazywana = scan.nextInt();
			System.out.println("Podaj liczbe kolumn");
				int liczbaKolumnPrzekazywana = scan.nextInt();

			gra = new Connect4(liczbaWierszyPrzekazywana,liczbaKolumnPrzekazywana);
		} 
		// Zerowanie tablicy przed gra
			gra.zerujTablice();

		while(true){
			gra.wyswietlajTablice(); // wyswietlanie tablicy
			gra.czyjaKolej();
			
			System.out.println("\n\nPodaj numer kolumny"); 
				int graKolumna = scan.nextInt(); // skaner linii
				while(graKolumna > 7){ // error jesli kolumna > 7
					System.out.println("\nError\nTwoja kolumna musi byc w zakresie <1,7>");
					graKolumna = scan.nextInt(); // skaner linii
				}
				System.out.println("\n\n\nTwoja kolumna to: " + graKolumna);
			if(gra.wrzucKrazek(graKolumna -1) == false){
				System.out.println("Dana kolumna jest pelna!");
				System.out.println("\nPodaj inna kolumne");
				graKolumna = scan.nextInt(); // skaner linii
				gra.wrzucKrazek(graKolumna - 1);
			}
			//Tablice.czyPelnaKolumna(gra.planszaGry, 2);
			//Tablice.czyPelna(gra.planszaGry[0]); // sprawdzanie dla najwyzszego wiersza czy jest pelen
			// -1 bo zaczynamy iteracje od 0, takze zeby pokrylo sie z "1 kolumna to 1 widoczna kolumna"

			gra.ktoWygral(); // sprawdzanie czy gracz wrzucajacy krążek wygrał grę
		}
	}
}
