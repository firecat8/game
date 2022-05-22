/**
 *   Games development project.
 *
 *   Creator: Gergana Kuleva Dimitrova
 *
 */
package com.game.domain.card;

import com.game.domain.GameContext;
import java.util.function.Consumer;

/**
 *
 * @author gdimitrova
 * @param <C>
 */
public abstract class AbstractCard<C extends AbstractCard> implements Card<C> {

    private final String description;

    private boolean isActive = false;

    private final int roundsActivable;

    private final Consumer<GameContext> action;

    private final CostTypes costType;

    private final int cost;

    public AbstractCard(String description, Consumer<GameContext> action, CostTypes costType, int cost) {
        this(description, 1, action, costType, cost);
    }

    public AbstractCard(String description, int roundsActivable, Consumer<GameContext> action, CostTypes costType, int cost) {
        this.description = description;
        this.roundsActivable = roundsActivable;
        this.action = action;
        this.costType = costType;
        this.cost = cost;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public boolean isActive() {
        return isActive;
    }

    @Override
    public void activate() {
        isActive = true;
    }

    @Override
    public void deactivate() {
        isActive = false;
    }

    @Override
    public int getRoundsCountActivable() {
        return roundsActivable;
    }

    @Override
    public Consumer<GameContext> getAction() {
        return action;
    }

    @Override
    public CostTypes getCostType() {
        return costType;
    }

    @Override
    public int getCost() {
        return cost;
    }
}
