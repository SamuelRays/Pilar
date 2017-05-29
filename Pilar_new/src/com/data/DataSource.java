package com.data;

import java.util.ArrayList;
import java.util.List;

public class DataSource {
    public static final long START_MONEY_AMOUNT = 750000;
    public static final int DEFAULT_DESTROYED_CITIES = 1;
    public static final int DEFAULT_FREE_CITIES = 1;
    public static final double DEFAULT_FIRST_CITY_PRICE_RATIO = 1;
    public static final double DEFAULT_SECOND_CITY_PRICE_RATIO = 1;
    public static final double DEFAULT_THIRD_CITY_PRICE_RATIO = 1;
    public static final double DEFAULT_PAYMENT_RATIO = 1;
    public static final int DEFAULT_CITIES_PER_TURN_AVAILABLE = 1;
    public static final int DEFAULT_AVAILABLE_THROWS = 1;
    public static final long DEFAULT_SALARY = 5000;
    public static final long DEFAULT_INCEPTION_BONUS = 5000;
    public static final long DEFAULT_TAX = 5000;
    public static final int DEFAULT_CITIES_WONDERS_RATIO = 3;
    public static final double DEFAULT_PROFIT_DOWN = 0.9;
    public static final double DEFAULT_PROFIT_UP = 1.1;
    public static final double DEFAULT_ULTRA_PROFIT = 2;
    public static final double DEFAULT_ONE_COUNTRY_BONUS_RATIO = 1;
    public static final int DEFAULT_EVEN_MOVE_CHANCES = 0;
    public static final int DEFAULT_MOVE_CHANCES = 0;
    public static final int DEFAULT_CITIES_FOR_WONDER = 3;
    public static final List<Long> BONUS_PRICES = new ArrayList<>();
    public static final List<List<Integer>> CITY_BONUSES = new ArrayList<>();
    public static final List<Integer> FAST_BUILD_BONUSES = new ArrayList<>();
    public static final List<List<Integer>> FREE_CITY_BONUSES = new ArrayList<>();
    public static final List<List<Integer>> MONEY_BONUSES = new ArrayList<>();
    public static final List<Integer> THROWS_BONUSES = new ArrayList<>();
    public static final List<List<Integer>> MOVE_CHANCE_BONUSES = new ArrayList<>();
    public static final List<Double> ONE_COUNTRY_BONUSES = new ArrayList<>();
    public static final List<Double> PAYMENT_BONUSES = new ArrayList<>();
    public static final List<Double> PROFIT_BONUSES = new ArrayList<>();
    public static final List<Double> WONDER_BONUSES = new ArrayList<>();
}
