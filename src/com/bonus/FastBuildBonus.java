package com.bonus;

public class FastBuildBonus extends Bonus {
    @Override
    public void increaseLevel() {
        super.increaseLevel();
        setQuantity(level);
    }

    private void setQuantity(int level) {
        switch (level) {
            case 1:
                player.setCitiesPerTurnAvailable(2);
                return;
            case 2:
                player.setCitiesPerTurnAvailable(3);
                return;
            case 3:
                player.setCitiesPerTurnAvailable(4);
                return;
            case 4:
                player.setCitiesPerTurnAvailable(6);
                return;
            case 5:
                player.setCitiesPerTurnAvailable(10);
                return;
            case 6:
                player.setCitiesPerTurnAvailable(15);
                return;
            case 7:
                player.setCitiesPerTurnAvailable(30);
                return;
            case 8:
                player.setCitiesPerTurnAvailable(60);
                return;
            case 9:
                player.setCitiesPerTurnAvailable(200);
                return;
        }
    }
}