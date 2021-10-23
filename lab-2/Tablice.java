// Tablica gry, plansza
import java.text.BreakIterator;

// do ogarniecia roznice miedzy int[] tab oraz int[][] tab
public class Tablice {
	public int iloscWierszy;
	public int iloscKolumn;
	public static int[][] planszaGry; // ewentualnie dodac ilosc elementow

	// ====================== KONSTRUKTORY ===================
	public Tablice() { // konstruktor bezparametrowy
		this.iloscWierszy = 6;
		this.iloscKolumn = 7;
		planszaGry[this.iloscWierszy][this.iloscKolumn];
	}
	
	public Tablice(int iloscWierszyPrzekazywana, int iloscKolumnPrzekazywana) {
		this.iloscWierszy = iloscWierszyPrzekazywana;
		this.iloscKolumn = iloscKolumnPrzekazywana;
	}
	// =======================================================
	
	
	
		private static int iloscZerowychElementow;
	public static boolean czyPelna(int[] tablicaGra) {
		iloscZerowychElementow = 0;
		for(int i = 0; i < 7; i++) {
			if(!czyPelnaKolumna(planszaGry, i)){
				iloscZerowychElementow += 1;
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
		
	}
	
	public static void najdluzszyCiag(int[][] tablicaGra, int x) {
		
	}
}