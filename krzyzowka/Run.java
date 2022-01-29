import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import javax.swing.SwingUtilities;

public class Run {
    public static void main(String[] args) throws InterruptedException, 
    InvocationTargetException, ParseException {
        SwingUtilities.invokeLater(()->{
            (new KrzyzowkaGUI()).setVisible(true);
        });
    }
}
