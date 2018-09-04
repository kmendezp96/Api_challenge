package steps;

import com.google.gson.JsonObject;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import helpers.JsonHelper;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import kafka.ConnectionKafka;
import kafka.ProducerSong;

import java.io.IOException;

import static net.serenitybdd.rest.SerenityRest.given;
import static net.serenitybdd.rest.SerenityRest.then;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class DeleteSongSteps {
    private Response response;
    private RequestSpecification request;
    private String viewSongsById = "http://localhost:7070/kafka-music/song/";
    private String name;

    @Given("^I have access to  Kafka Service$")
    public void iHaveAccessToKafkaService() throws IOException {
        ConnectionKafka connectionKafka =  new ConnectionKafka();
    }

    @And("^the song with this \"([^\"]*)\" exists$")
    public void theSongWithThisExists(String id) {
        request = given().contentType("application/json");
        response = request.when().get(this.viewSongsById+id);
        JsonObject body = JsonHelper.getJsonObjectFromResponse(response);
        this.name = body.get("name").getAsString();
        response.then().assertThat().statusCode(200);
    }

    @When("^I delete a song with that \"([^\"]*)\"$")
    public void iDeleteASongWithThat(String id) {
        ProducerSong producerSong = new ProducerSong(Long.parseLong(id),
                "",
                "",
                "",
                "");
    }

    @Then("^I wont see the song$")
    public void iWontSeeTheSong() {

    }


    @Then("^I wont see the song with that \"([^\"]*)\"$")
    public void iWontSeeTheSongWithThat(String id) {
        try{
            Thread.sleep(1000L);
            assertThat("The song shouldn't exists",
                    this.name, not(JsonHelper.getJsonObjectFromResponse(request.when().get(this.viewSongsById+id)).get("name").getAsString()));
        } catch (InterruptedException e){
            System.out.println(e);

        }

    }
}
