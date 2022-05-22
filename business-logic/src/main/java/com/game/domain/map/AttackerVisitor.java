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
 */
public class AttackerVisitor implements PlaygroundElementVisitor<Boolean> {
    
    @Override
    public Boolean visit(BearFigure attacked) {
        attacked.removeDrinksCount(2);
        return true;
    }
    
    @Override
    public Boolean visit(Teritory t) {
        t.getOwner().getFigure().removeDrinksCount(1);
        return true;
    }
    
}
