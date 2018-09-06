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

    @When("^I delete a song with \"([^\"]*)\"$")
    public void iDeleteASongWith(String idSong) {
        ProducerSong producerSong = new ProducerSong(Long.parseLong(idSong),
                "",
                "",
                "",
                "");
        producerSong.createSongBean(Long.parseLong(idSong), "", "", "", "");
    }
}
