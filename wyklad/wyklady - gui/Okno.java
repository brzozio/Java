import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import java.awt.GridLayout;
import java.awt.Container;

public class Okno extends JFrame {
    Okno(){
        setTitle("Minecraft 1.17.1");
        setSize(1920, 1080);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(3,1));
        JButton button = new JButton("Przycisk 1");
            add(button);
        JButton button2 = new JButton("Przycisk 2");
            add(button2);
        JButton button3 = new JButton("Przycisk 3");
            add(button3);

        public void actionPerformed(ActionEvent e){
            numClicks++;
            text.setText("Button clcicked " + numClicks + " times");
        }

        button3.addActionListener((e) -> {
            button3.HEIGHT = 100;
            button3.WIDTH = 100;
        });

        

        pack();

        /*
        Container c = this.getContentPane();
        //c.setLayout(new GridLayout(3,1));
        JButton b;
        c.add(b = new JButton("Otworz"));

        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0){
                JDialog d = new JDialog(Okno.this, true);
                d.setSize(200,200);
                d.setLocationRelativeTo(null);
                d.setVisible(true);
            }
        });
        c.add(new JButton("Przycisk 2"));
        c.add(new JButton("Przycisk 3"));
        pack();
    */
    }
}