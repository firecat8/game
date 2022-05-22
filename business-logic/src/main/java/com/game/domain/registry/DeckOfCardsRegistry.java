/**
 *   Games development project.
 *
 *   Creator: Gergana Kuleva Dimitrova
 *
 */
package com.game.domain.registry;

import com.game.domain.card.AttackCard;
import com.game.domain.card.Card;
import com.game.domain.card.Directions;
import com.game.domain.card.ExpansionCard;
import com.game.domain.card.MovementCard;
import com.game.domain.card.Movement;
import com.game.domain.card.desk.DeckOfCards;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 *
 * @author gdimitrova
 */
public class DeckOfCardsRegistry {
    
    public final static DeckOfCardsRegistry INSTANCE = new DeckOfCardsRegistry();
    
    private final Map<Class, DeckOfCards> decksByCardType = new ConcurrentHashMap<>();
    
    private DeckOfCardsRegistry() {
        register();
    }
    
    private void register() {
        List<Set<Directions>> combinations = DirectionsCombinationsGenerator.INSTANCE.generate();
        for (Set<Directions> directions : combinations) {
            register(new AttackCard(directions, ""));
            register(new ExpansionCard(directions, ""));
        }
        List<List<Movement>> movementCombinations = MovementsCombinationsGenerator.INSTANCE.generate(combinations);
        movementCombinations.forEach((movements) -> {
            register(new MovementCard("", movements));
        });
        SurpriseCardsRegistry.INSTANCE.getCards().forEach(c -> register(c));
    }
    
    private void register(Card card) {
        decksByCardType.get(card.getClass()).addCard(card);
    }
    
    public DeckOfCards get(Class cardClass) {
        return decksByCardType.get(cardClass);
    }
    
}
