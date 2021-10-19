public class PrzykladKlasyAbstra {
    public static void main(String[] args) {
        FiguraGeometryczna figura = new FiguraGeometryczna() {
            @Override // nadpisywanie klasy FiguraGeometryczna
            public double polePowierzchni(){
                return 0;
            }

            @Override
            public double obwod(){
                return 56;
            }
        };
        System.out.println(figura.obwod());
    }
}
