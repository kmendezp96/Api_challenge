package kafka;

import entities.Song;
import helpers.PropertiesHelper;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.LongSerializer;

import java.util.Collections;
import java.util.List;

public class DeleteSong {

    public DeleteSong(Long id, String album, String artist, String name, String genre) {
        List<Song> songs = Collections.singletonList(new Song(id, album, artist, name, genre));
        SongSerializer<Song> songSerializer = new SongSerializer<>(ConnectionKafka.getSchemaRegistry(), ConnectionKafka.getSerdeProps());
        songSerializer.configure(ConnectionKafka.getSerdeProps(), false);
        KafkaProducer<Long, Song> songProducer = new KafkaProducer<>(ConnectionKafka.getProps(),
                new LongSerializer(),
                songSerializer);
        songs.forEach(newSong -> songProducer.send(new ProducerRecord<>(PropertiesHelper.getTopic(), newSong.getId(), null)));
        songProducer.close();
    }
}
