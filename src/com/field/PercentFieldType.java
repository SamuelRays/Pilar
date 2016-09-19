package com.field;

public enum PercentFieldType implements FieldType {
    NEGATIVE_PERCENT_FIELD("Negative percent", 0.9),
    POSITIVE_PERCENT_FIELD("Positive percent", 1.1),
    ULTRA_PERCENT_FIELD("Ultra percent", 2);

    private String name;
    private double ratio;

    PercentFieldType(String name, double ratio) {
        this.name = name;
        this.ratio = ratio;
    }

    public String getName() {
        return name;
    }

    public double getRatio() {
        return ratio;
    }
}
