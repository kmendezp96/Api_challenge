package steps;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import helpers.JsonHelper;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import static net.serenitybdd.rest.SerenityRest.given;
import static net.serenitybdd.rest.SerenityRest.then;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.notNullValue;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;


public class ByGenreSteps {
    private Response response;
    private ValidatableResponse json;
    private RequestSpecification request;
    private String viewSongsByGnere = "http://localhost:7070/kafka-music/charts/genre/";

    ;

    @Given("^I want to see the songs of a genre$")
    public void iWantToSeeTheSongsOfAGenre() {
      this.request = given().contentType("application/json");

    }

    @When("^I make a REST request to see the songs of a \"([^\"]*)\"$")
    public void iMakeARESTRequestToSeeTheSongsOfA(String genre){
        this.response = request.when().get(this.viewSongsByGnere+genre);
    }

    @Then("^the system returns one json with all the songs of that genre$")
    public void theSystemReturnsOneJsonWithAllTheSongsOfThatGenre() {
        //Object response = then().extract().response().getBody().jsonPath().getList("");
        this.response.then().assertThat().body("size()", not(0));
        //assertThat(response, is(notNullValue()));
        //response.body().print();
    }


    @Then("^the system response with \"([^\"]*)\" status code$")
    public void theSystemResponseWithStatusCode(int expectedHttpResponseCode) {
        this.response.then().assertThat().statusCode(expectedHttpResponseCode);
    }

    @When("^I make a REST request to see the songs of an invalid \"([^\"]*)\" genre$")
    public void iMakeARESTRequestToSeeTheSongsOfAnInvalidGenre(String invalidGenre){
        // Write code here that turns the phrase above into concrete actions
        this.response = request.when().get(this.viewSongsByGnere+invalidGenre);
    }


}
