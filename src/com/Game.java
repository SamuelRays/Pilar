package com;

import com.field.*;

import java.util.*;

public class Game {
    public static final long START_MONEY_AMOUNT = 750000;
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
    public static final int DEFAULT_EVEN_MOVE_CHANCES = 0;
    public static final int DEFAULT_MOVE_CHANCES = 0;
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
        gameField.add(FieldFactory.getField(MoneyFieldType.FORWARD));
        gameField.add(FieldFactory.getField(CountryFieldType.FRANCE));
        gameField.add(FieldFactory.getField(CountryFieldType.SPAIN));
        gameField.add(FieldFactory.getField(CountryFieldType.ITALY));
        gameField.add(FieldFactory.getField(MoneyFieldType.TAX));
        gameField.add(FieldFactory.getField(CountryFieldType.LUXEMBOURG));
        gameField.add(FieldFactory.getField(CountryFieldType.USA));
        gameField.add(FieldFactory.getField(CountryFieldType.CANADA));
        gameField.add(FieldFactory.getField(CityFieldType.POSITIVE_CITY_BONUS));
        gameField.add(FieldFactory.getField(CityFieldType.NEGATIVE_CITY_BONUS));
        gameField.add(FieldFactory.getField(CountryFieldType.AUSTRALIA));
        gameField.add(FieldFactory.getField(CountryFieldType.INDIA));
        gameField.add(FieldFactory.getField(CountryFieldType.CHINA));
        gameField.add(FieldFactory.getField(PortFieldType.EVEN_PORT));
        gameField.add(FieldFactory.getField(CountryFieldType.JAPAN));
        gameField.add(FieldFactory.getField(CountryFieldType.VATICAN));
        gameField.add(FieldFactory.getField(CountryFieldType.BRAZIL));
        gameField.add(FieldFactory.getField(CountryFieldType.ARGENTINA));
        gameField.add(FieldFactory.getField(CountryFieldType.COLUMBIA));
        gameField.add(FieldFactory.getField(CountryFieldType.VENEZUELA));
        gameField.add(FieldFactory.getField(CountryFieldType.NEW_ZEALAND));
        gameField.add(FieldFactory.getField(CountryFieldType.GERMANY));
        gameField.add(FieldFactory.getField(PortFieldType.ODD_PORT));
        gameField.add(FieldFactory.getField(CountryFieldType.AUSTRIA));
        gameField.add(FieldFactory.getField(CountryFieldType.GREAT_BRITAIN));
        gameField.add(FieldFactory.getField(CountryFieldType.SINGAPORE));
        gameField.add(FieldFactory.getField(CountryFieldType.NETHERLANDS));
        gameField.add(FieldFactory.getField(CountryFieldType.DENMARK));
        gameField.add(FieldFactory.getField(PercentFieldType.POSITIVE_PERCENT_FIELD));
        gameField.add(FieldFactory.getField(CountryFieldType.BELGIUM));
        gameField.add(FieldFactory.getField(CountryFieldType.SOUTH_AFRICA));
        gameField.add(FieldFactory.getField(CountryFieldType.NORWAY));
        gameField.add(FieldFactory.getField(CountryFieldType.SWEDEN));
        gameField.add(FieldFactory.getField(CountryFieldType.FINLAND));
        gameField.add(FieldFactory.getField(PercentFieldType.NEGATIVE_PERCENT_FIELD));
        gameField.add(FieldFactory.getField(CountryFieldType.MONACO));
        gameField.add(FieldFactory.getField(CountryFieldType.UAE));
        gameField.add(FieldFactory.getField(CountryFieldType.KUWAIT));
        gameField.add(FieldFactory.getField(CountryFieldType.QATAR));
        gameField.add(FieldFactory.getField(PercentFieldType.ULTRA_PERCENT_FIELD));
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.gameField.forEach(p -> System.out.println(p.getName()));
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
                if (players.get(i).isLost()) {
                    players.remove(i--);
                }
            }
        }
    }

    public void playerTurn(Player player) {
        player.decreaseNegativePercentMovesLeft();
        player.decreasePositivePercentMovesLeft();
        player.decreaseUltraPercentMovesLeft();
        while (hasAvailableMoves(player)) {
            int[] dice = throwDice();
            if (!isDouble(dice)) {
                player.decreaseCurrentAvailableThrows();
            }
            int fieldsToMove = dice[0] + dice[1];
            move(player, fieldsToMove, true);
            playerEnterField(player);
        }
    }

    public void playerEnterField(Player player) {
        player.getCurrentField().setCurrentPlayer(player);
        if (player.getCurrentField() instanceof CityField) {
            player.getUnions().stream().filter(Union::isFull).forEach(i -> {
                if (player.getCurrentField().getType().equals(CityFieldType.NEGATIVE_CITY_BONUS)) {
                    i.buildOrDestroyCitiesInEachCountry(player.getNegativeCityIncrease());
                } else {
                    i.buildOrDestroyCitiesInEachCountry(player.getPositiveCityIncrease());
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
                    move(player, sum, true);
                } else {
                    move(player, sum, false);
                }
            } else {
                if (sum % 2 == 0) {
                    move(player, sum, false);
                } else {
                    move(player, sum, true);
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
            } else if (countryField.getOwner() == null) {
                player.buyCountryField(countryField);
                //TODO
            } else {
                Player owner = countryField.getOwner();
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
                long payment = (long) (countryField.getOneCountryBonusRatio() * neg * pos *
                        ultra * player.getPaymentRatio() * countryField.getCityAmount() *
                        countryField.getVisitCostPerCity() * (1 + countryField.getWonderAmount() / 10.0));
                player.pay(payment, owner);
                //TODO
                if (owner.getMoveChancesLeft() != 0) {
                    owner.decreaseMoveChancesLeft();
                    move(player, playerNextField(owner, gameField.indexOf(countryField)), true);
                } else if (owner.getEvenMoveChancesLeft() != 0) {
                    owner.decreaseEvenMoveChancesLeft();
                    int[] dice = throwDice();
                    if ((dice[0] + dice[1]) % 2 == 0) {
                        move(player, playerNextField(owner, gameField.indexOf(countryField)), true);
                    } else {
                        owner.resetEvenMoveChancesLeft();
                        owner.resetMoveChancesLeft();
                    }
                } else {
                    owner.resetEvenMoveChancesLeft();
                    owner.resetMoveChancesLeft();
                }
            }
        }
    }

    public void move(Player player, int fieldsToMove, boolean isForward) {
        int playerCurrentField = gameField.indexOf(player.getCurrentField());
        int nextPlayerField = 0;
        if (isForward) {
            nextPlayerField = playerCurrentField + fieldsToMove;
        } else {
            nextPlayerField = playerCurrentField - fieldsToMove;
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

    private int playerNextField(Player player, int currentPos) {
        for (int i = currentPos + 1; i < gameField.size(); i++) {
            Field field = gameField.get(i);
            if (field instanceof CountryField) {
                CountryField countryField = (CountryField) field;
                if (countryField.getOwner().equals(player)) {
                    return i - currentPos;
                }
            }
        }
        for (int i = 0; i < currentPos; i++) {
            Field field = gameField.get(i);
            if (field instanceof CountryField) {
                CountryField countryField = (CountryField) field;
                if (countryField.getOwner().equals(player)) {
                    return i + gameField.size() - currentPos;
                }
            }
        }
        return 0;
    }
}