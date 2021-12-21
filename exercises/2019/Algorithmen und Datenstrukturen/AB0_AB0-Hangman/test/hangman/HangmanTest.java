package hangman;

import static org.junit.Assert.*;

import org.junit.Test;

public class HangmanTest {

  private Hangman tester = new Hangman("galgenmaennchen", 26);

  @Test
  public void getWordTest() {
    assertEquals("galgenmaennchen", tester.getWord());
  }

  @Test
  public void isPossibleToLoseTest() {
    String testWord1 = "algomantik";
    String testWord2 = "orksundanderewesen";
    int testLineCount1 = 20;
    int testLineCount2 = 10;
    assertFalse(new Hangman(testWord1, testLineCount1).isPossibleToLose());
    assertTrue(new Hangman(testWord2, testLineCount2).isPossibleToLose());
  }

  @Test
  public void getLineCountTest() {
    assertEquals(0, tester.getLineCount());
    for(int i = 0; i < 3; i++) {
      tester.playStrategically();
    }
    assertEquals(1, tester.getLineCount());
  }

  @Test
  public void playRandomlyTest() {
    char randChar;
    char lowestChar = 'a';
    char highestChar = 'z';
    for(int i = 0; i < 100; i++) {
      randChar = tester.playRandomly();
      if(highestChar < randChar) highestChar = randChar;
      if(lowestChar > randChar) lowestChar = randChar;
    }
    assertTrue(lowestChar == 'a' && highestChar == 'z');
  }

  @Test
  public void playStrategicallyTest() {
    StringBuilder stratChars = new StringBuilder();
    String charFrequency = "enisratdhulcgmobwfkzpvjyxq";
    for(int i = 0; i < 26; i++) {
      stratChars.append(tester.playStrategically());
    }
    assertEquals(stratChars.toString(), charFrequency);
  }

  @Test
  public void isRandomWinTest() {
    String w = "galgenmaennchen";
    Hangman tester = new Hangman("galgenmaennchen", 80);
    int x = 0;
    int y = 0;
    for(int i = 0; i < 100; i++) {
      String z = String.valueOf(tester.playRandomly());
      if(w.contains(z)) {
        w = w.replace(z, "");
        x++;
        if(w.equals("")) break;
      }
      else y++;
    }
    if(y < 80 && x == 8 && w.isEmpty()) assertTrue(tester.isWin());
    else assertFalse(tester.isWin());
  }

  @Test
  public void isStrategicalWinTest() {
    String w = "galgenmaennchen";
    Hangman winTester = new Hangman("galgenmaennchen", 10);
    int x = 0;
    int y = 0;
    for(int i = 0; i < 14; i++) {
      String z = String.valueOf(winTester.playStrategically());
      if(w.contains(z)) x++;
      else y++;
    }
    assertTrue(x == 8 && y == 6 && winTester.isWin());

    Hangman lossTester1 = new Hangman("q", 0);
    assertFalse(lossTester1.isWin());

    Hangman lossTester2 = new Hangman("g", 5);
    assertFalse(lossTester2.isWin());
  }
}
