package com.bonus;

public class CityBonus extends Bonus {
    @Override
    public void increaseLevel() {
        super.increaseLevel();
        setMinMax();
    }

    private void setMinMax() {
        switch (level) {
            case 1:
                player.setNegativeCityIncrease(3);
                player.setPositiveCityIncrease(7);
                return;
            case 2:
                player.setNegativeCityIncrease(5);
                player.setPositiveCityIncrease(10);
                return;
            case 3:
                player.setNegativeCityIncrease(7);
                player.setPositiveCityIncrease(13);
                return;
            case 4:
                player.setNegativeCityIncrease(10);
                player.setPositiveCityIncrease(18);
                return;
            case 5:
                player.setNegativeCityIncrease(15);
                player.setPositiveCityIncrease(25);
                return;
            case 6:
                player.setNegativeCityIncrease(20);
                player.setPositiveCityIncrease(35);
                return;
            case 7:
                player.setNegativeCityIncrease(35);
                player.setPositiveCityIncrease(60);
                return;
            case 8:
                player.setNegativeCityIncrease(60);
                player.setPositiveCityIncrease(100);
                return;
            case 9:
                player.setNegativeCityIncrease(120);
                player.setPositiveCityIncrease(200);
                return;
        }
    }
}