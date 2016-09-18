package com;

import java.util.HashMap;
import java.util.Map;

public class Game {
    public static Map<Integer, Long> bonusPrices = new HashMap<>();

    static {
        bonusPrices.put(1, 100000L);
        bonusPrices.put(2, 300000L);
        bonusPrices.put(3, 750000L);
        bonusPrices.put(4, 1500000L);
        bonusPrices.put(5, 3000000L);
        bonusPrices.put(6, 7000000L);
        bonusPrices.put(7, 20000000L);
        bonusPrices.put(8, 50000000L);
        bonusPrices.put(9, 100000000L);
    }
}