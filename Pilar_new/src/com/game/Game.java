package com.game;

import com.field.CountryField;
import com.field.Field;
import com.field.NonCountryField;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game {
    private List<Player> players = new ArrayList<>();
    private List<Field> gameBoard = new ArrayList<>();
    private Player currentPlayer;
    private int[] dices = new int[2];

    public void enterField() {
        Field field = currentPlayer.getCurrentField();
        if (field instanceof CountryField) {

        } else if (field instanceof NonCountryField) {
            if (field.equals(NonCountryField.INCEPTION)) {
                currentPlayer.getBonusMoney();
            } else if (field.equals(NonCountryField.TAX)) {
                currentPlayer.payTax();
            } else if (field.equals(NonCountryField.DISASTER)) {

            } else if (field.equals(NonCountryField.FREE_CITY)) {

            } else if (field.equals(NonCountryField.EVEN_PORT)) {
                throwDice();
                if (sum() % 2 == 0) {
                    move(true);
                } else {
                    move(false);
                }
            } else if (field.equals(NonCountryField.ODD_PORT)) {
                throwDice();
                if (sum() % 2 != 0) {
                    move(true);
                } else {
                    move(false);
                }
            } else if (field.equals(NonCountryField.PROFIT_UP)) {
                currentPlayer.profitUpUpdate();
            } else if (field.equals(NonCountryField.PROFIT_DOWN)) {
                currentPlayer.profitDownUpdate();
            } else if (field.equals(NonCountryField.ULTRA_PROFIT)) {
                currentPlayer.ultraProfitUpdate();
            }
        }
    }

    public boolean makeMove() {
        throwDice();
        move(true);
        return currentPlayer.reduceAvailableThrows();
    }

    public void move(boolean isForward) {
        int currPos = gameBoard.indexOf(currentPlayer.getCurrentField());
        gameBoard.get(currPos).removeCurrentPlayer(currentPlayer);
        int steps = isForward ? sum() : -sum();
        int newPos = currPos + sum();
        if (newPos >= gameBoard.size()) {
            newPos = newPos - gameBoard.size();
            currentPlayer.getAWage();
        }
        gameBoard.get(newPos).setCurrentPlayer(currentPlayer);
        currentPlayer.setCurrentField(gameBoard.get(newPos));
        enterField();
    }

    public void throwDice() {
        Random random = new Random();
        int a = random.nextInt(6) + 1;
        int b = random.nextInt(6) + 1;
        dices[0] = a;
        dices[1] = b;
    }

    public boolean isDouble() {
        return dices[0] == dices[1];
    }

    public int sum() {
        return dices[0] + dices[1];
    }

    public void nextPlayer() {
        if (currentPlayer == null) {
            currentPlayer = players.get(0);
        } else {
            int pos = players.indexOf(currentPlayer);
            pos++;
            if (pos >= players.size()) {
                pos = pos - players.size();
            }
            currentPlayer = players.get(pos);
        }
    }

    public boolean transaction(Player debtor, Player creditor, long amount) {
        if (debtor.changeMoneyAmount(-amount)) {
            creditor.changeMoneyAmount(amount);
            return true;
        } else {
            return false;
        }
    }
}
