package com.field;

import com.game.Player;

import java.util.*;

public enum Union {
    SOUTH_EUROPE(10000, 1700, Field.FRANCE, Field.SPAIN, Field.ITALY),
    NORTH_AMERICA(16000, 1700, Field.USA, Field.CANADA),
    EAST_ASIA(15000, 2200, Field.INDIA, Field.CHINA, Field.JAPAN),
    SOUTH_AMERICA(5000, 600, Field.BRAZIL, Field.ARGENTINA, Field.COLUMBIA, Field.VENEZUELA),
    MIDDLE_EUROPE(11000, 1800, Field.GERMANY, Field.AUSTRIA, Field.GREAT_BRITAIN),
    WEST_EUROPE(12000, 1900, Field.NETHERLANDS, Field.DENMARK, Field.BELGIUM),
    NORTH_EUROPE(13000, 2000, Field.NORWAY, Field.SWEDEN, Field.FINLAND),
    WEST_ASIA(20000, 3500, Field.UAE, Field.KUWAIT, Field.QATAR),
    SMALL(17000, 3000, Field.LUXEMBOURG, Field.VATICAN, Field.SINGAPORE, Field.MONACO),
    THREE_NATIONS_CUP(14000, 2100, Field.AUSTRALIA, Field.NEW_ZEALAND, Field.SOUTH_AFRICA);

    private Player owner;
    private Map<Field, Player> countries = new HashMap<>();
    private int price;
    private int cityPrice;
    private int visitCostPerCity;
    private int cityAmount;
    private int wonderAmount;
    private int level;

    Union(int price, int cityPrice, Field... countries) {
        for (Field country : countries) {
            this.countries.put(country, null);
        }
        this.price = price;
        this.cityPrice = cityPrice;
        this.visitCostPerCity = price / 10;
    }

    public static void setCountryOwner(Field countryField, Player player) {
        if (!countryField.isCountry()) {
            throw new IllegalArgumentException("Setting the owner to not a country field");
        }
        Union union = null;
        for (Union i : Union.values()) {
            if (i.countries.containsKey(countryField)) {
                union = i;
                union.countries.put(countryField, player);
                union.checkOwner();
            }
        }
        if (union == null) {
            throw new RuntimeException("Country field has no union");
        }
    }

    public void checkOwner() {
        Player checkPlayer = null;
        for (Map.Entry<Field, Player> i : countries.entrySet()) {
            Player player = i.getValue();
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

    public Map<Field, Player> getCountries() {
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
