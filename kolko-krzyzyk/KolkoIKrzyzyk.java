public class KolkoIKrzyzyk {
    private Gracz czyjaKolej;
    private Gracz[][] plansza;
    KolkoIKrzyzyk(){
        czyjaKolej = Gracz.KOLKO;
        plansza = new Gracz[3][3];
    }

    public Gracz getCzyjaKolej(){
        return czyjaKolej;
    }

    public void pokazPlansze(){
        for(int wiersz = 0; wiersz < 3; wiersz++){
            if(wiersz == 0){
                System.out.println("    A     B    C");
            }
            System.out.print((wiersz+1) + " ");
            for(int kolumna = 0; kolumna < 3; kolumna++){
                if(plansza[wiersz][kolumna] == Gracz.KOLKO){
                    System.out.print("   O");
                } else if(plansza[wiersz][kolumna] == Gracz.KRZYZYK) {
                    System.out.print("   X");
                }else System.out.print("   -");
            }
            System.err.println();
        }
    
    }

    public void wykonajRuch(String ruch){
        int kolumnaRuch = ruch.charAt(0)-'A';
        int wierszRuch = ruch.charAt(1) - '1';
        plansza[wierszRuch][kolumnaRuch] = czyjaKolej;
        if(czyjaKolej == Gracz.KOLKO){
            czyjaKolej = Gracz.KRZYZYK;
        } else {
            czyjaKolej = Gracz.KOLKO;
        }
    }

    public Gracz ktoWygral(){
        for(Gracz g:Gracz.values()) { // petla forEach dla wartosci z enuma 
            // wiersz
            for(int w = 0; w < 3; w++){
                if(plansza[w][0] == g && plansza[w][1] == g && plansza[w][2] == g) return g;
            }
            // kolumna
            for(int k = 0; k < 3; k++){
                if(plansza[0][k] == g && plansza[1][k] == g && plansza[2][k] == g) return g;
            }
            // przekatna
            if(plansza[0][0] == g && plansza[1][1] == g && plansza[2][2] == g) return g;
            if(plansza[0][2] == g && plansza[1][1] == g && plansza[2][0] == g) return g;
        }
        return null;
    }

    public boolean jestRemis(){
        if(ktoWygral() != null) return false;
        int ilePustychPol = 0;

        for(int x = 0; x < 3; x++){
            for(int y = 0; y < 3; y++){
                if(plansza[x][y] == null) ilePustychPol++;
            }
        }
        return ilePustychPol==0;
    }
}
