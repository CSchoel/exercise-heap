package labyrinth;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class GoblinDresche {

    public static void main(String[] args) throws IOException {

        // Beispielcode zur Genenerierung des Labyrinths aus einer Textdatei
        List<String> lab = Files.readAllLines(Paths.get("labyrinth_small.txt"));
        final Labyrinth labyrinth = new Labyrinth(lab);
        List roomList = findeDenGoblin(labyrinth, 5);

    }


    public static List<Integer> findeDenGoblin(Labyrinth labyrinth, int reichweite) {
        List<Room> rooms = labyrinth.getRooms();
        if (rooms.size()  == 0) {
            return new LinkedList<>();
        }
    	boolean[] visited = new boolean[rooms.size() + 1];
    	Room startRoom = labyrinth.getLabyrinth();
    	visited[startRoom.getRoomNumber()] = true;
    	dfs(startRoom, visited, 0, reichweite);
        return IntStream.range(0, visited.length)
                .filter(i -> visited[i])
                .boxed()
                .collect(Collectors.toList());
    }
    

    private static void dfs(Room room, boolean[] visited, int depth, int maxDepth) {
        if (depth >= maxDepth) {
            return;
        }
        for (Room neighbor : room.getNeighborRooms()) {
            if (!visited[neighbor.getRoomNumber()]) {
                visited[neighbor.getRoomNumber()] = true;
                dfs(neighbor, visited, depth + 1, maxDepth);
            }
        }
    }

}
