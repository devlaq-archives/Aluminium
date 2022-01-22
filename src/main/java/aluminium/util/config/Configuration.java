package aluminium.util.config;

public interface Configuration {

    void load();

    void save(boolean overwriteExisting);

    void saveDefault(boolean overwriteExisting);

    default void set(String key, Object value) {}

    default Object get(String key) { return null; }

    default Object get(String key, Object def) { return null; }

}
