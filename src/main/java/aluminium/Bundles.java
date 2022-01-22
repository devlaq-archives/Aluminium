package aluminium;

import aluminium.struct.Seq;
import aluminium.util.I18NBundle;
import aluminium.util.Strings;

import java.util.Locale;

public class Bundles {

    private Seq<I18NBundle> bundleSeq;

    public void addI18NBundle(I18NBundle bundle) {
        bundleSeq.add(bundle);
    }

    public void removeI18NBundle(I18NBundle bundle) {
        bundleSeq.remove(bundle);
    }

    public void removeI18NBundle(Locale locale) {
        removeI18NBundle(getI18NBundle(locale));
    }

    public I18NBundle getI18NBundle(Locale locale) {
        for(I18NBundle bundle : bundleSeq) {
            if(bundle.getLocale() == locale) return bundle;
        }
        return null;
    }

    public boolean hasI18NBundle(Locale locale) {
        for(I18NBundle bundle : bundleSeq) {
            if(bundle.getLocale() == locale) return true;
        }
        return false;
    }

    public Seq<I18NBundle> getBundleSeq() {
        return bundleSeq;
    }

    public String get(String key) {
        for(I18NBundle bundle : bundleSeq) {
            if(bundle.has(key)) return bundle.get(key);
        }
        return null;
    }

    public String get(String key, String def) {
        String value = get(key);
        return value != null ? value : def;
    }

    public String get(Locale locale, String key) {
        for(I18NBundle bundle : bundleSeq.filter(b -> b.getLocale() == locale)) {
            if(bundle.has(key)) return bundle.get(key);
        }
        return null;
    }

    public String get(Locale locale, String key, String def) {
        String value = get(locale, key);
        return value != null ? value: def;
    }

    public String format(Locale locale, String text, Object... args) {
        if(text.startsWith("@") && !text.startsWith("@@")) {
            String key = text.substring(1);
            text = get(locale, key, "???" + key + "???");
        }

        return Strings.format(text, args);
    }

    public String format(String text, Object... args) {
        if(text.startsWith("@") && !text.startsWith("@@")) {
            String key = text.substring(1);
            text = get(key, "???" + key + "???");
        }

        return Strings.format(text, args);
    }

}
