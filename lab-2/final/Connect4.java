// Zasady gry, caly "silnik gry"
import java.lang.invoke.CallSite;
import java.util.Arrays;
import java.util.Random; // do generowania kolejnosci na starcie

public class Connect4 implements Cloneable{
	public int[][] planszaGry;
	Tablice tablice = new Tablice();

	public Connect4() { // konstruktor 6x7
		this.planszaGry = new int[6][7];
			// for(int i = 0; i < 6; i++){
			// 	for(int j = 0; j < 7; j++){
			// 		//this.planszaGry[i][j] = 0;
			// 	}
			// }
	}
	
	public Connect4(int iloscWierszyPrzekazywana, int iloscKolumnPrzekazywana) { // konstruktor 2 parametrowy
		this.planszaGry = new int[iloscWierszyPrzekazywana][iloscKolumnPrzekazywana];
			// for(int i = 0; i < iloscWierszyPrzekazywana; i++){
			// 	for(int j = 0; j < iloscKolumnPrzekazywana; j++){
			// 		//this.planszaGry[i][j] = 0;
			// 	}
			// }
	}

	public void zerujTablice(){
		for(int i = 0; i < 6; i++){
			for(int j = 0; j < 7; j++){
				planszaGry[i][j] = 0;
			}
		}
	}

	public void wyswietlajTablice(){
		for(int i = 0; i < 6; i++){
			for(int j = 0; j < 7; j++){
				System.out.printf(planszaGry[i][j] + " ");
			}
			System.out.println("\n");
		}
	}
	
	public static void clearScreen() {  
		System.out.print("\033[H\033[2J");  
		System.out.flush();  
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
				return kolej;
			} else {
				kolej = 1;
				return kolej;
			}
		}
	
	public boolean wrzucKrazek(int kolumna) {
		int checkFull = 0;
		if(planszaGry[0][kolumna] == 0){ // sprawdzanie czy gorna komorka jest pusta aby dodac do tej kolumny
				// sprawdzamy wolne miejsca od dolu
			if(planszaGry[5][kolumna] == 0){
				planszaGry[5][kolumna] = kolej;
			} else if(planszaGry[4][kolumna] == 0){
				planszaGry[4][kolumna] = kolej;
			} else if(planszaGry[3][kolumna] == 0){
				planszaGry[3][kolumna] = kolej;
			} else if(planszaGry[2][kolumna] == 0){
				planszaGry[2][kolumna] = kolej;
			} else if(planszaGry[1][kolumna] == 0){
				planszaGry[1][kolumna] = kolej;
			} else if(planszaGry[0][kolumna] == 0){
				planszaGry[0][kolumna] = kolej;
			} 
		}else checkFull++;
		if(checkFull == 0){
			return true;
		}else return false;
		
	}

	public int ktoWygral(){
		int ciong = Tablice.najdluzszyCiag(planszaGry, kolej);
		//System.out.println("DLUGOSC: " + ciong);
		if(ciong > 3){
		//System.out.println("Wygral gracz: " + kolej);
		//System.out.println("Najdluzszy ciag to: " + ciong);
		if(kolej == 1){
			return 1;
		}else return 2;
		}
		return 20; // return sth aby dzialalo
	}

	public String tablicaJakoString(){
		String tablicaJakoString = "";
		for(int i = 0; i < 6; i++){
			for(int j = 0; j < 7; j++){
				Integer temp = planszaGry[i][j];
				if(temp == 1 || temp == 2){
					String tempString = temp.toString();
					tablicaJakoString = tablicaJakoString + tempString;
				}else if(temp == 0){
					tablicaJakoString = tablicaJakoString + ".";
				}
			}
			tablicaJakoString = tablicaJakoString + "\n";
		}
		return tablicaJakoString;
	}

	public void wykonajRuchAI(){
		int[] ogolnePrawdNajlepszegoRuchu = new int[7];
		boolean[] brakPozwoleniaWygranaGraczaNastepnyKrok = new boolean[7]; // tablica braku pozwolenia wygrabej gracza w nastepnym ruchu
		int[] prawdopodobienstwoWygranej = new int[7]; // tablica prawdopodobienstwa do kolumn
		boolean[] pelnaKomorkaDoRuhu = new boolean[7]; // tablica "pelnosci" kolumn




		// petla po kolumnach
		for(int kolumnaAI = 0; kolumnaAI < 7; kolumnaAI++){
			pelnaKomorkaDoRuhu[kolumnaAI] = Tablice.czyPelnaKolumna(planszaGry, kolumnaAI); // przypisanie TRUE albo FALSE, sprawdzanie czy kolumna jest pelna
		}

		// Sprawdzanie czy gracz wygra - w tych komorkach gracz wygra
			//Tablice.najdluzszyCiag(planszaGry, 1);

			int komorkaGdzieGraczWygraPion_wiersz = Tablice.wierszGraczaKtoryWygraPion;
			int komorkaGdzieGraczWygraPion_kolumna = Tablice.kolumnaGraczaKtoraWygraPion;
			
			int komorkaGdzieGraczWygraPoziom_wiersz = Tablice.wierszGraczaKtoryWygraPoziom;
			int komorkaGdzieGraczWygraPoziom_kolumna = Tablice.kolumnaGraczaKtoraWygraPoziom;

			int komorkaGdzieGraczWygraSkos_TOP_LEFT_DOWN_RIGHT_wiersz = Tablice.wierszGraczaKtoryWygraSkos;
			int komorkaGdzieGraczWygraSkos_TOP_LEFT_DOWN_RIGHT_kolumna = Tablice.kolumnaGraczaKtoraWygraSkos;
			
			int kolumnaGraczaKtoraWygraSkos_TOP_RIGHT_DOWN_LEFT_wiersz = Tablice.wierszGraczaKtoryWygraSkos;
			int kolumnaGraczaKtoraWygraSkos_TOP_RIGHT_DOWN_LEFT_kolumna = Tablice.kolumnaGraczaKtoraWygraSkos;

			int wierszDoWpisaniaAI_BRAK_WYGRANEJ_GRACZ = 0;
			int kolumnaDoWpisaniaAI_BRAK_WYGRANEJ_GRACZ = 0;

			if(komorkaGdzieGraczWygraPion_wiersz != 10 && komorkaGdzieGraczWygraPion_kolumna != 10){
				wierszDoWpisaniaAI_BRAK_WYGRANEJ_GRACZ = komorkaGdzieGraczWygraPion_wiersz;
				kolumnaDoWpisaniaAI_BRAK_WYGRANEJ_GRACZ = komorkaGdzieGraczWygraPion_kolumna;
				planszaGry[wierszDoWpisaniaAI_BRAK_WYGRANEJ_GRACZ][kolumnaDoWpisaniaAI_BRAK_WYGRANEJ_GRACZ] = 2;
				System.out.println("\nTEST 1\nKolumna AI: " + kolumnaDoWpisaniaAI_BRAK_WYGRANEJ_GRACZ);
			}else if(komorkaGdzieGraczWygraPoziom_wiersz != 10 && komorkaGdzieGraczWygraPoziom_kolumna != 10){
				wierszDoWpisaniaAI_BRAK_WYGRANEJ_GRACZ = komorkaGdzieGraczWygraPoziom_wiersz;
				kolumnaDoWpisaniaAI_BRAK_WYGRANEJ_GRACZ = komorkaGdzieGraczWygraPoziom_kolumna;
				planszaGry[wierszDoWpisaniaAI_BRAK_WYGRANEJ_GRACZ][kolumnaDoWpisaniaAI_BRAK_WYGRANEJ_GRACZ] = 2;
				System.out.println("\nTEST 2\nKolumna AI: " + kolumnaDoWpisaniaAI_BRAK_WYGRANEJ_GRACZ);
			}else if(komorkaGdzieGraczWygraSkos_TOP_LEFT_DOWN_RIGHT_wiersz != 10 && komorkaGdzieGraczWygraSkos_TOP_LEFT_DOWN_RIGHT_kolumna != 10){
				wierszDoWpisaniaAI_BRAK_WYGRANEJ_GRACZ = komorkaGdzieGraczWygraSkos_TOP_LEFT_DOWN_RIGHT_wiersz;
				kolumnaDoWpisaniaAI_BRAK_WYGRANEJ_GRACZ = komorkaGdzieGraczWygraSkos_TOP_LEFT_DOWN_RIGHT_kolumna;
				planszaGry[wierszDoWpisaniaAI_BRAK_WYGRANEJ_GRACZ][kolumnaDoWpisaniaAI_BRAK_WYGRANEJ_GRACZ] = 2;
				System.out.println("\nTEST 3\nKolumna AI: " + kolumnaDoWpisaniaAI_BRAK_WYGRANEJ_GRACZ);
			}else if(kolumnaGraczaKtoraWygraSkos_TOP_RIGHT_DOWN_LEFT_wiersz != 10 && kolumnaGraczaKtoraWygraSkos_TOP_RIGHT_DOWN_LEFT_kolumna != 10){
				wierszDoWpisaniaAI_BRAK_WYGRANEJ_GRACZ = kolumnaGraczaKtoraWygraSkos_TOP_RIGHT_DOWN_LEFT_wiersz;
				kolumnaDoWpisaniaAI_BRAK_WYGRANEJ_GRACZ = kolumnaGraczaKtoraWygraSkos_TOP_RIGHT_DOWN_LEFT_kolumna;
				planszaGry[wierszDoWpisaniaAI_BRAK_WYGRANEJ_GRACZ][kolumnaDoWpisaniaAI_BRAK_WYGRANEJ_GRACZ] = 2;
				System.out.println("\nTEST 4\nKolumna AI: " + kolumnaDoWpisaniaAI_BRAK_WYGRANEJ_GRACZ);
			}else {
				// Wpisywanie do PLANSZY randomowo, jesli gracz nie wygra i tak w nastepnym ruchu
				Random randomNumber = new Random();
				int zmiennaRandomKolej = randomNumber.nextInt(7);
				int kolumnaOfChoiceAI = zmiennaRandomKolej;
					System.out.println("KolumnaAI: " + (kolumnaOfChoiceAI + 1));
					//	int ciagGracza = Tablice.najdluzszyCiag(planszaGry, 1); // zwracanie ciagu gracza
				if(planszaGry[0][kolumnaOfChoiceAI] == 0){ // sprawdzanie czy gorna komorka jest pusta aby dodac do tej kolumny
						// sprawdzamy wolne miejsca od dolu
					if(planszaGry[5][kolumnaOfChoiceAI] == 0){
						planszaGry[5][kolumnaOfChoiceAI] = 2;
					} else if(planszaGry[4][kolumnaOfChoiceAI] == 0){
						planszaGry[4][kolumnaOfChoiceAI] = 2;
					} else if(planszaGry[3][kolumnaOfChoiceAI] == 0){
						planszaGry[3][kolumnaOfChoiceAI] = 2;
					} else if(planszaGry[2][kolumnaOfChoiceAI] == 0){
						planszaGry[2][kolumnaOfChoiceAI] = 2;
					} else if(planszaGry[1][kolumnaOfChoiceAI] == 0){
						planszaGry[1][kolumnaOfChoiceAI] = 2;
					} else if(planszaGry[0][kolumnaOfChoiceAI] == 0){
						planszaGry[0][kolumnaOfChoiceAI] = 2;
					} 
				}
			}

		
		// przechodzenie po tablicy prawdopodobienstw i wybieranie takiej kolumny, dla ktorej jest ono najwieksze i wykonanie ruchu
		// wykonanie ruchu AI - wszystkie warunki sprawodzone w if
		// sprawdzamy wolne miejsca od dolu
		
		

		// }
	}

	@Override // Override metody CLONE z interfejsu Cloneable
	protected Connect4 clone() {
		try {
			Connect4 kopia =  (Connect4) super.clone();
		  kopia.planszaGry = planszaGry.clone();
		  return kopia;
		} catch (CloneNotSupportedException e) {
		  System.out.println(this.getClass().getName() + " nie implementuje interfejsuCloneable");
		  return null;
		}
	  }
}