/**
 *   Games development project.
 *
 *   Creator: Gergana Kuleva Dimitrova
 *
 */
package com.game.domain.card;

/**
 *
 * @author gdimitrova
 */
public class Movement {
    private final int steps;
    private final Directions direction;

    public Movement(int steps, Directions direction) {
        this.steps = steps;
        this.direction = direction;
    }

    public int getSteps() {
        return steps;
    }

    public Directions getDirection() {
        return direction;
    }
    
}
