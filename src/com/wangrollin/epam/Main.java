package com.wangrollin.epam;

public class Main {

    public static void main(String[] args) {
        new BiggerThan50Game<PlayingCardDeck.CardType>(3, new PlayingCardDeck()).startGame();
    }
}
