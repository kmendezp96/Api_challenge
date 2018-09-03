package steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import kafka.ProducerSong;

public class CreateSongSteps {

    ProducerSong producerSong;

    @Given("^I have access to Kafka Service$")
    public void iHaveAccessToKafkaService() {
        producerSong = new ProducerSong();
    }

    @When("^I create a new song with \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\" and \"([^\"]*)\" the song-feed topic$")
    public void iCreateANewSongWithAndTheSongFeedTopic(long id, String album, String artist, String song, String genre) {
        producerSong.createSong(id,
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
