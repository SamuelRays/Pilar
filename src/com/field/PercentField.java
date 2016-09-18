package com.field;

public class PercentField implements Field {
    private String name;
    private float ratio;

    public PercentField(String name, float ratio) {
        this.name = name;
        this.ratio = ratio;
    }
}