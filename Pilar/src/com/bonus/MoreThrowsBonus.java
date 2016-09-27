package com.bonus;

import com.Game;

public class MoreThrowsBonus extends Bonus {
    @Override
    public void increaseLevel() {
        super.increaseLevel();
        setThrowsAmount(level);
    }

    @Override
    protected void nullStates() {
        player.setAvailableThrows(Game.DEFAULT_AVAILABLE_THROWS);
    }

    private void setThrowsAmount(int level) {
        switch (level) {
            case 1:
                player.setAvailableThrows(3);
                return;
            case 2:
                player.setAvailableThrows(4);
                return;
            case 3:
                player.setAvailableThrows(5);
                return;
            case 4:
                player.setAvailableThrows(6);
                return;
            case 5:
                player.setAvailableThrows(8);
                return;
            case 6:
                player.setAvailableThrows(10);
                return;
            case 7:
                player.setAvailableThrows(15);
                return;
            case 8:
                player.setAvailableThrows(25);
                return;
            case 9:
                player.setAvailableThrows(50);
                return;
        }
    }
}