package com.field;

public class PercentField implements Field {
    private String name;
    private double ratio;

    public PercentField(PercentFieldType type) {
        this.name = type.getName();
        this.ratio = type.getRatio();
    }
}