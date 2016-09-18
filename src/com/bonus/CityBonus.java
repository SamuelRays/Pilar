package com.bonus;

public class CityBonus extends Bonus {
    private int min = -1;
    private int max = 1;

    @Override
    public void increaseLevel() {
        super.increaseLevel();
        setMinMax();
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