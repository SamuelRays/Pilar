package com.bonus;

import com.Game;
import com.Player;

public abstract class Bonus {
    protected int level = 0;
    protected Player player;

    public void increaseLevel() {
        if (level < 9) {
            long price = Game.bonusPrices.get(level + 1);
            if (player.getMoney() >= price) {
                level++;
                player.spendMoney(price);
            } else {
                //TODO
                return;
            }
        } else {
            //TODO
            return;
        }
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}