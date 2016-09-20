package com.bonus;

import com.Game;

public class OneCountryBonus extends Bonus {
    @Override
    public void increaseLevel() {
        super.increaseLevel();
        setRatio(level);
    }

    @Override
    protected void nullStates() {
        player.setOneCountryBonusRatio(Game.DEFAULT_ONE_COUNTRY_BONUS_RATIO);
    }

    private void setRatio(int level) {
        switch (level) {
            case 1:
                player.setOneCountryBonusRatio(1.4);
                return;
            case 2:
                player.setOneCountryBonusRatio(2);
                return;
            case 3:
                player.setOneCountryBonusRatio(3);
                return;
            case 4:
                player.setOneCountryBonusRatio(5);
                return;
            case 5:
                player.setOneCountryBonusRatio(7);
                return;
            case 6:
                player.setOneCountryBonusRatio(10);
                return;
            case 7:
                player.setOneCountryBonusRatio(15);
                return;
            case 8:
                player.setOneCountryBonusRatio(30);
                return;
            case 9:
                player.setOneCountryBonusRatio(100);
                return;
        }
    }
}