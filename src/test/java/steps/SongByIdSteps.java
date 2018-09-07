package steps;

import com.github.fge.jsonschema.cfg.ValidationConfiguration;
import com.github.fge.jsonschema.main.JsonSchemaFactory;
import cucumber.api.java.en.Then;
import helpers.ResponseHelper;

import static com.github.fge.jsonschema.SchemaVersion.DRAFTV4;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static java.util.concurrent.TimeUnit.SECONDS;
import static org.awaitility.Awaitility.await;

public class SongByIdSteps {

    @Then("^I see a the specified song$")
    public void iSeeATheSpecifiedSong() {
        JsonSchemaFactory jsonSchemaFactory = JsonSchemaFactory.newBuilder()
                .setValidationConfiguration(ValidationConfiguration.newBuilder()
                        .setDefaultVersion(DRAFTV4).freeze()).freeze();
        await().atMost(15, SECONDS)
                .untilAsserted(() -> ResponseHelper.getResponse()
                        .then().assertThat()
                        .body(matchesJsonSchemaInClasspath("jsonSchema/song-schema.json")
                                .using(jsonSchemaFactory)));

    }
}
