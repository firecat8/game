/**
 *   Games development project.
 *
 *   Creator: Gergana Kuleva Dimitrova
 *
 */
package com.game.domain.map;

/**
 *
 * @author gdimitrova
 * @param <T>
 */
public interface PlaygroundElementVisitor<T> {

    public T visit(BearFigure bear);

    public T visit(Teritory teritory);

}
