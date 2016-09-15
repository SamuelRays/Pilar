package com.field;

public enum Country {
    FRANCE(Union.SOUTH_EUROPE,"France", 10000, 1700),
    SPAIN(Union.SOUTH_EUROPE, "Spain", 10000, 1700),
    ITALY(Union.SOUTH_EUROPE, "Italy", 10000, 1700),
    USA(Union.NORTH_AMERICA, "USA", 16000, 1700),
    CANADA(Union.NORTH_AMERICA, "Canada", 16000, 1700),
    INDIA(Union.EAST_ASIA, "India", 15000, 2200),
    CHINA(Union.EAST_ASIA, "China", 15000, 2200),
    JAPAN(Union.EAST_ASIA, "Japan", 15000, 2200),
    BRAZIL(Union.SOUTH_AMERICA, "Brazil", 5000, 600),
    ARGENTINA(Union.SOUTH_AMERICA, "Argentina", 5000, 600),
    COLUMBIA(Union.SOUTH_AMERICA, "Colimbia", 5000, 600),
    VENEZUELA(Union.SOUTH_AMERICA, "Venezuela", 5000, 600),
    GERMANY(Union.MIDDLE_EUROPE, "Germany", 11000, 1800),
    AUSTRIA(Union.MIDDLE_EUROPE, "Austria", 11000, 1800),
    GREAT_BRITAIN(Union.MIDDLE_EUROPE, "Great Britain", 11000, 1800),
    NETHERLANDS(Union.WEST_EUROPE, "Netherlands", 12000, 1900),
    DENMARK(Union.WEST_EUROPE, "Denmark", 12000, 1900),
    BELGIUM(Union.WEST_EUROPE, "Belgium", 12000, 1900),
    NORWAY(Union.NORTH_EUROPE, "Norway", 13000, 2000),
    SWEDEN(Union.NORTH_EUROPE, "Sweden", 13000, 2000),
    FINLAND(Union.NORTH_EUROPE, "Finland", 13000, 2000),
    UAE(Union.WEST_ASIA, "UAE", 20000, 3500),
    KUWAIT(Union.WEST_ASIA, "Kuwait", 20000, 3500),
    QATAR(Union.WEST_ASIA, "Qatar", 20000, 3500),
    LUXEMBOURG(Union.SMALL, "Luxembourg", 17000, 3000),
    VATICAN(Union.SMALL, "Vatican", 17000, 3000),
    SINGAPORE(Union.SMALL, "Singapore", 17000, 3000),
    MONACO(Union.SMALL, "Monaco", 17000, 3000),
    AUSTRALIA(Union.THREE_NATIONS_CUP, "Australia", 14000, 2100),
    NEW_ZEALAND(Union.THREE_NATIONS_CUP, "New Zealand", 14000, 2100),
    SOUTH_AFRICA(Union.THREE_NATIONS_CUP, "South Africa", 14000, 2100);

    private Union union;
    private String name;
    private int price;
    private int cityPrice;
    private int visitCostPerCity;

    Country(Union union, String name, int price, int cityPrice) {
        this.union = union;
        this.name = name;
        this.price = price;
        this.cityPrice = cityPrice;
        this.visitCostPerCity = price / 10;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getCityPrice() {
        return cityPrice;
    }

    public int getVisitCostPerCity() {
        return visitCostPerCity;
    }
}
