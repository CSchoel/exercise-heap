package damenproblem;


import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class TestDamenproblem  {

    private Coordinate[] coordinates8 = {
            new Coordinate(7, 3),
            new Coordinate(6, 1),
            new Coordinate(5, 6),
            new Coordinate(4, 2),
            new Coordinate(3, 5),
            new Coordinate(2, 7),
            new Coordinate(1, 4),
            new Coordinate(0, 0)
    };

    private Coordinate[] coordinates4_1 = {
            new Coordinate(2, 0),
            new Coordinate(0, 1),
            new Coordinate(3, 2),
            new Coordinate(1, 3)
    };
    private Coordinate[] coordinates4_2 = {
            new Coordinate(1, 0),
            new Coordinate(0, 2),
            new Coordinate(3, 1),
            new Coordinate(2, 3)
    };

    private int[][] field8 = filledField(8, coordinates8);
    //private int[][] field4_1 = filledField(4, coordinates4_1);
    //private int[][] field4_2 = filledField(4, coordinates4_2);


    private int[][] filledField(int size, Coordinate[] queens) {
        int[][] emptyField = new int[size][size];
        Arrays.stream(queens).forEach(a -> emptyField[a.x][a.y] = 42);
        return emptyField;
    }

    private boolean compareArrayAndList(List<Coordinate> lst, Coordinate[] arr) {
        return Arrays.stream(arr).anyMatch(lst::contains);
    }

    @Test
    public void testCanPlaceFilled() {
        for (int i = 0; i < field8.length; i++) {
            for (int j = 0; j < field8[0].length; j++) {
                if (Damenproblem.canPlace(field8, new Coordinate(i, j)))
                    fail(String.format("You cannot place a queen at this position (%d, %d)", i, j));
            }
        }
    }

    @Test
    public void testCanPlaceEmpty() {
        int[][] empty = new int[8][8];
        for (int i = 0; i < empty.length; i++) {
            for (int j = 0; j < empty[0].length; j++) {
                if (!Damenproblem.canPlace(empty, new Coordinate(i, j)))
                    fail(String.format("You should be able to place a queen at this position (%d, %d)", i, j));
            }
        }
    }

    @Test
    public void testTheImpossible() {
        if (Arrays.stream(new int[]{0, 2, 3}).anyMatch(a -> Damenproblem.place(a, a).size() != 0)) {
            fail("There is no solution for 0, 2 or 3");
        }
    }

    @Test
    public void testTheEasy() {
        List<Coordinate> solution1 = Damenproblem.place(1, 1);
        if (solution1.size() != 1 && !solution1.get(0).equals(new Coordinate(0, 0))) fail("Wrong position for n = 1");

        List<Coordinate> solution4 = Damenproblem.place(4, 4);
        assertEquals(solution4.size(), 4);
        if (!(compareArrayAndList(solution4, coordinates4_1) || compareArrayAndList(solution4, coordinates4_2))) {
            fail("Incorrect solution for n = 4");
        }
    }



}
