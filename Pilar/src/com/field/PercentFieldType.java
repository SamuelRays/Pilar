package com.field;

public enum PercentFieldType implements FieldType {
    NEGATIVE_PERCENT_FIELD("Negative percent"),
    POSITIVE_PERCENT_FIELD("Positive percent"),
    ULTRA_PERCENT_FIELD("Ultra percent");

    private String name;

    PercentFieldType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
