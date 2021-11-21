// Tablica gry, plansza do gry
import java.text.BreakIterator;

public class Tablice {
	
	private static int iloscZerowychElementow;
	public static boolean czyPelna(int[] tablicaGra) {
		iloscZerowychElementow = 0;
		for(int i = 0; i < 7; i++) {
			if(tablicaGra[i] == 0){
				iloscZerowychElementow++;
			}
		}
		if(iloscZerowychElementow > 0) {
			return false;
		} else {
			return true;	
		}
	}
	
	public static boolean czyPelnaKolumna(int[][] tablicaGra, int nrKolumny) {
		iloscZerowychElementow = 0;
		for(int i = 0; i < 6; i++) {
			if(tablicaGra[i][nrKolumny] == 0) {
				iloscZerowychElementow = iloscZerowychElementow + 1;
			}
		}
		if(iloscZerowychElementow > 0) {
			return false;
		} else {
			return true;	
		}
	}
	
	public static void clone(int[] tablicaGra) {
		
	}
	
	public static void clone(int[][] tablicaGra) {
		//deepCopy
	}
	
	public static int najdluzszyCiag(int[][] tablicaGra, int numerGracza) {
		// pion, poziom, skos w obie strony
		int dlugoscCiagu = 1;
		int dlugoscCiaguMax = 0;
		int countWiersze = 6; // 6 - 1 bo start od 0
		int countKolumny = 7; // 7 - 1 bo start od 0

		// sprawdzanie poziomu -- countWiersze musi byc takie samo, inaczej zerowanie
			for(int i = 0; i < countWiersze; i++){
				dlugoscCiagu = 1;
				for(int j = 1; j < countKolumny; j++){
					if(tablicaGra[i][j] == numerGracza && tablicaGra[i][j] == tablicaGra[i][j-1]){
						dlugoscCiagu++;
						//System.out.println("\nPOZIOM\nKolumna " + j + " wiersz: " + i);
						if(dlugoscCiagu > dlugoscCiaguMax){
							dlugoscCiaguMax = dlugoscCiagu;
						}
					}
				}
			}
			
		// sprawdzanie pionu 
			for(int j = 0; j < countKolumny; j++){
				dlugoscCiagu = 1;
				for(int i = 1; i < countWiersze; i++){
					if(tablicaGra[i][j] == numerGracza && tablicaGra[i][j] == tablicaGra[i-1][j]){
						dlugoscCiagu++;
						//System.out.println("\nPION\nKolumna " + j + " wiersz: " + i + "\nDlugosc: " + dlugoscCiagu);
						if(dlugoscCiagu > dlugoscCiaguMax){
							dlugoscCiaguMax = dlugoscCiagu;
						}
					}
				}
			}
			
		
		
		// // sprawdzanie skosu
		// 	// od TOP_RIGTH do DOWN_LEFT, kolumny 3-6 -- DZIALA
			
		// 		int j4 = countKolumny - 2; // zaczynamy od 5 kolumny a konczymy na 3
		// 		int i4 = 1; // zaczybnamy od 1 wiersza a konczymy na 6
		// 		int kolumnyDiag4;
		// 	while(j4 >= 3){
		// 		i4 = 1;
		// 		kolumnyDiag4 = j4;
		// 		dlugoscCiagu = 1;

		// 		while(kolumnyDiag4 > 0){
		// 			if(tablicaGra[i4][j4] == numerGracza && tablicaGra[i4][kolumnyDiag4] == tablicaGra[i4-1][kolumnyDiag4+1]){
		// 				dlugoscCiagu++;
		// 				if(dlugoscCiagu > dlugoscCiaguMax){
		// 					dlugoscCiaguMax = dlugoscCiagu;
		// 				}
		// 			}else dlugoscCiagu = 1;
		// 			i4++; kolumnyDiag4--;;// sprawdzanie kolejnej komorki po skosie
		// 		}
		// 		j4 = j4 - 1; // przechodzenie
		// 	}
			
		// 	if(dlugoscCiagu > dlugoscCiaguMax){
		// 		dlugoscCiaguMax = dlugoscCiagu;
		// 	}


		// 	// od TOP_RIGTH do DOWN_LEFT, wiersze 1-2
		// 	int j5 = countKolumny - 2; // zaczynamy od 5
		// 	int i5 = 2; // zaczybnamy od 1 wiersza a konczymy na 2
		// 	int wierszeDiag5;
		// while(i5 <= 3){
		// 	i5 = 2;
		// 	wierszeDiag5 = i5;
		// 	dlugoscCiagu = 1;

		// 	while(wierszeDiag5 < countWiersze){
		// 		if(tablicaGra[wierszeDiag5][j5] == numerGracza && tablicaGra[wierszeDiag5][j5] == tablicaGra[wierszeDiag5-1][j5+1]){
		// 			dlugoscCiagu++;
		// 			if(dlugoscCiagu > dlugoscCiaguMax){
		// 				dlugoscCiaguMax = dlugoscCiagu;
		// 			}
		// 		}else dlugoscCiagu = 1;
		// 		wierszeDiag5++; j5--;;// sprawdzanie kolejnej komorki po skosie
		// 	}
		// 	i5 = i5 + 1; // przechodzenie
		// }
		
		if(dlugoscCiagu > dlugoscCiaguMax){
			dlugoscCiaguMax = dlugoscCiagu;
		}
		return dlugoscCiaguMax;
	}
}
