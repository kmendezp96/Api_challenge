package kafka;

import helpers.PropertiesHelper;
import io.confluent.kafka.schemaregistry.client.CachedSchemaRegistryClient;
import org.apache.kafka.clients.producer.ProducerConfig;

import java.io.IOException;
import java.util.Collections;
import java.util.Map;
import java.util.Properties;

public class ConnectionKafka {

    static Properties props;
    static String TOPIC;
    static CachedSchemaRegistryClient schemaRegistry;
    static Map<String, String> serdeProps;

    public ConnectionKafka() throws IOException {
        PropertiesHelper propertiesHelper = new PropertiesHelper();
        this.props = new Properties();
        String schemaRegistryUrl = propertiesHelper.getSchemaRegistryUrl();
        String bootstrapServers = propertiesHelper.getBootstrapServer();
        TOPIC = propertiesHelper.getTopic();

        System.out.println("Connecting to Kafka cluster via bootstrap servers " + bootstrapServers);
        System.out.println("Connecting to Confluent schema registry at " + schemaRegistryUrl);

        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        schemaRegistry = new CachedSchemaRegistryClient(schemaRegistryUrl, 100);
        serdeProps = Collections.singletonMap("schema.registry.url", schemaRegistryUrl);
    }
}
