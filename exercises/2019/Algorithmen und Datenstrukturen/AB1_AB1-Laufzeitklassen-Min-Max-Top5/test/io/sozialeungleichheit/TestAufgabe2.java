package io.sozialeungleichheit;

import de.thm.mni.aud.commons.AbstractInputOutputTest;

import java.util.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test; 

public class TestAufgabe2 extends AbstractInputOutputTest {
	
	private int[] inputInts;
	private int[] outputInts;
	
	private Integer[] inputIntegers;

	@Before
	public void init() {
		inputInts = studentInputLines.stream().mapToInt(s -> Integer.parseInt(s)).toArray();
		outputInts = studentOutputLines.stream().mapToInt(s -> Integer.parseInt(s)).toArray();
		
		inputIntegers = Arrays.stream(inputInts).boxed().toArray(Integer[]::new);
		Arrays.sort(inputIntegers, Collections.reverseOrder());
	}
	
	@Test
	public void lengthTest() {
		if(outputInts.length > 5) Assert.fail("Es wurden zu viele Zahlen ausgegeben!");
    if(outputInts.length < 5) Assert.fail("Es wurden zu wenige Zahlen ausgegeben!");

	}
	
	@Test
	public void topFiveTest() {
		if(inputIntegers[0] != outputInts[0]) Assert.fail("Der höchste Wert ist falsch!");
		if(inputIntegers[1] != outputInts[1]) Assert.fail("Der zweithöchste Wert ist falsch!");
		if(inputIntegers[2] != outputInts[2]) Assert.fail("Der dritthöchste Wert ist falsch!");
		if(inputIntegers[3] != outputInts[3]) Assert.fail("Der vierthöchste Wert ist falsch!");
		if(inputIntegers[4] != outputInts[4]) Assert.fail("Der fünfthöchste Wert ist falsch!");
	}

}
