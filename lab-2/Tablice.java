// Tablica gry, plansza
import java.text.BreakIterator;

public class Tablice {
	public int iloscWierszy;
	public int iloscKolumn;
	public int[][] planszaGry;

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
		this.iloscWierszy = 6;
		this.iloscKolumn = 7;
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
		//	if(!czyPelnaKolumna(tablicaGra, i)){
				iloscZerowychElementow += 1;
			//}
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
		
	}
	
	public static void najdluzszyCiag(int[][] tablicaGra, int x) {
		
	}
}
