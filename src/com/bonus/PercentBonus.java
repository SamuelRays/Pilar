package com.bonus;

public class PercentBonus extends Bonus {
    @Override
    public void increaseLevel() {
        super.increaseLevel();
        setPercents(level);
    }

    private void setPercents(int level) {
        switch (level) {
            case 1:
                player.setNegativePercent(1.5);
                player.setPositivePercent(1.5);
                player.setUltraPercent(3);
                player.setPercentMoves(5);
                return;
            case 2:
                player.setNegativePercent(2);
                player.setPositivePercent(2);
                player.setUltraPercent(4);
                player.setPercentMoves(6);
                return;
            case 3:
                player.setNegativePercent(2.5);
                player.setPositivePercent(2.5);
                player.setUltraPercent(5);
                player.setPercentMoves(7);
                return;
            case 4:
                player.setNegativePercent(3);
                player.setPositivePercent(3);
                player.setUltraPercent(6);
                player.setPercentMoves(8);
                return;
            case 5:
                player.setNegativePercent(5);
                player.setPositivePercent(5);
                player.setUltraPercent(8);
                player.setPercentMoves(10);
                return;
            case 6:
                player.setNegativePercent(7);
                player.setPositivePercent(7);
                player.setUltraPercent(12);
                player.setPercentMoves(12);
                return;
            case 7:
                player.setNegativePercent(10);
                player.setPositivePercent(10);
                player.setUltraPercent(20);
                player.setPercentMoves(15);
                return;
            case 8:
                player.setNegativePercent(25);
                player.setPositivePercent(25);
                player.setUltraPercent(50);
                player.setPercentMoves(20);
                return;
            case 9:
                player.setNegativePercent(50);
                player.setPositivePercent(50);
                player.setUltraPercent(100);
                player.setPercentMoves(30);
                return;
        }
    }
}