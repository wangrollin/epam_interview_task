package com.wangrollin.epam;

import java.util.ArrayList;
import java.util.List;

public class BiggerThan50Game<T> {

    private static final int WINNER_POINT = 50;
    private int playerNumber;
    private BasicCardDeck<T> cardDeck;

    private List<Boolean> threadTaskFinished;
    private List<GetCard> taskList;
    private List<Thread> threadList;

    public BiggerThan50Game(int playerNumberParam, BasicCardDeck cardDeckParam) {
        playerNumber = playerNumberParam;
        cardDeck = cardDeckParam;
    }

    public void startGame() {
        threadTaskFinished = new ArrayList<>();
        threadList = new ArrayList<>();
        cardDeck.shuffle();

        taskList = new ArrayList<>();
        for (int i = 0; i < playerNumber; i++) {
            taskList.add(new GetCard(i));
            threadList.add(new Thread(taskList.get(i)));
            threadTaskFinished.add(false);
            threadList.get(i).run();
        }

        while (!isAllTaskFinished()) {
        }

        printOneRoundResult();
    }

    private boolean isAllTaskFinished() {
        for (int i = 0; i < playerNumber; i++) {
            if (!threadTaskFinished.get(i)) {
                return false;
            }
        }
        return true;
    }

    private void printOneRoundResult() {
        for (int k = 0; k < 18; k++) {
            StringBuilder result = new StringBuilder();
            result.append("Round").append(k + 1).append(" = Sender[");
            for (int i = 0; i < playerNumber; i++) {

                result.append("\"").append(taskList.get(i).cardTypeListOfOnePlayer.get(k).toString()).append("\"");
                if (i != playerNumber - 1) {
                    result.append(",");
                }
            }
            result.append("]->");

            boolean gameRunning = true;
            int winner = 0;
            for (int i = 0; i < playerNumber; i++) {
                result.append("Player").append(i + 1).append("=").append(taskList.get(i).pointsListOfOnePlayer.get(k));
                if (taskList.get(i).pointsListOfOnePlayer.get(k) > WINNER_POINT && gameRunning) {
                    gameRunning = false;
                    winner = i;
                }
                if (i != playerNumber - 1) {
                    result.append(",");
                }
            }

            if (gameRunning) {
                result.append(";");
                System.out.println(result.toString());
            } else {
                result.append("->player ").append(winner + 1).append(" win;");
                System.out.println(result.toString());
                break;
            }

        }

    }

    private class GetCard implements Runnable {

        private int playerNo;

        private List<Integer> pointsListOfOnePlayer;
        private List<T> cardTypeListOfOnePlayer;

        GetCard(int num) {
            playerNo = num;
            pointsListOfOnePlayer = new ArrayList<>();
            cardTypeListOfOnePlayer = new ArrayList<>();
        }

        @Override
        public void run() {
            for (int cardIndex = playerNo, curRound = 0; cardIndex < PlayingCardDeck.CARD_NUMBER; cardIndex += playerNumber, curRound++) {
                T card = cardDeck.getCardByIndex(cardIndex);
                cardTypeListOfOnePlayer.add(card);
                if (pointsListOfOnePlayer.isEmpty()) {
                    pointsListOfOnePlayer.add(cardDeck.getValueOfCard(card));
                } else {
                    pointsListOfOnePlayer.add(pointsListOfOnePlayer.get(curRound - 1) + cardDeck.getValueOfCard(card));
                }
                if (pointsListOfOnePlayer.get(curRound) > WINNER_POINT) {
                    break;
                }
            }
            threadTaskFinished.set(playerNo, true);
        }
    }
}
