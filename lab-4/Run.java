import javax.swing.SwingUtilities;

public class Run {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            (new SudokuWindow()).setVisible(true);
            //(new SudokuWindow()).readPuzzle();
            //(new SudokuWindow()).createGui();
        });
    }
}
