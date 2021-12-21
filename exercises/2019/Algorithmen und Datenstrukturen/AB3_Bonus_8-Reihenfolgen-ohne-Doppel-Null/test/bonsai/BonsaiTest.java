package bonsai;

import de.thm.mni.aud.commons.AbstractInputOutputTest;
import org.junit.Assert;
import org.junit.Test;

public class BonsaiTest extends AbstractInputOutputTest {

	@Test
	public void testCorrectLineCount() {
		int nIn = studentInputLines.size();
		int nOut = studentOutputLines.size();
		if (nIn != nOut) {
			Assert.fail("Die Ausgabe sollte " + nIn + " haben. Sie haben " + nOut + " Zeilen angegeben.");
		}
	}

	@Test
	public void testIsNumber() {
		int i = 0;
		int nOut = studentOutputLines.size();
		try {
			for(; i < nOut; i++) {
				Integer.parseInt(studentOutputLines.get(i));
			}
		} catch (NumberFormatException nfe) {
			Assert.fail("Die Ausgabe muss eine Zahl sein! In Zeile " + i + " steht aber " + studentOutputLines.get(i) + ".");
		}
	}

	@Test
	public void testRecFunction() throws Exception {
		// the student should compute the amount of correct combinations to the given count of 0's and 1's
		int nOut = studentOutputLines.size();
		for(int line = 0; line < nOut; line++) {
			int expectedNumber = f(getZeroCount(line), getOneCount(line));
			int actualNumber = Integer.parseInt(studentOutputLines.get(line));
			if(actualNumber != expectedNumber) Assert.fail("Die Anzahl " + actualNumber + " an korrekten Reihenfolgen in Zeile " + line + " ist nicht richtig!");
		}
	}

	private int getZeroCount(int line) {
		String actualInputLine0 = studentInputLines.get(line);
		return Integer.parseInt(actualInputLine0.substring(0, actualInputLine0.indexOf(';')));
	}
	private int getOneCount(int line) {
		String actualInputLine1 = studentInputLines.get(line);
		return Integer.parseInt(actualInputLine1.substring(actualInputLine1.indexOf(';') + 1, actualInputLine1.length()));
	}

	private int f(int a, int b) {
		if (a > b + 1) return 0;
		if (a == 0 || b == 0) return 1;
		return f(a, b - 1) + f(a - 1, b - 1);
	}

}
