package com.bonus;

public class PaymentBonus extends Bonus {
    private double ratio = 1;

    @Override
    public void increaseLevel() {
        super.increaseLevel();
        setRatio(level);
    }

    public double getRatio() {
        return ratio;
    }

    private void setRatio(int level) {
        switch (level) {
            case 1:
                ratio = 0.8;
                return;
            case 2:
                ratio = 0.7;
                return;
            case 3:
                ratio = 0.6;
                return;
            case 4:
                ratio = 0.5;
                return;
            case 5:
                ratio = 0.3;
                return;
            case 6:
                ratio = 0.2;
                return;
            case 7:
                ratio = 0.1;
                return;
            case 8:
                ratio = 0.05;
                return;
            case 9:
                ratio = 0.01;
                return;
        }
    }
}