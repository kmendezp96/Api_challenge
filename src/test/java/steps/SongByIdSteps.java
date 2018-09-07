package steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SongByIdSteps {

    @When("^I go to /song/\"([^\"]*)\"$")
    public void iGoToSong(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^the system response with an \"([^\"]*)\" status code$")
    public void theSystemResponseWithAnStatusCode(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^I see a json with the specified song$")
    public void iSeeAJsonWithTheSpecifiedSong() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }
}
