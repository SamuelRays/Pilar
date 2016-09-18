package com;

import java.util.HashMap;
import java.util.Map;

public class Game {
    public static Map<Integer, Integer> bonusPrices = new HashMap<>();

    static {
        bonusPrices.put(1, 100000);
        bonusPrices.put(2, 300000);
        bonusPrices.put(3, 750000);
        bonusPrices.put(4, 1500000);
        bonusPrices.put(5, 3000000);
        bonusPrices.put(6, 7000000);
        bonusPrices.put(7, 20000000);
        bonusPrices.put(8, 50000000);
        bonusPrices.put(9, 100000000);
    }
}