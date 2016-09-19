package com.field;

public class PortField extends Field {
    public PortField(PortFieldType type) {
        this.type = type;
        this.name = type.getName();
    }
}