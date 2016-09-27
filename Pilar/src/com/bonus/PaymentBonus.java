package com.bonus;

import com.Game;

public class PaymentBonus extends Bonus {
    @Override
    public void increaseLevel() {
        super.increaseLevel();
        setRatio(level);
    }

    @Override
    protected void nullStates() {
        player.setPaymentRatio(Game.DEFAULT_PAYMENT_RATIO);
    }

    private void setRatio(int level) {
        switch (level) {
            case 1:
                player.setPaymentRatio(0.8);
                return;
            case 2:
                player.setPaymentRatio(0.7);
                return;
            case 3:
                player.setPaymentRatio(0.6);
                return;
            case 4:
                player.setPaymentRatio(0.5);
                return;
            case 5:
                player.setPaymentRatio(0.3);
                return;
            case 6:
                player.setPaymentRatio(0.2);
                return;
            case 7:
                player.setPaymentRatio(0.1);
                return;
            case 8:
                player.setPaymentRatio(0.05);
                return;
            case 9:
                player.setPaymentRatio(0.01);
                return;
        }
    }
}