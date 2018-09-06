package kafka;

import entities.Song;

import helpers.PropertiesHelper;
import io.confluent.kafka.schemaregistry.client.CachedSchemaRegistryClient;
import org.apache.avro.specific.SpecificRecordBase;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.LongSerializer;
import org.apache.kafka.common.serialization.Serdes;

import java.util.*;

public class ProducerSong<L extends Number, S extends SpecificRecordBase> {

    public ProducerSong(Long id, String album, String artist, String song, String genre) {
        List<Song> songs = Arrays.asList(new Song(id, album, artist, song, genre));
        SongSerializer<Song> songSerializer = new SongSerializer<>(ConnectionKafka.getSchemaRegistry(), ConnectionKafka.getSerdeProps());
        songSerializer.configure(ConnectionKafka.getSerdeProps(), false);
        KafkaProducer<Long, Song> songProducer = new KafkaProducer<>(ConnectionKafka.getProps(),
                new LongSerializer(),
                songSerializer);
        songs.forEach(newSong -> songProducer.send(new ProducerRecord<>(PropertiesHelper.getTopic(), newSong.getId(), newSong)));
        songProducer.close();
    }

}
