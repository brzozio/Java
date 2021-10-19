public interface MaPolePowierzchni {
    public double polePowierzchni();


// defaultowa implementacja wraz z implementacja interfejsu MaPolePowierzchni
// nie tzeba ich dodawac do klas do ktorych interfejs jest implementowany w odroznieniu
// od metod nie "default" ktore trzeba dodwac
    default public double polePowierzchniInne(){  
        return 0;
    }
}
