package com.field;

public class PercentField extends Field {
    public PercentField(PercentFieldType type) {
        this.type = type;
        this.name = type.getName();
    }
}