package com.field;

public enum CountryFieldType implements FieldType {
    FRANCE(UnionType.SOUTH_EUROPE,"France", 10000, 1700),
    SPAIN(UnionType.SOUTH_EUROPE, "Spain", 10000, 1700),
    ITALY(UnionType.SOUTH_EUROPE, "Italy", 10000, 1700),
    USA(UnionType.NORTH_AMERICA, "USA", 16000, 1700),
    CANADA(UnionType.NORTH_AMERICA, "Canada", 16000, 1700),
    INDIA(UnionType.EAST_ASIA, "India", 15000, 2200),
    CHINA(UnionType.EAST_ASIA, "China", 15000, 2200),
    JAPAN(UnionType.EAST_ASIA, "Japan", 15000, 2200),
    BRAZIL(UnionType.SOUTH_AMERICA, "Brazil", 5000, 600),
    ARGENTINA(UnionType.SOUTH_AMERICA, "Argentina", 5000, 600),
    COLUMBIA(UnionType.SOUTH_AMERICA, "Colimbia", 5000, 600),
    VENEZUELA(UnionType.SOUTH_AMERICA, "Venezuela", 5000, 600),
    GERMANY(UnionType.MIDDLE_EUROPE, "Germany", 11000, 1800),
    AUSTRIA(UnionType.MIDDLE_EUROPE, "Austria", 11000, 1800),
    GREAT_BRITAIN(UnionType.MIDDLE_EUROPE, "Great Britain", 11000, 1800),
    NETHERLANDS(UnionType.WEST_EUROPE, "Netherlands", 12000, 1900),
    DENMARK(UnionType.WEST_EUROPE, "Denmark", 12000, 1900),
    BELGIUM(UnionType.WEST_EUROPE, "Belgium", 12000, 1900),
    NORWAY(UnionType.NORTH_EUROPE, "Norway", 13000, 2000),
    SWEDEN(UnionType.NORTH_EUROPE, "Sweden", 13000, 2000),
    FINLAND(UnionType.NORTH_EUROPE, "Finland", 13000, 2000),
    UAE(UnionType.WEST_ASIA, "UAE", 20000, 3500),
    KUWAIT(UnionType.WEST_ASIA, "Kuwait", 20000, 3500),
    QATAR(UnionType.WEST_ASIA, "Qatar", 20000, 3500),
    LUXEMBOURG(UnionType.SMALL, "Luxembourg", 17000, 3000),
    VATICAN(UnionType.SMALL, "Vatican", 17000, 3000),
    SINGAPORE(UnionType.SMALL, "Singapore", 17000, 3000),
    MONACO(UnionType.SMALL, "Monaco", 17000, 3000),
    AUSTRALIA(UnionType.THREE_NATIONS_CUP, "Australia", 14000, 2100),
    NEW_ZEALAND(UnionType.THREE_NATIONS_CUP, "New Zealand", 14000, 2100),
    SOUTH_AFRICA(UnionType.THREE_NATIONS_CUP, "South Africa", 14000, 2100);

    private UnionType unionType;
    private String name;
    private int price;
    private int cityPrice;
    private int visitCostPerCity;

    CountryFieldType(UnionType unionType, String name, int price, int cityPrice) {
        this.unionType = unionType;
        this.name = name;
        this.price = price;
        this.cityPrice = cityPrice;
        this.visitCostPerCity = price / 10;
    }

    public UnionType getUnionType() {
        return unionType;
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
