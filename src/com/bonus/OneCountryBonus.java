package com.bonus;

public class OneCountryBonus extends Bonus {
    @Override
    public void increaseLevel() {
        super.increaseLevel();
        setRatio(level);
    }
    
    private void setRatio(int level) {
        switch (level) {
            case 1:
                player.setOneCountryBonus(1.4);
                return;
            case 2:
                player.setOneCountryBonus(2);
                return;
            case 3:
                player.setOneCountryBonus(3);
                return;
            case 4:
                player.setOneCountryBonus(5);
                return;
            case 5:
                player.setOneCountryBonus(7);
                return;
            case 6:
                player.setOneCountryBonus(10);
                return;
            case 7:
                player.setOneCountryBonus(15);
                return;
            case 8:
                player.setOneCountryBonus(30);
                return;
            case 9:
                player.setOneCountryBonus(100);
                return;
        }
    }
}