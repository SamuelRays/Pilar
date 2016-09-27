package com.bonus;

public class BonusFactory {
    public static Bonus getBonus(Class clazz) {
        if (clazz.equals(CityBonus.class)) {
            return new CityBonus();
        }
        if (clazz.equals(FastBuildBonus.class)) {
            return new FastBuildBonus();
        }
        if (clazz.equals(FreeCityBonus.class)) {
            return new FreeCityBonus();
        }
        if (clazz.equals(MoneyBonus.class)) {
            return new MoneyBonus();
        }
        if (clazz.equals(MoreThrowsBonus.class)) {
            return new MoreThrowsBonus();
        }
        if (clazz.equals(MoveChanceBonus.class)) {
            return new MoveChanceBonus();
        }
        if (clazz.equals(OneCountryBonus.class)) {
            return new OneCountryBonus();
        }
        if (clazz.equals(PaymentBonus.class)) {
            return new PaymentBonus();
        }
        if (clazz.equals(PercentBonus.class)) {
            return new PercentBonus();
        }
        if (clazz.equals(WonderBonus.class)) {
            return new WonderBonus();
        }
        throw new IllegalArgumentException();
    }
}
