package com.field;

import com.data.DataSource;
import com.game.Player;

import java.util.*;

public enum Union {
    CITIES_NEVER_ENOUGH(10000, 1700, CountryField.FRANCE, CountryField.SPAIN, CountryField.ITALY),
    THE_CHEAPER_THE_MORE(16000, 1700, CountryField.USA, CountryField.CANADA),
    PAY_NOTHING(15000, 2200, CountryField.INDIA, CountryField.CHINA, CountryField.JAPAN),
    SPEED_IS_EVERYTHING(5000, 600, CountryField.BRAZIL, CountryField.ARGENTINA, CountryField.COLUMBIA, CountryField.VENEZUELA),
    COME_TO_ME(11000, 1800, CountryField.GERMANY, CountryField.AUSTRIA, CountryField.GREAT_BRITAIN),
    I_AINT_GO_THERE(12000, 1900, CountryField.NETHERLANDS, CountryField.DENMARK, CountryField.BELGIUM),
    SHOW_ME_THE_MONEY(13000, 2000, CountryField.NORWAY, CountryField.SWEDEN, CountryField.FINLAND),
    WONDERFUL_LIFE(20000, 3500, CountryField.UAE, CountryField.KUWAIT, CountryField.QATAR),
    ULTIMATE_PROFIT(17000, 3000, CountryField.LUXEMBOURG, CountryField.VATICAN, CountryField.SINGAPORE, CountryField.MONACO),
    THE_ONE(14000, 2100, CountryField.AUSTRALIA, CountryField.NEW_ZEALAND, CountryField.SOUTH_AFRICA);

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
        if (owner != null) {
            zeroLevel();
            owner.getUnions().remove(this);
        }
        owner = checkPlayer;
    }

    public void levelUp() {
        if (level == DataSource.BONUS_PRICES.size()) {
            throw new RuntimeException("Maximal level reached already");
        }
        if (!owner.changeMoneyAmount(DataSource.BONUS_PRICES.get(level))) {
            throw new RuntimeException("Not enough money");
        }
        level++;
        owner.bonusLevelUp(this);
    }

    public void zeroLevel() {
        level = 0;
        owner.bonusLevelUp(this);
    }

    public Player getOwner() {
        return owner;
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
