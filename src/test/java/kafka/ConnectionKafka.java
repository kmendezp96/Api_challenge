package kafka;

import helpers.PropertiesHelper;
import io.confluent.kafka.schemaregistry.client.CachedSchemaRegistryClient;
import org.apache.kafka.clients.producer.ProducerConfig;

import java.util.Collections;
import java.util.Map;
import java.util.Properties;

public class ConnectionKafka {

    private static Properties props;
    private static CachedSchemaRegistryClient schemaRegistry;
    private static Map<String, String> serdeProps;

    public ConnectionKafka() {
        props = new Properties();
        System.out.println("Connecting to Kafka cluster via bootstrap servers " + PropertiesHelper.getBootstrapServer());
        System.out.println("Connecting to Confluent schema registry at " + PropertiesHelper.getSchemaRegistryUrl());
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, PropertiesHelper.getBootstrapServer());
        schemaRegistry = new CachedSchemaRegistryClient(PropertiesHelper.getSchemaRegistryUrl(), 100);
        serdeProps = Collections.singletonMap("schema.registry.url", PropertiesHelper.getSchemaRegistryUrl());
    }

    static Properties getProps() {
        return props;
    }

    static CachedSchemaRegistryClient getSchemaRegistry() {
        return schemaRegistry;
    }

    static Map<String, String> getSerdeProps() {
        return serdeProps;
    }

}
