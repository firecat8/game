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
 */
public class SurpriseCard extends AbstractCard<SurpriseCard> {

    public SurpriseCard(String description, int roundsActivable, Consumer<GameContext> action) {
        super(description, roundsActivable, action, CostTypes.NONE, 0);
    }

    @Override
    public SurpriseCard makeCopy() {
        return new SurpriseCard(getDescription(), getRoundsCountActivable(), getAction());
    }

    @Override
    public <T> T accept(CardVisitor<T> visitor) {
        return visitor.visit(this);
    }

}
