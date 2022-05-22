/**
 *   Games development project.
 *
 *   Creator: Gergana Kuleva Dimitrova
 *
 */
package com.game.domain;

import com.game.domain.card.Card;
import com.game.domain.map.Playground;
import com.game.domain.card.desk.DeckOfCardsDesk;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 *
 * @author gdimitrova
 */
public class GameContext {

    private int roundNumber = 0;

    private final Player inviter;

    private final String inviterId;

    public GameStatus status;

    private final Map<Integer, Player> playersByOrder = new ConcurrentHashMap<>();

    private final Map<String, Player> playersById = new ConcurrentHashMap<>();

    private final DeckOfCardsDesk deckOfCards = new DeckOfCardsDesk();

    private final Playground playground = new Playground();

    public GameContext(String id, Player inviter) {
        this.inviterId = id;
        this.inviter = inviter;
        playersById.put(id, inviter);
        playersByOrder.put(0, inviter);
    }

    public String getInviterId() {
        return inviterId;
    }

    public Player getInviter() {
        return inviter;
    }

    public synchronized void addPlayer(String id, Player p) {
        int count = playersByOrder.keySet().size();
        playersByOrder.put(count, p);
        playersById.put(id, p);
    }

    public List<Player> getPlayers() {
        return new ArrayList<>(playersByOrder.values());
    }

    public Player getActivePlayer() {
        return playersByOrder.get(roundNumber % playersByOrder.size());
    }

    public Playground getPlayground() {
        return playground;
    }

    public <C extends Card> void changeCards(Class<C> clazz, List<C> cards) {
        deckOfCards.changeCards(clazz, cards);
    }

}
