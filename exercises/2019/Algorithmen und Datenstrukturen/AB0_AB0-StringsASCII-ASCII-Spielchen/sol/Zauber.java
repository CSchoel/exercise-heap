import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Zauber {

    public static void main(String[] args) {
        List<String> lines;
        List<Integer> numbers = new LinkedList<>();
        List<Character> letters = new LinkedList<>();
        String[] tmp;
        try {
            lines = Files.readAllLines(Paths.get("input.txt"));
            for (String line : lines) {
                tmp = line.split("\\s");
                numbers.add(Integer.parseInt(tmp[0]));
                letters.add(tmp[1].charAt(0));
            }
            System.out.println(decode(numbers, letters));
            //numbers.forEach(System.out::println);
            //letters.forEach(System.out::println);
        } catch (IOException e) {
            System.err.println("Bad luck!");
        }
    }

    public static String decode(List<Integer> numbers, List<Character> letters) {
        class Tuple implements Comparable<Tuple> {
            private Integer idx;
            private Character key;

            private Tuple(Integer idx, Character key) {
                this.idx = idx;
                this.key = key;
            }

            @Override
            public int compareTo(Tuple o) {
                return idx.compareTo(o.idx);
            }
        }
        ArrayList<Tuple> kvp = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numbers.size(); i++) {
            kvp.add(new Tuple(numbers.get(i) + letters.get(i), letters.get(i)));
        }
        kvp.sort(Tuple::compareTo);
        for (Tuple t : kvp) {
            sb.append(t.key);
        }
        return sb.toString();
    }

}
