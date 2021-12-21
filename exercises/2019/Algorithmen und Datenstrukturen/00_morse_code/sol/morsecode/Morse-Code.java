package morsecode;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MorseCode {

    private static final String REGEX_PATTERN = "\"(.)\" => \"(.*)\",?";

    public static void main(String[] args) {
        String output = encode("The quick brown fox jumps over the lazy dog 0987654321-.,");
        System.out.println(output);
    }

    public static Map<Character, String> getDictionary(String filePath) {
        Map<Character, String> dict = new HashMap<>();
        System.out.println(Paths.get(filePath).toAbsolutePath().toString());
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(filePath))) {
            String line;
            Pattern pattern = Pattern.compile(REGEX_PATTERN);
            while ((line = reader.readLine()) != null) {
                Matcher matcher = pattern.matcher(line);
                if (matcher.matches()) {
                    dict.put(matcher.group(1).charAt(0), matcher.group(2));
                }
            }
        } catch (IOException x) {
            System.err.format("IOException: %s%n", x);
        }
        return dict;
    }

    public static String encode(String input) {
        Map<Character, String> dict = getDictionary("res/morse-code.txt");
        String output = input
                .toUpperCase()
                .chars()
                .mapToObj(e -> String.valueOf((char) e))
                .reduce("", (a, b) -> a + dict.get(b.charAt(0)));
        return output;
    }
}
