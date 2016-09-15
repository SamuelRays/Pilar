package com;

import com.bonus.Bonus;
import com.field.Field;

import java.util.Set;

public class Player {
    private String name;
    private Set<Bonus> bonuses;
    private Field currentField;
    private int money;
    private Set<Field> countries;

    public Player(String name) {
        this.name = name;
    }
}