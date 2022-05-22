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
import java.util.List;
import java.util.function.Consumer;

/**
 *
 * @author gdimitrova
 */
public class MovementCard extends AbstractCard<MovementCard> {

    private final List<Movement> movements;

    public MovementCard(String description, List<Movement> movements) {
        super(description, null, CostTypes.NONE, 0);
        this.movements = movements;
    }

    public MovementCard(String description, int roundsActivable, List<Movement> movements) {
        super(description, roundsActivable, null, CostTypes.NONE, 0);
        this.movements = movements;
    }

    @Override
    public Consumer<GameContext> getAction() {
        return (ctx) -> {
            Player player = ctx.getActivePlayer();
            Playground pg = ctx.getPlayground();
            PlaygroundPosition bearPos = player.getFigure().getPosition();
            for (Movement movement : movements) {
                int steps = movement.getSteps();
                Directions d = movement.getDirection();
                PlaygroundPosition nextPosition = d.getPosition(bearPos);
                while (steps > 0 && pg.canVisit(nextPosition)) {
                    steps--;
                    bearPos = nextPosition;
                    nextPosition = d.getPosition(bearPos);
                }
            }
            player.getFigure().setPosition(bearPos);
        };
    }

    @Override
    public MovementCard makeCopy() {
        return new MovementCard(getDescription(), getRoundsCountActivable(), movements);
    }

    @Override
    public <T> T accept(CardVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
