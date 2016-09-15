package com;

import com.bonus.*;

public enum Union {
    SOUTH_EUROPE(CityBonus.class),
    NORTH_AMERICA(FreeCityBonus.class),
    EAST_ASIA(PaymentBonus.class),
    SOUTH_AMERICA(FastBuildBonus.class),
    MIDDLE_EUROPE(MoveChanceBonus.class),
    WEST_EUROPE(MoreThrowsBonus.class),
    NORTH_EUROPE(MoneyBonus.class),
    WEST_ASIA(WonderBonus.class),
    SMALL(PercentBonus.class),
    THREE_NATIONS_CUP(OneCountryBonus.class);

    private Class bonus;

    Union(Class bonus) {
        this.bonus = bonus;
    }

    public Class getBonus() {
        return bonus;
    }
}