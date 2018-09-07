package steps;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import helpers.PropertiesHelper;
import kafka.ConnectionKafka;
import helpers.ResponseHelper;

import java.io.IOException;

public class PrincipalSteps {

    @Before
    public void setUp() throws IOException {
        new PropertiesHelper();
    }

    @Given("^I have access to Kafka Service$")
    public void iHaveAccessToKafkaService() {
        new ConnectionKafka();
    }


    @Then("^the system response with an \"([^\"]*)\" status code$")
    public void theSystemResponseWithAnStatusCode(String statusCode) {
        if (statusCode.equalsIgnoreCase("200")) {
            ResponseHelper.getResponse().then().assertThat().statusCode(Integer.parseInt(statusCode));
        } else {
            ResponseHelper.getResponse().then().assertThat().statusCode(Integer.parseInt(statusCode));
        }
    }
}
