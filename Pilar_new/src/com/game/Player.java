package com.game;

import com.data.DataSource;
import com.field.CountryField;
import com.field.Field;
import com.field.Union;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Player {
    private Set<CountryField> countryFields = new HashSet<>();
    private Set<Union> unions = new HashSet<>();
    private Field currentField;
    private long money = DataSource.START_MONEY_AMOUNT;
    private List<Integer> citiesAmountChange = DataSource.CITY_BONUSES.get(0);
    private List<Double> cityPriceRatios = DataSource.FREE_CITY_BONUSES.get(0);
    private double paymentRatio = DataSource.PAYMENT_BONUSES.get(0);
    private int citiesPerTurnAvailable = DataSource.FAST_BUILD_BONUSES.get(0);
    private int availableThrows = DataSource.THROWS_BONUSES.get(0);
    private int availableThrowsLeft = availableThrows;
    private List<Long> awards = DataSource.MONEY_BONUSES.get(0);
    private List<Integer> citiesForWonder = DataSource.WONDER_BONUSES.get(0);
    private List<Double> profits = DataSource.PROFIT_BONUSES.get(0);
    private List<Integer> profitMoves = DataSource.DEFAULT_PROFIT_MOVES;
    private List<Integer> profitMovesLeft = new ArrayList<>();
    private double oneCountryBonusRatio = DataSource.ONE_COUNTRY_BONUSES.get(0);
    private List<Integer> moveChances = DataSource.MOVE_CHANCE_BONUSES.get(0);
    private List<Integer> moveChancesLeft = new ArrayList<>();

    public boolean changeMoneyAmount(long value) {
        if (money + value < 0) {
            return false;
        } else {
            money += value;
            return true;
        }
    }

    public void getAWage() {
        changeMoneyAmount(awards.get(0));
    }

    public void getBonusMoney() {
        changeMoneyAmount(awards.get(1));
    }

    public void payTax() {
        changeMoneyAmount(awards.get(2));
    }

    public void profitUpUpdate() {
        int moves = profitMovesLeft.get(0);
        profitMovesLeft.set(0, moves + profitMoves.get(0));
    }

    public void profitDownUpdate() {
        int moves = profitMovesLeft.get(1);
        profitMovesLeft.set(1, moves + profitMoves.get(1));
    }

    public void ultraProfitUpdate() {
        int moves = profitMovesLeft.get(2);
        profitMovesLeft.set(2, moves + profitMoves.get(2));
    }

    public void bonusLevelUp(Union union) {
        if (!unions.contains(union)) {
            throw new IllegalArgumentException("Not a union owner");
        } else {
            int level = union.getLevel();
            if (union.equals(Union.CITIES_NEVER_ENOUGH)) {
                citiesAmountChange = DataSource.CITY_BONUSES.get(level);
            } else if (union.equals(Union.THE_CHEAPER_THE_MORE)) {
                cityPriceRatios = DataSource.FREE_CITY_BONUSES.get(level);
            } else if (union.equals(Union.PAY_NOTHING)) {
                paymentRatio = DataSource.PAYMENT_BONUSES.get(level);
            } else if (union.equals(Union.SPEED_IS_EVERYTHING)) {
                citiesPerTurnAvailable = DataSource.FAST_BUILD_BONUSES.get(level);
            } else if (union.equals(Union.COME_TO_ME)) {
                moveChances = DataSource.MOVE_CHANCE_BONUSES.get(level);
            } else if (union.equals(Union.I_AINT_GO_THERE)) {
                availableThrows = DataSource.THROWS_BONUSES.get(level);
            } else if (union.equals(Union.SHOW_ME_THE_MONEY)) {
                awards = DataSource.MONEY_BONUSES.get(level);
            } else if (union.equals(Union.WONDERFUL_LIFE)) {
                citiesForWonder = DataSource.WONDER_BONUSES.get(level);
            } else if (union.equals(Union.ULTIMATE_PROFIT)) {
                profits = DataSource.PROFIT_BONUSES.get(level);
            } else if (union.equals(Union.THE_ONE)) {
                oneCountryBonusRatio = DataSource.ONE_COUNTRY_BONUSES.get(level);
            } else {
                throw new RuntimeException("Unknown union");
            }
        }
    }

    public Set<CountryField> getCountryFields() {
        return countryFields;
    }

    public Set<Union> getUnions() {
        return unions;
    }

    public Field getCurrentField() {
        return currentField;
    }

    public void setCurrentField(Field currentField) {
        this.currentField = currentField;
    }

    public long getMoney() {
        return money;
    }

    public List<Integer> getCitiesAmountChange() {
        return citiesAmountChange;
    }

    public List<Double> getCityPriceRatios() {
        return cityPriceRatios;
    }

    public double getPaymentRatio() {
        return paymentRatio;
    }

    public int getCitiesPerTurnAvailable() {
        return citiesPerTurnAvailable;
    }

    public int getAvailableThrows() {
        return availableThrows;
    }

    public int getAvailableThrowsLeft() {
        return availableThrowsLeft;
    }

    public boolean reduceAvailableThrows() {
        if (availableThrowsLeft == 0) {
            availableThrowsLeft = availableThrows;
            return false;
        } else {
            availableThrowsLeft--;
            return true;
        }
    }

    public List<Long> getAwards() {
        return awards;
    }

    public List<Integer> getCitiesForWonder() {
        return citiesForWonder;
    }

    public List<Double> getProfits() {
        return profits;
    }

    public List<Integer> getProfitMoves() {
        return profitMoves;
    }

    public List<Integer> getProfitMovesLeft() {
        return profitMovesLeft;
    }

    public double getOneCountryBonusRatio() {
        return oneCountryBonusRatio;
    }

    public List<Integer> getMoveChances() {
        return moveChances;
    }

    public List<Integer> getMoveChancesLeft() {
        return moveChancesLeft;
    }
}
