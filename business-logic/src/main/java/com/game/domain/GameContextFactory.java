/**
 *   Games development project.
 *
 *   Creator: Gergana Kuleva Dimitrova
 *
 */
package com.game.domain;

import com.game.domain.card.ItemsShuffler;
import com.game.domain.card.AttackCard;
import com.game.domain.card.Card;
import com.game.domain.card.ExpansionCard;
import com.game.domain.card.MovementCard;
import com.game.domain.card.SurpriseCard;
import com.game.domain.card.desk.DeckOfCards;
import com.game.domain.registry.DeckOfCardsRegistry;
import java.util.List;

/**
 *
 * @author gdimitrova
 */
public class GameContextFactory {

    public final static GameContextFactory INSTANCE = new GameContextFactory();

    private GameContextFactory() {
    }

    public GameContext make(String id, Player p) {
        GameContext ctx = new GameContext(id, p);
        fillDeckOfCards(ctx, AttackCard.class);
        fillDeckOfCards(ctx, ExpansionCard.class);
        fillDeckOfCards(ctx, MovementCard.class);
        fillDeckOfCards(ctx, SurpriseCard.class);
        return ctx;
    }

    private <C extends Card> void fillDeckOfCards(GameContext ctx, Class<C> clazz) {
        DeckOfCards cardsDeck = DeckOfCardsRegistry.INSTANCE.get(clazz);
        List<C> cards = cardsDeck.getCards();
        ctx.changeCards(clazz, ItemsShuffler.shiffle(cards));
    }

}
