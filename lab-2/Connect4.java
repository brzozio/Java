// Zasady gry
import java.util.Arrays;
import java.util.Random;

public class Connect4{
	//Tablice tablica[][] = new Tablice[iloscWierszyPrzekazywana][iloscKolumnPrzekazywana]; // konstruktor bezparametrowy
	public Tablice tablica = new Tablice();
	public Tablice tablicaParametryTablice = new Tablice(6,7); // konstruktor z dwoma argumentami
	
	//public Tablice tablica2 = new Tablice();
	//public Tablice[][] tablicaDwaParametry = new Tablice[6][7];
			public void zerujTablice(){
				//System.out.println(tablica.planszaGry[1][1]);
				for(int i = 0; i < 6; i++){
					for(int j = 0; j < 7; j++){
						tablica.planszaGry[i][j] = 0;
						tablicaParametryTablice.planszaGry[i][j] = 0;
					}
				}
			}

	public void wyswietlajTablice(){
		for(int i = 0; i < 6; i++){
			for(int j = 0; j < 7; j++){
				System.out.printf(tablica.planszaGry[i][j] + " ");
			}
			System.out.println("\n");
		}
		//System.out.println(Arrays.asList(tablica));
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
	public int kolej = 0;
		public int czyjaKolej() {
			if(kolej == 0){
				Random randomNumber = new Random();
					int zmiennaRandomKolej = randomNumber.nextInt(2);
				kolej = zmiennaRandomKolej;
			}
			if(kolej == 1) {
				kolej = 2;
				return 2;
			} else {
				kolej = 1;
				return 1;
			}
		}
	
	public boolean wrzucKrazek(int kolumna) {
		int checkFull = 0;
		if(tablica.planszaGry[0][kolumna] == 0){ // sprawdzanie czy gorna komorka jest pusta aby dodac do tej kolumny
				// sprawdzamy wolne miejsca od dolu
			if(tablica.planszaGry[5][kolumna] == 0){
				tablica.planszaGry[5][kolumna] = kolej;
			} else if(tablica.planszaGry[4][kolumna] == 0){
				tablica.planszaGry[4][kolumna] = kolej;
			} else if(tablica.planszaGry[3][kolumna] == 0){
				tablica.planszaGry[3][kolumna] = kolej;
			} else if(tablica.planszaGry[2][kolumna] == 0){
				tablica.planszaGry[2][kolumna] = kolej;
			} else if(tablica.planszaGry[1][kolumna] == 0){
				tablica.planszaGry[1][kolumna] = kolej;
			} else if(tablica.planszaGry[0][kolumna] == 0){
				tablica.planszaGry[0][kolumna] = kolej;
			} 
		}else checkFull++;
		if(checkFull == 0){
			return true;
		}else return false;
		
	}

	public void ktoWygral(){
		int ciong = Tablice.najdluzszyCiag(tablica.planszaGry);
		System.out.println("Najdluzszy ciag to: " + ciong);
	}

	/*
	public String tablicaJakoString(){
		
	}*/

}
