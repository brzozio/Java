abstract public class FiguraGeometryczna { // nie mozna utworzyc obiektu klasy abstrakcyjnej
    abstract public double polePowierzchni(); // cala klasa jest abstrakcyjna wtedy (czyli nie maja podanej implementacji)
    abstract public double obwod();

    private double[] boki;
    public void ustawDlugosciBokow(double[] boki){
        this.boki = boki.clone();
    }
}