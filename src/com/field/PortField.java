package com.field;

public class PortField implements Field {
    private String name;

    public PortField(PortFieldType type) {
        this.name = type.getName();
    }

    public String getName() {
        return name;
    }
}