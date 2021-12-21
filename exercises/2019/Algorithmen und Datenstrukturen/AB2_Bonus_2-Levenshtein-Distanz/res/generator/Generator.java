package generator;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Generator {

    public static void main(String[] args) {
        Random lengthRandom = new Random();
        Random charRandom = new Random();
        List<String> lines = new LinkedList<>();
        int wordLength = 10;
        int numWords = 200;
        for (int i = 0; i < numWords; i++) {
            StringBuilder builder1 = new StringBuilder();
            StringBuilder builder2 = new StringBuilder();
            for (int j = 0; j < wordLength; j++) {
                builder1.append((char) (charRandom.nextInt(25) + 65));
                builder2.append((char) (charRandom.nextInt(25) + 65));
            }
            lines.add(String.format("%s;%s",
                    builder1.toString().substring(lengthRandom.nextInt(wordLength)),
                    builder2.toString().substring(lengthRandom.nextInt(wordLength))));
            System.out.println(lines.get(i));
        }
    }
}
