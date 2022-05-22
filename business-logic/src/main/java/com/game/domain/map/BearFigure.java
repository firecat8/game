/**
 *   Games development project.
 *
 *   Creator: Gergana Kuleva Dimitrova
 *
 */
package com.game.domain.map;

import com.game.domain.Drinks;

/**
 *
 * @author gdimitrova
 */
public class BearFigure extends AbstractPlaygroundElement<BearFigure> {

    private Drinks drink;

    private int drinksCount = 0;

    private final String name;

    public BearFigure(Drinks drink) {
        this.name = drink.name().substring(0, 1).concat(drink.name().substring(1).toLowerCase());
        this.drink = drink;
    }

    public Drinks getDrink() {
        return drink;
    }

    public void setDrink(Drinks drink) {
        this.drink = drink;
    }

    public void addDrinksCount(int count) {
        drinksCount += count;
    }

    public void removeDrinksCount(int count) {
        if (drinksCount - count > 0) {
            drinksCount -= count;
            return;
        }
        drinksCount = 0;
    }

    public void setDrinksCount(int drinksCount) {
        this.drinksCount = drinksCount;
    }

    public int getDrinksCount() {
        return drinksCount;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean isVisitable() {
        return false;
    }

    @Override
    public boolean isRemovable() {
        return false;
    }

    @Override
    public BearFigure makeCopy() {
        return new BearFigure(drink);
    }

    @Override
    public <T> T accept(PlaygroundElementVisitor<T> visitor) {
        return visitor.visit(this);
    }

}
