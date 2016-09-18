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
    private int money;
    private Set<Field> countries;

    public Player(String name) {
        this.name = name;
    }

    public void addCountryField(CountryField field) {
        money -= field.getCountry().getPrice();
        countries.add(field);
        field.setPlayer(this);
        checkUnion(field);
    }

    public int getMoney() {
        return money;
    }

    public void spendMoney(int amount) {
        money -= amount;
    }

    private void checkUnion(CountryField field) {
        Union union = field.getCountry().getUnion();
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