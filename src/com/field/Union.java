package com.field;

import com.Player;
import com.bonus.Bonus;
import com.bonus.BonusFactory;

import java.util.HashSet;
import java.util.Set;

public class Union {
    private UnionType unionType;
    private Set<CountryFieldType> countryTypes;
    private Set<CountryField> countries = new HashSet<>();
    Bonus bonus;
    private Player player;
    private boolean isFull = false;

    public Union(UnionType unionType, Player player) {
        this.player = player;
        bonus.setPlayer(player);
        this.unionType = unionType;
        countryTypes = unionType.getCountries();
        bonus = BonusFactory.getBonus(unionType.getBonus());
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
        checkIsFull();
    }

    public UnionType getUnionType() {
        return unionType;
    }

    public Set<CountryFieldType> getCountryTypes() {
        return countryTypes;
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
        if (countries.size() == countryTypes.size()) {
            isFull = true;
        } else {
            isFull = false;
        }
    }
}
