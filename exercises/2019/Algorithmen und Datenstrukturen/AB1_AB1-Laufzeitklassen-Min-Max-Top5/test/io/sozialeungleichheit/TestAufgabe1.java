package io.sozialeungleichheit;

import de.thm.mni.aud.commons.AbstractInputOutputTest;

import java.util.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestAufgabe1 extends AbstractInputOutputTest {
	
	private int[] inputInts;
	private int[] outputInts;
	private int[] minMax; //[0] = min, [1] = max

	@Before
	public void init() {
		inputInts = studentInputLines.stream().mapToInt(s -> Integer.parseInt(s)).toArray();
		outputInts = studentOutputLines.stream().mapToInt(s -> Integer.parseInt(s)).toArray();
		minMax = minMax(inputInts);
	}
	
	@Test
	public void lengthTest() {
		if(outputInts.length > 2) Assert.fail("Es wurden zu viele Zahlen angegeben!");
	}
	
	@Test
	public void minTest() {
		if(outputInts[0] != minMax[0]) Assert.fail("Der minimale Wert ist nicht korrekt!");
	}
	
	@Test
	public void maxTest() {
		if(outputInts[1] != minMax[1]) Assert.fail("Der maximale Wert ist nicht korrekt!");
	}
	
	//Lösung
	private int[] minMax(int[] a) {
		int[] minMax = {a[0], a[0]};
		for(int i = 0; i < a.length; i++) {
			if(a[i] < minMax[0]) minMax[0] = a[i];
			if(a[i] > minMax[1]) minMax[1] = a[i];
		}
		return minMax;
	}
}
