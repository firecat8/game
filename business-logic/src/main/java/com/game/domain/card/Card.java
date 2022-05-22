/**
 *   Games development project.
 *
 *   Creator: Gergana Kuleva Dimitrova
 *
 */
package com.game.domain.card;

import com.game.domain.GameContext;
import com.game.domain.GameElement;
import java.util.function.Consumer;

/**
 *
 * @author gdimitrova
 * @param <C>
 */
public interface Card<C extends Card> extends GameElement<C> {

    String getDescription();

    boolean isActive();

    void activate();

    void deactivate();

    int getRoundsCountActivable();

    Consumer<GameContext> getAction();

    public CostTypes getCostType();

    public int getCost();

    <T> T accept(CardVisitor<T> visitor);
}
