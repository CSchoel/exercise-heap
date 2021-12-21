package hillclimbing;

import java.util.ArrayList;
import java.util.List;

public class ClimbListener {
    private List<Coordinate> path = new ArrayList<>();

    /**
     * Returns all positions stored by the climbCallback method. The output is sorted chronologically by the time of insertion.
     *
     * @return the list of positions
     */
    public List<Coordinate> getPath() {
        return path;
    }

    /**
     * To be used in the hillclimbing exercise. This function must be called for each step the solving algorithm takes.
     * The argument is stored in an internal datastructure that can be read by using the getPath() method.
     *
     * @param newPosition the position to store
     */
    public void climbCallback(Coordinate newPosition) {
        path.add(newPosition);
        //System.out.printf("new Coordinate(%d, %d), \n", newPosition.x, newPosition.y);
    }
}
