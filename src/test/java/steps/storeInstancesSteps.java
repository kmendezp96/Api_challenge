package steps;

import cucumber.api.java.en.Given;
import helpers.JsonHelper;
import helpers.PropertiesHelper;
import io.restassured.response.Response;

import static net.serenitybdd.rest.SerenityRest.given;

public class storeInstancesSteps {
    @Given("^I can see the list of the instances that the provided store has$")
    public void iCanSeeTheListOfTheInstancesThatTheProvidedStoreHas() {
        given().contentType("application/json")
                .when().get(PropertiesHelper.getInstancesUrl())
                .then().assertThat().statusCode(200)
                .extract().response()
                .then().assertThat().equals(JsonHelper.getInstancesJson());
    }
}
