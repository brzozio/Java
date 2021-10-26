import java.awt.Component; // komponent graficzny
import java.awt.Container; // komponent, ktory moze przechowywac inne komponenty


public class Gui {
    public static void main(String[] args) {
        public Component add(Component comp){
            // dodawanie komponentu do konca listy komponentow
            // nalezy pozniej wywolac metode validate() po dodaniu komponentu
        }

        public Component getComponent(int n){
            // zwraca referencje do n-tego komponentu w danym kontenerze
        }

        public void remove(Component comp){
            // usuwa z kontenera element, do ktorego referencje podano jako argument
        }
        // LAYOUT MENEDZER odpowiada za rozmieszczenie elementów w kontenerze
        
    }
}