package steps;

import cucumber.api.java.en.When;
import kafka.ProducerSong;

public class UpdateSongSteps {
    @When("^I change the attributes album: \"([^\"]*)\", artist: \"([^\"]*)\", name: \"([^\"]*)\" and genre: \"([^\"]*)\" to song with id: \"([^\"]*)\"$")
    public void iChangeTheAttributesAnd(String album, String artist, String song, String genre, String id){
        ProducerSong producerSong = new ProducerSong(Long.parseLong(id),
                album,
                artist,
                song,
                genre);
        producerSong.createSongBean(Long.parseLong(id), album, artist, song, genre);
    }
}
