/**
 *   Games development project.
 *
 *   Creator: Gergana Kuleva Dimitrova
 *
 */
package com.game.domain;

import com.game.domain.map.BearFigure;
import java.io.Serializable;

/**
 *
 * @author gdimitrova
 */
public class Player implements Serializable {

    private String name;

    private BearFigure figure;

    public Player() {
    }

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public BearFigure getFigure() {
        return figure;
    }

    public void setFigure(BearFigure figure) {
        this.figure = figure;
    }

}
