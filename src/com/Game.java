package com;

import com.field.*;

import java.util.*;

public class Game {
    public static final int DEFAULT_NEGATIVE_CITY_INCREASE = -1;
    public static final int DEFAULT_POSITIVE_CITY_INCREASE = 1;
    public static final double DEFAULT_FIRST_CITY_PRICE_RATIO = 1;
    public static final double DEFAULT_SECOND_CITY_PRICE_RATIO = 1;
    public static final double DEFAULT_THIRD_CITY_PRICE_RATIO = 1;
    public static final double DEFAULT_PAYMENT_RATIO = 1;
    public static final int DEFAULT_CITIES_PER_TURN_AVAILABLE = 1;
    public static final int DEFAULT_AVAILABLE_THROWS = 1;
    public static final long DEFAULT_SALARY = 5000;
    public static final long DEFAULT_FORWARD_BONUS = 5000;
    public static final long DEFAULT_TAX = 5000;
    public static final int DEFAULT_CITIES_FOR_WONDER_1 = 3;
    public static final int DEFAULT_CITIES_FOR_WONDER_2 = 0;
    public static final int DEFAULT_CITIES_FOR_WONDER_3 = 0;
    public static final int DEFAULT_CITIES_FOR_WONDER_4 = 0;
    public static final double DEFAULT_NEGATIVE_PERCENT = 0.9;
    public static final double DEFAULT_POSITIVE_PERCENT = 1.1;
    public static final double DEFAULT_ULTRA_PERCENT = 2;
    public static final int DEFAULT_PERCENT_MOVES = 3;
    public static final int DEFAULT_ULTRA_PERCENT_MOVES = 1;
    public static final double DEFAULT_ONE_COUNTRY_BONUS_RATIO = 1;
    public static final Map<Integer, Long> BONUS_PRICES = new HashMap<>();
    private List<Field> gameField = new ArrayList<>();
    private List<Player> players = new ArrayList<>();

    static {
        BONUS_PRICES.put(1, 100000L);
        BONUS_PRICES.put(2, 300000L);
        BONUS_PRICES.put(3, 750000L);
        BONUS_PRICES.put(4, 1500000L);
        BONUS_PRICES.put(5, 3000000L);
        BONUS_PRICES.put(6, 7000000L);
        BONUS_PRICES.put(7, 20000000L);
        BONUS_PRICES.put(8, 50000000L);
        BONUS_PRICES.put(9, 100000000L);
    }

    {
        gameField.add(new MoneyField(MoneyFieldType.FORWARD));
        gameField.add(new CountryField(CountryFieldType.FRANCE));
        gameField.add(new CountryField(CountryFieldType.SPAIN));
        gameField.add(new CountryField(CountryFieldType.ITALY));
        gameField.add(new MoneyField(MoneyFieldType.TAX));
        gameField.add(new CountryField(CountryFieldType.LUXEMBOURG));
        gameField.add(new CountryField(CountryFieldType.USA));
        gameField.add(new CountryField(CountryFieldType.CANADA));
        gameField.add(new CityField(CityFieldType.POSITIVE_CITY_BONUS));
        gameField.add(new CityField(CityFieldType.NEGATIVE_CITY_BONUS));
        gameField.add(new CountryField(CountryFieldType.AUSTRALIA));
        gameField.add(new CountryField(CountryFieldType.INDIA));
        gameField.add(new CountryField(CountryFieldType.CHINA));
        gameField.add(new PortField(PortFieldType.EVEN_PORT));
        gameField.add(new CountryField(CountryFieldType.JAPAN));
        gameField.add(new CountryField(CountryFieldType.VATICAN));
        gameField.add(new CountryField(CountryFieldType.BRAZIL));
        gameField.add(new CountryField(CountryFieldType.ARGENTINA));
        gameField.add(new CountryField(CountryFieldType.COLUMBIA));
        gameField.add(new CountryField(CountryFieldType.VENEZUELA));
        gameField.add(new CountryField(CountryFieldType.NEW_ZEALAND));
        gameField.add(new CountryField(CountryFieldType.GERMANY));
        gameField.add(new PortField(PortFieldType.ODD_PORT));
        gameField.add(new CountryField(CountryFieldType.AUSTRIA));
        gameField.add(new CountryField(CountryFieldType.GREAT_BRITAIN));
        gameField.add(new CountryField(CountryFieldType.SINGAPORE));
        gameField.add(new CountryField(CountryFieldType.NETHERLANDS));
        gameField.add(new CountryField(CountryFieldType.DENMARK));
        gameField.add(new PercentField(PercentFieldType.POSITIVE_PERCENT_FIELD));
        gameField.add(new CountryField(CountryFieldType.BELGIUM));
        gameField.add(new CountryField(CountryFieldType.SOUTH_AFRICA));
        gameField.add(new CountryField(CountryFieldType.NORWAY));
        gameField.add(new CountryField(CountryFieldType.SWEDEN));
        gameField.add(new CountryField(CountryFieldType.FINLAND));
        gameField.add(new PercentField(PercentFieldType.NEGATIVE_PERCENT_FIELD));
        gameField.add(new CountryField(CountryFieldType.MONACO));
        gameField.add(new CountryField(CountryFieldType.UAE));
        gameField.add(new CountryField(CountryFieldType.KUWAIT));
        gameField.add(new CountryField(CountryFieldType.QATAR));
        gameField.add(new PercentField(PercentFieldType.ULTRA_PERCENT_FIELD));
    }
    
    public void addPlayer(Player player) {
        players.add(player);
    }

    public void addPlayers(Player... player) {
        Collections.addAll(players, player);
    }

    public void addPlayers(Collection<Player> players) {
        this.players.addAll(players);
    }

    public void game() {
        while (players.size() != 1) {
            for (int i = 0; i < players.size(); i++) {
                playerTurn(players.get(i));
            }
        }
    }

    public void playerTurn(Player player) {
        while (player.getCurrentAvailableThrows() != 0) {
            int[] dice = throwDice();
            if (!isDouble(dice)) {
                player.decreaseCurrentAvailableThrows();
            }
            move(player, dice, true);
            playerEnterField(player);
        }
    }

    public void playerEnterField(Player player) {
        player.getCurrentField().setCurrentPlayer(player);
        if (player.getCurrentField() instanceof CityField) {
            player.getCountries().stream().filter(CountryField::isUnionCompleted).forEach(i -> {
                if (player.getCurrentField().getType().equals(CityFieldType.NEGATIVE_CITY_BONUS)) {
                    i.buildCities(player.getNegativeCityIncrease());
                } else {
                    i.buildCities(player.getPositiveCityIncrease());
                }
            });
        } else if (player.getCurrentField() instanceof MoneyField) {
            if (player.getCurrentField().getType().equals(MoneyFieldType.FORWARD)) {
                player.earn(player.getForwardBonus());
            } else {
                player.pay(player.getTax());
            }
        } else if (player.getCurrentField() instanceof PortField) {
            int[] dice = throwDice();
            int sum = dice[0] + dice[1];
            if (player.getCurrentField().getType().equals(PortFieldType.EVEN_PORT)) {
                if (sum % 2 == 0) {
                    move(player, dice, true);
                } else {
                    move(player, dice, false);
                }
            } else {
                if (sum % 2 == 0) {
                    move(player, dice, false);
                } else {
                    move(player, dice, true);
                }
            }
        } else if (player.getCurrentField() instanceof PercentField) {
            if (player.getCurrentField().getType().equals(PercentFieldType.NEGATIVE_PERCENT_FIELD)) {
                player.addNegativePercentMovesLeft(player.getPercentMoves());
            } else if (player.getCurrentField().getType().equals(PercentFieldType.POSITIVE_PERCENT_FIELD)) {
                player.addPositivePercentMovesLeft(player.getPercentMoves());
            } else {
                player.addUltraPercentMovesLeft(player.getUltraPercentMoves());
            }
        } else {
            CountryField countryField = (CountryField) player.getCurrentField();
            if (player.getCountries().contains(countryField)) {
                return;
            } else if (countryField.getPlayer() == null) {
                player.buyCountryField(countryField);
                //TODO
            } else {
                Player owner = countryField.getPlayer();
                int negMoves = owner.getNegativePercentMovesLeft();
                int posMoves = owner.getPositivePercentMovesLeft();
                int ultraMoves = owner.getUltraPercentMovesLeft();
                double neg = 1;
                double pos = 1;
                double ultra = 1;
                if (negMoves != 0) {
                    neg = owner.getNegativePercent();
                }
                if (posMoves != 0) {
                    pos = owner.getPositivePercent();
                }
                if (ultraMoves != 0) {
                    ultra = owner.getUltraPercent();
                }
                long payment = (long) (neg * pos * ultra * owner.getPaymentRatio() * countryField.getCityAmount() *
                        countryField.getVisitCostPerCity() * (1 + countryField.getWonderAmount() / 10.0));
                player.pay(payment, owner);
                //TODO
            }
        }
    }

    public void move(Player player, int[] dice, boolean isForward) {
        int playerCurrentField = gameField.indexOf(player.getCurrentField());
        int nextPlayerField = 0;
        if (isForward) {
            nextPlayerField = playerCurrentField + dice[0] + dice[1];
        } else {
            nextPlayerField = playerCurrentField - dice[0] - dice[1];
        }
        if (nextPlayerField >= gameField.size()) {
            player.earn(player.getSalary());
            nextPlayerField = nextPlayerField % gameField.size();
        } else if (nextPlayerField < 0) {
            nextPlayerField = gameField.size() + nextPlayerField;
        }
        player.setCurrentField(gameField.get(nextPlayerField));
        playerEnterField(player);
    }

    public int[] throwDice() {
        Random random = new Random();
        int a = random.nextInt(6) + 1;
        int b = random.nextInt(6) + 1;
        return new int[]{a, b};
    }

    public List<Field> getGameField() {
        return gameField;
    }
    
    private boolean isDouble(int[] dice) {
        return dice[0] == dice[1];
    }
    
    private boolean hasAvailableMoves(Player player) {
        return player.getCurrentAvailableThrows() != 0;
    }
}