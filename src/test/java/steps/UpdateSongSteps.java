package steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import kafka.ConnectionKafka;
import kafka.ProducerSong;

import java.io.IOException;

import static net.serenitybdd.rest.SerenityRest.given;
import static org.hamcrest.Matchers.containsString;

public class UpdateSongSteps {
    private Response response;
    private RequestSpecification request;
    private String viewSongsById = "http://localhost:7070/kafka-music/song/";

    private ProducerSong producerSong;
    long id;
    String artist;
    String album;
    String name;

    @Given("^I have access to the Kafka Service$")
    public void iHaveAccessToTheKafkaService() throws IOException {
        ConnectionKafka connectionKafka =  new ConnectionKafka();
    }

    @And("^the song with \"([^\"]*)\" exists$")
    public void theSongWithExists(String id){
        request = given().contentType("application/json");
        response = request.when().get(this.viewSongsById+id);
        response.then().assertThat().statusCode(200);
        this.id = Long.parseLong(id);
    }

    @When("^I change the attributes \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\" and \"([^\"]*)\"$")
    public void iChangeTheAttributesAnd(String album, String artist, String song, String genre){
        this.artist = artist;
        this.album = album;
        this.name = song;
        ProducerSong producerSong = new ProducerSong(this.id,
                album,
                artist,
                song,
                genre);
    }

    @Then("^I will see the update song with the same \"([^\"]*)\"$")
    public void iWillSeeTheUpdateSongWithTheSame(String id) {
        try{
            Thread.sleep(1000L);
            response = request.when().get(this.viewSongsById+id);
            response.then().assertThat().body(containsString(artist));
            response.then().assertThat().body(containsString(album));
            response.then().assertThat().body(containsString(name));
        } catch (InterruptedException e){
            System.out.println(e);

        }


    }

}
