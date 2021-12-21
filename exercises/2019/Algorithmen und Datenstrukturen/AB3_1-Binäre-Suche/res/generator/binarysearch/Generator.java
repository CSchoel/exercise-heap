package binarysearch;

import java.util.Random;
import java.util.UUID;

/**
 * @author Dominik
 *
 *	Idee:
 *	Es wird in eine Reihe von zufälligen Hexzahlen die zu suchende Zahl an
 *  eine vordefinierte Position untergebracht.
 *	Damit diese Zahl für die Studenten nicht zu leicht zu finden ist, werden die einzelnen Stellen nach folgendem
 *	Schema ausgetauscht:
 *
 *	0 -> a
 *	1 ->
 *	...
 *	5 -> f
 *
 *	Ziffern 6 - 9 bleiben, wie sie sind.
 *
 *	Um die Zahl im Test finden zu können, ist es wichtig zu ermitteln, wieviele Ziffern
 *	die generierte Zahl hatte. Die Anzahl der Ziffern werden errechnet und an eine
 *	vordefinierte Position untergebracht.
 *
 *	Variablen:
 *
 *	NUM_LENGTH_POS -> Position für den Wert der Länge der zu suchenden Zahl
 *	NUM_POS = Position für die zu suchende Zahl nach der Umwandlung
 *	UNICODE_SHIFT = Für den oben genannten Austausch der Zeichen notwendig
 *
 *	All diese Werte müssen dem Test bekannt sein!
 */
public class Generator {

  private static final int NUM_LENGTH_POS = 36;
  private static final int NUM_POS = 112;
  private static final int UNICODE_SHIFT = 49;

  public static void main(String args[]) {
    Random rnd = new Random();
    System.out.println(encode(rnd.nextInt(1024)));
  }

  private static String encode(int number) {
    //Länge der Zahl wird ermittelt
    int numberLength = Integer.toString(number).length();

    //Zahl wird codiert
    String encryptedNumber = "";
    for(char c : Integer.toString(number).toCharArray())
      encryptedNumber += c < '6' ? Character.toString((char) (c + UNICODE_SHIFT)) : c;

    //Zufällige Reihe an Hexwerten wird erzeugt
    String seed = "";
    for(int i = 0; i < 5; i++) seed += UUID.randomUUID().toString().replace("-", "");

    //Länge der Zahl wird in den seed gemischt
    seed = seed.substring(0, NUM_LENGTH_POS) + numberLength + seed.substring(NUM_LENGTH_POS);

    //Die codierte Zahl wird in den seed gemischt
    seed = seed.substring(0, NUM_POS) + encryptedNumber + seed.substring(NUM_POS);

    return seed;
  }
}
