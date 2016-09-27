package com.bonus;

import com.Game;

public class MoveChanceBonus extends Bonus {
    @Override
    public void increaseLevel() {
        super.increaseLevel();
        setMoveChances();
    }

    @Override
    protected void nullStates() {
        player.setEvenMoveChances(Game.DEFAULT_EVEN_MOVE_CHANCES);
        player.setMoveChances(Game.DEFAULT_MOVE_CHANCES);
    }
    
    private void setMoveChances() {
        switch (level) {
            case 1:
                player.setEvenMoveChances(1);
                player.setMoveChances(0);
                return;
            case 2:
                player.setEvenMoveChances(0);
                player.setMoveChances(1);
                return;
            case 3:
                player.setEvenMoveChances(1);
                player.setMoveChances(1);
                return;
            case 4:
                player.setEvenMoveChances(0);
                player.setMoveChances(2);
                return;
            case 5:
                player.setEvenMoveChances(1);
                player.setMoveChances(2);
                return;
            case 6:
                player.setEvenMoveChances(0);
                player.setMoveChances(3);
                return;
            case 7:
                player.setEvenMoveChances(0);
                player.setMoveChances(4);
                return;
            case 8:
                player.setEvenMoveChances(0);
                player.setMoveChances(5);
                return;
            case 9:
                player.setEvenMoveChances(0);
                player.setMoveChances(7);
                return;
        }
    }
}