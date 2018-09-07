package steps;

import com.github.fge.jsonschema.cfg.ValidationConfiguration;
import com.github.fge.jsonschema.main.JsonSchemaFactory;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import helpers.JsonHelper;
import helpers.PropertiesHelper;
import helpers.ResponseHelper;

import static com.github.fge.jsonschema.SchemaVersion.DRAFTV4;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static java.util.concurrent.TimeUnit.SECONDS;
import static org.awaitility.Awaitility.await;

public class SongsByGenre {

    @When("^I make a request to see the songs of a \"([^\"]*)\"$")
    public void iMakeARequestToSeeTheSongsOfA(String genre) {
        new ResponseHelper(PropertiesHelper.getByGenreUrl() + genre);
    }

    @And("^the system returns all the songs of that genre$")
    public void theSystemReturnsAllTheSongsOfThatGenre() {
        JsonSchemaFactory jsonSchemaFactory = JsonSchemaFactory.newBuilder()
                .setValidationConfiguration(ValidationConfiguration.newBuilder()
                        .setDefaultVersion(DRAFTV4).freeze()).freeze();

        await().atMost(5, SECONDS)
                .untilAsserted(() -> JsonHelper.getJsonObjectListFromResponse(ResponseHelper.getResponse())
                        .forEach(x -> x.getAsJsonObject()
                                .equals(matchesJsonSchemaInClasspath("jsonSchema/song-schema.json")
                                .using(jsonSchemaFactory))));

    }
}
