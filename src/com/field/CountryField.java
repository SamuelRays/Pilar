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
    private boolean isUnionCompleted = false;

    public CountryField(CountryFieldType countryFieldType) {
        type = countryFieldType;
        union = new Union(countryFieldType.getUnionType());
        name = countryFieldType.getName();
        price = countryFieldType.getPrice();
        cityPrice = countryFieldType.getCityPrice();
        visitCostPerCity = countryFieldType.getVisitCostPerCity();
    }

    public void buildCities(int amount) {
        cityAmount += amount;
        if (amount > 0) {
            checkWonders();
        } else if (cityAmount < 0) {
            cityAmount = 0;
        }
    }

    public void checkWonders() {
        int w1 = player.getCitiesForWonder1();
        int w2 = player.getCitiesForWonder2();
        int w3 = player.getCitiesForWonder3();
        int w4 = player.getCitiesForWonder4();
        wonderAmount = cityAmount / w1;
        if (w2 != 0) {
            wonderAmount += cityAmount / w2;
        }
        if (w3 != 0) {
            wonderAmount += cityAmount / w3;
        }
        if (w4 != 0) {
            wonderAmount += cityAmount / w4;
        }
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

    public boolean isUnionCompleted() {
        return isUnionCompleted;
    }

    public void setUnionCompleted(boolean unionCompleted) {
        isUnionCompleted = unionCompleted;
    }
}