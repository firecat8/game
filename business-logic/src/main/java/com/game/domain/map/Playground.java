/**
 *   Games development project.
 *
 *   Creator: Gergana Kuleva Dimitrova
 *
 */
package com.game.domain.map;

import com.game.domain.PlaygroundPosition;
import com.game.domain.card.Directions;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;

/**
 *
 * @author gdimitrova
 */
public class Playground {

    private int maxRows;

    private int maxColumns;

    private final Map<PlaygroundPosition, PlaygroundElement> elements = new HashMap<>();

    public Playground() {
        this(10, 15);
    }

    public Playground(int maxRows, int maxColumns) {
        this.maxRows = maxRows;
        this.maxColumns = maxColumns;
        addElements();
    }

    private void addElements() {
        for (int i = 0; i < maxRows; i++) {
            for (int j = 0; j < maxColumns; j++) {
                elements.put(new PlaygroundPosition(i, j), null);
            }
        }
    }

    public void changeMapSize(int rows, int cols) {
        this.maxRows = rows;
        this.maxColumns = cols;
        addElements();
    }

    public boolean couldAddElements(PlaygroundPosition start, Set<Directions> directions) {
        return directions.stream()
                .map((d) -> d.getPosition(start))
                .noneMatch((pos) -> (!elements.containsKey(pos) || elements.get(pos) != null));
    }

    public void addElements(Map<PlaygroundPosition, PlaygroundElement> elems) {
        elements.putAll(elems);
    }

    public boolean canVisit(PlaygroundPosition pos) {
        if (!elements.containsKey(pos)) {
            return false;
        }
        PlaygroundElement me = elements.get(pos);
        if (me == null) {
            return false;
        }
        return me.isVisitable();
    }

    public Boolean isAttacked(PlaygroundPosition pos, AttackerVisitor visitor) {
        if (!elements.containsKey(pos)) {
            return false;
        }
        PlaygroundElement me = elements.get(pos);
        if (me == null) {
            return false;
        }
        Boolean isAttacked = (Boolean) me.accept(visitor);
        if (isAttacked && me.isRemovable()) {
            elements.put(pos, null);
        }
        return isAttacked;
    }

    public boolean isValid(PlaygroundPosition pos) {
        return !(pos.getRow() < 0 || pos.getColumn() < 0 || pos.getRow() > maxRows - 1 || pos.getColumn() > maxColumns - 1);
    }

    public Map<PlaygroundPosition, PlaygroundElement> filter(Function<PlaygroundElement, Boolean> criteria) {
        Map<PlaygroundPosition, PlaygroundElement> filtered = new HashMap<>();
        elements.entrySet().forEach((entry) -> {
            PlaygroundElement elem = entry.getValue();
            if (criteria.apply(elem)) {
                filtered.put(entry.getKey(), elem);
            }
        });
        return filtered;
    }

    public void removeElements(List<PlaygroundPosition> positions) {
        for (PlaygroundPosition p : positions) {
            elements.put(p, null);
        }
    }

}
