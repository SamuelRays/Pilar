package com.field;

import com.Player;

public abstract class Field {
    protected String name;
    protected FieldType type;
    protected Player currentPlayer;

    public String getName() {
        return name;
    }

    public FieldType getType() {
        return type;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }
}