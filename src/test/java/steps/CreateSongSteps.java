package steps;

import cucumber.api.java.en.When;
import kafka.ProducerSong;

public class CreateSongSteps {

    @When("^I create a new song with id: \"([^\"]*)\", album: \"([^\"]*)\", artist: \"([^\"]*)\", name: \"([^\"]*)\" and genre: \"([^\"]*)\" in the song-feed topic$")
    public void iCreateANewSongWithAndTheSongFeedTopic(long id, String album, String artist, String song, String genre) {
        ProducerSong producerSong = new ProducerSong(id,
                album,
                artist,
                song,
                genre);
        producerSong.createSongBean(id, album, artist, song, genre);
    }
}

