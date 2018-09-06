package steps;

import cucumber.api.java.en.Then;
import helpers.PropertiesHelper;

import static net.serenitybdd.rest.SerenityRest.given;

public class SearchSongSteps {
    @Then("^I can search the song with id: \"([^\"]*)\"$")
    public void iCanSearchTheSongWithId(String idSong){
        System.out.println("Searching song with id: " + idSong);
        String result = given().contentType("application/json")
                .when().get(PropertiesHelper.getSongUrl() + idSong)
                .then().assertThat().statusCode(200)
                .extract().response().body().print();
        System.out.println(result);
    }
}
