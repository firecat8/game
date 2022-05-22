package com.game.bl.i18n;

import com.game.bl.system.support.SystemSupport;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import javax.ws.rs.core.SecurityContext;

/**
 *
 * @author gdimitrova
 */
public class I18n {

    public static String translate(Message m, Locale l) {
        ResourceBundle bundle = getBundle(l);
        return bundle.getString(m.getMessageKey());
    }

    public static List<String> translate(List<Message> messages, String token) {
        return null;//translate(messages, getToken(token).getLocale());
    }

    public static List<String> translate(List<Message> messages, Locale l) {
        ResourceBundle bundle = getBundle(l);
        return messages.stream().map(m -> bundle.getString(m.getMessageKey())).collect(Collectors.toList());
    }

    public static List<String> translate(List<Message> messages, SecurityContext sc) {
        return translate(messages, sc.getUserPrincipal().getName());
    }

    private static ResourceBundle getBundle(Locale l) {
        return ResourceBundle.getBundle("translations/i18n", SystemSupport.get(l));
    }
}
