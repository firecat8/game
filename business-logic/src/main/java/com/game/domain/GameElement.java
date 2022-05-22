/**
 *   Games development project.
 *
 *   Creator: Gergana Kuleva Dimitrova
 *
 */
package com.game.domain;

import java.io.Serializable;

/**
 *
 * @author gdimitrova
 * @param <T>
 */
public interface GameElement<T extends GameElement> extends Serializable {

    public T makeCopy();
}
