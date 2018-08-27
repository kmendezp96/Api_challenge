package steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import static net.serenitybdd.rest.SerenityRest.given;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;

public class TopFiveSteps {
    private Response response;
    private RequestSpecification request;
    private String viewTopFive = "http://localhost:7070/kafka-music/charts/top-five";

    @Given("^I want to see the top five songs$")
    public void iWantToSeeTheTopFiveSongs() {
        this.request = given().contentType("application/json");
    }

    @When("^I go to /charts/top-five$")
    public void iGoToChartsTopFive(){
        this.response = request.when().get(this.viewTopFive);
    }

    @Then("^I see the list of five more listen songs$")
    public void iSeeTheListOfFiveMoreListenSongs(){
        this.response.then().assertThat().body("size()", is(5));
    }

    @And("^the system response a \"([^\"]*)\" status code$")
    public void theSystemResponseAStatusCode(int expectedHttpResponseCode) {
        this.response.then().assertThat().statusCode(expectedHttpResponseCode);
    }
}
