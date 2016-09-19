package com.bonus;

public class MoneyBonus extends Bonus {
    @Override
    public void increaseLevel() {
        super.increaseLevel();
        setStats(level);
    }

    private void setStats(int level) {
        switch (level) {
            case 1:
                player.setSalary(30000);
                player.setTax(-60000);
                player.setForwardBonus(30000);
                return;
            case 2:
                player.setSalary(60000);
                player.setTax(-180000);
                player.setForwardBonus(120000);
                return;
            case 3:
                player.setSalary(180000);
                player.setTax(-720000);
                player.setForwardBonus(540000);
                return;
            case 4:
                player.setSalary(300000);
                player.setTax(-1500000);
                player.setForwardBonus(1200000);
                return;
            case 5:
                player.setSalary(1000000);
                player.setTax(-6000000);
                player.setForwardBonus(5000000);
                return;
            case 6:
                player.setSalary(2000000);
                player.setTax(-16000000);
                player.setForwardBonus(14000000);
                return;
            case 7:
                player.setSalary(7000000);
                player.setTax(-105000000);
                player.setForwardBonus(98000000);
                return;
            case 8:
                player.setSalary(15000000);
                player.setTax(-450000000);
                player.setForwardBonus(435000000);
                return;
            case 9:
                player.setSalary(50000000);
                player.setTax(-5000000000L);
                player.setForwardBonus(4950000000L);
                return;
        }
    }
}