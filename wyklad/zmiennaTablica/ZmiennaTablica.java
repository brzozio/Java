public class ZmiennaTablica {
    private int[] tab;
    private int ileElementow = 0;

    public ZmiennaTablica() {
        //tab = new int[0];
        tab = new int[100];
    }

    public int dlugosc(){
       // return tab.length; 
       return ileElementow;
    }

    public void dodaj(int element){
        /* // Niezbyt efektywne
        int nowaTab[] = new int[dlugosc() + 1];
        for(int i = 0; i < nowaTab.length - 1; i++){
            nowaTab[i] = tab[i];
        }
        nowaTab[nowaTab.length - 1] = element;
        tab = nowaTab;
        

        if(ileElementow == tab.length){
            int nowaTab[] = new int[dlugosc() + 1];
            for(int i = 0; i < nowaTab.length - 1; i++){
                nowaTab[i] = tab[i];
            }
            tab = nowaTab;
        }
        tab[ileElementow] = element;
        */
        if(ileElementow == tab.length){
            int nowaTab[] = new int[dlugosc()*2];
            for(int i = 0; i < nowaTab.length - 1; i++){
                nowaTab[i] = tab[i];
            }
            tab = nowaTab;
        }
        tab[ileElementow++] = element;
    }
}
