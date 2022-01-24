// Tablica gry, plansza do gry
import java.text.BreakIterator;

import javax.swing.text.TableView.TableCell;

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
	
		static int kolumnaGraczaKtoraWygraPion;
		static int kolumnaGraczaKtoraWygraPoziom;
		static int kolumnaGraczaKtoraWygraSkos;
		static int wierszGraczaKtoryWygraPion;
		static int wierszGraczaKtoryWygraPoziom;
		static int wierszGraczaKtoryWygraSkos;
		static int kolumnaGraczaKtoryWygraSkos;

		static int kolumnaAIKtoraWygraPion;
		static int kolumnaAIKtoraWygraPoziom;
		static int kolumnaAIKtoraWygraSkos;
		static int wierszAIKtoryWygraPion;
		static int wierszAIKtoryWygraPoziom;
		static int wierszAIKtoryWygraSkos;
		static int kolumnaAIKtoryWygraSkos;

		static int dlugoscCiaguAI;
		static int wierszZwiekszCiagAI;
		static int kolumnaZwiekszCiagAI;

	public static int najdluzszyCiag(int[][] tablicaGra, int numerGracza) {

		kolumnaGraczaKtoraWygraPion = 10;
		kolumnaGraczaKtoraWygraPoziom = 10;
		kolumnaGraczaKtoraWygraSkos = 10;
		wierszGraczaKtoryWygraPion = 10;
		wierszGraczaKtoryWygraPoziom = 10;
		wierszGraczaKtoryWygraSkos = 10;
		kolumnaGraczaKtoryWygraSkos = 10;

		kolumnaAIKtoraWygraPion = 10;
		kolumnaAIKtoraWygraPoziom = 10;
		kolumnaAIKtoraWygraSkos = 10;
		wierszAIKtoryWygraPion = 10;
		wierszAIKtoryWygraPoziom = 10;
		wierszAIKtoryWygraSkos = 10;
		kolumnaAIKtoryWygraSkos = 10;

		dlugoscCiaguAI = 1;
		wierszZwiekszCiagAI = 10;
		kolumnaZwiekszCiagAI = 10;


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
							if(tablicaGra[i][j] == 2 && j < countKolumny - 1){ // AI
								dlugoscCiaguAI = dlugoscCiagu;
								if(tablicaGra[i][j+1] == 0){
									wierszZwiekszCiagAI = i;
									kolumnaZwiekszCiagAI = j + 1;
								}else {
									wierszZwiekszCiagAI = 10;
									kolumnaZwiekszCiagAI = 10;
								}
							}
						}
						if(dlugoscCiagu > 2){
							if(numerGracza == 1){
								if(tablicaGra[i][j+1] == 0){
									kolumnaGraczaKtoraWygraPoziom = j + 1; // kolumna w ktorej dlugosc ciagu jest rowna 3
									wierszGraczaKtoryWygraPoziom = i; // aktualny wiersz dla ktorego dlugosc ciagu jest rowna 3
								}
							}else if(numerGracza == 2){
								if(tablicaGra[i][j+1] == 0){
									kolumnaAIKtoraWygraPoziom = j + 1;
									wierszAIKtoryWygraPoziom = i;
								}
							}
						}else if(j < 5){ // aby nie wyjsc poza tabele, to sprawdzamy do maks. . . . 1 1 0 1| oraz ... 1 0 1 1|
							if(dlugoscCiagu == 2 && tablicaGra[i][j+1] == 0 && tablicaGra[i][j+2] == numerGracza){ // ciag 1 1 0 1 np
								if(numerGracza == 1){
									if(tablicaGra[i][j+1] == 0){
										kolumnaGraczaKtoraWygraPoziom = j + 1; // kolumna w ktorej dlugosc ciagu jest rowna 3
										wierszGraczaKtoryWygraPoziom = i; // aktualny wiersz dla ktorego dlugosc ciagu jest rowna 3
									}
								}else if(numerGracza == 2){
									if(tablicaGra[i][j+1] == 0){
										kolumnaAIKtoraWygraPoziom = j + 1;
										wierszAIKtoryWygraPoziom = i;
									}
								}
							}else if(j < 4){
								if(tablicaGra[i][j] == numerGracza && tablicaGra[i][j+1] == 0 && tablicaGra[i][j+1] == numerGracza && tablicaGra[i][j+2] == numerGracza){
									if(numerGracza == 1){
										if(tablicaGra[i][j+1] == 0){
											kolumnaGraczaKtoraWygraPoziom = j + 1; 
											wierszGraczaKtoryWygraPoziom = i; 
										}
									}else if(numerGracza == 2){
										if(tablicaGra[i][j+1] == 0){
											kolumnaAIKtoraWygraPoziom = j + 1;
											wierszAIKtoryWygraPoziom = i;
										}
									}
								}
							}
						}else  {
							kolumnaGraczaKtoryWygraSkos = 10;
							wierszGraczaKtoryWygraSkos = 10; 
							kolumnaAIKtoryWygraSkos = 10;
							wierszAIKtoryWygraSkos = 10; 
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
							if(numerGracza == 1){
								if(tablicaGra[i-3][j] == 0){
									kolumnaGraczaKtoraWygraPion = j; // kolumna w ktorej dlugosc ciagu jest rowna 3
									wierszGraczaKtoryWygraPion = i - 3; // wiersz dla ktorego dlugosc ciagu jest rowna 3
								}
								
							}else if(numerGracza == 2){
								if(tablicaGra[i-3][j] == 0){
									kolumnaAIKtoraWygraPion = j; // kolumna w ktorej dlugosc ciagu jest rowna 3
									wierszAIKtoryWygraPion = i - 3; // wiersz dla ktorego dlugosc ciagu jest rowna 3
								}
							}
						}else {
							kolumnaGraczaKtoryWygraSkos = 10;
							wierszGraczaKtoryWygraSkos = 10; 
							kolumnaAIKtoryWygraSkos = 10;
							wierszAIKtoryWygraSkos = 10; 
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
						if(dlugoscCiagu > 2){
							if(numerGracza == 1 && i < (countWiersze - 1)){
								if(tablicaGra[i+1][j+1] == 0){
									kolumnaGraczaKtoryWygraSkos = j + 1; 
									wierszGraczaKtoryWygraSkos = i+1; 
								}
							}else if(numerGracza == 2 && i < (countWiersze - 1)){
								if(tablicaGra[i+1][j+1] == 0){
									kolumnaAIKtoryWygraSkos = j + 1; 
									wierszAIKtoryWygraSkos = i+1; 
								}
							}
						}else if(j < 4){ // aby nie wyjsc poza tabele, to sprawdzamy do maks. . . . 1 1 0 1|
							if(dlugoscCiagu == 2 && tablicaGra[i+1][j+1] == 0 && tablicaGra[i+2][j+2] == numerGracza){ // ciag 1 1 0 1 np
								if(numerGracza == 1 && i < (countWiersze - 1)){
									if(tablicaGra[i+1][j+1] == 0){
										kolumnaGraczaKtoryWygraSkos = j + 1; 
										wierszGraczaKtoryWygraSkos = i+1; 
									}
								}else if(numerGracza == 2 && i < (countWiersze - 1)) {
									if(tablicaGra[i+1][j+1] == 0){
										kolumnaAIKtoryWygraSkos = j + 1;
										wierszAIKtoryWygraSkos = i+1; 
									}
								}
							}
						}else  {
							kolumnaGraczaKtoryWygraSkos = 10;
							wierszGraczaKtoryWygraSkos = 10; 
							kolumnaAIKtoryWygraSkos = 10;
							wierszAIKtoryWygraSkos = 10; 
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
						if(dlugoscCiagu > 2){
							if(numerGracza == 1 && i < (countWiersze - 1)){
								if(tablicaGra[i+1][j+1] == 0){
									kolumnaGraczaKtoryWygraSkos = j + 1;
									wierszGraczaKtoryWygraSkos = i+1;
								}
							}else if(numerGracza == 2 && i < (countWiersze - 1)){
								if(tablicaGra[i+1][j+1] == 0){
									kolumnaAIKtoryWygraSkos = j + 1; 
									wierszAIKtoryWygraSkos = i+1;
								}
							}
						}else if(j < 3){ // aby nie wyjsc poza tabele, to sprawdzamy do maks. . . . 1 1 0 1|
							if(dlugoscCiagu == 2 && tablicaGra[i+1][j+1] == 0 && tablicaGra[i+2][j+2] == numerGracza){ // ciag 1 1 0 1 np
								if(numerGracza == 1 && i < (countWiersze - 1)){
									if(tablicaGra[i+1][j+1] == 0){
										kolumnaGraczaKtoryWygraSkos = j + 1;
										wierszGraczaKtoryWygraSkos = i+1;
									}
								}else if(numerGracza == 2 && i < (countWiersze - 1)){
									if(tablicaGra[i+1][j+1] == 0){
										kolumnaAIKtoryWygraSkos = j + 1; 
										wierszAIKtoryWygraSkos = i+1;
									}
								}
							}
						}else  {
							kolumnaGraczaKtoryWygraSkos = 10;
							wierszGraczaKtoryWygraSkos = 10; 
							kolumnaAIKtoryWygraSkos = 10;
							wierszAIKtoryWygraSkos = 10; 
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
						if(dlugoscCiagu > 2){
							if(numerGracza == 1 && i < (countWiersze - 1)){
								if(tablicaGra[i+1][j+1] == 0){
									kolumnaGraczaKtoryWygraSkos = j + 1;
									wierszGraczaKtoryWygraSkos = i+1;
								}
							}else if(numerGracza == 2 && i < (countWiersze - 1)){
								if(tablicaGra[i+1][j+1] == 0){
									kolumnaAIKtoryWygraSkos = j + 1; 
									wierszAIKtoryWygraSkos = i+1;
								}
							}
						}else if(j < 2){ // aby nie wyjsc poza tabele, to sprawdzamy do maks. . . . 1 1 0 1|
							if(dlugoscCiagu == 2 && tablicaGra[i+1][j+1] == 0 && tablicaGra[i+2][j+2] == numerGracza){ // ciag 1 1 0 1 np
								if(numerGracza == 1 && i < (countWiersze - 1)){
									if(tablicaGra[i+1][j+1] == 0){
										kolumnaGraczaKtoryWygraSkos = j + 1;
										wierszGraczaKtoryWygraSkos = i+1;
									}
								}else if(numerGracza == 2 && i < (countWiersze - 1)){
									if(tablicaGra[i+1][j+1] == 0){
										kolumnaAIKtoryWygraSkos = j + 1; 
										wierszAIKtoryWygraSkos = i+1;
									}
								}
							}
						}else  {
							kolumnaGraczaKtoryWygraSkos = 10;
							wierszGraczaKtoryWygraSkos = 10; 
							kolumnaAIKtoryWygraSkos = 10;
							wierszAIKtoryWygraSkos = 10; 
						}
				}
			}

				dlugoscCiagu = 1;
			for(int i = 1, j = 2; i < countWiersze && j < countKolumny; i++, j++){
					if(tablicaGra[i][j] == numerGracza && tablicaGra[i][j] == tablicaGra[i-1][j-1]){
						dlugoscCiagu++;
						//System.out.println("\nPION\nKolumna " + j + " wiersz: " + i + "\nDlugosc: " + dlugoscCiagu);
						if(dlugoscCiagu > dlugoscCiaguMax){
							dlugoscCiaguMax = dlugoscCiagu;
						}
						else if(dlugoscCiagu > 2){
							if(numerGracza == 1 && i < (countWiersze - 1)){
								if(tablicaGra[i+1][j+1] == 0){
									kolumnaGraczaKtoryWygraSkos = j + 1;
									wierszGraczaKtoryWygraSkos = i+1;
								}
							}else if(numerGracza == 2 && i < (countWiersze - 1)){
								if(tablicaGra[i+1][j+1] == 0){
									kolumnaAIKtoryWygraSkos = j + 1; 
									wierszAIKtoryWygraSkos = i+1;
								}
							}
						}else if(j < 5){ // aby nie wyjsc poza tabele, to sprawdzamy do maks. . . . 1 1 0 1|
							if(dlugoscCiagu == 2 && tablicaGra[i+1][j+1] == 0 && tablicaGra[i+2][j+2] == numerGracza){ // ciag 1 1 0 1 np
								if(numerGracza == 1 && i < (countWiersze - 1)){
									if(tablicaGra[i+1][j+1] == 0){
										kolumnaGraczaKtoryWygraSkos = j + 1;
										wierszGraczaKtoryWygraSkos = i+1;
									}
								}else if(numerGracza == 2 && i < (countWiersze - 1)){
									if(tablicaGra[i+1][j+1] == 0){
										kolumnaAIKtoryWygraSkos = j + 1; 
										wierszAIKtoryWygraSkos = i+1;
									}
								}
							}
						}else  {
							kolumnaGraczaKtoryWygraSkos = 10;
							wierszGraczaKtoryWygraSkos = 10; 
							kolumnaAIKtoryWygraSkos = 10;
							wierszAIKtoryWygraSkos = 10; 
						}
				}
			}
				dlugoscCiagu = 1;
			for(int i = 1, j = 3; i < countWiersze && j < countKolumny; i++, j++){
					if(tablicaGra[i][j] == numerGracza && tablicaGra[i][j] == tablicaGra[i-1][j-1]){
						dlugoscCiagu++;
						//System.out.println("\nPION\nKolumna " + j + " wiersz: " + i + "\nDlugosc: " + dlugoscCiagu);
						if(dlugoscCiagu > dlugoscCiaguMax){
							dlugoscCiaguMax = dlugoscCiagu;
						}
						else if(dlugoscCiagu > 2){
							if(numerGracza == 1 && i < (countWiersze - 1)){
								if(tablicaGra[i+1][j+1] == 0){
									kolumnaGraczaKtoryWygraSkos = j + 1;
									wierszGraczaKtoryWygraSkos = i+1;
								}
							}else if(numerGracza == 2 && i < (countWiersze - 1)){
								if(tablicaGra[i+1][j+1] == 0){
									kolumnaAIKtoryWygraSkos = j + 1; 
									wierszAIKtoryWygraSkos = i+1;
								}
							}
						}else if(j < 5){ // aby nie wyjsc poza tabele, to sprawdzamy do maks. . . . 1 1 0 1|
							if(dlugoscCiagu == 2 && tablicaGra[i+1][j+1] == 0 && tablicaGra[i+2][j+2] == numerGracza){ // ciag 1 1 0 1 np
								if(numerGracza == 1 && i < (countWiersze - 1)){
									if(tablicaGra[i+1][j+1] == 0){
										kolumnaGraczaKtoryWygraSkos = j + 1;
										wierszGraczaKtoryWygraSkos = i+1;
									}
								}else if(numerGracza == 2 && i < (countWiersze - 1)){
									if(tablicaGra[i+1][j+1] == 0){
										kolumnaAIKtoryWygraSkos = j + 1; 
										wierszAIKtoryWygraSkos = i+1;
									}
								}
							}
						}else  {
							kolumnaGraczaKtoryWygraSkos = 10;
							wierszGraczaKtoryWygraSkos = 10; 
							kolumnaAIKtoryWygraSkos = 10;
							wierszAIKtoryWygraSkos = 10; 
						}
				}
			}
				dlugoscCiagu = 1;
			for(int i = 1, j = 4; i < countWiersze && j < countKolumny; i++, j++){
					if(tablicaGra[i][j] == numerGracza && tablicaGra[i][j] == tablicaGra[i-1][j-1]){
						dlugoscCiagu++;
						//System.out.println("\nPION\nKolumna " + j + " wiersz: " + i + "\nDlugosc: " + dlugoscCiagu);
						if(dlugoscCiagu > dlugoscCiaguMax){
							dlugoscCiaguMax = dlugoscCiagu;
						}
						else if(dlugoscCiagu > 2){
							if(numerGracza == 1 && i < (countWiersze - 1)){
								if(tablicaGra[i+1][j+1] == 0){
									kolumnaGraczaKtoryWygraSkos = j + 1;
									wierszGraczaKtoryWygraSkos = i+1;
								}
							}else if(numerGracza == 2 && i < (countWiersze - 1)){
								if(tablicaGra[i+1][j+1] == 0){
									kolumnaAIKtoryWygraSkos = j + 1; 
									wierszAIKtoryWygraSkos = i+1;
								}
							}
						}else if(j < 5){ // aby nie wyjsc poza tabele, to sprawdzamy do maks. . . . 1 1 0 1|
							if(dlugoscCiagu == 2 && tablicaGra[i+1][j+1] == 0 && tablicaGra[i+2][j+2] == numerGracza){ // ciag 1 1 0 1 np
								if(numerGracza == 1 && i < (countWiersze - 1)){
									if(tablicaGra[i+1][j+1] == 0){
										kolumnaGraczaKtoryWygraSkos = j + 1;
										wierszGraczaKtoryWygraSkos = i+1;
									}
								}else if(numerGracza == 2 && i < (countWiersze - 1)){
									if(tablicaGra[i+1][j+1] == 0){
										kolumnaAIKtoryWygraSkos = j + 1; 
										wierszAIKtoryWygraSkos = i+1;
									}
								}
							}
						}else  {
							kolumnaGraczaKtoryWygraSkos = 10;
							wierszGraczaKtoryWygraSkos = 10; 
							kolumnaAIKtoryWygraSkos = 10;
							wierszAIKtoryWygraSkos = 10;  
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
						if(dlugoscCiagu > 2){
							if(numerGracza == 1 && i < (countWiersze - 1) && j > 0){
								if(tablicaGra[i+1][j-1] == 0){
									kolumnaGraczaKtoryWygraSkos = j - 1;
									wierszGraczaKtoryWygraSkos = i+1;
								}
							}else if(numerGracza == 2 && i < (countWiersze - 1) && j > 0){
								if(tablicaGra[i+1][j-1] == 0){
									kolumnaAIKtoraWygraSkos = j - 1;
									wierszAIKtoryWygraSkos = i + 1;
								}
							}
						}else if(j > 2){ // aby nie wyjsc poza tabele, to sprawdzamy do maks. . . . 1 1 0 1|
							if(dlugoscCiagu == 2 && tablicaGra[i+1][j-1] == 0 && tablicaGra[i+2][j-2] == numerGracza){ // ciag 1 1 0 1 np
								if(numerGracza == 1 && i < (countWiersze - 1) && j > 0){
									if(tablicaGra[i+1][j-1] == 0){
										kolumnaGraczaKtoryWygraSkos = j - 1;
										wierszGraczaKtoryWygraSkos = i+1;
									}
								}else if(numerGracza == 2 && i < (countWiersze - 1) && j > 0){
									if(tablicaGra[i+1][j-1] == 0){
										kolumnaAIKtoraWygraSkos = j - 1;
										wierszAIKtoryWygraSkos = i + 1;
									}
								}
							}
						}else  {
							kolumnaGraczaKtoryWygraSkos = 10;
							wierszGraczaKtoryWygraSkos = 10; 
							kolumnaAIKtoryWygraSkos = 10;
							wierszAIKtoryWygraSkos = 10; 
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
						if(dlugoscCiagu > 2){
							if(numerGracza == 1 && i < (countWiersze - 1) && j > 0){
								if(tablicaGra[i+1][j-1] == 0){
									kolumnaGraczaKtoryWygraSkos = j - 1;
									wierszGraczaKtoryWygraSkos = i+1;
								}
							}else if(numerGracza == 2 && i < (countWiersze - 1) && j > 0){
								if(tablicaGra[i+1][j-1] == 0){
									kolumnaAIKtoraWygraSkos = j - 1;
									wierszAIKtoryWygraSkos = i + 1;
								}
							}
						}else if(j > 3){ // aby nie wyjsc poza tabele, to sprawdzamy do maks. . . . 1 1 0 1|
							if(dlugoscCiagu == 2 && tablicaGra[i+1][j-1] == 0 && tablicaGra[i+2][j-2] == numerGracza){ // ciag 1 1 0 1 np
								if(numerGracza == 1 && i < (countWiersze - 1) && j > 0){
									if(tablicaGra[i+1][j-1] == 0){
										kolumnaGraczaKtoryWygraSkos = j - 1;
										wierszGraczaKtoryWygraSkos = i+1;
									}
								}else if(numerGracza == 2 && i < (countWiersze - 1) && j > 0){
									if(tablicaGra[i+1][j-1] == 0){
										kolumnaAIKtoraWygraSkos = j - 1;
										wierszAIKtoryWygraSkos = i + 1;
									}
								}
							}
						}else  {
							kolumnaGraczaKtoryWygraSkos = 10;
							wierszGraczaKtoryWygraSkos = 10; 
							kolumnaAIKtoryWygraSkos = 10;
							wierszAIKtoryWygraSkos = 10; 
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
						if(dlugoscCiagu > 2){
							if(numerGracza == 1 && i < (countWiersze - 1) && j > 0){
								if(tablicaGra[i+1][j-1] == 0){
									kolumnaGraczaKtoryWygraSkos = j - 1;
									wierszGraczaKtoryWygraSkos = i+1;
								}
							}else if(numerGracza == 2 && i < (countWiersze - 1) && j > 0){
								if(tablicaGra[i+1][j-1] == 0){
									kolumnaAIKtoraWygraSkos = j - 1;
									wierszAIKtoryWygraSkos = i + 1;
								}
							}
						}else if(j > 4){ // aby nie wyjsc poza tabele, to sprawdzamy do maks. . . . 1 1 0 1|
							if(dlugoscCiagu == 2 && tablicaGra[i+1][j-1] == 0 && tablicaGra[i+2][j-2] == numerGracza){ // ciag 1 1 0 1 np
								if(numerGracza == 1 && i < (countWiersze - 1) && j > 0){
									if(tablicaGra[i+1][j-1] == 0){
										kolumnaGraczaKtoryWygraSkos = j - 1;
										wierszGraczaKtoryWygraSkos = i+1;
									}
								}else if(numerGracza == 2 && i < (countWiersze - 1) && j > 0){
									if(tablicaGra[i+1][j-1] == 0){
										kolumnaAIKtoraWygraSkos = j - 1;
										wierszAIKtoryWygraSkos = i + 1;
									}
								}
							}
						}else  {
							kolumnaGraczaKtoryWygraSkos = 10;
							wierszGraczaKtoryWygraSkos = 10; 
							kolumnaAIKtoryWygraSkos = 10;
							wierszAIKtoryWygraSkos = 10; 
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
						if(dlugoscCiagu > 2){
							if(numerGracza == 1 && i < (countWiersze - 1) && j > 0){
								if(tablicaGra[i+1][j-1] == 0){
									kolumnaGraczaKtoryWygraSkos = j - 1;
									wierszGraczaKtoryWygraSkos = i+1;
								}
							}else if(numerGracza == 2 && i < (countWiersze - 1) && j > 0){
								if(tablicaGra[i+1][j-1] == 0){
									kolumnaAIKtoraWygraSkos = j - 1;
									wierszAIKtoryWygraSkos = i + 1;
								}
							}
						}else if(j > 1){ // aby nie wyjsc poza tabele, to sprawdzamy do maks. . . . 1 1 0 1|
							if(dlugoscCiagu == 2 && tablicaGra[i+1][j-1] == 0 && tablicaGra[i+2][j-2] == numerGracza){ // ciag 1 1 0 1 np
								if(numerGracza == 1 && i < (countWiersze - 1) && j > 0){
									if(tablicaGra[i+1][j-1] == 0){
										kolumnaGraczaKtoryWygraSkos = j - 1;
										wierszGraczaKtoryWygraSkos = i+1;
									}
								}else if(numerGracza == 2 && i < (countWiersze - 1) && j > 0){
									if(tablicaGra[i+1][j-1] == 0){
										kolumnaAIKtoraWygraSkos = j - 1;
										wierszAIKtoryWygraSkos = i + 1;
									}
								}
							}
						}else  {
							kolumnaGraczaKtoryWygraSkos = 10;
							wierszGraczaKtoryWygraSkos = 10; 
							kolumnaAIKtoryWygraSkos = 10;
							wierszAIKtoryWygraSkos = 10; 
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
						if(dlugoscCiagu > 2){
							if(numerGracza == 1 && i < (countWiersze - 1) && j > 0){
								if(tablicaGra[i+1][j-1] == 0){
									kolumnaGraczaKtoryWygraSkos = j - 1;
									wierszGraczaKtoryWygraSkos = i+1;
								}
							}else if(numerGracza == 2 && i < (countWiersze - 1) && j > 0){
								if(tablicaGra[i+1][j-1] == 0){
									kolumnaAIKtoraWygraSkos = j - 1;
									wierszAIKtoryWygraSkos = i + 1;
								}
							}
						}else if(j > 1){ // aby nie wyjsc poza tabele, to sprawdzamy do maks. . . . 1 1 0 1|
							if(dlugoscCiagu == 2 && tablicaGra[i+1][j-1] == 0 && tablicaGra[i+2][j-2] == numerGracza){ // ciag 1 1 0 1 np
								if(numerGracza == 1 && i < (countWiersze - 1) && j > 0){
									if(tablicaGra[i+1][j-1] == 0){
										kolumnaGraczaKtoryWygraSkos = j - 1;
										wierszGraczaKtoryWygraSkos = i+1;
									}
								}else if(numerGracza == 2 && i < (countWiersze - 1) && j > 0){
									if(tablicaGra[i+1][j-1] == 0){
										kolumnaAIKtoraWygraSkos = j - 1;
										wierszAIKtoryWygraSkos = i + 1;
									}
								}
							}
						}else  {
							kolumnaGraczaKtoryWygraSkos = 10;
							wierszGraczaKtoryWygraSkos = 10; 
							kolumnaAIKtoryWygraSkos = 10;
							wierszAIKtoryWygraSkos = 10; 
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
						if(dlugoscCiagu > 2){
							if(numerGracza == 1 && i < (countWiersze - 1) && j > 0){
								if(tablicaGra[i+1][j-1] == 0){
									kolumnaGraczaKtoryWygraSkos = j - 1;
									wierszGraczaKtoryWygraSkos = i+1;
								}
							}else if(numerGracza == 2 && i < (countWiersze - 1) && j > 0){
								if(tablicaGra[i+1][j-1] == 0){
									kolumnaAIKtoraWygraSkos = j - 1;
									wierszAIKtoryWygraSkos = i + 1;
								}
							}
						}else if(j > 1){ // aby nie wyjsc poza tabele, to sprawdzamy do maks. . . . 1 1 0 1|
							if(dlugoscCiagu == 2 && tablicaGra[i+1][j-1] == 0 && tablicaGra[i+2][j-2] == numerGracza){ // ciag 1 1 0 1 np
								if(numerGracza == 1 && i < (countWiersze - 1) && j > 0){
									if(tablicaGra[i+1][j-1] == 0){
										kolumnaGraczaKtoryWygraSkos = j - 1;
										wierszGraczaKtoryWygraSkos = i+1;
									}
								}else if(numerGracza == 2 && i < (countWiersze - 1) && j > 0){
									if(tablicaGra[i+1][j-1] == 0){
										kolumnaAIKtoraWygraSkos = j - 1;
										wierszAIKtoryWygraSkos = i + 1;
									}
								}
							}
						}else  {
							kolumnaGraczaKtoryWygraSkos = 10;
							wierszGraczaKtoryWygraSkos = 10; 
							kolumnaAIKtoryWygraSkos = 10;
							wierszAIKtoryWygraSkos = 10; 
						}
				}
			}
		// -----------------------------------------------------------------------------------------------------
		return dlugoscCiaguMax;
	}
}
