import java.awt.Color;

public class Run {
    public static void main(String[] args) {
        car Audi = new car();
        car Volkswagen = new car();

        Audi.setColor(Color.red);
        Volkswagen.setColor(Color.red);
        Audi.setModel("A4");
        Volkswagen.setModel("Passat");

        Audi.wlaczSilnik();
        Volkswagen.wlaczSilnik();
    }
}