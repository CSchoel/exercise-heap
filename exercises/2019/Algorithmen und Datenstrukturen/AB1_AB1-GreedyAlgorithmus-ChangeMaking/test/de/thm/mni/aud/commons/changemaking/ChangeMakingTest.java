package de.thm.mni.aud.commons.changemaking;


import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class ChangeMakingTest {

    @Test
    public void noCoinsTest() {
        Assert.assertEquals(Arrays.asList(), ChangeMaking.giveChange(0));
    }

    @Test
    public void singleCoinsTest() {
        final int[] coinValues = new int[] { 50, 20, 10, 5, 2, 1 };

        for (final int coin : coinValues) {
            assertEquals(Arrays.asList(coin), ChangeMaking.giveChange(coin));
        }
    }

    @Test
    public void coins99Test() {
        assertEquals(Arrays.asList(50, 20, 20, 5, 2, 2), ChangeMaking.giveChange(99));
    }

    @Test
    public void coins3Test() {
        assertEquals(Arrays.asList(2, 1), ChangeMaking.giveChange(3));
    }

    @Test
    public void coins7Test() {
        assertEquals(Arrays.asList(5, 2), ChangeMaking.giveChange(7));
    }

    @Test
    public void coins11Test() {
        assertEquals(Arrays.asList(10, 1), ChangeMaking.giveChange(11));
    }

    @Test
    public void coins13Test() {
        assertEquals(Arrays.asList(10, 2, 1), ChangeMaking.giveChange(13));
    }

    @Test
    public void coins653Test() {
        assertEquals(Arrays.asList(50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 2, 1),
                ChangeMaking.giveChange(653));
    }

    @Test
    public void coins999Test() {
        assertEquals(Arrays.asList(50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50,
            50, 50, 50, 50, 50, 50, 20, 20, 5, 2, 2), ChangeMaking.giveChange(999));
    }

}
