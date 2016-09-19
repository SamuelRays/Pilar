package com.field;

import com.Player;

public class CountryField implements Field {
    private String name;
    private CountryFieldType countryFieldType;
    private int price;
    private int cityPrice;
    private int visitCostPerCity;
    private int cityAmount = 0;
    private int wonderAmount = 0;
    private Player player;

    public CountryField(CountryFieldType countryFieldType) {
        this.countryFieldType = countryFieldType;
        name = countryFieldType.getName();
        price = countryFieldType.getPrice();
        cityPrice = countryFieldType.getCityPrice();
        visitCostPerCity = countryFieldType.getVisitCostPerCity();
    }

    public String getName() {
        return name;
    }

    public CountryFieldType getCountryFieldType() {
        return countryFieldType;
    }

    public int getPrice() {
        return price;
    }

    public int getCityPrice() {
        return cityPrice;
    }

    public int getVisitCostPerCity() {
        return visitCostPerCity;
    }

    public int getCityAmount() {
        return cityAmount;
    }

    public int getWonderAmount() {
        return wonderAmount;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}