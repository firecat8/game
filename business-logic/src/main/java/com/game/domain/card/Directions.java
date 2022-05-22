/**
 *   Games development project.
 *
 *   Creator: Gergana Kuleva Dimitrova
 *
 */
package com.game.domain.card;

import com.game.domain.PlaygroundPosition;

/**
 *
 * @author gdimitrova
 */
public enum Directions {
    EAST(0, 1), WEST(0, -1), NORTH(-1, 0), SOUTH(1, 0), NORTH_EAST(-1, 1), SOUTH_EAST(1, 1), NORTH_WEST(-1, -1), SOUTH_WEST(1, -1);

    private final int rowOffset;

    private final int columnOffset;

    Directions(int rowOffset, int columnOffset) {
        this.rowOffset = rowOffset;
        this.columnOffset = columnOffset;
    }

    public PlaygroundPosition getPosition(PlaygroundPosition start) {
        return new PlaygroundPosition(start.getRow() + rowOffset, start.getColumn() + columnOffset);
    }
}
