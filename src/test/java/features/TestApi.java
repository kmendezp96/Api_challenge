package features;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = {"src/test/resources/features/songsByGenre.feature",
        "src/test/resources/features/songsById.feature",
        "src/test/resources/features/storedInstances.feature",
        "src/test/resources/features/topFiveSongs.feature"},
        glue = "steps")
public class TestApi {
}
