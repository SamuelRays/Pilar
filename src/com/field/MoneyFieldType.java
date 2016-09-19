package com.field;

public enum MoneyFieldType implements FieldType {
    TAX("Tax", -5000),
    FORWARD("Forward", 5000);

    private String name;
    private long amount;

    MoneyFieldType(String name, long amount) {
        this.name = name;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public long getAmount() {
        return amount;
    }
}
