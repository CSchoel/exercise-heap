package io.levenshtein;

import de.thm.mni.aud.commons.AbstractInputOutputTest;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.fail;

public class DistanceTest extends AbstractInputOutputTest {

    private List<Integer> distances = new LinkedList<>();
    private List<Integer> calculatedDistances = new LinkedList<>();

    @Before
    public void init() {
        if (studentOutputLines.size() != studentInputLines.size()) {
            fail("Number of input and output lines do not match!");
        }
        studentOutputLines.forEach(a -> distances.add(Integer.parseInt(a)));
        studentInputLines.stream()
                .map((String a) -> a.toLowerCase().split(";"))
                .mapToInt((a) -> Levenshtein.distance(a[0], a[1]))
                .forEach(a -> calculatedDistances.add(a));
    }

    @Test
    public void distancesCorrect() {
        for (int i = 0; i < distances.size(); i++) {
            if (!distances.get(i).equals(calculatedDistances.get(i))) {
                String[] splitted = studentInputLines.get(i).toLowerCase().split(";");
                fail(String.format("Error in line %d: The words %s and %s don't have the distance %d (%d)",
                        i,
                        splitted[0],
                        splitted[1],
                        distances.get(i),
                        calculatedDistances.get(i)));
            }
        }
    }

}
