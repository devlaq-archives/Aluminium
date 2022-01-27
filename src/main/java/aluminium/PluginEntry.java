package aluminium;

import aluminium.backends.AluFiles;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class PluginEntry extends JavaPlugin {

    @Override
    public void onEnable() {
        Aluminium.files = new AluFiles();
        Aluminium.bundles = new Bundles();

    }
}
