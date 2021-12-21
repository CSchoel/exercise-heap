import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        ArrayList<Integer> numbers = read(args[0]);
        int[] minmax = minmax(numbers);
        int[] top5 = top5(numbers);
        System.out.printf("minmax:\n%d\n%d\n\n", minmax[0], minmax[1]);
        System.out.println("top5:");
        Arrays.stream(top5).forEach(System.out::println);
    }

    private static int[] minmax(ArrayList<Integer> numbers) {
        if (numbers == null) throw new IllegalArgumentException("Invalid ArrayList!");
        AtomicInteger max = new AtomicInteger(Integer.MIN_VALUE);
        AtomicInteger min = new AtomicInteger(Integer.MAX_VALUE);
        numbers.forEach(number -> {
            if (max.get() < number) max.set(number);
            if (min.get() > number) min.set(number);
        });
        return new int[]{min.get(), max.get()};
    }

    private static int[] top5(ArrayList<Integer> numbers) {
        if (numbers == null) throw new IllegalArgumentException("Invalid ArrayList!");
        int[] top5 = new int[5];
        numbers.forEach(number -> {
            for (int i = 0; i < 5; i++) {
                if (number > top5[i]) {
                    System.arraycopy(top5, i, top5, i + 1, 5 - (i + 1));
                    top5[i] = number;
                    break;
                }
            }
        });
        return top5;
    }

    private static ArrayList<Integer> read(String path) {
        try {
            return Files.readAllLines(Paths.get(path))
                    .stream()
                    .map(Integer::parseInt)
                    .collect(Collectors.toCollection(ArrayList::new));
        } catch (IOException e) {
            System.err.println("Could not read file!");
            return null;
        }
    }

}
