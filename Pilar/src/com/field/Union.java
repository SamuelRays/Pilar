package com.field;

import com.Player;
import com.bonus.Bonus;
import com.bonus.BonusFactory;

import java.util.HashSet;
import java.util.Set;

public class Union {
    private Set<CountryFieldType> countryTypes;
    private Set<CountryField> countries = new HashSet<>();
    Bonus bonus;
    private boolean isFull = false;

    public Union(UnionType unionType, Player player) {
        bonus = BonusFactory.getBonus(unionType.getBonus());
        countryTypes = unionType.getCountries();
        bonus.setPlayer(player);
    }

    public void buyBonusLevel() {
        bonus.increaseLevel();
    }

    public void nullBonus() {
        bonus.nullLevel();
    }

    public void buildOrDestroyCitiesInEachCountry(int amount) {
        for (CountryField i : countries) {
            i.buildOrDestroyCities(amount);
        }
    }

    public void addCountry(CountryField field) {
        if (countryTypes.contains(field.getType())) {
            countries.add(field);
            field.setUnion(this);
            checkIsFull();
        }
    }

    public void removeCountry(CountryField field) {
        countries.remove(field);
        field.setUnion(null);
        checkIsFull();
    }

    public Set<CountryField> getCountries() {
        return countries;
    }

    public Bonus getBonus() {
        return bonus;
    }

    public boolean isFull() {
        return isFull;
    }

    private void checkIsFull() {
        isFull = countries.size() == countryTypes.size();
    }
}
