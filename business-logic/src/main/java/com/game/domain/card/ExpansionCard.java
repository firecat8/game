/**
 *   Games development project.
 *
 *   Creator: Gergana Kuleva Dimitrova
 *
 */
package com.game.domain.card;

import com.game.domain.GameContext;
import com.game.domain.Player;
import com.game.domain.PlaygroundPosition;
import com.game.domain.map.Playground;
import com.game.domain.map.Teritory;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;
import com.game.domain.map.PlaygroundElement;

/**
 *
 * @author gdimitrova
 */
public class ExpansionCard extends DirectionsCard<ExpansionCard> {

    public ExpansionCard(Set<Directions> directions, String description) {
        super(directions, CostTypes.GOLD, directions.size() * 10, description, null);
    }

    public ExpansionCard(Set<Directions> directions, String description, int roundsActivable) {
        super(directions, CostTypes.GOLD, directions.size() * 10, description, roundsActivable, null);
    }

    @Override
    public Consumer<GameContext> getAction() {
        return (ctx) -> {
            Player player = ctx.getActivePlayer();
            Set<Directions> directions = this.getDirections();
            Playground pg = ctx.getPlayground();
            PlaygroundPosition bearPos = player.getFigure().getPosition();
            if (pg.couldAddElements(bearPos, directions)) {
                Map<PlaygroundPosition, PlaygroundElement> elems = new HashMap<>();
                for (Directions d : directions) {
                    PlaygroundPosition pos = d.getPosition(bearPos);
                    elems.put(pos, new Teritory(player));
                }
                pg.addElements(elems);
            }
        };
    }

    @Override
    public ExpansionCard makeCopy() {
        return new ExpansionCard(getDirections(), getDescription(), getRoundsCountActivable());
    }

    @Override
    public <T> T accept(CardVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
