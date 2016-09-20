package com.field;

import com.bonus.Bonus;

import java.util.Set;

public class Union {
    private Set<CountryFieldType> countries;
    Bonus bonus;

    public Union(UnionType type) {
        countries = type.getCountries();
        try {
            bonus = (Bonus) type.getBonus().newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public Set<CountryFieldType> getCountries() {
        return countries;
    }

    public Bonus getBonus() {
        return bonus;
    }
}
