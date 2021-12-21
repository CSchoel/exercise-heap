package io.backtracking;

import de.thm.mni.aud.commons.AbstractInputOutputTest;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.fail;

public class IOHiddenTest extends AbstractInputOutputTest {

    private Integer[][] counterWeights;
    private Integer[] weights;

    @Before
    public void initHidden() {
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

    private static int[] baseWeights = {2, 7};

    private static int counterWeightAt(int index) {
        return baseWeights[(index % baseWeights.length)] * (int) Math.pow(10, index / baseWeights.length);
    }

    private int shortestDepth = Integer.MAX_VALUE;

    private List<Integer> getSmallest(int weight, List<Integer> possibleCounterWeights, int currentDepth) {
        if (currentDepth > shortestDepth) return null;
        if (weight == 0) {
            if (currentDepth < shortestDepth) {
                shortestDepth = currentDepth;
            }
            //System.out.println("Found a solution");
            return new LinkedList<>();
        }
        int shortest = Integer.MAX_VALUE;
        List<Integer> shortestSubPath = null;
        for (Integer n : possibleCounterWeights) {
            if (n > weight || n == 0) continue;
            List<Integer> res = getSmallest(weight - n, possibleCounterWeights, currentDepth + 1);
            if (res != null && res.size() < shortest) {
                shortest = res.size();
                res.add(n);
                shortestSubPath = res;
                //System.out.println(n);
                //return res;
            }
        }
        return shortestSubPath;
    }

    private void printSolution(List<Integer> solution) {
        if (solution == null) {
            System.out.println("No solution found");
        } else {
            StringBuilder out = new StringBuilder();
            solution.forEach(a -> out.append(String.format("%d,", a)));
            System.out.println(out.toString().substring(0, out.length() - 1));
        }
    }

    private List<Integer> testWeight(int weight) {
        shortestDepth = Integer.MAX_VALUE;
        List<Integer> possibleCounterWeights = new LinkedList<>();
        if (weight == 0) {
            List<Integer> res = new LinkedList<>();
            res.add(0);
            //printSolution(res);
            return res;
        }
        int i = 0;
        int cw = 0;
        do {
            possibleCounterWeights.add(cw);
            cw = counterWeightAt(i);
            i++;
        } while (cw <= weight);
        //Ganz wichtig, dass das reversed wird. Sonst läuft der Test ewig.
        List<Integer> reversed = new LinkedList<>();
        for (int j = possibleCounterWeights.size() - 1; j >= 0; j--) {
            reversed.add(possibleCounterWeights.get(j));
        }
        List<Integer> res = getSmallest(weight, reversed, 0);
        //List<Integer> res = getSmallest(weight, possibleCounterWeights, 0);
        //printSolution(res);
        return res;
    }

    @Test
    public void testIsShortest() {
        for (int i = 0; i < weights.length; i++) {
            List<Integer> shortest = testWeight(weights[i]);
            if (shortest == null) {
                throw new IllegalStateException(String.format(
                        "Line %d: Internal error: No solution found by the test. " +
                                "Please contact a teacher!", i));
            }
            if (counterWeights[i].length > shortest.size()) {
                fail(String.format("Error for weight %d: Your solution is too long! Expected: %d , Actual: %s", weights[i],shortest.size(), counterWeights[i].length));
            }
        }
    }


}
