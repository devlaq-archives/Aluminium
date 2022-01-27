package aluminium.util.config;

import aluminium.files.Fi;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

/**
 * Wrapper class of {@link YamlConfiguration}
 */
public class YamlConfigurations {

    /**
     * Wrapper method of {@link YamlConfiguration#loadConfiguration(File file)}
     * @param fi file to load yaml from.
     * @return loaded yaml configuration.
     */
    public static YamlConfiguration load(Fi fi) {
        return YamlConfiguration.loadConfiguration(fi.file());
    }

    /**
     * Wrapper method of {@link YamlConfiguration#save(File)}
     * @param configuration configuration to save.
     * @param fi file.
     * @throws IOException Thrown when the given file cannot be written to for any reason.
     */
    public static void save(YamlConfiguration configuration, Fi fi) throws IOException {
        configuration.save(fi.file());
    }

    /**
     * Wrapper method of {@link YamlConfiguration#save(File)} with no exception.
     * If exception, return the io exception.
     * @param configuration configuration to save.
     * @param fi file.
     * @return IOException if exception.
     */
    public static IOException saveNoException(YamlConfiguration configuration, Fi fi) {
        try {
            configuration.save(fi.file());
            return null;
        } catch (IOException e) {
            return e;
        }
    }

}
