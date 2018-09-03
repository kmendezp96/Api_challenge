package steps;

import cucumber.api.PendingException;
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

    @When("^I create a new song in the song-feed topic$")
    public void iCreateANewSongInTheSongFeedTopic() throws Throwable {
        producerSong.createSong(13L,
                "The beatles",
                "The beatles",
                "Happiness is a warn gun",
                "rock");
    }

    @Then("^I can play the song")
    public void iCanPlayTheSong() throws InterruptedException {
    }
}
