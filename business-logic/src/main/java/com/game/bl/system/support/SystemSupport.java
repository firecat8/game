package com.game.bl.system.support;

import com.game.bl.cache.CacheRegistry;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 *
 * @author gdimitrova
 */
public class SystemSupport {

    public final static String SUPPORT_LOCALES_CACHE_KEY = "system.support.locales";

    public final static Locale DEFAULT_LOCALE = Locale.UK;

    private final static Locale BG_LOCALE = new Locale("bg", "BG");

    public final static Map<String, Locale> LOCALES = new ConcurrentHashMap<>() {
        {
            put(makeKey(DEFAULT_LOCALE), DEFAULT_LOCALE);
            put(makeKey(BG_LOCALE), BG_LOCALE);
        }
    };

    public final static SystemSupport INSTANCE = new SystemSupport();

    private SystemSupport() {
        CacheRegistry.INSTANCE.add(SUPPORT_LOCALES_CACHE_KEY, LOCALES);
    }

    private static String makeKey(Locale l) {
        return l.getLanguage() + "_" + l.getCountry();
    }

    public static Locale get(Locale l) {
        return LOCALES.getOrDefault(makeKey(l), DEFAULT_LOCALE);
    }
}
