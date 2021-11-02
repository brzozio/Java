import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

import javax.swing.SwingUtilities;

import java.io.IOException;

public class Run {
    public static void main(String[] args) {
      //  BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
        Scanner scanner = new Scanner(System.in);
        KolkoIKrzyzyk kik = new KolkoIKrzyzyk();

        while(!kik.jestRemis()){
            System.out.println("Czyja kolej: " + kik.getCzyjaKolej());
            kik.pokazPlansze();
             //String ruch = br.readLine();
             System.out.println("Podaj pole w ktore chcesz umiescic znak");
             String ruch = scanner.nextLine(); 
            kik.wykonajRuch(ruch);
            kik.ktoWygral();
        }
    }
}