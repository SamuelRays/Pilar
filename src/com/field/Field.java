package com.field;

import com.Player;

public abstract class Field {
    protected String name;
    protected Player currentPlayer;

    public String getName() {
        return name;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }
}