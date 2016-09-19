package com;

import com.bonus.Bonus;
import com.field.*;

import java.util.Set;

public class Player {
    private Game game;
    private String name;
    private Set<Bonus> bonuses;
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

    public Player(String name) {
        this.name = name;
    }

    public void buyCountryField(CountryField field) {
        money -= field.getPrice();
        countries.add(field);
        field.setPlayer(this);
        checkUnion(field);
    }

    public void earn(long amount) {
        money += amount;
    }

    public void pay(long amount) {
        money -= amount;
    }

    private void pay(long amount, Player player) {
        money -= amount;
        player.earn(amount);
    }

    public void enterField() {
        currentField.setCurrentPlayer(this);
        if (currentField instanceof CityField) {
            countries.stream().filter(CountryField::isUnionCompleted).forEach(i -> {
                if (currentField.getType().equals(CityFieldType.NEGATIVE_CITY_BONUS)) {
                    i.buildCities(negativeCityIncrease);
                } else {
                    i.buildCities(positiveCityIncrease);
                }
            });
        } else if (currentField instanceof MoneyField) {
            if (currentField.getType().equals(MoneyFieldType.FORWARD)) {
                earn(forwardBonus);
            } else {
                pay(tax);
            }
        } else if (currentField instanceof PortField) {
            int[] dice = game.throwDice();
            int sum = dice[0] + dice[1];
            if (currentField.getType().equals(PortFieldType.EVEN_PORT)) {
                if (sum % 2 == 0) {
                    game.move(this, dice, true);
                } else {
                    game.move(this, dice, false);
                }
            } else {
                if (sum % 2 == 0) {
                    game.move(this, dice, false);
                } else {
                    game.move(this, dice, true);
                }
            }
        } else if (currentField instanceof PercentField) {
            if (currentField.getType().equals(PercentFieldType.NEGATIVE_PERCENT_FIELD)) {
                addNegativePercentMovesLeft(percentMoves);
            } else if (currentField.getType().equals(PercentFieldType.POSITIVE_PERCENT_FIELD)) {
                addPositivePercentMovesLeft(percentMoves);
            } else {
                addUltraPercentMovesLeft(ultraPercentMoves);
            }
        } else {
            CountryField field = (CountryField) currentField;
            if (countries.contains(field)) {
                return;
            } else if (field.getPlayer() == null) {
                buyCountryField(field);
                //TODO
            } else {
                Player player = field.getPlayer();
                int negMoves = player.getNegativePercentMovesLeft();
                int posMoves = player.getPositivePercentMovesLeft();
                int ultraMoves = player.getUltraPercentMovesLeft();
                double neg = 1;
                double pos = 1;
                double ultra = 1;
                if (negMoves != 0) {
                    neg = player.getNegativePercent();
                }
                if (posMoves != 0) {
                    pos = player.getPositivePercent();
                }
                if (ultraMoves != 0) {
                    ultra = player.getUltraPercent();
                }
                long payment = (long) (neg * pos * ultra * paymentRatio * field.getCityAmount() *
                        field.getVisitCostPerCity() * (1 + field.getWonderAmount() / 10.0));
                pay(payment, player);
                //TODO
            }
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

    public Set<Bonus> getBonuses() {
        return bonuses;
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

    public double getUltraPercentMoves() {
        return ultraPercentMoves;
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