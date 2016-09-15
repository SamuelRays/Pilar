package com.field;

class MoneyField implements Field {
    private String name;
    private int amount;

    public MoneyField(String name, int amount) {
        this.name = name;
        this.amount = amount;
    }
}