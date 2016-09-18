package com.bonus;

public class MoneyBonus extends Bonus {
    private long salary = 5000;
    private long tax = -5000;
    private long bonus = 5000;

    @Override
    public void increaseLevel() {
        super.increaseLevel();
        setStats(level);
    }

    public long getSalary() {
        return salary;
    }

    public long getTax() {
        return tax;
    }

    public long getBonus() {
        return bonus;
    }

    private void setStats(int level) {
        switch (level) {
            case 1:
                salary = 30000;
                tax = 60000;
                bonus = 30000;
                return;
            case 2:
                salary = 60000;
                tax = 180000;
                bonus = 120000;
                return;
            case 3:
                salary = 180000;
                tax = 720000;
                bonus = 540000;
                return;
            case 4:
                salary = 300000;
                tax = 1500000;
                bonus = 1200000;
                return;
            case 5:
                salary = 1000000;
                tax = 6000000;
                bonus = 5000000;
                return;
            case 6:
                salary = 2000000;
                tax = 16000000;
                bonus = 14000000;
                return;
            case 7:
                salary = 7000000;
                tax = 105000000;
                bonus = 98000000;
                return;
            case 8:
                salary = 15000000;
                tax = 450000000;
                bonus = 435000000;
                return;
            case 9:
                salary = 50000000;
                tax = 5000000000L;
                bonus = 4950000000L;
                return;
        }
    }
}