public class Przyklad {
    public static void main(String[] args) {
        ZmiennaTablica zt = new ZmiennaTablica();
        for(int i = 0; i < 100000; i++){
            zt.dodaj(i);
        }
        System.out.println(zt.dlugosc());   
    }
}
