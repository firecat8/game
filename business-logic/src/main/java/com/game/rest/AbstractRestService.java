/**
 *   Games development project.
 *
 *   Creator: Gergana Kuleva Dimitrova
 *
 */
package com.game.rest;

import com.game.bl.cache.CacheRegistry;
import com.game.domain.GameContext;
import java.util.Map;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;

/**
 *
 * @author gdimitrova
 */
@Consumes("application/json")
@Produces("application/json")
public abstract class AbstractRestService {

    protected CacheRegistry cacheRegistry = CacheRegistry.INSTANCE;

    public final static String CONTEXTS = "CONTEXTS";

    protected Map<String, GameContext> getGameContextsCtx() {
        return cacheRegistry.get(CONTEXTS);
    }

    protected GameContext getCtx(String ctxId) {
        Map<String, GameContext> cache = getGameContextsCtx();
        return cache.get(ctxId);
    }
}
