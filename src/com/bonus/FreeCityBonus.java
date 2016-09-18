package com.bonus;

public class FreeCityBonus extends Bonus {
    private double first = 1;
    private double second = 1;
    private double third = 1;

    @Override
    public void increaseLevel() {
        super.increaseLevel();
        setStates(level);
    }

    public double getFirst() {
        return first;
    }

    public double getSecond() {
        return second;
    }

    public double getThird() {
        return third;
    }

    private void setStates(int level) {
        switch (level) {
            case 1:
                first = 1;
                second = 1;
                third = 0;
                return;
            case 2:
                first = 1;
                second = 0.5;
                third = 0;
                return;
            case 3:
                first = 1;
                second = 0;
                third = 0;
                return;
            case 4:
                first = 1;
                second = 0;
                third = 0;
                return;
            case 5:
                first = 0.25;
                second = 0;
                third = 0;
                return;
            case 6:
                first = 0.1;
                second = 0;
                third = 0;
                return;
            case 7:
                first = 0;
                second = 0;
                third = 0;
                return;
            case 8:
                first = 0;
                second = 0;
                third = -1;
                return;
            case 9:
                first = -1;
                second = -1;
                third = -1;
                return;
        }
    }
}