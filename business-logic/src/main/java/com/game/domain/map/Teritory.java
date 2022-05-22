/**
 *   Games development project.
 *
 *   Creator: Gergana Kuleva Dimitrova
 *
 */
package com.game.domain.map;

import com.game.domain.Player;

/**
 *
 * @author gdimitrova
 */
public class Teritory extends AbstractPlaygroundElement<Teritory> {

    private final Player owner;

    public Teritory(Player owner) {
        this.owner = owner;
    }

    public Player getOwner() {
        return owner;
    }

    @Override
    public Teritory makeCopy() {
        return new Teritory(owner);
    }

    @Override
    public boolean isVisitable() {
        return true;
    }

    @Override
    public boolean isRemovable() {
        return true;
    }

    @Override
    public <T> T accept(PlaygroundElementVisitor<T> visitor) {
        return visitor.visit(this);
    }

}
