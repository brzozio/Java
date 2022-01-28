import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.UIManager;

abstract class SudokuField extends JLabel{
    private int value;
    JLabel label = new JLabel();
    public SudokuField(int valueInjected){
        Integer intTmp = valueInjected;
        String temp = intTmp.toString();
        this.label = new JLabel(temp);
        this.setDisplayedValue(valueInjected); // nie dziala nie wiem czemu, wiec musialem dodac to wyzej
        this.label.setHorizontalAlignment(CENTER);
        this.label.setVerticalAlignment(CENTER);
    }

    protected SudokuField getSudokuField(){
        return this;
    }
    protected void setSudokuField(){
      //
    }

    protected void setDisplayedValue(int valueInjected){
        if(value != 0){
            this.value = valueInjected;
            Integer integerValue = valueInjected;
            String valueString = integerValue.toString();
            this.label = new JLabel(valueString);
        }
    }
    
    public void setError(boolean bboolean){
    if(bboolean == true){
        this.setBackground(Color.red);
    }else if(bboolean == false){
        UIManager.getColor("Panel.background");
    }
        
    }
}
