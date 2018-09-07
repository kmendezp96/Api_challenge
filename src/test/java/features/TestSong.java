package features;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = {"src/test/resources/features/kafka/createSong.feature",
        "src/test/resources/features/kafka/updateSong.feature",
        "src/test/resources/features/kafka/deleteSong.feature"},
        glue = "steps")
public class TestSong {
}
