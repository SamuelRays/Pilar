package com.bonus;

public class WonderBonus extends Bonus {
    @Override
    public void increaseLevel() {
        super.increaseLevel();
        setCitiesAmountNeeded(level);
    }

    private void setCitiesAmountNeeded(int level) {
        switch (level) {
            case 1:
                player.setCitiesForWonder2(6);
                player.setCitiesForWonder3(0);
                player.setCitiesForWonder4(0);
                return;
            case 2:
                player.setCitiesForWonder2(5);
                player.setCitiesForWonder3(0);
                player.setCitiesForWonder4(0);
                return;
            case 3:
                player.setCitiesForWonder2(4);
                player.setCitiesForWonder3(0);
                player.setCitiesForWonder4(0);
                return;
            case 4:
                player.setCitiesForWonder2(3);
                player.setCitiesForWonder3(0);
                player.setCitiesForWonder4(0);
                return;
            case 5:
                player.setCitiesForWonder2(2);
                player.setCitiesForWonder3(0);
                player.setCitiesForWonder4(0);
                return;
            case 6:
                player.setCitiesForWonder2(1);
                player.setCitiesForWonder3(0);
                player.setCitiesForWonder4(0);
                return;
            case 7:
                player.setCitiesForWonder2(1);
                player.setCitiesForWonder3(3);
                player.setCitiesForWonder4(0);
                return;
            case 8:
                player.setCitiesForWonder2(1);
                player.setCitiesForWonder3(1);
                player.setCitiesForWonder4(0);
                return;
            case 9:
                player.setCitiesForWonder2(1);
                player.setCitiesForWonder3(1);
                player.setCitiesForWonder4(1);
                return;
        }
    }
}