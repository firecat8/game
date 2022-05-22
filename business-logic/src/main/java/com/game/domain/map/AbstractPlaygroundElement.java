/**
 *   Games development project.
 *
 *   Creator: Gergana Kuleva Dimitrova
 *
 */
package com.game.domain.map;

import com.game.domain.PlaygroundPosition;

/**
 *
 * @author gdimitrova
 * @param <ME>
 */
public abstract class AbstractPlaygroundElement<ME extends AbstractPlaygroundElement> implements PlaygroundElement<ME> {

    private PlaygroundPosition pos;

    @Override
    public PlaygroundPosition getPosition() {
        return pos;
    }

    @Override
    public void setPosition(PlaygroundPosition pos) {
        this.pos = pos;
    }

}
