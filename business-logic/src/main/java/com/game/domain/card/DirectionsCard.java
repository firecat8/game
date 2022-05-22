/**
 *   Games development project.
 *
 *   Creator: Gergana Kuleva Dimitrova
 *
 */
package com.game.domain.card;

import com.game.domain.GameContext;
import java.util.Set;
import java.util.function.Consumer;

/**
 *
 * @author gdimitrova
 * @param <C>
 */
public abstract class DirectionsCard<C extends DirectionsCard> extends AbstractCard<C> {

    private final Set<Directions> directions;

    public DirectionsCard(Set<Directions> directions, CostTypes costType, int cost, String description, Consumer<GameContext> action) {
        super(description, action, costType, cost);
        this.directions = directions;
    }

    public DirectionsCard(Set<Directions> directions, CostTypes costType, int cost, String description, int roundsActivable, Consumer<GameContext> action) {
        super(description, roundsActivable, action, costType, cost);
        this.directions = directions;
    }

    public Set<Directions> getDirections() {
        return directions;
    }

}
