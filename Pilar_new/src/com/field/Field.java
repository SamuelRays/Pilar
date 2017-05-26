package com.field;

public enum Field {
    INCEPTION("Inception", false),
    TAX("Tax", false),
    FREE_CITY("Free city", false),
    DISASTER("Disaster", false),
    EVEN_PORT("Even port", false),
    ODD_PORT("Odd port", false),
    PROFIT_UP("Profit up", false),
    PROFIT_DOWN("Profit down", false),
    ULTRA_PROFIT("Ultra profit", false),
    FRANCE("France", true),
    SPAIN("Spain", true),
    ITALY("Italy", true),
    USA("USA", true),
    CANADA("Canada", true),
    INDIA("India", true),
    CHINA("China", true),
    JAPAN("Japan", true),
    BRAZIL("Brazil", true),
    ARGENTINA("Argentina", true),
    COLUMBIA("Colimbia", true),
    VENEZUELA("Venezuela", true),
    GERMANY("Germany", true),
    AUSTRIA("Austria", true),
    GREAT_BRITAIN("Great Britain", true),
    NETHERLANDS("Netherlands", true),
    DENMARK("Denmark", true),
    BELGIUM("Belgium", true),
    NORWAY("Norway", true),
    SWEDEN("Sweden", true),
    FINLAND("Finland", true),
    UAE("UAE", true),
    KUWAIT("Kuwait", true),
    QATAR("Qatar", true),
    LUXEMBOURG("Luxembourg", true),
    VATICAN("Vatican", true),
    SINGAPORE("Singapore", true),
    MONACO("Monaco", true),
    AUSTRALIA("Australia", true),
    NEW_ZEALAND("New Zealand", true),
    SOUTH_AFRICA("South Africa", true);

    private String name;
    private boolean isCountry;

    Field(String name, boolean isCountry) {
        this.name = name;
        this.isCountry = isCountry;
    }

    public String getName() {
        return name;
    }

    public boolean isCountry() {
        return isCountry;
    }
}
