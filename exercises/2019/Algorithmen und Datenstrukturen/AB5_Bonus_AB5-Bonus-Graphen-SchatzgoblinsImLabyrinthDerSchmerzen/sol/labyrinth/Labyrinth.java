package labyrinth;

import java.util.*;


public final class Labyrinth {

    private Map<Integer, Map<Integer,Room>> labyrinth;
    private List<String> asciiLabyrinth;
    private Room startRoom;


    public Labyrinth(List<String> asciiLabyrinth){
        this.asciiLabyrinth = asciiLabyrinth;

        int sizeX = asciiLabyrinth.size()-1;
        int sizeY = asciiLabyrinth.get(0).length()-1;

        initLabyrinth(sizeX,sizeY);
        makeGraphfromAscii(sizeX,sizeY);
    }

    /* Erstellt aus einem Ascii-Labyrinth einen Graphen. Das Labyrinth muss komplett ummauert sein. Es darf keine
    * Öffnungen geben! Räume sind als Leerzeichen definiert (Ascii-Code 32), Wände können als beliebiges Zeichen
    * definiert sein (Am besten "*" oder "#". */
    private void makeGraphfromAscii(int sizeX, int sizeY) {

        labyrinth.forEach((x, roomMap) -> {
            roomMap.forEach((y, room) -> {
                room.connectRooms(getNeighbors(x, y));
            });
        });
    }


    // Erstellt eine Linked-List mit den möglichen Räumen. Jeder Raum erhält eine eindeutige Nummer.
    private void initLabyrinth(int sizeX,int sizeY) {

        this.labyrinth = new HashMap<>();
        int roomNumber = 1;

        for (int x = 0; x < sizeX; x++) {

            HashMap<Integer,Room> roomMap = new HashMap<>();

            for (int y = 0; y < sizeY; y++) {
                char labChar = this.asciiLabyrinth.get(x).charAt(y);
                if (labChar == 32) { // Integer value of char " ".
                    Room room = new Room(roomNumber);
                    if (roomNumber == 1){
                        this.startRoom = room;
                    }

                    roomMap.put(y,room);
                    labyrinth.put(x,roomMap);
                    roomNumber++;
                }
            }
        }
    }


    // Findet die benachbarten Räume einer Koordinate im Labyrinth
    private List<Room> getNeighbors(int x,int y) {
        List<Room> neighbor = new ArrayList<>();

        char up = asciiLabyrinth.get(x-1).charAt(y);
        char down = asciiLabyrinth.get(x+1).charAt(y);
        char left = asciiLabyrinth.get(x).charAt(y-1);
        char right = asciiLabyrinth.get(x).charAt(y+1);

        if (up == 32) {
            neighbor.add(labyrinth.get(x-1).get(y));
        }

        if (down == 32) {
            neighbor.add(labyrinth.get(x+1).get(y));
        }

        if (left == 32) {
            neighbor.add(labyrinth.get(x).get(y-1));
        }

        if (right == 32) {
            neighbor.add(labyrinth.get(x).get(y+1));
        }

        return neighbor;
    }


    // Liefert den Graphen zurück. Beginnt mit dem Startraum, Koordinaten 1x1 im Labyrinth
    public Room getLabyrinth() {
        return this.startRoom;
    }


    // Liefert eine Liste mit allen Räumen zurück.
    public List<Room> getRooms() {
        List<Room> listOfRooms = new ArrayList<>();

        labyrinth.forEach((x, roomMap) -> {
            roomMap.forEach((y, room) -> {
                listOfRooms.add(room);
            });
        });

        return listOfRooms;
    }

}
