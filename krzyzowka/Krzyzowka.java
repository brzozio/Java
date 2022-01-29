import java.util.List;

public class Krzyzowka {
    Pytanie pytanko;
    char[][] krzyzowka = new char[4][9];
    List<String> pytania;
    List<String> odpowiedz;
    //int wierszeIlosc, kolumnyIlosc;
    String haslo;
    
    public Krzyzowka(){ // ulozenie krzyzowki na podstawie podanej w pliku tekstowym, metoda automatycznego ukladania
        // jest do zrobienia, jednakże nie starczyło mi czasu
        pytanko = new Pytanie();
        pytania = pytanko.wyjasnienie;
        odpowiedz = pytanko.wyraz;
        haslo = this.pytanko.haslo;

        String temp = this.pytanko.wyraz.get(0);
            krzyzowka[0][5] = temp.charAt(0);
            krzyzowka[0][6] = temp.charAt(1);
            this.krzyzowka[0][7] = temp.charAt(2);

        temp = this.pytanko.wyraz.get(1);
            krzyzowka[1][3] = temp.charAt(0);
            krzyzowka[1][4] = temp.charAt(1);
            krzyzowka[1][5] = temp.charAt(2);
            krzyzowka[1][6] = temp.charAt(3);
            krzyzowka[1][7] = temp.charAt(4);

        temp = this.pytanko.wyraz.get(2);
            krzyzowka[2][2] = temp.charAt(0);
            krzyzowka[2][3] = temp.charAt(1);
            krzyzowka[2][4] = temp.charAt(2);
            krzyzowka[2][5] = temp.charAt(3);
            krzyzowka[2][6] = temp.charAt(4);
            krzyzowka[2][7] = temp.charAt(5);
            krzyzowka[2][8] = temp.charAt(6);

        temp = this.pytanko.wyraz.get(3);
            krzyzowka[3][0] = temp.charAt(0);
            krzyzowka[3][1] = temp.charAt(1);
            krzyzowka[3][2] = temp.charAt(2);
            krzyzowka[3][3] = temp.charAt(3);
            krzyzowka[3][4] = temp.charAt(4);
            krzyzowka[3][5] = temp.charAt(4);
            krzyzowka[3][6] = temp.charAt(4); 

            // Ustawianie pozsotalych pol w prostokacie na 0
            krzyzowka[0][0] = 0;
            krzyzowka[0][1] = 0;
            krzyzowka[0][2] = 0;
            krzyzowka[0][3] = 0;
            krzyzowka[0][4] = 0;
            krzyzowka[0][5] = 0;
            krzyzowka[0][8] = 0;
            krzyzowka[1][0] = 0;
            krzyzowka[1][1] = 0;
            krzyzowka[1][2] = 0;
            krzyzowka[1][8] = 0;
            krzyzowka[2][0] = 0;
            krzyzowka[2][1] = 0;
            krzyzowka[3][7] = 0;
            krzyzowka[3][8] = 0;
    }

    public int kolumnaZHaslem(){
        for(int wiersz = 0; wiersz < haslo.length(); wiersz++){
            for(int kolumna = 0; kolumna < 4; kolumna++){
                if(krzyzowka[wiersz][kolumna] == 'J'){
                    return kolumna;
                }
            }
        }
        return 0;
    }

    public String[] dajKrzyzowke(){
        String[] stringKrzyzowka = new String[haslo.length()];
        for(int wiersz = 0; wiersz < haslo.length(); wiersz++){
            for(int kolumna = 0; kolumna < 4; kolumna++){
                if(krzyzowka[wiersz][kolumna] != 0){
                    stringKrzyzowka[wiersz] += krzyzowka[wiersz][kolumna];
                }else {
                    stringKrzyzowka[wiersz] += "#";
                }
            }
        }
        return stringKrzyzowka;
    }
        
   public String[] dajPytanie(){ // Nie jest typem Pytania[] bo nie przekazuje nigdzie takiej tablicy pytan
       String[] pytanka = new String[haslo.length()];
       for(int i = 0; i < haslo.length(); i++){
            pytanka[i] += odpowiedz.get(i);
            pytanka[i] += " ";
            pytanka[i] += pytania.get(i);
       }
    return pytanka;
   }

    // boolean uloz(String haslo){
                // out of time unfortunately, could not make it
    // }
}