package com.field;

public enum PortFieldType implements FieldType {
    EVEN_PORT("Even forward port"),
    ODD_PORT("Odd forward port");

    private String name;

    PortFieldType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
