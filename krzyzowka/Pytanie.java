import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.nio.file.Files;

public class Pytanie {
    public List<String> puzzle;
    public String haslo;
    public List<String> wyraz;
    public List<String> wyjasnienie;
    public Pytanie(){
        pobieranieKrzyzowki();
        this.haslo = puzzle.get(0);
        //NA PARZYSTYCH MIEJSCACH JEST WYJASNIENIE, NA NIEPARZYSTYCH WYRAZ
        for(int i_wyraz = 1; i_wyraz < 8; i_wyraz+=2){
            String temp = puzzle.get(i_wyraz);
            System.out.println(temp);
            wyraz.add(temp);
        }

        for(int i_wyjasnienie = 2; i_wyjasnienie < 9; i_wyjasnienie+=2){
            String temp = puzzle.get(i_wyjasnienie);
            System.out.println(temp);
            wyjasnienie.add(temp);
        }
    }

    public void pobieranieKrzyzowki(){ // HASLO -> a potem odp i pytanie w oddzielnych liniach
        try{
            File file = new File("krzyzowka2.txt");
            URI fileUri = file.toURI();
            Path puzzlePath = Paths.get(fileUri);
            puzzle = Files.readAllLines(puzzlePath);
            System.out.println(puzzle);
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
