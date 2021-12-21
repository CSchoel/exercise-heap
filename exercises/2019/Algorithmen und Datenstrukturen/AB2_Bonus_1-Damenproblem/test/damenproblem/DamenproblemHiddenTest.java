package damenproblem;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.fail;

public class DamenproblemHiddenTest {

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

    private static boolean somethingAccessible(int[][] field, Coordinate position) {
        return Arrays.stream(Direction.values()).anyMatch(a -> somethingInTheWay(field, a, position));
    }

    private static int[][] placeQueens(List<Coordinate> positions, int size) {
        int[][] field = new int[size][size];
        positions.forEach(a -> field[a.x][a.y] = 42);
        return field;
    }

    @Test
    public void testSolution() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < i; j++) {
                List<Coordinate> result = Damenproblem.place(j, i);
                if (result.size() != j) {
                    fail(String.format(
                            "Error trying to put %d queens into an %dx%d size field: The number of queens does not match (%d)",
                            j, i, i, result.size()));
                }
                int[][] field = placeQueens(result, i);
                if (result.stream().anyMatch(a -> somethingAccessible(field, a))) {
                    fail(String.format(
                            "Error trying to put %d queens into an %dx%d size field: There are queens blocking each other",
                            j, i, i));
                }
            }
        }
    }
}
