// Tablica gry, plansza do gry
import java.text.BreakIterator;

public class Tablice {
	public int iloscWierszy;
	public int iloscKolumn;
	public int[][] planszaGry; // tablica gry

	// ====================== KONSTRUKTORY ===================
	// konstruktor bezparametrowy
	public Tablice() { 
		this.iloscWierszy = 6;
		this.iloscKolumn = 7;
		this.planszaGry = new int[iloscWierszy][iloscKolumn];
			for(int i = 0; i < iloscWierszy; i++){
				for(int j = 0; j < iloscKolumn; j++){
					this.planszaGry[i][j] = 0;
				}
			}
	}
	// konstruktor 2 parametrowy
	public Tablice(int iloscWierszyPrzekazywana, int iloscKolumnPrzekazywana) { 
		this.planszaGry = new int[iloscWierszyPrzekazywana][iloscKolumnPrzekazywana];
			for(int i = 0; i < iloscWierszyPrzekazywana; i++){
				for(int j = 0; j < iloscKolumnPrzekazywana; j++){
					this.planszaGry[i][j] = 0;
				}
			}
	}
	// =======================================================
	
	
	
		private static int iloscZerowychElementow;
	public static boolean czyPelna(int[] tablicaGra) {
		iloscZerowychElementow = 0;
		for(int i = 0; i < 7; i++) {
			/*if(!czyPelnaKolumna(tablicaGra, i)){
				iloscZerowychElementow += 1;
			}*/
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
	
	public static int najdluzszyCiag(int[][] tablicaGra) {
		// pion, poziom, skos w obie strony
		int dlugoscCiagu = 1; 
		int dlugoscCiaguMax = 0;
		int countWiersze = 6; // 6 - 1 bo start od 0
		int countKolumny = 7; // 7 - 1 bo start od 0
/*
		// sprawdzanie poziomu -- countWiersze musi byc takie samo, inaczej zerowanie
			for(int i = 1; i < countWiersze; i++){
				dlugoscCiagu = 1;
				for(int j = 0; j < countKolumny; j++){
					if(tablicaGra[i][j] == tablicaGra[i-1][j]){
						dlugoscCiagu++;
					}
				}
			}
			if(dlugoscCiagu > dlugoscCiaguMax){
				dlugoscCiaguMax = dlugoscCiagu;
			}
		// sprawdzanie pionu 
			for(int j = 0; j < countKolumny; j++){
				dlugoscCiagu = 1;
				for(int i = 3; i < countWiersze; i++){
					if(tablicaGra[i][j] == tablicaGra[i-1][j]){
						dlugoscCiagu++;
					}
				}
			}
			if(dlugoscCiagu > dlugoscCiaguMax){
				dlugoscCiaguMax = dlugoscCiagu;
			}
		
*/		
		// sprawdzanie skosu
			// od TOP_RIGTH do DOWN_LEFT, kolumny 3-6 -- DZIALA
			/*
				int j4 = countKolumny - 2; // zaczynamy od 5 kolumny a konczymy na 3
				int i4 = 1; // zaczybnamy od 1 wiersza a konczymy na 6
				int kolumnyDiag4;
			while(j4 >= 3){
				i4 = 1;
				kolumnyDiag4 = j4;
				dlugoscCiagu = 1;

				while(kolumnyDiag4 > 0){
					if(tablicaGra[i4][kolumnyDiag4] == tablicaGra[i4-1][kolumnyDiag4+1]){
						dlugoscCiagu++;
						if(dlugoscCiagu > dlugoscCiaguMax){
							dlugoscCiaguMax = dlugoscCiagu;
						}
					}else dlugoscCiagu = 1;
					i4++; kolumnyDiag4--;;// sprawdzanie kolejnej komorki po skosie
				}
				j4 = j4 - 1; // przechodzenie
			}
			
			if(dlugoscCiagu > dlugoscCiaguMax){
				dlugoscCiaguMax = dlugoscCiagu;
			}*/


			// od TOP_RIGTH do DOWN_LEFT, wiersze 1-2
			int j5 = countKolumny - 2; // zaczynamy od 5
			int i5 = 2; // zaczybnamy od 1 wiersza a konczymy na 2
			int wierszeDiag5;
		while(i5 <= 3){
			i5 = 2;
			wierszeDiag5 = i5;
			dlugoscCiagu = 1;

			while(wierszeDiag5 < countWiersze){
				if(tablicaGra[wierszeDiag5][j5] == tablicaGra[wierszeDiag5-1][j5+1]){
					dlugoscCiagu++;
					if(dlugoscCiagu > dlugoscCiaguMax){
						dlugoscCiaguMax = dlugoscCiagu;
					}
				}else dlugoscCiagu = 1;
				wierszeDiag5++; j5--;;// sprawdzanie kolejnej komorki po skosie
			}
			i5 = i5 + 1; // przechodzenie
		}
		
		if(dlugoscCiagu > dlugoscCiaguMax){
			dlugoscCiaguMax = dlugoscCiagu;
		}
		return dlugoscCiaguMax;
	}
}
