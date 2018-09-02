package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import kafka.ProducerSong;

public class CreateSongSteps {

    ProducerSong producerSong;

    @Given("^I have access to Kafka Service$")
    public void iHaveAccessToKafkaService() throws Throwable {

    }

    @When("^I create a new song : \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\" in the song-feed topic$")
    public void iCreateANewSongInTheSongFeedTopic(String arg0, String arg1, String arg2, String arg3, String arg4) throws Throwable {
        producerSong.createSong(arg0, arg1, arg2, arg3, arg4);
    }

    @Then("^I can play the song: \"([^\"]*)\"$")
    public void iCanPlayTheSong(String arg0) throws Throwable {

    }
}
