package com;

import com.field.*;

import java.util.HashSet;
import java.util.Set;

public class Player {
    private Game game;
    private String name;
    private boolean isLost = false;
    private Set<Union> unions = new HashSet<>();
    private Field currentField;
    private Set<CountryField> countries;
    private long money;
    private int negativeCityIncrease = Game.DEFAULT_NEGATIVE_CITY_INCREASE;
    private int positiveCityIncrease = Game.DEFAULT_POSITIVE_CITY_INCREASE;
    private double firstCityPriceRatio = Game.DEFAULT_FIRST_CITY_PRICE_RATIO;
    private double secondCityPriceRatio = Game.DEFAULT_SECOND_CITY_PRICE_RATIO;
    private double thirdCityPriceRatio = Game.DEFAULT_THIRD_CITY_PRICE_RATIO;
    private double paymentRatio = Game.DEFAULT_PAYMENT_RATIO;
    private int citiesPerTurnAvailable = Game.DEFAULT_CITIES_PER_TURN_AVAILABLE;
    private int availableThrows = Game.DEFAULT_AVAILABLE_THROWS;
    private int currentAvailableThrows = availableThrows;
    private long salary = Game.DEFAULT_SALARY;
    private long forwardBonus = Game.DEFAULT_FORWARD_BONUS;
    private long tax = Game.DEFAULT_TAX;
    private int citiesForWonder1 = Game.DEFAULT_CITIES_FOR_WONDER_1;
    private int citiesForWonder2 = Game.DEFAULT_CITIES_FOR_WONDER_2;
    private int citiesForWonder3 = Game.DEFAULT_CITIES_FOR_WONDER_3;
    private int citiesForWonder4 = Game.DEFAULT_CITIES_FOR_WONDER_4;
    private double negativePercent = Game.DEFAULT_NEGATIVE_PERCENT;
    private double positivePercent = Game.DEFAULT_POSITIVE_PERCENT;
    private int percentMoves = Game.DEFAULT_PERCENT_MOVES;
    private int negativePercentMovesLeft;
    private int positivePercentMovesLeft;
    private double ultraPercent = Game.DEFAULT_ULTRA_PERCENT;
    private int ultraPercentMoves = Game.DEFAULT_ULTRA_PERCENT_MOVES;
    private int ultraPercentMovesLeft;
    private double oneCountryBonusRatio = Game.DEFAULT_ONE_COUNTRY_BONUS_RATIO;

    {
        for (UnionType i : UnionType.values()) {
            unions.add(new Union(i, this));
        }
    }

    public Player(String name) {
        this.name = name;
    }

    public void buyCountryField(CountryField field) {
        buyCountryField(field, null, field.getPrice());
    }

    public void buyCountryField(CountryField field, Player player, long price) {
        pay(price, player);
        addCountry(field);
        if (player != null) {
            player.sellCountryField(field, price);
        }
    }

    private void addCountry(CountryField field) {
        countries.add(field);
        field.setPlayer(this);
        for (Union i : unions) {
            i.addCountry(field);
        }
    }

    public void sellCountryField(CountryField field) {
        sellCountryField(field, field.getPrice());
    }

    public void sellCountryField(CountryField field, long price) {
        if (field.getCityAmount() != 0) {
            //TODO
            destroyAllCities(field);
        }
        for (Union i : unions) {
            if (i.getCountries().contains(field)) {
                i.removeCountry(field);
                i.nullBonus();
            }
        }
        field.setPlayer(null);
        field.checkWonders();
        countries.remove(field);
        earn(price);
    }

    public void buildCities(CountryField countryField, int amount) {
        for (int i = 0; i < amount; i++) {
            buildCity(countryField);
        }
    }

    private void buildCity(CountryField countryField) {
        if (!countryField.getUnion().isFull()) {
            //TODO
        } else {
            countryField.getUnion().buildOrDestroyCitiesInEachCountry(1);
            int count = countryField.getCityAmount() / 3 + 1;
            int pred = countryField.getCityAmount() % 3;
            if (pred == 1) {
                pay((long) (firstCityPriceRatio * count * countryField.getCityPrice()));
            } else if (pred == 2) {
                pay((long) (secondCityPriceRatio * count * countryField.getCityPrice()));
            } else {
                pay((long) (thirdCityPriceRatio * count * countryField.getCityPrice()));
            }
        }
    }

    public void destroyAllCities(CountryField countryField) {
        for (int i = 0; i < countryField.getCityAmount(); i++) {
            destroyCity(countryField);
        }
    }

    public void destroyCities(CountryField countryField, int amount) {
        for (int i = 0; i < amount; i++) {
            destroyCity(countryField);
        }
    }

    private void destroyCity(CountryField countryField) {
        if (countryField.getCityAmount() == 0) {
            //TODO
        } else {
            countryField.getUnion().buildOrDestroyCitiesInEachCountry(-1);
            int count = countryField.getCityAmount() / 3 + 1;
            earn((count * countryField.getCityPrice()));
        }
    }

    public void earn(long amount) {
        money += amount;
    }

    public void pay(long amount) {
        money -= amount;
    }

    public void pay(long amount, Player player) {
        pay(amount);
        if (player != null) {
            player.earn(amount);
        }
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public String getName() {
        return name;
    }

    public boolean isLost() {
        return isLost;
    }

    public void setLost(boolean lost) {
        isLost = lost;
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

    public Set<CountryField> getCountries() {
        return countries;
    }

    public long getMoney() {
        return money;
    }

    public int getNegativeCityIncrease() {
        return negativeCityIncrease;
    }

    public void setNegativeCityIncrease(int negativeCityIncrease) {
        this.negativeCityIncrease = negativeCityIncrease;
    }

    public int getPositiveCityIncrease() {
        return positiveCityIncrease;
    }

    public void setPositiveCityIncrease(int positiveCityIncrease) {
        this.positiveCityIncrease = positiveCityIncrease;
    }

    public double getFirstCityPriceRatio() {
        return firstCityPriceRatio;
    }

    public void setFirstCityPriceRatio(double firstCityPriceRatio) {
        this.firstCityPriceRatio = firstCityPriceRatio;
    }

    public double getSecondCityPriceRatio() {
        return secondCityPriceRatio;
    }

    public void setSecondCityPriceRatio(double secondCityPriceRatio) {
        this.secondCityPriceRatio = secondCityPriceRatio;
    }

    public double getThirdCityPriceRatio() {
        return thirdCityPriceRatio;
    }

    public void setThirdCityPriceRatio(double thirdCityPriceRatio) {
        this.thirdCityPriceRatio = thirdCityPriceRatio;
    }

    public double getPaymentRatio() {
        return paymentRatio;
    }

    public void setPaymentRatio(double paymentRatio) {
        this.paymentRatio = paymentRatio;
    }

    public int getCitiesPerTurnAvailable() {
        return citiesPerTurnAvailable;
    }

    public void setCitiesPerTurnAvailable(int citiesPerTurnAvailable) {
        this.citiesPerTurnAvailable = citiesPerTurnAvailable;
    }

    public int getAvailableThrows() {
        return availableThrows;
    }

    public void setAvailableThrows(int availableThrows) {
        this.availableThrows = availableThrows;
    }

    public int getCurrentAvailableThrows() {
        return currentAvailableThrows;
    }

    public void decreaseCurrentAvailableThrows() {
        this.currentAvailableThrows--;
    }

    public void resetCurrentAvailableThrows() {
        this.currentAvailableThrows = availableThrows;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    public long getForwardBonus() {
        return forwardBonus;
    }

    public void setForwardBonus(long forwardBonus) {
        this.forwardBonus = forwardBonus;
    }

    public long getTax() {
        return tax;
    }

    public void setTax(long tax) {
        this.tax = tax;
    }

    public int getCitiesForWonder1() {
        return citiesForWonder1;
    }

    public int getCitiesForWonder2() {
        return citiesForWonder2;
    }

    public void setCitiesForWonder2(int citiesForWonder2) {
        this.citiesForWonder2 = citiesForWonder2;
    }

    public int getCitiesForWonder3() {
        return citiesForWonder3;
    }

    public void setCitiesForWonder3(int citiesForWonder3) {
        this.citiesForWonder3 = citiesForWonder3;
    }

    public int getCitiesForWonder4() {
        return citiesForWonder4;
    }

    public void setCitiesForWonder4(int citiesForWonder4) {
        this.citiesForWonder4 = citiesForWonder4;
    }

    public double getNegativePercent() {
        return negativePercent;
    }

    public void setNegativePercent(double negativePercent) {
        this.negativePercent = negativePercent;
    }

    public double getPositivePercent() {
        return positivePercent;
    }

    public void setPositivePercent(double positivePercent) {
        this.positivePercent = positivePercent;
    }

    public int getPercentMoves() {
        return percentMoves;
    }

    public void setPercentMoves(int percentMoves) {
        this.percentMoves = percentMoves;
    }

    public int getNegativePercentMovesLeft() {
        return negativePercentMovesLeft;
    }

    public void addNegativePercentMovesLeft(int negativePercentMoves) {
        this.negativePercentMovesLeft += negativePercentMoves;
    }

    public int getPositivePercentMovesLeft() {
        return positivePercentMovesLeft;
    }

    public void addPositivePercentMovesLeft(int positivePercentMoves) {
        this.positivePercentMovesLeft += positivePercentMoves;
    }

    public int getUltraPercentMovesLeft() {
        return ultraPercentMovesLeft;
    }

    public void addUltraPercentMovesLeft(int ultraPercentMoves) {
        this.ultraPercentMovesLeft += ultraPercentMoves;
    }

    public double getUltraPercent() {
        return ultraPercent;
    }

    public void setUltraPercent(double ultraPercent) {
        this.ultraPercent = ultraPercent;
    }

    public int getUltraPercentMoves() {
        return ultraPercentMoves;
    }

    public double getOneCountryBonusRatio() {
        return oneCountryBonusRatio;
    }

    public void setOneCountryBonusRatio(double oneCountryBonusRatio) {
        this.oneCountryBonusRatio = oneCountryBonusRatio;
    }
}