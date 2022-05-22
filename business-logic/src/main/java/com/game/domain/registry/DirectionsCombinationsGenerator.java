/**
 *   Games development project.
 *
 *   Creator: Gergana Kuleva Dimitrova
 *
 */
package com.game.domain.registry;

import com.game.domain.card.Directions;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;

/**
 *
 * @author gdimitrova
 */
public class DirectionsCombinationsGenerator {

    public final static DirectionsCombinationsGenerator INSTANCE = new DirectionsCombinationsGenerator();

    private DirectionsCombinationsGenerator() {
        //Singleton
    }

    public List<Set<Directions>> generate() {
        List<Directions> directions = new ArrayList<>(Arrays.asList(Directions.values()));
        List<Set<Directions>> combinations = new ArrayList<>();
        for (int i = 0; i < directions.size(); i++) {
            generate(directions, new LinkedHashSet<>(), i + 1, (combination) -> {
                combinations.add(combination);
            });
        }
        return combinations;
    }
/**
 * 
 * @param directions
 * @param set
 * @param setSize Required count directions for generated combination
 * @param setGetter 
 */
    private void generate(List<Directions> directions, Set<Directions> set, int setSize, Consumer<Set<Directions>> setGetter) {
        int size = directions.size();
        for (int i = 0; i < size; i++) {
            Set<Directions> copy = new LinkedHashSet<>(set);
            copy.add(directions.get(i));
            if (copy.size() == setSize) {
                setGetter.accept(copy);
                continue;
            }
            generate(directions.subList(i + 1, size), copy, setSize, setGetter);
        }
    }

}
