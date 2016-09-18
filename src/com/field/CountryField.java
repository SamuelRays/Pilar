package com.field;

import com.Player;

public class CountryField implements Field {
    private String name;
    private Country country;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getCityPrice() {
        return cityPrice;
    }

    public void setCityPrice(int cityPrice) {
        this.cityPrice = cityPrice;
    }

    public int getVisitCostPerCity() {
        return visitCostPerCity;
    }

    public void setVisitCostPerCity(int visitCostPerCity) {
        this.visitCostPerCity = visitCostPerCity;
    }

    public int getCityAmount() {
        return cityAmount;
    }

    public void setCityAmount(int cityAmount) {
        this.cityAmount = cityAmount;
    }

    public int getWonderAmount() {
        return wonderAmount;
    }

    public void setWonderAmount(int wonderAmount) {
        this.wonderAmount = wonderAmount;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}