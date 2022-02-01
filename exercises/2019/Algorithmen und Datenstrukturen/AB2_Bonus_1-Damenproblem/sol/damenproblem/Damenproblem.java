package damenproblem;

import java.util.*;

public class Damenproblem {

    private static Optional<Coordinate> castRay(int[][] field, Coordinate start, int xMod, int yMod) {
        int xPos = start.x;
        int yPos = start.y;
        while (true) {
            xPos += xMod;
            yPos += yMod;
            if (!(xPos >= 0 && xPos <= field.length - 1 && yPos >= 0 && yPos <= field[0].length - 1)) {
                return Optional.empty();
            } else if (field[xPos][yPos] > 0) {
                return Optional.of(new Coordinate(xPos, yPos));
            }
        }
    }

    private static boolean somethingInTheWay(int[][] field, Direction direction, Coordinate start) {
        int[] modifiers = direction.getModifiers();
        Optional<Coordinate> blocking = castRay(field, start, modifiers[0], modifiers[1]);
        return blocking.isPresent();
    }

    public static boolean canPlace(int[][] field, Coordinate position) {
        if (field[position.x][position.y] > 0) return false;
        return Arrays.stream(Direction.values()).noneMatch(a -> somethingInTheWay(field, a, position));
    }

    private static List<Coordinate> place(int nDamen, int[][] field) {
        if (nDamen == 0) return new LinkedList<>();
        for (int x = 0; x < field.length; x++) {
            for (int y = 0; y < field[0].length; y++) {
                if (!canPlace(field, new Coordinate(x, y)))
                    continue;
                field[x][y] = 42;
                List<Coordinate> res = place(nDamen - 1, field);
                if (res == null) {
                    field[x][y] = 0;
                } else {
                    res.add(new Coordinate(x, y));
                    return res;
                }
            }
        }
        return null;
    }

    public static List<Coordinate> place(int nDamen, int nSize) {
        int[][] field = new int[nSize][nSize];
        List<Coordinate> res = place(nDamen, field);
        return (res == null) ? new ArrayList<>() : res;
    }

    public static void main(String[] args) {
        List<Coordinate> positions = Damenproblem.place(8, 8);
        positions.forEach(System.out::println);
    }
}
