package com.field;

import com.game.Player;

import java.util.HashSet;
import java.util.Set;

public abstract class Field {
    private String name;
    private Set<Player> currentPlayers = new HashSet<>();

    protected Field(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Set<Player> getCurrentPlayers() {
        return currentPlayers;
    }

    public void setCurrentPlayer(Player player) {
        currentPlayers.add(player);
    }

    public void removeCurrentPlayer(Player player) {
        currentPlayers.remove(player);
    }

    public void clearField() {
        currentPlayers.clear();
    }
}
