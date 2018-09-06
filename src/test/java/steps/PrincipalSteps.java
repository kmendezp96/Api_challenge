package steps;

import cucumber.api.PendingException;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import helpers.PropertiesHelper;
import kafka.ConnectionKafka;

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

}
