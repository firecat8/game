/**
 *   Games development project.
 *
 *   Creator: Gergana Kuleva Dimitrova
 *
 */
package com.game.domain.card;

import java.util.List;
import java.util.Random;

/**
 *
 * @author gdimitrova
 */
public class ItemsShuffler {

    public static <C> List<C> shiffle(List<C> items, int count) {
        return shiffle(items).subList(0, count);
    }

    public static <C> List<C> shiffle(List<C> items) {
        Random rand = new Random();
        int count = items.size();
        for (int i = 0; i < count; i++) {
            int r = i + rand.nextInt(count - i);
            C temp = items.get(r);
            items.set(r, items.get(i));
            items.set(i, temp);
        }
        return items;
    }
}
