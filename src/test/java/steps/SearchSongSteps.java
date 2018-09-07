package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import helpers.JsonHelper;
import helpers.PropertiesHelper;
import kafka.ProducerSong;
import org.junit.Assert;

import static java.util.concurrent.TimeUnit.SECONDS;
import static net.serenitybdd.rest.SerenityRest.given;
import static org.awaitility.Awaitility.await;

public class SearchSongSteps {
    @Then("^I can search the song with id: \"([^\"]*)\"$")
    public void iCanSearchTheSongWithId(String idSong){
        System.out.println("Searching song with id: " + idSong);
        await().atMost(15, SECONDS)
                .untilAsserted(() -> Assert
                        .assertEquals("The searched song does not match with the saved song",
                                ProducerSong.getSongBean().toString(),
                                JsonHelper.getJsonObjectFromResponse(given().contentType("application/json")
                                        .when().get(PropertiesHelper.getSongUrl() + idSong)).toString()));
    }

    @And("^the song with \"([^\"]*)\" exists$")
    public void theSongWithExists(String idSong) {
        System.out.println("Searching song with id: " + idSong);
        given().contentType("application/json")
                .when().get(PropertiesHelper.getSongUrl() + idSong)
                .then().assertThat().statusCode(200);
    }

    @Then("^I wont see the song with that \"([^\"]*)\"$")
    public void iWontSeeTheSongWithThat(String idSong) {
        System.out.println("Searching song with id: " + idSong);

        await().atMost(15, SECONDS)
                .untilAsserted(() -> Assert
                        .assertEquals("The searched song does not match with the saved song",
                                ProducerSong.getSongBean().toString(),
                                JsonHelper.getJsonObjectFromResponse(given().contentType("application/json")
                                        .when().get(PropertiesHelper.getSongUrl() + idSong)).toString()));
    }
}
