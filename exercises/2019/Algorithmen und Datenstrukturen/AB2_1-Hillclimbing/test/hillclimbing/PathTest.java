package hillclimbing;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.fail;

public class PathTest {


    private int[][] hill0 = generateHill(25, 17, 0);
    private int[][] hill1 = generateHill(42, 42, 42);

    private int[][] generateHill(int size, double noiseFactor, int offset) {
        int[][] hill = new int[size][size];
        for (int x = 0; x < hill.length; x++) {
            for (int y = 0; y < hill[x].length; y++) {
                double val = ImprovedNoise.noise((x + offset) / noiseFactor, (y + offset) / noiseFactor, 0) * 100;
                hill[x][y] = Math.abs((int) val);
            }
        }
        return hill;
    }

    private List<Coordinate> getNeighbours(Coordinate position, int[][] hill) {
        List<Coordinate> neighbours = new ArrayList<>();
        if (position.y - 1 >= 0) neighbours.add(new Coordinate(position.x, position.y - 1));
        if (position.x + 1 < hill.length) neighbours.add(new Coordinate(position.x + 1, position.y));
        if (position.y + 1 < hill[position.x].length) neighbours.add(new Coordinate(position.x, position.y + 1));
        if (position.x - 1 >= 0) neighbours.add(new Coordinate(position.x - 1, position.y));
        return neighbours;
    }

    private Coordinate highest(List<Coordinate> positions, int[][] hill) {
        int highest = -1;
        Coordinate highestCoordinate = null;
        for (Coordinate Coordinate : positions) {
            if (hill[Coordinate.x][Coordinate.y] >= highest) {
                highest = hill[Coordinate.x][Coordinate.y];
                highestCoordinate = Coordinate;
            }
        }
        return highestCoordinate;
    }

    private void printPath(Coordinate[] path) {
        Arrays.stream(path).forEach(System.out::print);
        System.out.println();
    }

    private void testPath(int[][] hill, Coordinate[] path, int hillNumber) {
        for (int i = 0; i < path.length; i++) {
            List<Coordinate> neighbours = getNeighbours(path[i], hill);
            Coordinate highestCoord = highest(neighbours, hill);
            if (i < path.length - 1 && hill[path[i + 1].x][path[i + 1].y] != hill[highestCoord.x][highestCoord.y]) {
                //printPath(path);
                fail(String.format(
                        "Did not take the highest step on hill %d (from {%d, %d} to {%d, %d}). Step height: %d, highest neighbour: %d. On the path with start at {%d, %d}",
                        hillNumber,
                        path[i].x,
                        path[i].y,
                        path[i + 1].x,
                        path[i + 1].y,
                        hill[path[i + 1].x][path[i + 1].y],
                        hill[highestCoord.x][highestCoord.y],
                        path[0].x,
                        path[0].y));
            }

        }
        //Don't forget to test if we're actually done.

        List<Coordinate> neighbours = getNeighbours(path[0], hill);
        Coordinate highestCoord = highest(neighbours, hill);
        if (hill[path[path.length - 1].x][path[path.length - 1].y] < hill[highestCoord.x][highestCoord.y]) {
            //printPath(path);
            fail(String.format("You stopped moving too early on hill %d (at %d, %d). There still possible steps (to %d, %d).",
                    hillNumber,
                    path[path.length - 1].x,
                    path[path.length - 1].y,
                    highestCoord.x,
                    highestCoord.y
            ));
        }
    }

    private void testPaths(Hillclimber hillclimber, ClimbListener[] listeners, Coordinate[] starts, int[][] hill, int hillNumber) {
        for (int i = 0; i < starts.length; i++) {
            hillclimber.climb(new Coordinate(starts[i].x, starts[i].y), listeners[i]);
            List<Coordinate> userPath = listeners[i].getPath();
            if (userPath == null || userPath.size() == 0) {
                fail(String.format("Your path is empty (Startpoint at {%d, %d})", starts[i].x, starts[i].y));
            }
            Coordinate[] path = userPath.toArray(new Coordinate[0]);
            testPath(hill, path, hillNumber);
        }
    }

    private Coordinate[] startPoints(int[][] hill) {
        Coordinate[] starts = new Coordinate[hill.length * hill[0].length];
        for (int i = 0; i < hill.length; i++) {
            for (int j = 0; j < hill[0].length; j++) {
                starts[i * hill.length + j] = new Coordinate(i, j);
            }
        }
        return starts;
    }

    private void hillTest(int[][] hill, int hillNumber) {
        Hillclimber hillclimber = new Hillclimber(hill);
        Coordinate[] startPoints = startPoints(hill);
        ClimbListener[] listeners = new ClimbListener[startPoints.length];
        for (int i = 0; i < listeners.length; i++) {
            listeners[i] = new ClimbListener();
        }
        testPaths(hillclimber, listeners, startPoints, hill, hillNumber);

    }

    @Test
    public void hill0FullPathTest() {
        hillTest(hill0, 0);
    }

    @Test
    public void hill1FullPathTest() {
        hillTest(hill1, 1);
    }
}
