/**
 *   Games development project.
 *
 *   Creator: Gergana Kuleva Dimitrova
 *
 */
package com.game.domain.map;

import com.game.domain.GameElement;
import com.game.domain.PlaygroundPosition;

/**
 *
 * @author gdimitrova
 * @param <E>
 */
public interface PlaygroundElement<E extends PlaygroundElement> extends GameElement<E> {

    PlaygroundPosition getPosition();

    void setPosition(PlaygroundPosition pos);

    public boolean isVisitable();

    public boolean isRemovable();

    public <T> T accept(PlaygroundElementVisitor<T> visitor);

}
