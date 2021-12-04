import javax.swing.JFrame;


public class Macierz extends JFrame {
    int wiersz = 0;
    int kolumna = 0;
    double[][] tabela = new double[2][2];

    public Macierz(double[][] tabelaPrzekazywana){  // konstruktor do macierzy, przechwytujący tabele i dodający ją do macierzy
       this.tabela = tabelaPrzekazywana;
    }

    public double dajElement(int wierszPrzekazywany, int kolumnaPrzekazywana){
        System.out.println("Element o wierszu: " + wierszPrzekazywany + " oraz kolumnie: " + kolumnaPrzekazywana + " to: " + tabela[wierszPrzekazywany][kolumnaPrzekazywana]);
        return this.tabela[wierszPrzekazywany][kolumnaPrzekazywana];
    }

    public void ustawElement(int wierszPrzekazywany, int kolumnaPrzekazywana, double wartoscPrzekazywana){
        this.tabela[wierszPrzekazywany][kolumnaPrzekazywana] = wartoscPrzekazywana;
    }

    public double dajWyznacznik(){
       return this.tabela[0][0]*this.tabela[1][1] - this.tabela[0][1]*this.tabela[1][0];
    }
}