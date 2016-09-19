package com;

import java.util.HashMap;
import java.util.Map;

public class Game {
    public static final int DEFAULT_NEGATIVE_CITY_INCREASE = -1;
    public static final int DEFAULT_POSITIVE_CITY_INCREASE = 1;
    public static final double DEFAULT_FIRST_CITY_PRICE_RATIO = 1;
    public static final double DEFAULT_SECOND_CITY_PRICE_RATIO = 1;
    public static final double DEFAULT_THIRD_CITY_PRICE_RATIO = 1;
    public static final double DEFAULT_PAYMENT_RATIO = 1;
    public static final int DEFAULT_CITIES_PER_TURN_AVAILABLE = 1;
    public static final int DEFAULT_AVAILABLE_THROWS = 1;
    public static final long DEFAULT_SALARY = 5000;
    public static final long DEFAULT_FORWARD_BONUS = 5000;
    public static final long DEFAULT_TAX = -5000;
    public static final int DEFAULT_CITIES_FOR_WONDER_1 = 3;
    public static final int DEFAULT_CITIES_FOR_WONDER_2 = 0;
    public static final int DEFAULT_CITIES_FOR_WONDER_3 = 0;
    public static final int DEFAULT_CITIES_FOR_WONDER_4 = 0;
    public static final double DEFAULT_NEGATIVE_PERCENT = 0.9;
    public static final double DEFAULT_POSITIVE_PERCENT = 1.1;
    public static final double DEFAULT_ULTRA_PERCENT = 2;
    public static final int DEFAULT_PERCENT_MOVES = 3;
    public static final int DEFAULT_ULTRA_PERCENT_MOVES = 1;
    public static final double DEFAULT_ONE_COUNTRY_BONUS_RATIO = 1;
    public static final Map<Integer, Long> BONUS_PRICES = new HashMap<>();

    static {
        BONUS_PRICES.put(1, 100000L);
        BONUS_PRICES.put(2, 300000L);
        BONUS_PRICES.put(3, 750000L);
        BONUS_PRICES.put(4, 1500000L);
        BONUS_PRICES.put(5, 3000000L);
        BONUS_PRICES.put(6, 7000000L);
        BONUS_PRICES.put(7, 20000000L);
        BONUS_PRICES.put(8, 50000000L);
        BONUS_PRICES.put(9, 100000000L);
    }
}