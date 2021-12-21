package hangman;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/*
  Hilf dem Henker
 */

public class Hangman {

  private String wordToGuess;
  private int maxLines;
  private int lineCount = 0;

  // Aufgabe 1  --------------------------------------------------------------------------------------------------------

  public Hangman(String word, int maxLines) {
    wordToGuess = word.toLowerCase();
    this.maxLines = maxLines;
  }

  public String getWord() {

    return wordToGuess;
  }

  // Variante 1: Set
  private int countDifferentLetters() {
    Set<Character> uniqueChars = new HashSet<>();
    for (char e : wordToGuess.toCharArray()) {
      uniqueChars.add(e);
    }
    return uniqueChars.size();
  }

  // Variante 2: Streams
  private int countDifferentLettersStreams() {
    return (int) wordToGuess.chars().distinct().count();
  }

  public boolean isPossibleToLose() {
    return (countDifferentLetters() + maxLines) <= 26;
  }

  // Aufgabe 2  --------------------------------------------------------------------------------------------------------

  public int getLineCount() {
    return lineCount;
  }

  public char playRandomly() {
    Random r = new Random();
    char randChar = (char) ('a' + r.nextInt(26));
    String guessedLetter = String.valueOf(randChar);
    if (wordToGuess.contains(String.valueOf(guessedLetter))) wordToGuess = wordToGuess.replace(guessedLetter, "");
      else lineCount++;
    return randChar;
  }

  public boolean isWin() {
    actualLetterIdx = 0;
    return (lineCount < maxLines) && wordToGuess.isEmpty();
  }

  // Aufgabe 3  --------------------------------------------------------------------------------------------------------

  private int actualLetterIdx;

  public char playStrategically() {
    String letterFrequency = "enisratdhulcgmobwfkzpvjyxq";
    char stratChar = letterFrequency.charAt(actualLetterIdx);
    if (actualLetterIdx < letterFrequency.length() - 1) actualLetterIdx++;
    String guessedLetter = String.valueOf(stratChar);
    if (wordToGuess.contains(String.valueOf(guessedLetter))) wordToGuess = wordToGuess.replace(guessedLetter, "");
      else lineCount++;
    return stratChar;
  }

}
