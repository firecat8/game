package com.game.bl.cache;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 *
 * @author gdimitrova
 */
public class CacheRegistry {

    public final static CacheRegistry INSTANCE = new CacheRegistry();

    private final Map<String, Object> cache = new ConcurrentHashMap<>();

    private CacheRegistry() {
        //singleton
    }

    public <T> void add(String cacheRegion, T o) {
        cache.putIfAbsent(cacheRegion, o);
    }

    public <T> T get(String cacheRegion) {
        return (T) cache.get(cacheRegion);
    }

}
