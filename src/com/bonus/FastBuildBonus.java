package com.bonus;

public class FastBuildBonus extends Bonus {
    private int quantity = 1;

    @Override
    public void increaseLevel() {
        super.increaseLevel();
    }

    public int getQuantity() {
        return quantity;
    }

    private void setQuantity(int level) {
        switch (level) {
            case 1:
                quantity = 2;
                return;
            case 2:
                quantity = 3;
                return;
            case 3:
                quantity = 4;
                return;
            case 4:
                quantity = 6;
                return;
            case 5:
                quantity = 10;
                return;
            case 6:
                quantity = 15;
                return;
            case 7:
                quantity = 30;
                return;
            case 8:
                quantity = 60;
                return;
            case 9:
                quantity = 200;
                return;
        }
    }
}