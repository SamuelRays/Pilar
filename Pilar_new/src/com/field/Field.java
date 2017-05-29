package com.field;

import com.game.Player;

public abstract class Field {
    private String name;
    private Player currentPlayer;

    protected Field(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }
}
