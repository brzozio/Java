public class Przyklad {
    public static void main(String[] args){
        int tab[][] = new int[10][];
        tab[0] = new int[2];
        tab[2] = new int[5];

        int ileWierszy = tab.length;
        int suma = 0;
        
        for(int i = 0; i < ileWierszy; i++){
            if(tab[i] != null){
               for(int j = 0; j < tab[i].length; j++){
                    suma += tab[i][j];
                } 
            }
        }
    }
}