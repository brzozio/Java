import java.awt.Color;

public class car {
    private String model;
    private Color kolor;
    private Silnik silnik;

    public String getModel(){
        return model;
    }
    public void setModel(String model){
        this.model = model;
        if(this.model != null && !this.model.equals(model)){
            System.out.println("Modelu nie mozna zmienic");
        }
    }
    
    public Color getColor(){
        return kolor;
    }
    public void setColor(Color kolor){
        this.kolor = kolor;
    }


    public void wlaczSilnik(){
        System.out.println(model+": Wlaczam silnik ... ");
        if(silnik==null){
            System.out.println("Nie mamy silnika, zostal w garazu");
        } else {
          silnik.wlacz();  
        }
    }
}
