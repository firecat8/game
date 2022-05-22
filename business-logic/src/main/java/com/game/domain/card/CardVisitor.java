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
 * @param <T>
 */
public interface CardVisitor<T> {

    public T visit(MovementCard card);

    public T visit(AttackCard card);

    public T visit(ExpansionCard card);

    public T visit(SurpriseCard card);
}
