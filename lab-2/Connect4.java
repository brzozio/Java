
public class Connect4{
	Tablice tablica = new Tablice(); // konstruktor bezparametrowy
	Tablice tablica2 = new Tablice(5,7); // konstruktor z dwoma argumentami
	
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
	
	
}
