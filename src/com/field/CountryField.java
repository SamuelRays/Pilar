package com.field;

import com.Player;
import com.bonus.Bonus;

import java.util.Set;

public class CountryField implements Field {
    private Country country;
    private Set<Bonus> bonuses;
    private int price;
    private int cityPrice;
    private int visitCostPerCity;
    private int cityAmount;
    private int wonderAmount;
    private Player player;
}
