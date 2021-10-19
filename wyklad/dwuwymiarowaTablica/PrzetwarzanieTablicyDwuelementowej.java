public class PrzetwarzanieTablicyDwuelementowej {
    public static void main(String[] args){
        int tab[][] = new int[10][];
        tab[0] = new int[] {1,2};
        tab[2] = new int[] {3,4,5};

        int ileWierszy = tab.length;
        int suma = 0;
        
        for(int i = 0; i < ileWierszy; i++){
            if(tab[i] != null){
               for(int j = 0; j < tab[i].length; j++){
                    suma += tab[i][j];
                } 
            }
        }
            System.out.println(suma);

        // FOR EACH
        suma = 0;
        for(int[] wiersz:tab){
            if(wiersz != null){
               for(int element:wiersz){
                    suma += element;
                } 
            }
        }
            System.out.println(suma);
    }
}