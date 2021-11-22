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
	
	public static int[][] klonuj(int[][] tablicaGra) {
		//deepCopy
		int[][] tablicaKlonujDwaWymiary = {{0,0,0,0,0,0,0},
										   {0,0,0,0,0,0,0},
										   {0,0,0,0,0,0,0},
										   {0,0,0,0,0,0,0},
										   {0,0,0,0,0,0,0},
										   {0,0,0,0,0,0,0}};
		for(int i = 0; i < 6; i++){
			for(int j = 0; j < 7; j++){
				tablicaKlonujDwaWymiary[i][j] = tablicaGra[i][j];
			}
		}
		return tablicaKlonujDwaWymiary;
	}

	public static int[] klonuj(int[] tablicaGra) {
		//Copy
		int[] wierszTablicyKlonuj = tablicaGra;
		return wierszTablicyKlonuj;
	}
	
	
		static int kolumnaGraczaKtoraWygraPion = 0;
		static int kolumnaGraczaKtoraWygraPoziom = 0;
		static int kolumnaGraczaKtoraWygraSkos = 0;
		static int wierszGraczaKtoryWygraPion = 0;
		static int wierszGraczaKtoryWygraPoziom = 0;
		static int wierszGraczaKtoryWygraSkos = 0;

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
						if(dlugoscCiagu > 2){
							kolumnaGraczaKtoraWygraPoziom = j; // kolumna w ktorej dlugosc ciagu jest rowna 3
							wierszGraczaKtoryWygraPoziom = i; // aktualny wiersz dla ktorego dlugosc ciagu jest rowna 3
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
						if(dlugoscCiagu > 2){
							kolumnaGraczaKtoraWygraPion = j; // kolumna w ktorej dlugosc ciagu jest rowna 3
							wierszGraczaKtoryWygraPion = i; // wiersz dla ktorego dlugosc ciagu jest rowna 3
						}
					}
				}
			}
		
		// sprawdzanie skosu -----------------------------------------------------------------------------------
			// TOP LEFT -> DOWN RIGHT
				dlugoscCiagu = 1;
			for(int i = 1, j = 1; i < countWiersze && j < countKolumny; i++, j++){
					if(tablicaGra[i][j] == numerGracza && tablicaGra[i][j] == tablicaGra[i-1][j-1]){
						dlugoscCiagu++;
						//System.out.println("\nPION\nKolumna " + j + " wiersz: " + i + "\nDlugosc: " + dlugoscCiagu);
						if(dlugoscCiagu > dlugoscCiaguMax){
							dlugoscCiaguMax = dlugoscCiagu;
						}
				}
			}
				dlugoscCiagu = 1;
			for(int i = 2, j = 1; i < countWiersze && j < countKolumny; i++, j++){
					if(tablicaGra[i][j] == numerGracza && tablicaGra[i][j] == tablicaGra[i-1][j-1]){
						dlugoscCiagu++;
						//System.out.println("\nPION\nKolumna " + j + " wiersz: " + i + "\nDlugosc: " + dlugoscCiagu);
						if(dlugoscCiagu > dlugoscCiaguMax){
							dlugoscCiaguMax = dlugoscCiagu;
						}
				}
			}
				dlugoscCiagu = 1;
			for(int i = 3, j = 1; i < countWiersze && j < countKolumny; i++, j++){
					if(tablicaGra[i][j] == numerGracza && tablicaGra[i][j] == tablicaGra[i-1][j-1]){
						dlugoscCiagu++;
						//System.out.println("\nPION\nKolumna " + j + " wiersz: " + i + "\nDlugosc: " + dlugoscCiagu);
						if(dlugoscCiagu > dlugoscCiaguMax){
							dlugoscCiaguMax = dlugoscCiagu;
						}
				}
			}

				dlugoscCiagu = 1;
			for(int i = 2, j = 1; i < countWiersze && j < countKolumny; i++, j++){
					if(tablicaGra[i][j] == numerGracza && tablicaGra[i][j] == tablicaGra[i-1][j-1]){
						dlugoscCiagu++;
						//System.out.println("\nPION\nKolumna " + j + " wiersz: " + i + "\nDlugosc: " + dlugoscCiagu);
						if(dlugoscCiagu > dlugoscCiaguMax){
							dlugoscCiaguMax = dlugoscCiagu;
						}
				}
			}
				dlugoscCiagu = 1;
			for(int i = 3, j = 1; i < countWiersze && j < countKolumny; i++, j++){
					if(tablicaGra[i][j] == numerGracza && tablicaGra[i][j] == tablicaGra[i-1][j-1]){
						dlugoscCiagu++;
						//System.out.println("\nPION\nKolumna " + j + " wiersz: " + i + "\nDlugosc: " + dlugoscCiagu);
						if(dlugoscCiagu > dlugoscCiaguMax){
							dlugoscCiaguMax = dlugoscCiagu;
						}
				}
			}
				dlugoscCiagu = 1;
			for(int i = 4, j = 1; i < countWiersze && j < countKolumny; i++, j++){
					if(tablicaGra[i][j] == numerGracza && tablicaGra[i][j] == tablicaGra[i-1][j-1]){
						dlugoscCiagu++;
						//System.out.println("\nPION\nKolumna " + j + " wiersz: " + i + "\nDlugosc: " + dlugoscCiagu);
						if(dlugoscCiagu > dlugoscCiaguMax){
							dlugoscCiaguMax = dlugoscCiagu;
						}
				}
			}

			// TOP RIGHT -> DOWN LEFT
				dlugoscCiagu = 1;
			for(int i = 1, j = 5; i < countWiersze && j < countKolumny; i++, j--){
					if(tablicaGra[i][j] == numerGracza && tablicaGra[i][j] == tablicaGra[i-1][j+1]){
						dlugoscCiagu++;
						//System.out.println("\nPION\nKolumna " + j + " wiersz: " + i + "\nDlugosc: " + dlugoscCiagu);
						if(dlugoscCiagu > dlugoscCiaguMax){
							dlugoscCiaguMax = dlugoscCiagu;
						}
				}
			}
				dlugoscCiagu = 1;
			for(int i = 2, j = 5; i < countWiersze && j > -1; i++, j--){
					if(tablicaGra[i][j] == numerGracza && tablicaGra[i][j] == tablicaGra[i-1][j+1]){
						dlugoscCiagu++;
						//System.out.println("\nPION\nKolumna " + j + " wiersz: " + i + "\nDlugosc: " + dlugoscCiagu);
						if(dlugoscCiagu > dlugoscCiaguMax){
							dlugoscCiaguMax = dlugoscCiagu;
						}
				}
			}
				dlugoscCiagu = 1;
			for(int i = 3, j = 5; i < countWiersze && j > -1; i++, j--){
					if(tablicaGra[i][j] == numerGracza && tablicaGra[i][j] == tablicaGra[i-1][j+1]){
						dlugoscCiagu++;
						//System.out.println("\nPION\nKolumna " + j + " wiersz: " + i + "\nDlugosc: " + dlugoscCiagu);
						if(dlugoscCiagu > dlugoscCiaguMax){
							dlugoscCiaguMax = dlugoscCiagu;
						}
				}
			}
				dlugoscCiagu = 1;
			for(int i = 1, j = 4; i < countWiersze && j > -1; i++, j--){
					if(tablicaGra[i][j] == numerGracza && tablicaGra[i][j] == tablicaGra[i-1][j+1]){
						dlugoscCiagu++;
						//System.out.println("\nPION\nKolumna " + j + " wiersz: " + i + "\nDlugosc: " + dlugoscCiagu);
						if(dlugoscCiagu > dlugoscCiaguMax){
							dlugoscCiaguMax = dlugoscCiagu;
						}
				}
			}
				dlugoscCiagu = 1;
			for(int i = 1, j = 3; i < countWiersze && j > -1; i++, j--){
					if(tablicaGra[i][j] == numerGracza && tablicaGra[i][j] == tablicaGra[i-1][j+1]){
						dlugoscCiagu++;
						//System.out.println("\nPION\nKolumna " + j + " wiersz: " + i + "\nDlugosc: " + dlugoscCiagu);
						if(dlugoscCiagu > dlugoscCiaguMax){
							dlugoscCiaguMax = dlugoscCiagu;
						}
				}
			}
				dlugoscCiagu = 1;
			for(int i = 1, j = 2; i < countWiersze && j > -1; i++, j--){
					if(tablicaGra[i][j] == numerGracza && tablicaGra[i][j] == tablicaGra[i-1][j+1]){
						dlugoscCiagu++;
						//System.out.println("\nPION\nKolumna " + j + " wiersz: " + i + "\nDlugosc: " + dlugoscCiagu);
						if(dlugoscCiagu > dlugoscCiaguMax){
							dlugoscCiaguMax = dlugoscCiagu;
						}
				}
			}

		// -----------------------------------------------------------------------------------------------------

		return dlugoscCiaguMax;
	}

}
