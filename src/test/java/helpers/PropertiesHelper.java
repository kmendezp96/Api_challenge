package helpers;


import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertiesHelper {
    private FileReader reader;
    private Properties properties;

    public PropertiesHelper() throws IOException {
        reader = new FileReader("src/test/resources/application.properties");
        properties = new Properties();
        properties.load(reader);
    }

    public String getTopic(){
        return properties.getProperty("TOPIC");
    }

    public String getBootstrapServer(){
        return properties.getProperty("BOOTSTRAP_SERVERS");
    }

    public String getSchemaRegistryUrl(){
        return properties.getProperty("schemaRegistryUrl");
    }
}
