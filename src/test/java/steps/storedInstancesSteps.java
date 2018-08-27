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

public class storedInstancesSteps {
    private Response response;
    private RequestSpecification request;
    private String viewInstances = "http://localhost:7070/kafka-music/instances/";

    @Given("^I want to see the list of intances$")
    public void iWantToSeeTheListOfIntances(){
        this.request = given().contentType("application/json");
    }

    @When("^I go to /instances$")
    public void iGoToInstances(){
        this.response = request.when().get(this.viewInstances);
    }

    @Then("^I see the list with all the instances$")
    public void iSeeTheListWithAllTheInstances() {
        this.response.then().assertThat().body("size()", not(0));
    }


    @Given("^I want to see the list of intances that an specific provider has$")
    public void iWantToSeeTheListOfIntancesThatAnSpecificProviderHas(){
        this.request = given().contentType("application/json");
    }

    @When("^I go to /instances/ \"([^\"]*)\"$")
    public void iGoToInstances(String storeName){
        this.response = request.when().get(this.viewInstances+storeName);
    }

    @Then("^I see the list of the instances that the provided store has$")
    public void iSeeTheListOfTheInstancesThatTheProvidedStoreHas() {
        this.response.then().assertThat().body("size()", not(0));
    }

    @And("^the system response an \"([^\"]*)\" status code$")
    public void theSystemResponseAnStatusCode(int expectedHttpResponseCode){
        this.response.then().assertThat().statusCode(expectedHttpResponseCode);
    }


    @Then("^The systems returns an empty list of intances$")
    public void theSystemsReturnsAnEmptyListOfIntances(){
        this.response.then().assertThat().body("size()", is(0));
    }
}
