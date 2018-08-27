package steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import helpers.JsonHelper;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import static net.serenitybdd.rest.SerenityRest.given;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.not;

public class ByIdSteps {
    private Response response;
    private RequestSpecification request;
    private String viewSongsById = "http://localhost:7070/kafka-music/song/";

    @Given("^I want to see a song with an specific id$")
    public void iWantToSeeASongWithAnSpecificId(){
        request = given().contentType("application/json");
    }

    @When("^I go to /song/\"([^\"]*)\"$")
    public void iGoToSong(String id){
        response = request.when().get(this.viewSongsById+id);
    }

    @And("^I see a json with the specified song$")
    public void iSeeAJsonWithTheSpecifiedSong(){
        response.then().assertThat().body(containsString("name"));
    }

    @When("^I go to /song/\"([^\"]*)\" with an invalid id$")
    public void iGoToSongWithAnInvalidId(String invalidId) {
        // Write code here that turns the phrase above into concrete actions
        response = request.when().get(this.viewSongsById+invalidId);

    }


    @Then("^the system response  a with \"([^\"]*)\" status code$")
    public void theSystemResponseAWithStatusCode(int expectedHttpResponseCode) {
        response.then().assertThat().statusCode(expectedHttpResponseCode);

    }
}
