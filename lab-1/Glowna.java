import java.time.LocalTime;

public class Glowna {
    public static void main(String[] args){
        System.out.println("Moj pierwszy program");
        LocalTime localTime = LocalTime.now();
        int sekundy = localTime.getSecond(); 

        if(sekundy > 30){
            System.out.println("IF - Spelniony warunek SEKUNDY > 30");
        } else {
            System.out.println("IF - Brak spelnionego warunku SEKUNDY > 30");
        }

        String failOrPass = (sekundy > 30) ? "3P - spelniony warunek": "3P - niespelniony warunek";
            System.out.println(failOrPass);
    }
}
