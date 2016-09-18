package com.field;

import com.bonus.*;

import java.util.HashSet;
import java.util.Set;

public enum Union {
    SOUTH_EUROPE(CityBonus.class, Country.FRANCE, Country.SPAIN, Country.ITALY),
    NORTH_AMERICA(FreeCityBonus.class, Country.USA, Country.CANADA),
    EAST_ASIA(PaymentBonus.class, Country.INDIA, Country.CHINA, Country.JAPAN),
    SOUTH_AMERICA(FastBuildBonus.class, Country.BRAZIL, Country.ARGENTINA, Country.COLUMBIA, Country.VENEZUELA),
    MIDDLE_EUROPE(MoveChanceBonus.class, Country.GERMANY, Country.AUSTRIA, Country.GREAT_BRITAIN),
    WEST_EUROPE(MoreThrowsBonus.class, Country.NETHERLANDS, Country.DENMARK, Country.BELGIUM),
    NORTH_EUROPE(MoneyBonus.class, Country.NORWAY, Country.SWEDEN, Country.FINLAND),
    WEST_ASIA(WonderBonus.class, Country.UAE, Country.KUWAIT, Country.QATAR),
    SMALL(PercentBonus.class, Country.LUXEMBOURG, Country.VATICAN, Country.SINGAPORE, Country.MONACO),
    THREE_NATIONS_CUP(OneCountryBonus.class, Country.AUSTRALIA, Country.NEW_ZEALAND, Country.SOUTH_AFRICA);

    private Class bonus;
    private Set<Country> countries = new HashSet<>();

    Union(Class bonus, Country... countries) {
        this.bonus = bonus;
        for (Country i : countries) {
            this.countries.add(i);
        }
    }

    public Class getBonus() {
        return bonus;
    }
}