package com.field;

public class MoneyField implements Field {
    private String name;
    private long amount;

    public MoneyField(MoneyFieldType type) {
        this.name = type.getName();
        this.amount = type.getAmount();
    }
}