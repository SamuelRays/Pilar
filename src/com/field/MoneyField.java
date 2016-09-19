package com.field;

public class MoneyField extends Field {
    public MoneyField(MoneyFieldType type) {
        this.name = type.getName();
    }
}