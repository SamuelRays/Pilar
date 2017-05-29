package com.field;

public class NonCountryField extends Field {
    public static final NonCountryField INCEPTION = new NonCountryField("Inception");
    public static final NonCountryField TAX = new NonCountryField("Tax");
    public static final NonCountryField FREE_CITY = new NonCountryField("Free city");
    public static final NonCountryField DISASTER = new NonCountryField("Disaster");
    public static final NonCountryField EVEN_PORT = new NonCountryField("Even port");
    public static final NonCountryField ODD_PORT = new NonCountryField("Odd port");
    public static final NonCountryField PROFIT_UP = new NonCountryField("Profit up");
    public static final NonCountryField PROFIT_DOWN = new NonCountryField("Profit down");
    public static final NonCountryField ULTRA_PROFIT = new NonCountryField("Ultra profit");

    private NonCountryField(String name) {
        super(name);
    }
}
