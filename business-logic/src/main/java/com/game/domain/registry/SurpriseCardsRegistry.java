/**
 *   Games development project.
 *
 *   Creator: Gergana Kuleva Dimitrova
 *
 */
package com.game.domain.registry;

import com.game.domain.GameContext;
import com.game.domain.Player;
import com.game.domain.PlaygroundPosition;
import com.game.domain.card.ItemsShuffler;
import com.game.domain.card.SurpriseCard;
import com.game.domain.map.BearFigure;
import com.game.domain.map.Playground;
import com.game.domain.map.PlaygroundElement;
import com.game.domain.map.Teritory;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 *
 * @author gdimitrova
 */
class SurpriseCardsRegistry {

    public final static SurpriseCardsRegistry INSTANCE = new SurpriseCardsRegistry();

    private final List<SurpriseCard> cards = new ArrayList<>();

    public SurpriseCardsRegistry() {
        register();
    }

    private void register() {
        addPercentCards();
    }

    private void addPercentCards() {
        double[] percents = {0.10, 0.20, 0.25, 0.50, 0.75, 0.90};
        for (double percent : percents) {
            addDrinksCountChanger(percent);
            addDrinksCountChangerForActivePlayer(percent);
            addDrinksCountChangerExceptActivePlayer(percent);
            //
            addDrinksCountChanger(-percent);
            addDrinksCountChangerExceptActivePlayer(-percent);
            addDrinksCountChangerForActivePlayer(-percent);
            //
            addTeritoryReducer(-percent);
            addTeritoryReducerForActivePlayer(-percent);
            addTeritoryReducerExceptActivePlayer(-percent);
        }
    }

    private void addDrinksCountChanger(double percent) {
        add("Change " + percent + "% of drinks of the players", 1, (ctx) -> {
            List<Player> players = ctx.getPlayers();
            players.stream().map((player) -> player.getFigure()).forEachOrdered((figure) -> {
                int drinksCount = figure.getDrinksCount();
                figure.setDrinksCount((int) (drinksCount + (drinksCount * percent)));
            });
        });
    }

    private void addDrinksCountChangerExceptActivePlayer(double percent) {
        add("Change " + percent + "% of drinks of the players except the active player", 1, (ctx) -> {
            List<Player> players = getPlayerWithoutOne(ctx.getPlayers(), ctx.getActivePlayer());
            players.stream().map((player) -> player.getFigure()).forEachOrdered((figure) -> {
                int drinksCount = figure.getDrinksCount();
                figure.setDrinksCount((int) (drinksCount + (drinksCount * percent)));
            });
        });
    }

    private void addDrinksCountChangerForActivePlayer(double percent) {
        add("Change " + percent + "% of drinks of the active player", 1, (ctx) -> {
            Player player = ctx.getActivePlayer();
            BearFigure figure = player.getFigure();
            int drinksCount = figure.getDrinksCount();
            figure.setDrinksCount((int) (drinksCount + (drinksCount * percent)));
        });
    }

    private void addTeritoryReducer(double percent) {
        add("Reduce " + percent + "% of teritory of the players", 1, (ctx) -> {
            Playground playground = ctx.getPlayground();
            ctx.getPlayers().forEach((player) -> {
                reduceTeritoty(playground, percent, player.getName());
            });
        });
    }

    private void addTeritoryReducerExceptActivePlayer(double percent) {
        add("Reduce " + percent + "% of teritory of the players except the active player", 1, (ctx) -> {
            Playground playground = ctx.getPlayground();
            List<Player> players = getPlayerWithoutOne(ctx.getPlayers(), ctx.getActivePlayer());
            players.forEach((player) -> {
                reduceTeritoty(playground, percent, player.getName());
            });
        });
    }

    private void addTeritoryReducerForActivePlayer(double percent) {
        add("Reduce " + percent + "% of teritory of the active player", 1, (ctx) -> {
            reduceTeritoty(ctx.getPlayground(), percent, ctx.getActivePlayer().getName());
        });
    }

    private void reduceTeritoty(Playground playground, double percent, String name) {
        Map<PlaygroundPosition, PlaygroundElement> teritory
                = playground.filter(getPlayerTeritoryCriteria(name));
        List<PlaygroundPosition> reduced = getReduced(teritory.keySet(), percent);
        playground.removeElements(reduced);
    }

    private Function<PlaygroundElement, Boolean> getPlayerTeritoryCriteria(String name) {
        return (pe) -> {
            if (!(pe instanceof Teritory)) {
                return false;
            }
            Teritory t = (Teritory) pe;
            return t.getOwner().getName().equals(name);
        };
    }

    private List<PlaygroundPosition> getReduced(Set<PlaygroundPosition> keySet, double percent) {
        return ItemsShuffler.shiffle(new ArrayList<>(keySet), (int) (keySet.size() * percent));
    }

    private List<Player> getPlayerWithoutOne(List<Player> players, Player player) {
        return players.stream().filter(p -> !p.getName().equals(player.getName())).collect(Collectors.toList());
    }

    private void add(String description, int roundsCount, Consumer<GameContext> action) {
        cards.add(new SurpriseCard(description, roundsCount, action));
    }

    public List<SurpriseCard> getCards() {
        return new ArrayList<>(cards);
    }
}
