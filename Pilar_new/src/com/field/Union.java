package com.field;

import com.game.Player;

import java.util.*;

public enum Union {
    SOUTH_EUROPE(10000, 1700, CountryField.FRANCE, CountryField.SPAIN, CountryField.ITALY),
    NORTH_AMERICA(16000, 1700, CountryField.USA, CountryField.CANADA),
    EAST_ASIA(15000, 2200, CountryField.INDIA, CountryField.CHINA, CountryField.JAPAN),
    SOUTH_AMERICA(5000, 600, CountryField.BRAZIL, CountryField.ARGENTINA, CountryField.COLUMBIA, CountryField.VENEZUELA),
    MIDDLE_EUROPE(11000, 1800, CountryField.GERMANY, CountryField.AUSTRIA, CountryField.GREAT_BRITAIN),
    WEST_EUROPE(12000, 1900, CountryField.NETHERLANDS, CountryField.DENMARK, CountryField.BELGIUM),
    NORTH_EUROPE(13000, 2000, CountryField.NORWAY, CountryField.SWEDEN, CountryField.FINLAND),
    WEST_ASIA(20000, 3500, CountryField.UAE, CountryField.KUWAIT, CountryField.QATAR),
    SMALL(17000, 3000, CountryField.LUXEMBOURG, CountryField.VATICAN, CountryField.SINGAPORE, CountryField.MONACO),
    THREE_NATIONS_CUP(14000, 2100, CountryField.AUSTRALIA, CountryField.NEW_ZEALAND, CountryField.SOUTH_AFRICA);

    private Player owner;
    private Set<CountryField> countries = new HashSet<>();
    private int price;
    private int cityPrice;
    private int visitCostPerCity;
    private int cityAmount;
    private int wonderAmount;
    private int level;

    Union(int price, int cityPrice, CountryField... countries) {
        for (CountryField country : countries) {
            this.countries.add(country);
            country.setUnion(this);
        }
        this.price = price;
        this.cityPrice = cityPrice;
        this.visitCostPerCity = price / 10;
    }

    public void checkOwner() {
        Player checkPlayer = null;
        for (CountryField i : countries) {
            Player player = i.getOwner();
            if (player == null) {
                owner = null;
            }
            if (checkPlayer == null) {
                checkPlayer = player;
            } else if (!checkPlayer.equals(player)) {
                owner = null;
            }
        }
        owner = checkPlayer;
    }

    public Player getOwner() {
        return owner;
    }

    public Set<CountryField> getCountries() {
        return countries;
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

    public int getLevel() {
        return level;
    }
}
