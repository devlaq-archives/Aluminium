package aluminium.util.config;

import aluminium.files.Fi;
import com.google.gson.*;

public class JsonConfiguration implements Configuration {

    private final Gson gson;
    private JsonObject object;

    private Fi configFile;
    private Fi defaultFile;

    public JsonConfiguration() {
        gson = new Gson();
        object = new JsonObject();
    }

    public JsonConfiguration(Fi configFile, Fi defaultFile) {
        this();
        this.configFile = configFile;
        this.defaultFile = defaultFile;
    }

    public JsonConfiguration(Fi configFile) {
        this();
        this.configFile = configFile;
    }

    public void load() {
        object = gson.fromJson(configFile.readString(), JsonObject.class);
    }

    public void load(boolean nonExistLoadDefault) {
        if(nonExistLoadDefault) saveDefault(false);
        load();
    }

    public void save(boolean overwriteExisting) {
        if(configFile.exists() && ! overwriteExisting) return;
        configFile.writeString(gson.toJson(object), false);
    }

    public void saveDefault(boolean overwriteExisting) {
        if(configFile.exists() && !overwriteExisting) return;
        String data = defaultFile.readString();
        configFile.writeString(data, false);
    }

    public void setConfigFile(Fi configFile) {
        this.configFile = configFile;
    }
    public void setDefaultFile(Fi defaultFile) {
        this.defaultFile = defaultFile;
    }

    public Fi getConfigFile() {
        return configFile;
    }

    public Fi getDefaultFile() {
        return defaultFile;
    }

    @Override
    public void set(String key, Object value) {
        add(key, gson.toJsonTree(value));
    }

    @Override
    public JsonElement get(String key, Object def) {
        JsonElement jsonElement = get(key);
        if(jsonElement == null) return gson.toJsonTree(def);
        else return jsonElement;
    }

    @Override
    public JsonElement get(String memberName) {
        return object.get(memberName);
    }

    public void addProperty(String property, Number value) {
        object.addProperty(property, value);
    }

    public void addProperty(String property, String value) {
        object.addProperty(property, value);
    }

    public void addProperty(String property, Boolean value) {
        object.addProperty(property, value);
    }

    public void addProperty(String property, Character value) {
        object.addProperty(property, value);
    }

    public void add(String property, JsonElement value) {
        object.add(property, value);
    }

    public JsonObject getAsJsonObject(String memberName) {
        return object.getAsJsonObject(memberName);
    }

    public JsonArray getAsJsonArray(String memberName) {
        return object.getAsJsonArray(memberName);
    }

    public JsonPrimitive getAsJsonPrimitive(String memberName) {
        return object.getAsJsonPrimitive(memberName);
    }

}
