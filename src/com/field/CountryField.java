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
    private int cityAmount = 0;
    private int wonderAmount = 0;
    private Player player;

    public CountryField(Country country) {
        this.country = country;
        name = country.getName();
        price = country.getPrice();
        cityPrice = country.getCityPrice();
        visitCostPerCity = country.getVisitCostPerCity();
    }
}