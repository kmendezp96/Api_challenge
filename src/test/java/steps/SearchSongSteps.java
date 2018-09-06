package steps;

import com.google.gson.JsonObject;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import helpers.JsonHelper;
import helpers.PropertiesHelper;
import kafka.ProducerSong;
import org.junit.Assert;

import io.restassured.response.Response;

import static java.util.concurrent.TimeUnit.SECONDS;
import static net.serenitybdd.rest.SerenityRest.given;
import static org.awaitility.Awaitility.await;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;

public class SearchSongSteps {
    @Then("^I can search the song with id: \"([^\"]*)\"$")
    public void iCanSearchTheSongWithId(String idSong){
        System.out.println("Searching song with id: " + idSong);
        String result = given().contentType("application/json")
                .when().get(PropertiesHelper.getSongUrl() + idSong)
                .then().assertThat().statusCode(200)
                .extract().response().body().print();

        await().atMost(15, SECONDS)
                .untilAsserted(() -> Assert
                        .assertEquals("The searched song does not match with the saved song",
                                ProducerSong.getSongBean().toString(),
                                result));
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
        String result = given().contentType("application/json")
                .when().get(PropertiesHelper.getSongUrl() + idSong)
                .then().assertThat().statusCode(200)
                .extract().response().body().print();

        await().atMost(15, SECONDS)
                .untilAsserted(() -> Assert
                        .assertEquals("The searched song does not match with the saved song",
                                ProducerSong.getSongBean().toString(),
                                result));
    }
}
