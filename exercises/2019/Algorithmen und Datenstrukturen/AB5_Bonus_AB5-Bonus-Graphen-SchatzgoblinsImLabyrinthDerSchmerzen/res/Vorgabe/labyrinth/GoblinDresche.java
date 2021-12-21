package labyrinth;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;
import java.util.*;


public class GoblinDresche {

    public static void main(String[] args) throws IOException {

        // Beispielcode zur Genenerierung des Labyrinths aus einer Textdatei
        List<String> lab = Files.readAllLines(Paths.get("labyrinth_small.txt"));
        final Labyrinth labyrinth = new Labyrinth(lab);
        List roomList = findeDenGoblin(labyrinth, 5);

    }


    public static List<Integer> findeDenGoblin(Labyrinth labyrinth, int reichweite) {
        
        // Mit eigenem Code füllen

        return null;
    }
}
