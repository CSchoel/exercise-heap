package hillclimbing;

import java.util.ArrayList;
import java.util.List;

public class Hillclimber {
    private int[][] hill;

    public static void main(String[] argv) {
        //int[][] hill = generateHill(42, 42, 42);
        //Coordinate top = new Hillclimber(hill).climb(new Coordinate(hill.length - 1,
        //  hill.length - 1), new ClimbListener());
    }

    public static int[][] generateHill(int size, double noiseFactor, int offset) {
        int[][] hill = new int[size][size];
        for (int x = 0; x < hill.length; x++) {
            for (int y = 0; y < hill[x].length; y++) {
                double val = ImprovedNoise.noise((x + offset) / noiseFactor, (y + offset) / noiseFactor, 0) * 100;
                hill[x][y] = Math.abs((int) val);
                //System.out.printf("%d,\t", hill[x][y]);
            }
            //System.out.println();
        }
        return hill;
    }

    public Hillclimber(int[][] hill) {
        this.hill = hill;
    }

    private List<Coordinate> getNeighbours(Coordinate position) {
        List<Coordinate> neighbours = new ArrayList<>();
        if (position.y - 1 >= 0) neighbours.add(new Coordinate(position.x, position.y - 1));
        if (position.x + 1 < hill.length) neighbours.add(new Coordinate(position.x + 1, position.y));
        if (position.y + 1 < hill[position.x].length) neighbours.add(new Coordinate(position.x, position.y + 1));
        if (position.x - 1 >= 0) neighbours.add(new Coordinate(position.x - 1, position.y));
        return neighbours;
    }

    private Coordinate highest(List<Coordinate> positions) {
        int highest = -1;
        Coordinate highestCoordinate = null;
        for (Coordinate coordinate : positions) {
            if (hill[coordinate.x][coordinate.y] >= highest) {
                highest = hill[coordinate.x][coordinate.y];
                highestCoordinate = coordinate;
            }
        }
        return highestCoordinate;
    }

    /*
    private List<Coordinate> allHighest(Coordinate position) {
        List<Coordinate> neighbours = getNeighbours(position);
        Coordinate highestPos = highest(neighbours);
        int highest = hill[highestPos.x][highestPos.y];
        List<Coordinate> out = new ArrayList<>();
        for (Coordinate coordinate : neighbours) {
            if (hill[coordinate.x][coordinate.y] == highest) {
                out.add(coordinate);
            }
        }
        return out;
    }


    public CoordinateTree allPaths(Coordinate start, CoordinateTree parent) {
        //System.out.printf("%d %d\n", start.x, start.y);
        System.out.printf("new Coordinate(%d, %d)))\n", start.x, start.y);
        CoordinateTree out = new CoordinateTree(parent, start);
        List<Coordinate> children = allHighest(start);
        for (Coordinate coordinate : children) {
            if (!out.beenThere(coordinate) && hill[coordinate.x][coordinate.y] > hill[start.x][start.y]) {
                System.out.print(".addChild(new CoordinateTree(null, ");
                out.addChild(allPaths(coordinate, out));
                //System.out.print("))");
            }
        }
        System.out.print("\n");
        return out;
    }
    */

    /**
     * Implements a greedy algorithm to "climb" a 2d-array with height levels.
     *
     * @param start         the starting point
     * @param climbListener a listener whose climbCallback method is called for each position the climbing algorithm is on
     * @return the top of the hill
     */
    public Coordinate climb(Coordinate start, ClimbListener climbListener) {
        //System.out.printf("%d %d\n", start.x, start.y);
        climbListener.climbCallback(start);
        Coordinate highestNeighbour = highest(getNeighbours(start));
        int highest = hill[highestNeighbour.x][highestNeighbour.y];
        if (highest > hill[start.x][start.y]) {
            return climb(highestNeighbour, climbListener);
        } else {
            return start;
        }
    }
}
