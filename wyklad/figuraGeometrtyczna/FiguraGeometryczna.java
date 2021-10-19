import java.util.Map;

abstract public class FiguraGeometryczna implements MaPolePowierzchni, MaObwod{ // nie mozna utworzyc obiektu klasy abstrakcyjnej
    //abstract public double polePowierzchni(); // cala klasa jest abstrakcyjna wtedy (czyli nie maja podanej implementacji)
    

    private double[] boki;
    public void ustawDlugosciBokow(double[] boki){
        this.boki = boki.clone();
    }
}