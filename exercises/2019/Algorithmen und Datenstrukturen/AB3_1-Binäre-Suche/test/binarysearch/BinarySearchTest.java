package binarysearch;

import de.thm.mni.aud.commons.AbstractInputOutputTest;
import org.junit.Assert;
import org.junit.Test;

public class BinarySearchTest extends AbstractInputOutputTest {

  private static final int NUM_LENGTH_POS = 36;
  private static final int NUM_POS = 112;
  private static final int UNICODE_SHIFT = 49;

  @Test
  public void comparisonTest() {
    int in = decode(studentInputLines.get(0));
    int out = Integer.parseInt(studentOutputLines.get(0));

    if(out < in) Assert.fail("Nein, das Passwort ist gr\u00f6\u00dfer!");
    if(out > in) Assert.fail("Nein, das Passwort ist kleiner!");
  }

  private int decode(String seed) {
    int numberLength = Integer.parseInt(seed.substring(NUM_LENGTH_POS, NUM_LENGTH_POS + 1));
    String encryptedNumber = seed.substring(NUM_POS, NUM_POS + numberLength);
    String number = "";
    for(char c : encryptedNumber.toCharArray()) {
      if(Character.isDigit(c)) number += c;
      else number += (char) (c - UNICODE_SHIFT);
    }

    return Integer.parseInt(number);
  }
}
