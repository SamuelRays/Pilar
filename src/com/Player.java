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
    private int minCityIncrease = -1;
    private int maxCityIncrease = 1;
    private double firstCityPriceRatio = 1;
    private double secondCityPriceRatio = 1;
    private double thirdCityPriceRatio = 1;
    private double paymentRatio = 1;
    private int citiesPerTurnAvailable = 1;
    private int availableThrows = 1;
    private long salary = 5000;
    private long forwardBonus = 5000;
    private long tax = -5000;
    private int citiesForWonder1 = 3;
    private int citiesForWonder2 = 0;
    private int citiesForWonder3 = 0;
    private int citiesForWonder4 = 0;
    private double minPercent = 0.9;
    private double maxPercent = 1.1;
    private int percentMoves = 3;
    private double ultraPercent = 2;
    private int ultraPercentMoves = 1;
    private double oneCountryBonusRatio = 1.4;

    public Player(String name) {
        this.name = name;
    }

    public void addCountryField(CountryField field) {
        money -= field.getPrice();
        countries.add(field);
        field.setPlayer(this);
        checkUnion(field);
    }

    public long getMoney() {
        return money;
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

    public void setMoney(long money) {
        this.money = money;
    }

    public int setMinCityIncrease() {
        return minCityIncrease;
    }

    public void setMinCityIncrease(int minCityIncrease) {
        this.minCityIncrease = minCityIncrease;
    }

    public int getMaxCityIncrease() {
        return maxCityIncrease;
    }

    public void setMaxCityIncrease(int maxCityIncrease) {
        this.maxCityIncrease = maxCityIncrease;
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

    public double getMinPercent() {
        return minPercent;
    }

    public void setMinPercent(double minPercent) {
        this.minPercent = minPercent;
    }

    public double getMaxPercent() {
        return maxPercent;
    }

    public void setMaxPercent(double maxPercent) {
        this.maxPercent = maxPercent;
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