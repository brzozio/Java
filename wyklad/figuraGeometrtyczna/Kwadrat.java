public class Kwadrat extends FiguraGeometryczna {
    @Override // nadpisywanie klasy FiguraGeometryczna

    public double polePowierzchni(){ // metoda ktora jest w klasie z ktorej Kwadrat pochodzi (FiguraGeometryczna) musi posiadac tez ta funkcje ktora implementuje klasa wyzsza
        return 0;
    }

    @Override
    public double obwod(){
        return 56;
    }
}
