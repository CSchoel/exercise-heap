package uniqueList;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

import org.junit.Test;

public class UniqueListTest {

    public static final int TEST_INPUT_SIZE = 20;

    public static final int RANGE_LOWER_BOUND = 0;

    // the range is smaller than input size to insure presence of duplicates
    public static final int RANGE_UPPER_BOUND = TEST_INPUT_SIZE / 2;

    @Test
    public void distinctTest() {
        List<Integer> input = new Random()
                .ints(TEST_INPUT_SIZE, RANGE_LOWER_BOUND, RANGE_UPPER_BOUND)
                .boxed()
                .collect(Collectors.toList());
        List<Integer> actualOutput = UniqueList.distinct(input);
        List<Integer> expectedOutput = input.stream()
                .distinct()
                .collect(Collectors.toList());
        assertTrue(actualOutput != null
                && expectedOutput.size() == actualOutput.size()
                && actualOutput.containsAll(expectedOutput));
    }
}
