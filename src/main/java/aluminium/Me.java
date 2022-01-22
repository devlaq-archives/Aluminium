package aluminium;

import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;

import java.util.Locale;

public class Me {

    public static void message(CommandSender target, Locale locale, String text, Object... args) {
        target.sendMessage(format(locale, text, args));
    }

    public static void message(CommandSender target, String text, Object... args) {
        target.sendMessage(format(text, args));
    }

    public static String format(Locale locale, String text, Object... args) {
        return Aluminium.bundles.format(locale, text);
    }

    public static String format(String text, Object... args) {
        return Aluminium.bundles.format(text);
    }

}
