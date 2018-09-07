package steps;

import cucumber.api.java.en.When;
import kafka.DeleteSong;

public class DeleteSongSteps {

    @When("^I delete a song with \"([^\"]*)\"$")
    public void iDeleteASongWith(String idSong) {
        new DeleteSong(Long.parseLong(idSong),
                "",
                "",
                "",
                "");
    }
}
