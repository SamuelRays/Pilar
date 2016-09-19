package com.field;

import com.bonus.*;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public enum Union {
    SOUTH_EUROPE(CityBonus.class, CountryFieldType.FRANCE, CountryFieldType.SPAIN, CountryFieldType.ITALY),
    NORTH_AMERICA(FreeCityBonus.class, CountryFieldType.USA, CountryFieldType.CANADA),
    EAST_ASIA(PaymentBonus.class, CountryFieldType.INDIA, CountryFieldType.CHINA, CountryFieldType.JAPAN),
    SOUTH_AMERICA(FastBuildBonus.class, CountryFieldType.BRAZIL, CountryFieldType.ARGENTINA, CountryFieldType.COLUMBIA, CountryFieldType.VENEZUELA),
    MIDDLE_EUROPE(MoveChanceBonus.class, CountryFieldType.GERMANY, CountryFieldType.AUSTRIA, CountryFieldType.GREAT_BRITAIN),
    WEST_EUROPE(MoreThrowsBonus.class, CountryFieldType.NETHERLANDS, CountryFieldType.DENMARK, CountryFieldType.BELGIUM),
    NORTH_EUROPE(MoneyBonus.class, CountryFieldType.NORWAY, CountryFieldType.SWEDEN, CountryFieldType.FINLAND),
    WEST_ASIA(WonderBonus.class, CountryFieldType.UAE, CountryFieldType.KUWAIT, CountryFieldType.QATAR),
    SMALL(PercentBonus.class, CountryFieldType.LUXEMBOURG, CountryFieldType.VATICAN, CountryFieldType.SINGAPORE, CountryFieldType.MONACO),
    THREE_NATIONS_CUP(OneCountryBonus.class, CountryFieldType.AUSTRALIA, CountryFieldType.NEW_ZEALAND, CountryFieldType.SOUTH_AFRICA);

    private Class bonus;
    private Set<CountryFieldType> countries = new HashSet<>();

    Union(Class bonus, CountryFieldType... countries) {
        this.bonus = bonus;
        Collections.addAll(this.countries, countries);
    }

    public Class getBonus() {
        return bonus;
    }

    public Set<CountryFieldType> getCountries() {
        return countries;
    }
}