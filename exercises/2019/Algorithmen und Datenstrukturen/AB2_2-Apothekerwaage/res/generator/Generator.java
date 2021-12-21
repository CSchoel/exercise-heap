package generator;

import java.util.*;

public class Generator {

    private static int[] baseWeights = {2, 7};
    private static int maxWeightSum = 1000;

    private static int counterWeightAt(int index) {
        return baseWeights[(index % baseWeights.length)] * (int) Math.pow(10, index / baseWeights.length);
    }

    public static void main(String args[]) {
        Random rand = new Random();
        for (int i = 0; i < 500; i++) {
            int length = rand.nextInt(14);
            List<Integer> weights = new ArrayList<>();
            for (int j = 0; j < length; j++) {
                int weight = counterWeightAt(rand.nextInt(length));
                if(weights.stream().mapToInt(Integer::intValue).sum() + weight >= maxWeightSum) break;
                weights.add(weight);
            }
            //weights.forEach((w) -> System.out.print(String.format("%d,", w)));
            //System.out.println();
            System.out.println(weights.stream().mapToInt(Integer::intValue).sum());
        }
    }

}
