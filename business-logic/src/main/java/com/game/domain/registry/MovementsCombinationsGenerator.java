/**
 *   Games development project.
 *
 *   Creator: Gergana Kuleva Dimitrova
 *
 */
package com.game.domain.registry;

import com.game.domain.card.Directions;
import com.game.domain.card.Movement;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 *
 * @author gdimitrova
 */
public class MovementsCombinationsGenerator {

    public final static MovementsCombinationsGenerator INSTANCE = new MovementsCombinationsGenerator();

    private MovementsCombinationsGenerator() {
        //Singleton
    }

    public List<List<Movement>> generate(List<Set<Directions>> directionCombinations) {
        List<List<Movement>> combinations = new ArrayList<>();
        for (Set<Directions> directions : directionCombinations) {
            combinations.add(generate(directions, 2, 3));
            combinations.add(generate(directions, 3, 5));
            combinations.add(generate(directions, 5, 2));
        }
        return combinations;
    }

    private List<Movement> generate(Set<Directions> directions, int oddPositionNumber, int evenPositionNumber) {
        List<Movement> movements = new ArrayList<>();
        int i = 1;
        for (Directions d : directions) {
            movements.add(new Movement(i % 2 == 0 ? evenPositionNumber : oddPositionNumber, d));
            i++;
        }
        return movements;
    }

}
