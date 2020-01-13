package com.wangrollin.epam;

public interface BasicCardDeck<T> {

    void shuffle();

    void putCardInOrder();

    T getCardByIndex(int index);

    int getValueOfCard(T card);
}
