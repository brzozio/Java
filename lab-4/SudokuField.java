import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.UIManager;

abstract class SudokuField extends JLabel{
    private int value;
    JLabel label = new JLabel();
    public SudokuField(int valueInjected){
        this.setDisplayedValue(valueInjected);
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
            this.label.setText(valueString);
        }else this.value = (Integer) null;
    }
    
    public void setError(boolean bboolean){
    if(bboolean == true){
        this.setBackground(Color.red);
    }else if(bboolean == false){
        UIManager.getColor("Panel.background");
    }
        
    }
}
