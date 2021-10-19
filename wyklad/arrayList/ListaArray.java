import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ListaArray {
    public static void main(String[] args) {
        /*ArrayList<Integer> lista = new ArrayList<>();
        lista.add(3);
        
        long time0 = System.currentTimeMillis();*/

        List<Integer> lista = new LinkedList<>();
        for(int i = 0; i < 10000; i++){
           lista.add(3); 
        }
    }
}