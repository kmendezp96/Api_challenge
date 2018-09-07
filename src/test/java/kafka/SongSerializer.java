package kafka;

import io.confluent.kafka.schemaregistry.client.SchemaRegistryClient;
import io.confluent.kafka.serializers.KafkaAvroSerializer;
import org.apache.kafka.common.serialization.Serializer;

import java.util.HashMap;
import java.util.Map;

import static io.confluent.kafka.serializers.KafkaAvroDeserializerConfig.SPECIFIC_AVRO_READER_CONFIG;

public class SongSerializer<T extends org.apache.avro.specific.SpecificRecord> implements Serializer<T> {

    KafkaAvroSerializer inner;

    /**
     * Constructor used by Kafka Streams.
     */
    public SongSerializer() {
        inner = new KafkaAvroSerializer();
    }

    public SongSerializer(SchemaRegistryClient client) {
        inner = new KafkaAvroSerializer(client);
    }

    public SongSerializer(SchemaRegistryClient client, Map<String, ?> props) {
        inner = new KafkaAvroSerializer(client, props);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void configure(Map<String, ?> configs, boolean isKey) {
        Map<String, Object> effectiveConfigs = new HashMap<>(configs);
        effectiveConfigs.put(SPECIFIC_AVRO_READER_CONFIG, true);
        inner.configure(effectiveConfigs, isKey);
    }

    @Override
    public byte[] serialize(String topic, T record) {
        return inner.serialize(topic, record);
    }

    @Override
    public void close() {
        inner.close();
    }
}