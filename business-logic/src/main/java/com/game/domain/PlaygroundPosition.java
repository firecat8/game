/**
 *   Games development project.
 *
 *   Creator: Gergana Kuleva Dimitrova
 *
 */
package com.game.domain;

/**
 *
 * @author gdimitrova
 */
public class PlaygroundPosition implements Comparable<PlaygroundPosition> {

    private final int row;

    private final int column;

    public PlaygroundPosition(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    @Override
    public int compareTo(PlaygroundPosition o) {
        if (row == o.getRow() && column == o.getColumn()) {
            return 0;
        }
        if (row > o.getRow() && column > o.getColumn()) {
            return 1;
        }
        return -1;
    }

}
