package com.bonus;

public class FreeCityBonus extends Bonus {
    @Override
    public void increaseLevel() {
        super.increaseLevel();
        setStates(level);
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