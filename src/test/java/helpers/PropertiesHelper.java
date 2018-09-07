package helpers;


import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertiesHelper {

    private static Properties properties;

    public PropertiesHelper() throws IOException {
        FileReader reader = new FileReader("src/test/resources/application.properties");
        properties = new Properties();
        properties.load(reader);
    }

    public static String getTopic() {
        return properties.getProperty("topic");
    }

    public static String getBootstrapServer() {
        return properties.getProperty("bootstrapServers");
    }

    public static String getSchemaRegistryUrl() {
        return properties.getProperty("schemaRegistryUrl");
    }

    public static String getSongUrl() {
        return properties.getProperty("songUrl");
    }

    public static String getInstancesUrl() {
        return properties.getProperty("instancesUrl");
    }

    static String getHost() {
        return properties.getProperty("host");
    }

    static String getPort() {
        return properties.getProperty("port");
    }

    static String getStoreNames() {
        return properties.getProperty("storeNames");
    }

    public static String getByGenreUrl() {
        return properties.getProperty("byGenreUrl");
    }

    public static String getTopUrl() {
        return properties.getProperty("topUrl");
    }

}
