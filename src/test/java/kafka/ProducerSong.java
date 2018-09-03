package kafka;

import entities.Song;

import io.confluent.kafka.schemaregistry.client.CachedSchemaRegistryClient;
import org.apache.avro.specific.SpecificRecordBase;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.LongSerializer;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.*;

public class ProducerSong<L extends Number, S extends SpecificRecordBase> {

    Properties props;
    String BOOTSTRAP_SERVERS;
    String schemaRegistryUrl;
    List<Song> songs;
    String TOPIC;
    CachedSchemaRegistryClient schemaRegistry;
    Map<String, String> serdeProps;

    public ProducerSong(){
        this.props = new Properties();
        schemaRegistryUrl = "http://localhost:8081";
        BOOTSTRAP_SERVERS = "localhost:9092";
        TOPIC = "song-feed";
        System.out.println("Connecting to Kafka cluster via bootstrap servers " + BOOTSTRAP_SERVERS);
        System.out.println("Connecting to Confluent schema registry at " + schemaRegistryUrl);
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, BOOTSTRAP_SERVERS);
        props.put(ProducerConfig.CLIENT_ID_CONFIG, schemaRegistryUrl);
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, LongSerializer.class.getName());
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        schemaRegistry = new CachedSchemaRegistryClient(schemaRegistryUrl, 100);
        serdeProps = Collections.singletonMap("schema.registry.url", schemaRegistryUrl);
    }

    public void createSong(Long id, String album, String artist, String song, String genre) {
        songs = Arrays.asList(new Song(id, album, artist, song, genre));
        SongSerializer<Song> songSerializer = new SongSerializer<>(schemaRegistry, serdeProps);
        songSerializer.configure(serdeProps, false);
        KafkaProducer<Long, Song> songProducer = new KafkaProducer<>(props,
                new LongSerializer(),
                songSerializer);

        songs.forEach(newSong -> {
            songProducer.send(new ProducerRecord<>(TOPIC, newSong.getId(), newSong));
        });

        songProducer.close();

    }

}
