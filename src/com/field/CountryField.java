package com.field;

import com.Player;
import com.bonus.Bonus;

import java.util.Set;

class CountryField implements Field {
    private String name;
    private Country country;
    private Set<Bonus> bonuses;
    private int price;
    private int cityPrice;
    private int visitCostPerCity;
    private int cityAmount;
    private int wonderAmount;
    private Player player;

    public CountryField(Country country) {
        this.country = country;
    }
}