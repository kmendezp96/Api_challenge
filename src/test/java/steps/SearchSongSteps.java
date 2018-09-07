package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import helpers.JsonHelper;
import helpers.PropertiesHelper;
import kafka.ProducerSong;
import helpers.ResponseHelper;
import org.junit.Assert;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.awaitility.Awaitility.await;

public class SearchSongSteps {

    @When("^I go to /song/\"([^\"]*)\"$")
    public void iGoToSong(String idSong) {
        new ResponseHelper(PropertiesHelper.getSongUrl() + idSong);
    }

    @Then("^I can see the song with id: \"([^\"]*)\"$")
    public void iCanSearchTheSongWithId(String idSong) {
        System.out.println("Searching song with id: " + idSong);
        new ResponseHelper(PropertiesHelper.getSongUrl() + idSong);
        await().atMost(15, SECONDS)
                .untilAsserted(() -> Assert
                        .assertEquals("The searched song does not match with the saved song",
                                ProducerSong.getSongBean().toString(),
                                JsonHelper.getJsonObjectFromResponse(ResponseHelper
                                        .getResponse()).toString()));
    }

    @And("^the song with \"([^\"]*)\" exists$")
    public void theSongWithExists(String idSong) {
        new ResponseHelper(PropertiesHelper.getSongUrl() + idSong);
        ResponseHelper.getResponse()
                .then().assertThat().statusCode(200);
    }

    @Then("^I wont see the song with that \"([^\"]*)\"$")
    public void iWontSeeTheSongWithThat(String idSong) {
        new ResponseHelper(PropertiesHelper.getSongUrl() + idSong);
        await().atMost(15, SECONDS)
                .untilAsserted(() -> ResponseHelper.getResponse()
                        .then().assertThat().statusCode(404));
    }
}
