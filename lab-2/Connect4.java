// Zasady gry
import java.util.Arrays;

public class Connect4{
	//Tablice tablica[][] = new Tablice[iloscWierszyPrzekazywana][iloscKolumnPrzekazywana]; // konstruktor bezparametrowy
	public Tablice tablica = new Tablice();
	public Tablice tablica2[][] = new Tablice[6][7]; // konstruktor z dwoma argumentami
			public void zerujTablice(){
				//System.out.println(tablica.planszaGry[1][1]);
				for(int i = 0; i < 6; i++){
					for(int j = 0; j < 7; j++){
						tablica.planszaGry[i][j] = 0;
					}
				}
			}

	public void wyswietlajTablice(){
		//System.out.println(tablica.planszaGry[1][1]);
		for(int i = 0; i < 6; i++){
			for(int j = 0; j < 7; j++){
				System.out.println(tablica.planszaGry[i][j]);
			}
		}
	}
	
	//Tablice tablica3 = new Tablice(6,7);
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
		if(tablica.planszaGry[0][kolumna] == 0){
			
		} // dodawanie krazka danego gracza
		czyjaKolej(); // zmiana kolejki na innego gracza
		if(czyPelnaKolumna(tablica, kolumna) == true) {
			
		}
		
		
	}
	
}
