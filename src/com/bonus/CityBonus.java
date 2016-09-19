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
                player.setMinCityIncrease(3);
                player.setMaxCityIncrease(7);
                return;
            case 2:
                player.setMinCityIncrease(5);
                player.setMaxCityIncrease(10);
                return;
            case 3:
                player.setMinCityIncrease(7);
                player.setMaxCityIncrease(13);
                return;
            case 4:
                player.setMinCityIncrease(10);
                player.setMaxCityIncrease(18);
                return;
            case 5:
                player.setMinCityIncrease(15);
                player.setMaxCityIncrease(25);
                return;
            case 6:
                player.setMinCityIncrease(20);
                player.setMaxCityIncrease(35);
                return;
            case 7:
                player.setMinCityIncrease(35);
                player.setMaxCityIncrease(60);
                return;
            case 8:
                player.setMinCityIncrease(60);
                player.setMaxCityIncrease(100);
                return;
            case 9:
                player.setMinCityIncrease(120);
                player.setMaxCityIncrease(200);
                return;
        }
    }
}