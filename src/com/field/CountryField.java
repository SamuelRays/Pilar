package com.field;

import com.Player;

public class CountryField extends Field {
    private Union union;
    private int price;
    private int cityPrice;
    private int visitCostPerCity;
    private int cityAmount = 0;
    private int wonderAmount = 0;
    private Player owner;
    private double OneCountryBonusRatio = 1;

    public CountryField(CountryFieldType countryFieldType) {
        type = countryFieldType;
        name = countryFieldType.getName();
        price = countryFieldType.getPrice();
        cityPrice = countryFieldType.getCityPrice();
        visitCostPerCity = countryFieldType.getVisitCostPerCity();
    }

    public void buildOrDestroyCities(int amount) {
        cityAmount += amount;
        if (amount > 0) {
            checkWonders();
        }
    }

    public void checkWonders() {
        int w1 = owner.getCitiesForWonder1();
        int w2 = owner.getCitiesForWonder2();
        int w3 = owner.getCitiesForWonder3();
        int w4 = owner.getCitiesForWonder4();
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

    public void setUnion(Union union) {
        this.union = union;
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

    public Player getOwner() {
        return owner;
    }

    public void setOwner(Player owner) {
        this.owner = owner;
    }

    public double getOneCountryBonusRatio() {
        return OneCountryBonusRatio;
    }

    public void setOneCountryBonusRatio(double oneCountryBonusRatio) {
        OneCountryBonusRatio = oneCountryBonusRatio;
    }
}