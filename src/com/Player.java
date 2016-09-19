package com;

import com.bonus.Bonus;
import com.field.CountryField;
import com.field.Field;
import com.field.Union;

import java.util.Set;

public class Player {
    private String name;
    private Set<Bonus> bonuses;
    private Field currentField;
    private Set<Field> countries;
    private long money;
    private int negativeCityIncrease = Game.DEFAULT_NEGATIVE_CITY_INCREASE;
    private int positiveCityIncrease = Game.DEFAULT_POSITIVE_CITY_INCREASE;
    private double firstCityPriceRatio = Game.DEFAULT_FIRST_CITY_PRICE_RATIO;
    private double secondCityPriceRatio = Game.DEFAULT_SECOND_CITY_PRICE_RATIO;
    private double thirdCityPriceRatio = Game.DEFAULT_THIRD_CITY_PRICE_RATIO;
    private double paymentRatio = Game.DEFAULT_PAYMENT_RATIO;
    private int citiesPerTurnAvailable = Game.DEFAULT_CITIES_PER_TURN_AVAILABLE;
    private int availableThrows = Game.DEFAULT_AVAILABLE_THROWS;
    private long salary = Game.DEFAULT_SALARY;
    private long forwardBonus = Game.DEFAULT_FORWARD_BONUS;
    private long tax = -Game.DEFAULT_TAX;
    private int citiesForWonder1 = Game.DEFAULT_CITIES_FOR_WONDER_1;
    private int citiesForWonder2 = Game.DEFAULT_CITIES_FOR_WONDER_2;
    private int citiesForWonder3 = Game.DEFAULT_CITIES_FOR_WONDER_3;
    private int citiesForWonder4 = Game.DEFAULT_CITIES_FOR_WONDER_4;
    private double negativePercent = Game.DEFAULT_NEGATIVE_PERCENT;
    private double positivePercent = Game.DEFAULT_POSITIVE_PERCENT;
    private int percentMoves = Game.DEFAULT_PERCENT_MOVES;
    private double ultraPercent = Game.DEFAULT_ULTRA_PERCENT;
    private int ultraPercentMoves = Game.DEFAULT_ULTRA_PERCENT_MOVES;
    private double oneCountryBonusRatio = Game.DEFAULT_ONE_COUNTRY_BONUS_RATIO;

    public Player(String name) {
        this.name = name;
    }

    public void buyCountryField(CountryField field) {
        money -= field.getPrice();
        countries.add(field);
        field.setPlayer(this);
        checkUnion(field);
    }

    public void pay(long amount) {
        money -= amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Bonus> getBonuses() {
        return bonuses;
    }

    public void setBonuses(Set<Bonus> bonuses) {
        this.bonuses = bonuses;
    }

    public Field getCurrentField() {
        return currentField;
    }

    public void setCurrentField(Field currentField) {
        this.currentField = currentField;
    }

    public Set<Field> getCountries() {
        return countries;
    }

    public void setCountries(Set<Field> countries) {
        this.countries = countries;
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

    public double getUltraPercent() {
        return ultraPercent;
    }

    public void setUltraPercent(double ultraPercent) {
        this.ultraPercent = ultraPercent;
    }

    public double getUltraPercentMoves() {
        return ultraPercentMoves;
    }

    public void setUltraPercentMoves(int ultraPercentMoves) {
        this.ultraPercentMoves = ultraPercentMoves;
    }

    public double getOneCountryBonusRatio() {
        return oneCountryBonusRatio;
    }

    public void setOneCountryBonusRatio(double oneCountryBonusRatio) {
        this.oneCountryBonusRatio = oneCountryBonusRatio;
    }

    private void checkUnion(CountryField field) {
        Union union = field.getUnion();
        if (countries.containsAll(union.getCountries())) {
            try {
                Bonus bonus = (Bonus) union.getBonus().newInstance();
                bonuses.add(bonus);
                bonus.setPlayer(this);
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }
}