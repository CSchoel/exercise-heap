package de.thm.mni.aud.commons.changemaking;

import java.util.ArrayList;

public class ChangeMaking {

    private static final int[] COIN_VALUES = new int[] { 50, 20, 10, 5, 2, 1 };

    private static int addCoins(ArrayList<Integer> coins, int coin, int geldBetrag) {
        if (geldBetrag >= coin) {
            final int coinsToAdd = geldBetrag / coin;
            for (int i = 0; i < coinsToAdd; i++) {
                coins.add(coin);
            }
            return geldBetrag % coin;
        } else {
            return geldBetrag;
        }
    }

    public static ArrayList<Integer> giveChange(int geldBetrag) {
        if (geldBetrag < 0)
            throw new IllegalArgumentException("Bitte einen positiven geldBetrag angeben!");

        final ArrayList<Integer> coins = new ArrayList<>();

        for (final int coin : COIN_VALUES) {
            geldBetrag = addCoins(coins, coin, geldBetrag);
        }

        return coins;
    }

}
