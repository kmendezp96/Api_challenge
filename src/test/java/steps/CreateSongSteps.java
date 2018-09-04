package steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import kafka.ConnectionKafka;
import kafka.ProducerSong;

import java.io.IOException;

public class CreateSongSteps {

    @Given("^I have access to Kafka Service$")
    public void iHaveAccessToKafkaService() throws IOException {
        ConnectionKafka connectionKafka =  new ConnectionKafka();
    }

    @When("^I create a new song with \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\" and \"([^\"]*)\" the song-feed topic$")
    public void iCreateANewSongWithAndTheSongFeedTopic(long id, String album, String artist, String song, String genre) {
        ProducerSong producerSong = new ProducerSong(id,
                album,
                artist,
                song,
                genre);
    }

    @Then("^I can play the song")
    public void iCanPlayTheSong() throws Throwable {
        //producerSong.playSong();
    }



}
