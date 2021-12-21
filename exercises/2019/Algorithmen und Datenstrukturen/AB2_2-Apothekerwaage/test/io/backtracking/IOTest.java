package io.backtracking;

import de.thm.mni.aud.commons.AbstractInputOutputTest;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.fail;

public class IOTest extends AbstractInputOutputTest {

    private Integer[][] counterWeights;
    private Integer[] weights;

    @Before
    public void init() {
        if (studentOutputLines.size() != studentInputLines.size()) {
            fail("Number of input and output lines do not match!");
        }
        counterWeights = new Integer[studentOutputLines.size()][];
        weights = new Integer[studentInputLines.size()];
        for (int i = 0; i < studentOutputLines.size(); i++) {
            try {
                if (studentOutputLines.get(i).isEmpty()) {
                    counterWeights[i] = new Integer[1];
                    counterWeights[i][0] = 0;
                } else {
                    counterWeights[i] = Arrays.stream(studentOutputLines.get(i).split(","))
                            .map(Integer::parseInt).toArray(Integer[]::new);
                }
                weights[i] = Integer.parseInt(studentInputLines.get(i));
                //System.out.println(Arrays.toString(counterWeights[i]));
            } catch (NumberFormatException nfe) {
                fail(String.format("Error in line %d: Cannot parse number (%s)", i, studentOutputLines.get(i)));
            }
        }
    }

    @Test
    public void testCounterweightsFromSet() {
        Set<Character> possibleCounterweights = new HashSet<>();
        possibleCounterweights.add('0');
        possibleCounterweights.add('2');
        possibleCounterweights.add('7');
        for (int i = 0; i < counterWeights.length; i++) {
            for (int j = 0; j < counterWeights[i].length; j++) {
                char[] str = counterWeights[i][j].toString().toCharArray();
                if (!possibleCounterweights.contains(str[0])) {
                    fail(String.format("Error in line %d: Number not in the set of possible counterweights (%d)",
                            i, counterWeights[i][j]));
                }
                for (int k = 1; k < str.length; k++) {
                    if (str[k] != '0') {
                        fail(String.format("Error in line %d: Number not in the set of possible counterweights (%d)",
                                i, counterWeights[i][j]));
                    }
                }
            }
        }
    }

    @Test
    public void testCounterweights() {
        for (int i = 0; i < weights.length; i++) {
            //System.out.println(weights[i]);
            //Arrays.stream(counterWeights[i]).forEach(n -> System.out.printf("%d,", n));
            //System.out.println();
            if (weights[i].intValue() != Arrays.stream(counterWeights[i]).reduce(0, Integer::sum).intValue()) {
                fail(String.format("Error in line %d: Counterweights %s do not fit the weight %d", i, Arrays.toString(counterWeights[i]), weights[i]));
            }
        }
    }


}
