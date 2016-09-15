package com.field;

import com.field.Union;

/**
 * Created by nadareishvili on 15.09.2016.
 */
public enum Country {
    FRANCE(Union.SOUTH_EUROPE),
    SPAIN(Union.SOUTH_EUROPE),
    ITALY(Union.SOUTH_EUROPE),
    USA(Union.NORTH_AMERICA),
    CANADA(Union.NORTH_AMERICA),
    INDIA(Union.EAST_ASIA),
    CHINA(Union.EAST_ASIA),
    JAPAN(Union.EAST_ASIA),
    BRAZIL(Union.SOUTH_AMERICA),
    ARGENTINA(Union.SOUTH_AMERICA),
    COLUMBIA(Union.SOUTH_AMERICA),
    VENEZUELA(Union.SOUTH_AMERICA),
    GERMANY(Union.MIDDLE_EUROPE),
    AUSTRIA(Union.MIDDLE_EUROPE),
    GREAT_BRITAIN(Union.MIDDLE_EUROPE),
    NETHERLANDS(Union.WEST_EUROPE),
    DENMARK(Union.WEST_EUROPE),
    BELGIUM(Union.WEST_EUROPE),
    NORWAY(Union.NORTH_EUROPE),
    SWEDEN(Union.NORTH_EUROPE),
    FINLAND(Union.NORTH_EUROPE),
    UAE(Union.WEST_ASIA),
    KUWAIT(Union.WEST_ASIA),
    QATAR(Union.WEST_ASIA),
    LUXEMBOURG(Union.SMALL),
    VATICAN(Union.SMALL),
    SINGAPORE(Union.SMALL),
    MONACO(Union.SMALL),
    AUSTRALIA(Union.THREE_NATIONS_CUP),
    NEW_ZEALAND(Union.THREE_NATIONS_CUP),
    SOUTH_AFRICA(Union.THREE_NATIONS_CUP);

    private Union union;

    Country(Union union) {
        this.union = union;
    }

    public Union getUnion() {
        return union;
    }
}
