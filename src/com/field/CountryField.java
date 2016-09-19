package com.field;

import com.Player;

public class CountryField extends Field {
    private Union union;
    private int price;
    private int cityPrice;
    private int visitCostPerCity;
    private int cityAmount = 0;
    private int wonderAmount = 0;
    private Player player;

    public CountryField(CountryFieldType countryFieldType) {
        union = countryFieldType.getUnion();
        name = countryFieldType.getName();
        price = countryFieldType.getPrice();
        cityPrice = countryFieldType.getCityPrice();
        visitCostPerCity = countryFieldType.getVisitCostPerCity();
    }

    public Union getUnion() {
        return union;
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