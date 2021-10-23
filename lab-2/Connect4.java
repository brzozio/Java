// Zasady gry
import java.util.Arrays;

public class Connect4{
	Tablice tablica = (Tablice) new Tablice(); // konstruktor bezparametrowy

	Tablice tablica2[][] = new Tablice[6][7]; // konstruktor z dwoma argumentami
	
	/* ----- ZASADY GRY --------
	 * 0 -pusta komorka
	 * 1 - krazek gracza Gracz1
	 * 2 - krazek gracza Gracz2
	 * 
	 * zaczyna gracz Gracz1 zawsze jako pierwszy
	 * 
	 */
	public int lastKolej;
		public int czyjaKolej() {
			if(lastKolej == 1) {
				return 2;
			} else return 1;
		}
	
	public boolean wrzucKrazek(int kolumna) {
		//tablica[0][kolumna] == 0; // dodawanie krazka danego gracza
		//czyjaKolej(); // zmiana kolejki na innego gracza
		//if(czyPelnaKolumna(tablica, kolumna) == true) {
			
		//}
		
		
	}
	public void wyswietlajTablice(){
		for(int o = 0; o < 6; o++){
		for(int j = 0; j < 7; j++){
			tablica[i][j] = 0;
		}
	}
	for(int i = 0; i < 6; i++){
		for(int j = 0; j < 7; j++){
			System.out.println();
		}
	}
	}
	
	
}
