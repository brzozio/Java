// Okienko glowne gry, glowne polecnia do gry
import java.util.Scanner;

import javax.swing.table.TableColumn;

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
		
		System.out.println("Podaj czy chcesz zagrac z komputerem (2) czy z innym graczem (1)");
		int znakWyborKomputerGracz = scan.nextInt();
		
		gra.wyswietlajTablice(); // pierwsze wyswietlanie tablicy

			while(!(znakWyborKomputerGracz == 2 || znakWyborKomputerGracz == 1)){
				System.out.println("Podales inna liczbe niz 1 lub 2.\nPodaj czy chcesz zagrac z komputerem (2) czy z innym graczem (1)");
				znakWyborKomputerGracz = scan.nextInt();
			}
		if(znakWyborKomputerGracz == 1){
			while(true){
				gra.czyjaKolej();
				
				System.out.println("\n\nPodaj numer kolumny"); 
				int graKolumna = scan.nextInt(); // skaner linii
				while(graKolumna > 7 || graKolumna < 1){ // error jesli kolumna > 7
					System.out.println("\nError\nTwoja kolumna musi byc w zakresie <1,7>");
					graKolumna = scan.nextInt(); // skaner linii
				}
				System.out.println("\n\n\nTwoja kolumna to: " + graKolumna);
				while(gra.wrzucKrazek(graKolumna -1) == false){
					System.out.println("Dana kolumna jest pelna!");
					System.out.println("\nPodaj inna kolumne");
					graKolumna = scan.nextInt(); // skaner linii
					gra.wrzucKrazek(graKolumna - 1);
				}
				//Tablice.czyPelnaKolumna(gra.planszaGry, 2);
				Tablice.czyPelna(gra.planszaGry[0]); // sprawdzanie dla najwyzszego wiersza czy jest pelen
				// -1 bo zaczynamy iteracje od 0, takze zeby pokrylo sie z "1 kolumna to 1 widoczna kolumna"
				
				gra.ktoWygral(); // sprawdzanie czy gracz wrzucajacy krążek wygrał grę
				if(gra.ktoWygral() == 1){
					System.out.println("\n\n\n=====================\n\nWygral gracz: 1\n\n=====================");
					break;
				}else if(gra.ktoWygral() == 2){
					System.out.println("\n\n\n=====================\n\nWygral gracz: 2\n\n=====================");
					break;
				}else if(Tablice.czyPelna(gra.planszaGry[0]) == true){
					System.out.println("\n\n\nKONIEC GRY!\n\nNikt nie wygral, pelna tablica gry!");
					break;
				}
				//Connect4.clearScreen(); // czyszcenie ekranu
				gra.wyswietlajTablice(); // wyswietlanie tablicy
				
				/* TESTOWANIE
				// ------------ SPRAWDZANIE COPY TABLIC ------------
				// String tablica = gra.tablicaJakoString();
				// 	System.out.println("Tablica jako string to: \n" + tablica);

				// int[] tablicaSSSS = Tablice.klonuj(gra.planszaGry[5]);
				// 	System.out.println("\n\n\n");
				// 	for(int i = 0; i < 7; i++){
				// 		System.out.println(tablicaSSSS[i]);
				// 	}

				// int[][] tablicaSSSSSS = Tablice.klonuj(gra.planszaGry);
				// 	System.out.println("\n\n\n");
				//  	for(int i = 0; i < 6; i++){
				// 		 for(int j = 0; j < 7; j++){
				// 			 System.out.print(tablicaSSSSSS[i][j]);
				// 		 }
				// 		 System.out.println("\n");
				//  	}
				*/
			}
		}else if (znakWyborKomputerGracz == 2){
			while(true){
				gra.wyswietlajTablice(); // wyswietlanie tablicy
				gra.kolej = 1; // zaczyna gracz 1 w przypadku gry z komputerem i gra tylko on
			
				System.out.println("\n\nPodaj numer kolumny"); 
					int graKolumna = scan.nextInt(); // skaner linii
					while(graKolumna > 7 || graKolumna < 1){ // error jesli kolumna > 7
						System.out.println("\nError\nTwoja kolumna musi byc w zakresie <1,7>");
						graKolumna = scan.nextInt(); // skaner linii
					}
					System.out.println("\n\n\nTwoja kolumna to: " + graKolumna);
				while(gra.wrzucKrazek(graKolumna -1) == false){
					System.out.println("Dana kolumna jest pelna!");
					System.out.println("\nPodaj inna kolumne");
					graKolumna = scan.nextInt(); // skaner linii
					gra.wrzucKrazek(graKolumna - 1);
				}

				// Connect4.clearScreen(); // czyszcenie ekranu
				// KOLEJ KOMPUTERA
					gra.kolej = 2;
					gra.wykonajRuchAI(); // ruch komputera
					
				gra.ktoWygral(); // sprawdzanie czy gracz wrzucajacy krążek wygrał grę
				if(gra.ktoWygral() == 1){
					System.out.println("\n\n\n=====================\n\nWygral gracz: 1\n\n=====================");
					break;
				}else if(gra.ktoWygral() == 2){
					System.out.println("\n\n\n=====================\n\nWygral gracz: KOMPUTER\n\n=====================");
					break;
				}else if(Tablice.czyPelna(gra.planszaGry[0]) == true){
					System.out.println("\n\n\nKONIEC GRY!\n\nNikt nie wygral, pelna tablica gry!");
					break;
				}
			}
		}
	}

}
