package labyrinth;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by glasen on 19.06.17.
 */
public class Room {

    private ArrayList<Room> NeighborRooms = new ArrayList<>();
    private final int roomNumber;


    public Room(int roomNumber) {
        this.roomNumber = roomNumber;
    }


    public void connectRooms(List<Room> rooms) {
        this.NeighborRooms = (ArrayList<Room>) rooms;
    }

    public int getRoomNumber() {
        return this.roomNumber;
    }


    public ArrayList<Room> getNeighborRooms() {
        return this.NeighborRooms;
    }

}
