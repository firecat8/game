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
import com.game.domain.map.AttackerVisitor;
import com.game.domain.map.Playground;
import java.util.Set;
import java.util.function.Consumer;

/**
 *
 * @author gdimitrova
 */
public class AttackCard extends DirectionsCard<AttackCard> {

    public AttackCard(Set<Directions> directions, String description) {
        super(directions, CostTypes.NONE, directions.size() * 10, description, null);
    }

    public AttackCard(Set<Directions> directions, String description, int roundsActivable) {
        super(directions, CostTypes.NONE, directions.size() * 10, description, roundsActivable, null);
    }

    @Override
    public Consumer<GameContext> getAction() {
        return (ctx) -> {
            Player player = ctx.getActivePlayer();
            Set<Directions> directions = this.getDirections();
            Playground pg = ctx.getPlayground();
            PlaygroundPosition bearPos = player.getFigure().getPosition();
            AttackerVisitor visitor = new AttackerVisitor();
            for (Directions d : directions) {
                PlaygroundPosition pos = d.getPosition(bearPos);
                while (pg.isValid(pos)) {
                    pg.isAttacked(pos, visitor);
                    pos = d.getPosition(pos);
                }
                bearPos = pos;
            }
        };
    }

    @Override
    public AttackCard makeCopy() {
        return new AttackCard(getDirections(), getDescription(), getRoundsCountActivable());
    }

    @Override
    public <T> T accept(CardVisitor<T> visitor) {
        return visitor.visit(this);
    }

}
