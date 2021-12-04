import javax.swing.JButton; // przyciski
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import java.awt.event.MouseAdapter;
import java.awt.GridLayout; // GridLayout
import java.awt.FlowLayout;
import java.awt.Container;
import java.awt.event.*; // ActionEvent oraz ActionListener

import javax.swing.JPanel;
import java.awt.BorderLayout;

public class Okno2 extends JFrame {
    double[][] tabela = new double[2][2];
    Macierz macierz = new Macierz(tabela);

    Okno2(){
        setTitle("Drugie okno");
        setSize(420,420);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());



         // KONTERNER GLOWNY
         Container mainContainer = new Container();
         add(mainContainer);
         mainContainer.setLayout(new BorderLayout());

     JPanel panelMacierz = new JPanel();
         mainContainer.add(panelMacierz, BorderLayout.CENTER); // dodawanie do srodka
         panelMacierz.setLayout(new GridLayout(2,2));
    
     JTextField macierz11 = new JTextField(5);
         panelMacierz.add(macierz11);
     JTextField macierz12 = new JTextField(5);
         panelMacierz.add(macierz12);
     JTextField macierz21 = new JTextField(5);
         panelMacierz.add(macierz21);
     JTextField macierz22 = new JTextField(5);
         panelMacierz.add(macierz22);
         

     JPanel southTextPanel = new JPanel();
         mainContainer.add(southTextPanel, BorderLayout.SOUTH);
         southTextPanel.setLayout(new FlowLayout());
         JButton przyciskSouthPanel = new JButton("OBLICZ WYZNACZNIK");
             southTextPanel.add(przyciskSouthPanel);

            //   double[][] tabela = new double[2][2];
             ActionListener event = new ActionListener(){ // towrzenie ActionListenera - odbiornika
                 public void actionPerformed(ActionEvent arg0){
                     
                     macierz.tabela[0][0] = Double.parseDouble(macierz11.getText());
                     macierz.tabela[1][0] = Double.parseDouble(macierz21.getText());
                     macierz.tabela[0][1] = Double.parseDouble(macierz12.getText());
                     macierz.tabela[1][1] = Double.parseDouble(macierz22.getText());
                   
                    double wynik = macierz.dajWyznacznik();
                     JOptionPane.showMessageDialog(Okno2.this, "Wynik to: " + wynik);
                  }
              }; 
                 przyciskSouthPanel.addActionListener(event);

        
        JButton buttonSuma = new JButton("SUMA");
        southTextPanel.add(buttonSuma);

        ActionListener suma = new ActionListener(){ // towrzenie ActionListenera - odbiornika
            public void actionPerformed(ActionEvent arg0){
                macierz.tabela[0][0] = Double.parseDouble(macierz11.getText());
                macierz.tabela[1][0] = Double.parseDouble(macierz21.getText());
                macierz.tabela[0][1] = Double.parseDouble(macierz12.getText());
                macierz.tabela[1][1] = Double.parseDouble(macierz22.getText());

                double suma = macierz.tabela[0][0] + macierz.tabela[1][0] + macierz.tabela[0][1] + macierz.tabela[1][1];
                JOptionPane.showMessageDialog(Okno2.this,"Wynik to: " + suma);
             }
         }; 
            buttonSuma.addActionListener(suma);

        JButton buttonTransponuj = new JButton("TRANSPONUJ");
        southTextPanel.add(buttonTransponuj);

            ActionListener Transponuj = new ActionListener(){ // towrzenie ActionListenera - odbiornika
                public void actionPerformed(ActionEvent arg0){
                    macierz.tabela[0][0] = Double.parseDouble(macierz11.getText());
                    macierz.tabela[1][0] = Double.parseDouble(macierz21.getText());
                    macierz.tabela[0][1] = Double.parseDouble(macierz12.getText());
                    macierz.tabela[1][1] = Double.parseDouble(macierz22.getText());

                    double[][] tablicaTemp = new double[2][2];
                        tablicaTemp[0][1] = macierz.tabela[0][1];
                        tablicaTemp[1][0] = macierz.tabela[1][0];
                        
                        macierz.tabela[0][1] = tablicaTemp[1][0];
                        macierz.tabela[1][0] = tablicaTemp[0][1];

                    macierz12.setText("" + macierz.tabela[0][1]);
                    macierz21.setText("" + macierz.tabela[1][0]);
                 }
             }; 
             buttonTransponuj.addActionListener(Transponuj);

        pack();
    }
}