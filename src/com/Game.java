package com;

import com.field.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
    private List<Field> gameField = new ArrayList<>();

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

    {
        gameField.add(new MoneyField(MoneyFieldType.FORWARD));
        gameField.add(new CountryField(CountryFieldType.FRANCE));
        gameField.add(new CountryField(CountryFieldType.SPAIN));
        gameField.add(new CountryField(CountryFieldType.ITALY));
        gameField.add(new MoneyField(MoneyFieldType.TAX));
        gameField.add(new CountryField(CountryFieldType.LUXEMBOURG));
        gameField.add(new CountryField(CountryFieldType.USA));
        gameField.add(new CountryField(CountryFieldType.CANADA));
        gameField.add(new CityField(CityFieldType.POSITIVE_CITY_BONUS));
        gameField.add(new CityField(CityFieldType.NEGATIVE_CITY_BONUS));
        gameField.add(new CountryField(CountryFieldType.AUSTRALIA));
        gameField.add(new CountryField(CountryFieldType.INDIA));
        gameField.add(new CountryField(CountryFieldType.CHINA));
        gameField.add(new PortField(PortFieldType.EVEN_PORT));
        gameField.add(new CountryField(CountryFieldType.JAPAN));
        gameField.add(new CountryField(CountryFieldType.VATICAN));
        gameField.add(new CountryField(CountryFieldType.BRAZIL));
        gameField.add(new CountryField(CountryFieldType.ARGENTINA));
        gameField.add(new CountryField(CountryFieldType.COLUMBIA));
        gameField.add(new CountryField(CountryFieldType.VENEZUELA));
        gameField.add(new CountryField(CountryFieldType.NEW_ZEALAND));
        gameField.add(new CountryField(CountryFieldType.GERMANY));
        gameField.add(new PortField(PortFieldType.ODD_PORT));
        gameField.add(new CountryField(CountryFieldType.AUSTRIA));
        gameField.add(new CountryField(CountryFieldType.GREAT_BRITAIN));
        gameField.add(new CountryField(CountryFieldType.SINGAPORE));
        gameField.add(new CountryField(CountryFieldType.NETHERLANDS));
        gameField.add(new CountryField(CountryFieldType.DENMARK));
        gameField.add(new PercentField(PercentFieldType.POSITIVE_PERCENT_FIELD));
        gameField.add(new CountryField(CountryFieldType.BELGIUM));
        gameField.add(new CountryField(CountryFieldType.SOUTH_AFRICA));
        gameField.add(new CountryField(CountryFieldType.NORWAY));
        gameField.add(new CountryField(CountryFieldType.SWEDEN));
        gameField.add(new CountryField(CountryFieldType.FINLAND));
        gameField.add(new PercentField(PercentFieldType.NEGATIVE_PERCENT_FIELD));
        gameField.add(new CountryField(CountryFieldType.MONACO));
        gameField.add(new CountryField(CountryFieldType.UAE));
        gameField.add(new CountryField(CountryFieldType.KUWAIT));
        gameField.add(new CountryField(CountryFieldType.QATAR));
        gameField.add(new PercentField(PercentFieldType.ULTRA_PERCENT_FIELD));
    }

    public List<Field> getGameField() {
        return gameField;
    }
}