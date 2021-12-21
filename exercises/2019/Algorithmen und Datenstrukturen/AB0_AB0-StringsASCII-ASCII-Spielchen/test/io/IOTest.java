package io;

import de.thm.mni.aud.commons.AbstractInputOutputTest;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

public class IOTest extends AbstractInputOutputTest {
    private class CharWithPos {
        char c;
        int pos;
        public CharWithPos(char c, int pos) {
            this.c = c;
            this.pos = pos + c;
        }
    }

    private String expected;
    private String actual;

    @Before
    public void decodeInput() {
        List<CharWithPos> decoded = studentInputLines.stream()
                .filter(x -> x.trim().length() > 0)
                .map(x -> x.split("\\s+"))
                .map(x -> new CharWithPos(x[1].charAt(0), Integer.parseInt(x[0])))
                .sorted(Comparator.comparing(x -> x.pos))
                .collect(Collectors.toList());
        expected = decoded.stream()
                .map(x -> String.valueOf(x.c))
                .collect(Collectors.joining());
        actual = studentOutputLines.get(0);
    }

    @Test
    public void testCorrectLengths() {
        if (expected.length() > actual.length()) {
            fail("Deine Ausgabe enthält zu wenige Zeichen!");
        } else if (expected.length() < actual.length()) {
            fail("Deine Ausgabe enthält zu viele Zeichen!");
        }
    }

    @Test
    public void testCorrectChars() {
        Set<Character> expectedChars = new HashSet<>();
        Set<Character> actualChars = new HashSet<>();
        for(char c : expected.toCharArray()) { expectedChars.add(c); }
        for(char c : actual.toCharArray()) { actualChars.add(c); }
        Set<Character> shouldNotExist = new HashSet<>(actualChars);
        shouldNotExist.removeAll(expectedChars);
        if (!shouldNotExist.isEmpty()) {
            fail("Die Zeichen "+shouldNotExist+" gehören nicht in die Ausgabe.");
        }
        Set<Character> shouldExist = new HashSet<>(expectedChars);
        shouldExist.removeAll(actualChars);
        if (!shouldExist.isEmpty()) {
            fail("Die Zeichen " +shouldExist+" sollten in der Ausgabe vorkommen.");
        }
    }

    @Test
    public void testCorrectOrder() {
        //the student should decode the given input

        int incorrectPositions = 0;
        for(int i = 0; i < expected.length(); i++) {
            if (actual.charAt(i) != expected.charAt(i)) {
                incorrectPositions++;
            }
        }
        if(incorrectPositions > 0) {
            fail("Es gibt noch "+incorrectPositions+" Zeichen, die an der falschen Position stehen.");
        }
    }
}