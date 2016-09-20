package com.bonus;

import com.Game;

public class FreeCityBonus extends Bonus {
    @Override
    public void increaseLevel() {
        super.increaseLevel();
        setStates(level);
    }

    @Override
    protected void nullStates() {
        player.setFirstCityPriceRatio(Game.DEFAULT_FIRST_CITY_PRICE_RATIO);
        player.setSecondCityPriceRatio(Game.DEFAULT_SECOND_CITY_PRICE_RATIO);
        player.setThirdCityPriceRatio(Game.DEFAULT_THIRD_CITY_PRICE_RATIO);
    }

    private void setStates(int level) {
        switch (level) {
            case 1:
                player.setFirstCityPriceRatio(1);
                player.setSecondCityPriceRatio(1);
                player.setThirdCityPriceRatio(0);
                return;
            case 2:
                player.setFirstCityPriceRatio(1);
                player.setSecondCityPriceRatio(0.5);
                player.setThirdCityPriceRatio(0);
                return;
            case 3:
                player.setFirstCityPriceRatio(1);
                player.setSecondCityPriceRatio(0);
                player.setThirdCityPriceRatio(0);
                return;
            case 4:
                player.setFirstCityPriceRatio(0.5);
                player.setSecondCityPriceRatio(0);
                player.setThirdCityPriceRatio(0);
                return;
            case 5:
                player.setFirstCityPriceRatio(0.25);
                player.setSecondCityPriceRatio(0);
                player.setThirdCityPriceRatio(0);
                return;
            case 6:
                player.setFirstCityPriceRatio(0.1);
                player.setSecondCityPriceRatio(0);
                player.setThirdCityPriceRatio(0);
                return;
            case 7:
                player.setFirstCityPriceRatio(0);
                player.setSecondCityPriceRatio(0);
                player.setThirdCityPriceRatio(0);
                return;
            case 8:
                player.setFirstCityPriceRatio(0);
                player.setSecondCityPriceRatio(0);
                player.setThirdCityPriceRatio(-1);
                return;
            case 9:
                player.setFirstCityPriceRatio(-1);
                player.setSecondCityPriceRatio(-1);
                player.setThirdCityPriceRatio(-1);
                return;
        }
    }
}