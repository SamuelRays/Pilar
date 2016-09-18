package com.bonus;

import com.Game;
import com.Player;

public class CityBonus implements Bonus {
    private int level = 0;
    private int min = -1;
    private int max = 1;
    private Player player;

    @Override
    public void increaseLevel() {
        if (level < 9) {
            int price = Game.bonusPrices.get(level + 1);
            if (player.getMoney() >= price) {
                level++;
                player.spendMoney(price);
                setMinMax();
            } else {
                //TODO
            }
        } else {
            //TODO
        }
    }

    public int getLevel() {
        return level;
    }

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }

    public Player getPlayer() {
        return player;
    }

    @Override
    public void setPlayer(Player player) {
        this.player = player;
    }

    private void setMinMax() {
        switch (level) {
            case 1:
                min = 3;
                max = 7;
                return;
            case 2:
                min = 5;
                max = 10;
                return;
            case 3:
                min = 7;
                max = 13;
                return;
            case 4:
                min = 10;
                max = 18;
                return;
            case 5:
                min = 15;
                max = 25;
                return;
            case 6:
                min = 20;
                max = 35;
                return;
            case 7:
                min = 35;
                max = 60;
                return;
            case 8:
                min = 60;
                max = 100;
                return;
            case 9:
                min = 120;
                max = 200;
                return;
        }
    }
}