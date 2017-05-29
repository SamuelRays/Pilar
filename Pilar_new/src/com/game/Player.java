package com.game;

import com.data.DataSource;
import com.field.CountryField;
import com.field.Field;
import com.field.Union;

import java.util.HashSet;
import java.util.Set;

public class Player {
    private Set<CountryField> countryFields = new HashSet<>();
    private Set<Union> unions = new HashSet<>();
    private Field currentField;
    private long money = DataSource.START_MONEY_AMOUNT;

    public boolean changeMoneyAmount(long value) {
        if (money + value < 0) {
            return false;
        } else {
            money += value;
            return true;
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
}
