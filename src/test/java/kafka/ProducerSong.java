package kafka;


import entities.Song;
import org.apache.avro.specific.SpecificRecordBase;
import org.apache.kafka.clients.producer.*;
import org.apache.kafka.common.serialization.StringSerializer;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.common.serialization.LongSerializer;

import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.clients.producer.ProducerRecord;


import java.util.*;

public class ProducerSong<L extends Number, S extends SpecificRecordBase> {

    Properties props;
    String BOOTSTRAP_SERVERS;
    String schemaRegistryUrl;
    List<Song> songs;
    String TOPIC;

    private Producer<Long, Song> ProducerSong() {
        this.props = new Properties();
        schemaRegistryUrl = "http://localhost:8081";
        BOOTSTRAP_SERVERS = "localhost:9092";
        TOPIC = "song-feed";
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,
                BOOTSTRAP_SERVERS);
        props.put(ProducerConfig.CLIENT_ID_CONFIG, schemaRegistryUrl);
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,
                LongSerializer.class.getName());
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
                StringSerializer.class.getName());
        return new KafkaProducer<>(props);
    }

    public void createSong(String id, String album, String artist, String song, String genre) {
        songs = Arrays.asList(new Song(Long.parseLong(id), album, artist, song, genre));
        final Producer<Long, Song> producer = ProducerSong();
        try {
            songs.forEach(newSong -> {
                producer.send(new ProducerRecord<Long, Song>(TOPIC, newSong.getId(), newSong));

            });

        } finally {
            producer.flush();
            producer.close();
        }

    }

}
