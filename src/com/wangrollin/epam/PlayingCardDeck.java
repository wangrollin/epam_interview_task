package com.wangrollin.epam;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

public class PlayingCardDeck implements BasicCardDeck<PlayingCardDeck.CardType> {

    public static final int CARD_NUMBER = 54;

    private List<PlayingCardDeck.CardType> cardsList;

    public PlayingCardDeck() {
        putCardInOrder();
    }

    @Override
    public void shuffle() {
        putCardInOrder();

        SecureRandom random = new SecureRandom();
        // 保证任何排序都可以洗到
        for (int depth = 0; depth < 10; depth++) {
            for (int i = 0; i < CARD_NUMBER - 1; i++) {
                for (int j = i + 1; j < CARD_NUMBER; j++) {
                    if (random.nextInt() % 2 == 0) {
                        CardType tmp = cardsList.get(i);
                        cardsList.set(i, cardsList.get(j));
                        cardsList.set(j, tmp);
                    }
                }
            }
        }
    }

    @Override
    public void putCardInOrder() {
        cardsList = new ArrayList<>();

        cardsList.add(CardType.CARD_A);
        cardsList.add(CardType.CARD_A);
        cardsList.add(CardType.CARD_A);
        cardsList.add(CardType.CARD_A);

        cardsList.add(CardType.CARD_2);
        cardsList.add(CardType.CARD_2);
        cardsList.add(CardType.CARD_2);
        cardsList.add(CardType.CARD_2);

        cardsList.add(CardType.CARD_3);
        cardsList.add(CardType.CARD_3);
        cardsList.add(CardType.CARD_3);
        cardsList.add(CardType.CARD_3);

        cardsList.add(CardType.CARD_4);
        cardsList.add(CardType.CARD_4);
        cardsList.add(CardType.CARD_4);
        cardsList.add(CardType.CARD_4);

        cardsList.add(CardType.CARD_5);
        cardsList.add(CardType.CARD_5);
        cardsList.add(CardType.CARD_5);
        cardsList.add(CardType.CARD_5);

        cardsList.add(CardType.CARD_6);
        cardsList.add(CardType.CARD_6);
        cardsList.add(CardType.CARD_6);
        cardsList.add(CardType.CARD_6);

        cardsList.add(CardType.CARD_7);
        cardsList.add(CardType.CARD_7);
        cardsList.add(CardType.CARD_7);
        cardsList.add(CardType.CARD_7);

        cardsList.add(CardType.CARD_8);
        cardsList.add(CardType.CARD_8);
        cardsList.add(CardType.CARD_8);
        cardsList.add(CardType.CARD_8);

        cardsList.add(CardType.CARD_9);
        cardsList.add(CardType.CARD_9);
        cardsList.add(CardType.CARD_9);
        cardsList.add(CardType.CARD_9);

        cardsList.add(CardType.CARD_10);
        cardsList.add(CardType.CARD_10);
        cardsList.add(CardType.CARD_10);
        cardsList.add(CardType.CARD_10);

        cardsList.add(CardType.CARD_J);
        cardsList.add(CardType.CARD_J);
        cardsList.add(CardType.CARD_J);
        cardsList.add(CardType.CARD_J);

        cardsList.add(CardType.CARD_Q);
        cardsList.add(CardType.CARD_Q);
        cardsList.add(CardType.CARD_Q);
        cardsList.add(CardType.CARD_Q);

        cardsList.add(CardType.CARD_K);
        cardsList.add(CardType.CARD_K);
        cardsList.add(CardType.CARD_K);
        cardsList.add(CardType.CARD_K);

        cardsList.add(CardType.CARD_BLACK_JOKE);
        cardsList.add(CardType.CARD_RED_JOKE);
    }

    @Override
    public CardType getCardByIndex(int index) {
        if (0 <= index && index < CARD_NUMBER) {
            return cardsList.get(index);
        }
        return null;
    }

    @Override
    public int getValueOfCard(CardType card) {
        return card.getValue();
    }

    public enum CardType {

        CARD_A("A"),
        CARD_2("2"),
        CARD_3("3"),
        CARD_4("4"),
        CARD_5("5"),
        CARD_6("6"),
        CARD_7("7"),
        CARD_8("8"),
        CARD_9("9"),
        CARD_10("10"),
        CARD_J("J"),
        CARD_Q("Q"),
        CARD_K("K"),
        CARD_BLACK_JOKE("black Joke"),
        CARD_RED_JOKE("red Joke");

        private String name;

        CardType(String nameParam) {
            name = nameParam;
        }

        int getValue() {

            int result = 0;
            switch (name) {
                case "A":
                    result = 1;
                    break;
                case "2":
                    result = 2;
                    break;
                case "3":
                    result = 3;
                    break;
                case "4":
                    result = 4;
                    break;
                case "5":
                    result = 5;
                    break;
                case "6":
                    result = 6;
                    break;
                case "7":
                    result = 7;
                    break;
                case "8":
                    result = 8;
                    break;
                case "9":
                    result = 9;
                    break;
                case "10":
                    result = 10;
                    break;
                case "J":
                    result = 11;
                    break;
                case "Q":
                    result = 12;
                    break;
                case "K":
                    result = 13;
                    break;
                case "black Joke":
                    result = 20;
                    break;
                case "red Joke":
                    result = 20;
                    break;
                default:
                    break;
            }
            return result;
        }

        public String toString() {
            return name;
        }
    }
}
