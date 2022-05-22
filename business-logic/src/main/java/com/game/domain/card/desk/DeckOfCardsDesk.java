/**
 *   Games development project.
 *
 *   Creator: Gergana Kuleva Dimitrova
 *
 */
package com.game.domain.card.desk;

import com.game.domain.card.AttackCard;
import com.game.domain.card.Card;
import com.game.domain.card.ExpansionCard;
import com.game.domain.card.MovementCard;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author gdimitrova
 */
public class DeckOfCardsDesk {

    private final Map<Class, DeckOfCards> decksByCardType = new HashMap<>() {
        {
            put(ExpansionCard.class, new DeckOfCards<ExpansionCard>());
            put(AttackCard.class, new DeckOfCards<AttackCard>());
            put(MovementCard.class, new DeckOfCards<MovementCard>());
        }
    };

    private final Map<Class, DeckOfCards> playedDecksByCardType = new HashMap<>() {
        {
            put(ExpansionCard.class, new DeckOfCards<ExpansionCard>());
            put(AttackCard.class, new DeckOfCards<AttackCard>());
            put(MovementCard.class, new DeckOfCards<MovementCard>());
        }
    };

    public Card replace(Card card) {
        return decksByCardType.get(card.getClass()).replaceCard(card);
    }

    public Card get(Class clazz) {
        return decksByCardType.get(clazz).getCard();
    }

    public void add(Card card) {
        playedDecksByCardType.get(card.getClass()).addCard(card);
    }

    public Card show(Class clazz) {
        return playedDecksByCardType.get(clazz).showCard();
    }

    public <C extends Card> void changeCards(Class<C> clazz, List<C> cards) {
        playedDecksByCardType.get(clazz).changeCards(cards);
    }

}
