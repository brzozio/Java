package filesGame;
// Okienko glowne gry, glowne polecnia do gry
import java.util.Scanner;
import javax.swing.SwingUtilities;

import javax.swing.table.TableColumn;

import javax.swing.JButton; // przyciski
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import java.awt.event.MouseAdapter;
import java.awt.GridLayout; // GridLayout
import java.awt.FlowLayout;
import java.awt.Container;
import java.awt.event.*; // ActionEvent oraz ActionListener

import javax.swing.JPanel;
import java.awt.BorderLayout;

public class Gra extends JFrame{
	public Gra() {
		// URUCHOMIENIE GFY

		setTitle("Connect 4");
		setSize(1000,1000);
		setLocationRelativeTo(null);
		setLayout(new FlowLayout());

		// Kontener główny gry
		Container mainContainer = new Container();
			add(mainContainer);

		mainContainer.setLayout(new BorderLayout());

		JPanel panelGry = new JPanel();
			mainContainer.add(panelGry, BorderLayout.CENTER);
			panelGry.setLayout(new GridLayout(6,7));
// Tworzenie pol ===============================================
	JTextField macierz00 = new JTextField(5);
	panelGry.add(macierz00);
    JTextField macierz01 = new JTextField(5);
	panelGry.add(macierz01);
    JTextField macierz02 = new JTextField(5);
	panelGry.add(macierz02);
    JTextField macierz03 = new JTextField(5);
	panelGry.add(macierz03);
	JTextField macierz04 = new JTextField(5);
	panelGry.add(macierz04);
    JTextField macierz05 = new JTextField(5);
	panelGry.add(macierz05);
    JTextField macierz06 = new JTextField(5);
	panelGry.add(macierz06);

    JTextField macierz10 = new JTextField(5);
	panelGry.add(macierz10);
    JTextField macierz11 = new JTextField(5);
	panelGry.add(macierz11);
    JTextField macierz12 = new JTextField(5);
	panelGry.add(macierz12);
    JTextField macierz13 = new JTextField(5);
	panelGry.add(macierz13);
	JTextField macierz14 = new JTextField(5);
	panelGry.add(macierz14);
    JTextField macierz15 = new JTextField(5);
	panelGry.add(macierz15);
    JTextField macierz16 = new JTextField(5);
	panelGry.add(macierz16);

	JTextField macierz20 = new JTextField(5);
	panelGry.add(macierz20);
    JTextField macierz21 = new JTextField(5);
	panelGry.add(macierz21);
    JTextField macierz22 = new JTextField(5);
	panelGry.add(macierz22);
    JTextField macierz23 = new JTextField(5);
	panelGry.add(macierz23);
	JTextField macierz24 = new JTextField(5);
	panelGry.add(macierz24);
    JTextField macierz25 = new JTextField(5);
	panelGry.add(macierz25);
    JTextField macierz26 = new JTextField(5);
	panelGry.add(macierz26);

	JTextField macierz30 = new JTextField(5);
	panelGry.add(macierz30);
    JTextField macierz31 = new JTextField(5);
	panelGry.add(macierz31);
    JTextField macierz32 = new JTextField(5);
	panelGry.add(macierz32);
    JTextField macierz33 = new JTextField(5);
	panelGry.add(macierz33);
	JTextField macierz34 = new JTextField(5);
	panelGry.add(macierz34);
    JTextField macierz35 = new JTextField(5);
	panelGry.add(macierz35);
    JTextField macierz36 = new JTextField(5);
	panelGry.add(macierz36);

	JTextField macierz40 = new JTextField(5);
	panelGry.add(macierz40);
    JTextField macierz41 = new JTextField(5);
	panelGry.add(macierz41);
    JTextField macierz42 = new JTextField(5);
	panelGry.add(macierz42);
    JTextField macierz43 = new JTextField(5);
	panelGry.add(macierz43);
	JTextField macierz44 = new JTextField(5);
	panelGry.add(macierz44);
    JTextField macierz45 = new JTextField(5);
	panelGry.add(macierz45);
    JTextField macierz46 = new JTextField(5);
	panelGry.add(macierz46);

	JTextField macierz50 = new JTextField(5);
	panelGry.add(macierz50);
    JTextField macierz51 = new JTextField(5);
	panelGry.add(macierz51);
    JTextField macierz52 = new JTextField(5);
	panelGry.add(macierz52);
    JTextField macierz53 = new JTextField(5);
	panelGry.add(macierz53);
	JTextField macierz54 = new JTextField(5);
	panelGry.add(macierz54);
    JTextField macierz55 = new JTextField(5);
	panelGry.add(macierz55);
    JTextField macierz56 = new JTextField(5);
	panelGry.add(macierz56);
// ============================================================			

		System.out.println("Witaj w Connect4");	
		Scanner scan = new Scanner(System.in);
		System.out.println("Podaj co chcesz utworzyc: \n1) Plansza 6x7\n2) Plansza XxY");
		int opcjaWyborKonstruktora = scan.nextInt(); // skaner linii do wyboru konstruktora

		Connect4 gra = new Connect4();
		if(opcjaWyborKonstruktora == 1){
			gra = new Connect4(); // twrorzenie planszy 6x7
		} else if(opcjaWyborKonstruktora == 2){
			System.out.println("Podaj liczbe wierszy");
			int liczbaWierszyPrzekazywana = scan.nextInt();
			System.out.println("Podaj liczbe kolumn");
			int liczbaKolumnPrzekazywana = scan.nextInt();
			
			gra = new Connect4(liczbaWierszyPrzekazywana,liczbaKolumnPrzekazywana);
			
				System.out.println("eee, i tak bedziesz gral na 6x7 :)");
				gra = new Connect4();
		} 
		// Zerowanie tablicy przed gra
		gra.zerujTablice();
		
		System.out.println("Podaj czy chcesz zagrac z komputerem (2) czy z innym graczem (1)");
		int znakWyborKomputerGracz = scan.nextInt();
		
		gra.wyswietlajTablice(); // pierwsze wyswietlanie tablicy

			while(!(znakWyborKomputerGracz == 2 || znakWyborKomputerGracz == 1)){
				System.out.println("Podales inna liczbe niz 1 lub 2.\nPodaj czy chcesz zagrac z komputerem (2) czy z innym graczem (1)");
				znakWyborKomputerGracz = scan.nextInt();
			}
		if(znakWyborKomputerGracz == 1){
			while(true){
				gra.czyjaKolej();
				
				System.out.println("\n\nPodaj numer kolumny"); 
				int graKolumna = scan.nextInt(); // skaner linii
				while(graKolumna > 7 || graKolumna < 1){ // error jesli kolumna > 7
					System.out.println("\nError\nTwoja kolumna musi byc w zakresie <1,7>");
					graKolumna = scan.nextInt(); // skaner linii
				}
				System.out.println("\n\n\nTwoja kolumna to: " + graKolumna);
				while(gra.wrzucKrazek(graKolumna -1) == false){
					System.out.println("Dana kolumna jest pelna!");
					System.out.println("\nPodaj inna kolumne");
					graKolumna = scan.nextInt(); // skaner linii
					gra.wrzucKrazek(graKolumna - 1);
				}
				//Tablice.czyPelnaKolumna(gra.planszaGry, 2);
				//Tablice.czyPelna(gra.planszaGry[0]); // sprawdzanie dla najwyzszego wiersza czy jest pelen
				// -1 bo zaczynamy iteracje od 0, takze zeby pokrylo sie z "1 kolumna to 1 widoczna kolumna"
				
				gra.ktoWygral(); // sprawdzanie czy gracz wrzucajacy krążek wygrał grę
				if(gra.ktoWygral() == 1){
					System.out.println("\n\n\n=====================\n\nWygral gracz: 1\n\n=====================");
					break;
				}else if(gra.ktoWygral() == 2){
					System.out.println("\n\n\n=====================\n\nWygral gracz: 2\n\n=====================");
					break;
				}else if(Tablice.czyPelna(gra.planszaGry[0]) == true){
					System.out.println("\n\n\nKONIEC GRY!\n\nNikt nie wygral, pelna tablica gry!");
					break;
				}
				//Connect4.clearScreen(); // czyszcenie ekranu
				gra.wyswietlajTablice(); // wyswietlanie tablicy
				
				/* TESTOWANIE
				// ------------ SPRAWDZANIE COPY TABLIC ------------
				// String tablica = gra.tablicaJakoString();
				// 	System.out.println("Tablica jako string to: \n" + tablica);

				// int[] tablicaSSSS = Tablice.klonuj(gra.planszaGry[5]);
				// 	System.out.println("\n\n\n");
				// 	for(int i = 0; i < 7; i++){
				// 		System.out.println(tablicaSSSS[i]);
				// 	}

				// int[][] tablicaSSSSSS = Tablice.klonuj(gra.planszaGry);
				// 	System.out.println("\n\n\n");
				//  	for(int i = 0; i < 6; i++){
				// 		 for(int j = 0; j < 7; j++){
				// 			 System.out.print(tablicaSSSSSS[i][j]);
				// 		 }
				// 		 System.out.println("\n");
				//  	}
				*/
			}
		}else if (znakWyborKomputerGracz == 2){
			while(true){
				gra.kolej = 1; // zaczyna gracz 1 w przypadku gry z komputerem i gra tylko on
				
				System.out.println("\n\nPodaj numer kolumny"); 
				int graKolumna = scan.nextInt(); // skaner linii
				while(graKolumna > 7 || graKolumna < 1){ // error jesli kolumna > 7
					System.out.println("\nError\nTwoja kolumna musi byc w zakresie <1,7>");
					graKolumna = scan.nextInt(); // skaner linii
				}
				System.out.println("\n\n\nTwoja kolumna to: " + graKolumna);
				while(gra.wrzucKrazek(graKolumna -1) == false){
					System.out.println("Dana kolumna jest pelna!");
					System.out.println("\nPodaj inna kolumne");
					graKolumna = scan.nextInt(); // skaner linii
					gra.wrzucKrazek(graKolumna - 1);
				}
				gra.ktoWygral(); // sprawdzanie czy gracz wrzucajacy krążek wygrał grę
				if(gra.ktoWygral() == 1){
					System.out.println("\n\n\n=====================\n\nWygral gracz: 1\n\n=====================");
					break;
				}else if(gra.ktoWygral() == 2){
					System.out.println("\n\n\n=====================\n\nWygral gracz: KOMPUTER\n\n=====================");
					break;
				}else if(Tablice.czyPelna(gra.planszaGry[0]) == true){
					System.out.println("\n\n\nKONIEC GRY!\n\nNikt nie wygral, pelna tablica gry!");
					break;
				}

				// Connect4.clearScreen(); // czyszcenie ekranu
				// KOLEJ KOMPUTERA
				/*
				Tablice.kolumnaGraczaKtoraWygraPion = 10;
				Tablice.kolumnaGraczaKtoraWygraPoziom = 10;
				Tablice.kolumnaGraczaKtoraWygraSkos = 10;
				Tablice.wierszGraczaKtoryWygraPion = 10;
				Tablice.wierszGraczaKtoryWygraPoziom = 10;
				Tablice.wierszGraczaKtoryWygraSkos = 10;
				*/
				gra.kolej = 2;
				gra.wykonajRuchAI(); // ruch komputera
				gra.wyswietlajTablice(); // wyswietlanie tablicy
				
				gra.ktoWygral(); // sprawdzanie czy gracz wrzucajacy krążek wygrał grę
				if(gra.ktoWygral() == 1){
					System.out.println("\n\n\n=====================\n\nWygral gracz: 1\n\n=====================");
					break;
				}else if(gra.ktoWygral() == 2){
					System.out.println("\n\n\n=====================\n\nWygral gracz: KOMPUTER\n\n=====================");
					break;
				}else if(Tablice.czyPelna(gra.planszaGry[0]) == true){
					System.out.println("\n\n\nKONIEC GRY!\n\nNikt nie wygral, pelna tablica gry!");
					break;
				}
			}
		}
	}

}
