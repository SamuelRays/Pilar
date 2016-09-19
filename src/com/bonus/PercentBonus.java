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
                player.setMinPercent(1.5);
                player.setMaxPercent(1.5);
                player.setUltraPercent(3);
                player.setPercentMoves(5);
                return;
            case 2:
                player.setMinPercent(2);
                player.setMaxPercent(2);
                player.setUltraPercent(4);
                player.setPercentMoves(6);
                return;
            case 3:
                player.setMinPercent(2.5);
                player.setMaxPercent(2.5);
                player.setUltraPercent(5);
                player.setPercentMoves(7);
                return;
            case 4:
                player.setMinPercent(3);
                player.setMaxPercent(3);
                player.setUltraPercent(6);
                player.setPercentMoves(8);
                return;
            case 5:
                player.setMinPercent(5);
                player.setMaxPercent(5);
                player.setUltraPercent(8);
                player.setPercentMoves(10);
                return;
            case 6:
                player.setMinPercent(7);
                player.setMaxPercent(7);
                player.setUltraPercent(12);
                player.setPercentMoves(12);
                return;
            case 7:
                player.setMinPercent(10);
                player.setMaxPercent(10);
                player.setUltraPercent(20);
                player.setPercentMoves(15);
                return;
            case 8:
                player.setMinPercent(25);
                player.setMaxPercent(25);
                player.setUltraPercent(50);
                player.setPercentMoves(20);
                return;
            case 9:
                player.setMinPercent(50);
                player.setMaxPercent(50);
                player.setUltraPercent(100);
                player.setPercentMoves(30);
                return;
        }
    }
}