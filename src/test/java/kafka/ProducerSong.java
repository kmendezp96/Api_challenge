package kafka;

import entities.Song;

import entities.SongBean;
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

    private static SongBean songBean;

    public ProducerSong(Long id, String album, String artist, String name, String genre) {
        List<Song> songs = Arrays.asList(new Song(id, album, artist, name, genre));
        SongSerializer<Song> songSerializer = new SongSerializer<>(ConnectionKafka.getSchemaRegistry(), ConnectionKafka.getSerdeProps());
        songSerializer.configure(ConnectionKafka.getSerdeProps(), false);
        KafkaProducer<Long, Song> songProducer = new KafkaProducer<>(ConnectionKafka.getProps(),
                new LongSerializer(),
                songSerializer);
        songs.forEach(newSong -> songProducer.send(new ProducerRecord<>(PropertiesHelper.getTopic(), newSong.getId(), newSong)));
        songProducer.close();
    }

    public void createSongBean(long id, String album, String artist, String name, String genre){
        songBean = new SongBean(id, artist, album, name, genre);
    }

    public static SongBean getSongBean() {
        return songBean;
    }
}
