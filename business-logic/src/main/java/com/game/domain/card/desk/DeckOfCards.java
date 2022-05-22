/**
 *   Games development project.
 *
 *   Creator: Gergana Kuleva Dimitrova
 *
 */
package com.game.domain.card.desk;

import com.game.domain.card.Card;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gdimitrova
 * @param <C>
 */
public class DeckOfCards<C extends Card> {

    private final List<C> cards = new ArrayList<>();

    public C showCard() {
        return cards.get(0);
    }

    public C getCard() {
        C card = cards.get(0);
        cards.remove(0);
        return card;
    }

    public void addCard(C card) {
        cards.add(card);
    }

    public C replaceCard(C old) {
        C card = getCard();
        cards.add(old);
        return card;
    }

    public boolean isEmpty() {
        return cards.isEmpty();
    }

    public void changeCards(List<C> newDeck) {
        cards.clear();
        cards.addAll(newDeck);
    }

    public List<C> getCards() {
        return new ArrayList<>(cards);
    }

}
